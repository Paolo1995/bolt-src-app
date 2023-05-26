package ee.mtakso.driver.ui.screens.authenticate;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthenticateFragment_Factory implements Factory<AuthenticateFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27023a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppResolver> f27024b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PlatformManager> f27025c;

    public AuthenticateFragment_Factory(Provider<BaseUiDependencies> provider, Provider<AppResolver> provider2, Provider<PlatformManager> provider3) {
        this.f27023a = provider;
        this.f27024b = provider2;
        this.f27025c = provider3;
    }

    public static AuthenticateFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<AppResolver> provider2, Provider<PlatformManager> provider3) {
        return new AuthenticateFragment_Factory(provider, provider2, provider3);
    }

    public static AuthenticateFragment c(BaseUiDependencies baseUiDependencies, AppResolver appResolver, PlatformManager platformManager) {
        return new AuthenticateFragment(baseUiDependencies, appResolver, platformManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AuthenticateFragment get() {
        return c(this.f27023a.get(), this.f27024b.get(), this.f27025c.get());
    }
}
