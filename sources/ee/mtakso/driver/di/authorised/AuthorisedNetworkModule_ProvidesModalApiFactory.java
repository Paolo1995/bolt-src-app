package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.modal.ModalApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesModalApiFactory implements Factory<ModalApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20342a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20343b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20344c;

    public AuthorisedNetworkModule_ProvidesModalApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20342a = authorisedNetworkModule;
        this.f20343b = provider;
        this.f20344c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesModalApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesModalApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static ModalApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (ModalApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.r(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ModalApi get() {
        return c(this.f20342a, this.f20343b.get(), this.f20344c.get());
    }
}
