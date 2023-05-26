package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDto.kt */
/* loaded from: classes3.dex */
public final class FinalizeOrderRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f22371a;
    @SerializedName("client_rating")

    /* renamed from: b  reason: collision with root package name */
    private final RateClientRequest f22372b;
    @SerializedName("price")

    /* renamed from: c  reason: collision with root package name */
    private final PriceReviewRequest f22373c;

    public FinalizeOrderRequest(OrderHandle orderHandle, RateClientRequest rateClientRequest, PriceReviewRequest priceReview) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(priceReview, "priceReview");
        this.f22371a = orderHandle;
        this.f22372b = rateClientRequest;
        this.f22373c = priceReview;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FinalizeOrderRequest) {
            FinalizeOrderRequest finalizeOrderRequest = (FinalizeOrderRequest) obj;
            return Intrinsics.a(this.f22371a, finalizeOrderRequest.f22371a) && Intrinsics.a(this.f22372b, finalizeOrderRequest.f22372b) && Intrinsics.a(this.f22373c, finalizeOrderRequest.f22373c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22371a.hashCode() * 31;
        RateClientRequest rateClientRequest = this.f22372b;
        return ((hashCode + (rateClientRequest == null ? 0 : rateClientRequest.hashCode())) * 31) + this.f22373c.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f22371a;
        RateClientRequest rateClientRequest = this.f22372b;
        PriceReviewRequest priceReviewRequest = this.f22373c;
        return "FinalizeOrderRequest(orderHandle=" + orderHandle + ", clientRating=" + rateClientRequest + ", priceReview=" + priceReviewRequest + ")";
    }
}
