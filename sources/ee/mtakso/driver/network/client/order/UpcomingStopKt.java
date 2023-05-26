package ee.mtakso.driver.network.client.order;

import ee.mtakso.driver.network.client.order.UpcomingStop;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcomingStop.kt */
/* loaded from: classes3.dex */
public final class UpcomingStopKt {
    public static final GeoCoordinate a(UpcomingStop upcomingStop) {
        Intrinsics.f(upcomingStop, "<this>");
        Double c8 = upcomingStop.c();
        Double d8 = upcomingStop.d();
        if (c8 != null && d8 != null) {
            return new GeoCoordinate(c8.doubleValue(), d8.doubleValue());
        }
        return null;
    }

    public static final GeoCoordinate b(UpcomingStop upcomingStop) {
        Double d8;
        Double d9;
        Intrinsics.f(upcomingStop, "<this>");
        UpcomingStop.MapMatchedLocation e8 = upcomingStop.e();
        if (e8 != null) {
            d8 = Double.valueOf(e8.a());
        } else {
            d8 = null;
        }
        UpcomingStop.MapMatchedLocation e9 = upcomingStop.e();
        if (e9 != null) {
            d9 = Double.valueOf(e9.b());
        } else {
            d9 = null;
        }
        if (d8 == null || d9 == null) {
            return null;
        }
        return new GeoCoordinate(d8.doubleValue(), d9.doubleValue());
    }
}
