package ee.mtakso.driver.network.client.geo;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleDirections.kt */
/* loaded from: classes3.dex */
public final class Leg {
    @SerializedName("distance")

    /* renamed from: a  reason: collision with root package name */
    private final Distance f22260a;

    public final Distance a() {
        return this.f22260a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Leg) && Intrinsics.a(this.f22260a, ((Leg) obj).f22260a);
    }

    public int hashCode() {
        return this.f22260a.hashCode();
    }

    public String toString() {
        Distance distance = this.f22260a;
        return "Leg(distance=" + distance + ")";
    }
}
