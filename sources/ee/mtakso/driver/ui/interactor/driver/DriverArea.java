package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.service.geo.GeoCoordinate;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverAreaInteractor.kt */
/* loaded from: classes3.dex */
public final class DriverArea {

    /* renamed from: a  reason: collision with root package name */
    private final GeoCoordinate f26447a;

    /* renamed from: b  reason: collision with root package name */
    private final double f26448b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f26449c;

    /* renamed from: d  reason: collision with root package name */
    private final GeoCoordinate f26450d;

    public DriverArea(GeoCoordinate position, double d8, Integer num, GeoCoordinate geoCoordinate) {
        Intrinsics.f(position, "position");
        this.f26447a = position;
        this.f26448b = d8;
        this.f26449c = num;
        this.f26450d = geoCoordinate;
    }

    public final double a() {
        return this.f26448b;
    }

    public final GeoCoordinate b() {
        return this.f26450d;
    }

    public final GeoCoordinate c() {
        return this.f26447a;
    }

    public final Integer d() {
        return this.f26449c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverArea) {
            DriverArea driverArea = (DriverArea) obj;
            return Intrinsics.a(this.f26447a, driverArea.f26447a) && Double.compare(this.f26448b, driverArea.f26448b) == 0 && Intrinsics.a(this.f26449c, driverArea.f26449c) && Intrinsics.a(this.f26450d, driverArea.f26450d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f26447a.hashCode() * 31) + q1.a.a(this.f26448b)) * 31;
        Integer num = this.f26449c;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        GeoCoordinate geoCoordinate = this.f26450d;
        return hashCode2 + (geoCoordinate != null ? geoCoordinate.hashCode() : 0);
    }

    public String toString() {
        GeoCoordinate geoCoordinate = this.f26447a;
        double d8 = this.f26448b;
        Integer num = this.f26449c;
        GeoCoordinate geoCoordinate2 = this.f26450d;
        return "DriverArea(position=" + geoCoordinate + ", bearing=" + d8 + ", radiusMeters=" + num + ", destination=" + geoCoordinate2 + ")";
    }
}
