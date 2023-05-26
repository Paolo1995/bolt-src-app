package ee.mtakso.driver.ui.screens.order.arrived;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.order.details.OrderManager;
import ee.mtakso.driver.service.order.details.OrderTryAgainManager;
import ee.mtakso.driver.service.rating.app.AppRatingManager;
import ee.mtakso.driver.ui.common.internet.InternetDataDelegate;
import ee.mtakso.driver.ui.interactor.warnings.AuthorizedWarningInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DrivePriceViewModel_Factory implements Factory<DrivePriceViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DrivePriceInteractor> f31045a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f31046b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderStateManager> f31047c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<OrderTracker> f31048d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AppRatingManager> f31049e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<InternetDataDelegate> f31050f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<AuthorizedWarningInteractor> f31051g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<SafetyToolkitAnalytics> f31052h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<EmergencyAssistInteractor> f31053i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<DidYouGetHelpInteractor> f31054j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<DriverSettings> f31055k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<AudioRecordingManager> f31056l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<OrderTryAgainManager> f31057m;

    /* renamed from: n  reason: collision with root package name */
    private final Provider<OrderManager> f31058n;

    public DrivePriceViewModel_Factory(Provider<DrivePriceInteractor> provider, Provider<DriverProvider> provider2, Provider<OrderStateManager> provider3, Provider<OrderTracker> provider4, Provider<AppRatingManager> provider5, Provider<InternetDataDelegate> provider6, Provider<AuthorizedWarningInteractor> provider7, Provider<SafetyToolkitAnalytics> provider8, Provider<EmergencyAssistInteractor> provider9, Provider<DidYouGetHelpInteractor> provider10, Provider<DriverSettings> provider11, Provider<AudioRecordingManager> provider12, Provider<OrderTryAgainManager> provider13, Provider<OrderManager> provider14) {
        this.f31045a = provider;
        this.f31046b = provider2;
        this.f31047c = provider3;
        this.f31048d = provider4;
        this.f31049e = provider5;
        this.f31050f = provider6;
        this.f31051g = provider7;
        this.f31052h = provider8;
        this.f31053i = provider9;
        this.f31054j = provider10;
        this.f31055k = provider11;
        this.f31056l = provider12;
        this.f31057m = provider13;
        this.f31058n = provider14;
    }

    public static DrivePriceViewModel_Factory a(Provider<DrivePriceInteractor> provider, Provider<DriverProvider> provider2, Provider<OrderStateManager> provider3, Provider<OrderTracker> provider4, Provider<AppRatingManager> provider5, Provider<InternetDataDelegate> provider6, Provider<AuthorizedWarningInteractor> provider7, Provider<SafetyToolkitAnalytics> provider8, Provider<EmergencyAssistInteractor> provider9, Provider<DidYouGetHelpInteractor> provider10, Provider<DriverSettings> provider11, Provider<AudioRecordingManager> provider12, Provider<OrderTryAgainManager> provider13, Provider<OrderManager> provider14) {
        return new DrivePriceViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    public static DrivePriceViewModel c(DrivePriceInteractor drivePriceInteractor, DriverProvider driverProvider, OrderStateManager orderStateManager, OrderTracker orderTracker, AppRatingManager appRatingManager, InternetDataDelegate internetDataDelegate, AuthorizedWarningInteractor authorizedWarningInteractor, SafetyToolkitAnalytics safetyToolkitAnalytics, EmergencyAssistInteractor emergencyAssistInteractor, DidYouGetHelpInteractor didYouGetHelpInteractor, DriverSettings driverSettings, AudioRecordingManager audioRecordingManager, OrderTryAgainManager orderTryAgainManager, OrderManager orderManager) {
        return new DrivePriceViewModel(drivePriceInteractor, driverProvider, orderStateManager, orderTracker, appRatingManager, internetDataDelegate, authorizedWarningInteractor, safetyToolkitAnalytics, emergencyAssistInteractor, didYouGetHelpInteractor, driverSettings, audioRecordingManager, orderTryAgainManager, orderManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DrivePriceViewModel get() {
        return c(this.f31045a.get(), this.f31046b.get(), this.f31047c.get(), this.f31048d.get(), this.f31049e.get(), this.f31050f.get(), this.f31051g.get(), this.f31052h.get(), this.f31053i.get(), this.f31054j.get(), this.f31055k.get(), this.f31056l.get(), this.f31057m.get(), this.f31058n.get());
    }
}
