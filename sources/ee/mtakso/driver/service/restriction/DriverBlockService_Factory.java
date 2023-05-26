package ee.mtakso.driver.service.restriction;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverBlockService_Factory implements Factory<DriverBlockService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f25818a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverRestrictionManager> f25819b;

    public DriverBlockService_Factory(Provider<DriverStatusProvider> provider, Provider<DriverRestrictionManager> provider2) {
        this.f25818a = provider;
        this.f25819b = provider2;
    }

    public static DriverBlockService_Factory a(Provider<DriverStatusProvider> provider, Provider<DriverRestrictionManager> provider2) {
        return new DriverBlockService_Factory(provider, provider2);
    }

    public static DriverBlockService c(DriverStatusProvider driverStatusProvider, DriverRestrictionManager driverRestrictionManager) {
        return new DriverBlockService(driverStatusProvider, driverRestrictionManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverBlockService get() {
        return c(this.f25818a.get(), this.f25819b.get());
    }
}
