package io.reactivex.internal.schedulers;

import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f49660g = Thread.currentThread();
        try {
            this.f49659f.run();
            this.f49660g = null;
        } catch (Throwable th) {
            this.f49660g = null;
            lazySet(AbstractDirectTask.f49657h);
            RxJavaPlugins.s(th);
        }
    }
}
