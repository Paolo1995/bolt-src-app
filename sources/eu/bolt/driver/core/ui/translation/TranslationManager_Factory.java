package eu.bolt.driver.core.ui.translation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class TranslationManager_Factory implements Factory<TranslationManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TranslationUpdateProvider> f41213a;

    public TranslationManager_Factory(Provider<TranslationUpdateProvider> provider) {
        this.f41213a = provider;
    }

    public static TranslationManager_Factory a(Provider<TranslationUpdateProvider> provider) {
        return new TranslationManager_Factory(provider);
    }

    public static TranslationManager c(TranslationUpdateProvider translationUpdateProvider) {
        return new TranslationManager(translationUpdateProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TranslationManager get() {
        return c(this.f41213a.get());
    }
}
