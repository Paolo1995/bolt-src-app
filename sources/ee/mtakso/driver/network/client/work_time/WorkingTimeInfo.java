package ee.mtakso.driver.network.client.work_time;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkTime.kt */
/* loaded from: classes3.dex */
public final class WorkingTimeInfo implements Parcelable {
    public static final Parcelable.Creator<WorkingTimeInfo> CREATOR = new Creator();
    @SerializedName("working_time_left_str")

    /* renamed from: f  reason: collision with root package name */
    private final String f22916f;
    @SerializedName("working_time_left_in_seconds")

    /* renamed from: g  reason: collision with root package name */
    private final long f22917g;
    @SerializedName("time_left_until_working_time_reset_str")

    /* renamed from: h  reason: collision with root package name */
    private final String f22918h;
    @SerializedName("time_left_until_working_time_reset_in_seconds")

    /* renamed from: i  reason: collision with root package name */
    private final Long f22919i;
    @SerializedName("working_time_limit_in_hours")

    /* renamed from: j  reason: collision with root package name */
    private final Integer f22920j;
    @SerializedName("offline_time_limit_in_hours")

    /* renamed from: k  reason: collision with root package name */
    private final Integer f22921k;
    @SerializedName("rolling_time_window_in_hours")

    /* renamed from: l  reason: collision with root package name */
    private final Integer f22922l;
    @SerializedName("rolling_allowed_working_time_in_hours")

    /* renamed from: m  reason: collision with root package name */
    private final Integer f22923m;
    @SerializedName("rolling_active_driving_str")

    /* renamed from: n  reason: collision with root package name */
    private final String f22924n;

    /* compiled from: WorkTime.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<WorkingTimeInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final WorkingTimeInfo createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new WorkingTimeInfo(parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final WorkingTimeInfo[] newArray(int i8) {
            return new WorkingTimeInfo[i8];
        }
    }

    public WorkingTimeInfo(String workingTimeLeft, long j8, String str, Long l8, Integer num, Integer num2, Integer num3, Integer num4, String drivingTime) {
        Intrinsics.f(workingTimeLeft, "workingTimeLeft");
        Intrinsics.f(drivingTime, "drivingTime");
        this.f22916f = workingTimeLeft;
        this.f22917g = j8;
        this.f22918h = str;
        this.f22919i = l8;
        this.f22920j = num;
        this.f22921k = num2;
        this.f22922l = num3;
        this.f22923m = num4;
        this.f22924n = drivingTime;
    }

    public final String a() {
        return this.f22924n;
    }

    public final Integer b() {
        return this.f22921k;
    }

    public final Integer c() {
        return this.f22923m;
    }

    public final Integer d() {
        return this.f22922l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f22918h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WorkingTimeInfo) {
            WorkingTimeInfo workingTimeInfo = (WorkingTimeInfo) obj;
            return Intrinsics.a(this.f22916f, workingTimeInfo.f22916f) && this.f22917g == workingTimeInfo.f22917g && Intrinsics.a(this.f22918h, workingTimeInfo.f22918h) && Intrinsics.a(this.f22919i, workingTimeInfo.f22919i) && Intrinsics.a(this.f22920j, workingTimeInfo.f22920j) && Intrinsics.a(this.f22921k, workingTimeInfo.f22921k) && Intrinsics.a(this.f22922l, workingTimeInfo.f22922l) && Intrinsics.a(this.f22923m, workingTimeInfo.f22923m) && Intrinsics.a(this.f22924n, workingTimeInfo.f22924n);
        }
        return false;
    }

    public final String f() {
        return this.f22916f;
    }

    public final long g() {
        return this.f22917g;
    }

    public final Integer h() {
        return this.f22920j;
    }

    public int hashCode() {
        int hashCode = ((this.f22916f.hashCode() * 31) + a.a(this.f22917g)) * 31;
        String str = this.f22918h;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l8 = this.f22919i;
        int hashCode3 = (hashCode2 + (l8 == null ? 0 : l8.hashCode())) * 31;
        Integer num = this.f22920j;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f22921k;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f22922l;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f22923m;
        return ((hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 31) + this.f22924n.hashCode();
    }

    public String toString() {
        String str = this.f22916f;
        long j8 = this.f22917g;
        String str2 = this.f22918h;
        Long l8 = this.f22919i;
        Integer num = this.f22920j;
        Integer num2 = this.f22921k;
        Integer num3 = this.f22922l;
        Integer num4 = this.f22923m;
        String str3 = this.f22924n;
        return "WorkingTimeInfo(workingTimeLeft=" + str + ", workingTimeLeftInSeconds=" + j8 + ", timeLeftUntilWorkingTimeReset=" + str2 + ", timeLeftUntilWorkingTimeResetInSeconds=" + l8 + ", workingTimeLimitInHours=" + num + ", offlineTimeLimitInHours=" + num2 + ", rollingTimeWindowInHours=" + num3 + ", rollingAllowedWorkingTimeInHours=" + num4 + ", drivingTime=" + str3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22916f);
        out.writeLong(this.f22917g);
        out.writeString(this.f22918h);
        Long l8 = this.f22919i;
        if (l8 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l8.longValue());
        }
        Integer num = this.f22920j;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.f22921k;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        Integer num3 = this.f22922l;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        Integer num4 = this.f22923m;
        if (num4 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num4.intValue());
        }
        out.writeString(this.f22924n);
    }
}
