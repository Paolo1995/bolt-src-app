package ee.mtakso.driver.navigation.navigators;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CityGuideNavigator_Factory implements Factory<CityGuideNavigator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AppResolver> f21218a;

    public CityGuideNavigator_Factory(Provider<AppResolver> provider) {
        this.f21218a = provider;
    }

    public static CityGuideNavigator_Factory a(Provider<AppResolver> provider) {
        return new CityGuideNavigator_Factory(provider);
    }

    public static CityGuideNavigator c(AppResolver appResolver) {
        return new CityGuideNavigator(appResolver);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CityGuideNavigator get() {
        return c(this.f21218a.get());
    }
}
