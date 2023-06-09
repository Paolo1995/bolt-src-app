package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class WorkInitializer_Factory implements Factory<WorkInitializer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Executor> f12253a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EventStore> f12254b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WorkScheduler> f12255c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f12256d;

    public WorkInitializer_Factory(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        this.f12253a = provider;
        this.f12254b = provider2;
        this.f12255c = provider3;
        this.f12256d = provider4;
    }

    public static WorkInitializer_Factory a(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        return new WorkInitializer_Factory(provider, provider2, provider3, provider4);
    }

    public static WorkInitializer c(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkInitializer get() {
        return c(this.f12253a.get(), this.f12254b.get(), this.f12255c.get(), this.f12256d.get());
    }
}
