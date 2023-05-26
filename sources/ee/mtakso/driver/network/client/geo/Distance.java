package ee.mtakso.driver.network.client.geo;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleDirections.kt */
/* loaded from: classes3.dex */
public final class Distance {
    @SerializedName("text")

    /* renamed from: a  reason: collision with root package name */
    private final String f22233a;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: b  reason: collision with root package name */
    private final String f22234b;

    public final String a() {
        return this.f22233a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Distance) {
            Distance distance = (Distance) obj;
            return Intrinsics.a(this.f22233a, distance.f22233a) && Intrinsics.a(this.f22234b, distance.f22234b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22233a.hashCode() * 31) + this.f22234b.hashCode();
    }

    public String toString() {
        String str = this.f22233a;
        String str2 = this.f22234b;
        return "Distance(text=" + str + ", value=" + str2 + ")";
    }
}
