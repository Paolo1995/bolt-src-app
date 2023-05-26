package eu.bolt.android.maps.core;

import q1.a;

/* compiled from: MapPoint.kt */
/* loaded from: classes5.dex */
public final class MapPoint implements Locatable {

    /* renamed from: f  reason: collision with root package name */
    private final double f36944f;

    /* renamed from: g  reason: collision with root package name */
    private final double f36945g;

    public MapPoint(double d8, double d9) {
        this.f36944f = d8;
        this.f36945g = d9;
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double a() {
        return this.f36944f;
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double b() {
        return this.f36945g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapPoint) {
            MapPoint mapPoint = (MapPoint) obj;
            return Double.compare(this.f36944f, mapPoint.f36944f) == 0 && Double.compare(this.f36945g, mapPoint.f36945g) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (a.a(this.f36944f) * 31) + a.a(this.f36945g);
    }

    public String toString() {
        return "MapPoint(lat=" + this.f36944f + ", lng=" + this.f36945g + ')';
    }
}
