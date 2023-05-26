package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public abstract class l implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final TaskCompletionSource f14618f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l() {
        this.f14618f = null;
    }

    public l(TaskCompletionSource taskCompletionSource) {
        this.f14618f = taskCompletionSource;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f14618f;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final TaskCompletionSource c() {
        return this.f14618f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b();
        } catch (Exception e8) {
            a(e8);
        }
    }
}
