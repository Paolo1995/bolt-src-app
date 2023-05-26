package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SchedulingModule_WorkSchedulerFactory implements Factory<WorkScheduler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12210a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EventStore> f12211b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SchedulerConfig> f12212c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Clock> f12213d;

    public SchedulingModule_WorkSchedulerFactory(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        this.f12210a = provider;
        this.f12211b = provider2;
        this.f12212c = provider3;
        this.f12213d = provider4;
    }

    public static SchedulingModule_WorkSchedulerFactory a(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        return new SchedulingModule_WorkSchedulerFactory(provider, provider2, provider3, provider4);
    }

    public static WorkScheduler c(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        return (WorkScheduler) Preconditions.c(SchedulingModule.a(context, eventStore, schedulerConfig, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkScheduler get() {
        return c(this.f12210a.get(), this.f12211b.get(), this.f12212c.get(), this.f12213d.get());
    }
}
