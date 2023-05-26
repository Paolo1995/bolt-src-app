package eu.bolt.driver.earnings.network;

import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxSingleKt;

/* compiled from: EarningsBalanceClient.kt */
/* loaded from: classes5.dex */
public final class EarningsBalanceClient {

    /* renamed from: a  reason: collision with root package name */
    private final EarningsBalanceApi f41471a;

    @Inject
    public EarningsBalanceClient(EarningsBalanceApi earningsBalanceApi) {
        Intrinsics.f(earningsBalanceApi, "earningsBalanceApi");
        this.f41471a = earningsBalanceApi;
    }

    public final Single<BalanceHistory> b(String id, String str) {
        Intrinsics.f(id, "id");
        return RxSingleKt.c(null, new EarningsBalanceClient$getBalanceHistory$1(this, id, str, null), 1, null);
    }

    public final Single<BalanceScreen> c() {
        return RxSingleKt.c(null, new EarningsBalanceClient$getBalanceScreen$1(this, null), 1, null);
    }
}
