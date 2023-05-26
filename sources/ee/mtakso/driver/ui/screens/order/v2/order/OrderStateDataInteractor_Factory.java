package ee.mtakso.driver.ui.screens.order.v2.order;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.b2b.B2bManager;
import ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import eu.bolt.driver.core.time.AnchoredTimeSource;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderStateDataInteractor_Factory implements Factory<OrderStateDataInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f32299a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderProvider> f32300b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f32301c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f32302d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverFeatures> f32303e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<Features> f32304f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<B2bManager> f32305g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<UpcomingStopDistanceService> f32306h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<AnchoredTimeSource> f32307i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<NavigationAppTypeFactory> f32308j;

    public OrderStateDataInteractor_Factory(Provider<Context> provider, Provider<OrderProvider> provider2, Provider<DriverProvider> provider3, Provider<DriverDestinationsManager> provider4, Provider<DriverFeatures> provider5, Provider<Features> provider6, Provider<B2bManager> provider7, Provider<UpcomingStopDistanceService> provider8, Provider<AnchoredTimeSource> provider9, Provider<NavigationAppTypeFactory> provider10) {
        this.f32299a = provider;
        this.f32300b = provider2;
        this.f32301c = provider3;
        this.f32302d = provider4;
        this.f32303e = provider5;
        this.f32304f = provider6;
        this.f32305g = provider7;
        this.f32306h = provider8;
        this.f32307i = provider9;
        this.f32308j = provider10;
    }

    public static OrderStateDataInteractor_Factory a(Provider<Context> provider, Provider<OrderProvider> provider2, Provider<DriverProvider> provider3, Provider<DriverDestinationsManager> provider4, Provider<DriverFeatures> provider5, Provider<Features> provider6, Provider<B2bManager> provider7, Provider<UpcomingStopDistanceService> provider8, Provider<AnchoredTimeSource> provider9, Provider<NavigationAppTypeFactory> provider10) {
        return new OrderStateDataInteractor_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static OrderStateDataInteractor c(Context context, OrderProvider orderProvider, DriverProvider driverProvider, DriverDestinationsManager driverDestinationsManager, DriverFeatures driverFeatures, Features features, B2bManager b2bManager, UpcomingStopDistanceService upcomingStopDistanceService, AnchoredTimeSource anchoredTimeSource, NavigationAppTypeFactory navigationAppTypeFactory) {
        return new OrderStateDataInteractor(context, orderProvider, driverProvider, driverDestinationsManager, driverFeatures, features, b2bManager, upcomingStopDistanceService, anchoredTimeSource, navigationAppTypeFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderStateDataInteractor get() {
        return c(this.f32299a.get(), this.f32300b.get(), this.f32301c.get(), this.f32302d.get(), this.f32303e.get(), this.f32304f.get(), this.f32305g.get(), this.f32306h.get(), this.f32307i.get(), this.f32308j.get());
    }
}
