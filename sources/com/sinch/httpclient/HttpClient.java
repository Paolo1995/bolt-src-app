package com.sinch.httpclient;

import android.util.Log;
import com.sinch.httpclient.ConnectivityMonitor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class HttpClient implements ConnectivityMonitor.Listener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int PRIORITY_CMP_GT = 2;
    private static final int PRIORITY_CMP_LT = 1;
    private static final String TAG = "HttpClient";
    private static final Comparator<RequestEntry> sPriorityComparator = new Comparator<RequestEntry>() { // from class: com.sinch.httpclient.HttpClient.1
        @Override // java.util.Comparator
        public int compare(RequestEntry requestEntry, RequestEntry requestEntry2) {
            int i8 = requestEntry.options.priority;
            int i9 = requestEntry2.options.priority;
            if (i8 > i9) {
                return 1;
            }
            return i8 < i9 ? -1 : 0;
        }
    };
    private final ConnectivityMonitor mConnectivityMonitor;
    private final AtomicInteger mEntryIdCounter;
    private final Set<RequestEntry> mFailedRequests;
    private final AtomicBoolean mRegisteredConnectivityListener;
    private final PriorityQueue<RequestEntry> mRequestQueue;
    private final Map<Integer, RequestEntry> mRequestsInProgress;
    private final Scheduler mScheduler;
    private final System mSystem;

    public HttpClient() {
        this(new System().createScheduler(), new System(), null);
    }

    public HttpClient(ConnectivityMonitor connectivityMonitor) {
        this(new System().createScheduler(), new System(), connectivityMonitor);
    }

    public HttpClient(Scheduler scheduler, System system, ConnectivityMonitor connectivityMonitor) {
        this.mScheduler = scheduler;
        this.mSystem = system;
        this.mRequestQueue = new PriorityQueue<>(10, sPriorityComparator);
        this.mRequestsInProgress = new HashMap();
        this.mFailedRequests = new HashSet();
        this.mEntryIdCounter = new AtomicInteger(0);
        this.mConnectivityMonitor = connectivityMonitor;
        this.mRegisteredConnectivityListener = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _cancelAllRequests() {
        for (Map.Entry<Integer, RequestEntry> entry : this.mRequestsInProgress.entrySet()) {
            cancelRequest(entry.getValue().id, "Cancelling all requests");
        }
        this.mRequestQueue.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _cancelRequest(String str, String str2) {
        for (Map.Entry<Integer, RequestEntry> entry : this.mRequestsInProgress.entrySet()) {
            if (entry.getValue().request.id.equals(str)) {
                cancelRequest(entry.getValue().id, str2);
                return;
            }
        }
    }

    private long _currentTimeMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.mSystem.nanoTime());
    }

    private void _onCompleted(RequestEntry requestEntry) {
        unregisterConnectivityListenerApplicable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _onError(final RequestEntry requestEntry, Exception exc) {
        RetryPolicy retryPolicy = requestEntry.retryPolicy;
        if (retryPolicy != null) {
            retryPolicy.handleError(exc);
        }
        removeFromInProgress(requestEntry.id);
        requestEntry.logger.d(TAG, "Request " + requestEntry.loggingIdentifier() + " completed with exception: " + exc);
        RetryPolicy retryPolicy2 = requestEntry.retryPolicy;
        if (retryPolicy2 == null || !retryPolicy2.shouldRetry()) {
            requestEntry.invokeError(exc);
            _onCompleted(requestEntry);
        } else {
            long backOffMillis = requestEntry.retryPolicy.getBackOffMillis();
            requestEntry.retryAt = _currentTimeMillis() + backOffMillis;
            requestEntry.setTask(null);
            addFailedRequest(requestEntry);
            requestEntry.logger.d(TAG, "Scheduling request " + requestEntry.loggingIdentifier() + " for retry (delay=" + String.valueOf(backOffMillis) + ")");
            this.mScheduler.postDelayed(new Runnable() { // from class: com.sinch.httpclient.HttpClient.7
                @Override // java.lang.Runnable
                public void run() {
                    HttpClient.this.retryFailedRequestsIfApplicable(requestEntry);
                }
            }, backOffMillis);
        }
        dispatchRequestsIfApplicable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _onSuccess(RequestEntry requestEntry, Response response) {
        Logger logger = requestEntry.logger;
        logger.d(TAG, "Request " + requestEntry.loggingIdentifier() + " completed with HTTP status " + String.valueOf(response.status));
        removeFromInProgress(requestEntry.id);
        requestEntry.invokeSuccess(response);
        _onCompleted(requestEntry);
        dispatchRequestsIfApplicable();
    }

    private void _retryFailedRequest(RequestEntry requestEntry) {
        Logger logger = requestEntry.logger;
        logger.d(TAG, "Retrying request " + requestEntry.loggingIdentifier());
        removeFailedRequest(requestEntry);
        dispatchRequest(requestEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _retryFailedRequestsIfApplicable() {
        HashSet<RequestEntry> hashSet = new HashSet();
        hashSet.addAll(this.mFailedRequests);
        if (hashSet.isEmpty()) {
            return;
        }
        for (RequestEntry requestEntry : hashSet) {
            if (isReadyForRetry(requestEntry)) {
                _retryFailedRequest(requestEntry);
            } else {
                Logger logger = requestEntry.logger;
                logger.d(TAG, "Request " + requestEntry.loggingIdentifier() + " not applicable for retry yet (retryAt=" + requestEntry.retryAt + ")");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _sendRequest(Request request, ResponseHandler responseHandler, RequestOptions requestOptions) {
        for (RequestEntry requestEntry : requestsWithLowerPriorityThan(requestOptions.priority)) {
            cancelRequest(requestEntry.id, "Higher priority request is taking precedence");
        }
        RequestEntry requestEntry2 = new RequestEntry(nextEntryId(), request, responseHandler, requestOptions);
        Logger logger = requestEntry2.logger;
        logger.d(TAG, "Adding request entry " + requestEntry2.loggingIdentifier() + " to queue (" + requestEntry2 + ")");
        this.mRequestQueue.add(requestEntry2);
        dispatchRequestsIfApplicable();
    }

    private void addFailedRequest(RequestEntry requestEntry) {
        Logger logger = requestEntry.logger;
        logger.d(TAG, "Adding request " + requestEntry.loggingIdentifier() + " to failed");
        this.mFailedRequests.add(requestEntry);
    }

    private void addProgressing(RequestEntry requestEntry) {
        Logger logger = requestEntry.logger;
        logger.d(TAG, "Adding request " + requestEntry.loggingIdentifier() + " to progressing");
        this.mRequestsInProgress.put(Integer.valueOf(requestEntry.id), requestEntry);
    }

    private void cancelRequest(int i8, String str) {
        RequestEntry requestEntry = this.mRequestsInProgress.get(Integer.valueOf(i8));
        if (requestEntry != null) {
            logCancellingRequest(requestEntry, str);
            HttpRequestTask task = requestEntry.task();
            if (task != null) {
                task.cancel(str);
                return;
            }
            return;
        }
        Log.d(TAG, "Requested to cancel request with id " + i8 + " but no such request found (may have been completed or cancelled already)");
    }

    private List<RequestEntry> copyOfRequestsInProgress() {
        ArrayList arrayList = new ArrayList(this.mRequestsInProgress.size());
        for (Map.Entry<Integer, RequestEntry> entry : this.mRequestsInProgress.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    private void dispatchRequest(final RequestEntry requestEntry) {
        Logger logger = requestEntry.logger;
        logger.d(TAG, "Dispatching request " + requestEntry.loggingIdentifier());
        ResponseHandler responseHandler = new ResponseHandler() { // from class: com.sinch.httpclient.HttpClient.6
            @Override // com.sinch.httpclient.ResponseHandler
            public void onError(final Exception exc) {
                HttpClient.this.mScheduler.post(new Runnable() { // from class: com.sinch.httpclient.HttpClient.6.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        HttpClient.this._onError(requestEntry, exc);
                    }
                });
            }

            @Override // com.sinch.httpclient.ResponseHandler
            public void onSuccess(final Response response) {
                HttpClient.this.mScheduler.post(new Runnable() { // from class: com.sinch.httpclient.HttpClient.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        HttpClient.this._onSuccess(requestEntry, response);
                    }
                });
            }
        };
        registerConnectivityListenerIfNecessary();
        AsyncTaskRequest asyncTaskRequest = new AsyncTaskRequest(requestEntry.request, responseHandler, this.mSystem.createScheduler(), this.mSystem, requestEntry.options);
        requestEntry.setTask(asyncTaskRequest);
        addProgressing(requestEntry);
        asyncTaskRequest.start();
    }

    private void dispatchRequestsIfApplicable() {
        while (true) {
            RequestEntry poll = this.mRequestQueue.poll();
            if (poll == null) {
                return;
            }
            if (!requestsWithHigherPriorityThan(poll.options.priority).isEmpty()) {
                this.mRequestQueue.add(poll);
                return;
            }
            dispatchRequest(poll);
        }
    }

    private boolean isReadyForRetry(RequestEntry requestEntry) {
        return _currentTimeMillis() >= requestEntry.retryAt;
    }

    private void logCancellingRequest(RequestEntry requestEntry, String str) {
        if (str == null) {
            Logger logger = requestEntry.logger;
            logger.d(TAG, "Cancelling request " + requestEntry.loggingIdentifier());
            return;
        }
        Logger logger2 = requestEntry.logger;
        logger2.d(TAG, "Cancelling request " + requestEntry.loggingIdentifier() + " (reason: " + str + ")");
    }

    private int nextEntryId() {
        return this.mEntryIdCounter.incrementAndGet();
    }

    private void registerConnectivityListenerIfNecessary() {
        if (this.mConnectivityMonitor != null && this.mRegisteredConnectivityListener.compareAndSet(false, true)) {
            this.mConnectivityMonitor.registerListener(this);
        }
    }

    private void removeFailedRequest(RequestEntry requestEntry) {
        Logger logger = requestEntry.logger;
        logger.d(TAG, "Removing request " + requestEntry.loggingIdentifier() + " from failed");
        this.mFailedRequests.remove(requestEntry);
    }

    private RequestEntry removeFromInProgress(int i8) {
        return this.mRequestsInProgress.remove(Integer.valueOf(i8));
    }

    private static List<RequestEntry> requestsWithFilteredWithComparator(List<RequestEntry> list, int i8, int i9) {
        ArrayList arrayList = new ArrayList(list.size());
        for (RequestEntry requestEntry : list) {
            if ((2 == i9 && requestEntry.options.priority > i8) || (1 == i9 && requestEntry.options.priority < i8)) {
                arrayList.add(requestEntry);
            }
        }
        return arrayList;
    }

    private List<RequestEntry> requestsWithHigherPriorityThan(int i8) {
        return requestsWithFilteredWithComparator(copyOfRequestsInProgress(), i8, 2);
    }

    private List<RequestEntry> requestsWithLowerPriorityThan(int i8) {
        return requestsWithFilteredWithComparator(copyOfRequestsInProgress(), i8, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryFailedRequestsIfApplicable(RequestEntry requestEntry) {
        if (this.mFailedRequests.contains(requestEntry) && isReadyForRetry(requestEntry)) {
            _retryFailedRequest(requestEntry);
        }
    }

    private void unregisterConnectivityListenerApplicable() {
        if (this.mConnectivityMonitor == null) {
            return;
        }
        if ((this.mRequestsInProgress.size() == 0 && this.mFailedRequests.size() == 0) && this.mRegisteredConnectivityListener.compareAndSet(true, false)) {
            this.mConnectivityMonitor.unregisterListener(this);
        }
    }

    public void cancelAllRequests() {
        this.mScheduler.post(new Runnable() { // from class: com.sinch.httpclient.HttpClient.5
            @Override // java.lang.Runnable
            public void run() {
                HttpClient.this._cancelAllRequests();
            }
        });
    }

    public void cancelRequest(final String str) {
        this.mScheduler.post(new Runnable() { // from class: com.sinch.httpclient.HttpClient.4
            @Override // java.lang.Runnable
            public void run() {
                HttpClient.this._cancelRequest(str, null);
            }
        });
    }

    @Override // com.sinch.httpclient.ConnectivityMonitor.Listener
    public void onReconnected() {
        retryFailedRequestsIfApplicable();
    }

    public void retryFailedRequestsIfApplicable() {
        this.mScheduler.post(new Runnable() { // from class: com.sinch.httpclient.HttpClient.8
            @Override // java.lang.Runnable
            public void run() {
                HttpClient.this._retryFailedRequestsIfApplicable();
            }
        });
    }

    public void sendRequest(final Request request, final ResponseHandler responseHandler, final RequestOptions requestOptions) {
        Logger logger = requestOptions.logger;
        logger.d(TAG, "Scheduling request: " + request);
        this.mScheduler.post(new Runnable() { // from class: com.sinch.httpclient.HttpClient.2
            @Override // java.lang.Runnable
            public void run() {
                HttpClient.this._sendRequest(request, responseHandler, requestOptions);
            }
        });
        if (requestOptions.requestTimeout > 0) {
            Logger logger2 = requestOptions.logger;
            logger2.d(TAG, "Scheduling request timeout cancellation " + request.id + " (in " + requestOptions.requestTimeout + "ms)");
            this.mScheduler.postDelayed(new Runnable() { // from class: com.sinch.httpclient.HttpClient.3
                @Override // java.lang.Runnable
                public void run() {
                    HttpClient httpClient = HttpClient.this;
                    String str = request.id;
                    httpClient._cancelRequest(str, "Request timeout (" + requestOptions.requestTimeout + "ms)");
                }
            }, (long) requestOptions.requestTimeout);
        }
    }
}
