package ee.mtakso.driver.network.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InaccurateCoordinates.kt */
/* loaded from: classes3.dex */
public final class InaccurateCoordinates implements Parcelable, Locatable {
    public static final Parcelable.Creator<InaccurateCoordinates> CREATOR = new Creator();
    @SerializedName("lat")

    /* renamed from: f  reason: collision with root package name */
    private final double f21317f;
    @SerializedName("lng")

    /* renamed from: g  reason: collision with root package name */
    private final double f21318g;
    @SerializedName("accuracy_m")

    /* renamed from: h  reason: collision with root package name */
    private final Double f21319h;

    /* compiled from: InaccurateCoordinates.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<InaccurateCoordinates> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final InaccurateCoordinates createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new InaccurateCoordinates(parcel.readDouble(), parcel.readDouble(), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final InaccurateCoordinates[] newArray(int i8) {
            return new InaccurateCoordinates[i8];
        }
    }

    public InaccurateCoordinates(double d8, double d9, Double d10) {
        this.f21317f = d8;
        this.f21318g = d9;
        this.f21319h = d10;
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double a() {
        return this.f21317f;
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double b() {
        return this.f21318g;
    }

    public final Double c() {
        return this.f21319h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InaccurateCoordinates) {
            InaccurateCoordinates inaccurateCoordinates = (InaccurateCoordinates) obj;
            return Double.compare(a(), inaccurateCoordinates.a()) == 0 && Double.compare(b(), inaccurateCoordinates.b()) == 0 && Intrinsics.a(this.f21319h, inaccurateCoordinates.f21319h);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((q1.a.a(a()) * 31) + q1.a.a(b())) * 31;
        Double d8 = this.f21319h;
        return a8 + (d8 == null ? 0 : d8.hashCode());
    }

    public String toString() {
        double a8 = a();
        double b8 = b();
        Double d8 = this.f21319h;
        return "InaccurateCoordinates(latitude=" + a8 + ", longitude=" + b8 + ", accuracyInMeters=" + d8 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeDouble(this.f21317f);
        out.writeDouble(this.f21318g);
        Double d8 = this.f21319h;
        if (d8 == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeDouble(d8.doubleValue());
    }
}
