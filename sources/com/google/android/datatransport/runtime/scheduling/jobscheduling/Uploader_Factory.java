package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class Uploader_Factory implements Factory<Uploader> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12240a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BackendRegistry> f12241b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EventStore> f12242c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<WorkScheduler> f12243d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Executor> f12244e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f12245f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<Clock> f12246g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<Clock> f12247h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<ClientHealthMetricsStore> f12248i;

    public Uploader_Factory(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7, Provider<Clock> provider8, Provider<ClientHealthMetricsStore> provider9) {
        this.f12240a = provider;
        this.f12241b = provider2;
        this.f12242c = provider3;
        this.f12243d = provider4;
        this.f12244e = provider5;
        this.f12245f = provider6;
        this.f12246g = provider7;
        this.f12247h = provider8;
        this.f12248i = provider9;
    }

    public static Uploader_Factory a(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7, Provider<Clock> provider8, Provider<ClientHealthMetricsStore> provider9) {
        return new Uploader_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static Uploader c(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock, clock2, clientHealthMetricsStore);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Uploader get() {
        return c(this.f12240a.get(), this.f12241b.get(), this.f12242c.get(), this.f12243d.get(), this.f12244e.get(), this.f12245f.get(), this.f12246g.get(), this.f12247h.get(), this.f12248i.get());
    }
}
