package ee.mtakso.driver.ui.screens.login.v2.verification;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import ee.mtakso.driver.service.auth.flow.PasswordAuthFlow;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoService;
import eu.bolt.driver.core.time.SystemUptimeSource;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VerificationViewModel_Factory implements Factory<VerificationViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PasswordAuthFlow> f30603a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SystemUptimeSource> f30604b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AnonymousAuthClient> f30605c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ConfirmationCodeRetriever> f30606d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<GeoLocationManager> f30607e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<GeoService> f30608f;

    public VerificationViewModel_Factory(Provider<PasswordAuthFlow> provider, Provider<SystemUptimeSource> provider2, Provider<AnonymousAuthClient> provider3, Provider<ConfirmationCodeRetriever> provider4, Provider<GeoLocationManager> provider5, Provider<GeoService> provider6) {
        this.f30603a = provider;
        this.f30604b = provider2;
        this.f30605c = provider3;
        this.f30606d = provider4;
        this.f30607e = provider5;
        this.f30608f = provider6;
    }

    public static VerificationViewModel_Factory a(Provider<PasswordAuthFlow> provider, Provider<SystemUptimeSource> provider2, Provider<AnonymousAuthClient> provider3, Provider<ConfirmationCodeRetriever> provider4, Provider<GeoLocationManager> provider5, Provider<GeoService> provider6) {
        return new VerificationViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static VerificationViewModel c(PasswordAuthFlow passwordAuthFlow, SystemUptimeSource systemUptimeSource, AnonymousAuthClient anonymousAuthClient, ConfirmationCodeRetriever confirmationCodeRetriever, GeoLocationManager geoLocationManager, GeoService geoService) {
        return new VerificationViewModel(passwordAuthFlow, systemUptimeSource, anonymousAuthClient, confirmationCodeRetriever, geoLocationManager, geoService);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VerificationViewModel get() {
        return c(this.f30603a.get(), this.f30604b.get(), this.f30605c.get(), this.f30606d.get(), this.f30607e.get(), this.f30608f.get());
    }
}
