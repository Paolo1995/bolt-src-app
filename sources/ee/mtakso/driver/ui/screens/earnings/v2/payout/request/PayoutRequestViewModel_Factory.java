package ee.mtakso.driver.ui.screens.earnings.v2.payout.request;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.ui.interactor.payouts.ConfirmPayoutInteractor;
import ee.mtakso.driver.ui.interactor.payouts.PayoutInfoInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PayoutRequestViewModel_Factory implements Factory<PayoutRequestViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PayoutInfoInteractor> f28760a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ConfirmPayoutInteractor> f28761b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PayoutAnalytics> f28762c;

    public PayoutRequestViewModel_Factory(Provider<PayoutInfoInteractor> provider, Provider<ConfirmPayoutInteractor> provider2, Provider<PayoutAnalytics> provider3) {
        this.f28760a = provider;
        this.f28761b = provider2;
        this.f28762c = provider3;
    }

    public static PayoutRequestViewModel_Factory a(Provider<PayoutInfoInteractor> provider, Provider<ConfirmPayoutInteractor> provider2, Provider<PayoutAnalytics> provider3) {
        return new PayoutRequestViewModel_Factory(provider, provider2, provider3);
    }

    public static PayoutRequestViewModel c(PayoutInfoInteractor payoutInfoInteractor, ConfirmPayoutInteractor confirmPayoutInteractor, PayoutAnalytics payoutAnalytics) {
        return new PayoutRequestViewModel(payoutInfoInteractor, confirmPayoutInteractor, payoutAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutRequestViewModel get() {
        return c(this.f28760a.get(), this.f28761b.get(), this.f28762c.get());
    }
}
