package ee.mtakso.driver.network.client.driver;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Statistics.kt */
/* loaded from: classes3.dex */
public final class HoursPeriodData implements Parcelable {
    public static final Parcelable.Creator<HoursPeriodData> CREATOR = new Creator();
    @SerializedName("key")

    /* renamed from: f  reason: collision with root package name */
    private final String f21959f;
    @SerializedName("start_date")

    /* renamed from: g  reason: collision with root package name */
    private final String f21960g;
    @SerializedName("end_date")

    /* renamed from: h  reason: collision with root package name */
    private final String f21961h;
    @SerializedName("active_seconds")

    /* renamed from: i  reason: collision with root package name */
    private final int f21962i;
    @SerializedName("items")

    /* renamed from: j  reason: collision with root package name */
    private final List<HoursSubPeriodData> f21963j;

    /* compiled from: Statistics.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<HoursPeriodData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final HoursPeriodData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.f(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i8 = 0; i8 != readInt2; i8++) {
                    arrayList2.add(HoursSubPeriodData.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new HoursPeriodData(readString, readString2, readString3, readInt, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final HoursPeriodData[] newArray(int i8) {
            return new HoursPeriodData[i8];
        }
    }

    public HoursPeriodData(String key, String startDate, String endDate, int i8, List<HoursSubPeriodData> list) {
        Intrinsics.f(key, "key");
        Intrinsics.f(startDate, "startDate");
        Intrinsics.f(endDate, "endDate");
        this.f21959f = key;
        this.f21960g = startDate;
        this.f21961h = endDate;
        this.f21962i = i8;
        this.f21963j = list;
    }

    public final List<HoursSubPeriodData> a() {
        return this.f21963j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HoursPeriodData) {
            HoursPeriodData hoursPeriodData = (HoursPeriodData) obj;
            return Intrinsics.a(this.f21959f, hoursPeriodData.f21959f) && Intrinsics.a(this.f21960g, hoursPeriodData.f21960g) && Intrinsics.a(this.f21961h, hoursPeriodData.f21961h) && this.f21962i == hoursPeriodData.f21962i && Intrinsics.a(this.f21963j, hoursPeriodData.f21963j);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.f21959f.hashCode() * 31) + this.f21960g.hashCode()) * 31) + this.f21961h.hashCode()) * 31) + this.f21962i) * 31;
        List<HoursSubPeriodData> list = this.f21963j;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        String str = this.f21959f;
        String str2 = this.f21960g;
        String str3 = this.f21961h;
        int i8 = this.f21962i;
        List<HoursSubPeriodData> list = this.f21963j;
        return "HoursPeriodData(key=" + str + ", startDate=" + str2 + ", endDate=" + str3 + ", activeSeconds=" + i8 + ", dailyDataList=" + list + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f21959f);
        out.writeString(this.f21960g);
        out.writeString(this.f21961h);
        out.writeInt(this.f21962i);
        List<HoursSubPeriodData> list = this.f21963j;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        for (HoursSubPeriodData hoursSubPeriodData : list) {
            hoursSubPeriodData.writeToParcel(out, i8);
        }
    }
}
