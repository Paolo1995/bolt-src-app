package ee.mtakso.driver.service.auth;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FullAuthFlow_Factory implements Factory<FullAuthFlow> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeepLinkManager> f23719a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AuthStepFactory> f23720b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AuthManager> f23721c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PlatformAvailabilityManager> f23722d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<GeoLocationManager> f23723e;

    public FullAuthFlow_Factory(Provider<DeepLinkManager> provider, Provider<AuthStepFactory> provider2, Provider<AuthManager> provider3, Provider<PlatformAvailabilityManager> provider4, Provider<GeoLocationManager> provider5) {
        this.f23719a = provider;
        this.f23720b = provider2;
        this.f23721c = provider3;
        this.f23722d = provider4;
        this.f23723e = provider5;
    }

    public static FullAuthFlow_Factory a(Provider<DeepLinkManager> provider, Provider<AuthStepFactory> provider2, Provider<AuthManager> provider3, Provider<PlatformAvailabilityManager> provider4, Provider<GeoLocationManager> provider5) {
        return new FullAuthFlow_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FullAuthFlow c(DeepLinkManager deepLinkManager, AuthStepFactory authStepFactory, AuthManager authManager, PlatformAvailabilityManager platformAvailabilityManager, GeoLocationManager geoLocationManager) {
        return new FullAuthFlow(deepLinkManager, authStepFactory, authManager, platformAvailabilityManager, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FullAuthFlow get() {
        return c(this.f23719a.get(), this.f23720b.get(), this.f23721c.get(), this.f23722d.get(), this.f23723e.get());
    }
}
