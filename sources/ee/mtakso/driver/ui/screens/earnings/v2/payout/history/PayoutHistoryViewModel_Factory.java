package ee.mtakso.driver.ui.screens.earnings.v2.payout.history;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.ui.interactor.payouts.PayoutHistoryInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PayoutHistoryViewModel_Factory implements Factory<PayoutHistoryViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PayoutHistoryInteractor> f28718a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PayoutAnalytics> f28719b;

    public PayoutHistoryViewModel_Factory(Provider<PayoutHistoryInteractor> provider, Provider<PayoutAnalytics> provider2) {
        this.f28718a = provider;
        this.f28719b = provider2;
    }

    public static PayoutHistoryViewModel_Factory a(Provider<PayoutHistoryInteractor> provider, Provider<PayoutAnalytics> provider2) {
        return new PayoutHistoryViewModel_Factory(provider, provider2);
    }

    public static PayoutHistoryViewModel c(PayoutHistoryInteractor payoutHistoryInteractor, PayoutAnalytics payoutAnalytics) {
        return new PayoutHistoryViewModel(payoutHistoryInteractor, payoutAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutHistoryViewModel get() {
        return c(this.f28718a.get(), this.f28719b.get());
    }
}
