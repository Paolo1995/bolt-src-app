package ee.mtakso.driver.service.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.TargetingUpdateManager;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.time.AnchoredTrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverManager_Factory implements Factory<DriverManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverStatusSender> f24321a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f24322b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<TargetingUpdateManager> f24323c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AnchoredTrueTimeProvider> f24324d;

    public DriverManager_Factory(Provider<DriverStatusSender> provider, Provider<DriverProvider> provider2, Provider<TargetingUpdateManager> provider3, Provider<AnchoredTrueTimeProvider> provider4) {
        this.f24321a = provider;
        this.f24322b = provider2;
        this.f24323c = provider3;
        this.f24324d = provider4;
    }

    public static DriverManager_Factory a(Provider<DriverStatusSender> provider, Provider<DriverProvider> provider2, Provider<TargetingUpdateManager> provider3, Provider<AnchoredTrueTimeProvider> provider4) {
        return new DriverManager_Factory(provider, provider2, provider3, provider4);
    }

    public static DriverManager c(DriverStatusSender driverStatusSender, DriverProvider driverProvider, TargetingUpdateManager targetingUpdateManager, AnchoredTrueTimeProvider anchoredTrueTimeProvider) {
        return new DriverManager(driverStatusSender, driverProvider, targetingUpdateManager, anchoredTrueTimeProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverManager get() {
        return c(this.f24321a.get(), this.f24322b.get(), this.f24323c.get(), this.f24324d.get());
    }
}
