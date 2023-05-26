package ee.mtakso.driver.ui.screens.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.support.SupportClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.CompositeChromeFirstUrlLauncher;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.UrlFactory;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SettingsInteractor> f33143a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f33144b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MagicLinkInteractor> f33145c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UrlFactory> f33146d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<SettingsAnalytics> f33147e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<LoginAnalytics> f33148f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<AppResolver> f33149g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f33150h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<CompositeChromeFirstUrlLauncher> f33151i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<SupportClient> f33152j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<AuthManager> f33153k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<AppThemeManager> f33154l;

    public SettingsViewModel_Factory(Provider<SettingsInteractor> provider, Provider<DriverProvider> provider2, Provider<MagicLinkInteractor> provider3, Provider<UrlFactory> provider4, Provider<SettingsAnalytics> provider5, Provider<LoginAnalytics> provider6, Provider<AppResolver> provider7, Provider<CompositeUrlLauncher> provider8, Provider<CompositeChromeFirstUrlLauncher> provider9, Provider<SupportClient> provider10, Provider<AuthManager> provider11, Provider<AppThemeManager> provider12) {
        this.f33143a = provider;
        this.f33144b = provider2;
        this.f33145c = provider3;
        this.f33146d = provider4;
        this.f33147e = provider5;
        this.f33148f = provider6;
        this.f33149g = provider7;
        this.f33150h = provider8;
        this.f33151i = provider9;
        this.f33152j = provider10;
        this.f33153k = provider11;
        this.f33154l = provider12;
    }

    public static SettingsViewModel_Factory a(Provider<SettingsInteractor> provider, Provider<DriverProvider> provider2, Provider<MagicLinkInteractor> provider3, Provider<UrlFactory> provider4, Provider<SettingsAnalytics> provider5, Provider<LoginAnalytics> provider6, Provider<AppResolver> provider7, Provider<CompositeUrlLauncher> provider8, Provider<CompositeChromeFirstUrlLauncher> provider9, Provider<SupportClient> provider10, Provider<AuthManager> provider11, Provider<AppThemeManager> provider12) {
        return new SettingsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static SettingsViewModel c(SettingsInteractor settingsInteractor, DriverProvider driverProvider, MagicLinkInteractor magicLinkInteractor, UrlFactory urlFactory, SettingsAnalytics settingsAnalytics, LoginAnalytics loginAnalytics, AppResolver appResolver, CompositeUrlLauncher compositeUrlLauncher, CompositeChromeFirstUrlLauncher compositeChromeFirstUrlLauncher, SupportClient supportClient, AuthManager authManager, AppThemeManager appThemeManager) {
        return new SettingsViewModel(settingsInteractor, driverProvider, magicLinkInteractor, urlFactory, settingsAnalytics, loginAnalytics, appResolver, compositeUrlLauncher, compositeChromeFirstUrlLauncher, supportClient, authManager, appThemeManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SettingsViewModel get() {
        return c(this.f33143a.get(), this.f33144b.get(), this.f33145c.get(), this.f33146d.get(), this.f33147e.get(), this.f33148f.get(), this.f33149g.get(), this.f33150h.get(), this.f33151i.get(), this.f33152j.get(), this.f33153k.get(), this.f33154l.get());
    }
}
