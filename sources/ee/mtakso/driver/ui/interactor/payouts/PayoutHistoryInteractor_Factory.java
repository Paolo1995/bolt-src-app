package ee.mtakso.driver.ui.interactor.payouts;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.earnings.PayoutClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PayoutHistoryInteractor_Factory implements Factory<PayoutHistoryInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PayoutClient> f26779a;

    public PayoutHistoryInteractor_Factory(Provider<PayoutClient> provider) {
        this.f26779a = provider;
    }

    public static PayoutHistoryInteractor_Factory a(Provider<PayoutClient> provider) {
        return new PayoutHistoryInteractor_Factory(provider);
    }

    public static PayoutHistoryInteractor c(PayoutClient payoutClient) {
        return new PayoutHistoryInteractor(payoutClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutHistoryInteractor get() {
        return c(this.f26779a.get());
    }
}
