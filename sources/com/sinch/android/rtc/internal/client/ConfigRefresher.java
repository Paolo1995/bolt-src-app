package com.sinch.android.rtc.internal.client;

import com.sinch.android.rtc.internal.natives.jni.UserAgent;
import com.sinch.android.rtc.internal.service.dispatcher.Dispatcher;

/* loaded from: classes3.dex */
public class ConfigRefresher extends UserAgentMethodInvocationScheduler {
    public ConfigRefresher(Dispatcher dispatcher, UserAgent userAgent) {
        super(dispatcher, userAgent, "Sinch SDK ConfigRefresher");
    }

    @Override // com.sinch.android.rtc.internal.client.UserAgentMethodInvocationScheduler
    public void onRun(UserAgent userAgent) {
        userAgent.refreshConfig();
    }
}
