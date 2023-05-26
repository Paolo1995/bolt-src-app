package ee.mtakso.driver.ui.screens.login.v3.verification;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.flow.OTPAuthFlow;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoService;
import eu.bolt.driver.core.time.SystemUptimeSource;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VerificationV3ViewModel_Factory implements Factory<VerificationV3ViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OTPAuthFlow> f30840a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SystemUptimeSource> f30841b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AnonymousAuthClient> f30842c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LoginAnalytics> f30843d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AuthManager> f30844e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<GeoLocationManager> f30845f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<RoutingManager> f30846g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<ConfirmationCodeRetriever> f30847h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<GeoService> f30848i;

    public VerificationV3ViewModel_Factory(Provider<OTPAuthFlow> provider, Provider<SystemUptimeSource> provider2, Provider<AnonymousAuthClient> provider3, Provider<LoginAnalytics> provider4, Provider<AuthManager> provider5, Provider<GeoLocationManager> provider6, Provider<RoutingManager> provider7, Provider<ConfirmationCodeRetriever> provider8, Provider<GeoService> provider9) {
        this.f30840a = provider;
        this.f30841b = provider2;
        this.f30842c = provider3;
        this.f30843d = provider4;
        this.f30844e = provider5;
        this.f30845f = provider6;
        this.f30846g = provider7;
        this.f30847h = provider8;
        this.f30848i = provider9;
    }

    public static VerificationV3ViewModel_Factory a(Provider<OTPAuthFlow> provider, Provider<SystemUptimeSource> provider2, Provider<AnonymousAuthClient> provider3, Provider<LoginAnalytics> provider4, Provider<AuthManager> provider5, Provider<GeoLocationManager> provider6, Provider<RoutingManager> provider7, Provider<ConfirmationCodeRetriever> provider8, Provider<GeoService> provider9) {
        return new VerificationV3ViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static VerificationV3ViewModel c(OTPAuthFlow oTPAuthFlow, SystemUptimeSource systemUptimeSource, AnonymousAuthClient anonymousAuthClient, LoginAnalytics loginAnalytics, AuthManager authManager, GeoLocationManager geoLocationManager, RoutingManager routingManager, ConfirmationCodeRetriever confirmationCodeRetriever, GeoService geoService) {
        return new VerificationV3ViewModel(oTPAuthFlow, systemUptimeSource, anonymousAuthClient, loginAnalytics, authManager, geoLocationManager, routingManager, confirmationCodeRetriever, geoService);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VerificationV3ViewModel get() {
        return c(this.f30840a.get(), this.f30841b.get(), this.f30842c.get(), this.f30843d.get(), this.f30844e.get(), this.f30845f.get(), this.f30846g.get(), this.f30847h.get(), this.f30848i.get());
    }
}
