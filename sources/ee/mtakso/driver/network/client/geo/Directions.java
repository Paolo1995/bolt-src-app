package ee.mtakso.driver.network.client.geo;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Directions.kt */
/* loaded from: classes3.dex */
public final class Directions {
    @SerializedName("google")

    /* renamed from: a  reason: collision with root package name */
    private final GoogleDirections f22232a;

    public final GoogleDirections a() {
        return this.f22232a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Directions) && Intrinsics.a(this.f22232a, ((Directions) obj).f22232a);
    }

    public int hashCode() {
        GoogleDirections googleDirections = this.f22232a;
        if (googleDirections == null) {
            return 0;
        }
        return googleDirections.hashCode();
    }

    public String toString() {
        GoogleDirections googleDirections = this.f22232a;
        return "Directions(googleDirections=" + googleDirections + ")";
    }
}
