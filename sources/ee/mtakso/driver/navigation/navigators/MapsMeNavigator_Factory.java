package ee.mtakso.driver.navigation.navigators;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MapsMeNavigator_Factory implements Factory<MapsMeNavigator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AppResolver> f21235a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Features> f21236b;

    public MapsMeNavigator_Factory(Provider<AppResolver> provider, Provider<Features> provider2) {
        this.f21235a = provider;
        this.f21236b = provider2;
    }

    public static MapsMeNavigator_Factory a(Provider<AppResolver> provider, Provider<Features> provider2) {
        return new MapsMeNavigator_Factory(provider, provider2);
    }

    public static MapsMeNavigator c(AppResolver appResolver, Features features) {
        return new MapsMeNavigator(appResolver, features);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MapsMeNavigator get() {
        return c(this.f21235a.get(), this.f21236b.get());
    }
}
