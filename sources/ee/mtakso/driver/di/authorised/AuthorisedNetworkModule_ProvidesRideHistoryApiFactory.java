package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.order.RideHistoryApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesRideHistoryApiFactory implements Factory<RideHistoryApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20351a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20352b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20353c;

    public AuthorisedNetworkModule_ProvidesRideHistoryApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20351a = authorisedNetworkModule;
        this.f20352b = provider;
        this.f20353c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesRideHistoryApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesRideHistoryApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static RideHistoryApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (RideHistoryApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.u(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RideHistoryApi get() {
        return c(this.f20351a, this.f20352b.get(), this.f20353c.get());
    }
}
