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
public final class PayoutPayToBoltInfoInteractor_Factory implements Factory<PayoutPayToBoltInfoInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PayoutClient> f26785a;

    public PayoutPayToBoltInfoInteractor_Factory(Provider<PayoutClient> provider) {
        this.f26785a = provider;
    }

    public static PayoutPayToBoltInfoInteractor_Factory a(Provider<PayoutClient> provider) {
        return new PayoutPayToBoltInfoInteractor_Factory(provider);
    }

    public static PayoutPayToBoltInfoInteractor c(PayoutClient payoutClient) {
        return new PayoutPayToBoltInfoInteractor(payoutClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutPayToBoltInfoInteractor get() {
        return c(this.f26785a.get());
    }
}
