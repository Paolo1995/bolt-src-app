package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.search.SearchApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesSearchApiFactory implements Factory<SearchApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20354a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20355b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20356c;

    public AuthorisedNetworkModule_ProvidesSearchApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20354a = authorisedNetworkModule;
        this.f20355b = provider;
        this.f20356c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesSearchApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesSearchApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static SearchApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (SearchApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.v(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SearchApi get() {
        return c(this.f20354a, this.f20355b.get(), this.f20356c.get());
    }
}
