package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.modules.polling.Poller;
import ee.mtakso.driver.service.pollerv2.DynamicPollingService;
import ee.mtakso.driver.service.pollerv2.FixedPollingService;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PollerModule_ProvidePollerDataSourceFactory implements Factory<PollerSource> {

    /* renamed from: a  reason: collision with root package name */
    private final PollerModule f20857a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverFeatures> f20858b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Poller> f20859c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DynamicPollingService> f20860d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<FixedPollingService> f20861e;

    public PollerModule_ProvidePollerDataSourceFactory(PollerModule pollerModule, Provider<DriverFeatures> provider, Provider<Poller> provider2, Provider<DynamicPollingService> provider3, Provider<FixedPollingService> provider4) {
        this.f20857a = pollerModule;
        this.f20858b = provider;
        this.f20859c = provider2;
        this.f20860d = provider3;
        this.f20861e = provider4;
    }

    public static PollerModule_ProvidePollerDataSourceFactory a(PollerModule pollerModule, Provider<DriverFeatures> provider, Provider<Poller> provider2, Provider<DynamicPollingService> provider3, Provider<FixedPollingService> provider4) {
        return new PollerModule_ProvidePollerDataSourceFactory(pollerModule, provider, provider2, provider3, provider4);
    }

    public static PollerSource c(PollerModule pollerModule, DriverFeatures driverFeatures, Poller poller, DynamicPollingService dynamicPollingService, FixedPollingService fixedPollingService) {
        return (PollerSource) Preconditions.checkNotNullFromProvides(pollerModule.a(driverFeatures, poller, dynamicPollingService, fixedPollingService));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PollerSource get() {
        return c(this.f20857a, this.f20858b.get(), this.f20859c.get(), this.f20860d.get(), this.f20861e.get());
    }
}
