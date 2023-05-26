package ee.mtakso.driver.ui.screens.earnings.v3.goal;

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
public final class EarningsGoalExpensesFragment_Factory implements Factory<EarningsGoalExpensesFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f29150a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CurrencyValueFormat> f29151b;

    public EarningsGoalExpensesFragment_Factory(Provider<BaseUiDependencies> provider, Provider<CurrencyValueFormat> provider2) {
        this.f29150a = provider;
        this.f29151b = provider2;
    }

    public static EarningsGoalExpensesFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<CurrencyValueFormat> provider2) {
        return new EarningsGoalExpensesFragment_Factory(provider, provider2);
    }

    public static EarningsGoalExpensesFragment c(BaseUiDependencies baseUiDependencies, CurrencyValueFormat currencyValueFormat) {
        return new EarningsGoalExpensesFragment(baseUiDependencies, currencyValueFormat);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsGoalExpensesFragment get() {
        return c(this.f29150a.get(), this.f29151b.get());
    }
}
