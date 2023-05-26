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
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Applog"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideApplogOkHttpFactory implements Factory<OkHttpClient> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20769a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ClientFactory> f20770b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OkHttpClient> f20771c;

    public NetworkModule_ProvideApplogOkHttpFactory(NetworkModule networkModule, Provider<ClientFactory> provider, Provider<OkHttpClient> provider2) {
        this.f20769a = networkModule;
        this.f20770b = provider;
        this.f20771c = provider2;
    }

    public static NetworkModule_ProvideApplogOkHttpFactory a(NetworkModule networkModule, Provider<ClientFactory> provider, Provider<OkHttpClient> provider2) {
        return new NetworkModule_ProvideApplogOkHttpFactory(networkModule, provider, provider2);
    }

    public static OkHttpClient c(NetworkModule networkModule, ClientFactory clientFactory, OkHttpClient okHttpClient) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(networkModule.b(clientFactory, okHttpClient));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OkHttpClient get() {
        return c(this.f20769a, this.f20770b.get(), this.f20771c.get());
    }
}
