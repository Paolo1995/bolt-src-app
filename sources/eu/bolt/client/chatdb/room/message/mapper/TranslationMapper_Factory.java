package eu.bolt.client.chatdb.room.message.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class TranslationMapper_Factory implements Factory<TranslationMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TranslationAttributionMapper> f39896a;

    public TranslationMapper_Factory(Provider<TranslationAttributionMapper> provider) {
        this.f39896a = provider;
    }

    public static TranslationMapper_Factory a(Provider<TranslationAttributionMapper> provider) {
        return new TranslationMapper_Factory(provider);
    }

    public static TranslationMapper c(TranslationAttributionMapper translationAttributionMapper) {
        return new TranslationMapper(translationAttributionMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TranslationMapper get() {
        return c(this.f39896a.get());
    }
}
