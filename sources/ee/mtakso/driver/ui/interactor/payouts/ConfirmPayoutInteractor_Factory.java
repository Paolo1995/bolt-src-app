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
public final class ConfirmPayoutInteractor_Factory implements Factory<ConfirmPayoutInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PayoutClient> f26771a;

    public ConfirmPayoutInteractor_Factory(Provider<PayoutClient> provider) {
        this.f26771a = provider;
    }

    public static ConfirmPayoutInteractor_Factory a(Provider<PayoutClient> provider) {
        return new ConfirmPayoutInteractor_Factory(provider);
    }

    public static ConfirmPayoutInteractor c(PayoutClient payoutClient) {
        return new ConfirmPayoutInteractor(payoutClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ConfirmPayoutInteractor get() {
        return c(this.f26771a.get());
    }
}
