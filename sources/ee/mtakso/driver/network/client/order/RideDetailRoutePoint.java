package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RideDetailRoutePoint.kt */
/* loaded from: classes3.dex */
public final class RideDetailRoutePoint {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final Type f22547a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f22548b;

    /* compiled from: RideDetailRoutePoint.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        PICKUP,
        WAYPOINT,
        DESTINATION,
        UNKNOWN
    }

    public final String a() {
        return this.f22548b;
    }

    public final Type b() {
        return this.f22547a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RideDetailRoutePoint) {
            RideDetailRoutePoint rideDetailRoutePoint = (RideDetailRoutePoint) obj;
            return this.f22547a == rideDetailRoutePoint.f22547a && Intrinsics.a(this.f22548b, rideDetailRoutePoint.f22548b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22547a.hashCode() * 31) + this.f22548b.hashCode();
    }

    public String toString() {
        Type type = this.f22547a;
        String str = this.f22548b;
        return "RideDetailRoutePoint(type=" + type + ", title=" + str + ")";
    }
}
