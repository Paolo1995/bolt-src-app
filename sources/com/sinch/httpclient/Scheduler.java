package com.sinch.httpclient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public interface Scheduler {
    void post(Runnable runnable);

    void postDelayed(Runnable runnable, long j8);
}
