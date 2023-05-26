package ee.mtakso.driver.ui.screens.login.v3.verification;

import androidx.fragment.app.FragmentFactory;
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
public final class VerificationV3Fragment_Factory implements Factory<VerificationV3Fragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f30797a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FragmentFactory> f30798b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppResolver> f30799c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PlatformManager> f30800d;

    public VerificationV3Fragment_Factory(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<AppResolver> provider3, Provider<PlatformManager> provider4) {
        this.f30797a = provider;
        this.f30798b = provider2;
        this.f30799c = provider3;
        this.f30800d = provider4;
    }

    public static VerificationV3Fragment_Factory a(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<AppResolver> provider3, Provider<PlatformManager> provider4) {
        return new VerificationV3Fragment_Factory(provider, provider2, provider3, provider4);
    }

    public static VerificationV3Fragment c(BaseUiDependencies baseUiDependencies, FragmentFactory fragmentFactory, AppResolver appResolver, PlatformManager platformManager) {
        return new VerificationV3Fragment(baseUiDependencies, fragmentFactory, appResolver, platformManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VerificationV3Fragment get() {
        return c(this.f30797a.get(), this.f30798b.get(), this.f30799c.get(), this.f30800d.get());
    }
}
