package ee.mtakso.driver.service.geo;

import eu.bolt.android.maps.core.Locatable;

/* compiled from: GeoCoordinate.kt */
/* loaded from: classes3.dex */
public final class GeoCoordinate implements Locatable {

    /* renamed from: f  reason: collision with root package name */
    private final double f24368f;

    /* renamed from: g  reason: collision with root package name */
    private final double f24369g;

    public GeoCoordinate(double d8, double d9) {
        this.f24368f = d8;
        this.f24369g = d9;
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double a() {
        return this.f24368f;
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double b() {
        return this.f24369g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GeoCoordinate) {
            GeoCoordinate geoCoordinate = (GeoCoordinate) obj;
            return Double.compare(a(), geoCoordinate.a()) == 0 && Double.compare(b(), geoCoordinate.b()) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (q1.a.a(a()) * 31) + q1.a.a(b());
    }

    public String toString() {
        double a8 = a();
        double b8 = b();
        return "GeoCoordinate(latitude=" + a8 + ", longitude=" + b8 + ")";
    }
}
