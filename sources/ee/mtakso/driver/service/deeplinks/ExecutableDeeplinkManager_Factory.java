package ee.mtakso.driver.service.deeplinks;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.service.earnings.EarningsManager;
import ee.mtakso.driver.service.order.ScheduledOrderManager;
import ee.mtakso.driver.service.restriction.DriverTrainingRestrictionManager;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ExecutableDeeplinkManager_Factory implements Factory<ExecutableDeeplinkManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeepLinkManager> f24281a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScheduledOrderManager> f24282b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverTrainingRestrictionManager> f24283c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<EarningsManager> f24284d;

    public ExecutableDeeplinkManager_Factory(Provider<DeepLinkManager> provider, Provider<ScheduledOrderManager> provider2, Provider<DriverTrainingRestrictionManager> provider3, Provider<EarningsManager> provider4) {
        this.f24281a = provider;
        this.f24282b = provider2;
        this.f24283c = provider3;
        this.f24284d = provider4;
    }

    public static ExecutableDeeplinkManager_Factory a(Provider<DeepLinkManager> provider, Provider<ScheduledOrderManager> provider2, Provider<DriverTrainingRestrictionManager> provider3, Provider<EarningsManager> provider4) {
        return new ExecutableDeeplinkManager_Factory(provider, provider2, provider3, provider4);
    }

    public static ExecutableDeeplinkManager c(DeepLinkManager deepLinkManager, ScheduledOrderManager scheduledOrderManager, DriverTrainingRestrictionManager driverTrainingRestrictionManager, EarningsManager earningsManager) {
        return new ExecutableDeeplinkManager(deepLinkManager, scheduledOrderManager, driverTrainingRestrictionManager, earningsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ExecutableDeeplinkManager get() {
        return c(this.f24281a.get(), this.f24282b.get(), this.f24283c.get(), this.f24284d.get());
    }
}
