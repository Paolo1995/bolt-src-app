package ee.mtakso.driver.ui.interactor.payouts;

import ee.mtakso.driver.network.client.earnings.CreatePayoutResponse;
import ee.mtakso.driver.network.client.earnings.PayoutClient;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmPayoutInteractor.kt */
/* loaded from: classes3.dex */
public final class ConfirmPayoutInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final PayoutClient f26770a;

    @Inject
    public ConfirmPayoutInteractor(PayoutClient payoutClient) {
        Intrinsics.f(payoutClient, "payoutClient");
        this.f26770a = payoutClient;
    }

    public final Single<CreatePayoutResponse> a(String confirmationId) {
        Intrinsics.f(confirmationId, "confirmationId");
        return this.f26770a.a(confirmationId);
    }
}
