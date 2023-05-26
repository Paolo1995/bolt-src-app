package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.order.v2.order.RouteSharingInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SafetyToolkitViewModel_Factory implements Factory<SafetyToolkitViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SafetyToolkitInteractor> f32846a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderTracker> f32847b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderProvider> f32848c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<RouteSharingInteractor> f32849d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AudioRecordingAnalytics> f32850e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PermissionAnalytics> f32851f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<SafetyToolkitAnalytics> f32852g;

    public SafetyToolkitViewModel_Factory(Provider<SafetyToolkitInteractor> provider, Provider<OrderTracker> provider2, Provider<OrderProvider> provider3, Provider<RouteSharingInteractor> provider4, Provider<AudioRecordingAnalytics> provider5, Provider<PermissionAnalytics> provider6, Provider<SafetyToolkitAnalytics> provider7) {
        this.f32846a = provider;
        this.f32847b = provider2;
        this.f32848c = provider3;
        this.f32849d = provider4;
        this.f32850e = provider5;
        this.f32851f = provider6;
        this.f32852g = provider7;
    }

    public static SafetyToolkitViewModel_Factory a(Provider<SafetyToolkitInteractor> provider, Provider<OrderTracker> provider2, Provider<OrderProvider> provider3, Provider<RouteSharingInteractor> provider4, Provider<AudioRecordingAnalytics> provider5, Provider<PermissionAnalytics> provider6, Provider<SafetyToolkitAnalytics> provider7) {
        return new SafetyToolkitViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SafetyToolkitViewModel c(SafetyToolkitInteractor safetyToolkitInteractor, OrderTracker orderTracker, OrderProvider orderProvider, RouteSharingInteractor routeSharingInteractor, AudioRecordingAnalytics audioRecordingAnalytics, PermissionAnalytics permissionAnalytics, SafetyToolkitAnalytics safetyToolkitAnalytics) {
        return new SafetyToolkitViewModel(safetyToolkitInteractor, orderTracker, orderProvider, routeSharingInteractor, audioRecordingAnalytics, permissionAnalytics, safetyToolkitAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SafetyToolkitViewModel get() {
        return c(this.f32846a.get(), this.f32847b.get(), this.f32848c.get(), this.f32849d.get(), this.f32850e.get(), this.f32851f.get(), this.f32852g.get());
    }
}
