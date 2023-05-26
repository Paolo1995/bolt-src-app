package ee.mtakso.driver.service.geo.state;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeoLocationState.kt */
/* loaded from: classes3.dex */
public final class GeoLocationState {

    /* renamed from: a  reason: collision with root package name */
    private final GeoLocationIssue f24430a;

    public GeoLocationState(GeoLocationIssue geoLocationIssue) {
        this.f24430a = geoLocationIssue;
    }

    public final GeoLocationIssue a() {
        return this.f24430a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GeoLocationState) && Intrinsics.a(this.f24430a, ((GeoLocationState) obj).f24430a);
    }

    public int hashCode() {
        GeoLocationIssue geoLocationIssue = this.f24430a;
        if (geoLocationIssue == null) {
            return 0;
        }
        return geoLocationIssue.hashCode();
    }

    public String toString() {
        GeoLocationIssue geoLocationIssue = this.f24430a;
        return "GeoLocationState(issue=" + geoLocationIssue + ")";
    }
}
