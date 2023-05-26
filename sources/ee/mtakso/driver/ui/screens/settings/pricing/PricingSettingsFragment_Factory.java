package ee.mtakso.driver.ui.screens.settings.pricing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes5.dex */
public final class PricingSettingsFragment_Factory implements Factory<PricingSettingsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33274a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PriceFormat> f33275b;

    public PricingSettingsFragment_Factory(Provider<BaseUiDependencies> provider, Provider<PriceFormat> provider2) {
        this.f33274a = provider;
        this.f33275b = provider2;
    }

    public static PricingSettingsFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<PriceFormat> provider2) {
        return new PricingSettingsFragment_Factory(provider, provider2);
    }

    public static PricingSettingsFragment c(BaseUiDependencies baseUiDependencies, PriceFormat priceFormat) {
        return new PricingSettingsFragment(baseUiDependencies, priceFormat);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PricingSettingsFragment get() {
        return c(this.f33274a.get(), this.f33275b.get());
    }
}
