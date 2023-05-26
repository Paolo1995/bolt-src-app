package ee.mtakso.driver.ui.interactor.payouts;

import ee.mtakso.driver.network.client.earnings.PayoutClient;
import ee.mtakso.driver.network.client.earnings.PayoutHistoryItem;
import ee.mtakso.driver.network.client.earnings.PayoutHistoryResponce;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutHistoryInteractor.kt */
/* loaded from: classes3.dex */
public final class PayoutHistoryInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final PayoutClient f26777a;

    @Inject
    public PayoutHistoryInteractor(PayoutClient payoutClient) {
        Intrinsics.f(payoutClient, "payoutClient");
        this.f26777a = payoutClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public final Single<List<PayoutHistoryItem>> b() {
        Single<PayoutHistoryResponce> e8 = this.f26777a.e();
        final PayoutHistoryInteractor$getPayoutsHistory$1 payoutHistoryInteractor$getPayoutsHistory$1 = new Function1<PayoutHistoryResponce, List<? extends PayoutHistoryItem>>() { // from class: ee.mtakso.driver.ui.interactor.payouts.PayoutHistoryInteractor$getPayoutsHistory$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<PayoutHistoryItem> invoke(PayoutHistoryResponce it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single x7 = e8.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.payouts.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List c8;
                c8 = PayoutHistoryInteractor.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "payoutClient.getPayoutHi…        .map { it.items }");
        return x7;
    }
}
