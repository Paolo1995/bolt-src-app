package ee.mtakso.driver.network.client.analytics;

import dagger.Lazy;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import java.util.Map;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsClient.kt */
/* loaded from: classes3.dex */
public final class AnalyticsClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<AnalyticsApi> f21349a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy<LeadAnalyticsApi> f21350b;

    /* renamed from: c  reason: collision with root package name */
    private final ResponseErrorProcessor f21351c;

    @Inject
    public AnalyticsClient(Lazy<AnalyticsApi> api, Lazy<LeadAnalyticsApi> leadApi, ResponseErrorProcessor responseTransformer) {
        Intrinsics.f(api, "api");
        Intrinsics.f(leadApi, "leadApi");
        Intrinsics.f(responseTransformer, "responseTransformer");
        this.f21349a = api;
        this.f21350b = leadApi;
        this.f21351c = responseTransformer;
    }

    public final Single<EmptyServerResponse> a(String key, Map<String, ? extends Object> payload) {
        Map n8;
        Intrinsics.f(key, "key");
        Intrinsics.f(payload, "payload");
        n8 = MapsKt__MapsKt.n(payload, TuplesKt.a("type", key));
        return SingleExtKt.d(SingleExtKt.e(this.f21349a.get().a(new AnalyticsRequest(key, n8)), this.f21351c));
    }

    public final Single<EmptyServerResponse> b(String key, Map<String, ? extends Object> payload) {
        Map n8;
        Intrinsics.f(key, "key");
        Intrinsics.f(payload, "payload");
        n8 = MapsKt__MapsKt.n(payload, TuplesKt.a("type", key));
        return SingleExtKt.d(SingleExtKt.e(this.f21350b.get().a(new AnalyticsRequest(key, n8)), this.f21351c));
    }
}
