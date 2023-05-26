package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderPrice.kt */
/* loaded from: classes3.dex */
public final class Price implements Parcelable {
    public static final Parcelable.Creator<Price> CREATOR = new Creator();
    @SerializedName("total_price")

    /* renamed from: f  reason: collision with root package name */
    private final BigDecimal f22467f;
    @SerializedName("currency")

    /* renamed from: g  reason: collision with root package name */
    private final String f22468g;
    @SerializedName("currency_symbol_before")

    /* renamed from: h  reason: collision with root package name */
    private final String f22469h;
    @SerializedName("currency_symbol_after")

    /* renamed from: i  reason: collision with root package name */
    private final String f22470i;

    /* compiled from: OrderPrice.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<Price> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final Price createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new Price((BigDecimal) parcel.readSerializable(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final Price[] newArray(int i8) {
            return new Price[i8];
        }
    }

    public Price(BigDecimal bigDecimal, String str, String str2, String str3) {
        this.f22467f = bigDecimal;
        this.f22468g = str;
        this.f22469h = str2;
        this.f22470i = str3;
    }

    public final String a() {
        return this.f22470i;
    }

    public final String b() {
        return this.f22469h;
    }

    public final BigDecimal c() {
        return this.f22467f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Price) {
            Price price = (Price) obj;
            return Intrinsics.a(this.f22467f, price.f22467f) && Intrinsics.a(this.f22468g, price.f22468g) && Intrinsics.a(this.f22469h, price.f22469h) && Intrinsics.a(this.f22470i, price.f22470i);
        }
        return false;
    }

    public int hashCode() {
        BigDecimal bigDecimal = this.f22467f;
        int hashCode = (bigDecimal == null ? 0 : bigDecimal.hashCode()) * 31;
        String str = this.f22468g;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f22469h;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f22470i;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        BigDecimal bigDecimal = this.f22467f;
        String str = this.f22468g;
        String str2 = this.f22469h;
        String str3 = this.f22470i;
        return "Price(totalPrice=" + bigDecimal + ", currency=" + str + ", currencySymbolBefore=" + str2 + ", currencySymbolAfter=" + str3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeSerializable(this.f22467f);
        out.writeString(this.f22468g);
        out.writeString(this.f22469h);
        out.writeString(this.f22470i);
    }
}
