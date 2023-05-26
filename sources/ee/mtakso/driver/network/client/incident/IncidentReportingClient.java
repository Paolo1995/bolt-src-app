package ee.mtakso.driver.network.client.incident;

import dagger.Lazy;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncidentReportingClient.kt */
/* loaded from: classes3.dex */
public final class IncidentReportingClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<IncidentReportingApi> f22265a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeResponseTransformer f22266b;

    /* renamed from: c  reason: collision with root package name */
    private final ResponseErrorProcessor f22267c;

    @Inject
    public IncidentReportingClient(Lazy<IncidentReportingApi> incidentReportingApi, CompositeResponseTransformer responseTransformer, ResponseErrorProcessor errorProcessor) {
        Intrinsics.f(incidentReportingApi, "incidentReportingApi");
        Intrinsics.f(responseTransformer, "responseTransformer");
        Intrinsics.f(errorProcessor, "errorProcessor");
        this.f22265a = incidentReportingApi;
        this.f22266b = responseTransformer;
        this.f22267c = errorProcessor;
    }

    public final Single<OpenIncidentResult> a(GeoCoordinate point, OrderHandle orderHandle) {
        Intrinsics.f(point, "point");
        return SingleExtKt.g(this.f22265a.get().b(new OpenIncidentRequest(point.a(), point.b(), orderHandle)), this.f22266b);
    }

    public final Single<EmptyServerResponse> b(long j8, double d8, double d9) {
        return SingleExtKt.e(this.f22265a.get().a(j8, d8, d9), this.f22267c);
    }
}
