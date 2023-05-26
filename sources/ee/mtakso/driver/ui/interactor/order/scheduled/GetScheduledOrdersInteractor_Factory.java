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
public final class GetScheduledOrdersInteractor_Factory implements Factory<GetScheduledOrdersInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderClient> f26760a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScheduledOrderProvider> f26761b;

    public GetScheduledOrdersInteractor_Factory(Provider<OrderClient> provider, Provider<ScheduledOrderProvider> provider2) {
        this.f26760a = provider;
        this.f26761b = provider2;
    }

    public static GetScheduledOrdersInteractor_Factory a(Provider<OrderClient> provider, Provider<ScheduledOrderProvider> provider2) {
        return new GetScheduledOrdersInteractor_Factory(provider, provider2);
    }

    public static GetScheduledOrdersInteractor c(OrderClient orderClient, ScheduledOrderProvider scheduledOrderProvider) {
        return new GetScheduledOrdersInteractor(orderClient, scheduledOrderProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetScheduledOrdersInteractor get() {
        return c(this.f26760a.get(), this.f26761b.get());
    }
}
