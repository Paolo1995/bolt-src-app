package ee.mtakso.driver.ui.screens.order.arrived;

import ee.mtakso.driver.network.client.order.TollRoad;
import ee.mtakso.driver.uicore.components.views.priceSelectorView.PriceSelectorView;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrivePriceScreenData.kt */
/* loaded from: classes3.dex */
public final class DrivePriceScreenData {

    /* renamed from: a  reason: collision with root package name */
    private final long f30997a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30998b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f30999c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31000d;

    /* renamed from: e  reason: collision with root package name */
    private final double f31001e;

    /* renamed from: f  reason: collision with root package name */
    private final String f31002f;

    /* renamed from: g  reason: collision with root package name */
    private final PriceSelectorView.CurrencyGravity f31003g;

    /* renamed from: h  reason: collision with root package name */
    private final int f31004h;

    /* renamed from: i  reason: collision with root package name */
    private final BigDecimal f31005i;

    /* renamed from: j  reason: collision with root package name */
    private final String f31006j;

    /* renamed from: k  reason: collision with root package name */
    private final BigDecimal f31007k;

    /* renamed from: l  reason: collision with root package name */
    private final BigDecimal f31008l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f31009m;

    /* renamed from: n  reason: collision with root package name */
    private final List<TollRoad> f31010n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f31011o;

    /* renamed from: p  reason: collision with root package name */
    private final PriceModificationMethod f31012p;

    /* renamed from: q  reason: collision with root package name */
    private final Map<Integer, String> f31013q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f31014r;

    public DrivePriceScreenData(long j8, String str, boolean z7, String str2, double d8, String currencySymbol, PriceSelectorView.CurrencyGravity currencyGravity, int i8, BigDecimal bigDecimal, String str3, BigDecimal originalPrice, BigDecimal bigDecimal2, boolean z8, List<TollRoad> list, boolean z9, PriceModificationMethod priceModificationMethod, Map<Integer, String> map, boolean z10) {
        Intrinsics.f(currencySymbol, "currencySymbol");
        Intrinsics.f(currencyGravity, "currencyGravity");
        Intrinsics.f(originalPrice, "originalPrice");
        Intrinsics.f(priceModificationMethod, "priceModificationMethod");
        this.f30997a = j8;
        this.f30998b = str;
        this.f30999c = z7;
        this.f31000d = str2;
        this.f31001e = d8;
        this.f31002f = currencySymbol;
        this.f31003g = currencyGravity;
        this.f31004h = i8;
        this.f31005i = bigDecimal;
        this.f31006j = str3;
        this.f31007k = originalPrice;
        this.f31008l = bigDecimal2;
        this.f31009m = z8;
        this.f31010n = list;
        this.f31011o = z9;
        this.f31012p = priceModificationMethod;
        this.f31013q = map;
        this.f31014r = z10;
    }

    public final DrivePriceScreenData a(long j8, String str, boolean z7, String str2, double d8, String currencySymbol, PriceSelectorView.CurrencyGravity currencyGravity, int i8, BigDecimal bigDecimal, String str3, BigDecimal originalPrice, BigDecimal bigDecimal2, boolean z8, List<TollRoad> list, boolean z9, PriceModificationMethod priceModificationMethod, Map<Integer, String> map, boolean z10) {
        Intrinsics.f(currencySymbol, "currencySymbol");
        Intrinsics.f(currencyGravity, "currencyGravity");
        Intrinsics.f(originalPrice, "originalPrice");
        Intrinsics.f(priceModificationMethod, "priceModificationMethod");
        return new DrivePriceScreenData(j8, str, z7, str2, d8, currencySymbol, currencyGravity, i8, bigDecimal, str3, originalPrice, bigDecimal2, z8, list, z9, priceModificationMethod, map, z10);
    }

    public final BigDecimal c() {
        return this.f31008l;
    }

    public final long d() {
        return this.f30997a;
    }

