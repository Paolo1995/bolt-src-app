package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.geo.GeoApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesGeoApiFactory implements Factory<GeoApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20336a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20337b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20338c;

    public AuthorisedNetworkModule_ProvidesGeoApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20336a = authorisedNetworkModule;
        this.f20337b = provider;
        this.f20338c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesGeoApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesGeoApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static GeoApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (GeoApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.p(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GeoApi get() {
        return c(this.f20336a, this.f20337b.get(), this.f20338c.get());
    }
}
