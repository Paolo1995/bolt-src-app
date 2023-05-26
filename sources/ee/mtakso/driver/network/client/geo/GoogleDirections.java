package ee.mtakso.driver.network.client.geo;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleDirections.kt */
/* loaded from: classes3.dex */
public final class GoogleDirections {
    @SerializedName("routes")

    /* renamed from: a  reason: collision with root package name */
    private final List<Route> f22259a;

    public final List<Route> a() {
        return this.f22259a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GoogleDirections) && Intrinsics.a(this.f22259a, ((GoogleDirections) obj).f22259a);
    }

    public int hashCode() {
        List<Route> list = this.f22259a;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        List<Route> list = this.f22259a;
        return "GoogleDirections(routes=" + list + ")";
    }
}
