package ee.mtakso.driver.ui.screens.order.lookup.orderdestination;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.interactor.search.GetExternalSourceAddressDetailInteractor;
import ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor;
import ee.mtakso.driver.ui.screens.destination.search.SearchSuggestionMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderDestinationViewModel_Factory implements Factory<OrderDestinationViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GetOrderDestinationSearchSuggestionInteractor> f31496a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<GetExternalSourceAddressDetailInteractor> f31497b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SearchSuggestionMapper> f31498c;

    public OrderDestinationViewModel_Factory(Provider<GetOrderDestinationSearchSuggestionInteractor> provider, Provider<GetExternalSourceAddressDetailInteractor> provider2, Provider<SearchSuggestionMapper> provider3) {
        this.f31496a = provider;
        this.f31497b = provider2;
        this.f31498c = provider3;
    }

    public static OrderDestinationViewModel_Factory a(Provider<GetOrderDestinationSearchSuggestionInteractor> provider, Provider<GetExternalSourceAddressDetailInteractor> provider2, Provider<SearchSuggestionMapper> provider3) {
        return new OrderDestinationViewModel_Factory(provider, provider2, provider3);
    }

    public static OrderDestinationViewModel c(GetOrderDestinationSearchSuggestionInteractor getOrderDestinationSearchSuggestionInteractor, GetExternalSourceAddressDetailInteractor getExternalSourceAddressDetailInteractor, SearchSuggestionMapper searchSuggestionMapper) {
        return new OrderDestinationViewModel(getOrderDestinationSearchSuggestionInteractor, getExternalSourceAddressDetailInteractor, searchSuggestionMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderDestinationViewModel get() {
        return c(this.f31496a.get(), this.f31497b.get(), this.f31498c.get());
    }
}
