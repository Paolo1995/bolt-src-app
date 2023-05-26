package ee.mtakso.driver.ui.screens.earnings.v3.payout;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.payments.EarningsPaymentClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RequestWebUrlViewModel_Factory implements Factory<RequestWebUrlViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsPaymentClient> f29423a;

    public RequestWebUrlViewModel_Factory(Provider<EarningsPaymentClient> provider) {
        this.f29423a = provider;
    }

    public static RequestWebUrlViewModel_Factory a(Provider<EarningsPaymentClient> provider) {
        return new RequestWebUrlViewModel_Factory(provider);
    }

    public static RequestWebUrlViewModel c(EarningsPaymentClient earningsPaymentClient) {
        return new RequestWebUrlViewModel(earningsPaymentClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RequestWebUrlViewModel get() {
        return c(this.f29423a.get());
    }
}
