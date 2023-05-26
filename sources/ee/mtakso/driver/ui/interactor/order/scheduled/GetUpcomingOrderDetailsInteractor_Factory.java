package ee.mtakso.driver.ui.interactor.order.scheduled;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.service.order.ScheduledOrderProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GetUpcomingOrderDetailsInteractor_Factory implements Factory<GetUpcomingOrderDetailsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderClient> f26767a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScheduledOrderProvider> f26768b;

    public GetUpcomingOrderDetailsInteractor_Factory(Provider<OrderClient> provider, Provider<ScheduledOrderProvider> provider2) {
        this.f26767a = provider;
        this.f26768b = provider2;
    }

    public static GetUpcomingOrderDetailsInteractor_Factory a(Provider<OrderClient> provider, Provider<ScheduledOrderProvider> provider2) {
        return new GetUpcomingOrderDetailsInteractor_Factory(provider, provider2);
    }

    public static GetUpcomingOrderDetailsInteractor c(OrderClient orderClient, ScheduledOrderProvider scheduledOrderProvider) {
        return new GetUpcomingOrderDetailsInteractor(orderClient, scheduledOrderProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetUpcomingOrderDetailsInteractor get() {
        return c(this.f26767a.get(), this.f26768b.get());
    }
}
