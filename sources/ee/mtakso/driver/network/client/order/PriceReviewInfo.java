package ee.mtakso.driver.network.client.order;

import java.math.BigDecimal;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PriceReviewInfo.kt */
/* loaded from: classes3.dex */
public final class PriceReviewInfo {

    /* renamed from: a  reason: collision with root package name */
    private final long f22478a;

    /* renamed from: b  reason: collision with root package name */
    private final BigDecimal f22479b;

    /* renamed from: c  reason: collision with root package name */
    private final BigDecimal f22480c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22481d;

    /* renamed from: e  reason: collision with root package name */
    private final String f22482e;

    /* renamed from: f  reason: collision with root package name */
    private final String f22483f;

    /* renamed from: g  reason: collision with root package name */
    private final String f22484g;

    public PriceReviewInfo(long j8, BigDecimal resultPrice, BigDecimal promoPrice, boolean z7, String str, String str2, String str3) {
        Intrinsics.f(resultPrice, "resultPrice");
        Intrinsics.f(promoPrice, "promoPrice");
        this.f22478a = j8;
        this.f22479b = resultPrice;
        this.f22480c = promoPrice;
        this.f22481d = z7;
        this.f22482e = str;
        this.f22483f = str2;
        this.f22484g = str3;
    }

    public final PriceReviewInfo a(long j8, BigDecimal resultPrice, BigDecimal promoPrice, boolean z7, String str, String str2, String str3) {
        Intrinsics.f(resultPrice, "resultPrice");
        Intrinsics.f(promoPrice, "promoPrice");
        return new PriceReviewInfo(j8, resultPrice, promoPrice, z7, str, str2, str3);
    }

    public final long c() {
        return this.f22478a;
    }

    public final String d() {
        return this.f22483f;
    }

    public final String e() {
        return this.f22482e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PriceReviewInfo) {
            PriceReviewInfo priceReviewInfo = (PriceReviewInfo) obj;
            return this.f22478a == priceReviewInfo.f22478a && Intrinsics.a(this.f22479b, priceReviewInfo.f22479b) && Intrinsics.a(this.f22480c, priceReviewInfo.f22480c) && this.f22481d == priceReviewInfo.f22481d && Intrinsics.a(this.f22482e, priceReviewInfo.f22482e) && Intrinsics.a(this.f22483f, priceReviewInfo.f22483f) && Intrinsics.a(this.f22484g, priceReviewInfo.f22484g);
        }
        return false;
    }

    public final String f() {
        return this.f22484g;
    }

    public final BigDecimal g() {
        return this.f22479b;
    }

    public final boolean h() {
        return this.f22481d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = ((((i0.a.a(this.f22478a) * 31) + this.f22479b.hashCode()) * 31) + this.f22480c.hashCode()) * 31;
        boolean z7 = this.f22481d;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (a8 + i8) * 31;
        String str = this.f22482e;
        int hashCode = (i9 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f22483f;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f22484g;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        long j8 = this.f22478a;
        BigDecimal bigDecimal = this.f22479b;
        BigDecimal bigDecimal2 = this.f22480c;
        boolean z7 = this.f22481d;
        String str = this.f22482e;
        String str2 = this.f22483f;
        String str3 = this.f22484g;
        return "PriceReviewInfo(calculationId=" + j8 + ", resultPrice=" + bigDecimal + ", promoPrice=" + bigDecimal2 + ", isNeeded=" + z7 + ", price=" + str + ", comment=" + str2 + ", reasonCode=" + str3 + ")";
    }

    public /* synthetic */ PriceReviewInfo(long j8, BigDecimal bigDecimal, BigDecimal bigDecimal2, boolean z7, String str, String str2, String str3, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j8, bigDecimal, bigDecimal2, (i8 & 8) != 0 ? false : z7, (i8 & 16) != 0 ? null : str, (i8 & 32) != 0 ? null : str2, (i8 & 64) != 0 ? null : str3);
    }
}
