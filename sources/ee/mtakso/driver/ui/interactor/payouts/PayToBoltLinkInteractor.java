package ee.mtakso.driver.ui.interactor.payouts;

import ee.mtakso.driver.network.client.earnings.PayToBoltLinkResponse;
import ee.mtakso.driver.network.client.earnings.PayoutClient;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayToBoltLinkInteractor.kt */
/* loaded from: classes3.dex */
public final class PayToBoltLinkInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final PayoutClient f26772a;

    @Inject
    public PayToBoltLinkInteractor(PayoutClient payoutClient) {
        Intrinsics.f(payoutClient, "payoutClient");
        this.f26772a = payoutClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    public final Single<String> b() {
        Single<PayToBoltLinkResponse> b8 = this.f26772a.b();
        final PayToBoltLinkInteractor$requestPayoutInfo$1 payToBoltLinkInteractor$requestPayoutInfo$1 = new Function1<PayToBoltLinkResponse, String>() { // from class: ee.mtakso.driver.ui.interactor.payouts.PayToBoltLinkInteractor$requestPayoutInfo$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(PayToBoltLinkResponse it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single x7 = b8.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.payouts.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String c8;
                c8 = PayToBoltLinkInteractor.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "payoutClient.getPayToBoltUrl().map { it.url }");
        return x7;
    }
}
