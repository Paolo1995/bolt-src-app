package ee.mtakso.driver.network.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Coordinates.kt */
/* loaded from: classes3.dex */
public final class Coordinates implements Parcelable, Locatable {
    public static final Parcelable.Creator<Coordinates> CREATOR = new Creator();
    @SerializedName("lat")

    /* renamed from: f  reason: collision with root package name */
    private final double f21315f;
    @SerializedName("lng")

    /* renamed from: g  reason: collision with root package name */
    private final double f21316g;

    /* compiled from: Coordinates.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<Coordinates> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final Coordinates createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new Coordinates(parcel.readDouble(), parcel.readDouble());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final Coordinates[] newArray(int i8) {
            return new Coordinates[i8];
        }
    }

    public Coordinates(double d8, double d9) {
        this.f21315f = d8;
        this.f21316g = d9;
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double a() {
        return this.f21315f;
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double b() {
        return this.f21316g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Coordinates) {
            Coordinates coordinates = (Coordinates) obj;
            return Double.compare(a(), coordinates.a()) == 0 && Double.compare(b(), coordinates.b()) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (q1.a.a(a()) * 31) + q1.a.a(b());
    }

    public String toString() {
        double a8 = a();
        double b8 = b();
        return "Coordinates(latitude=" + a8 + ", longitude=" + b8 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeDouble(this.f21315f);
        out.writeDouble(this.f21316g);
    }
}
