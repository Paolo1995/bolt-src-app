package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.earnings.PayoutApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesPayoutApiFactory implements Factory<PayoutApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20345a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20346b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20347c;

    public AuthorisedNetworkModule_ProvidesPayoutApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20345a = authorisedNetworkModule;
        this.f20346b = provider;
        this.f20347c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesPayoutApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesPayoutApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static PayoutApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (PayoutApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.s(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutApi get() {
        return c(this.f20345a, this.f20346b.get(), this.f20347c.get());
    }
}
