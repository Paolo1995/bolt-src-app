package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveOrder.kt */
/* loaded from: classes3.dex */
public final class OptionalRideInfo implements Parcelable {
    public static final Parcelable.Creator<OptionalRideInfo> CREATOR = new Creator();
    @SerializedName("title")

    /* renamed from: f  reason: collision with root package name */
    private final String f22380f;
    @SerializedName("body")

    /* renamed from: g  reason: collision with root package name */
    private final String f22381g;

    /* compiled from: ActiveOrder.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<OptionalRideInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final OptionalRideInfo createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new OptionalRideInfo(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final OptionalRideInfo[] newArray(int i8) {
            return new OptionalRideInfo[i8];
        }
    }

    public OptionalRideInfo(String title, String body) {
        Intrinsics.f(title, "title");
        Intrinsics.f(body, "body");
        this.f22380f = title;
        this.f22381g = body;
    }

    public final String a() {
        return this.f22381g;
    }

    public final String b() {
        return this.f22380f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OptionalRideInfo) {
            OptionalRideInfo optionalRideInfo = (OptionalRideInfo) obj;
            return Intrinsics.a(this.f22380f, optionalRideInfo.f22380f) && Intrinsics.a(this.f22381g, optionalRideInfo.f22381g);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22380f.hashCode() * 31) + this.f22381g.hashCode();
    }

    public String toString() {
        String str = this.f22380f;
        String str2 = this.f22381g;
        return "OptionalRideInfo(title=" + str + ", body=" + str2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22380f);
        out.writeString(this.f22381g);
    }
}