    public final String e() {
        return this.f31000d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrivePriceScreenData) {
            DrivePriceScreenData drivePriceScreenData = (DrivePriceScreenData) obj;
            return this.f30997a == drivePriceScreenData.f30997a && Intrinsics.a(this.f30998b, drivePriceScreenData.f30998b) && this.f30999c == drivePriceScreenData.f30999c && Intrinsics.a(this.f31000d, drivePriceScreenData.f31000d) && Double.compare(this.f31001e, drivePriceScreenData.f31001e) == 0 && Intrinsics.a(this.f31002f, drivePriceScreenData.f31002f) && this.f31003g == drivePriceScreenData.f31003g && this.f31004h == drivePriceScreenData.f31004h && Intrinsics.a(this.f31005i, drivePriceScreenData.f31005i) && Intrinsics.a(this.f31006j, drivePriceScreenData.f31006j) && Intrinsics.a(this.f31007k, drivePriceScreenData.f31007k) && Intrinsics.a(this.f31008l, drivePriceScreenData.f31008l) && this.f31009m == drivePriceScreenData.f31009m && Intrinsics.a(this.f31010n, drivePriceScreenData.f31010n) && this.f31011o == drivePriceScreenData.f31011o && this.f31012p == drivePriceScreenData.f31012p && Intrinsics.a(this.f31013q, drivePriceScreenData.f31013q) && this.f31014r == drivePriceScreenData.f31014r;
        }
        return false;
    }

    public final PriceSelectorView.CurrencyGravity f() {
        return this.f31003g;
    }

    public final String g() {
        return this.f31002f;
    }

    public final BigDecimal h() {
        return this.f31007k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = i0.a.a(this.f30997a) * 31;
        String str = this.f30998b;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z7 = this.f30999c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        String str2 = this.f31000d;
        int hashCode2 = (((((((((i9 + (str2 == null ? 0 : str2.hashCode())) * 31) + q1.a.a(this.f31001e)) * 31) + this.f31002f.hashCode()) * 31) + this.f31003g.hashCode()) * 31) + this.f31004h) * 31;
        BigDecimal bigDecimal = this.f31005i;
        int hashCode3 = (hashCode2 + (bigDecimal == null ? 0 : bigDecimal.hashCode())) * 31;
        String str3 = this.f31006j;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f31007k.hashCode()) * 31;
        BigDecimal bigDecimal2 = this.f31008l;
        int hashCode5 = (hashCode4 + (bigDecimal2 == null ? 0 : bigDecimal2.hashCode())) * 31;
        boolean z8 = this.f31009m;
        int i10 = z8;
        if (z8 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode5 + i10) * 31;
        List<TollRoad> list = this.f31010n;
        int hashCode6 = (i11 + (list == null ? 0 : list.hashCode())) * 31;
        boolean z9 = this.f31011o;
        int i12 = z9;
        if (z9 != 0) {
            i12 = 1;
        }
        int hashCode7 = (((hashCode6 + i12) * 31) + this.f31012p.hashCode()) * 31;
        Map<Integer, String> map = this.f31013q;
        int hashCode8 = (hashCode7 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z10 = this.f31014r;
        return hashCode8 + (z10 ? 1 : z10 ? 1 : 0);
    }

    public final int i() {
        return this.f31004h;
    }

    public final PriceModificationMethod j() {
        return this.f31012p;
    }

    public final double k() {
        return this.f31001e;
    }

    public final BigDecimal l() {
        return this.f31005i;
    }

    public final Map<Integer, String> m() {
        return this.f31013q;
    }

    public final String n() {
        return this.f30998b;
    }

    public final List<TollRoad> o() {
        return this.f31010n;
    }

    public final boolean p() {
        return this.f30999c;
    }

    public final boolean q() {
        return this.f31014r;
    }

    public final boolean r() {
        return this.f31011o;
    }

    public final boolean s() {
        return this.f31009m;
    }

    public String toString() {
        long j8 = this.f30997a;
        String str = this.f30998b;
        boolean z7 = this.f30999c;
        String str2 = this.f31000d;
        double d8 = this.f31001e;
        String str3 = this.f31002f;
        PriceSelectorView.CurrencyGravity currencyGravity = this.f31003g;
        int i8 = this.f31004h;
        BigDecimal bigDecimal = this.f31005i;
        String str4 = this.f31006j;
        BigDecimal bigDecimal2 = this.f31007k;
        BigDecimal bigDecimal3 = this.f31008l;
        boolean z8 = this.f31009m;
        List<TollRoad> list = this.f31010n;
        boolean z9 = this.f31011o;
        PriceModificationMethod priceModificationMethod = this.f31012p;
        Map<Integer, String> map = this.f31013q;
        boolean z10 = this.f31014r;
        return "DrivePriceScreenData(calculationId=" + j8 + ", recalculationReason=" + str + ", isAppPayment=" + z7 + ", clientName=" + str2 + ", priceModificationStep=" + d8 + ", currencySymbol=" + str3 + ", currencyGravity=" + currencyGravity + ", priceDecimalsFormattingRules=" + i8 + ", promoPrice=" + bigDecimal + ", promoDiscountPrice=" + str4 + ", originalPrice=" + bigDecimal2 + ", actualPrice=" + bigDecimal3 + ", isPriceReviewAllowed=" + z8 + ", tollRoads=" + list + ", isErrorWithPrice=" + z9 + ", priceModificationMethod=" + priceModificationMethod + ", ratingSubtitle=" + map + ", isAutomaticUnmatchingEnabled=" + z10 + ")";
    }

    public /* synthetic */ DrivePriceScreenData(long j8, String str, boolean z7, String str2, double d8, String str3, PriceSelectorView.CurrencyGravity currencyGravity, int i8, BigDecimal bigDecimal, String str4, BigDecimal bigDecimal2, BigDecimal bigDecimal3, boolean z8, List list, boolean z9, PriceModificationMethod priceModificationMethod, Map map, boolean z10, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(j8, str, z7, str2, d8, str3, currencyGravity, i8, bigDecimal, str4, bigDecimal2, bigDecimal3, z8, list, (i9 & 16384) != 0 ? false : z9, priceModificationMethod, map, (i9 & 131072) != 0 ? false : z10);
    }
}
