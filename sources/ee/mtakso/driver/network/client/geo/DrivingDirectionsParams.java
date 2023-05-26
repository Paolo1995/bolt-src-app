package ee.mtakso.driver.network.client.geo;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.Coordinates;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleDirections.kt */
/* loaded from: classes3.dex */
public final class DrivingDirectionsParams {
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.ORIGIN)

    /* renamed from: a  reason: collision with root package name */
    private final Coordinates f22235a;
    @SerializedName("destination")

    /* renamed from: b  reason: collision with root package name */
    private final Coordinates f22236b;
    @SerializedName("units")

    /* renamed from: c  reason: collision with root package name */
    private final String f22237c;
    @SerializedName("route_meta")

    /* renamed from: d  reason: collision with root package name */
    private final String f22238d;
    @SerializedName("waypoints")

    /* renamed from: e  reason: collision with root package name */
    private final List<Coordinates> f22239e;

    public DrivingDirectionsParams(Coordinates from, Coordinates to, String measurementSystem, String str, List<Coordinates> waypoints) {
        Intrinsics.f(from, "from");
        Intrinsics.f(to, "to");
        Intrinsics.f(measurementSystem, "measurementSystem");
        Intrinsics.f(waypoints, "waypoints");
        this.f22235a = from;
        this.f22236b = to;
        this.f22237c = measurementSystem;
        this.f22238d = str;
        this.f22239e = waypoints;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrivingDirectionsParams) {
            DrivingDirectionsParams drivingDirectionsParams = (DrivingDirectionsParams) obj;
            return Intrinsics.a(this.f22235a, drivingDirectionsParams.f22235a) && Intrinsics.a(this.f22236b, drivingDirectionsParams.f22236b) && Intrinsics.a(this.f22237c, drivingDirectionsParams.f22237c) && Intrinsics.a(this.f22238d, drivingDirectionsParams.f22238d) && Intrinsics.a(this.f22239e, drivingDirectionsParams.f22239e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f22235a.hashCode() * 31) + this.f22236b.hashCode()) * 31) + this.f22237c.hashCode()) * 31;
        String str = this.f22238d;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f22239e.hashCode();
    }

    public String toString() {
        Coordinates coordinates = this.f22235a;
        Coordinates coordinates2 = this.f22236b;
        String str = this.f22237c;
        String str2 = this.f22238d;
        List<Coordinates> list = this.f22239e;
        return "DrivingDirectionsParams(from=" + coordinates + ", to=" + coordinates2 + ", measurementSystem=" + str + ", routeMeta=" + str2 + ", waypoints=" + list + ")";
    }
}
