package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Executor> f12204a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BackendRegistry> f12205b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WorkScheduler> f12206c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<EventStore> f12207d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f12208e;

    public DefaultScheduler_Factory(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        this.f12204a = provider;
        this.f12205b = provider2;
        this.f12206c = provider3;
        this.f12207d = provider4;
        this.f12208e = provider5;
    }

    public static DefaultScheduler_Factory a(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        return new DefaultScheduler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DefaultScheduler c(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DefaultScheduler get() {
        return c(this.f12204a.get(), this.f12205b.get(), this.f12206c.get(), this.f12207d.get(), this.f12208e.get());
    }
}
