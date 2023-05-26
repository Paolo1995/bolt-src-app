package com.sinch.android.rtc.internal;

import android.content.Context;
import com.sinch.android.rtc.internal.service.dispatcher.Dispatcher;
import com.sinch.android.rtc.internal.service.http.HttpService;
import com.sinch.android.rtc.internal.service.time.TimeService;

/* loaded from: classes3.dex */
public interface RuntimeResources {
    CallbackHandler getCallbackHandler();

    Context getContext();

    String getDeviceId();

    Dispatcher getDispatcher();

    HttpService getHttpService();

    String getPersistenceServiceDatabasePath();

    TimeService getTimeService();
}
