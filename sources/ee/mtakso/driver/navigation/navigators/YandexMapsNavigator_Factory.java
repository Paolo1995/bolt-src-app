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
public final class YandexMapsNavigator_Factory implements Factory<YandexMapsNavigator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AppResolver> f21273a;

    public YandexMapsNavigator_Factory(Provider<AppResolver> provider) {
        this.f21273a = provider;
    }

    public static YandexMapsNavigator_Factory a(Provider<AppResolver> provider) {
        return new YandexMapsNavigator_Factory(provider);
    }

    public static YandexMapsNavigator c(AppResolver appResolver) {
        return new YandexMapsNavigator(appResolver);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public YandexMapsNavigator get() {
        return c(this.f21273a.get());
    }
}
