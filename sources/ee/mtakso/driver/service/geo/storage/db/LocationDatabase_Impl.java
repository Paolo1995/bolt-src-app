package ee.mtakso.driver.service.geo.storage.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class LocationDatabase_Impl extends LocationDatabase {

    /* renamed from: o  reason: collision with root package name */
    private volatile LocationDao f24460o;

    @Override // ee.mtakso.driver.service.geo.storage.db.LocationDatabase
    public LocationDao G() {
        LocationDao locationDao;
        if (this.f24460o != null) {
            return this.f24460o;
        }
        synchronized (this) {
            if (this.f24460o == null) {
                this.f24460o = new LocationDao_Impl(this);
            }
            locationDao = this.f24460o;
        }
        return locationDao;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker g() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "LocationEntity");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper h(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.f7443a.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f7444b).c(databaseConfiguration.f7445c).b(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: ee.mtakso.driver.service.geo.storage.db.LocationDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS `LocationEntity` (`orderState` TEXT NOT NULL, `lat` REAL NOT NULL, `lng` REAL NOT NULL, `alt` REAL NOT NULL, `speed` REAL, `phoneTimestamp` INTEGER NOT NULL, `fixed` INTEGER NOT NULL, `bearing` REAL, `bearingAccuracy` REAL, `orderSystem` TEXT NOT NULL, `cityId` INTEGER NOT NULL, `orderId` INTEGER NOT NULL, PRIMARY KEY(`orderId`, `phoneTimestamp`))");
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.u("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '44d54749fa18641db42b89f43d8693c0')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.u("DROP TABLE IF EXISTS `LocationEntity`");
                if (((RoomDatabase) LocationDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) LocationDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) LocationDatabase_Impl.this).f7544h.get(i8)).b(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void c(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) LocationDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) LocationDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) LocationDatabase_Impl.this).f7544h.get(i8)).a(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void d(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) LocationDatabase_Impl.this).f7537a = supportSQLiteDatabase;
                LocationDatabase_Impl.this.w(supportSQLiteDatabase);
                if (((RoomDatabase) LocationDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) LocationDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) LocationDatabase_Impl.this).f7544h.get(i8)).c(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void e(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void f(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.b(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected RoomOpenHelper.ValidationResult g(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(12);
                hashMap.put("orderState", new TableInfo.Column("orderState", "TEXT", true, 0, null, 1));
                hashMap.put("lat", new TableInfo.Column("lat", "REAL", true, 0, null, 1));
                hashMap.put("lng", new TableInfo.Column("lng", "REAL", true, 0, null, 1));
                hashMap.put("alt", new TableInfo.Column("alt", "REAL", true, 0, null, 1));
                hashMap.put("speed", new TableInfo.Column("speed", "REAL", false, 0, null, 1));
                hashMap.put("phoneTimestamp", new TableInfo.Column("phoneTimestamp", "INTEGER", true, 2, null, 1));
                hashMap.put("fixed", new TableInfo.Column("fixed", "INTEGER", true, 0, null, 1));
                hashMap.put("bearing", new TableInfo.Column("bearing", "REAL", false, 0, null, 1));
                hashMap.put("bearingAccuracy", new TableInfo.Column("bearingAccuracy", "REAL", false, 0, null, 1));
                hashMap.put("orderSystem", new TableInfo.Column("orderSystem", "TEXT", true, 0, null, 1));
                hashMap.put("cityId", new TableInfo.Column("cityId", "INTEGER", true, 0, null, 1));
                hashMap.put("orderId", new TableInfo.Column("orderId", "INTEGER", true, 1, null, 1));
                TableInfo tableInfo = new TableInfo("LocationEntity", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a8 = TableInfo.a(supportSQLiteDatabase, "LocationEntity");
                if (!tableInfo.equals(a8)) {
                    return new RoomOpenHelper.ValidationResult(false, "LocationEntity(ee.mtakso.driver.service.geo.storage.LocationEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + a8);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "44d54749fa18641db42b89f43d8693c0", "96fd11c1776dfcb2a76c08e5cc3f1dcd")).a());
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> j(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> p() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> q() {
        HashMap hashMap = new HashMap();
        hashMap.put(LocationDao.class, LocationDao_Impl.f());
        return hashMap;
    }
}
