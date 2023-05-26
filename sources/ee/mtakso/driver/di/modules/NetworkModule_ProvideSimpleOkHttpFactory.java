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
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Simple"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideSimpleOkHttpFactory implements Factory<OkHttpClient> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20812a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ClientFactory> f20813b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OkHttpClient> f20814c;

    public NetworkModule_ProvideSimpleOkHttpFactory(NetworkModule networkModule, Provider<ClientFactory> provider, Provider<OkHttpClient> provider2) {
        this.f20812a = networkModule;
        this.f20813b = provider;
        this.f20814c = provider2;
    }

    public static NetworkModule_ProvideSimpleOkHttpFactory a(NetworkModule networkModule, Provider<ClientFactory> provider, Provider<OkHttpClient> provider2) {
        return new NetworkModule_ProvideSimpleOkHttpFactory(networkModule, provider, provider2);
    }

    public static OkHttpClient c(NetworkModule networkModule, ClientFactory clientFactory, OkHttpClient okHttpClient) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(networkModule.q(clientFactory, okHttpClient));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OkHttpClient get() {
        return c(this.f20812a, this.f20813b.get(), this.f20814c.get());
    }
}
