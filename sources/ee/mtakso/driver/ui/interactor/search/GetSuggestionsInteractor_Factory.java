package ee.mtakso.driver.ui.interactor.search;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GetSuggestionsInteractor_Factory implements Factory<GetSuggestionsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoLocationManager> f26894a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<GetExternalSourceAddressInteractor> f26895b;

    public GetSuggestionsInteractor_Factory(Provider<GeoLocationManager> provider, Provider<GetExternalSourceAddressInteractor> provider2) {
        this.f26894a = provider;
        this.f26895b = provider2;
    }

    public static GetSuggestionsInteractor_Factory a(Provider<GeoLocationManager> provider, Provider<GetExternalSourceAddressInteractor> provider2) {
        return new GetSuggestionsInteractor_Factory(provider, provider2);
    }

    public static GetSuggestionsInteractor c(GeoLocationManager geoLocationManager, GetExternalSourceAddressInteractor getExternalSourceAddressInteractor) {
        return new GetSuggestionsInteractor(geoLocationManager, getExternalSourceAddressInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetSuggestionsInteractor get() {
        return c(this.f26894a.get(), this.f26895b.get());
    }
}
