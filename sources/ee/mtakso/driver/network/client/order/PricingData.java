package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PricingData.kt */
/* loaded from: classes3.dex */
public final class PricingData implements Parcelable {
    public static final Parcelable.Creator<PricingData> CREATOR = new Creator();
    @SerializedName("calculation_id")

    /* renamed from: f  reason: collision with root package name */
    private final long f22491f;
    @SerializedName("payment_type")

    /* renamed from: g  reason: collision with root package name */
    private final PaymentType f22492g;
    @SerializedName("total_price")

    /* renamed from: h  reason: collision with root package name */
    private final BigDecimal f22493h;
    @SerializedName("total_price_str")

    /* renamed from: i  reason: collision with root package name */
    private final String f22494i;
    @SerializedName("route_price")

    /* renamed from: j  reason: collision with root package name */
    private final BigDecimal f22495j;
    @SerializedName("promo_price")

    /* renamed from: k  reason: collision with root package name */
    private final BigDecimal f22496k;
    @SerializedName("promo_price_str")

    /* renamed from: l  reason: collision with root package name */
    private final String f22497l;
    @SerializedName("promo_amount")

    /* renamed from: m  reason: collision with root package name */
    private final BigDecimal f22498m;
    @SerializedName("promo_amount_str")

    /* renamed from: n  reason: collision with root package name */
    private final String f22499n;
    @SerializedName("currency")

    /* renamed from: o  reason: collision with root package name */
    private final String f22500o;
    @SerializedName("country")

    /* renamed from: p  reason: collision with root package name */
    private final String f22501p;
    @SerializedName("currency_symbol_before")

    /* renamed from: q  reason: collision with root package name */
    private final String f22502q;
    @SerializedName("currency_symbol_after")

    /* renamed from: r  reason: collision with root package name */
    private final String f22503r;
    @SerializedName("toll_roads")

    /* renamed from: s  reason: collision with root package name */
    private final List<TollRoad> f22504s;
    @SerializedName("rates")

    /* renamed from: t  reason: collision with root package name */
    private final List<PriceComponent> f22505t;
    @SerializedName("recalculation_reason")

    /* renamed from: u  reason: collision with root package name */
    private final String f22506u;
    @SerializedName("pricing_options")

    /* renamed from: v  reason: collision with root package name */
    private final PricingOptions f22507v;
    @SerializedName("rider_rating_subtitle")

    /* renamed from: w  reason: collision with root package name */
    private final Map<Integer, String> f22508w;
    @SerializedName("is_automatic_unmatching_enabled")

    /* renamed from: x  reason: collision with root package name */
    private final boolean f22509x;

