package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics;
import ee.mtakso.driver.service.earnings.EarningsManager;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverNormalImageMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsGoalViewModel_Factory implements Factory<EarningsGoalViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsManager> f29220a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverNormalImageMapper> f29221b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EarningsGoalAnalytics> f29222c;

    public EarningsGoalViewModel_Factory(Provider<EarningsManager> provider, Provider<DriverNormalImageMapper> provider2, Provider<EarningsGoalAnalytics> provider3) {
        this.f29220a = provider;
        this.f29221b = provider2;
        this.f29222c = provider3;
    }

    public static EarningsGoalViewModel_Factory a(Provider<EarningsManager> provider, Provider<DriverNormalImageMapper> provider2, Provider<EarningsGoalAnalytics> provider3) {
        return new EarningsGoalViewModel_Factory(provider, provider2, provider3);
    }

    public static EarningsGoalViewModel c(EarningsManager earningsManager, DriverNormalImageMapper driverNormalImageMapper, EarningsGoalAnalytics earningsGoalAnalytics) {
        return new EarningsGoalViewModel(earningsManager, driverNormalImageMapper, earningsGoalAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsGoalViewModel get() {
        return c(this.f29220a.get(), this.f29221b.get(), this.f29222c.get());
    }
}
