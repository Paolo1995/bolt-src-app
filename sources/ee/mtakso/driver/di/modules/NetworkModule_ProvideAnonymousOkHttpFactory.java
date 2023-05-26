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
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Unauthorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideAnonymousOkHttpFactory implements Factory<OkHttpClient> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20766a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ClientFactory> f20767b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OkHttpClient> f20768c;

    public NetworkModule_ProvideAnonymousOkHttpFactory(NetworkModule networkModule, Provider<ClientFactory> provider, Provider<OkHttpClient> provider2) {
        this.f20766a = networkModule;
        this.f20767b = provider;
        this.f20768c = provider2;
    }

    public static NetworkModule_ProvideAnonymousOkHttpFactory a(NetworkModule networkModule, Provider<ClientFactory> provider, Provider<OkHttpClient> provider2) {
        return new NetworkModule_ProvideAnonymousOkHttpFactory(networkModule, provider, provider2);
    }

    public static OkHttpClient c(NetworkModule networkModule, ClientFactory clientFactory, OkHttpClient okHttpClient) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(networkModule.a(clientFactory, okHttpClient));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OkHttpClient get() {
        return c(this.f20766a, this.f20767b.get(), this.f20768c.get());
    }
}
