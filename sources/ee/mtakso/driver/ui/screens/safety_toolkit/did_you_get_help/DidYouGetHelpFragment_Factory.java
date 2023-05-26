package ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment_MembersInjector;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DidYouGetHelpFragment_Factory implements Factory<DidYouGetHelpFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f32619a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ViewModelFactory> f32620b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PermissionManager> f32621c;

    public DidYouGetHelpFragment_Factory(Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3) {
        this.f32619a = provider;
        this.f32620b = provider2;
        this.f32621c = provider3;
    }

    public static DidYouGetHelpFragment_Factory a(Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3) {
        return new DidYouGetHelpFragment_Factory(provider, provider2, provider3);
    }

    public static DidYouGetHelpFragment c() {
        return new DidYouGetHelpFragment();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DidYouGetHelpFragment get() {
        DidYouGetHelpFragment c8 = c();
        BaseMvvmBottomSheetDialogFragment_MembersInjector.b(c8, this.f32619a.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.c(c8, this.f32620b.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.a(c8, this.f32621c.get());
        return c8;
    }
}
