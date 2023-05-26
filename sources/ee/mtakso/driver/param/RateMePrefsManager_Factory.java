package ee.mtakso.driver.param;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RateMePrefsManager_Factory implements Factory<RateMePrefsManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f23233a;

    public RateMePrefsManager_Factory(Provider<DriverProvider> provider) {
        this.f23233a = provider;
    }

    public static RateMePrefsManager_Factory a(Provider<DriverProvider> provider) {
        return new RateMePrefsManager_Factory(provider);
    }

    public static RateMePrefsManager c(DriverProvider driverProvider) {
        return new RateMePrefsManager(driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RateMePrefsManager get() {
        return c(this.f23233a.get());
    }
}
