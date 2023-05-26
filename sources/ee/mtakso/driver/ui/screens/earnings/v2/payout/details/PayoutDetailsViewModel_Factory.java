package ee.mtakso.driver.ui.screens.earnings.v2.payout.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.ui.interactor.payouts.PayoutDetailsInteractor;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PayoutDetailsViewModel_Factory implements Factory<PayoutDetailsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PayoutDetailsInteractor> f28698a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f28699b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PayoutAnalytics> f28700c;

    public PayoutDetailsViewModel_Factory(Provider<PayoutDetailsInteractor> provider, Provider<CompositeUrlLauncher> provider2, Provider<PayoutAnalytics> provider3) {
        this.f28698a = provider;
        this.f28699b = provider2;
        this.f28700c = provider3;
    }

    public static PayoutDetailsViewModel_Factory a(Provider<PayoutDetailsInteractor> provider, Provider<CompositeUrlLauncher> provider2, Provider<PayoutAnalytics> provider3) {
        return new PayoutDetailsViewModel_Factory(provider, provider2, provider3);
    }

    public static PayoutDetailsViewModel c(PayoutDetailsInteractor payoutDetailsInteractor, CompositeUrlLauncher compositeUrlLauncher, PayoutAnalytics payoutAnalytics) {
        return new PayoutDetailsViewModel(payoutDetailsInteractor, compositeUrlLauncher, payoutAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutDetailsViewModel get() {
        return c(this.f28698a.get(), this.f28699b.get(), this.f28700c.get());
    }
}
