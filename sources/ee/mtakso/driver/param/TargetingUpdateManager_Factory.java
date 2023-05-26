package ee.mtakso.driver.param;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.driver.DriverConfigurationClient;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TargetingUpdateManager_Factory implements Factory<TargetingUpdateManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverConfigurationClient> f23244a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Features> f23245b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f23246c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LoginAnalytics> f23247d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f23248e;

    public TargetingUpdateManager_Factory(Provider<DriverConfigurationClient> provider, Provider<Features> provider2, Provider<DriverProvider> provider3, Provider<LoginAnalytics> provider4, Provider<TrueTimeProvider> provider5) {
        this.f23244a = provider;
        this.f23245b = provider2;
        this.f23246c = provider3;
        this.f23247d = provider4;
        this.f23248e = provider5;
    }

    public static TargetingUpdateManager_Factory a(Provider<DriverConfigurationClient> provider, Provider<Features> provider2, Provider<DriverProvider> provider3, Provider<LoginAnalytics> provider4, Provider<TrueTimeProvider> provider5) {
        return new TargetingUpdateManager_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TargetingUpdateManager c(DriverConfigurationClient driverConfigurationClient, Features features, DriverProvider driverProvider, LoginAnalytics loginAnalytics, TrueTimeProvider trueTimeProvider) {
        return new TargetingUpdateManager(driverConfigurationClient, features, driverProvider, loginAnalytics, trueTimeProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TargetingUpdateManager get() {
        return c(this.f23244a.get(), this.f23245b.get(), this.f23246c.get(), this.f23247d.get(), this.f23248e.get());
    }
}
