package ee.mtakso.driver.ui.screens.order.incoming.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.ui.interactor.order.IncomingOrderInteractor;
import ee.mtakso.driver.ui.interactor.order.incoming.IncomingOrderRouteInteractor;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IncomingOrderViewModel_Factory implements Factory<IncomingOrderViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<IncomingOrderInteractor> f31431a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<IncomingOrderRouteInteractor> f31432b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderStateManager> f31433c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AppThemeManager> f31434d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RateMePrefsManager> f31435e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f31436f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<DriverFeatures> f31437g;

    public IncomingOrderViewModel_Factory(Provider<IncomingOrderInteractor> provider, Provider<IncomingOrderRouteInteractor> provider2, Provider<OrderStateManager> provider3, Provider<AppThemeManager> provider4, Provider<RateMePrefsManager> provider5, Provider<TrueTimeProvider> provider6, Provider<DriverFeatures> provider7) {
        this.f31431a = provider;
        this.f31432b = provider2;
        this.f31433c = provider3;
        this.f31434d = provider4;
        this.f31435e = provider5;
        this.f31436f = provider6;
        this.f31437g = provider7;
    }

    public static IncomingOrderViewModel_Factory a(Provider<IncomingOrderInteractor> provider, Provider<IncomingOrderRouteInteractor> provider2, Provider<OrderStateManager> provider3, Provider<AppThemeManager> provider4, Provider<RateMePrefsManager> provider5, Provider<TrueTimeProvider> provider6, Provider<DriverFeatures> provider7) {
        return new IncomingOrderViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static IncomingOrderViewModel c(IncomingOrderInteractor incomingOrderInteractor, IncomingOrderRouteInteractor incomingOrderRouteInteractor, OrderStateManager orderStateManager, AppThemeManager appThemeManager, RateMePrefsManager rateMePrefsManager, TrueTimeProvider trueTimeProvider, DriverFeatures driverFeatures) {
        return new IncomingOrderViewModel(incomingOrderInteractor, incomingOrderRouteInteractor, orderStateManager, appThemeManager, rateMePrefsManager, trueTimeProvider, driverFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncomingOrderViewModel get() {
        return c(this.f31431a.get(), this.f31432b.get(), this.f31433c.get(), this.f31434d.get(), this.f31435e.get(), this.f31436f.get(), this.f31437g.get());
    }
}
