package ee.mtakso.driver.ui.screens.login.v2.pswrd;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.flow.PasswordAuthFlow;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import ee.mtakso.driver.utils.UrlFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PasswordLoginViewModel_Factory implements Factory<PasswordLoginViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PasswordAuthFlow> f30549a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UrlFactory> f30550b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SystemUrlLauncher> f30551c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LoginAnalytics> f30552d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AuthManager> f30553e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<GeoLocationManager> f30554f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<DeviceSettings> f30555g;

    public PasswordLoginViewModel_Factory(Provider<PasswordAuthFlow> provider, Provider<UrlFactory> provider2, Provider<SystemUrlLauncher> provider3, Provider<LoginAnalytics> provider4, Provider<AuthManager> provider5, Provider<GeoLocationManager> provider6, Provider<DeviceSettings> provider7) {
        this.f30549a = provider;
        this.f30550b = provider2;
        this.f30551c = provider3;
        this.f30552d = provider4;
        this.f30553e = provider5;
        this.f30554f = provider6;
        this.f30555g = provider7;
    }

    public static PasswordLoginViewModel_Factory a(Provider<PasswordAuthFlow> provider, Provider<UrlFactory> provider2, Provider<SystemUrlLauncher> provider3, Provider<LoginAnalytics> provider4, Provider<AuthManager> provider5, Provider<GeoLocationManager> provider6, Provider<DeviceSettings> provider7) {
        return new PasswordLoginViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static PasswordLoginViewModel c(PasswordAuthFlow passwordAuthFlow, UrlFactory urlFactory, SystemUrlLauncher systemUrlLauncher, LoginAnalytics loginAnalytics, AuthManager authManager, GeoLocationManager geoLocationManager, DeviceSettings deviceSettings) {
        return new PasswordLoginViewModel(passwordAuthFlow, urlFactory, systemUrlLauncher, loginAnalytics, authManager, geoLocationManager, deviceSettings);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PasswordLoginViewModel get() {
        return c(this.f30549a.get(), this.f30550b.get(), this.f30551c.get(), this.f30552d.get(), this.f30553e.get(), this.f30554f.get(), this.f30555g.get());
    }
}
