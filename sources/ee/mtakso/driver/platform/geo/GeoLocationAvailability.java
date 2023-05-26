package ee.mtakso.driver.platform.geo;

/* compiled from: GeoLocationAvailability.kt */
/* loaded from: classes3.dex */
public final class GeoLocationAvailability {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23281a;

    public GeoLocationAvailability(boolean z7) {
        this.f23281a = z7;
    }

    public final boolean a() {
        return this.f23281a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GeoLocationAvailability) && this.f23281a == ((GeoLocationAvailability) obj).f23281a;
    }

    public int hashCode() {
        boolean z7 = this.f23281a;
        if (z7) {
            return 1;
        }
        return z7 ? 1 : 0;
    }

    public String toString() {
        boolean z7 = this.f23281a;
        return "GeoLocationAvailability(isAvailable=" + z7 + ")";
    }
}
