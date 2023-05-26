package ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PriceReviewResult.kt */
/* loaded from: classes3.dex */
public final class PriceReviewResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f31144a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31145b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31146c;

    public PriceReviewResult(String expectedPrice, String reviewComment, String reviewCode) {
        Intrinsics.f(expectedPrice, "expectedPrice");
        Intrinsics.f(reviewComment, "reviewComment");
        Intrinsics.f(reviewCode, "reviewCode");
        this.f31144a = expectedPrice;
        this.f31145b = reviewComment;
        this.f31146c = reviewCode;
    }

    public final String a() {
        return this.f31144a;
    }

    public final String b() {
        return this.f31146c;
    }

    public final String c() {
        return this.f31145b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PriceReviewResult) {
            PriceReviewResult priceReviewResult = (PriceReviewResult) obj;
            return Intrinsics.a(this.f31144a, priceReviewResult.f31144a) && Intrinsics.a(this.f31145b, priceReviewResult.f31145b) && Intrinsics.a(this.f31146c, priceReviewResult.f31146c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f31144a.hashCode() * 31) + this.f31145b.hashCode()) * 31) + this.f31146c.hashCode();
    }

    public String toString() {
        String str = this.f31144a;
        String str2 = this.f31145b;
        String str3 = this.f31146c;
        return "PriceReviewResult(expectedPrice=" + str + ", reviewComment=" + str2 + ", reviewCode=" + str3 + ")";
    }
}
