package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class CrashlyticsBackgroundWorker {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f15590a;

    /* renamed from: b  reason: collision with root package name */
    private Task<Void> f15591b = Tasks.forResult(null);

    /* renamed from: c  reason: collision with root package name */
    private final Object f15592c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final ThreadLocal<Boolean> f15593d = new ThreadLocal<>();

    public CrashlyticsBackgroundWorker(Executor executor) {
        this.f15590a = executor;
        executor.execute(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.1
            @Override // java.lang.Runnable
            public void run() {
                CrashlyticsBackgroundWorker.this.f15593d.set(Boolean.TRUE);
            }
        });
    }

    private <T> Task<Void> d(Task<T> task) {
        return task.continueWith(this.f15590a, (Continuation<T, Void>) new Continuation<T, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.4
            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: a */
            public Void then(@NonNull Task<T> task2) throws Exception {
                return null;
            }
        });
    }

    private boolean e() {
        return Boolean.TRUE.equals(this.f15593d.get());
    }

    private <T> Continuation<Void, T> f(final Callable<T> callable) {
        return new Continuation<Void, T>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.3
            @Override // com.google.android.gms.tasks.Continuation
            public T then(@NonNull Task<Void> task) throws Exception {
                return (T) callable.call();
            }
        };
    }

    public void b() {
        if (e()) {
            return;
        }
        throw new IllegalStateException("Not running on background worker thread as intended.");
    }

    public Executor c() {
        return this.f15590a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Void> g(final Runnable runnable) {
        return h(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                runnable.run();
                return null;
            }
        });
    }

    public <T> Task<T> h(Callable<T> callable) {
        Task<T> continueWith;
        synchronized (this.f15592c) {
            continueWith = this.f15591b.continueWith(this.f15590a, f(callable));
            this.f15591b = d(continueWith);
        }
        return continueWith;
    }

    public <T> Task<T> i(Callable<Task<T>> callable) {
        Task<T> continueWithTask;
        synchronized (this.f15592c) {
            continueWithTask = this.f15591b.continueWithTask(this.f15590a, f(callable));
            this.f15591b = d(continueWithTask);
        }
        return continueWithTask;
    }
}
