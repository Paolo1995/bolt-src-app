package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.payments.EarningsPaymentClient;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PayToBoltViewModel_Factory implements Factory<PayToBoltViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsPaymentClient> f28643a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<WebViewTracker> f28644b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PayoutAnalytics> f28645c;

    public PayToBoltViewModel_Factory(Provider<EarningsPaymentClient> provider, Provider<WebViewTracker> provider2, Provider<PayoutAnalytics> provider3) {
        this.f28643a = provider;
        this.f28644b = provider2;
        this.f28645c = provider3;
    }

    public static PayToBoltViewModel_Factory a(Provider<EarningsPaymentClient> provider, Provider<WebViewTracker> provider2, Provider<PayoutAnalytics> provider3) {
        return new PayToBoltViewModel_Factory(provider, provider2, provider3);
    }

    public static PayToBoltViewModel c(EarningsPaymentClient earningsPaymentClient, WebViewTracker webViewTracker, PayoutAnalytics payoutAnalytics) {
        return new PayToBoltViewModel(earningsPaymentClient, webViewTracker, payoutAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayToBoltViewModel get() {
        return c(this.f28643a.get(), this.f28644b.get(), this.f28645c.get());
    }
}
