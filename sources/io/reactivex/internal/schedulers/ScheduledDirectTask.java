package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b */
    public Void call() throws Exception {
        this.f49660g = Thread.currentThread();
        try {
            this.f49659f.run();
            return null;
        } finally {
            lazySet(AbstractDirectTask.f49657h);
            this.f49660g = null;
        }
    }
}
