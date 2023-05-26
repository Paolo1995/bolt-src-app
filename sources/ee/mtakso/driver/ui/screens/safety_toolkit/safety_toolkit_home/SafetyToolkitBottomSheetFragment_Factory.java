package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment_MembersInjector;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.permission.MicrophonePermissionDialogProvider;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SafetyToolkitBottomSheetFragment_Factory implements Factory<SafetyToolkitBottomSheetFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SafetyToolkitMapper> f32799a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FragmentFactory> f32800b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MicrophonePermissionDialogProvider> f32801c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f32802d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ViewModelFactory> f32803e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PermissionManager> f32804f;

    public SafetyToolkitBottomSheetFragment_Factory(Provider<SafetyToolkitMapper> provider, Provider<FragmentFactory> provider2, Provider<MicrophonePermissionDialogProvider> provider3, Provider<ScreenAnalytics> provider4, Provider<ViewModelFactory> provider5, Provider<PermissionManager> provider6) {
        this.f32799a = provider;
        this.f32800b = provider2;
        this.f32801c = provider3;
        this.f32802d = provider4;
        this.f32803e = provider5;
        this.f32804f = provider6;
    }

    public static SafetyToolkitBottomSheetFragment_Factory a(Provider<SafetyToolkitMapper> provider, Provider<FragmentFactory> provider2, Provider<MicrophonePermissionDialogProvider> provider3, Provider<ScreenAnalytics> provider4, Provider<ViewModelFactory> provider5, Provider<PermissionManager> provider6) {
        return new SafetyToolkitBottomSheetFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static SafetyToolkitBottomSheetFragment c(SafetyToolkitMapper safetyToolkitMapper, FragmentFactory fragmentFactory, MicrophonePermissionDialogProvider microphonePermissionDialogProvider) {
        return new SafetyToolkitBottomSheetFragment(safetyToolkitMapper, fragmentFactory, microphonePermissionDialogProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SafetyToolkitBottomSheetFragment get() {
        SafetyToolkitBottomSheetFragment c8 = c(this.f32799a.get(), this.f32800b.get(), this.f32801c.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.b(c8, this.f32802d.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.c(c8, this.f32803e.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.a(c8, this.f32804f.get());
        return c8;
    }
}
