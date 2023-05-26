package eu.bolt.driver.core.ui.translation.language;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class LanguageManager_Factory implements Factory<LanguageManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LanguageListProvider> f41239a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LanguageSettingsStorage> f41240b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Context> f41241c;

    public LanguageManager_Factory(Provider<LanguageListProvider> provider, Provider<LanguageSettingsStorage> provider2, Provider<Context> provider3) {
        this.f41239a = provider;
        this.f41240b = provider2;
        this.f41241c = provider3;
    }

    public static LanguageManager_Factory a(Provider<LanguageListProvider> provider, Provider<LanguageSettingsStorage> provider2, Provider<Context> provider3) {
        return new LanguageManager_Factory(provider, provider2, provider3);
    }

    public static LanguageManager c(LanguageListProvider languageListProvider, LanguageSettingsStorage languageSettingsStorage, Context context) {
        return new LanguageManager(languageListProvider, languageSettingsStorage, context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LanguageManager get() {
        return c(this.f41239a.get(), this.f41240b.get(), this.f41241c.get());
    }
}
