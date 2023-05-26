package ee.mtakso.driver.ui.interactor.search;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GetOrderDestinationSearchSuggestionInteractor_Factory implements Factory<GetOrderDestinationSearchSuggestionInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GetExternalSourceAddressInteractor> f26884a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverClient> f26885b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderProvider> f26886c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<GeoLocationManager> f26887d;

    public GetOrderDestinationSearchSuggestionInteractor_Factory(Provider<GetExternalSourceAddressInteractor> provider, Provider<DriverClient> provider2, Provider<OrderProvider> provider3, Provider<GeoLocationManager> provider4) {
        this.f26884a = provider;
        this.f26885b = provider2;
        this.f26886c = provider3;
        this.f26887d = provider4;
    }

    public static GetOrderDestinationSearchSuggestionInteractor_Factory a(Provider<GetExternalSourceAddressInteractor> provider, Provider<DriverClient> provider2, Provider<OrderProvider> provider3, Provider<GeoLocationManager> provider4) {
        return new GetOrderDestinationSearchSuggestionInteractor_Factory(provider, provider2, provider3, provider4);
    }

    public static GetOrderDestinationSearchSuggestionInteractor c(GetExternalSourceAddressInteractor getExternalSourceAddressInteractor, DriverClient driverClient, OrderProvider orderProvider, GeoLocationManager geoLocationManager) {
        return new GetOrderDestinationSearchSuggestionInteractor(getExternalSourceAddressInteractor, driverClient, orderProvider, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetOrderDestinationSearchSuggestionInteractor get() {
        return c(this.f26884a.get(), this.f26885b.get(), this.f26886c.get(), this.f26887d.get());
    }
}
