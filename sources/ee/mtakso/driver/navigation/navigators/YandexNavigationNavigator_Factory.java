package ee.mtakso.driver.navigation.navigators;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class YandexNavigationNavigator_Factory implements Factory<YandexNavigationNavigator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f21280a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChromeCustomTabsUrlLauncher> f21281b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppResolver> f21282c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Features> f21283d;

    public YandexNavigationNavigator_Factory(Provider<Context> provider, Provider<ChromeCustomTabsUrlLauncher> provider2, Provider<AppResolver> provider3, Provider<Features> provider4) {
        this.f21280a = provider;
        this.f21281b = provider2;
        this.f21282c = provider3;
        this.f21283d = provider4;
    }

    public static YandexNavigationNavigator_Factory a(Provider<Context> provider, Provider<ChromeCustomTabsUrlLauncher> provider2, Provider<AppResolver> provider3, Provider<Features> provider4) {
        return new YandexNavigationNavigator_Factory(provider, provider2, provider3, provider4);
    }

    public static YandexNavigationNavigator c(Context context, ChromeCustomTabsUrlLauncher chromeCustomTabsUrlLauncher, AppResolver appResolver, Features features) {
        return new YandexNavigationNavigator(context, chromeCustomTabsUrlLauncher, appResolver, features);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public YandexNavigationNavigator get() {
        return c(this.f21280a.get(), this.f21281b.get(), this.f21282c.get(), this.f21283d.get());
    }
}
