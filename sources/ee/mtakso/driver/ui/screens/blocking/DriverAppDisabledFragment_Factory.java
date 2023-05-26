package ee.mtakso.driver.ui.screens.blocking;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class DriverAppDisabledFragment_Factory implements Factory<DriverAppDisabledFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27062a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PlatformManager> f27063b;

    public DriverAppDisabledFragment_Factory(Provider<BaseUiDependencies> provider, Provider<PlatformManager> provider2) {
        this.f27062a = provider;
        this.f27063b = provider2;
    }

    public static DriverAppDisabledFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<PlatformManager> provider2) {
        return new DriverAppDisabledFragment_Factory(provider, provider2);
    }

    public static DriverAppDisabledFragment c(BaseUiDependencies baseUiDependencies, PlatformManager platformManager) {
        return new DriverAppDisabledFragment(baseUiDependencies, platformManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverAppDisabledFragment get() {
        return c(this.f27062a.get(), this.f27063b.get());
    }
}
