package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PastOrder.kt */
/* loaded from: classes3.dex */
public final class PreviousOrder {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f22435a;
    @SerializedName("address")

    /* renamed from: b  reason: collision with root package name */
    private final String f22436b;
    @SerializedName("client_phone")

    /* renamed from: c  reason: collision with root package name */
    private final String f22437c;
    @SerializedName("created")

    /* renamed from: d  reason: collision with root package name */
    private final String f22438d;
    @SerializedName("created_timestamp")

    /* renamed from: e  reason: collision with root package name */
    private final long f22439e;
    @SerializedName("payment_type")

    /* renamed from: f  reason: collision with root package name */
    private final PaymentType f22440f;
    @SerializedName("payment_method_id")

    /* renamed from: g  reason: collision with root package name */
    private final String f22441g;
    @SerializedName("payment_method_type")

    /* renamed from: h  reason: collision with root package name */
    private final String f22442h;
    @SerializedName("price_str")

    /* renamed from: i  reason: collision with root package name */
    private final String f22443i;
    @SerializedName("price_review_status")

    /* renamed from: j  reason: collision with root package name */
    private final PriceReviewState f22444j;
    @SerializedName("state")

    /* renamed from: k  reason: collision with root package name */
    private final OrderState f22445k;
    @SerializedName("tip_str")

    /* renamed from: l  reason: collision with root package name */
    private final String f22446l;

    public final String a() {
        return this.f22436b;
    }

    public final long b() {
        return this.f22439e;
    }

    public final OrderHandle c() {
        return this.f22435a;
    }

    public final String d() {
        return this.f22443i;
    }

    public final PriceReviewState e() {
        return this.f22444j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreviousOrder) {
            PreviousOrder previousOrder = (PreviousOrder) obj;
            return Intrinsics.a(this.f22435a, previousOrder.f22435a) && Intrinsics.a(this.f22436b, previousOrder.f22436b) && Intrinsics.a(this.f22437c, previousOrder.f22437c) && Intrinsics.a(this.f22438d, previousOrder.f22438d) && this.f22439e == previousOrder.f22439e && this.f22440f == previousOrder.f22440f && Intrinsics.a(this.f22441g, previousOrder.f22441g) && Intrinsics.a(this.f22442h, previousOrder.f22442h) && Intrinsics.a(this.f22443i, previousOrder.f22443i) && this.f22444j == previousOrder.f22444j && this.f22445k == previousOrder.f22445k && Intrinsics.a(this.f22446l, previousOrder.f22446l);
        }
        return false;
    }

    public final PaymentType f() {
        return this.f22440f;
    }

    public final OrderState g() {
        return this.f22445k;
    }

    public final String h() {
        return this.f22446l;
    }

    public int hashCode() {
        int hashCode = ((this.f22435a.hashCode() * 31) + this.f22436b.hashCode()) * 31;
        String str = this.f22437c;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f22438d.hashCode()) * 31) + i0.a.a(this.f22439e)) * 31;
        PaymentType paymentType = this.f22440f;
        int hashCode3 = (((((hashCode2 + (paymentType == null ? 0 : paymentType.hashCode())) * 31) + this.f22441g.hashCode()) * 31) + this.f22442h.hashCode()) * 31;
        String str2 = this.f22443i;
        int hashCode4 = (((((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f22444j.hashCode()) * 31) + this.f22445k.hashCode()) * 31;
        String str3 = this.f22446l;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        OrderHandle orderHandle = this.f22435a;
        String str = this.f22436b;
        String str2 = this.f22437c;
        String str3 = this.f22438d;
        long j8 = this.f22439e;
        PaymentType paymentType = this.f22440f;
        String str4 = this.f22441g;
        String str5 = this.f22442h;
        String str6 = this.f22443i;
        PriceReviewState priceReviewState = this.f22444j;
        OrderState orderState = this.f22445k;
        String str7 = this.f22446l;
        return "PreviousOrder(orderHandle=" + orderHandle + ", address=" + str + ", clientPhoneNum=" + str2 + ", creationDate=" + str3 + ", creationTimestampSeconds=" + j8 + ", rawPaymentType=" + paymentType + ", paymentMethodId=" + str4 + ", paymentMethodType=" + str5 + ", price=" + str6 + ", priceReviewStatus=" + priceReviewState + ", status=" + orderState + ", tipsInfo=" + str7 + ")";
    }
}
