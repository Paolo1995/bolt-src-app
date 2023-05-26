package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.support.SupportApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesFindSolutionApiFactory implements Factory<SupportApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20840a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20841b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20842c;

    public NetworkModule_ProvidesFindSolutionApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20840a = networkModule;
        this.f20841b = provider;
        this.f20842c = provider2;
    }

    public static NetworkModule_ProvidesFindSolutionApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvidesFindSolutionApiFactory(networkModule, provider, provider2);
    }

    public static SupportApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (SupportApi) Preconditions.checkNotNullFromProvides(networkModule.A(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SupportApi get() {
        return c(this.f20840a, this.f20841b.get(), this.f20842c.get());
    }
}
