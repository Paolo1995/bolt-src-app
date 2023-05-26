package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TransportRuntime_Factory implements Factory<TransportRuntime> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Clock> f12119a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f12120b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Scheduler> f12121c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Uploader> f12122d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<WorkInitializer> f12123e;

    public TransportRuntime_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        this.f12119a = provider;
        this.f12120b = provider2;
        this.f12121c = provider3;
        this.f12122d = provider4;
        this.f12123e = provider5;
    }

    public static TransportRuntime_Factory a(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        return new TransportRuntime_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TransportRuntime c(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TransportRuntime get() {
        return c(this.f12119a.get(), this.f12120b.get(), this.f12121c.get(), this.f12122d.get(), this.f12123e.get());
    }
}
