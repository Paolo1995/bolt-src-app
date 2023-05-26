package ee.mtakso.driver.service.modules.status;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics;
import ee.mtakso.driver.service.modules.reporters.AppReporter;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverStatusSenderImpl_Factory implements Factory<DriverStatusSenderImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverClient> f25241a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppStateAnalytics> f25242b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppReporter> f25243c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverProvider> f25244d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<GoOnlineFlow> f25245e;

    public DriverStatusSenderImpl_Factory(Provider<DriverClient> provider, Provider<AppStateAnalytics> provider2, Provider<AppReporter> provider3, Provider<DriverProvider> provider4, Provider<GoOnlineFlow> provider5) {
        this.f25241a = provider;
        this.f25242b = provider2;
        this.f25243c = provider3;
        this.f25244d = provider4;
        this.f25245e = provider5;
    }

    public static DriverStatusSenderImpl_Factory a(Provider<DriverClient> provider, Provider<AppStateAnalytics> provider2, Provider<AppReporter> provider3, Provider<DriverProvider> provider4, Provider<GoOnlineFlow> provider5) {
        return new DriverStatusSenderImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DriverStatusSenderImpl c(DriverClient driverClient, AppStateAnalytics appStateAnalytics, AppReporter appReporter, DriverProvider driverProvider, GoOnlineFlow goOnlineFlow) {
        return new DriverStatusSenderImpl(driverClient, appStateAnalytics, appReporter, driverProvider, goOnlineFlow);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverStatusSenderImpl get() {
        return c(this.f25241a.get(), this.f25242b.get(), this.f25243c.get(), this.f25244d.get(), this.f25245e.get());
    }
}
