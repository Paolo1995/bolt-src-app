package ee.mtakso.driver.ui.interactor.warnings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.connectivity.ConnectionMessageManager;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class UnauthorizedWarningInteractor_Factory implements Factory<UnauthorizedWarningInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ConnectionMessageManager> f26949a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AuthManager> f26950b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<GeoLocationManager> f26951c;

    public UnauthorizedWarningInteractor_Factory(Provider<ConnectionMessageManager> provider, Provider<AuthManager> provider2, Provider<GeoLocationManager> provider3) {
        this.f26949a = provider;
        this.f26950b = provider2;
        this.f26951c = provider3;
    }

    public static UnauthorizedWarningInteractor_Factory a(Provider<ConnectionMessageManager> provider, Provider<AuthManager> provider2, Provider<GeoLocationManager> provider3) {
        return new UnauthorizedWarningInteractor_Factory(provider, provider2, provider3);
    }

    public static UnauthorizedWarningInteractor c(ConnectionMessageManager connectionMessageManager, AuthManager authManager, GeoLocationManager geoLocationManager) {
        return new UnauthorizedWarningInteractor(connectionMessageManager, authManager, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public UnauthorizedWarningInteractor get() {
        return c(this.f26949a.get(), this.f26950b.get(), this.f26951c.get());
    }
}
