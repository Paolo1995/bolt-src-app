package com.sinch.android.rtc.internal.service.serviceprovider;

import com.sinch.android.rtc.internal.service.dispatcher.Dispatcher;
import com.sinch.android.rtc.internal.service.http.HttpService;
import com.sinch.android.rtc.internal.service.pubnub.PubSubClient;

/* loaded from: classes3.dex */
public interface ServiceProvider {
    Dispatcher getDispatcher();

    HttpService getHttpService();

    PubSubClient getPubSubClient();
}
