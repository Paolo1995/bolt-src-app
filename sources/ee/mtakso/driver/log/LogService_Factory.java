package ee.mtakso.driver.log;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.applog.AppLogWatcher;
import ee.mtakso.driver.log.bigquery.BigQueryLogWatcher;
import ee.mtakso.driver.log.strategy.memory.OrderStateStrategy;
import ee.mtakso.driver.param.DriverFeatures;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LogService_Factory implements Factory<LogService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverFeatures> f21026a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BigQueryLogWatcher> f21027b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppLogWatcher> f21028c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LogManager> f21029d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<StorageConsumer> f21030e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<OrderStateStrategy> f21031f;

    public LogService_Factory(Provider<DriverFeatures> provider, Provider<BigQueryLogWatcher> provider2, Provider<AppLogWatcher> provider3, Provider<LogManager> provider4, Provider<StorageConsumer> provider5, Provider<OrderStateStrategy> provider6) {
        this.f21026a = provider;
        this.f21027b = provider2;
        this.f21028c = provider3;
        this.f21029d = provider4;
        this.f21030e = provider5;
        this.f21031f = provider6;
    }

    public static LogService_Factory a(Provider<DriverFeatures> provider, Provider<BigQueryLogWatcher> provider2, Provider<AppLogWatcher> provider3, Provider<LogManager> provider4, Provider<StorageConsumer> provider5, Provider<OrderStateStrategy> provider6) {
        return new LogService_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static LogService c(DriverFeatures driverFeatures, BigQueryLogWatcher bigQueryLogWatcher, AppLogWatcher appLogWatcher, LogManager logManager, StorageConsumer storageConsumer, OrderStateStrategy orderStateStrategy) {
        return new LogService(driverFeatures, bigQueryLogWatcher, appLogWatcher, logManager, storageConsumer, orderStateStrategy);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LogService get() {
        return c(this.f21026a.get(), this.f21027b.get(), this.f21028c.get(), this.f21029d.get(), this.f21030e.get(), this.f21031f.get());
    }
}
