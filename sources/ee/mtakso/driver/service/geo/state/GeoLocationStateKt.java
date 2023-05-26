package ee.mtakso.driver.service.geo.state;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeoLocationState.kt */
/* loaded from: classes3.dex */
public final class GeoLocationStateKt {
    public static final GeoLocationIssue a(GeoLocationState geoLocationState) {
        Intrinsics.f(geoLocationState, "<this>");
        GeoLocationIssue a8 = geoLocationState.a();
        if (a8 != null) {
            return a8;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final boolean b(GeoLocationState geoLocationState) {
        Intrinsics.f(geoLocationState, "<this>");
        if (geoLocationState.a() == null) {
            return true;
        }
        return false;
    }
}
