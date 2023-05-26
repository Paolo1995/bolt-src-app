package eu.bolt.driver.core.ui.translation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class RawTranslationProvider_Factory implements Factory<RawTranslationProvider> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final RawTranslationProvider_Factory f41186a = new RawTranslationProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static RawTranslationProvider_Factory a() {
        return InstanceHolder.f41186a;
    }

    public static RawTranslationProvider c() {
        return new RawTranslationProvider();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RawTranslationProvider get() {
        return c();
    }
}
