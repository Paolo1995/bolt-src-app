package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import eu.bolt.driver.stories.network.StoriesApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesStoriesApiFactory implements Factory<StoriesApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20357a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20358b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20359c;

    public AuthorisedNetworkModule_ProvidesStoriesApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20357a = authorisedNetworkModule;
        this.f20358b = provider;
        this.f20359c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesStoriesApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesStoriesApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static StoriesApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (StoriesApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.w(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StoriesApi get() {
        return c(this.f20357a, this.f20358b.get(), this.f20359c.get());
    }
}
