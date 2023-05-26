package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.campaign.CircleKApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesCircleKApiFactory implements Factory<CircleKApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20330a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20331b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20332c;

    public AuthorisedNetworkModule_ProvidesCircleKApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20330a = authorisedNetworkModule;
        this.f20331b = provider;
        this.f20332c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesCircleKApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesCircleKApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static CircleKApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (CircleKApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.n(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CircleKApi get() {
        return c(this.f20330a, this.f20331b.get(), this.f20332c.get());
    }
}
