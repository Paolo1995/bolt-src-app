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
public final class CompositeChromeFirstUrlLauncher_Factory implements Factory<CompositeChromeFirstUrlLauncher> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SystemUrlLauncher> f36298a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChromeUrlLauncher> f36299b;

    public CompositeChromeFirstUrlLauncher_Factory(Provider<SystemUrlLauncher> provider, Provider<ChromeUrlLauncher> provider2) {
        this.f36298a = provider;
        this.f36299b = provider2;
    }

    public static CompositeChromeFirstUrlLauncher_Factory a(Provider<SystemUrlLauncher> provider, Provider<ChromeUrlLauncher> provider2) {
        return new CompositeChromeFirstUrlLauncher_Factory(provider, provider2);
    }

    public static CompositeChromeFirstUrlLauncher c(SystemUrlLauncher systemUrlLauncher, ChromeUrlLauncher chromeUrlLauncher) {
        return new CompositeChromeFirstUrlLauncher(systemUrlLauncher, chromeUrlLauncher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CompositeChromeFirstUrlLauncher get() {
        return c(this.f36298a.get(), this.f36299b.get());
    }
}
