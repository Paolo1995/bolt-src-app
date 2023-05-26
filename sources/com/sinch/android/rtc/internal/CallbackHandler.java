package com.sinch.android.rtc.internal;

/* loaded from: classes3.dex */
public interface CallbackHandler {
    boolean post(Runnable runnable);

    void postDelayed(Runnable runnable, int i8);

    void removeCallbacksAndMessages(Object obj);
}
