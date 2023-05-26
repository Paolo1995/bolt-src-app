package ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.price.PriceReviewClient;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ChoosePriceReviewViewModel_Factory implements Factory<ChoosePriceReviewViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f31116a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PriceReviewClient> f31117b;

    public ChoosePriceReviewViewModel_Factory(Provider<OrderProvider> provider, Provider<PriceReviewClient> provider2) {
        this.f31116a = provider;
        this.f31117b = provider2;
    }

    public static ChoosePriceReviewViewModel_Factory a(Provider<OrderProvider> provider, Provider<PriceReviewClient> provider2) {
        return new ChoosePriceReviewViewModel_Factory(provider, provider2);
    }

    public static ChoosePriceReviewViewModel c(OrderProvider orderProvider, PriceReviewClient priceReviewClient) {
        return new ChoosePriceReviewViewModel(orderProvider, priceReviewClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChoosePriceReviewViewModel get() {
        return c(this.f31116a.get(), this.f31117b.get());
    }
}
