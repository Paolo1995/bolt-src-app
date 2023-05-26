package ee.mtakso.driver.ui.screens.earnings.v2;

import ee.mtakso.driver.network.client.earnings.EarningsClient;
import ee.mtakso.driver.network.client.earnings.EarningsScreenType;
import ee.mtakso.driver.network.client.earnings.PayToBoltResponse;
import ee.mtakso.driver.network.client.earnings.ToPay;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.DebtInfo;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltInfo;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsInteractor.kt */
/* loaded from: classes3.dex */
public final class EarningsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final EarningsClient f28515a;

    @Inject
    public EarningsInteractor(EarningsClient earningsClient) {
        Intrinsics.f(earningsClient, "earningsClient");
        this.f28515a = earningsClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PayToBoltInfo d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (PayToBoltInfo) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    public final Single<Optional<PayToBoltInfo>> c(EarningsScreenType earningsScreenType) {
        if (earningsScreenType != EarningsScreenType.BALANCE) {
            Single<Optional<PayToBoltInfo>> w7 = Single.w(Optional.a());
            Intrinsics.e(w7, "just(Optional.empty<PayToBoltInfo>())");
            return w7;
        }
        Single<PayToBoltResponse> d8 = this.f28515a.d();
        final EarningsInteractor$getPayToBoltInformation$1 earningsInteractor$getPayToBoltInformation$1 = new Function1<PayToBoltResponse, PayToBoltInfo>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsInteractor$getPayToBoltInformation$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final PayToBoltInfo invoke(PayToBoltResponse response) {
                DebtInfo debtInfo;
                Intrinsics.f(response, "response");
                ToPay a8 = response.a();
                if (a8 == null) {
                    debtInfo = null;
                } else {
                    debtInfo = new DebtInfo(a8.a(), a8.b());
                }
                return new PayToBoltInfo(response.b(), response.c(), debtInfo);
            }
        };
        Single<R> x7 = d8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PayToBoltInfo d9;
                d9 = EarningsInteractor.d(Function1.this, obj);
                return d9;
            }
        });
        final EarningsInteractor$getPayToBoltInformation$2 earningsInteractor$getPayToBoltInformation$2 = new Function1<PayToBoltInfo, Optional<PayToBoltInfo>>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsInteractor$getPayToBoltInformation$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<PayToBoltInfo> invoke(PayToBoltInfo it) {
                Intrinsics.f(it, "it");
                return Optional.f(it);
            }
        };
        Single<Optional<PayToBoltInfo>> x8 = x7.x(new Function() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional e8;
                e8 = EarningsInteractor.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(x8, "earningsClient.getPayToB… .map { Optional.of(it) }");
        return x8;
    }
}
