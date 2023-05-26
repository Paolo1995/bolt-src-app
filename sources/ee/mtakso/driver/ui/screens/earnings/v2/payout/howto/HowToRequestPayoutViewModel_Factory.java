package ee.mtakso.driver.ui.screens.earnings.v2.payout.howto;

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
public final class HowToRequestPayoutViewModel_Factory implements Factory<HowToRequestPayoutViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PayoutClient> f28730a;

    public HowToRequestPayoutViewModel_Factory(Provider<PayoutClient> provider) {
        this.f28730a = provider;
    }

    public static HowToRequestPayoutViewModel_Factory a(Provider<PayoutClient> provider) {
        return new HowToRequestPayoutViewModel_Factory(provider);
    }

    public static HowToRequestPayoutViewModel c(PayoutClient payoutClient) {
        return new HowToRequestPayoutViewModel(payoutClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HowToRequestPayoutViewModel get() {
        return c(this.f28730a.get());
    }
}
