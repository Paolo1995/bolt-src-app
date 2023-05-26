package ee.mtakso.driver.ui.interactor.payouts;

import ee.mtakso.driver.network.client.earnings.PayoutClient;
import ee.mtakso.driver.network.client.earnings.PayoutResponce;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutDetailsInteractor.kt */
/* loaded from: classes3.dex */
public final class PayoutDetailsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final PayoutClient f26775a;

    @Inject
    public PayoutDetailsInteractor(PayoutClient payoutClient) {
        Intrinsics.f(payoutClient, "payoutClient");
        this.f26775a = payoutClient;
    }

    public final Single<PayoutResponce> a(long j8) {
        return this.f26775a.d(j8);
    }
}
