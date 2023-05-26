package ee.mtakso.driver.service.modules.driverdestinations;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverDestinationsService_Factory implements Factory<DriverDestinationsService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f24656a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f24657b;

    public DriverDestinationsService_Factory(Provider<PollerSource> provider, Provider<DriverDestinationsManager> provider2) {
        this.f24656a = provider;
        this.f24657b = provider2;
    }

    public static DriverDestinationsService_Factory a(Provider<PollerSource> provider, Provider<DriverDestinationsManager> provider2) {
        return new DriverDestinationsService_Factory(provider, provider2);
    }

    public static DriverDestinationsService c(PollerSource pollerSource, DriverDestinationsManager driverDestinationsManager) {
        return new DriverDestinationsService(pollerSource, driverDestinationsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverDestinationsService get() {
        return c(this.f24656a.get(), this.f24657b.get());
    }
}
