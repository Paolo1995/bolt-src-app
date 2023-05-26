package ee.mtakso.driver.service.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverStateService_Factory implements Factory<DriverStateService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f24329a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverManager> f24330b;

    public DriverStateService_Factory(Provider<DriverStatusProvider> provider, Provider<DriverManager> provider2) {
        this.f24329a = provider;
        this.f24330b = provider2;
    }

    public static DriverStateService_Factory a(Provider<DriverStatusProvider> provider, Provider<DriverManager> provider2) {
        return new DriverStateService_Factory(provider, provider2);
    }

    public static DriverStateService c(DriverStatusProvider driverStatusProvider, DriverManager driverManager) {
        return new DriverStateService(driverStatusProvider, driverManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverStateService get() {
        return c(this.f24329a.get(), this.f24330b.get());
    }
}
