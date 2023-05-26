package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsGoalExpensesViewModel_Factory implements Factory<EarningsGoalExpensesViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsGoalAnalytics> f29159a;

    public EarningsGoalExpensesViewModel_Factory(Provider<EarningsGoalAnalytics> provider) {
        this.f29159a = provider;
    }

    public static EarningsGoalExpensesViewModel_Factory a(Provider<EarningsGoalAnalytics> provider) {
        return new EarningsGoalExpensesViewModel_Factory(provider);
    }

    public static EarningsGoalExpensesViewModel c(EarningsGoalAnalytics earningsGoalAnalytics) {
        return new EarningsGoalExpensesViewModel(earningsGoalAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsGoalExpensesViewModel get() {
        return c(this.f29159a.get());
    }
}
