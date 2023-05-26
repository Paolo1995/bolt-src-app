package ee.mtakso.driver.ui.screens.order.cancel;

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
public final class TripCancellationBottomSheetFragment_Factory implements Factory<TripCancellationBottomSheetFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f31241a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ViewModelFactory> f31242b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PermissionManager> f31243c;

    public TripCancellationBottomSheetFragment_Factory(Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3) {
        this.f31241a = provider;
        this.f31242b = provider2;
        this.f31243c = provider3;
    }

    public static TripCancellationBottomSheetFragment_Factory a(Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3) {
        return new TripCancellationBottomSheetFragment_Factory(provider, provider2, provider3);
    }

    public static TripCancellationBottomSheetFragment c() {
        return new TripCancellationBottomSheetFragment();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TripCancellationBottomSheetFragment get() {
        TripCancellationBottomSheetFragment c8 = c();
        BaseMvvmBottomSheetDialogFragment_MembersInjector.b(c8, this.f31241a.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.c(c8, this.f31242b.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.a(c8, this.f31243c.get());
        return c8;
    }
}
