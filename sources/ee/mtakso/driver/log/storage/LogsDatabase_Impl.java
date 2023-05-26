package ee.mtakso.driver.log.storage;

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
public final class LogsDatabase_Impl extends LogsDatabase {

    /* renamed from: o  reason: collision with root package name */
    private volatile LogDao f21119o;

    @Override // ee.mtakso.driver.log.storage.LogsDatabase
    public LogDao G() {
        LogDao logDao;
        if (this.f21119o != null) {
            return this.f21119o;
        }
        synchronized (this) {
            if (this.f21119o == null) {
                this.f21119o = new LogDao_Impl(this);
            }
            logDao = this.f21119o;
        }
        return logDao;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker g() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "LogEntity", "BigQuerySync", "ApplogSync");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper h(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.f7443a.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f7444b).c(databaseConfiguration.f7445c).b(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: ee.mtakso.driver.log.storage.LogsDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS `LogEntity` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tag` TEXT, `message` TEXT NOT NULL, `severity` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `data` TEXT NOT NULL)");
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS `BigQuerySync` (`logUid` INTEGER NOT NULL, `wasUploaded` INTEGER NOT NULL, PRIMARY KEY(`logUid`))");
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS `ApplogSync` (`logUid` INTEGER NOT NULL, `wasUploaded` INTEGER NOT NULL, PRIMARY KEY(`logUid`))");
                supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.u("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '986c0980b04fa5c90e239929bd1abc4e')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.u("DROP TABLE IF EXISTS `LogEntity`");
                supportSQLiteDatabase.u("DROP TABLE IF EXISTS `BigQuerySync`");
                supportSQLiteDatabase.u("DROP TABLE IF EXISTS `ApplogSync`");
                if (((RoomDatabase) LogsDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) LogsDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) LogsDatabase_Impl.this).f7544h.get(i8)).b(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void c(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) LogsDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) LogsDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) LogsDatabase_Impl.this).f7544h.get(i8)).a(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void d(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) LogsDatabase_Impl.this).f7537a = supportSQLiteDatabase;
                LogsDatabase_Impl.this.w(supportSQLiteDatabase);
                if (((RoomDatabase) LogsDatabase_Impl.this).f7544h != null) {
                    int size = ((RoomDatabase) LogsDatabase_Impl.this).f7544h.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) LogsDatabase_Impl.this).f7544h.get(i8)).c(supportSQLiteDatabase);
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
                HashMap hashMap = new HashMap(6);
                hashMap.put("uid", new TableInfo.Column("uid", "INTEGER", true, 1, null, 1));
                hashMap.put("tag", new TableInfo.Column("tag", "TEXT", false, 0, null, 1));
                hashMap.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, 1));
                hashMap.put("severity", new TableInfo.Column("severity", "TEXT", true, 0, null, 1));
                hashMap.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                hashMap.put("data", new TableInfo.Column("data", "TEXT", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("LogEntity", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a8 = TableInfo.a(supportSQLiteDatabase, "LogEntity");
                if (!tableInfo.equals(a8)) {
                    return new RoomOpenHelper.ValidationResult(false, "LogEntity(ee.mtakso.driver.log.storage.LogEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + a8);
                }
                HashMap hashMap2 = new HashMap(2);
                hashMap2.put("logUid", new TableInfo.Column("logUid", "INTEGER", true, 1, null, 1));
                hashMap2.put("wasUploaded", new TableInfo.Column("wasUploaded", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("BigQuerySync", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo a9 = TableInfo.a(supportSQLiteDatabase, "BigQuerySync");
                if (!tableInfo2.equals(a9)) {
                    return new RoomOpenHelper.ValidationResult(false, "BigQuerySync(ee.mtakso.driver.log.storage.BigQuerySync).\n Expected:\n" + tableInfo2 + "\n Found:\n" + a9);
                }
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put("logUid", new TableInfo.Column("logUid", "INTEGER", true, 1, null, 1));
                hashMap3.put("wasUploaded", new TableInfo.Column("wasUploaded", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("ApplogSync", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo a10 = TableInfo.a(supportSQLiteDatabase, "ApplogSync");
                if (!tableInfo3.equals(a10)) {
                    return new RoomOpenHelper.ValidationResult(false, "ApplogSync(ee.mtakso.driver.log.storage.ApplogSync).\n Expected:\n" + tableInfo3 + "\n Found:\n" + a10);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "986c0980b04fa5c90e239929bd1abc4e", "3843dd63217809d54af8549e4dd17f8f")).a());
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
        hashMap.put(LogDao.class, LogDao_Impl.n());
        return hashMap;
    }
}
