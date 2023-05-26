package ee.mtakso.driver.ui.screens.order.arrived;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DrivePriceInteractor_Factory implements Factory<DrivePriceInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f30995a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderClient> f30996b;

    public DrivePriceInteractor_Factory(Provider<OrderProvider> provider, Provider<OrderClient> provider2) {
        this.f30995a = provider;
        this.f30996b = provider2;
    }

    public static DrivePriceInteractor_Factory a(Provider<OrderProvider> provider, Provider<OrderClient> provider2) {
        return new DrivePriceInteractor_Factory(provider, provider2);
    }

    public static DrivePriceInteractor c(OrderProvider orderProvider, OrderClient orderClient) {
        return new DrivePriceInteractor(orderProvider, orderClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DrivePriceInteractor get() {
        return c(this.f30995a.get(), this.f30996b.get());
    }
}
