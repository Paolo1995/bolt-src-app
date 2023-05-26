package com.sinch.httpclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
final class AsyncTaskRequest implements HttpRequestTask {
    private final Scheduler mMainThreadScheduler;
    private final RequestOptions mOptions;
    private final Request mRequest;
    private final ResponseHandler mResponseHandler;
    private final System mSystem;
    private AsyncTaskInterface mTask;
    private final AtomicBoolean mCancelled = new AtomicBoolean(false);
    private final AtomicBoolean mStarted = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public static class TaskImpl implements AsyncTaskDelegate<Object> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int CONNECT_TIMEOUT = 20000;
        private static final int READ_TIMEOUT = 20000;
        private final ResponseHandler mHandler;
        private final RequestOptions mOptions;
        private final Request mRequest;
        private final System mSystem;

        public TaskImpl(Request request, System system, ResponseHandler responseHandler, RequestOptions requestOptions) {
            this.mRequest = request;
            this.mSystem = system;
            this.mHandler = responseHandler;
            this.mOptions = requestOptions;
        }

        public static void disconnectQuietly(HttpURLConnection httpURLConnection) {
            if (httpURLConnection == null) {
                return;
            }
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
        }

        @Override // com.sinch.httpclient.AsyncTaskDelegate
        public Object doInBackground(AsyncTaskState asyncTaskState) {
            if (asyncTaskState.isCancelled()) {
                return new CancellationException("Cancelled before starting background execution");
            }
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    RequestOptions requestOptions = this.mOptions;
                    int i8 = requestOptions.connectionTimeout;
                    int i9 = 20000;
                    if (i8 <= 0) {
                        i8 = 20000;
                    }
                    int i10 = requestOptions.readTimeout;
                    if (i10 > 0) {
                        i9 = i10;
                    }
                    httpURLConnection = this.mSystem.createHttpConnection(this.mRequest.url);
                    httpURLConnection.setConnectTimeout(i8);
                    httpURLConnection.setReadTimeout(i9);
                    Response run = new HttpRequestProcessor(this.mRequest, httpURLConnection).run();
                    disconnectQuietly(httpURLConnection);
                    return run;
                } catch (IOException e8) {
                    if (!asyncTaskState.isCancelled()) {
                        if (httpURLConnection != null) {
                            disconnectQuietly(httpURLConnection);
                        }
                        return e8;
                    }
                    CancellationException cancellationException = new CancellationException(e8.getMessage());
                    if (httpURLConnection != null) {
                        disconnectQuietly(httpURLConnection);
                    }
                    return cancellationException;
                } catch (Exception e9) {
                    if (httpURLConnection != null) {
                        disconnectQuietly(httpURLConnection);
                    }
                    return e9;
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    disconnectQuietly(httpURLConnection);
                }
                throw th;
            }
        }

        @Override // com.sinch.httpclient.AsyncTaskDelegate
        public void onCancelled(Object obj, String str) {
            this.mHandler.onError((str == null || str.length() <= 0) ? (obj == null || !(obj instanceof Exception)) ? new CancellationException() : (Exception) obj : new CancellationException(str));
        }

        @Override // com.sinch.httpclient.AsyncTaskDelegate
        public void onPostExecute(Object obj) {
            if (obj instanceof Response) {
                this.mHandler.onSuccess((Response) obj);
            } else {
                this.mHandler.onError((Exception) obj);
            }
        }

        @Override // com.sinch.httpclient.AsyncTaskDelegate
        public void onPreExecute() {
        }
    }

    public AsyncTaskRequest(Request request, ResponseHandler responseHandler, Scheduler scheduler, System system, RequestOptions requestOptions) {
        this.mRequest = request;
        this.mSystem = system;
        this.mResponseHandler = responseHandler;
        this.mMainThreadScheduler = scheduler;
        this.mOptions = requestOptions;
    }

    private boolean isCancelled() {
        return this.mCancelled.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start_main() {
        ResponseHandler responseHandler;
        Exception illegalStateException;
        if (isCancelled()) {
            responseHandler = this.mResponseHandler;
            illegalStateException = new CancellationException("Cancelled before starting background execution");
        } else if (this.mStarted.compareAndSet(false, true)) {
            AsyncTaskInterface createAsyncTask = this.mSystem.createAsyncTask(new TaskImpl(this.mRequest, this.mSystem, this.mResponseHandler, this.mOptions));
            synchronized (this) {
                this.mTask = createAsyncTask;
            }
            createAsyncTask.execute();
            return;
        } else {
            responseHandler = this.mResponseHandler;
            illegalStateException = new IllegalStateException("Already started");
        }
        responseHandler.onError(illegalStateException);
    }

    @Override // com.sinch.httpclient.HttpRequestTask
    public void cancel(String str) {
        AsyncTaskInterface asyncTaskInterface;
        if (this.mCancelled.compareAndSet(false, true)) {
            synchronized (this) {
                asyncTaskInterface = this.mTask;
            }
            if (asyncTaskInterface != null) {
                asyncTaskInterface.cancel(true, str);
            }
        }
    }

    @Override // com.sinch.httpclient.HttpRequestTask
    public void start() {
        this.mMainThreadScheduler.post(new Runnable() { // from class: com.sinch.httpclient.AsyncTaskRequest.1
            @Override // java.lang.Runnable
            public void run() {
                AsyncTaskRequest.this.start_main();
            }
        });
    }
}
