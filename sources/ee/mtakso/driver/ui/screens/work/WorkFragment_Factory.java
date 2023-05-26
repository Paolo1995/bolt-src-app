package ee.mtakso.driver.ui.screens.work;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverReferralCampaignManager;
import ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate;
import ee.mtakso.driver.ui.screens.modal.ModalDelegate;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.LowStorageDialogDelegate;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.permission.MicrophonePermissionDialogProvider;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes5.dex */
public final class WorkFragment_Factory implements Factory<WorkFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33741a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f33742b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DateTimeConverter> f33743c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverReferralCampaignManager> f33744d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Features> f33745e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DeeplinkDelegate> f33746f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<GeoLocationManager> f33747g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DriverPricingAnalytics> f33748h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<PromoDialogDelegate> f33749i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<PermissionManager> f33750j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<HtmlEngine> f33751k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<ModalDelegate> f33752l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<DriverConfig> f33753m;

    /* renamed from: n  reason: collision with root package name */
    private final Provider<MicrophonePermissionDialogProvider> f33754n;

    /* renamed from: o  reason: collision with root package name */
    private final Provider<PermissionAnalytics> f33755o;

    /* renamed from: p  reason: collision with root package name */
    private final Provider<LowStorageDialogDelegate> f33756p;

    public WorkFragment_Factory(Provider<BaseUiDependencies> provider, Provider<DriverProvider> provider2, Provider<DateTimeConverter> provider3, Provider<DriverReferralCampaignManager> provider4, Provider<Features> provider5, Provider<DeeplinkDelegate> provider6, Provider<GeoLocationManager> provider7, Provider<DriverPricingAnalytics> provider8, Provider<PromoDialogDelegate> provider9, Provider<PermissionManager> provider10, Provider<HtmlEngine> provider11, Provider<ModalDelegate> provider12, Provider<DriverConfig> provider13, Provider<MicrophonePermissionDialogProvider> provider14, Provider<PermissionAnalytics> provider15, Provider<LowStorageDialogDelegate> provider16) {
        this.f33741a = provider;
        this.f33742b = provider2;
        this.f33743c = provider3;
        this.f33744d = provider4;
        this.f33745e = provider5;
        this.f33746f = provider6;
        this.f33747g = provider7;
        this.f33748h = provider8;
        this.f33749i = provider9;
        this.f33750j = provider10;
        this.f33751k = provider11;
        this.f33752l = provider12;
        this.f33753m = provider13;
        this.f33754n = provider14;
        this.f33755o = provider15;
        this.f33756p = provider16;
    }

    public static WorkFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<DriverProvider> provider2, Provider<DateTimeConverter> provider3, Provider<DriverReferralCampaignManager> provider4, Provider<Features> provider5, Provider<DeeplinkDelegate> provider6, Provider<GeoLocationManager> provider7, Provider<DriverPricingAnalytics> provider8, Provider<PromoDialogDelegate> provider9, Provider<PermissionManager> provider10, Provider<HtmlEngine> provider11, Provider<ModalDelegate> provider12, Provider<DriverConfig> provider13, Provider<MicrophonePermissionDialogProvider> provider14, Provider<PermissionAnalytics> provider15, Provider<LowStorageDialogDelegate> provider16) {
        return new WorkFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    public static WorkFragment c(BaseUiDependencies baseUiDependencies, DriverProvider driverProvider, DateTimeConverter dateTimeConverter, DriverReferralCampaignManager driverReferralCampaignManager, Features features, DeeplinkDelegate deeplinkDelegate, GeoLocationManager geoLocationManager, DriverPricingAnalytics driverPricingAnalytics, PromoDialogDelegate promoDialogDelegate, PermissionManager permissionManager, HtmlEngine htmlEngine, ModalDelegate modalDelegate, DriverConfig driverConfig, MicrophonePermissionDialogProvider microphonePermissionDialogProvider, PermissionAnalytics permissionAnalytics, LowStorageDialogDelegate lowStorageDialogDelegate) {
        return new WorkFragment(baseUiDependencies, driverProvider, dateTimeConverter, driverReferralCampaignManager, features, deeplinkDelegate, geoLocationManager, driverPricingAnalytics, promoDialogDelegate, permissionManager, htmlEngine, modalDelegate, driverConfig, microphonePermissionDialogProvider, permissionAnalytics, lowStorageDialogDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkFragment get() {
        return c(this.f33741a.get(), this.f33742b.get(), this.f33743c.get(), this.f33744d.get(), this.f33745e.get(), this.f33746f.get(), this.f33747g.get(), this.f33748h.get(), this.f33749i.get(), this.f33750j.get(), this.f33751k.get(), this.f33752l.get(), this.f33753m.get(), this.f33754n.get(), this.f33755o.get(), this.f33756p.get());
    }
}
