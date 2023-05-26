package ee.mtakso.driver.ui.screens.login.v3.password;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class PasswordLoginV3ViewModel_Factory implements Factory<PasswordLoginV3ViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PasswordAuthFlow> f30778a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UrlFactory> f30779b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SystemUrlLauncher> f30780c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LoginAnalytics> f30781d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AuthManager> f30782e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<GeoLocationManager> f30783f;

    public PasswordLoginV3ViewModel_Factory(Provider<PasswordAuthFlow> provider, Provider<UrlFactory> provider2, Provider<SystemUrlLauncher> provider3, Provider<LoginAnalytics> provider4, Provider<AuthManager> provider5, Provider<GeoLocationManager> provider6) {
        this.f30778a = provider;
        this.f30779b = provider2;
        this.f30780c = provider3;
        this.f30781d = provider4;
        this.f30782e = provider5;
        this.f30783f = provider6;
    }

    public static PasswordLoginV3ViewModel_Factory a(Provider<PasswordAuthFlow> provider, Provider<UrlFactory> provider2, Provider<SystemUrlLauncher> provider3, Provider<LoginAnalytics> provider4, Provider<AuthManager> provider5, Provider<GeoLocationManager> provider6) {
        return new PasswordLoginV3ViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PasswordLoginV3ViewModel c(PasswordAuthFlow passwordAuthFlow, UrlFactory urlFactory, SystemUrlLauncher systemUrlLauncher, LoginAnalytics loginAnalytics, AuthManager authManager, GeoLocationManager geoLocationManager) {
        return new PasswordLoginV3ViewModel(passwordAuthFlow, urlFactory, systemUrlLauncher, loginAnalytics, authManager, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PasswordLoginV3ViewModel get() {
        return c(this.f30778a.get(), this.f30779b.get(), this.f30780c.get(), this.f30781d.get(), this.f30782e.get(), this.f30783f.get());
    }
}
