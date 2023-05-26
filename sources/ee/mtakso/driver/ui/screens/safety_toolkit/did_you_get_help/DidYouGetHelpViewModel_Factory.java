package ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistClient;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DidYouGetHelpViewModel_Factory implements Factory<DidYouGetHelpViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EmergencyAssistClient> f32641a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderProvider> f32642b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EmergencyAssistManager> f32643c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SafetyToolkitAnalytics> f32644d;

    public DidYouGetHelpViewModel_Factory(Provider<EmergencyAssistClient> provider, Provider<OrderProvider> provider2, Provider<EmergencyAssistManager> provider3, Provider<SafetyToolkitAnalytics> provider4) {
        this.f32641a = provider;
        this.f32642b = provider2;
        this.f32643c = provider3;
        this.f32644d = provider4;
    }

    public static DidYouGetHelpViewModel_Factory a(Provider<EmergencyAssistClient> provider, Provider<OrderProvider> provider2, Provider<EmergencyAssistManager> provider3, Provider<SafetyToolkitAnalytics> provider4) {
        return new DidYouGetHelpViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static DidYouGetHelpViewModel c(EmergencyAssistClient emergencyAssistClient, OrderProvider orderProvider, EmergencyAssistManager emergencyAssistManager, SafetyToolkitAnalytics safetyToolkitAnalytics) {
        return new DidYouGetHelpViewModel(emergencyAssistClient, orderProvider, emergencyAssistManager, safetyToolkitAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DidYouGetHelpViewModel get() {
        return c(this.f32641a.get(), this.f32642b.get(), this.f32643c.get(), this.f32644d.get());
    }
}
