package ee.mtakso.driver.service.modules.surge;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SurgeManager_Factory implements Factory<SurgeManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f25301a;

    public SurgeManager_Factory(Provider<DriverProvider> provider) {
        this.f25301a = provider;
    }

    public static SurgeManager_Factory a(Provider<DriverProvider> provider) {
        return new SurgeManager_Factory(provider);
    }

    public static SurgeManager c(DriverProvider driverProvider) {
        return new SurgeManager(driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SurgeManager get() {
        return c(this.f25301a.get());
    }
}
