package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderPrice.kt */
/* loaded from: classes3.dex */
public final class PriceComponent implements Parcelable {
    public static final Parcelable.Creator<PriceComponent> CREATOR = new Creator();
    @SerializedName("type")

    /* renamed from: f  reason: collision with root package name */
    private final String f22471f;
    @SerializedName("rate")

    /* renamed from: g  reason: collision with root package name */
    private final double f22472g;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: h  reason: collision with root package name */
    private final double f22473h;
    @SerializedName("unit")

    /* renamed from: i  reason: collision with root package name */
    private final String f22474i;
    @SerializedName("name")

    /* renamed from: j  reason: collision with root package name */
    private final String f22475j;
    @SerializedName("price")

    /* renamed from: k  reason: collision with root package name */
    private final double f22476k;
    @SerializedName("external_id")

    /* renamed from: l  reason: collision with root package name */
    private final Long f22477l;

    /* compiled from: OrderPrice.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PriceComponent> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PriceComponent createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new PriceComponent(parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final PriceComponent[] newArray(int i8) {
            return new PriceComponent[i8];
        }
    }

    public PriceComponent(String type, double d8, double d9, String unit, String str, double d10, Long l8) {
        Intrinsics.f(type, "type");
        Intrinsics.f(unit, "unit");
        this.f22471f = type;
        this.f22472g = d8;
        this.f22473h = d9;
        this.f22474i = unit;
        this.f22475j = str;
        this.f22476k = d10;
        this.f22477l = l8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PriceComponent) {
            PriceComponent priceComponent = (PriceComponent) obj;
            return Intrinsics.a(this.f22471f, priceComponent.f22471f) && Double.compare(this.f22472g, priceComponent.f22472g) == 0 && Double.compare(this.f22473h, priceComponent.f22473h) == 0 && Intrinsics.a(this.f22474i, priceComponent.f22474i) && Intrinsics.a(this.f22475j, priceComponent.f22475j) && Double.compare(this.f22476k, priceComponent.f22476k) == 0 && Intrinsics.a(this.f22477l, priceComponent.f22477l);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.f22471f.hashCode() * 31) + q1.a.a(this.f22472g)) * 31) + q1.a.a(this.f22473h)) * 31) + this.f22474i.hashCode()) * 31;
        String str = this.f22475j;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + q1.a.a(this.f22476k)) * 31;
        Long l8 = this.f22477l;
        return hashCode2 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22471f;
        double d8 = this.f22472g;
        double d9 = this.f22473h;
        String str2 = this.f22474i;
        String str3 = this.f22475j;
        double d10 = this.f22476k;
        Long l8 = this.f22477l;
        return "PriceComponent(type=" + str + ", rate=" + d8 + ", value=" + d9 + ", unit=" + str2 + ", name=" + str3 + ", price=" + d10 + ", externalId=" + l8 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22471f);
        out.writeDouble(this.f22472g);
        out.writeDouble(this.f22473h);
        out.writeString(this.f22474i);
        out.writeString(this.f22475j);
        out.writeDouble(this.f22476k);
        Long l8 = this.f22477l;
        if (l8 == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeLong(l8.longValue());
    }
}
