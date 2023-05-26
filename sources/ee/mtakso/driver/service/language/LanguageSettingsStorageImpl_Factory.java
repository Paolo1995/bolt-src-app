package ee.mtakso.driver.service.language;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LanguageSettingsStorageImpl_Factory implements Factory<LanguageSettingsStorageImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f24593a;

    public LanguageSettingsStorageImpl_Factory(Provider<DriverProvider> provider) {
        this.f24593a = provider;
    }

    public static LanguageSettingsStorageImpl_Factory a(Provider<DriverProvider> provider) {
        return new LanguageSettingsStorageImpl_Factory(provider);
    }

    public static LanguageSettingsStorageImpl c(DriverProvider driverProvider) {
        return new LanguageSettingsStorageImpl(driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LanguageSettingsStorageImpl get() {
        return c(this.f24593a.get());
    }
}
