package ee.mtakso.driver.service.geo;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeoLocation.kt */
/* loaded from: classes3.dex */
public final class GeoLocation {

    /* renamed from: a  reason: collision with root package name */
    private final GeoCoordinate f24370a;

    /* renamed from: b  reason: collision with root package name */
    private final float f24371b;

    /* renamed from: c  reason: collision with root package name */
    private final double f24372c;

    /* renamed from: d  reason: collision with root package name */
    private final Double f24373d;

    /* renamed from: e  reason: collision with root package name */
    private final double f24374e;

    /* renamed from: f  reason: collision with root package name */
    private final Float f24375f;

    /* renamed from: g  reason: collision with root package name */
    private final Float f24376g;

    /* renamed from: h  reason: collision with root package name */
    private final Float f24377h;

    /* renamed from: i  reason: collision with root package name */
    private final long f24378i;

    public GeoLocation(GeoCoordinate coordinates, float f8, double d8, Double d9, double d10, Float f9, Float f10, Float f11, long j8) {
        Intrinsics.f(coordinates, "coordinates");
        this.f24370a = coordinates;
        this.f24371b = f8;
        this.f24372c = d8;
        this.f24373d = d9;
        this.f24374e = d10;
        this.f24375f = f9;
        this.f24376g = f10;
        this.f24377h = f11;
        this.f24378i = j8;
    }

    public final double a() {
        return this.f24374e;
    }

    public final double b() {
        return this.f24372c;
    }

    public final Double c() {
        return this.f24373d;
    }

    public final Float d() {
        return this.f24375f;
    }

    public final GeoCoordinate e() {
        return this.f24370a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GeoLocation) {
            GeoLocation geoLocation = (GeoLocation) obj;
            return Intrinsics.a(this.f24370a, geoLocation.f24370a) && Float.compare(this.f24371b, geoLocation.f24371b) == 0 && Double.compare(this.f24372c, geoLocation.f24372c) == 0 && Intrinsics.a(this.f24373d, geoLocation.f24373d) && Double.compare(this.f24374e, geoLocation.f24374e) == 0 && Intrinsics.a(this.f24375f, geoLocation.f24375f) && Intrinsics.a(this.f24376g, geoLocation.f24376g) && Intrinsics.a(this.f24377h, geoLocation.f24377h) && this.f24378i == geoLocation.f24378i;
        }
        return false;
    }

    public final float f() {
        return this.f24371b;
    }

    public final Float g() {
        return this.f24376g;
    }

    public final Float h() {
        return this.f24377h;
    }

    public int hashCode() {
        int hashCode = ((((this.f24370a.hashCode() * 31) + Float.floatToIntBits(this.f24371b)) * 31) + q1.a.a(this.f24372c)) * 31;
        Double d8 = this.f24373d;
        int hashCode2 = (((hashCode + (d8 == null ? 0 : d8.hashCode())) * 31) + q1.a.a(this.f24374e)) * 31;
        Float f8 = this.f24375f;
        int hashCode3 = (hashCode2 + (f8 == null ? 0 : f8.hashCode())) * 31;
        Float f9 = this.f24376g;
        int hashCode4 = (hashCode3 + (f9 == null ? 0 : f9.hashCode())) * 31;
        Float f10 = this.f24377h;
        return ((hashCode4 + (f10 != null ? f10.hashCode() : 0)) * 31) + i0.a.a(this.f24378i);
    }

    public final long i() {
        return this.f24378i;
    }

    public String toString() {
        GeoCoordinate geoCoordinate = this.f24370a;
        float f8 = this.f24371b;
        double d8 = this.f24372c;
        Double d9 = this.f24373d;
        double d10 = this.f24374e;
        Float f9 = this.f24375f;
        Float f10 = this.f24376g;
        Float f11 = this.f24377h;
        long j8 = this.f24378i;
        return "GeoLocation(coordinates=" + geoCoordinate + ", locationAccuracy=" + f8 + ", altitude=" + d8 + ", bearing=" + d9 + ", adjustedBearing=" + d10 + ", bearingAccuracy=" + f9 + ", speed=" + f10 + ", speedAccuracy=" + f11 + ", timestamp=" + j8 + ")";
    }
}
