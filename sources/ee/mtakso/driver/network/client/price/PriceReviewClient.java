package ee.mtakso.driver.network.client.price;

import dagger.Lazy;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PriceReviewClient.kt */
/* loaded from: classes3.dex */
public final class PriceReviewClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<PriceReviewApi> f22656a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeResponseTransformer f22657b;

    @Inject
    public PriceReviewClient(Lazy<PriceReviewApi> api, CompositeResponseTransformer responseTransformer) {
        Intrinsics.f(api, "api");
        Intrinsics.f(responseTransformer, "responseTransformer");
        this.f22656a = api;
        this.f22657b = responseTransformer;
    }

    public final Single<PriceReviewReasons> a(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.g(this.f22656a.get().a(orderHandle.b()), this.f22657b);
    }
}