    /* compiled from: PricingData.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PricingData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PricingData createFromParcel(Parcel parcel) {
            String str;
            ArrayList arrayList;
            LinkedHashMap linkedHashMap;
            ArrayList arrayList2;
            String str2;
            Intrinsics.f(parcel, "parcel");
            long readLong = parcel.readLong();
            PaymentType valueOf = parcel.readInt() == 0 ? null : PaymentType.valueOf(parcel.readString());
            BigDecimal bigDecimal = (BigDecimal) parcel.readSerializable();
            String readString = parcel.readString();
            BigDecimal bigDecimal2 = (BigDecimal) parcel.readSerializable();
            BigDecimal bigDecimal3 = (BigDecimal) parcel.readSerializable();
            String readString2 = parcel.readString();
            BigDecimal bigDecimal4 = (BigDecimal) parcel.readSerializable();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            if (parcel.readInt() == 0) {
                str = readString6;
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(readInt);
                str = readString6;
                int i8 = 0;
                while (i8 != readInt) {
                    arrayList3.add(TollRoad.CREATOR.createFromParcel(parcel));
                    i8++;
                    readInt = readInt;
                }
                arrayList = arrayList3;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(readInt2);
            ArrayList arrayList5 = arrayList;
            int i9 = 0;
            while (i9 != readInt2) {
                arrayList4.add(PriceComponent.CREATOR.createFromParcel(parcel));
                i9++;
                readInt2 = readInt2;
            }
            String readString8 = parcel.readString();
            PricingOptions createFromParcel = parcel.readInt() == 0 ? null : PricingOptions.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                str2 = readString8;
                arrayList2 = arrayList4;
                linkedHashMap = null;
            } else {
                int readInt3 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt3);
                arrayList2 = arrayList4;
                int i10 = 0;
                while (i10 != readInt3) {
                    linkedHashMap.put(Integer.valueOf(parcel.readInt()), parcel.readString());
                    i10++;
                    readString8 = readString8;
                    readInt3 = readInt3;
                }
                str2 = readString8;
            }
            return new PricingData(readLong, valueOf, bigDecimal, readString, bigDecimal2, bigDecimal3, readString2, bigDecimal4, readString3, readString4, readString5, str, readString7, arrayList5, arrayList2, str2, createFromParcel, linkedHashMap, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final PricingData[] newArray(int i8) {
            return new PricingData[i8];
        }
    }

    public PricingData(long j8, PaymentType paymentType, BigDecimal totalPrice, String totalPriceString, BigDecimal originalPriceWithoutExtras, BigDecimal bigDecimal, String promoPriceStr, BigDecimal bigDecimal2, String promoDiscountStr, String currency, String country, String currencySymbolBefore, String currencySymbolAfter, List<TollRoad> list, List<PriceComponent> rates, String str, PricingOptions pricingOptions, Map<Integer, String> map, boolean z7) {
        Intrinsics.f(totalPrice, "totalPrice");
        Intrinsics.f(totalPriceString, "totalPriceString");
        Intrinsics.f(originalPriceWithoutExtras, "originalPriceWithoutExtras");
        Intrinsics.f(promoPriceStr, "promoPriceStr");
        Intrinsics.f(promoDiscountStr, "promoDiscountStr");
        Intrinsics.f(currency, "currency");
        Intrinsics.f(country, "country");
        Intrinsics.f(currencySymbolBefore, "currencySymbolBefore");
        Intrinsics.f(currencySymbolAfter, "currencySymbolAfter");
        Intrinsics.f(rates, "rates");
        this.f22491f = j8;
        this.f22492g = paymentType;
        this.f22493h = totalPrice;
        this.f22494i = totalPriceString;
        this.f22495j = originalPriceWithoutExtras;
        this.f22496k = bigDecimal;
        this.f22497l = promoPriceStr;
        this.f22498m = bigDecimal2;
        this.f22499n = promoDiscountStr;
        this.f22500o = currency;
        this.f22501p = country;
        this.f22502q = currencySymbolBefore;
        this.f22503r = currencySymbolAfter;
        this.f22504s = list;
        this.f22505t = rates;
        this.f22506u = str;
        this.f22507v = pricingOptions;
        this.f22508w = map;
        this.f22509x = z7;
    }

    public final long a() {
        return this.f22491f;
    }

    public final String b() {
        return this.f22503r;
    }

    public final String c() {
        return this.f22502q;
    }

    public final PricingOptions d() {
        return this.f22507v;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f22499n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PricingData) {
            PricingData pricingData = (PricingData) obj;
            return this.f22491f == pricingData.f22491f && this.f22492g == pricingData.f22492g && Intrinsics.a(this.f22493h, pricingData.f22493h) && Intrinsics.a(this.f22494i, pricingData.f22494i) && Intrinsics.a(this.f22495j, pricingData.f22495j) && Intrinsics.a(this.f22496k, pricingData.f22496k) && Intrinsics.a(this.f22497l, pricingData.f22497l) && Intrinsics.a(this.f22498m, pricingData.f22498m) && Intrinsics.a(this.f22499n, pricingData.f22499n) && Intrinsics.a(this.f22500o, pricingData.f22500o) && Intrinsics.a(this.f22501p, pricingData.f22501p) && Intrinsics.a(this.f22502q, pricingData.f22502q) && Intrinsics.a(this.f22503r, pricingData.f22503r) && Intrinsics.a(this.f22504s, pricingData.f22504s) && Intrinsics.a(this.f22505t, pricingData.f22505t) && Intrinsics.a(this.f22506u, pricingData.f22506u) && Intrinsics.a(this.f22507v, pricingData.f22507v) && Intrinsics.a(this.f22508w, pricingData.f22508w) && this.f22509x == pricingData.f22509x;
        }
        return false;
    }

    public final BigDecimal f() {
        return this.f22496k;
    }

    public final Map<Integer, String> g() {
        return this.f22508w;
    }

    public final PaymentType h() {
        return this.f22492g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = i0.a.a(this.f22491f) * 31;
        PaymentType paymentType = this.f22492g;
        int hashCode = (((((((a8 + (paymentType == null ? 0 : paymentType.hashCode())) * 31) + this.f22493h.hashCode()) * 31) + this.f22494i.hashCode()) * 31) + this.f22495j.hashCode()) * 31;
        BigDecimal bigDecimal = this.f22496k;
        int hashCode2 = (((hashCode + (bigDecimal == null ? 0 : bigDecimal.hashCode())) * 31) + this.f22497l.hashCode()) * 31;
        BigDecimal bigDecimal2 = this.f22498m;
        int hashCode3 = (((((((((((hashCode2 + (bigDecimal2 == null ? 0 : bigDecimal2.hashCode())) * 31) + this.f22499n.hashCode()) * 31) + this.f22500o.hashCode()) * 31) + this.f22501p.hashCode()) * 31) + this.f22502q.hashCode()) * 31) + this.f22503r.hashCode()) * 31;
        List<TollRoad> list = this.f22504s;
        int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f22505t.hashCode()) * 31;
        String str = this.f22506u;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        PricingOptions pricingOptions = this.f22507v;
        int hashCode6 = (hashCode5 + (pricingOptions == null ? 0 : pricingOptions.hashCode())) * 31;
        Map<Integer, String> map = this.f22508w;
        int hashCode7 = (hashCode6 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z7 = this.f22509x;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode7 + i8;
    }

    public final String i() {
        return this.f22506u;
    }

    public final List<TollRoad> j() {
        return this.f22504s;
    }

    public final BigDecimal l() {
        return this.f22493h;
    }

    public final boolean n() {
        return this.f22509x;
    }

    public String toString() {
        long j8 = this.f22491f;
        PaymentType paymentType = this.f22492g;
        BigDecimal bigDecimal = this.f22493h;
        String str = this.f22494i;
        BigDecimal bigDecimal2 = this.f22495j;
        BigDecimal bigDecimal3 = this.f22496k;
        String str2 = this.f22497l;
        BigDecimal bigDecimal4 = this.f22498m;
        String str3 = this.f22499n;
        String str4 = this.f22500o;
        String str5 = this.f22501p;
        String str6 = this.f22502q;
        String str7 = this.f22503r;
        List<TollRoad> list = this.f22504s;
        List<PriceComponent> list2 = this.f22505t;
        String str8 = this.f22506u;
        PricingOptions pricingOptions = this.f22507v;
        Map<Integer, String> map = this.f22508w;
        boolean z7 = this.f22509x;
        return "PricingData(calculationId=" + j8 + ", rawPaymentType=" + paymentType + ", totalPrice=" + bigDecimal + ", totalPriceString=" + str + ", originalPriceWithoutExtras=" + bigDecimal2 + ", promoPrice=" + bigDecimal3 + ", promoPriceStr=" + str2 + ", promoDiscount=" + bigDecimal4 + ", promoDiscountStr=" + str3 + ", currency=" + str4 + ", country=" + str5 + ", currencySymbolBefore=" + str6 + ", currencySymbolAfter=" + str7 + ", tollRoads=" + list + ", rates=" + list2 + ", recalculationReason=" + str8 + ", pricingOptions=" + pricingOptions + ", ratingSubtitle=" + map + ", isAutomaticUnmatchingEnabled=" + z7 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeLong(this.f22491f);
        PaymentType paymentType = this.f22492g;
        if (paymentType == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(paymentType.name());
        }
        out.writeSerializable(this.f22493h);
        out.writeString(this.f22494i);
        out.writeSerializable(this.f22495j);
        out.writeSerializable(this.f22496k);
        out.writeString(this.f22497l);
        out.writeSerializable(this.f22498m);
        out.writeString(this.f22499n);
        out.writeString(this.f22500o);
        out.writeString(this.f22501p);
        out.writeString(this.f22502q);
        out.writeString(this.f22503r);
        List<TollRoad> list = this.f22504s;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            for (TollRoad tollRoad : list) {
                tollRoad.writeToParcel(out, i8);
            }
        }
        List<PriceComponent> list2 = this.f22505t;
        out.writeInt(list2.size());
        for (PriceComponent priceComponent : list2) {
            priceComponent.writeToParcel(out, i8);
        }
        out.writeString(this.f22506u);
        PricingOptions pricingOptions = this.f22507v;
        if (pricingOptions == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            pricingOptions.writeToParcel(out, i8);
        }
        Map<Integer, String> map = this.f22508w;
        if (map == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(map.size());
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                out.writeInt(entry.getKey().intValue());
                out.writeString(entry.getValue());
            }
        }
        out.writeInt(this.f22509x ? 1 : 0);
    }
}
