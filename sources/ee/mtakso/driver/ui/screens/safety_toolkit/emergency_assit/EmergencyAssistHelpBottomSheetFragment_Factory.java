package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment_MembersInjector;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EmergencyAssistHelpBottomSheetFragment_Factory implements Factory<EmergencyAssistHelpBottomSheetFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EmergencyAssistDataMapper> f32693a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FragmentFactory> f32694b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverSettings> f32695c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f32696d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ViewModelFactory> f32697e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PermissionManager> f32698f;

    public EmergencyAssistHelpBottomSheetFragment_Factory(Provider<EmergencyAssistDataMapper> provider, Provider<FragmentFactory> provider2, Provider<DriverSettings> provider3, Provider<ScreenAnalytics> provider4, Provider<ViewModelFactory> provider5, Provider<PermissionManager> provider6) {
        this.f32693a = provider;
        this.f32694b = provider2;
        this.f32695c = provider3;
        this.f32696d = provider4;
        this.f32697e = provider5;
        this.f32698f = provider6;
    }

    public static EmergencyAssistHelpBottomSheetFragment_Factory a(Provider<EmergencyAssistDataMapper> provider, Provider<FragmentFactory> provider2, Provider<DriverSettings> provider3, Provider<ScreenAnalytics> provider4, Provider<ViewModelFactory> provider5, Provider<PermissionManager> provider6) {
        return new EmergencyAssistHelpBottomSheetFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static EmergencyAssistHelpBottomSheetFragment c(EmergencyAssistDataMapper emergencyAssistDataMapper, FragmentFactory fragmentFactory, DriverSettings driverSettings) {
        return new EmergencyAssistHelpBottomSheetFragment(emergencyAssistDataMapper, fragmentFactory, driverSettings);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EmergencyAssistHelpBottomSheetFragment get() {
        EmergencyAssistHelpBottomSheetFragment c8 = c(this.f32693a.get(), this.f32694b.get(), this.f32695c.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.b(c8, this.f32696d.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.c(c8, this.f32697e.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.a(c8, this.f32698f.get());
        return c8;
    }
}
