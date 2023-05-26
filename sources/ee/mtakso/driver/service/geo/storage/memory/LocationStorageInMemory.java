package ee.mtakso.driver.service.geo.storage.memory;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.service.geo.storage.LocationEntity;
import ee.mtakso.driver.service.geo.storage.LocationStorage;
import ee.mtakso.driver.service.geo.storage.RoutePoint;
import ee.mtakso.driver.service.geo.storage.RoutePointList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationStorageInMemory.kt */
/* loaded from: classes3.dex */
public final class LocationStorageInMemory implements LocationStorage {

    /* renamed from: a  reason: collision with root package name */
    private final InMemoryStorage f24464a = new InMemoryStorage();

    /* compiled from: LocationStorageInMemory.kt */
    /* loaded from: classes3.dex */
    private static final class InMemoryStorage {

        /* renamed from: a  reason: collision with root package name */
        private final Map<OrderHandle, Set<LocationEntity>> f24465a = new LinkedHashMap();

        public final void a(List<LocationEntity> entities) {
            Intrinsics.f(entities, "entities");
            for (LocationEntity locationEntity : entities) {
                synchronized (this) {
                    Set<LocationEntity> set = this.f24465a.get(locationEntity.g());
                    if (set != null) {
                        set.remove(locationEntity);
                    }
                }
            }
        }

        public final void b() {
            synchronized (this) {
                this.f24465a.clear();
                Unit unit = Unit.f50853a;
            }
        }

        public final void c(LocationEntity entity) {
            Intrinsics.f(entity, "entity");
            OrderHandle g8 = entity.g();
            synchronized (this) {
                if (!this.f24465a.containsKey(g8)) {
                    this.f24465a.put(g8, new LinkedHashSet());
                }
                Set<LocationEntity> set = this.f24465a.get(g8);
                if (set != null) {
                    set.add(entity);
                }
            }
        }

        public final List<LocationEntity> d(OrderHandle orderHandle) {
            Object g8;
            Intrinsics.f(orderHandle, "orderHandle");
            synchronized (this) {
                if (this.f24465a.containsKey(orderHandle)) {
                    g8 = MapsKt__MapsKt.g(this.f24465a, orderHandle);
                    return new ArrayList((Collection) g8);
                }
                Unit unit = Unit.f50853a;
                List<LocationEntity> emptyList = Collections.emptyList();
                Intrinsics.e(emptyList, "emptyList()");
                return emptyList;
            }
        }
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorageCleaner
    public void a() {
        this.f24464a.b();
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public void b(RoutePoint point) {
        Intrinsics.f(point, "point");
        this.f24464a.c(point.a());
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public RoutePointList c(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return new RoutePointList(orderHandle, this.f24464a.d(orderHandle));
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public RoutePointList d(OrderHandle orderHandle, int i8) {
        List B0;
        Intrinsics.f(orderHandle, "orderHandle");
        B0 = CollectionsKt___CollectionsKt.B0(this.f24464a.d(orderHandle), i8);
        return new RoutePointList(orderHandle, B0);
    }

    @Override // ee.mtakso.driver.service.geo.storage.LocationStorage
    public void e(RoutePointList routePointList) {
        Intrinsics.f(routePointList, "routePointList");
        this.f24464a.a(routePointList.b());
    }
}
