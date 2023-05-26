package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.ui.translation.RawTranslationProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WaitingTimeTranslationProvider_Factory implements Factory<WaitingTimeTranslationProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RawTranslationProvider> f30258a;

    public WaitingTimeTranslationProvider_Factory(Provider<RawTranslationProvider> provider) {
        this.f30258a = provider;
    }

    public static WaitingTimeTranslationProvider_Factory a(Provider<RawTranslationProvider> provider) {
        return new WaitingTimeTranslationProvider_Factory(provider);
    }

    public static WaitingTimeTranslationProvider c(RawTranslationProvider rawTranslationProvider) {
        return new WaitingTimeTranslationProvider(rawTranslationProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WaitingTimeTranslationProvider get() {
        return c(this.f30258a.get());
    }
}
