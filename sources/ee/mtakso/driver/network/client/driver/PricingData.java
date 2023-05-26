package ee.mtakso.driver.network.client.driver;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.settings.DriverPricingState;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Block.kt */
/* loaded from: classes3.dex */
public final class PricingData implements Parcelable {
    public static final Parcelable.Creator<PricingData> CREATOR = new Creator();
    @SerializedName("driver_state")

    /* renamed from: f  reason: collision with root package name */
    private final DriverPricingState f21990f;
    @SerializedName("distance_rate")

    /* renamed from: g  reason: collision with root package name */
    private final BigDecimal f21991g;

    /* compiled from: Block.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PricingData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PricingData createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new PricingData(DriverPricingState.valueOf(parcel.readString()), (BigDecimal) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final PricingData[] newArray(int i8) {
            return new PricingData[i8];
        }
    }

    public PricingData(DriverPricingState driverState, BigDecimal bigDecimal) {
        Intrinsics.f(driverState, "driverState");
        this.f21990f = driverState;
        this.f21991g = bigDecimal;
    }

    public final BigDecimal a() {
        return this.f21991g;
    }

    public final DriverPricingState b() {
        return this.f21990f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PricingData) {
            PricingData pricingData = (PricingData) obj;
            return this.f21990f == pricingData.f21990f && Intrinsics.a(this.f21991g, pricingData.f21991g);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f21990f.hashCode() * 31;
        BigDecimal bigDecimal = this.f21991g;
        return hashCode + (bigDecimal == null ? 0 : bigDecimal.hashCode());
    }

    public String toString() {
        DriverPricingState driverPricingState = this.f21990f;
        BigDecimal bigDecimal = this.f21991g;
        return "PricingData(driverState=" + driverPricingState + ", distanceRate=" + bigDecimal + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f21990f.name());
        out.writeSerializable(this.f21991g);
    }
}
