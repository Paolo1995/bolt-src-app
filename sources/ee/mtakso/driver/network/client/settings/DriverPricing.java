package ee.mtakso.driver.network.client.settings;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Settings.kt */
/* loaded from: classes3.dex */
public final class DriverPricing implements Parcelable {
    public static final Parcelable.Creator<DriverPricing> CREATOR = new Creator();
    @SerializedName("driver_state")

    /* renamed from: f  reason: collision with root package name */
    private final DriverPricingState f22793f;
    @SerializedName("text")

    /* renamed from: g  reason: collision with root package name */
    private final String f22794g;

    /* compiled from: Settings.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<DriverPricing> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DriverPricing createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new DriverPricing(DriverPricingState.valueOf(parcel.readString()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final DriverPricing[] newArray(int i8) {
            return new DriverPricing[i8];
        }
    }

    public DriverPricing(DriverPricingState state, String text) {
        Intrinsics.f(state, "state");
        Intrinsics.f(text, "text");
        this.f22793f = state;
        this.f22794g = text;
    }

    public final DriverPricingState a() {
        return this.f22793f;
    }

    public final String b() {
        return this.f22794g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverPricing) {
            DriverPricing driverPricing = (DriverPricing) obj;
            return this.f22793f == driverPricing.f22793f && Intrinsics.a(this.f22794g, driverPricing.f22794g);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22793f.hashCode() * 31) + this.f22794g.hashCode();
    }

    public String toString() {
        DriverPricingState driverPricingState = this.f22793f;
        String str = this.f22794g;
        return "DriverPricing(state=" + driverPricingState + ", text=" + str + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22793f.name());
        out.writeString(this.f22794g);
    }
}
