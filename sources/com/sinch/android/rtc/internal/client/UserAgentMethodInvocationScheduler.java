package com.sinch.android.rtc.internal.client;

import com.sinch.android.rtc.internal.natives.Dispatchable;
import com.sinch.android.rtc.internal.natives.jni.UserAgent;
import com.sinch.android.rtc.internal.service.dispatcher.Dispatcher;

/* loaded from: classes3.dex */
abstract class UserAgentMethodInvocationScheduler extends Scheduler {
    private Dispatcher dispatcher;
    private UserAgent userAgent;

    public UserAgentMethodInvocationScheduler(Dispatcher dispatcher, UserAgent userAgent) {
        this.dispatcher = dispatcher;
        this.userAgent = userAgent;
    }

    public UserAgentMethodInvocationScheduler(Dispatcher dispatcher, UserAgent userAgent, String str) {
        super(str);
        this.dispatcher = dispatcher;
        this.userAgent = userAgent;
    }

    @Override // com.sinch.android.rtc.internal.client.Scheduler
    public void onDispose() {
        this.dispatcher = null;
        this.userAgent = null;
    }

    @Override // com.sinch.android.rtc.internal.client.Scheduler
    public void onRun() {
        Dispatcher dispatcher = this.dispatcher;
        if (dispatcher == null) {
            return;
        }
        dispatcher.dispatchOnThread(new Dispatchable() { // from class: com.sinch.android.rtc.internal.client.UserAgentMethodInvocationScheduler.1
            @Override // com.sinch.android.rtc.internal.natives.Dispatchable
            public void dispose() {
            }

            @Override // com.sinch.android.rtc.internal.natives.Dispatchable
            public void invalidate() {
            }

            @Override // com.sinch.android.rtc.internal.natives.Dispatchable
            public void run() {
                if (UserAgentMethodInvocationScheduler.this.isRunning() && UserAgentMethodInvocationScheduler.this.userAgent != null) {
                    UserAgentMethodInvocationScheduler userAgentMethodInvocationScheduler = UserAgentMethodInvocationScheduler.this;
                    userAgentMethodInvocationScheduler.onRun(userAgentMethodInvocationScheduler.userAgent);
                }
            }
        });
    }

    public abstract void onRun(UserAgent userAgent);
}
