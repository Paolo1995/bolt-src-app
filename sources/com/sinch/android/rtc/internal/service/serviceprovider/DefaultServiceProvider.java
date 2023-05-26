package com.sinch.android.rtc.internal.service.serviceprovider;

import com.sinch.android.rtc.internal.natives.jni.NativeServiceProviderImpl;
import com.sinch.android.rtc.internal.natives.jni.ServiceProviderFactory;
import com.sinch.android.rtc.internal.service.dispatcher.Dispatcher;
import com.sinch.android.rtc.internal.service.http.HttpService;
import com.sinch.android.rtc.internal.service.pubnub.PubSubClient;

/* loaded from: classes3.dex */
public class DefaultServiceProvider implements ServiceProvider {
    private Dispatcher dispatcher;
    private HttpService httpService;
    private NativeServiceProviderImpl mNativeServiceProvider;
    private PubSubClient pubSubClient;

    public DefaultServiceProvider(Dispatcher dispatcher, HttpService httpService, PubSubClient pubSubClient) {
        this.dispatcher = dispatcher;
        this.httpService = httpService;
        this.pubSubClient = pubSubClient;
        this.mNativeServiceProvider = ServiceProviderFactory.createServiceProvider(dispatcher, httpService, pubSubClient);
    }

    public void dispose() {
        NativeServiceProviderImpl nativeServiceProviderImpl = this.mNativeServiceProvider;
        if (nativeServiceProviderImpl != null) {
            nativeServiceProviderImpl.dispose();
            this.mNativeServiceProvider = null;
        }
        this.dispatcher = null;
        this.httpService = null;
        this.pubSubClient = null;
    }

    @Override // com.sinch.android.rtc.internal.service.serviceprovider.ServiceProvider
    public Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    @Override // com.sinch.android.rtc.internal.service.serviceprovider.ServiceProvider
    public HttpService getHttpService() {
        return this.httpService;
    }

    public NativeServiceProviderImpl getNativeServiceProvider() {
        return this.mNativeServiceProvider;
    }

    @Override // com.sinch.android.rtc.internal.service.serviceprovider.ServiceProvider
    public PubSubClient getPubSubClient() {
        return this.pubSubClient;
    }
}
