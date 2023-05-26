package ee.mtakso.driver.utils;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.model.DeviceInfo;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class UrlFactory_Factory implements Factory<UrlFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceInfo> f36337a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LanguageManager> f36338b;

    public UrlFactory_Factory(Provider<DeviceInfo> provider, Provider<LanguageManager> provider2) {
        this.f36337a = provider;
        this.f36338b = provider2;
    }

    public static UrlFactory_Factory a(Provider<DeviceInfo> provider, Provider<LanguageManager> provider2) {
        return new UrlFactory_Factory(provider, provider2);
    }

    public static UrlFactory c(DeviceInfo deviceInfo, LanguageManager languageManager) {
        return new UrlFactory(deviceInfo, languageManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public UrlFactory get() {
        return c(this.f36337a.get(), this.f36338b.get());
    }
}
