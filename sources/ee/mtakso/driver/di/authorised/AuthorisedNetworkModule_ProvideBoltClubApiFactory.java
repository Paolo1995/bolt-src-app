package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.boltclub.BoltClubApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvideBoltClubApiFactory implements Factory<BoltClubApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20294a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20295b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20296c;

    public AuthorisedNetworkModule_ProvideBoltClubApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20294a = authorisedNetworkModule;
        this.f20295b = provider;
        this.f20296c = provider2;
    }

    public static AuthorisedNetworkModule_ProvideBoltClubApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvideBoltClubApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static BoltClubApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (BoltClubApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.b(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BoltClubApi get() {
        return c(this.f20294a, this.f20295b.get(), this.f20296c.get());
    }
}
