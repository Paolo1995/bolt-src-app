package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: OrderPrice.kt */
/* loaded from: classes3.dex */
public final class ExtraFeeItem implements Parcelable {
    public static final Parcelable.Creator<ExtraFeeItem> CREATOR = new Creator();
    @SerializedName(Name.MARK)

    /* renamed from: f  reason: collision with root package name */
    private final long f22347f;
    @SerializedName("name")

    /* renamed from: g  reason: collision with root package name */
    private final String f22348g;
    @SerializedName("price_str")

    /* renamed from: h  reason: collision with root package name */
    private final String f22349h;

    /* compiled from: OrderPrice.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<ExtraFeeItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ExtraFeeItem createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new ExtraFeeItem(parcel.readLong(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final ExtraFeeItem[] newArray(int i8) {
            return new ExtraFeeItem[i8];
        }
    }

    public ExtraFeeItem(long j8, String title, String priceStr) {
        Intrinsics.f(title, "title");
        Intrinsics.f(priceStr, "priceStr");
        this.f22347f = j8;
        this.f22348g = title;
        this.f22349h = priceStr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExtraFeeItem) {
            ExtraFeeItem extraFeeItem = (ExtraFeeItem) obj;
            return this.f22347f == extraFeeItem.f22347f && Intrinsics.a(this.f22348g, extraFeeItem.f22348g) && Intrinsics.a(this.f22349h, extraFeeItem.f22349h);
        }
        return false;
    }

    public int hashCode() {
        return (((i0.a.a(this.f22347f) * 31) + this.f22348g.hashCode()) * 31) + this.f22349h.hashCode();
    }

    public String toString() {
        long j8 = this.f22347f;
        String str = this.f22348g;
        String str2 = this.f22349h;
        return "ExtraFeeItem(id=" + j8 + ", title=" + str + ", priceStr=" + str2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeLong(this.f22347f);
        out.writeString(this.f22348g);
        out.writeString(this.f22349h);
    }
}
