package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Clock> f12312a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f12313b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EventStoreConfig> f12314c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SchemaManager> f12315d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<String> f12316e;

    public SQLiteEventStore_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4, Provider<String> provider5) {
        this.f12312a = provider;
        this.f12313b = provider2;
        this.f12314c = provider3;
        this.f12315d = provider4;
        this.f12316e = provider5;
    }

    public static SQLiteEventStore_Factory a(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4, Provider<String> provider5) {
        return new SQLiteEventStore_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SQLiteEventStore c(Clock clock, Clock clock2, Object obj, Object obj2, Lazy<String> lazy) {
        return new SQLiteEventStore(clock, clock2, (EventStoreConfig) obj, (SchemaManager) obj2, lazy);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SQLiteEventStore get() {
        return c(this.f12312a.get(), this.f12313b.get(), this.f12314c.get(), this.f12315d.get(), DoubleCheck.a(this.f12316e));
    }
}
