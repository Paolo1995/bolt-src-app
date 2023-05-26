package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.training.TrainingApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvidesTrainingApiFactory implements Factory<TrainingApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20360a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20361b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20362c;

    public AuthorisedNetworkModule_ProvidesTrainingApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20360a = authorisedNetworkModule;
        this.f20361b = provider;
        this.f20362c = provider2;
    }

    public static AuthorisedNetworkModule_ProvidesTrainingApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvidesTrainingApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static TrainingApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (TrainingApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.x(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TrainingApi get() {
        return c(this.f20360a, this.f20361b.get(), this.f20362c.get());
    }
}
