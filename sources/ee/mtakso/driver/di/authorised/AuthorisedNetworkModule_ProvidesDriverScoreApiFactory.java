package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.score.DriverScoreApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesDriverScoreApiFactory implements Factory<DriverScoreApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20333a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20334b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20335c;

    public AuthorisedNetworkModule_ProvidesDriverScoreApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20333a = authorisedNetworkModule;
        this.f20334b = provider;
        this.f20335c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesDriverScoreApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesDriverScoreApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static DriverScoreApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (DriverScoreApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.o(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverScoreApi get() {
        return c(this.f20333a, this.f20334b.get(), this.f20335c.get());
    }
}
