package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DaggerTransportRuntimeComponent extends TransportRuntimeComponent {

    /* renamed from: f  reason: collision with root package name */
    private Provider<Executor> f12086f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<Context> f12087g;

    /* renamed from: h  reason: collision with root package name */
    private Provider f12088h;

    /* renamed from: i  reason: collision with root package name */
    private Provider f12089i;

    /* renamed from: j  reason: collision with root package name */
    private Provider f12090j;

    /* renamed from: k  reason: collision with root package name */
    private Provider<String> f12091k;

    /* renamed from: l  reason: collision with root package name */
    private Provider<SQLiteEventStore> f12092l;

    /* renamed from: m  reason: collision with root package name */
    private Provider<SchedulerConfig> f12093m;

    /* renamed from: n  reason: collision with root package name */
    private Provider<WorkScheduler> f12094n;

    /* renamed from: o  reason: collision with root package name */
    private Provider<DefaultScheduler> f12095o;

    /* renamed from: p  reason: collision with root package name */
    private Provider<Uploader> f12096p;

    /* renamed from: q  reason: collision with root package name */
    private Provider<WorkInitializer> f12097q;

    /* renamed from: r  reason: collision with root package name */
    private Provider<TransportRuntime> f12098r;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Builder implements TransportRuntimeComponent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Context f12099a;

        private Builder() {
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        /* renamed from: b */
        public Builder a(Context context) {
            this.f12099a = (Context) Preconditions.b(context);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        public TransportRuntimeComponent build() {
            Preconditions.a(this.f12099a, Context.class);
            return new DaggerTransportRuntimeComponent(this.f12099a);
        }
    }

    public static TransportRuntimeComponent.Builder e() {
        return new Builder();
    }

    private void g(Context context) {
        this.f12086f = DoubleCheck.b(ExecutionModule_ExecutorFactory.a());
        Factory a8 = InstanceFactory.a(context);
        this.f12087g = a8;
        CreationContextFactory_Factory a9 = CreationContextFactory_Factory.a(a8, TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a());
        this.f12088h = a9;
        this.f12089i = DoubleCheck.b(MetadataBackendRegistry_Factory.a(this.f12087g, a9));
        this.f12090j = SchemaManager_Factory.a(this.f12087g, EventStoreModule_DbNameFactory.a(), EventStoreModule_SchemaVersionFactory.a());
        this.f12091k = EventStoreModule_PackageNameFactory.a(this.f12087g);
        this.f12092l = DoubleCheck.b(SQLiteEventStore_Factory.a(TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), EventStoreModule_StoreConfigFactory.a(), this.f12090j, this.f12091k));
        SchedulingConfigModule_ConfigFactory b8 = SchedulingConfigModule_ConfigFactory.b(TimeModule_EventClockFactory.a());
        this.f12093m = b8;
        SchedulingModule_WorkSchedulerFactory a10 = SchedulingModule_WorkSchedulerFactory.a(this.f12087g, this.f12092l, b8, TimeModule_UptimeClockFactory.a());
        this.f12094n = a10;
        Provider<Executor> provider = this.f12086f;
        Provider provider2 = this.f12089i;
        Provider<SQLiteEventStore> provider3 = this.f12092l;
        this.f12095o = DefaultScheduler_Factory.a(provider, provider2, a10, provider3, provider3);
        Provider<Context> provider4 = this.f12087g;
        Provider provider5 = this.f12089i;
        Provider<SQLiteEventStore> provider6 = this.f12092l;
        this.f12096p = Uploader_Factory.a(provider4, provider5, provider6, this.f12094n, this.f12086f, provider6, TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), this.f12092l);
        Provider<Executor> provider7 = this.f12086f;
        Provider<SQLiteEventStore> provider8 = this.f12092l;
        this.f12097q = WorkInitializer_Factory.a(provider7, provider8, this.f12094n, provider8);
        this.f12098r = DoubleCheck.b(TransportRuntime_Factory.a(TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), this.f12095o, this.f12096p, this.f12097q));
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    EventStore a() {
        return this.f12092l.get();
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    TransportRuntime c() {
        return this.f12098r.get();
    }

    private DaggerTransportRuntimeComponent(Context context) {
        g(context);
    }
}
