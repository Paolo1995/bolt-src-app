package com.sinch.android.rtc.internal.service.pubnub;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.sinch.android.rtc.internal.InternalErrorCodes;
import com.sinch.android.rtc.internal.natives.PubSubHistoryConsumer;
import com.sinch.android.rtc.internal.service.http.HttpClientDefaults;
import com.sinch.android.rtc.internal.service.http.HttpClientInterface;
import com.sinch.android.rtc.internal.service.pubnub.PubNubHistoryReader;
import com.sinch.httpclient.FixedBackoffRetryPolicy;
import com.sinch.httpclient.Request;
import com.sinch.httpclient.RequestOptions;
import com.sinch.httpclient.Response;
import com.sinch.httpclient.ResponseHandler;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class PubNubHistoryReader {
    private static final int HTTP_CONNECTION_TIMEOUT = 5000;
    private static final int HTTP_READ_TIMEOUT = 10000;
    private static final int HTTP_REQUEST_TIMEOUT = 60000;
    private static final long MILLISECONDS_TO_TEN_THOUSAND_MILLISECONDS = 10000;
    private static final int[] RETRY_INTERVALS = {200, 1000, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, InternalErrorCodes.ApiCallFailed, 6000};
    private final String baseRequest;
    private final String baseRequestSuffix;
    private final PubSubHistoryConsumer callback;
    private final Executor callbackExecutor;
    private final HttpClientInterface httpClient;
    private final int timeOffsetOnSubscribeInMs;

    /* loaded from: classes3.dex */
    public abstract class DefaultResponseHandler implements ResponseHandler {
        private final PubSubHistoryConsumer callback;
        private final Executor callbackExecutor;

        public DefaultResponseHandler(Executor executor, PubSubHistoryConsumer pubSubHistoryConsumer) {
            this.callbackExecutor = executor;
            this.callback = pubSubHistoryConsumer;
        }

        @Override // com.sinch.httpclient.ResponseHandler
        public void onError(Exception exc) {
            PubNubHistoryReader.onError(this.callbackExecutor, this.callback);
        }

        @Override // com.sinch.httpclient.ResponseHandler
        public void onSuccess(Response response) {
            PubNubResponse parse = PubNubResponse.parse(PubNubHistoryReader.this.convertResponseToString(response));
            if (parse.isValid()) {
                onSuccessAction(parse);
            } else {
                onError(null);
            }
        }

        public abstract void onSuccessAction(PubNubResponse pubNubResponse);
    }

    public PubNubHistoryReader(String str, int i8, PubSubHistoryConsumer pubSubHistoryConsumer, Executor executor, HttpClientInterface httpClientInterface) {
        String str2;
        this.baseRequest = str + "/subscribe/" + pubSubHistoryConsumer.getSubscribeKey() + "/" + pubSubHistoryConsumer.getChannel() + "/0/";
        String clientId = pubSubHistoryConsumer.getClientId();
        if (clientId == null || clientId.isEmpty()) {
            str2 = "";
        } else {
            str2 = "?uuid=" + clientId;
        }
        this.baseRequestSuffix = str2;
        this.timeOffsetOnSubscribeInMs = i8;
        this.callback = pubSubHistoryConsumer;
        this.callbackExecutor = executor;
        this.httpClient = httpClientInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String convertResponseToString(Response response) {
        byte[] bArr = response.body;
        if (bArr.length != 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onError(Executor executor, final PubSubHistoryConsumer pubSubHistoryConsumer) {
        executor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.service.pubnub.PubNubHistoryReader.1
            @Override // java.lang.Runnable
            public void run() {
                PubSubHistoryConsumer.this.failedHistoryGet();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendGetRequest(HttpClientInterface httpClientInterface, String str, ResponseHandler responseHandler) throws MalformedURLException {
        httpClientInterface.sendRequest(new Request(UUID.randomUUID().toString(), new URL(str), "GET", HttpClientDefaults.getDefaultEmptyHeaders(), HttpClientDefaults.getDefaultEmptyBody()), responseHandler, new RequestOptions(1, new FixedBackoffRetryPolicy(RETRY_INTERVALS, TimeUnit.MILLISECONDS), HttpClientDefaults.getDefaultLogger(), 5000, HTTP_READ_TIMEOUT, HTTP_REQUEST_TIMEOUT));
    }

    public void startHistoryReader() {
        DefaultResponseHandler defaultResponseHandler = new DefaultResponseHandler(this.callbackExecutor, this.callback) { // from class: com.sinch.android.rtc.internal.service.pubnub.PubNubHistoryReader.2

            /* renamed from: com.sinch.android.rtc.internal.service.pubnub.PubNubHistoryReader$2$1  reason: invalid class name */
            /* loaded from: classes3.dex */
            public class AnonymousClass1 extends DefaultResponseHandler {
                public AnonymousClass1(Executor executor, PubSubHistoryConsumer pubSubHistoryConsumer) {
                    super(executor, pubSubHistoryConsumer);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onSuccessAction$0(PubNubResponse pubNubResponse) {
                    PubNubHistoryReader.this.callback.endHistoryGetWithoutTimestamps(pubNubResponse.getMessagesAsArray());
                }

                @Override // com.sinch.android.rtc.internal.service.pubnub.PubNubHistoryReader.DefaultResponseHandler
                public void onSuccessAction(final PubNubResponse pubNubResponse) {
                    PubNubHistoryReader.this.callbackExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.service.pubnub.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            PubNubHistoryReader.AnonymousClass2.AnonymousClass1.this.lambda$onSuccessAction$0(pubNubResponse);
                        }
                    });
                }
            }

            @Override // com.sinch.android.rtc.internal.service.pubnub.PubNubHistoryReader.DefaultResponseHandler
            public void onSuccessAction(PubNubResponse pubNubResponse) {
                long longValue = pubNubResponse.getTimeToken().longValue() + (PubNubHistoryReader.this.timeOffsetOnSubscribeInMs * PubNubHistoryReader.MILLISECONDS_TO_TEN_THOUSAND_MILLISECONDS);
                try {
                    HttpClientInterface httpClientInterface = PubNubHistoryReader.this.httpClient;
                    PubNubHistoryReader.sendGetRequest(httpClientInterface, PubNubHistoryReader.this.baseRequest + longValue + PubNubHistoryReader.this.baseRequestSuffix, new AnonymousClass1(PubNubHistoryReader.this.callbackExecutor, PubNubHistoryReader.this.callback));
                } catch (MalformedURLException unused) {
                    onError(null);
                }
            }
        };
        try {
            HttpClientInterface httpClientInterface = this.httpClient;
            sendGetRequest(httpClientInterface, this.baseRequest + "0" + this.baseRequestSuffix, defaultResponseHandler);
        } catch (MalformedURLException unused) {
            onError(this.callbackExecutor, this.callback);
        }
    }
}
