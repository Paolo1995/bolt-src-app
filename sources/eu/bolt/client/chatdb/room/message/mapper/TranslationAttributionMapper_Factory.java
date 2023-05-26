package eu.bolt.client.chatdb.room.message.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class TranslationAttributionMapper_Factory implements Factory<TranslationAttributionMapper> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final TranslationAttributionMapper_Factory f39894a = new TranslationAttributionMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static TranslationAttributionMapper_Factory a() {
        return InstanceHolder.f39894a;
    }

    public static TranslationAttributionMapper c() {
        return new TranslationAttributionMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TranslationAttributionMapper get() {
        return c();
    }
}
