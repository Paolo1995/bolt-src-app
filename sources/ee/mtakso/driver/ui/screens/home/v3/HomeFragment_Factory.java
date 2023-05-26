package ee.mtakso.driver.ui.screens.home.v3;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.common.push.PushDialogDelegate;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialogDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.CarUnavailableDialogDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.NavigatorChooserDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.OnBoardingDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.TrainingDelegate;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.LowStorageDialogDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class HomeFragment_Factory implements Factory<HomeFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f29778a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FragmentFactory> f29779b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<NavigatorChooserDelegate> f29780c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PushDialogDelegate> f29781d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PromoDialogDelegate> f29782e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<TrainingDelegate> f29783f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<DeeplinkDelegate> f29784g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<OnBoardingDelegate> f29785h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<RateMeDialogDelegate> f29786i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<AppRoutingManager> f29787j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<CarUnavailableDialogDelegate> f29788k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<DeeplinkHomeContainerCoordinator> f29789l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<LowStorageDialogDelegate> f29790m;

    public HomeFragment_Factory(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<NavigatorChooserDelegate> provider3, Provider<PushDialogDelegate> provider4, Provider<PromoDialogDelegate> provider5, Provider<TrainingDelegate> provider6, Provider<DeeplinkDelegate> provider7, Provider<OnBoardingDelegate> provider8, Provider<RateMeDialogDelegate> provider9, Provider<AppRoutingManager> provider10, Provider<CarUnavailableDialogDelegate> provider11, Provider<DeeplinkHomeContainerCoordinator> provider12, Provider<LowStorageDialogDelegate> provider13) {
        this.f29778a = provider;
        this.f29779b = provider2;
        this.f29780c = provider3;
        this.f29781d = provider4;
        this.f29782e = provider5;
        this.f29783f = provider6;
        this.f29784g = provider7;
        this.f29785h = provider8;
        this.f29786i = provider9;
        this.f29787j = provider10;
        this.f29788k = provider11;
        this.f29789l = provider12;
        this.f29790m = provider13;
    }

    public static HomeFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<NavigatorChooserDelegate> provider3, Provider<PushDialogDelegate> provider4, Provider<PromoDialogDelegate> provider5, Provider<TrainingDelegate> provider6, Provider<DeeplinkDelegate> provider7, Provider<OnBoardingDelegate> provider8, Provider<RateMeDialogDelegate> provider9, Provider<AppRoutingManager> provider10, Provider<CarUnavailableDialogDelegate> provider11, Provider<DeeplinkHomeContainerCoordinator> provider12, Provider<LowStorageDialogDelegate> provider13) {
        return new HomeFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static HomeFragment c(BaseUiDependencies baseUiDependencies, FragmentFactory fragmentFactory, NavigatorChooserDelegate navigatorChooserDelegate, PushDialogDelegate pushDialogDelegate, PromoDialogDelegate promoDialogDelegate, TrainingDelegate trainingDelegate, DeeplinkDelegate deeplinkDelegate, OnBoardingDelegate onBoardingDelegate, RateMeDialogDelegate rateMeDialogDelegate, AppRoutingManager appRoutingManager, CarUnavailableDialogDelegate carUnavailableDialogDelegate, DeeplinkHomeContainerCoordinator deeplinkHomeContainerCoordinator, LowStorageDialogDelegate lowStorageDialogDelegate) {
        return new HomeFragment(baseUiDependencies, fragmentFactory, navigatorChooserDelegate, pushDialogDelegate, promoDialogDelegate, trainingDelegate, deeplinkDelegate, onBoardingDelegate, rateMeDialogDelegate, appRoutingManager, carUnavailableDialogDelegate, deeplinkHomeContainerCoordinator, lowStorageDialogDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HomeFragment get() {
        return c(this.f29778a.get(), this.f29779b.get(), this.f29780c.get(), this.f29781d.get(), this.f29782e.get(), this.f29783f.get(), this.f29784g.get(), this.f29785h.get(), this.f29786i.get(), this.f29787j.get(), this.f29788k.get(), this.f29789l.get(), this.f29790m.get());
    }
}
