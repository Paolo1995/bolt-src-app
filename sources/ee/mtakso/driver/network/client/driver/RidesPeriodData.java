package ee.mtakso.driver.network.client.driver;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Statistics.kt */
/* loaded from: classes3.dex */
public final class RidesPeriodData implements Parcelable {
    public static final Parcelable.Creator<RidesPeriodData> CREATOR = new Creator();
    @SerializedName("key")

    /* renamed from: f  reason: collision with root package name */
    private final String f21998f;
    @SerializedName("start_date")

    /* renamed from: g  reason: collision with root package name */
    private final String f21999g;
    @SerializedName("end_date")

    /* renamed from: h  reason: collision with root package name */
    private final String f22000h;
    @SerializedName("total")

    /* renamed from: i  reason: collision with root package name */
    private final int f22001i;
    @SerializedName("finished")

    /* renamed from: j  reason: collision with root package name */
    private final String f22002j;
    @SerializedName("activity_score")

    /* renamed from: k  reason: collision with root package name */
    private final int f22003k;
    @SerializedName("items")

    /* renamed from: l  reason: collision with root package name */
    private final List<RidesSubPeriodData> f22004l;

    /* compiled from: Statistics.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<RidesPeriodData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RidesPeriodData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.f(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            String readString4 = parcel.readString();
            int readInt2 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt3 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt3);
                for (int i8 = 0; i8 != readInt3; i8++) {
                    arrayList2.add(RidesSubPeriodData.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new RidesPeriodData(readString, readString2, readString3, readInt, readString4, readInt2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final RidesPeriodData[] newArray(int i8) {
            return new RidesPeriodData[i8];
        }
    }

    public RidesPeriodData(String key, String startDate, String endDate, int i8, String finishedRides, int i9, List<RidesSubPeriodData> list) {
        Intrinsics.f(key, "key");
        Intrinsics.f(startDate, "startDate");
        Intrinsics.f(endDate, "endDate");
        Intrinsics.f(finishedRides, "finishedRides");
        this.f21998f = key;
        this.f21999g = startDate;
        this.f22000h = endDate;
        this.f22001i = i8;
        this.f22002j = finishedRides;
        this.f22003k = i9;
        this.f22004l = list;
    }

    public final int a() {
        return this.f22003k;
    }

    public final List<RidesSubPeriodData> b() {
        return this.f22004l;
    }

    public final String c() {
        return this.f22002j;
    }

    public final int d() {
        return this.f22001i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RidesPeriodData) {
            RidesPeriodData ridesPeriodData = (RidesPeriodData) obj;
            return Intrinsics.a(this.f21998f, ridesPeriodData.f21998f) && Intrinsics.a(this.f21999g, ridesPeriodData.f21999g) && Intrinsics.a(this.f22000h, ridesPeriodData.f22000h) && this.f22001i == ridesPeriodData.f22001i && Intrinsics.a(this.f22002j, ridesPeriodData.f22002j) && this.f22003k == ridesPeriodData.f22003k && Intrinsics.a(this.f22004l, ridesPeriodData.f22004l);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.f21998f.hashCode() * 31) + this.f21999g.hashCode()) * 31) + this.f22000h.hashCode()) * 31) + this.f22001i) * 31) + this.f22002j.hashCode()) * 31) + this.f22003k) * 31;
        List<RidesSubPeriodData> list = this.f22004l;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        String str = this.f21998f;
        String str2 = this.f21999g;
        String str3 = this.f22000h;
        int i8 = this.f22001i;
        String str4 = this.f22002j;
        int i9 = this.f22003k;
        List<RidesSubPeriodData> list = this.f22004l;
        return "RidesPeriodData(key=" + str + ", startDate=" + str2 + ", endDate=" + str3 + ", totalRides=" + i8 + ", finishedRides=" + str4 + ", activityScore=" + i9 + ", dailyDataList=" + list + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f21998f);
        out.writeString(this.f21999g);
        out.writeString(this.f22000h);
        out.writeInt(this.f22001i);
        out.writeString(this.f22002j);
        out.writeInt(this.f22003k);
        List<RidesSubPeriodData> list = this.f22004l;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        for (RidesSubPeriodData ridesSubPeriodData : list) {
            ridesSubPeriodData.writeToParcel(out, i8);
        }
    }
}
