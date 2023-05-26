package com.sinch.android.rtc.internal.client;

import android.content.Context;
import com.sinch.android.rtc.internal.CallbackHandler;
import com.sinch.android.rtc.internal.natives.jni.NativeServiceProviderImpl;
import com.sinch.android.rtc.internal.natives.jni.UserAgent;
import com.sinch.android.rtc.internal.natives.jni.UserAgentFactory;
import com.sinch.android.rtc.internal.service.dispatcher.DefaultDispatcher;
import com.sinch.android.rtc.internal.service.http.DefaultHttpService;
import com.sinch.android.rtc.internal.service.http.HttpClientInterface;
import com.sinch.android.rtc.internal.service.pubnub.PubNubSubscriberFactory;
import com.sinch.android.rtc.internal.service.pubnub.PublishSubscribeClient;
import com.sinch.android.rtc.internal.service.state.AndroidAppStateService;
import com.sinch.android.rtc.internal.service.state.AppStateService;
import com.sinch.android.rtc.internal.service.time.SystemClockTimeService;
import com.sinch.android.rtc.internal.service.time.TimeService;
import com.sinch.httpclient.HttpClient;
import com.sinch.httpclient.Request;
import com.sinch.httpclient.RequestOptions;
import com.sinch.httpclient.ResponseHandler;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class ServiceFactory {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public CallbackHandler mCallbackHandler;
    public HttpClientInterface mHttpClient;
    public TimeService mTimeService;

    public ServiceFactory(CallbackHandler callbackHandler) {
        if (callbackHandler == null) {
            throw new IllegalArgumentException("CallbackHandler must not be null");
        }
        this.mCallbackHandler = callbackHandler;
        this.mTimeService = new SystemClockTimeService();
    }

    public ServiceFactory(CallbackHandler callbackHandler, TimeService timeService, HttpClientInterface httpClientInterface) {
        if (callbackHandler == null) {
            throw new IllegalArgumentException("CallbackHandler must not be null");
        }
        if (timeService == null) {
            throw new IllegalArgumentException("TimeService must not be null");
        }
        if (httpClientInterface == null) {
            throw new IllegalArgumentException("HttpClientInterface must not be null");
        }
        this.mCallbackHandler = callbackHandler;
        this.mTimeService = timeService;
        this.mHttpClient = httpClientInterface;
    }

    private CallbackHandler getCurrentCallbackHandler() {
        return this.mCallbackHandler;
    }

    public AppStateService createAndroidAppStateService(Context context) {
        return new AndroidAppStateService(context);
    }

    public DefaultDispatcher createDefaultDispatcher() {
        return new DefaultDispatcher(getCurrentCallbackHandler());
    }

    public DefaultHttpService createDefaultHttpService(HttpClientInterface httpClientInterface) {
        return new DefaultHttpService(httpClientInterface);
    }

    public HttpClientInterface createHttpClient() {
        if (this.mHttpClient == null) {
            this.mHttpClient = new HttpClientInterface() { // from class: com.sinch.android.rtc.internal.client.ServiceFactory.1
                private HttpClient httpClient = new HttpClient();

                @Override // com.sinch.android.rtc.internal.service.http.HttpClientInterface
                public void cancelAllRequests() {
                    this.httpClient.cancelAllRequests();
                }

                @Override // com.sinch.android.rtc.internal.service.http.HttpClientInterface
                public void cancelRequest(String str) {
                    this.httpClient.cancelRequest(str);
                }

                @Override // com.sinch.android.rtc.internal.service.http.HttpClientInterface
                public void sendRequest(Request request, ResponseHandler responseHandler, RequestOptions requestOptions) {
                    this.httpClient.sendRequest(request, responseHandler, requestOptions);
                }
            };
        }
        return this.mHttpClient;
    }

    public PublishSubscribeClient createPublishSubscribeClient(WorkerThread workerThread, HttpClientInterface httpClientInterface) {
        return new PublishSubscribeClient(new PubNubSubscriberFactory(), workerThread, Executors.newSingleThreadExecutor(), httpClientInterface);
    }

    public UserAgent createUserAgent(NativeServiceProviderImpl nativeServiceProviderImpl, String str, String str2, String str3, boolean z7, String str4, DeviceInformation deviceInformation) {
        TimeService timeService = this.mTimeService;
        String str5 = deviceInformation.deviceId;
        String str6 = DeviceInformation.modelName;
        String str7 = DeviceInformation.modelId;
        String str8 = DeviceInformation.os;
        String str9 = DeviceInformation.osApiVersion;
        return timeService != null ? UserAgentFactory.createUserAgentWithTimeService(timeService, nativeServiceProviderImpl, "5.10.7", str, str2, str5, str3, z7, str4, str6, str7, str8, DeviceInformation.osName, str9) : UserAgentFactory.createUserAgent(nativeServiceProviderImpl, "5.10.7", str, str2, str5, str3, z7, str4, str6, str7, str8, DeviceInformation.osName, str9);
    }

    public WorkerThread createWorkerThread() {
        return WorkerThread.createWorkerThread();
    }
}
