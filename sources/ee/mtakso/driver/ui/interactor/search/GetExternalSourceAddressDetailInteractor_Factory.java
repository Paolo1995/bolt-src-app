package ee.mtakso.driver.ui.interactor.search;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.geo.GeoClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GetExternalSourceAddressDetailInteractor_Factory implements Factory<GetExternalSourceAddressDetailInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoClient> f26867a;

    public GetExternalSourceAddressDetailInteractor_Factory(Provider<GeoClient> provider) {
        this.f26867a = provider;
    }

    public static GetExternalSourceAddressDetailInteractor_Factory a(Provider<GeoClient> provider) {
        return new GetExternalSourceAddressDetailInteractor_Factory(provider);
    }

    public static GetExternalSourceAddressDetailInteractor c(GeoClient geoClient) {
        return new GetExternalSourceAddressDetailInteractor(geoClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetExternalSourceAddressDetailInteractor get() {
        return c(this.f26867a.get());
    }
}
