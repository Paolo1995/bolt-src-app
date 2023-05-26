package ee.mtakso.driver.service.geo.storage.db;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.service.geo.storage.LocationStorage;
import ee.mtakso.driver.service.geo.storage.RoutePoint;
import ee.mtakso.driver.service.geo.storage.RoutePointList;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationStorageDatabase.kt */
/* loaded from: classes3.dex */
public final class LocationStorageDatabase implements LocationStorage {

    /* renamed from: a  reason: collision with root package name */
    private final LocationDao f24462a;

    @Inject
    public LocationStorageDatabase(LocationDao locationDao) {
        Intrinsics.f(locationDao, "locationDao");
        this.f24462a = locationDao;
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorageCleaner
    public void a() {
        this.f24462a.a();
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public void b(RoutePoint point) {
        Intrinsics.f(point, "point");
        this.f24462a.e(point.a());
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public RoutePointList c(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return new RoutePointList(orderHandle, this.f24462a.b(orderHandle.b(), orderHandle.a(), orderHandle.c()));
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public RoutePointList d(OrderHandle orderHandle, int i8) {
        Intrinsics.f(orderHandle, "orderHandle");
        return new RoutePointList(orderHandle, this.f24462a.d(orderHandle.b(), orderHandle.a(), orderHandle.c(), i8));
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public void e(RoutePointList routePointList) {
        Intrinsics.f(routePointList, "routePointList");
        this.f24462a.c(routePointList.b());
    }
}
