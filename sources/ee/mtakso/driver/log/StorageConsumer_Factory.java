package ee.mtakso.driver.log;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.storage.LogSaver;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class StorageConsumer_Factory implements Factory<StorageConsumer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LogSaver> f21042a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LogWorker> f21043b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<LogFilter> f21044c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<InternalLog> f21045d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverProvider> f21046e;

    public StorageConsumer_Factory(Provider<LogSaver> provider, Provider<LogWorker> provider2, Provider<LogFilter> provider3, Provider<InternalLog> provider4, Provider<DriverProvider> provider5) {
        this.f21042a = provider;
        this.f21043b = provider2;
        this.f21044c = provider3;
        this.f21045d = provider4;
        this.f21046e = provider5;
    }

    public static StorageConsumer_Factory a(Provider<LogSaver> provider, Provider<LogWorker> provider2, Provider<LogFilter> provider3, Provider<InternalLog> provider4, Provider<DriverProvider> provider5) {
        return new StorageConsumer_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static StorageConsumer c(LogSaver logSaver, LogWorker logWorker, LogFilter logFilter, InternalLog internalLog, DriverProvider driverProvider) {
        return new StorageConsumer(logSaver, logWorker, logFilter, internalLog, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StorageConsumer get() {
        return c(this.f21042a.get(), this.f21043b.get(), this.f21044c.get(), this.f21045d.get(), this.f21046e.get());
    }
}
