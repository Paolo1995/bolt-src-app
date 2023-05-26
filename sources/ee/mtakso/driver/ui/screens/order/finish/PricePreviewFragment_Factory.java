package ee.mtakso.driver.ui.screens.order.finish;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class PricePreviewFragment_Factory implements Factory<PricePreviewFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f31326a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FragmentFactory> f31327b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverConfig> f31328c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverProvider> f31329d;

    public PricePreviewFragment_Factory(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<DriverConfig> provider3, Provider<DriverProvider> provider4) {
        this.f31326a = provider;
        this.f31327b = provider2;
        this.f31328c = provider3;
        this.f31329d = provider4;
    }

    public static PricePreviewFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<DriverConfig> provider3, Provider<DriverProvider> provider4) {
        return new PricePreviewFragment_Factory(provider, provider2, provider3, provider4);
    }

    public static PricePreviewFragment c(BaseUiDependencies baseUiDependencies, FragmentFactory fragmentFactory, DriverConfig driverConfig, DriverProvider driverProvider) {
        return new PricePreviewFragment(baseUiDependencies, fragmentFactory, driverConfig, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PricePreviewFragment get() {
        return c(this.f31326a.get(), this.f31327b.get(), this.f31328c.get(), this.f31329d.get());
    }
}
