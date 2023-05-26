package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.pollerv2.DynamicPollingService;
import ee.mtakso.driver.service.pollerv2.FixedPollingService;
import ee.mtakso.driver.service.pollerv2.PollerService;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PollerModule_ProvidePollerServiceFactory implements Factory<PollerService> {

    /* renamed from: a  reason: collision with root package name */
    private final PollerModule f20862a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f20863b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DynamicPollingService> f20864c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<FixedPollingService> f20865d;

    public PollerModule_ProvidePollerServiceFactory(PollerModule pollerModule, Provider<DriverProvider> provider, Provider<DynamicPollingService> provider2, Provider<FixedPollingService> provider3) {
        this.f20862a = pollerModule;
        this.f20863b = provider;
        this.f20864c = provider2;
        this.f20865d = provider3;
    }

    public static PollerModule_ProvidePollerServiceFactory a(PollerModule pollerModule, Provider<DriverProvider> provider, Provider<DynamicPollingService> provider2, Provider<FixedPollingService> provider3) {
        return new PollerModule_ProvidePollerServiceFactory(pollerModule, provider, provider2, provider3);
    }

    public static PollerService c(PollerModule pollerModule, DriverProvider driverProvider, DynamicPollingService dynamicPollingService, FixedPollingService fixedPollingService) {
        return (PollerService) Preconditions.checkNotNullFromProvides(pollerModule.b(driverProvider, dynamicPollingService, fixedPollingService));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PollerService get() {
        return c(this.f20862a, this.f20863b.get(), this.f20864c.get(), this.f20865d.get());
    }
}
