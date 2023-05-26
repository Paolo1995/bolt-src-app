package ee.mtakso.driver.ui.screens.settings;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverReferralCampaignManager;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.service.workingtime.WorkingTimeManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class SettingsInteractor_Factory implements Factory<SettingsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f33077a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f33078b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DeviceInfo> f33079c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<WorkingTimeManager> f33080d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<NavigationAppTypeFactory> f33081e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DriverReferralCampaignManager> f33082f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f33083g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DeviceSettings> f33084h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<LanguageManager> f33085i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<DriverManager> f33086j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<DispatchSettingsManager> f33087k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<OnBoardingManager> f33088l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<AppThemeManager> f33089m;

    /* renamed from: n  reason: collision with root package name */
    private final Provider<DriverFeatures> f33090n;

    public SettingsInteractor_Factory(Provider<Context> provider, Provider<DriverProvider> provider2, Provider<DeviceInfo> provider3, Provider<WorkingTimeManager> provider4, Provider<NavigationAppTypeFactory> provider5, Provider<DriverReferralCampaignManager> provider6, Provider<DriverStatusProvider> provider7, Provider<DeviceSettings> provider8, Provider<LanguageManager> provider9, Provider<DriverManager> provider10, Provider<DispatchSettingsManager> provider11, Provider<OnBoardingManager> provider12, Provider<AppThemeManager> provider13, Provider<DriverFeatures> provider14) {
        this.f33077a = provider;
        this.f33078b = provider2;
        this.f33079c = provider3;
        this.f33080d = provider4;
        this.f33081e = provider5;
        this.f33082f = provider6;
        this.f33083g = provider7;
        this.f33084h = provider8;
        this.f33085i = provider9;
        this.f33086j = provider10;
        this.f33087k = provider11;
        this.f33088l = provider12;
        this.f33089m = provider13;
        this.f33090n = provider14;
    }

    public static SettingsInteractor_Factory a(Provider<Context> provider, Provider<DriverProvider> provider2, Provider<DeviceInfo> provider3, Provider<WorkingTimeManager> provider4, Provider<NavigationAppTypeFactory> provider5, Provider<DriverReferralCampaignManager> provider6, Provider<DriverStatusProvider> provider7, Provider<DeviceSettings> provider8, Provider<LanguageManager> provider9, Provider<DriverManager> provider10, Provider<DispatchSettingsManager> provider11, Provider<OnBoardingManager> provider12, Provider<AppThemeManager> provider13, Provider<DriverFeatures> provider14) {
        return new SettingsInteractor_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    public static SettingsInteractor c(Context context, DriverProvider driverProvider, DeviceInfo deviceInfo, WorkingTimeManager workingTimeManager, NavigationAppTypeFactory navigationAppTypeFactory, DriverReferralCampaignManager driverReferralCampaignManager, DriverStatusProvider driverStatusProvider, DeviceSettings deviceSettings, LanguageManager languageManager, DriverManager driverManager, DispatchSettingsManager dispatchSettingsManager, OnBoardingManager onBoardingManager, AppThemeManager appThemeManager, DriverFeatures driverFeatures) {
        return new SettingsInteractor(context, driverProvider, deviceInfo, workingTimeManager, navigationAppTypeFactory, driverReferralCampaignManager, driverStatusProvider, deviceSettings, languageManager, driverManager, dispatchSettingsManager, onBoardingManager, appThemeManager, driverFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SettingsInteractor get() {
        return c(this.f33077a.get(), this.f33078b.get(), this.f33079c.get(), this.f33080d.get(), this.f33081e.get(), this.f33082f.get(), this.f33083g.get(), this.f33084h.get(), this.f33085i.get(), this.f33086j.get(), this.f33087k.get(), this.f33088l.get(), this.f33089m.get(), this.f33090n.get());
    }
}
