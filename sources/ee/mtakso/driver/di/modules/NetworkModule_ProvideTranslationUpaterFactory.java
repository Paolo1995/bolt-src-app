package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.translations.TranslationsClient;
import eu.bolt.driver.core.ui.translation.TranslationUpdateProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideTranslationUpaterFactory implements Factory<TranslationUpdateProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20815a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TranslationsClient> f20816b;

    public NetworkModule_ProvideTranslationUpaterFactory(NetworkModule networkModule, Provider<TranslationsClient> provider) {
        this.f20815a = networkModule;
        this.f20816b = provider;
    }

    public static NetworkModule_ProvideTranslationUpaterFactory a(NetworkModule networkModule, Provider<TranslationsClient> provider) {
        return new NetworkModule_ProvideTranslationUpaterFactory(networkModule, provider);
    }

    public static TranslationUpdateProvider c(NetworkModule networkModule, TranslationsClient translationsClient) {
        return (TranslationUpdateProvider) Preconditions.checkNotNullFromProvides(networkModule.r(translationsClient));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TranslationUpdateProvider get() {
        return c(this.f20815a, this.f20816b.get());
    }
}
