package com.clevertap.android.sdk.task;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class MainThreadExecutor implements Executor {

    /* renamed from: f  reason: collision with root package name */
    Handler f11791f = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f11791f.post(runnable);
    }
}
