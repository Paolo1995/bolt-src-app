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
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.UploadUnauthorised"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideUploadAudioOkHttpFactory implements Factory<OkHttpClient> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20817a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ClientFactory> f20818b;

    public NetworkModule_ProvideUploadAudioOkHttpFactory(NetworkModule networkModule, Provider<ClientFactory> provider) {
        this.f20817a = networkModule;
        this.f20818b = provider;
    }

    public static NetworkModule_ProvideUploadAudioOkHttpFactory a(NetworkModule networkModule, Provider<ClientFactory> provider) {
        return new NetworkModule_ProvideUploadAudioOkHttpFactory(networkModule, provider);
    }

    public static OkHttpClient c(NetworkModule networkModule, ClientFactory clientFactory) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(networkModule.s(clientFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OkHttpClient get() {
        return c(this.f20817a, this.f20818b.get());
    }
}
