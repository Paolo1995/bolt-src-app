package ee.mtakso.driver.service.session;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.service.analytics.event.facade.DriverAnalytics;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SessionProvider_Factory implements Factory<SessionProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f25918a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeviceInfo> f25919b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverAnalytics> f25920c;

    public SessionProvider_Factory(Provider<TrueTimeProvider> provider, Provider<DeviceInfo> provider2, Provider<DriverAnalytics> provider3) {
        this.f25918a = provider;
        this.f25919b = provider2;
        this.f25920c = provider3;
    }

    public static SessionProvider_Factory a(Provider<TrueTimeProvider> provider, Provider<DeviceInfo> provider2, Provider<DriverAnalytics> provider3) {
        return new SessionProvider_Factory(provider, provider2, provider3);
    }

    public static SessionProvider c(TrueTimeProvider trueTimeProvider, DeviceInfo deviceInfo, DriverAnalytics driverAnalytics) {
        return new SessionProvider(trueTimeProvider, deviceInfo, driverAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SessionProvider get() {
        return c(this.f25918a.get(), this.f25919b.get(), this.f25920c.get());
    }
}
