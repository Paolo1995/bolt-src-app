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
public final class GetAcceptedOrdersInteractor_Factory implements Factory<GetAcceptedOrdersInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderClient> f26755a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScheduledOrderProvider> f26756b;

    public GetAcceptedOrdersInteractor_Factory(Provider<OrderClient> provider, Provider<ScheduledOrderProvider> provider2) {
        this.f26755a = provider;
        this.f26756b = provider2;
    }

    public static GetAcceptedOrdersInteractor_Factory a(Provider<OrderClient> provider, Provider<ScheduledOrderProvider> provider2) {
        return new GetAcceptedOrdersInteractor_Factory(provider, provider2);
    }

    public static GetAcceptedOrdersInteractor c(OrderClient orderClient, ScheduledOrderProvider scheduledOrderProvider) {
        return new GetAcceptedOrdersInteractor(orderClient, scheduledOrderProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetAcceptedOrdersInteractor get() {
        return c(this.f26755a.get(), this.f26756b.get());
    }
}
