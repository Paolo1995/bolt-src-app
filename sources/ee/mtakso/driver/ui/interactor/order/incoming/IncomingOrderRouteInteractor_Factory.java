package ee.mtakso.driver.ui.interactor.order.incoming;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.geo.route.RouteManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IncomingOrderRouteInteractor_Factory implements Factory<IncomingOrderRouteInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RouteManager> f26747a;

    public IncomingOrderRouteInteractor_Factory(Provider<RouteManager> provider) {
        this.f26747a = provider;
    }

    public static IncomingOrderRouteInteractor_Factory a(Provider<RouteManager> provider) {
        return new IncomingOrderRouteInteractor_Factory(provider);
    }

    public static IncomingOrderRouteInteractor c(RouteManager routeManager) {
        return new IncomingOrderRouteInteractor(routeManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncomingOrderRouteInteractor get() {
        return c(this.f26747a.get());
    }
}
