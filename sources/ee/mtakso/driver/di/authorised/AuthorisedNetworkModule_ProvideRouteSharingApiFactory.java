package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.route_sharing.RouteSharingApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvideRouteSharingApiFactory implements Factory<RouteSharingApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20318a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20319b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20320c;

    public AuthorisedNetworkModule_ProvideRouteSharingApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20318a = authorisedNetworkModule;
        this.f20319b = provider;
        this.f20320c = provider2;
    }

    public static AuthorisedNetworkModule_ProvideRouteSharingApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvideRouteSharingApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static RouteSharingApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (RouteSharingApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.j(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RouteSharingApi get() {
        return c(this.f20318a, this.f20319b.get(), this.f20320c.get());
    }
}
