package eu.bolt.driver.earnings.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningBreakdownBottomSection.kt */
/* loaded from: classes5.dex */
public final class EarningBreakdownBottomSection {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f41411a;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: b  reason: collision with root package name */
    private final String f41412b;
    @SerializedName("chip")

    /* renamed from: c  reason: collision with root package name */
    private final DriverChip f41413c;

    public final DriverChip a() {
        return this.f41413c;
    }

    public final String b() {
        return this.f41411a;
    }

    public final String c() {
        return this.f41412b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningBreakdownBottomSection) {
            EarningBreakdownBottomSection earningBreakdownBottomSection = (EarningBreakdownBottomSection) obj;
            return Intrinsics.a(this.f41411a, earningBreakdownBottomSection.f41411a) && Intrinsics.a(this.f41412b, earningBreakdownBottomSection.f41412b) && Intrinsics.a(this.f41413c, earningBreakdownBottomSection.f41413c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f41411a.hashCode() * 31) + this.f41412b.hashCode()) * 31) + this.f41413c.hashCode();
    }

    public String toString() {
        String str = this.f41411a;
        String str2 = this.f41412b;
        DriverChip driverChip = this.f41413c;
        return "EarningBreakdownBottomSection(title=" + str + ", value=" + str2 + ", chip=" + driverChip + ")";
    }
}
