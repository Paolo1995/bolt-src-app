package ee.mtakso.driver.ui.screens.authenticate;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.flow.PartnerConvertAuthFlow;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthenticateViewModel_Factory implements Factory<AuthenticateViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PartnerConvertAuthFlow> f27045a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AnonymousAuthClient> f27046b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<LoginAnalytics> f27047c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AuthManager> f27048d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<GeoLocationManager> f27049e;

    public AuthenticateViewModel_Factory(Provider<PartnerConvertAuthFlow> provider, Provider<AnonymousAuthClient> provider2, Provider<LoginAnalytics> provider3, Provider<AuthManager> provider4, Provider<GeoLocationManager> provider5) {
        this.f27045a = provider;
        this.f27046b = provider2;
        this.f27047c = provider3;
        this.f27048d = provider4;
        this.f27049e = provider5;
    }

    public static AuthenticateViewModel_Factory a(Provider<PartnerConvertAuthFlow> provider, Provider<AnonymousAuthClient> provider2, Provider<LoginAnalytics> provider3, Provider<AuthManager> provider4, Provider<GeoLocationManager> provider5) {
        return new AuthenticateViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AuthenticateViewModel c(PartnerConvertAuthFlow partnerConvertAuthFlow, AnonymousAuthClient anonymousAuthClient, LoginAnalytics loginAnalytics, AuthManager authManager, GeoLocationManager geoLocationManager) {
        return new AuthenticateViewModel(partnerConvertAuthFlow, anonymousAuthClient, loginAnalytics, authManager, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AuthenticateViewModel get() {
        return c(this.f27045a.get(), this.f27046b.get(), this.f27047c.get(), this.f27048d.get(), this.f27049e.get());
    }
}
