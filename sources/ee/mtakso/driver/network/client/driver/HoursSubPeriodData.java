package ee.mtakso.driver.network.client.driver;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Statistics.kt */
/* loaded from: classes3.dex */
public final class HoursSubPeriodData implements Parcelable {
    public static final Parcelable.Creator<HoursSubPeriodData> CREATOR = new Creator();
    @SerializedName("date")

    /* renamed from: f  reason: collision with root package name */
    private final String f21964f;
    @SerializedName("active_seconds")

    /* renamed from: g  reason: collision with root package name */
    private final int f21965g;

    /* compiled from: Statistics.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<HoursSubPeriodData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final HoursSubPeriodData createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new HoursSubPeriodData(parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final HoursSubPeriodData[] newArray(int i8) {
            return new HoursSubPeriodData[i8];
        }
    }

    public HoursSubPeriodData(String date, int i8) {
        Intrinsics.f(date, "date");
        this.f21964f = date;
        this.f21965g = i8;
    }

    public final int a() {
        return this.f21965g;
    }

    public final String b() {
        return this.f21964f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HoursSubPeriodData) {
            HoursSubPeriodData hoursSubPeriodData = (HoursSubPeriodData) obj;
            return Intrinsics.a(this.f21964f, hoursSubPeriodData.f21964f) && this.f21965g == hoursSubPeriodData.f21965g;
        }
        return false;
    }

    public int hashCode() {
        return (this.f21964f.hashCode() * 31) + this.f21965g;
    }

    public String toString() {
        String str = this.f21964f;
        int i8 = this.f21965g;
        return "HoursSubPeriodData(date=" + str + ", activeSeconds=" + i8 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f21964f);
        out.writeInt(this.f21965g);
    }
}
