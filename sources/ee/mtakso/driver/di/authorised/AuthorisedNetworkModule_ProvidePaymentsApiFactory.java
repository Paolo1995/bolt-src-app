package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.payments.EarningsPaymentApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidePaymentsApiFactory implements Factory<EarningsPaymentApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20315a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20316b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20317c;

    public AuthorisedNetworkModule_ProvidePaymentsApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20315a = authorisedNetworkModule;
        this.f20316b = provider;
        this.f20317c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidePaymentsApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidePaymentsApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static EarningsPaymentApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (EarningsPaymentApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.i(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsPaymentApi get() {
        return c(this.f20315a, this.f20316b.get(), this.f20317c.get());
    }
}
