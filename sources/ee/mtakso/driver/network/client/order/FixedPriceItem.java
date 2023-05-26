package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: OrderPrice.kt */
/* loaded from: classes3.dex */
public final class FixedPriceItem implements Parcelable {
    public static final Parcelable.Creator<FixedPriceItem> CREATOR = new Creator();
    @SerializedName(Name.MARK)

    /* renamed from: f  reason: collision with root package name */
    private final long f22374f;
    @SerializedName("name")

    /* renamed from: g  reason: collision with root package name */
    private final String f22375g;
    @SerializedName("price_str")

    /* renamed from: h  reason: collision with root package name */
    private final String f22376h;

    /* compiled from: OrderPrice.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<FixedPriceItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final FixedPriceItem createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new FixedPriceItem(parcel.readLong(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final FixedPriceItem[] newArray(int i8) {
            return new FixedPriceItem[i8];
        }
    }

    public FixedPriceItem(long j8, String title, String priceStr) {
        Intrinsics.f(title, "title");
        Intrinsics.f(priceStr, "priceStr");
        this.f22374f = j8;
        this.f22375g = title;
        this.f22376h = priceStr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FixedPriceItem) {
            FixedPriceItem fixedPriceItem = (FixedPriceItem) obj;
            return this.f22374f == fixedPriceItem.f22374f && Intrinsics.a(this.f22375g, fixedPriceItem.f22375g) && Intrinsics.a(this.f22376h, fixedPriceItem.f22376h);
        }
        return false;
    }

    public int hashCode() {
        return (((i0.a.a(this.f22374f) * 31) + this.f22375g.hashCode()) * 31) + this.f22376h.hashCode();
    }

    public String toString() {
        long j8 = this.f22374f;
        String str = this.f22375g;
        String str2 = this.f22376h;
        return "FixedPriceItem(id=" + j8 + ", title=" + str + ", priceStr=" + str2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeLong(this.f22374f);
        out.writeString(this.f22375g);
        out.writeString(this.f22376h);
    }
}
