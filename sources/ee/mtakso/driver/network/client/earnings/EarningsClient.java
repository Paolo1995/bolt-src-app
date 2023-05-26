package ee.mtakso.driver.network.client.earnings;

import dagger.Lazy;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsClient.kt */
/* loaded from: classes3.dex */
public final class EarningsClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<EarningsApi> f22100a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeResponseTransformer f22101b;

    @Inject
    public EarningsClient(Lazy<EarningsApi> earningsApi, CompositeResponseTransformer responseTransformer) {
        Intrinsics.f(earningsApi, "earningsApi");
        Intrinsics.f(responseTransformer, "responseTransformer");
        this.f22100a = earningsApi;
        this.f22101b = responseTransformer;
    }

    public final Single<EarningsChartResponse> a(String interval) {
        Intrinsics.f(interval, "interval");
        return SingleExtKt.g(this.f22100a.get().c(interval), this.f22101b);
    }

    public final Single<ReportIntervals> b(String modeId) {
        Intrinsics.f(modeId, "modeId");
        return SingleExtKt.g(this.f22100a.get().b(modeId), this.f22101b);
    }

    public final Single<ReportScreen> c(String interval, String str) {
        Intrinsics.f(interval, "interval");
        return SingleExtKt.g(this.f22100a.get().d(interval, str), this.f22101b);
    }

    public final Single<PayToBoltResponse> d() {
        return SingleExtKt.g(this.f22100a.get().a(), this.f22101b);
    }

    public final Single<EarningsReportScreenConfig> e() {
        return SingleExtKt.g(this.f22100a.get().e(), this.f22101b);
    }
}
