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
public final class GetExternalSourceAddressInteractor_Factory implements Factory<GetExternalSourceAddressInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoClient> f26870a;

    public GetExternalSourceAddressInteractor_Factory(Provider<GeoClient> provider) {
        this.f26870a = provider;
    }

    public static GetExternalSourceAddressInteractor_Factory a(Provider<GeoClient> provider) {
        return new GetExternalSourceAddressInteractor_Factory(provider);
    }

    public static GetExternalSourceAddressInteractor c(GeoClient geoClient) {
        return new GetExternalSourceAddressInteractor(geoClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetExternalSourceAddressInteractor get() {
        return c(this.f26870a.get());
    }
}
