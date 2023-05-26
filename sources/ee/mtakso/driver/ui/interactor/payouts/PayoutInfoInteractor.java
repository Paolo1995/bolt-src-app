package ee.mtakso.driver.ui.interactor.payouts;

import ee.mtakso.driver.network.client.earnings.PayoutClient;
import ee.mtakso.driver.network.client.earnings.PayoutConfirmationResponce;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutInfoInteractor.kt */
/* loaded from: classes3.dex */
public final class PayoutInfoInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final PayoutClient f26780a;

    @Inject
    public PayoutInfoInteractor(PayoutClient payoutClient) {
        Intrinsics.f(payoutClient, "payoutClient");
        this.f26780a = payoutClient;
    }

    public final Single<PayoutConfirmationResponce> a() {
        return this.f26780a.f();
    }
}
