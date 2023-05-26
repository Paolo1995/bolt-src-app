package ee.mtakso.driver.network.client.settings;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: DriverDestination.kt */
/* loaded from: classes3.dex */
public final class DriverDestination implements Parcelable {
    public static final Parcelable.Creator<DriverDestination> CREATOR = new Creator();
    @SerializedName(alternate = {Name.MARK}, value = "driver_destination_id")

    /* renamed from: f  reason: collision with root package name */
    private final long f22782f;
    @SerializedName("type")

    /* renamed from: g  reason: collision with root package name */
    private final String f22783g;
    @SerializedName("name")

    /* renamed from: h  reason: collision with root package name */
    private String f22784h;
    @SerializedName("address")

    /* renamed from: i  reason: collision with root package name */
    private final String f22785i;
    @SerializedName("lat")

    /* renamed from: j  reason: collision with root package name */
    private final Double f22786j;
    @SerializedName("lng")

    /* renamed from: k  reason: collision with root package name */
    private final Double f22787k;
    @SerializedName("state")

    /* renamed from: l  reason: collision with root package name */
    private final String f22788l;

    /* compiled from: DriverDestination.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<DriverDestination> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DriverDestination createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new DriverDestination(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final DriverDestination[] newArray(int i8) {
            return new DriverDestination[i8];
        }
    }

    public DriverDestination(long j8, String type, String str, String address, Double d8, Double d9, String str2) {
        Intrinsics.f(type, "type");
        Intrinsics.f(address, "address");
        this.f22782f = j8;
        this.f22783g = type;
        this.f22784h = str;
        this.f22785i = address;
        this.f22786j = d8;
        this.f22787k = d9;
        this.f22788l = str2;
    }

    public final String a() {
        return this.f22785i;
    }

    public final long b() {
        return this.f22782f;
    }

    public final Double c() {
        return this.f22786j;
    }

    public final Double d() {
        return this.f22787k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f22784h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverDestination) {
            DriverDestination driverDestination = (DriverDestination) obj;
            return this.f22782f == driverDestination.f22782f && Intrinsics.a(this.f22783g, driverDestination.f22783g) && Intrinsics.a(this.f22784h, driverDestination.f22784h) && Intrinsics.a(this.f22785i, driverDestination.f22785i) && Intrinsics.a(this.f22786j, driverDestination.f22786j) && Intrinsics.a(this.f22787k, driverDestination.f22787k) && Intrinsics.a(this.f22788l, driverDestination.f22788l);
        }
        return false;
    }

    public final String f() {
        return this.f22783g;
    }

    public int hashCode() {
        int a8 = ((i0.a.a(this.f22782f) * 31) + this.f22783g.hashCode()) * 31;
        String str = this.f22784h;
        int hashCode = (((a8 + (str == null ? 0 : str.hashCode())) * 31) + this.f22785i.hashCode()) * 31;
        Double d8 = this.f22786j;
        int hashCode2 = (hashCode + (d8 == null ? 0 : d8.hashCode())) * 31;
        Double d9 = this.f22787k;
        int hashCode3 = (hashCode2 + (d9 == null ? 0 : d9.hashCode())) * 31;
        String str2 = this.f22788l;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        long j8 = this.f22782f;
        String str = this.f22783g;
        String str2 = this.f22784h;
        String str3 = this.f22785i;
        Double d8 = this.f22786j;
        Double d9 = this.f22787k;
        String str4 = this.f22788l;
        return "DriverDestination(id=" + j8 + ", type=" + str + ", name=" + str2 + ", address=" + str3 + ", lat=" + d8 + ", lng=" + d9 + ", state=" + str4 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeLong(this.f22782f);
        out.writeString(this.f22783g);
        out.writeString(this.f22784h);
        out.writeString(this.f22785i);
        Double d8 = this.f22786j;
        if (d8 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeDouble(d8.doubleValue());
        }
        Double d9 = this.f22787k;
        if (d9 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeDouble(d9.doubleValue());
        }
        out.writeString(this.f22788l);
    }

    public /* synthetic */ DriverDestination(long j8, String str, String str2, String str3, Double d8, Double d9, String str4, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0L : j8, str, str2, (i8 & 8) != 0 ? "" : str3, (i8 & 16) != 0 ? Double.valueOf(0.0d) : d8, (i8 & 32) != 0 ? Double.valueOf(0.0d) : d9, str4);
    }
}
