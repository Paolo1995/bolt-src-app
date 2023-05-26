package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import eu.bolt.driver.chat.network.ChatApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesChatApiFactory implements Factory<ChatApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20828a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20829b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20830c;

    public NetworkModule_ProvidesChatApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20828a = networkModule;
        this.f20829b = provider;
        this.f20830c = provider2;
    }

    public static NetworkModule_ProvidesChatApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvidesChatApiFactory(networkModule, provider, provider2);
    }

    public static ChatApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (ChatApi) Preconditions.checkNotNullFromProvides(networkModule.w(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatApi get() {
        return c(this.f20828a, this.f20829b.get(), this.f20830c.get());
    }
}
