package eu.bolt.driver.earnings.network;

import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxSingleKt;

/* compiled from: EarningsClient.kt */
/* loaded from: classes5.dex */
public final class EarningsClient {

    /* renamed from: a  reason: collision with root package name */
    private final EarningsApi f41479a;

    @Inject
    public EarningsClient(EarningsApi earningsApi) {
        Intrinsics.f(earningsApi, "earningsApi");
        this.f41479a = earningsApi;
    }

    public final Single<EarningBreakdownIntervals> b() {
        return RxSingleKt.c(null, new EarningsClient$getEarningBreakdownIntervals$1(this, null), 1, null);
    }

    public final Single<EarningBreakdownScreen> c(long j8, long j9) {
        return RxSingleKt.c(null, new EarningsClient$getEarningBreakdownScreen$1(this, j8, j9, null), 1, null);
    }

    public final Single<EarningLandingScreen> d() {
        return RxSingleKt.c(null, new EarningsClient$getEarningLandingScreen$1(this, null), 1, null);
    }

    public final Single<EarningPayoutExplanationResponse> e() {
        return RxSingleKt.c(null, new EarningsClient$getEarningPayoutExplanation$1(this, null), 1, null);
    }
}
