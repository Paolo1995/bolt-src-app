package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.ClientFactory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ReleaseNetworkModule_ProvideReleaseBaseNetworkClientFactory implements Factory<OkHttpClient> {

    /* renamed from: a  reason: collision with root package name */
    private final ReleaseNetworkModule f20869a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ClientFactory> f20870b;

    public ReleaseNetworkModule_ProvideReleaseBaseNetworkClientFactory(ReleaseNetworkModule releaseNetworkModule, Provider<ClientFactory> provider) {
        this.f20869a = releaseNetworkModule;
        this.f20870b = provider;
    }

    public static ReleaseNetworkModule_ProvideReleaseBaseNetworkClientFactory a(ReleaseNetworkModule releaseNetworkModule, Provider<ClientFactory> provider) {
        return new ReleaseNetworkModule_ProvideReleaseBaseNetworkClientFactory(releaseNetworkModule, provider);
    }

    public static OkHttpClient c(ReleaseNetworkModule releaseNetworkModule, ClientFactory clientFactory) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(releaseNetworkModule.a(clientFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OkHttpClient get() {
        return c(this.f20869a, this.f20870b.get());
    }
}
