package ee.mtakso.driver.ui.screens.order.arrived.raterider;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RiderRatingInfo.kt */
/* loaded from: classes3.dex */
public final class RiderRatingInfo implements Parcelable {
    public static final Parcelable.Creator<RiderRatingInfo> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f31215f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31216g;

    /* renamed from: h  reason: collision with root package name */
    private final int f31217h;

    /* compiled from: RiderRatingInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<RiderRatingInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RiderRatingInfo createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new RiderRatingInfo(parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final RiderRatingInfo[] newArray(int i8) {
            return new RiderRatingInfo[i8];
        }
    }

    public RiderRatingInfo(String str, String comment, int i8) {
        Intrinsics.f(comment, "comment");
        this.f31215f = str;
        this.f31216g = comment;
        this.f31217h = i8;
    }

    public final String a() {
        return this.f31216g;
    }

    public final String b() {
        return this.f31215f;
    }

    public final int c() {
        return this.f31217h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RiderRatingInfo) {
            RiderRatingInfo riderRatingInfo = (RiderRatingInfo) obj;
            return Intrinsics.a(this.f31215f, riderRatingInfo.f31215f) && Intrinsics.a(this.f31216g, riderRatingInfo.f31216g) && this.f31217h == riderRatingInfo.f31217h;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f31215f;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.f31216g.hashCode()) * 31) + this.f31217h;
    }

    public String toString() {
        String str = this.f31215f;
        String str2 = this.f31216g;
        int i8 = this.f31217h;
        return "RiderRatingInfo(problem=" + str + ", comment=" + str2 + ", rating=" + i8 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f31215f);
        out.writeString(this.f31216g);
        out.writeInt(this.f31217h);
    }
}
