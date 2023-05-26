package ee.mtakso.driver.network.client.order;

import dagger.Lazy;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderRequest;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RideHistoryClient.kt */
/* loaded from: classes3.dex */
public final class RideHistoryClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<RideHistoryApi> f22549a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeResponseTransformer f22550b;

    @Inject
    public RideHistoryClient(Lazy<RideHistoryApi> rideHistoryApi, CompositeResponseTransformer responseTransformer) {
        Intrinsics.f(rideHistoryApi, "rideHistoryApi");
        Intrinsics.f(responseTransformer, "responseTransformer");
        this.f22549a = rideHistoryApi;
        this.f22550b = responseTransformer;
    }

    public final Single<PreviousOrders> a() {
        return SingleExtKt.g(this.f22549a.get().a(), this.f22550b);
    }

    public final Single<PreviousOrderDetails> b(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.g(this.f22549a.get().b(new OrderRequest(orderHandle)), this.f22550b);
    }
}
