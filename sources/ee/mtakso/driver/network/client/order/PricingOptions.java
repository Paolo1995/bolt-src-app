package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderPrice.kt */
/* loaded from: classes3.dex */
public final class PricingOptions implements Parcelable {
    public static final Parcelable.Creator<PricingOptions> CREATOR = new Creator();
    @SerializedName("extras")

    /* renamed from: f  reason: collision with root package name */
    private final List<ExtraFeeItem> f22510f;
    @SerializedName("fixed_routes")

    /* renamed from: g  reason: collision with root package name */
    private final List<FixedPriceItem> f22511g;
    @SerializedName("price_modification_step")

    /* renamed from: h  reason: collision with root package name */
    private final Double f22512h;
    @SerializedName("price_modification_allowed")

    /* renamed from: i  reason: collision with root package name */
    private final Integer f22513i;
    @SerializedName("price_review_allowed")

    /* renamed from: j  reason: collision with root package name */
    private final Integer f22514j;
    @SerializedName("price_modification_type")

    /* renamed from: k  reason: collision with root package name */
    private final PriceModificationType f22515k;
    @SerializedName("price_modification_range_percent")

    /* renamed from: l  reason: collision with root package name */
    private final BigDecimal f22516l;
    @SerializedName("price_rounding")

    /* renamed from: m  reason: collision with root package name */
    private final Integer f22517m;

    /* compiled from: OrderPrice.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PricingOptions> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PricingOptions createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(readInt);
                for (int i8 = 0; i8 != readInt; i8++) {
                    arrayList3.add(ExtraFeeItem.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList3;
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt2);
                for (int i9 = 0; i9 != readInt2; i9++) {
                    arrayList4.add(FixedPriceItem.CREATOR.createFromParcel(parcel));
                }
                arrayList2 = arrayList4;
            }
            return new PricingOptions(arrayList, arrayList2, parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : PriceModificationType.valueOf(parcel.readString()), (BigDecimal) parcel.readSerializable(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final PricingOptions[] newArray(int i8) {
            return new PricingOptions[i8];
        }
    }

    public PricingOptions(List<ExtraFeeItem> list, List<FixedPriceItem> list2, Double d8, Integer num, Integer num2, PriceModificationType priceModificationType, BigDecimal priceModificationRangePercent, Integer num3) {
        Intrinsics.f(priceModificationRangePercent, "priceModificationRangePercent");
        this.f22510f = list;
        this.f22511g = list2;
        this.f22512h = d8;
        this.f22513i = num;
        this.f22514j = num2;
        this.f22515k = priceModificationType;
        this.f22516l = priceModificationRangePercent;
        this.f22517m = num3;
    }

    public final Double a() {
        return this.f22512h;
    }

    public final PriceModificationType b() {
        return this.f22515k;
    }

    public final Integer c() {
        return this.f22514j;
    }

    public final Integer d() {
        return this.f22517m;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PricingOptions) {
            PricingOptions pricingOptions = (PricingOptions) obj;
            return Intrinsics.a(this.f22510f, pricingOptions.f22510f) && Intrinsics.a(this.f22511g, pricingOptions.f22511g) && Intrinsics.a(this.f22512h, pricingOptions.f22512h) && Intrinsics.a(this.f22513i, pricingOptions.f22513i) && Intrinsics.a(this.f22514j, pricingOptions.f22514j) && this.f22515k == pricingOptions.f22515k && Intrinsics.a(this.f22516l, pricingOptions.f22516l) && Intrinsics.a(this.f22517m, pricingOptions.f22517m);
        }
        return false;
    }

    public int hashCode() {
        List<ExtraFeeItem> list = this.f22510f;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<FixedPriceItem> list2 = this.f22511g;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        Double d8 = this.f22512h;
        int hashCode3 = (hashCode2 + (d8 == null ? 0 : d8.hashCode())) * 31;
        Integer num = this.f22513i;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f22514j;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        PriceModificationType priceModificationType = this.f22515k;
        int hashCode6 = (((hashCode5 + (priceModificationType == null ? 0 : priceModificationType.hashCode())) * 31) + this.f22516l.hashCode()) * 31;
        Integer num3 = this.f22517m;
        return hashCode6 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        List<ExtraFeeItem> list = this.f22510f;
        List<FixedPriceItem> list2 = this.f22511g;
        Double d8 = this.f22512h;
        Integer num = this.f22513i;
        Integer num2 = this.f22514j;
        PriceModificationType priceModificationType = this.f22515k;
        BigDecimal bigDecimal = this.f22516l;
        Integer num3 = this.f22517m;
        return "PricingOptions(listOfAvailableExtras=" + list + ", listOfAvailableFixedRoutes=" + list2 + ", priceModificationStep=" + d8 + ", priceModificationAllowed=" + num + ", priceReviewAllowed=" + num2 + ", priceModificationType=" + priceModificationType + ", priceModificationRangePercent=" + bigDecimal + ", priceRounding=" + num3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        List<ExtraFeeItem> list = this.f22510f;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            for (ExtraFeeItem extraFeeItem : list) {
                extraFeeItem.writeToParcel(out, i8);
            }
        }
        List<FixedPriceItem> list2 = this.f22511g;
        if (list2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list2.size());
            for (FixedPriceItem fixedPriceItem : list2) {
                fixedPriceItem.writeToParcel(out, i8);
            }
        }
        Double d8 = this.f22512h;
        if (d8 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeDouble(d8.doubleValue());
        }
        Integer num = this.f22513i;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.f22514j;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        PriceModificationType priceModificationType = this.f22515k;
        if (priceModificationType == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(priceModificationType.name());
        }
        out.writeSerializable(this.f22516l);
        Integer num3 = this.f22517m;
        if (num3 == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(num3.intValue());
    }
}
