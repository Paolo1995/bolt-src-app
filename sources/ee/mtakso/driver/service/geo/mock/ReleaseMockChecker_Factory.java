package ee.mtakso.driver.service.geo.mock;

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
public final class ReleaseMockChecker_Factory implements Factory<ReleaseMockChecker> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f24418a;

    public ReleaseMockChecker_Factory(Provider<DriverProvider> provider) {
        this.f24418a = provider;
    }

    public static ReleaseMockChecker_Factory a(Provider<DriverProvider> provider) {
        return new ReleaseMockChecker_Factory(provider);
    }

    public static ReleaseMockChecker c(DriverProvider driverProvider) {
        return new ReleaseMockChecker(driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ReleaseMockChecker get() {
        return c(this.f24418a.get());
    }
}
