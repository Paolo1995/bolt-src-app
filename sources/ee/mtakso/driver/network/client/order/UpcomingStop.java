package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: UpcomingStop.kt */
/* loaded from: classes3.dex */
public final class UpcomingStop implements Parcelable {
    public static final Parcelable.Creator<UpcomingStop> CREATOR = new Creator();
    @SerializedName(Name.MARK)

    /* renamed from: f  reason: collision with root package name */
    private final long f22606f;
    @SerializedName("address")

    /* renamed from: g  reason: collision with root package name */
    private final String f22607g;
    @SerializedName("lat")

    /* renamed from: h  reason: collision with root package name */
    private final Double f22608h;
    @SerializedName("lng")

    /* renamed from: i  reason: collision with root package name */
    private final Double f22609i;
    @SerializedName("type")

    /* renamed from: j  reason: collision with root package name */
    private final StopType f22610j;
    @SerializedName("map_matched_lat_lng")

    /* renamed from: k  reason: collision with root package name */
    private final MapMatchedLocation f22611k;

    /* compiled from: UpcomingStop.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<UpcomingStop> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final UpcomingStop createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new UpcomingStop(parcel.readLong(), parcel.readString(), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), StopType.valueOf(parcel.readString()), parcel.readInt() != 0 ? MapMatchedLocation.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final UpcomingStop[] newArray(int i8) {
            return new UpcomingStop[i8];
        }
    }

    /* compiled from: UpcomingStop.kt */
    /* loaded from: classes3.dex */
    public static final class MapMatchedLocation implements Parcelable {
        public static final Parcelable.Creator<MapMatchedLocation> CREATOR = new Creator();
        @SerializedName("lat")

        /* renamed from: f  reason: collision with root package name */
        private final double f22612f;
        @SerializedName("lng")

        /* renamed from: g  reason: collision with root package name */
        private final double f22613g;
        @SerializedName("bearing")

        /* renamed from: h  reason: collision with root package name */
        private final Double f22614h;

        /* compiled from: UpcomingStop.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<MapMatchedLocation> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final MapMatchedLocation createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new MapMatchedLocation(parcel.readDouble(), parcel.readDouble(), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final MapMatchedLocation[] newArray(int i8) {
                return new MapMatchedLocation[i8];
            }
        }

        public MapMatchedLocation(double d8, double d9, Double d10) {
            this.f22612f = d8;
            this.f22613g = d9;
            this.f22614h = d10;
        }

        public final double a() {
            return this.f22612f;
        }

        public final double b() {
            return this.f22613g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MapMatchedLocation) {
                MapMatchedLocation mapMatchedLocation = (MapMatchedLocation) obj;
                return Double.compare(this.f22612f, mapMatchedLocation.f22612f) == 0 && Double.compare(this.f22613g, mapMatchedLocation.f22613g) == 0 && Intrinsics.a(this.f22614h, mapMatchedLocation.f22614h);
            }
            return false;
        }

        public int hashCode() {
            int a8 = ((q1.a.a(this.f22612f) * 31) + q1.a.a(this.f22613g)) * 31;
            Double d8 = this.f22614h;
            return a8 + (d8 == null ? 0 : d8.hashCode());
        }

        public String toString() {
            double d8 = this.f22612f;
            double d9 = this.f22613g;
            Double d10 = this.f22614h;
            return "MapMatchedLocation(lat=" + d8 + ", lng=" + d9 + ", bearing=" + d10 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeDouble(this.f22612f);
            out.writeDouble(this.f22613g);
            Double d8 = this.f22614h;
            if (d8 == null) {
                out.writeInt(0);
                return;
            }
            out.writeInt(1);
            out.writeDouble(d8.doubleValue());
        }
    }

    public UpcomingStop(long j8, String str, Double d8, Double d9, StopType type, MapMatchedLocation mapMatchedLocation) {
        Intrinsics.f(type, "type");
        this.f22606f = j8;
        this.f22607g = str;
        this.f22608h = d8;
        this.f22609i = d9;
        this.f22610j = type;
        this.f22611k = mapMatchedLocation;
    }

    public final String a() {
        return this.f22607g;
    }

    public final long b() {
        return this.f22606f;
    }

    public final Double c() {
        return this.f22608h;
    }

    public final Double d() {
        return this.f22609i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final MapMatchedLocation e() {
        return this.f22611k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpcomingStop) {
            UpcomingStop upcomingStop = (UpcomingStop) obj;
            return this.f22606f == upcomingStop.f22606f && Intrinsics.a(this.f22607g, upcomingStop.f22607g) && Intrinsics.a(this.f22608h, upcomingStop.f22608h) && Intrinsics.a(this.f22609i, upcomingStop.f22609i) && this.f22610j == upcomingStop.f22610j && Intrinsics.a(this.f22611k, upcomingStop.f22611k);
        }
        return false;
    }

    public final StopType f() {
        return this.f22610j;
    }

    public int hashCode() {
        int a8 = i0.a.a(this.f22606f) * 31;
        String str = this.f22607g;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        Double d8 = this.f22608h;
        int hashCode2 = (hashCode + (d8 == null ? 0 : d8.hashCode())) * 31;
        Double d9 = this.f22609i;
        int hashCode3 = (((hashCode2 + (d9 == null ? 0 : d9.hashCode())) * 31) + this.f22610j.hashCode()) * 31;
        MapMatchedLocation mapMatchedLocation = this.f22611k;
        return hashCode3 + (mapMatchedLocation != null ? mapMatchedLocation.hashCode() : 0);
    }

    public String toString() {
        long j8 = this.f22606f;
        String str = this.f22607g;
        Double d8 = this.f22608h;
        Double d9 = this.f22609i;
        StopType stopType = this.f22610j;
        MapMatchedLocation mapMatchedLocation = this.f22611k;
        return "UpcomingStop(id=" + j8 + ", address=" + str + ", lat=" + d8 + ", lng=" + d9 + ", type=" + stopType + ", mapMatchedLocation=" + mapMatchedLocation + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeLong(this.f22606f);
        out.writeString(this.f22607g);
        Double d8 = this.f22608h;
        if (d8 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeDouble(d8.doubleValue());
        }
        Double d9 = this.f22609i;
        if (d9 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeDouble(d9.doubleValue());
        }
        out.writeString(this.f22610j.name());
        MapMatchedLocation mapMatchedLocation = this.f22611k;
        if (mapMatchedLocation == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        mapMatchedLocation.writeToParcel(out, i8);
    }
}
