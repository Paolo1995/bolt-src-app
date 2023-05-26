package com.sinch.android.rtc.internal;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public class AndroidLooperCallbackHandler implements CallbackHandler {
    public Handler mHandler;

    public AndroidLooperCallbackHandler() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            throw new IllegalThreadStateException("A Looper must be associated with this thread.");
        }
        this.mHandler = new Handler(myLooper);
    }

    @Override // com.sinch.android.rtc.internal.CallbackHandler
    public boolean post(Runnable runnable) {
        return this.mHandler.post(runnable);
    }

    @Override // com.sinch.android.rtc.internal.CallbackHandler
    public void postDelayed(Runnable runnable, int i8) {
        this.mHandler.postDelayed(runnable, i8);
    }

    @Override // com.sinch.android.rtc.internal.CallbackHandler
    public void removeCallbacksAndMessages(Object obj) {
        this.mHandler.removeCallbacksAndMessages(obj);
    }
}
