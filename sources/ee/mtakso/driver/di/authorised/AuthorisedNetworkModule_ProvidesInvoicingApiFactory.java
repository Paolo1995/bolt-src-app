package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.earnings.EarningsApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesInvoicingApiFactory implements Factory<EarningsApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20339a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20340b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20341c;

    public AuthorisedNetworkModule_ProvidesInvoicingApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20339a = authorisedNetworkModule;
        this.f20340b = provider;
        this.f20341c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesInvoicingApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesInvoicingApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static EarningsApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (EarningsApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.q(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsApi get() {
        return c(this.f20339a, this.f20340b.get(), this.f20341c.get());
    }
}
