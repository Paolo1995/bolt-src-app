package com.sinch.httpclient;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
final class AndroidLooperScheduler implements Scheduler {
    private final Handler mHandler;

    public AndroidLooperScheduler(Looper looper) {
        if (looper == null) {
            throw new IllegalThreadStateException("A Looper must be associated with this thread.");
        }
        this.mHandler = new Handler(looper);
    }

    @Override // com.sinch.httpclient.Scheduler
    public void post(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    @Override // com.sinch.httpclient.Scheduler
    public void postDelayed(Runnable runnable, long j8) {
        this.mHandler.postDelayed(runnable, j8);
    }
}
