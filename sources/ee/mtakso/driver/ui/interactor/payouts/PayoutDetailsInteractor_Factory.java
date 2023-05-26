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
public final class PayoutDetailsInteractor_Factory implements Factory<PayoutDetailsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PayoutClient> f26776a;

    public PayoutDetailsInteractor_Factory(Provider<PayoutClient> provider) {
        this.f26776a = provider;
    }

    public static PayoutDetailsInteractor_Factory a(Provider<PayoutClient> provider) {
        return new PayoutDetailsInteractor_Factory(provider);
    }

    public static PayoutDetailsInteractor c(PayoutClient payoutClient) {
        return new PayoutDetailsInteractor(payoutClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutDetailsInteractor get() {
        return c(this.f26776a.get());
    }
}
