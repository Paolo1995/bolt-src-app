package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.campaign.CampaignApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesCampaignApiFactory implements Factory<CampaignApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20327a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20328b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20329c;

    public AuthorisedNetworkModule_ProvidesCampaignApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20327a = authorisedNetworkModule;
        this.f20328b = provider;
        this.f20329c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesCampaignApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesCampaignApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static CampaignApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (CampaignApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.m(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CampaignApi get() {
        return c(this.f20327a, this.f20328b.get(), this.f20329c.get());
    }
}
