package com.clevertap.android.sdk.task;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class MainLooperHandler extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f11790a;

    public MainLooperHandler() {
        super(Looper.getMainLooper());
        this.f11790a = null;
    }

    public Runnable a() {
        return this.f11790a;
    }

    public void b(Runnable runnable) {
        this.f11790a = runnable;
    }
}
