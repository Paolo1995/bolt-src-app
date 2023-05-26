package ee.mtakso.driver.network.client.driver;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Statistics.kt */
/* loaded from: classes3.dex */
public final class RidesSubPeriodData implements Parcelable {
    public static final Parcelable.Creator<RidesSubPeriodData> CREATOR = new Creator();
    @SerializedName("date")

    /* renamed from: f  reason: collision with root package name */
    private final String f22005f;
    @SerializedName("total")

    /* renamed from: g  reason: collision with root package name */
    private final int f22006g;
    @SerializedName("finished")

    /* renamed from: h  reason: collision with root package name */
    private final int f22007h;
    @SerializedName("activity_score")

    /* renamed from: i  reason: collision with root package name */
    private final int f22008i;

    /* compiled from: Statistics.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<RidesSubPeriodData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RidesSubPeriodData createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new RidesSubPeriodData(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final RidesSubPeriodData[] newArray(int i8) {
            return new RidesSubPeriodData[i8];
        }
    }

    public RidesSubPeriodData(String date, int i8, int i9, int i10) {
        Intrinsics.f(date, "date");
        this.f22005f = date;
        this.f22006g = i8;
        this.f22007h = i9;
        this.f22008i = i10;
    }

    public final int a() {
        return this.f22008i;
    }

    public final String b() {
        return this.f22005f;
    }

    public final int c() {
        return this.f22007h;
    }

    public final int d() {
        return this.f22006g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RidesSubPeriodData) {
            RidesSubPeriodData ridesSubPeriodData = (RidesSubPeriodData) obj;
            return Intrinsics.a(this.f22005f, ridesSubPeriodData.f22005f) && this.f22006g == ridesSubPeriodData.f22006g && this.f22007h == ridesSubPeriodData.f22007h && this.f22008i == ridesSubPeriodData.f22008i;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f22005f.hashCode() * 31) + this.f22006g) * 31) + this.f22007h) * 31) + this.f22008i;
    }

    public String toString() {
        String str = this.f22005f;
        int i8 = this.f22006g;
        int i9 = this.f22007h;
        int i10 = this.f22008i;
        return "RidesSubPeriodData(date=" + str + ", totalRides=" + i8 + ", finishedRides=" + i9 + ", activityScore=" + i10 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22005f);
        out.writeInt(this.f22006g);
        out.writeInt(this.f22007h);
        out.writeInt(this.f22008i);
    }
}
