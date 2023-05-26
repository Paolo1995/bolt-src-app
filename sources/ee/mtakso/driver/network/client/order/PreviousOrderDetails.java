package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PastOrder.kt */
/* loaded from: classes3.dex */
public final class PreviousOrderDetails {
    @SerializedName("cash_payment_str")

    /* renamed from: a  reason: collision with root package name */
    private final String f22447a;
    @SerializedName("cash_campaign_str")

    /* renamed from: b  reason: collision with root package name */
    private final String f22448b;
    @SerializedName("stops")

    /* renamed from: c  reason: collision with root package name */
    private final List<OrderStop> f22449c;
    @SerializedName("ride_start")

    /* renamed from: d  reason: collision with root package name */
    private final Long f22450d;
    @SerializedName("ride_end")

    /* renamed from: e  reason: collision with root package name */
    private final Long f22451e;
    @SerializedName("ride_distance_str")

    /* renamed from: f  reason: collision with root package name */
    private final String f22452f;
    @SerializedName("order_handle")

    /* renamed from: g  reason: collision with root package name */
    private final OrderHandle f22453g;
    @SerializedName("address")

    /* renamed from: h  reason: collision with root package name */
    private final String f22454h;
    @SerializedName("client_phone")

    /* renamed from: i  reason: collision with root package name */
    private final String f22455i;
    @SerializedName("created")

    /* renamed from: j  reason: collision with root package name */
    private final String f22456j;
    @SerializedName("created_timestamp")

    /* renamed from: k  reason: collision with root package name */
    private final long f22457k;
    @SerializedName("payment_type")

    /* renamed from: l  reason: collision with root package name */
    private final PaymentType f22458l;
    @SerializedName("payment_method_id")

    /* renamed from: m  reason: collision with root package name */
    private final String f22459m;
    @SerializedName("payment_method_type")

    /* renamed from: n  reason: collision with root package name */
    private final String f22460n;
    @SerializedName("price_str")

    /* renamed from: o  reason: collision with root package name */
    private final String f22461o;
    @SerializedName("price_review_status")

    /* renamed from: p  reason: collision with root package name */
    private final PriceReviewState f22462p;
    @SerializedName("state")

    /* renamed from: q  reason: collision with root package name */
    private final OrderState f22463q;
    @SerializedName("tip_str")

    /* renamed from: r  reason: collision with root package name */
    private final String f22464r;
    @SerializedName("trip_audio_recording")

    /* renamed from: s  reason: collision with root package name */
    private final TripAudioRecordingData f22465s;

    public final String a() {
        return this.f22448b;
    }

    public final String b() {
        return this.f22447a;
    }

    public final long c() {
        return this.f22457k;
    }

    public final OrderHandle d() {
        return this.f22453g;
    }

    public final String e() {
        return this.f22461o;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreviousOrderDetails) {
            PreviousOrderDetails previousOrderDetails = (PreviousOrderDetails) obj;
            return Intrinsics.a(this.f22447a, previousOrderDetails.f22447a) && Intrinsics.a(this.f22448b, previousOrderDetails.f22448b) && Intrinsics.a(this.f22449c, previousOrderDetails.f22449c) && Intrinsics.a(this.f22450d, previousOrderDetails.f22450d) && Intrinsics.a(this.f22451e, previousOrderDetails.f22451e) && Intrinsics.a(this.f22452f, previousOrderDetails.f22452f) && Intrinsics.a(this.f22453g, previousOrderDetails.f22453g) && Intrinsics.a(this.f22454h, previousOrderDetails.f22454h) && Intrinsics.a(this.f22455i, previousOrderDetails.f22455i) && Intrinsics.a(this.f22456j, previousOrderDetails.f22456j) && this.f22457k == previousOrderDetails.f22457k && this.f22458l == previousOrderDetails.f22458l && Intrinsics.a(this.f22459m, previousOrderDetails.f22459m) && Intrinsics.a(this.f22460n, previousOrderDetails.f22460n) && Intrinsics.a(this.f22461o, previousOrderDetails.f22461o) && this.f22462p == previousOrderDetails.f22462p && this.f22463q == previousOrderDetails.f22463q && Intrinsics.a(this.f22464r, previousOrderDetails.f22464r) && Intrinsics.a(this.f22465s, previousOrderDetails.f22465s);
        }
        return false;
    }

    public final PriceReviewState f() {
        return this.f22462p;
    }

    public final PaymentType g() {
        return this.f22458l;
    }

    public final String h() {
        return this.f22452f;
    }

    public int hashCode() {
        String str = this.f22447a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f22448b;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f22449c.hashCode()) * 31;
        Long l8 = this.f22450d;
        int hashCode3 = (hashCode2 + (l8 == null ? 0 : l8.hashCode())) * 31;
        Long l9 = this.f22451e;
        int hashCode4 = (hashCode3 + (l9 == null ? 0 : l9.hashCode())) * 31;
        String str3 = this.f22452f;
        int hashCode5 = (((((hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f22453g.hashCode()) * 31) + this.f22454h.hashCode()) * 31;
        String str4 = this.f22455i;
        int hashCode6 = (((((hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f22456j.hashCode()) * 31) + i0.a.a(this.f22457k)) * 31;
        PaymentType paymentType = this.f22458l;
        int hashCode7 = (((((hashCode6 + (paymentType == null ? 0 : paymentType.hashCode())) * 31) + this.f22459m.hashCode()) * 31) + this.f22460n.hashCode()) * 31;
        String str5 = this.f22461o;
        int hashCode8 = (((((hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f22462p.hashCode()) * 31) + this.f22463q.hashCode()) * 31;
        String str6 = this.f22464r;
        return ((hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f22465s.hashCode();
    }

    public final Long i() {
        return this.f22451e;
    }

    public final Long j() {
        return this.f22450d;
    }

    public final OrderState k() {
        return this.f22463q;
    }

    public final List<OrderStop> l() {
        return this.f22449c;
    }

    public final String m() {
        return this.f22464r;
    }

    public final TripAudioRecordingData n() {
        return this.f22465s;
    }

    public String toString() {
        String str = this.f22447a;
        String str2 = this.f22448b;
        List<OrderStop> list = this.f22449c;
        Long l8 = this.f22450d;
        Long l9 = this.f22451e;
        String str3 = this.f22452f;
        OrderHandle orderHandle = this.f22453g;
        String str4 = this.f22454h;
        String str5 = this.f22455i;
        String str6 = this.f22456j;
        long j8 = this.f22457k;
        PaymentType paymentType = this.f22458l;
        String str7 = this.f22459m;
        String str8 = this.f22460n;
        String str9 = this.f22461o;
        PriceReviewState priceReviewState = this.f22462p;
        OrderState orderState = this.f22463q;
        String str10 = this.f22464r;
        TripAudioRecordingData tripAudioRecordingData = this.f22465s;
        return "PreviousOrderDetails(cashPayment=" + str + ", cashCampaign=" + str2 + ", stops=" + list + ", rideStartTimestamp=" + l8 + ", rideEndTimestamp=" + l9 + ", rideDistance=" + str3 + ", orderHandle=" + orderHandle + ", pickupAddress=" + str4 + ", clientPhoneNum=" + str5 + ", created=" + str6 + ", creationTimestampSeconds=" + j8 + ", rawPaymentType=" + paymentType + ", paymentMethodId=" + str7 + ", paymentMethodType=" + str8 + ", price=" + str9 + ", priceReviewStatus=" + priceReviewState + ", state=" + orderState + ", tipsInfo=" + str10 + ", tripAudioRecordingData=" + tripAudioRecordingData + ")";
    }
}
