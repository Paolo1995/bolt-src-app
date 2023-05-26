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
public final class PayToBoltLinkInteractor_Factory implements Factory<PayToBoltLinkInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PayoutClient> f26774a;

    public PayToBoltLinkInteractor_Factory(Provider<PayoutClient> provider) {
        this.f26774a = provider;
    }

    public static PayToBoltLinkInteractor_Factory a(Provider<PayoutClient> provider) {
        return new PayToBoltLinkInteractor_Factory(provider);
    }

    public static PayToBoltLinkInteractor c(PayoutClient payoutClient) {
        return new PayToBoltLinkInteractor(payoutClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayToBoltLinkInteractor get() {
        return c(this.f26774a.get());
    }
}
