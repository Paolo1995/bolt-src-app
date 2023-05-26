package ee.mtakso.driver.ui.screens.order.incoming.v2;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class IncomingOrderFragment_Factory implements Factory<IncomingOrderFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f31386a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderTracker> f31387b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f31388c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<FragmentFactory> f31389d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<IncomingOrderSoundController> f31390e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<HtmlEngine> f31391f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<UiNotificationManager> f31392g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DriverProvider> f31393h;

    public IncomingOrderFragment_Factory(Provider<BaseUiDependencies> provider, Provider<OrderTracker> provider2, Provider<TrueTimeProvider> provider3, Provider<FragmentFactory> provider4, Provider<IncomingOrderSoundController> provider5, Provider<HtmlEngine> provider6, Provider<UiNotificationManager> provider7, Provider<DriverProvider> provider8) {
        this.f31386a = provider;
        this.f31387b = provider2;
        this.f31388c = provider3;
        this.f31389d = provider4;
        this.f31390e = provider5;
        this.f31391f = provider6;
        this.f31392g = provider7;
        this.f31393h = provider8;
    }

    public static IncomingOrderFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<OrderTracker> provider2, Provider<TrueTimeProvider> provider3, Provider<FragmentFactory> provider4, Provider<IncomingOrderSoundController> provider5, Provider<HtmlEngine> provider6, Provider<UiNotificationManager> provider7, Provider<DriverProvider> provider8) {
        return new IncomingOrderFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static IncomingOrderFragment c(BaseUiDependencies baseUiDependencies, OrderTracker orderTracker, TrueTimeProvider trueTimeProvider, FragmentFactory fragmentFactory, IncomingOrderSoundController incomingOrderSoundController, HtmlEngine htmlEngine, UiNotificationManager uiNotificationManager, DriverProvider driverProvider) {
        return new IncomingOrderFragment(baseUiDependencies, orderTracker, trueTimeProvider, fragmentFactory, incomingOrderSoundController, htmlEngine, uiNotificationManager, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncomingOrderFragment get() {
        return c(this.f31386a.get(), this.f31387b.get(), this.f31388c.get(), this.f31389d.get(), this.f31390e.get(), this.f31391f.get(), this.f31392g.get(), this.f31393h.get());
    }
}
