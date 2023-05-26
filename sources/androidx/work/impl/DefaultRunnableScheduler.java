package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

/* loaded from: classes.dex */
public class DefaultRunnableScheduler implements RunnableScheduler {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f8344a = HandlerCompat.a(Looper.getMainLooper());

    @Override // androidx.work.RunnableScheduler
    public void a(@NonNull Runnable runnable) {
        this.f8344a.removeCallbacks(runnable);
    }

    @Override // androidx.work.RunnableScheduler
    public void b(long j8, @NonNull Runnable runnable) {
        this.f8344a.postDelayed(runnable, j8);
    }
}
