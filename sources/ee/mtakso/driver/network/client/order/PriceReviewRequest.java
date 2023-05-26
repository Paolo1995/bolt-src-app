package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDto.kt */
/* loaded from: classes3.dex */
public final class PriceReviewRequest {
    @SerializedName("final_price")

    /* renamed from: a  reason: collision with root package name */
    private final double f22485a;
    @SerializedName("price_calculation_id")

    /* renamed from: b  reason: collision with root package name */
    private final long f22486b;
    @SerializedName("price_review_needed")

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22487c;
    @SerializedName("price_review_price")

    /* renamed from: d  reason: collision with root package name */
    private final String f22488d;
    @SerializedName("price_review_reason_code")

    /* renamed from: e  reason: collision with root package name */
    private final String f22489e;
    @SerializedName("price_review_comment")

    /* renamed from: f  reason: collision with root package name */
    private final String f22490f;

    public PriceReviewRequest(double d8, long j8, boolean z7, String str, String str2, String str3) {
        this.f22485a = d8;
        this.f22486b = j8;
        this.f22487c = z7;
        this.f22488d = str;
        this.f22489e = str2;
        this.f22490f = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PriceReviewRequest) {
            PriceReviewRequest priceReviewRequest = (PriceReviewRequest) obj;
            return Double.compare(this.f22485a, priceReviewRequest.f22485a) == 0 && this.f22486b == priceReviewRequest.f22486b && this.f22487c == priceReviewRequest.f22487c && Intrinsics.a(this.f22488d, priceReviewRequest.f22488d) && Intrinsics.a(this.f22489e, priceReviewRequest.f22489e) && Intrinsics.a(this.f22490f, priceReviewRequest.f22490f);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = ((q1.a.a(this.f22485a) * 31) + i0.a.a(this.f22486b)) * 31;
        boolean z7 = this.f22487c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (a8 + i8) * 31;
        String str = this.f22488d;
        int hashCode = (i9 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f22489e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f22490f;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        double d8 = this.f22485a;
        long j8 = this.f22486b;
        boolean z7 = this.f22487c;
        String str = this.f22488d;
        String str2 = this.f22489e;
        String str3 = this.f22490f;
        return "PriceReviewRequest(finalPrice=" + d8 + ", priceCalculationId=" + j8 + ", priceReviewNeeded=" + z7 + ", priceReviewPrice=" + str + ", priceReviewReasonCode=" + str2 + ", priceReviewComment=" + str3 + ")";
    }
}
