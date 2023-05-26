package ee.mtakso.driver.network.client.geo;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleDirections.kt */
/* loaded from: classes3.dex */
public final class PolyLine {
    @SerializedName("points")

    /* renamed from: a  reason: collision with root package name */
    private final String f22261a;

    public final String a() {
        return this.f22261a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PolyLine) && Intrinsics.a(this.f22261a, ((PolyLine) obj).f22261a);
    }

    public int hashCode() {
        return this.f22261a.hashCode();
    }

    public String toString() {
        String str = this.f22261a;
        return "PolyLine(points=" + str + ")";
    }
}
