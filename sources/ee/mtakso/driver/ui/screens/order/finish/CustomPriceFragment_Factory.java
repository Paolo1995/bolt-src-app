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
public final class CustomPriceFragment_Factory implements Factory<CustomPriceFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f31306a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FragmentFactory> f31307b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f31308c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverConfig> f31309d;

    public CustomPriceFragment_Factory(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<DriverProvider> provider3, Provider<DriverConfig> provider4) {
        this.f31306a = provider;
        this.f31307b = provider2;
        this.f31308c = provider3;
        this.f31309d = provider4;
    }

    public static CustomPriceFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<DriverProvider> provider3, Provider<DriverConfig> provider4) {
        return new CustomPriceFragment_Factory(provider, provider2, provider3, provider4);
    }

    public static CustomPriceFragment c(BaseUiDependencies baseUiDependencies, FragmentFactory fragmentFactory, DriverProvider driverProvider, DriverConfig driverConfig) {
        return new CustomPriceFragment(baseUiDependencies, fragmentFactory, driverProvider, driverConfig);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CustomPriceFragment get() {
        return c(this.f31306a.get(), this.f31307b.get(), this.f31308c.get(), this.f31309d.get());
    }
}
