package com.sinch.android.rtc.internal.client;

import com.sinch.android.rtc.internal.natives.jni.UserAgent;
import com.sinch.android.rtc.internal.service.dispatcher.DefaultDispatcher;

/* loaded from: classes3.dex */
public class HouseKeeper extends UserAgentMethodInvocationScheduler {
    public HouseKeeper(DefaultDispatcher defaultDispatcher, UserAgent userAgent) {
        super(defaultDispatcher, userAgent, "Sinch SDK HouseKeeper");
    }

    @Override // com.sinch.android.rtc.internal.client.UserAgentMethodInvocationScheduler
    public void onRun(UserAgent userAgent) {
        userAgent.doHouseKeeping();
    }
}
