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
public final class PayoutInfoInteractor_Factory implements Factory<PayoutInfoInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PayoutClient> f26781a;

    public PayoutInfoInteractor_Factory(Provider<PayoutClient> provider) {
        this.f26781a = provider;
    }

    public static PayoutInfoInteractor_Factory a(Provider<PayoutClient> provider) {
        return new PayoutInfoInteractor_Factory(provider);
    }

    public static PayoutInfoInteractor c(PayoutClient payoutClient) {
        return new PayoutInfoInteractor(payoutClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutInfoInteractor get() {
        return c(this.f26781a.get());
    }
}
