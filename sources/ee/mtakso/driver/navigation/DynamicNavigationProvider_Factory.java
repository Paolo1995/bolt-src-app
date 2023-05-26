package ee.mtakso.driver.navigation;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DynamicNavigationProvider_Factory implements Factory<DynamicNavigationProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f21198a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChromeCustomTabsUrlLauncher> f21199b;

    public DynamicNavigationProvider_Factory(Provider<Context> provider, Provider<ChromeCustomTabsUrlLauncher> provider2) {
        this.f21198a = provider;
        this.f21199b = provider2;
    }

    public static DynamicNavigationProvider_Factory a(Provider<Context> provider, Provider<ChromeCustomTabsUrlLauncher> provider2) {
        return new DynamicNavigationProvider_Factory(provider, provider2);
    }

    public static DynamicNavigationProvider c(Context context, ChromeCustomTabsUrlLauncher chromeCustomTabsUrlLauncher) {
        return new DynamicNavigationProvider(context, chromeCustomTabsUrlLauncher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DynamicNavigationProvider get() {
        return c(this.f21198a.get(), this.f21199b.get());
    }
}
