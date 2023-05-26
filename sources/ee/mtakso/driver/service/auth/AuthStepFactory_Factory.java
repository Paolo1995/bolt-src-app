package ee.mtakso.driver.service.auth;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.network.client.driver.DriverConfigurationClient;
import ee.mtakso.driver.network.client.partner.PartnerClient;
import ee.mtakso.driver.network.client.registration.DriverRegistrationClient;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityCheck;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.push.PushManagerImpl;
import eu.bolt.driver.core.ui.translation.TranslationManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthStepFactory_Factory implements Factory<AuthStepFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23653a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeepLinkManager> f23654b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AnonymousAuthClient> f23655c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PartnerClient> f23656d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AuthenticatedAuthClient> f23657e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DriverRegistrationClient> f23658f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<TranslationManager> f23659g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<AuthManager> f23660h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<PushManagerImpl> f23661i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<DriverProvider> f23662j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<DeviceSettings> f23663k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<LanguageManager> f23664l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<PlatformAvailabilityManager> f23665m;

    /* renamed from: n  reason: collision with root package name */
    private final Provider<DeviceFeatures> f23666n;

    /* renamed from: o  reason: collision with root package name */
    private final Provider<GeoLocationManager> f23667o;

    /* renamed from: p  reason: collision with root package name */
    private final Provider<DriverConfigurationClient> f23668p;

    /* renamed from: q  reason: collision with root package name */
    private final Provider<TempDriverConfigHolder> f23669q;

    /* renamed from: r  reason: collision with root package name */
    private final Provider<StoreIntegrityCheck> f23670r;

    /* renamed from: s  reason: collision with root package name */
    private final Provider<StoreVerificationBackoffStrategy> f23671s;

    /* renamed from: t  reason: collision with root package name */
    private final Provider<AuthConfigurationBackoffStrategy> f23672t;

    /* renamed from: u  reason: collision with root package name */
    private final Provider<PlatformManager> f23673u;

    public AuthStepFactory_Factory(Provider<Context> provider, Provider<DeepLinkManager> provider2, Provider<AnonymousAuthClient> provider3, Provider<PartnerClient> provider4, Provider<AuthenticatedAuthClient> provider5, Provider<DriverRegistrationClient> provider6, Provider<TranslationManager> provider7, Provider<AuthManager> provider8, Provider<PushManagerImpl> provider9, Provider<DriverProvider> provider10, Provider<DeviceSettings> provider11, Provider<LanguageManager> provider12, Provider<PlatformAvailabilityManager> provider13, Provider<DeviceFeatures> provider14, Provider<GeoLocationManager> provider15, Provider<DriverConfigurationClient> provider16, Provider<TempDriverConfigHolder> provider17, Provider<StoreIntegrityCheck> provider18, Provider<StoreVerificationBackoffStrategy> provider19, Provider<AuthConfigurationBackoffStrategy> provider20, Provider<PlatformManager> provider21) {
        this.f23653a = provider;
        this.f23654b = provider2;
        this.f23655c = provider3;
        this.f23656d = provider4;
        this.f23657e = provider5;
        this.f23658f = provider6;
        this.f23659g = provider7;
        this.f23660h = provider8;
        this.f23661i = provider9;
        this.f23662j = provider10;
        this.f23663k = provider11;
        this.f23664l = provider12;
        this.f23665m = provider13;
        this.f23666n = provider14;
        this.f23667o = provider15;
        this.f23668p = provider16;
        this.f23669q = provider17;
        this.f23670r = provider18;
        this.f23671s = provider19;
        this.f23672t = provider20;
        this.f23673u = provider21;
    }

    public static AuthStepFactory_Factory a(Provider<Context> provider, Provider<DeepLinkManager> provider2, Provider<AnonymousAuthClient> provider3, Provider<PartnerClient> provider4, Provider<AuthenticatedAuthClient> provider5, Provider<DriverRegistrationClient> provider6, Provider<TranslationManager> provider7, Provider<AuthManager> provider8, Provider<PushManagerImpl> provider9, Provider<DriverProvider> provider10, Provider<DeviceSettings> provider11, Provider<LanguageManager> provider12, Provider<PlatformAvailabilityManager> provider13, Provider<DeviceFeatures> provider14, Provider<GeoLocationManager> provider15, Provider<DriverConfigurationClient> provider16, Provider<TempDriverConfigHolder> provider17, Provider<StoreIntegrityCheck> provider18, Provider<StoreVerificationBackoffStrategy> provider19, Provider<AuthConfigurationBackoffStrategy> provider20, Provider<PlatformManager> provider21) {
        return new AuthStepFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21);
    }

    public static AuthStepFactory c(Context context, DeepLinkManager deepLinkManager, AnonymousAuthClient anonymousAuthClient, PartnerClient partnerClient, AuthenticatedAuthClient authenticatedAuthClient, DriverRegistrationClient driverRegistrationClient, TranslationManager translationManager, AuthManager authManager, PushManagerImpl pushManagerImpl, DriverProvider driverProvider, DeviceSettings deviceSettings, LanguageManager languageManager, PlatformAvailabilityManager platformAvailabilityManager, DeviceFeatures deviceFeatures, GeoLocationManager geoLocationManager, DriverConfigurationClient driverConfigurationClient, TempDriverConfigHolder tempDriverConfigHolder, StoreIntegrityCheck storeIntegrityCheck, StoreVerificationBackoffStrategy storeVerificationBackoffStrategy, AuthConfigurationBackoffStrategy authConfigurationBackoffStrategy, PlatformManager platformManager) {
        return new AuthStepFactory(context, deepLinkManager, anonymousAuthClient, partnerClient, authenticatedAuthClient, driverRegistrationClient, translationManager, authManager, pushManagerImpl, driverProvider, deviceSettings, languageManager, platformAvailabilityManager, deviceFeatures, geoLocationManager, driverConfigurationClient, tempDriverConfigHolder, storeIntegrityCheck, storeVerificationBackoffStrategy, authConfigurationBackoffStrategy, platformManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AuthStepFactory get() {
        return c(this.f23653a.get(), this.f23654b.get(), this.f23655c.get(), this.f23656d.get(), this.f23657e.get(), this.f23658f.get(), this.f23659g.get(), this.f23660h.get(), this.f23661i.get(), this.f23662j.get(), this.f23663k.get(), this.f23664l.get(), this.f23665m.get(), this.f23666n.get(), this.f23667o.get(), this.f23668p.get(), this.f23669q.get(), this.f23670r.get(), this.f23671s.get(), this.f23672t.get(), this.f23673u.get());
    }
}
