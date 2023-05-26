package ee.mtakso.driver.ui.screens.signup;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.platform.ads.AdvertiserIdProvider;
import ee.mtakso.driver.service.analytics.event.facade.SignUpAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import ee.mtakso.driver.service.push.PushManagerImpl;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import ee.mtakso.driver.utils.UrlFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class SignUpViewModel_Factory implements Factory<SignUpViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceSettings> f33374a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UrlFactory> f33375b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PushManagerImpl> f33376c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AuthManager> f33377d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<StartUpTracing> f33378e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<WebViewTracker> f33379f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<AppsflyerManager> f33380g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<AdvertiserIdProvider> f33381h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<SignUpAnalytics> f33382i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<CleverTapManager> f33383j;

    public SignUpViewModel_Factory(Provider<DeviceSettings> provider, Provider<UrlFactory> provider2, Provider<PushManagerImpl> provider3, Provider<AuthManager> provider4, Provider<StartUpTracing> provider5, Provider<WebViewTracker> provider6, Provider<AppsflyerManager> provider7, Provider<AdvertiserIdProvider> provider8, Provider<SignUpAnalytics> provider9, Provider<CleverTapManager> provider10) {
        this.f33374a = provider;
        this.f33375b = provider2;
        this.f33376c = provider3;
        this.f33377d = provider4;
        this.f33378e = provider5;
        this.f33379f = provider6;
        this.f33380g = provider7;
        this.f33381h = provider8;
        this.f33382i = provider9;
        this.f33383j = provider10;
    }

    public static SignUpViewModel_Factory a(Provider<DeviceSettings> provider, Provider<UrlFactory> provider2, Provider<PushManagerImpl> provider3, Provider<AuthManager> provider4, Provider<StartUpTracing> provider5, Provider<WebViewTracker> provider6, Provider<AppsflyerManager> provider7, Provider<AdvertiserIdProvider> provider8, Provider<SignUpAnalytics> provider9, Provider<CleverTapManager> provider10) {
        return new SignUpViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static SignUpViewModel c(DeviceSettings deviceSettings, UrlFactory urlFactory, PushManagerImpl pushManagerImpl, AuthManager authManager, StartUpTracing startUpTracing, WebViewTracker webViewTracker, AppsflyerManager appsflyerManager, AdvertiserIdProvider advertiserIdProvider, SignUpAnalytics signUpAnalytics, CleverTapManager cleverTapManager) {
        return new SignUpViewModel(deviceSettings, urlFactory, pushManagerImpl, authManager, startUpTracing, webViewTracker, appsflyerManager, advertiserIdProvider, signUpAnalytics, cleverTapManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SignUpViewModel get() {
        return c(this.f33374a.get(), this.f33375b.get(), this.f33376c.get(), this.f33377d.get(), this.f33378e.get(), this.f33379f.get(), this.f33380g.get(), this.f33381h.get(), this.f33382i.get(), this.f33383j.get());
    }
}
