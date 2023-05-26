package ee.mtakso.driver.service.modules.status;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverStatusService_Factory implements Factory<DriverStatusService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f25249a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverManager> f25250b;

    public DriverStatusService_Factory(Provider<PollerSource> provider, Provider<DriverManager> provider2) {
        this.f25249a = provider;
        this.f25250b = provider2;
    }

    public static DriverStatusService_Factory a(Provider<PollerSource> provider, Provider<DriverManager> provider2) {
        return new DriverStatusService_Factory(provider, provider2);
    }

    public static DriverStatusService c(PollerSource pollerSource, DriverManager driverManager) {
        return new DriverStatusService(pollerSource, driverManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverStatusService get() {
        return c(this.f25249a.get(), this.f25250b.get());
    }
}
