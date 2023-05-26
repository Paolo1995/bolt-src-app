package ee.mtakso.driver.ui.screens.order.v2.order;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderDistanceInteractor_Factory implements Factory<OrderDistanceInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UpcomingStopDistanceService> f32264a;

    public OrderDistanceInteractor_Factory(Provider<UpcomingStopDistanceService> provider) {
        this.f32264a = provider;
    }

    public static OrderDistanceInteractor_Factory a(Provider<UpcomingStopDistanceService> provider) {
        return new OrderDistanceInteractor_Factory(provider);
    }

    public static OrderDistanceInteractor c(UpcomingStopDistanceService upcomingStopDistanceService) {
        return new OrderDistanceInteractor(upcomingStopDistanceService);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderDistanceInteractor get() {
        return c(this.f32264a.get());
    }
}
