package ee.mtakso.driver.service.session;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverConfig;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SessionService_Factory implements Factory<SessionService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SessionProvider> f25923a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverConfig> f25924b;

    public SessionService_Factory(Provider<SessionProvider> provider, Provider<DriverConfig> provider2) {
        this.f25923a = provider;
        this.f25924b = provider2;
    }

    public static SessionService_Factory a(Provider<SessionProvider> provider, Provider<DriverConfig> provider2) {
        return new SessionService_Factory(provider, provider2);
    }

    public static SessionService c(SessionProvider sessionProvider, DriverConfig driverConfig) {
        return new SessionService(sessionProvider, driverConfig);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SessionService get() {
        return c(this.f25923a.get(), this.f25924b.get());
    }
}
