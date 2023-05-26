package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderPrice.kt */
/* loaded from: classes3.dex */
public final class TollRoad implements Parcelable {
    public static final Parcelable.Creator<TollRoad> CREATOR = new Creator();
    @SerializedName("name")

    /* renamed from: f  reason: collision with root package name */
    private final String f22602f;
    @SerializedName("price_str")

    /* renamed from: g  reason: collision with root package name */
    private final String f22603g;

    /* compiled from: OrderPrice.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<TollRoad> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TollRoad createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new TollRoad(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final TollRoad[] newArray(int i8) {
            return new TollRoad[i8];
        }
    }

    public TollRoad(String tollRoadName, String tollRoadPrice) {
        Intrinsics.f(tollRoadName, "tollRoadName");
        Intrinsics.f(tollRoadPrice, "tollRoadPrice");
        this.f22602f = tollRoadName;
        this.f22603g = tollRoadPrice;
    }

    public final String a() {
        return this.f22602f;
    }

    public final String b() {
        return this.f22603g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TollRoad) {
            TollRoad tollRoad = (TollRoad) obj;
            return Intrinsics.a(this.f22602f, tollRoad.f22602f) && Intrinsics.a(this.f22603g, tollRoad.f22603g);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22602f.hashCode() * 31) + this.f22603g.hashCode();
    }

    public String toString() {
        String str = this.f22602f;
        String str2 = this.f22603g;
        return "TollRoad(tollRoadName=" + str + ", tollRoadPrice=" + str2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22602f);
        out.writeString(this.f22603g);
    }
}
