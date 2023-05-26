package ee.mtakso.driver.ui.screens.order.v2.order;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AutoAcceptedOrderInteractor_Factory implements Factory<AutoAcceptedOrderInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f32174a;

    public AutoAcceptedOrderInteractor_Factory(Provider<OrderProvider> provider) {
        this.f32174a = provider;
    }

    public static AutoAcceptedOrderInteractor_Factory a(Provider<OrderProvider> provider) {
        return new AutoAcceptedOrderInteractor_Factory(provider);
    }

    public static AutoAcceptedOrderInteractor c(OrderProvider orderProvider) {
        return new AutoAcceptedOrderInteractor(orderProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AutoAcceptedOrderInteractor get() {
        return c(this.f32174a.get());
    }
}
