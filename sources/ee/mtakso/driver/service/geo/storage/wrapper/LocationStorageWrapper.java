package ee.mtakso.driver.service.geo.storage.wrapper;

import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.service.geo.storage.LocationStorage;
import ee.mtakso.driver.service.geo.storage.RoutePoint;
import ee.mtakso.driver.service.geo.storage.RoutePointList;
import ee.mtakso.driver.service.geo.storage.db.LocationStorageDatabase;
import ee.mtakso.driver.service.geo.storage.memory.LocationStorageInMemory;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationStorageWrapper.kt */
@Singleton
/* loaded from: classes3.dex */
public final class LocationStorageWrapper implements LocationStorage {

    /* renamed from: a  reason: collision with root package name */
    private final LocationStorageInMemory f24467a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationStorageDatabase f24468b;

    /* renamed from: c  reason: collision with root package name */
    private final Features f24469c;

    @Inject
    public LocationStorageWrapper(LocationStorageInMemory locationStorageInMemory, LocationStorageDatabase locationStorageDatabase, Features features) {
        Intrinsics.f(locationStorageInMemory, "locationStorageInMemory");
        Intrinsics.f(locationStorageDatabase, "locationStorageDatabase");
        Intrinsics.f(features, "features");
        this.f24467a = locationStorageInMemory;
        this.f24468b = locationStorageDatabase;
        this.f24469c = features;
    }

    private final LocationStorage f() {
        if (this.f24469c.b(Feature.Type.INMEMORY_LOCATION_STORAGE)) {
            return this.f24467a;
        }
        return this.f24468b;
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorageCleaner
    public void a() {
        f().a();
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public void b(RoutePoint point) {
        Intrinsics.f(point, "point");
        f().b(point);
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public RoutePointList c(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return f().c(orderHandle);
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public RoutePointList d(OrderHandle orderHandle, int i8) {
        Intrinsics.f(orderHandle, "orderHandle");
        return f().d(orderHandle, i8);
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public void e(RoutePointList routePointList) {
        Intrinsics.f(routePointList, "routePointList");
        f().e(routePointList);
    }
}
