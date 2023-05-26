package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* loaded from: classes.dex */
public class WorkInitializer {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f12249a;

    /* renamed from: b  reason: collision with root package name */
    private final EventStore f12250b;

    /* renamed from: c  reason: collision with root package name */
    private final WorkScheduler f12251c;

    /* renamed from: d  reason: collision with root package name */
    private final SynchronizationGuard f12252d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public WorkInitializer(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.f12249a = executor;
        this.f12250b = eventStore;
        this.f12251c = workScheduler;
        this.f12252d = synchronizationGuard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d() {
        for (TransportContext transportContext : this.f12250b.D()) {
            this.f12251c.a(transportContext, 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f12252d.c(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.o
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object execute() {
                Object d8;
                d8 = WorkInitializer.this.d();
                return d8;
            }
        });
    }

    public void c() {
        this.f12249a.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.n
            @Override // java.lang.Runnable
            public final void run() {
                WorkInitializer.this.e();
            }
        });
    }
}
