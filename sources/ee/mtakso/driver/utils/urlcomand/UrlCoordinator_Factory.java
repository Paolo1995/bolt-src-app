package ee.mtakso.driver.utils.urlcomand;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import ee.mtakso.driver.utils.customtabs.CustomTabsUrlLauncher;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class UrlCoordinator_Factory implements Factory<UrlCoordinator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CustomTabsUrlLauncher> f36480a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SystemUrlLauncher> f36481b;

    public UrlCoordinator_Factory(Provider<CustomTabsUrlLauncher> provider, Provider<SystemUrlLauncher> provider2) {
        this.f36480a = provider;
        this.f36481b = provider2;
    }

    public static UrlCoordinator_Factory a(Provider<CustomTabsUrlLauncher> provider, Provider<SystemUrlLauncher> provider2) {
        return new UrlCoordinator_Factory(provider, provider2);
    }

    public static UrlCoordinator c(CustomTabsUrlLauncher customTabsUrlLauncher, SystemUrlLauncher systemUrlLauncher) {
        return new UrlCoordinator(customTabsUrlLauncher, systemUrlLauncher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public UrlCoordinator get() {
        return c(this.f36480a.get(), this.f36481b.get());
    }
}
