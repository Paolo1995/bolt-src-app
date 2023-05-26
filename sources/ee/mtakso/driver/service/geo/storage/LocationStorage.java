package ee.mtakso.driver.service.geo.storage;

import ee.mtakso.driver.network.client.OrderHandle;

/* compiled from: LocationStorage.kt */
/* loaded from: classes3.dex */
public interface LocationStorage extends LocationStorageCleaner {
    void b(RoutePoint routePoint);

    RoutePointList c(OrderHandle orderHandle);

    RoutePointList d(OrderHandle orderHandle, int i8);

    void e(RoutePointList routePointList);
}
