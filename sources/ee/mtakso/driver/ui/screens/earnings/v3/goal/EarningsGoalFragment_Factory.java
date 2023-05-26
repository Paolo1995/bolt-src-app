package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyValueFormat;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class EarningsGoalFragment_Factory implements Factory<EarningsGoalFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f29191a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FragmentFactory> f29192b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CurrencyValueFormat> f29193c;

    public EarningsGoalFragment_Factory(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<CurrencyValueFormat> provider3) {
        this.f29191a = provider;
        this.f29192b = provider2;
        this.f29193c = provider3;
    }

    public static EarningsGoalFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<CurrencyValueFormat> provider3) {
        return new EarningsGoalFragment_Factory(provider, provider2, provider3);
    }

    public static EarningsGoalFragment c(BaseUiDependencies baseUiDependencies, FragmentFactory fragmentFactory, CurrencyValueFormat currencyValueFormat) {
        return new EarningsGoalFragment(baseUiDependencies, fragmentFactory, currencyValueFormat);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsGoalFragment get() {
        return c(this.f29191a.get(), this.f29192b.get(), this.f29193c.get());
    }
}
