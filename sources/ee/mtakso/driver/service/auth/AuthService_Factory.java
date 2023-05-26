package ee.mtakso.driver.service.auth;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.analytics.event.facade.DriverAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.chat.ChatService;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.google.FirebaseRemoteConfigManager;
import ee.mtakso.driver.service.modules.polling.Poller;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.service.pollerv2.PollerService;
import ee.mtakso.driver.service.restriction.DriverRestrictionManager;
import ee.mtakso.driver.service.token.TokenManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthService_Factory implements Factory<AuthService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverConfig> f23611a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverFeatures> f23612b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Features> f23613c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LoginAnalytics> f23614d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverRestrictionManager> f23615e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<Poller> f23616f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ChatService> f23617g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DriverAnalytics> f23618h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<SettingsAnalytics> f23619i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<FirebaseRemoteConfigManager> f23620j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<DriverManager> f23621k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<TokenManager> f23622l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<AppThemeManager> f23623m;

    /* renamed from: n  reason: collision with root package name */
    private final Provider<OrdersCache> f23624n;

    /* renamed from: o  reason: collision with root package name */
    private final Provider<PollerService> f23625o;

    public AuthService_Factory(Provider<DriverConfig> provider, Provider<DriverFeatures> provider2, Provider<Features> provider3, Provider<LoginAnalytics> provider4, Provider<DriverRestrictionManager> provider5, Provider<Poller> provider6, Provider<ChatService> provider7, Provider<DriverAnalytics> provider8, Provider<SettingsAnalytics> provider9, Provider<FirebaseRemoteConfigManager> provider10, Provider<DriverManager> provider11, Provider<TokenManager> provider12, Provider<AppThemeManager> provider13, Provider<OrdersCache> provider14, Provider<PollerService> provider15) {
        this.f23611a = provider;
        this.f23612b = provider2;
        this.f23613c = provider3;
        this.f23614d = provider4;
        this.f23615e = provider5;
        this.f23616f = provider6;
        this.f23617g = provider7;
        this.f23618h = provider8;
        this.f23619i = provider9;
        this.f23620j = provider10;
        this.f23621k = provider11;
        this.f23622l = provider12;
        this.f23623m = provider13;
        this.f23624n = provider14;
        this.f23625o = provider15;
    }

    public static AuthService_Factory a(Provider<DriverConfig> provider, Provider<DriverFeatures> provider2, Provider<Features> provider3, Provider<LoginAnalytics> provider4, Provider<DriverRestrictionManager> provider5, Provider<Poller> provider6, Provider<ChatService> provider7, Provider<DriverAnalytics> provider8, Provider<SettingsAnalytics> provider9, Provider<FirebaseRemoteConfigManager> provider10, Provider<DriverManager> provider11, Provider<TokenManager> provider12, Provider<AppThemeManager> provider13, Provider<OrdersCache> provider14, Provider<PollerService> provider15) {
        return new AuthService_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static AuthService c(DriverConfig driverConfig, DriverFeatures driverFeatures, Features features, LoginAnalytics loginAnalytics, DriverRestrictionManager driverRestrictionManager, Poller poller, Lazy<ChatService> lazy, DriverAnalytics driverAnalytics, SettingsAnalytics settingsAnalytics, FirebaseRemoteConfigManager firebaseRemoteConfigManager, DriverManager driverManager, TokenManager tokenManager, AppThemeManager appThemeManager, OrdersCache ordersCache, PollerService pollerService) {
        return new AuthService(driverConfig, driverFeatures, features, loginAnalytics, driverRestrictionManager, poller, lazy, driverAnalytics, settingsAnalytics, firebaseRemoteConfigManager, driverManager, tokenManager, appThemeManager, ordersCache, pollerService);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AuthService get() {
        return c(this.f23611a.get(), this.f23612b.get(), this.f23613c.get(), this.f23614d.get(), this.f23615e.get(), this.f23616f.get(), DoubleCheck.lazy(this.f23617g), this.f23618h.get(), this.f23619i.get(), this.f23620j.get(), this.f23621k.get(), this.f23622l.get(), this.f23623m.get(), this.f23624n.get(), this.f23625o.get());
    }
}
