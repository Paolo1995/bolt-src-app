package ee.mtakso.driver.network.client.order;

import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.modules.order.SeparatedAddress;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Order.kt */
/* loaded from: classes3.dex */
public final class OrderKt {
    public static final GeoCoordinate a(Order order) {
        Intrinsics.f(order, "<this>");
        UpcomingStop upcomingStop = (UpcomingStop) CollectionsKt___CollectionsKt.Y(order.H());
        if (upcomingStop != null) {
            return UpcomingStopKt.b(upcomingStop);
        }
        return null;
    }

    public static final GeoCoordinate b(Order order) {
        Intrinsics.f(order, "<this>");
        UpcomingStop upcomingStop = (UpcomingStop) CollectionsKt___CollectionsKt.Y(order.H());
        if (upcomingStop != null) {
            return UpcomingStopKt.a(upcomingStop);
        }
        return null;
    }

    public static final SeparatedAddress c(Order order) {
        String str;
        Intrinsics.f(order, "<this>");
        UpcomingStop upcomingStop = (UpcomingStop) CollectionsKt___CollectionsKt.Y(order.H());
        if (upcomingStop != null) {
            str = upcomingStop.a();
        } else {
            str = null;
        }
        return e(str);
    }

    public static final String d(Order order) {
        Intrinsics.f(order, "<this>");
        UpcomingStop upcomingStop = (UpcomingStop) CollectionsKt___CollectionsKt.Y(order.H());
        if (upcomingStop != null) {
            return upcomingStop.a();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final ee.mtakso.driver.service.modules.order.SeparatedAddress e(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.network.client.order.OrderKt.e(java.lang.String):ee.mtakso.driver.service.modules.order.SeparatedAddress");
    }

    public static final String f(Order order) {
        Intrinsics.f(order, "<this>");
        if (!order.D()) {
            return null;
        }
        return String.valueOf(order.f());
    }

    public static final GeoCoordinate g(Order order) {
        Object i02;
        Intrinsics.f(order, "<this>");
        i02 = CollectionsKt___CollectionsKt.i0(order.H());
        UpcomingStop upcomingStop = (UpcomingStop) i02;
        if (upcomingStop != null) {
            return UpcomingStopKt.a(upcomingStop);
        }
        return null;
    }
}
