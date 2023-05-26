package ee.mtakso.driver.navigation.navigators;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TwoGisNavigator_Factory implements Factory<TwoGisNavigator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f21263a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppResolver> f21264b;

    public TwoGisNavigator_Factory(Provider<DriverProvider> provider, Provider<AppResolver> provider2) {
        this.f21263a = provider;
        this.f21264b = provider2;
    }

    public static TwoGisNavigator_Factory a(Provider<DriverProvider> provider, Provider<AppResolver> provider2) {
        return new TwoGisNavigator_Factory(provider, provider2);
    }

    public static TwoGisNavigator c(DriverProvider driverProvider, AppResolver appResolver) {
        return new TwoGisNavigator(driverProvider, appResolver);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TwoGisNavigator get() {
        return c(this.f21263a.get(), this.f21264b.get());
    }
}
