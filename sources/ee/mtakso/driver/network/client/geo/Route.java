package ee.mtakso.driver.network.client.geo;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Route.kt */
/* loaded from: classes3.dex */
public final class Route {
    @SerializedName("legs")

    /* renamed from: a  reason: collision with root package name */
    private final List<Leg> f22262a;
    @SerializedName("overview_polyline")

    /* renamed from: b  reason: collision with root package name */
    private final PolyLine f22263b;

    public final List<Leg> a() {
        return this.f22262a;
    }

    public final PolyLine b() {
        return this.f22263b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Route) {
            Route route = (Route) obj;
            return Intrinsics.a(this.f22262a, route.f22262a) && Intrinsics.a(this.f22263b, route.f22263b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22262a.hashCode() * 31) + this.f22263b.hashCode();
    }

    public String toString() {
        List<Leg> list = this.f22262a;
        PolyLine polyLine = this.f22263b;
        return "Route(legs=" + list + ", polyline=" + polyLine + ")";
    }
}
