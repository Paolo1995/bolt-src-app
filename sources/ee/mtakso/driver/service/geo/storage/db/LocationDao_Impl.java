package ee.mtakso.driver.service.geo.storage.db;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.service.geo.storage.LocationEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class LocationDao_Impl implements LocationDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f24451a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<LocationEntity> f24452b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<LocationEntity> f24453c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f24454d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f24455e;

    public LocationDao_Impl(RoomDatabase roomDatabase) {
        this.f24451a = roomDatabase;
        this.f24452b = new EntityInsertionAdapter<LocationEntity>(roomDatabase) { // from class: ee.mtakso.driver.service.geo.storage.db.LocationDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR ABORT INTO `LocationEntity` (`orderState`,`lat`,`lng`,`alt`,`speed`,`phoneTimestamp`,`fixed`,`bearing`,`bearingAccuracy`,`orderSystem`,`cityId`,`orderId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, LocationEntity locationEntity) {
                if (locationEntity.h() == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, locationEntity.h());
                }
                supportSQLiteStatement.z(2, locationEntity.e());
                supportSQLiteStatement.z(3, locationEntity.f());
                supportSQLiteStatement.z(4, locationEntity.a());
                if (locationEntity.j() == null) {
                    supportSQLiteStatement.Q0(5);
                } else {
                    supportSQLiteStatement.z(5, locationEntity.j().floatValue());
                }
                supportSQLiteStatement.B0(6, locationEntity.i());
                supportSQLiteStatement.B0(7, locationEntity.d() ? 1L : 0L);
                if (locationEntity.b() == null) {
                    supportSQLiteStatement.Q0(8);
                } else {
                    supportSQLiteStatement.z(8, locationEntity.b().floatValue());
                }
                if (locationEntity.c() == null) {
                    supportSQLiteStatement.Q0(9);
                } else {
                    supportSQLiteStatement.z(9, locationEntity.c().floatValue());
                }
                OrderHandle g8 = locationEntity.g();
                if (g8 != null) {
                    if (g8.c() == null) {
                        supportSQLiteStatement.Q0(10);
                    } else {
                        supportSQLiteStatement.q0(10, g8.c());
                    }
                    supportSQLiteStatement.B0(11, g8.a());
                    supportSQLiteStatement.B0(12, g8.b());
                    return;
                }
                supportSQLiteStatement.Q0(10);
                supportSQLiteStatement.Q0(11);
                supportSQLiteStatement.Q0(12);
            }
        };
        this.f24453c = new EntityDeletionOrUpdateAdapter<LocationEntity>(roomDatabase) { // from class: ee.mtakso.driver.service.geo.storage.db.LocationDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM `LocationEntity` WHERE `orderId` = ? AND `phoneTimestamp` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, LocationEntity locationEntity) {
                supportSQLiteStatement.B0(2, locationEntity.i());
                OrderHandle g8 = locationEntity.g();
                if (g8 != null) {
                    supportSQLiteStatement.B0(1, g8.b());
                } else {
                    supportSQLiteStatement.Q0(1);
                }
            }
        };
        this.f24454d = new SharedSQLiteStatement(roomDatabase) { // from class: ee.mtakso.driver.service.geo.storage.db.LocationDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM LocationEntity WHERE orderId = ? AND cityId = ? AND orderSystem = ?";
            }
        };
        this.f24455e = new SharedSQLiteStatement(roomDatabase) { // from class: ee.mtakso.driver.service.geo.storage.db.LocationDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "DELETE FROM LocationEntity";
            }
        };
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    @Override // ee.mtakso.driver.service.geo.storage.db.LocationDao
    public void a() {
        this.f24451a.d();
        SupportSQLiteStatement a8 = this.f24455e.a();
        this.f24451a.e();
        try {
            a8.x();
            this.f24451a.E();
        } finally {
            this.f24451a.i();
            this.f24455e.f(a8);
        }
    }

    @Override // ee.mtakso.driver.service.geo.storage.db.LocationDao
    public List<LocationEntity> b(long j8, long j9, String str) {
        String string;
        Float valueOf;
        boolean z7;
        Float valueOf2;
        Float valueOf3;
        String string2;
        OrderHandle orderHandle;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM LocationEntity WHERE orderId = ? AND cityId = ? AND orderSystem = ?", 3);
        e8.B0(1, j8);
        e8.B0(2, j9);
        if (str == null) {
            e8.Q0(3);
        } else {
            e8.q0(3, str);
        }
        this.f24451a.d();
        Cursor c8 = DBUtil.c(this.f24451a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, "orderState");
            int e10 = CursorUtil.e(c8, "lat");
            int e11 = CursorUtil.e(c8, "lng");
            int e12 = CursorUtil.e(c8, "alt");
            int e13 = CursorUtil.e(c8, "speed");
            int e14 = CursorUtil.e(c8, "phoneTimestamp");
            int e15 = CursorUtil.e(c8, "fixed");
            int e16 = CursorUtil.e(c8, "bearing");
            int e17 = CursorUtil.e(c8, "bearingAccuracy");
            int e18 = CursorUtil.e(c8, "orderSystem");
            int e19 = CursorUtil.e(c8, "cityId");
            int e20 = CursorUtil.e(c8, "orderId");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                if (c8.isNull(e9)) {
                    string = null;
                } else {
                    string = c8.getString(e9);
                }
                double d8 = c8.getDouble(e10);
                double d9 = c8.getDouble(e11);
                double d10 = c8.getDouble(e12);
                if (c8.isNull(e13)) {
                    valueOf = null;
                } else {
                    valueOf = Float.valueOf(c8.getFloat(e13));
                }
                long j10 = c8.getLong(e14);
                if (c8.getInt(e15) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (c8.isNull(e16)) {
                    valueOf2 = null;
                } else {
                    valueOf2 = Float.valueOf(c8.getFloat(e16));
                }
                if (c8.isNull(e17)) {
                    valueOf3 = null;
                } else {
                    valueOf3 = Float.valueOf(c8.getFloat(e17));
                }
                if (c8.isNull(e18) && c8.isNull(e19) && c8.isNull(e20)) {
                    orderHandle = null;
                    arrayList.add(new LocationEntity(orderHandle, string, d8, d9, d10, valueOf, j10, z7, valueOf2, valueOf3));
                }
                if (c8.isNull(e18)) {
                    string2 = null;
                } else {
                    string2 = c8.getString(e18);
                }
                orderHandle = new OrderHandle(string2, c8.getLong(e19), c8.getLong(e20));
                arrayList.add(new LocationEntity(orderHandle, string, d8, d9, d10, valueOf, j10, z7, valueOf2, valueOf3));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // ee.mtakso.driver.service.geo.storage.db.LocationDao
    public void c(List<LocationEntity> list) {
        this.f24451a.d();
        this.f24451a.e();
        try {
            this.f24453c.h(list);
            this.f24451a.E();
        } finally {
            this.f24451a.i();
        }
    }

    @Override // ee.mtakso.driver.service.geo.storage.db.LocationDao
    public List<LocationEntity> d(long j8, long j9, String str, int i8) {
        String string;
        Float valueOf;
        boolean z7;
        Float valueOf2;
        Float valueOf3;
        String string2;
        OrderHandle orderHandle;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM LocationEntity WHERE orderId = ? AND cityId = ? AND orderSystem = ? LIMIT ?", 4);
        e8.B0(1, j8);
        e8.B0(2, j9);
        if (str == null) {
            e8.Q0(3);
        } else {
            e8.q0(3, str);
        }
        e8.B0(4, i8);
        this.f24451a.d();
        Cursor c8 = DBUtil.c(this.f24451a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, "orderState");
            int e10 = CursorUtil.e(c8, "lat");
            int e11 = CursorUtil.e(c8, "lng");
            int e12 = CursorUtil.e(c8, "alt");
            int e13 = CursorUtil.e(c8, "speed");
            int e14 = CursorUtil.e(c8, "phoneTimestamp");
            int e15 = CursorUtil.e(c8, "fixed");
            int e16 = CursorUtil.e(c8, "bearing");
            int e17 = CursorUtil.e(c8, "bearingAccuracy");
            int e18 = CursorUtil.e(c8, "orderSystem");
            int e19 = CursorUtil.e(c8, "cityId");
            int e20 = CursorUtil.e(c8, "orderId");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                if (c8.isNull(e9)) {
                    string = null;
                } else {
                    string = c8.getString(e9);
                }
                double d8 = c8.getDouble(e10);
                double d9 = c8.getDouble(e11);
                double d10 = c8.getDouble(e12);
                if (c8.isNull(e13)) {
                    valueOf = null;
                } else {
                    valueOf = Float.valueOf(c8.getFloat(e13));
                }
                long j10 = c8.getLong(e14);
                if (c8.getInt(e15) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (c8.isNull(e16)) {
                    valueOf2 = null;
                } else {
                    valueOf2 = Float.valueOf(c8.getFloat(e16));
                }
                if (c8.isNull(e17)) {
                    valueOf3 = null;
                } else {
                    valueOf3 = Float.valueOf(c8.getFloat(e17));
                }
                if (c8.isNull(e18) && c8.isNull(e19) && c8.isNull(e20)) {
                    orderHandle = null;
                    arrayList.add(new LocationEntity(orderHandle, string, d8, d9, d10, valueOf, j10, z7, valueOf2, valueOf3));
                }
                if (c8.isNull(e18)) {
                    string2 = null;
                } else {
                    string2 = c8.getString(e18);
                }
                orderHandle = new OrderHandle(string2, c8.getLong(e19), c8.getLong(e20));
                arrayList.add(new LocationEntity(orderHandle, string, d8, d9, d10, valueOf, j10, z7, valueOf2, valueOf3));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // ee.mtakso.driver.service.geo.storage.db.LocationDao
    public void e(LocationEntity locationEntity) {
        this.f24451a.d();
        this.f24451a.e();
        try {
            this.f24452b.i(locationEntity);
            this.f24451a.E();
        } finally {
            this.f24451a.i();
        }
    }
}
