package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.voip.VoipApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvideVoipApiFactory implements Factory<VoipApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20321a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20322b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20323c;

    public AuthorisedNetworkModule_ProvideVoipApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20321a = authorisedNetworkModule;
        this.f20322b = provider;
        this.f20323c = provider2;
    }

    public static AuthorisedNetworkModule_ProvideVoipApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvideVoipApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static VoipApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (VoipApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.k(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipApi get() {
        return c(this.f20321a, this.f20322b.get(), this.f20323c.get());
    }
}
