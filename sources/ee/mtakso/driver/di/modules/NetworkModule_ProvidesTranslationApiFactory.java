package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.translations.TranslationApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Simple"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesTranslationApiFactory implements Factory<TranslationApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20851a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20852b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20853c;

    public NetworkModule_ProvidesTranslationApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20851a = networkModule;
        this.f20852b = provider;
        this.f20853c = provider2;
    }

    public static NetworkModule_ProvidesTranslationApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvidesTranslationApiFactory(networkModule, provider, provider2);
    }

    public static TranslationApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (TranslationApi) Preconditions.checkNotNullFromProvides(networkModule.E(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TranslationApi get() {
        return c(this.f20851a, this.f20852b.get(), this.f20853c.get());
    }
}
