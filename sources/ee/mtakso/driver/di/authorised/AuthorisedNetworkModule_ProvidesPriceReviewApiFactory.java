package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.price.PriceReviewApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesPriceReviewApiFactory implements Factory<PriceReviewApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20348a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20349b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20350c;

    public AuthorisedNetworkModule_ProvidesPriceReviewApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20348a = authorisedNetworkModule;
        this.f20349b = provider;
        this.f20350c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesPriceReviewApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesPriceReviewApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static PriceReviewApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (PriceReviewApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.t(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PriceReviewApi get() {
        return c(this.f20348a, this.f20349b.get(), this.f20350c.get());
    }
}
