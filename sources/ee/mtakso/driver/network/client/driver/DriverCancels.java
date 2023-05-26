package ee.mtakso.driver.network.client.driver;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Statistics.kt */
/* loaded from: classes3.dex */
public final class DriverCancels implements Parcelable {
    public static final Parcelable.Creator<DriverCancels> CREATOR = new Creator();
    @SerializedName("total_cancelled")

    /* renamed from: f  reason: collision with root package name */
    private final int f21893f;
    @SerializedName("driver_rejected")

    /* renamed from: g  reason: collision with root package name */
    private final int f21894g;
    @SerializedName("client_cancelled")

    /* renamed from: h  reason: collision with root package name */
    private final int f21895h;
    @SerializedName("client_did_not_show")

    /* renamed from: i  reason: collision with root package name */
    private final int f21896i;
    @SerializedName("driver_did_not_respond")

    /* renamed from: j  reason: collision with root package name */
    private final int f21897j;

    /* compiled from: Statistics.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<DriverCancels> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DriverCancels createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new DriverCancels(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final DriverCancels[] newArray(int i8) {
            return new DriverCancels[i8];
        }
    }

    public DriverCancels(int i8, int i9, int i10, int i11, int i12) {
        this.f21893f = i8;
        this.f21894g = i9;
        this.f21895h = i10;
        this.f21896i = i11;
        this.f21897j = i12;
    }

    public final int a() {
        return this.f21895h;
    }

    public final int b() {
        return this.f21896i;
    }

    public final int c() {
        return this.f21897j;
    }

    public final int d() {
        return this.f21894g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f21893f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverCancels) {
            DriverCancels driverCancels = (DriverCancels) obj;
            return this.f21893f == driverCancels.f21893f && this.f21894g == driverCancels.f21894g && this.f21895h == driverCancels.f21895h && this.f21896i == driverCancels.f21896i && this.f21897j == driverCancels.f21897j;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f21893f * 31) + this.f21894g) * 31) + this.f21895h) * 31) + this.f21896i) * 31) + this.f21897j;
    }

    public String toString() {
        int i8 = this.f21893f;
        int i9 = this.f21894g;
        int i10 = this.f21895h;
        int i11 = this.f21896i;
        int i12 = this.f21897j;
        return "DriverCancels(totalCancelled=" + i8 + ", driverRejected=" + i9 + ", clientCancelled=" + i10 + ", clientDidNotShow=" + i11 + ", driverDidNotRespond=" + i12 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeInt(this.f21893f);
        out.writeInt(this.f21894g);
        out.writeInt(this.f21895h);
        out.writeInt(this.f21896i);
        out.writeInt(this.f21897j);
    }
}
