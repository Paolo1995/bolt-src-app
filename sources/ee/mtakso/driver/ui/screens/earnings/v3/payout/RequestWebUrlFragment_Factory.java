package ee.mtakso.driver.ui.screens.earnings.v3.payout;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class RequestWebUrlFragment_Factory implements Factory<RequestWebUrlFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f29416a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChromeCustomTabsUrlLauncher> f29417b;

    public RequestWebUrlFragment_Factory(Provider<BaseUiDependencies> provider, Provider<ChromeCustomTabsUrlLauncher> provider2) {
        this.f29416a = provider;
        this.f29417b = provider2;
    }

    public static RequestWebUrlFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<ChromeCustomTabsUrlLauncher> provider2) {
        return new RequestWebUrlFragment_Factory(provider, provider2);
    }

    public static RequestWebUrlFragment c(BaseUiDependencies baseUiDependencies, ChromeCustomTabsUrlLauncher chromeCustomTabsUrlLauncher) {
        return new RequestWebUrlFragment(baseUiDependencies, chromeCustomTabsUrlLauncher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RequestWebUrlFragment get() {
        return c(this.f29416a.get(), this.f29417b.get());
    }
}
