package ee.mtakso.driver.utils;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class CompositeUrlLauncher_Factory implements Factory<CompositeUrlLauncher> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChromeCustomTabsUrlLauncher> f36302a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SystemUrlLauncher> f36303b;

    public CompositeUrlLauncher_Factory(Provider<ChromeCustomTabsUrlLauncher> provider, Provider<SystemUrlLauncher> provider2) {
        this.f36302a = provider;
        this.f36303b = provider2;
    }

    public static CompositeUrlLauncher_Factory a(Provider<ChromeCustomTabsUrlLauncher> provider, Provider<SystemUrlLauncher> provider2) {
        return new CompositeUrlLauncher_Factory(provider, provider2);
    }

    public static CompositeUrlLauncher c(ChromeCustomTabsUrlLauncher chromeCustomTabsUrlLauncher, SystemUrlLauncher systemUrlLauncher) {
        return new CompositeUrlLauncher(chromeCustomTabsUrlLauncher, systemUrlLauncher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CompositeUrlLauncher get() {
        return c(this.f36302a.get(), this.f36303b.get());
    }
}
