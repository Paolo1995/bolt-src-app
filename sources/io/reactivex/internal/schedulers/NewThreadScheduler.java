package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes5.dex */
public final class NewThreadScheduler extends Scheduler {

    /* renamed from: d  reason: collision with root package name */
    private static final RxThreadFactory f49722d = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f49723c;

    public NewThreadScheduler() {
        this(f49722d);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new NewThreadWorker(this.f49723c);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f49723c = threadFactory;
    }
}
