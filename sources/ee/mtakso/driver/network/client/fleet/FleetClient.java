package ee.mtakso.driver.network.client.fleet;

import ee.mtakso.driver.network.client.ShardApiProvider;
import ee.mtakso.driver.network.response.EmptyDestinationServerResponse;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FleetClient.kt */
/* loaded from: classes3.dex */
public final class FleetClient {

    /* renamed from: a  reason: collision with root package name */
    private final ShardApiProvider f22213a;

    /* renamed from: b  reason: collision with root package name */
    private final ResponseErrorProcessor f22214b;

    @Inject
    public FleetClient(ShardApiProvider apiProvider, ResponseErrorProcessor errorProcessor) {
        Intrinsics.f(apiProvider, "apiProvider");
        Intrinsics.f(errorProcessor, "errorProcessor");
        this.f22213a = apiProvider;
        this.f22214b = errorProcessor;
    }

    public final Single<EmptyServerResponse> a() {
        return SingleExtKt.e(this.f22213a.j().a(), this.f22214b);
    }

    public final Single<EmptyDestinationServerResponse> b(long j8) {
        return SingleExtKt.e(this.f22213a.j().b(j8), this.f22214b);
    }
}
