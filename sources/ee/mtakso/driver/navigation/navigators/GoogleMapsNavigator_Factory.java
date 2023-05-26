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
public final class GoogleMapsNavigator_Factory implements Factory<GoogleMapsNavigator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AppResolver> f21229a;

    public GoogleMapsNavigator_Factory(Provider<AppResolver> provider) {
        this.f21229a = provider;
    }

    public static GoogleMapsNavigator_Factory a(Provider<AppResolver> provider) {
        return new GoogleMapsNavigator_Factory(provider);
    }

    public static GoogleMapsNavigator c(AppResolver appResolver) {
        return new GoogleMapsNavigator(appResolver);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GoogleMapsNavigator get() {
        return c(this.f21229a.get());
    }
}
