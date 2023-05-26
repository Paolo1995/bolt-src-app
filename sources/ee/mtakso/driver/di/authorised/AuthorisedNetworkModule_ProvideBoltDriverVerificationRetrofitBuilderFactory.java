package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvideBoltDriverVerificationRetrofitBuilderFactory implements Factory<Retrofit.Builder> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20297a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20298b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20299c;

    public AuthorisedNetworkModule_ProvideBoltDriverVerificationRetrofitBuilderFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20297a = authorisedNetworkModule;
        this.f20298b = provider;
        this.f20299c = provider2;
    }

    public static AuthorisedNetworkModule_ProvideBoltDriverVerificationRetrofitBuilderFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvideBoltDriverVerificationRetrofitBuilderFactory(authorisedNetworkModule, provider, provider2);
    }

    public static Retrofit.Builder c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (Retrofit.Builder) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.c(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Retrofit.Builder get() {
        return c(this.f20297a, this.f20298b.get(), this.f20299c.get());
    }
}
