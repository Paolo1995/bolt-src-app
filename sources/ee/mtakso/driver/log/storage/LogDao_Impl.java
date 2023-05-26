package ee.mtakso.driver.log.storage;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class LogDao_Impl implements LogDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f21094a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<LogEntity> f21095b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityInsertionAdapter<BigQuerySync> f21096c;

    /* renamed from: d  reason: collision with root package name */
    private final EntityInsertionAdapter<ApplogSync> f21097d;

    /* renamed from: e  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<BigQuerySync> f21098e;

    /* renamed from: f  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<ApplogSync> f21099f;

    public LogDao_Impl(RoomDatabase roomDatabase) {
        this.f21094a = roomDatabase;
        this.f21095b = new EntityInsertionAdapter<LogEntity>(roomDatabase) { // from class: ee.mtakso.driver.log.storage.LogDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR ABORT INTO `LogEntity` (`uid`,`tag`,`message`,`severity`,`timestamp`,`data`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, LogEntity logEntity) {
                supportSQLiteStatement.B0(1, logEntity.f());
                if (logEntity.d() == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.q0(2, logEntity.d());
                }
                if (logEntity.b() == null) {
                    supportSQLiteStatement.Q0(3);
                } else {
                    supportSQLiteStatement.q0(3, logEntity.b());
                }
                if (logEntity.c() == null) {
                    supportSQLiteStatement.Q0(4);
                } else {
                    supportSQLiteStatement.q0(4, logEntity.c());
                }
                supportSQLiteStatement.B0(5, logEntity.e());
                if (logEntity.a() == null) {
                    supportSQLiteStatement.Q0(6);
                } else {
                    supportSQLiteStatement.q0(6, logEntity.a());
                }
            }
        };
        this.f21096c = new EntityInsertionAdapter<BigQuerySync>(roomDatabase) { // from class: ee.mtakso.driver.log.storage.LogDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR ABORT INTO `BigQuerySync` (`logUid`,`wasUploaded`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, BigQuerySync bigQuerySync) {
                supportSQLiteStatement.B0(1, bigQuerySync.a());
                supportSQLiteStatement.B0(2, bigQuerySync.b() ? 1L : 0L);
            }
        };
        this.f21097d = new EntityInsertionAdapter<ApplogSync>(roomDatabase) { // from class: ee.mtakso.driver.log.storage.LogDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR ABORT INTO `ApplogSync` (`logUid`,`wasUploaded`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, ApplogSync applogSync) {
                supportSQLiteStatement.B0(1, applogSync.a());
                supportSQLiteStatement.B0(2, applogSync.b() ? 1L : 0L);
            }
        };
        this.f21098e = new EntityDeletionOrUpdateAdapter<BigQuerySync>(roomDatabase) { // from class: ee.mtakso.driver.log.storage.LogDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE OR ABORT `BigQuerySync` SET `logUid` = ?,`wasUploaded` = ? WHERE `logUid` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, BigQuerySync bigQuerySync) {
                supportSQLiteStatement.B0(1, bigQuerySync.a());
                supportSQLiteStatement.B0(2, bigQuerySync.b() ? 1L : 0L);
                supportSQLiteStatement.B0(3, bigQuerySync.a());
            }
        };
        this.f21099f = new EntityDeletionOrUpdateAdapter<ApplogSync>(roomDatabase) { // from class: ee.mtakso.driver.log.storage.LogDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE OR ABORT `ApplogSync` SET `logUid` = ?,`wasUploaded` = ? WHERE `logUid` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, ApplogSync applogSync) {
                supportSQLiteStatement.B0(1, applogSync.a());
                supportSQLiteStatement.B0(2, applogSync.b() ? 1L : 0L);
                supportSQLiteStatement.B0(3, applogSync.a());
            }
        };
    }

    public static List<Class<?>> n() {
        return Collections.emptyList();
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public List<Long> a(List<LogEntity> list) {
        this.f21094a.d();
        this.f21094a.e();
        try {
            List<Long> j8 = this.f21095b.j(list);
            this.f21094a.E();
            return j8;
        } finally {
            this.f21094a.i();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public void b(List<ApplogSync> list) {
        this.f21094a.d();
        this.f21094a.e();
        try {
            this.f21097d.h(list);
            this.f21094a.E();
        } finally {
            this.f21094a.i();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public void c(List<BigQuerySync> list) {
        this.f21094a.d();
        this.f21094a.e();
        try {
            this.f21096c.h(list);
            this.f21094a.E();
        } finally {
            this.f21094a.i();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public List<LogEntity> d(String str) {
        String string;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM LogEntity LEFT JOIN ApplogSync ON LogEntity.uid = ApplogSync.logUid WHERE ApplogSync.logUid is null AND LogEntity.tag = ? ORDER BY LogEntity.timestamp DESC", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f21094a.d();
        Cursor c8 = DBUtil.c(this.f21094a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, "uid");
            int e10 = CursorUtil.e(c8, "tag");
            int e11 = CursorUtil.e(c8, "message");
            int e12 = CursorUtil.e(c8, "severity");
            int e13 = CursorUtil.e(c8, "timestamp");
            int e14 = CursorUtil.e(c8, "data");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                long j8 = c8.getLong(e9);
                if (c8.isNull(e10)) {
                    string = null;
                } else {
                    string = c8.getString(e10);
                }
                if (c8.isNull(e11)) {
                    string2 = null;
                } else {
                    string2 = c8.getString(e11);
                }
                if (c8.isNull(e12)) {
                    string3 = null;
                } else {
                    string3 = c8.getString(e12);
                }
                long j9 = c8.getLong(e13);
                if (c8.isNull(e14)) {
                    string4 = null;
                } else {
                    string4 = c8.getString(e14);
                }
                arrayList.add(new LogEntity(j8, string, string2, string3, j9, string4));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public List<LogEntity> e() {
        String string;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM LogEntity INNER JOIN BigQuerySync ON BigQuerySync.logUid = LogEntity.uid WHERE wasUploaded = 0 ORDER BY LogEntity.timestamp ASC", 0);
        this.f21094a.d();
        Cursor c8 = DBUtil.c(this.f21094a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, "uid");
            int e10 = CursorUtil.e(c8, "tag");
            int e11 = CursorUtil.e(c8, "message");
            int e12 = CursorUtil.e(c8, "severity");
            int e13 = CursorUtil.e(c8, "timestamp");
            int e14 = CursorUtil.e(c8, "data");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                long j8 = c8.getLong(e9);
                if (c8.isNull(e10)) {
                    string = null;
                } else {
                    string = c8.getString(e10);
                }
                if (c8.isNull(e11)) {
                    string2 = null;
                } else {
                    string2 = c8.getString(e11);
                }
                if (c8.isNull(e12)) {
                    string3 = null;
                } else {
                    string3 = c8.getString(e12);
                }
                long j9 = c8.getLong(e13);
                if (c8.isNull(e14)) {
                    string4 = null;
                } else {
                    string4 = c8.getString(e14);
                }
                arrayList.add(new LogEntity(j8, string, string2, string3, j9, string4));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public List<LogEntity> f(String str) {
        String string;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM LogEntity LEFT JOIN ApplogSync ON LogEntity.uid = ApplogSync.logUid WHERE ApplogSync.logUid is null AND LogEntity.message = ? ORDER BY LogEntity.timestamp DESC", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f21094a.d();
        Cursor c8 = DBUtil.c(this.f21094a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, "uid");
            int e10 = CursorUtil.e(c8, "tag");
            int e11 = CursorUtil.e(c8, "message");
            int e12 = CursorUtil.e(c8, "severity");
            int e13 = CursorUtil.e(c8, "timestamp");
            int e14 = CursorUtil.e(c8, "data");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                long j8 = c8.getLong(e9);
                if (c8.isNull(e10)) {
                    string = null;
                } else {
                    string = c8.getString(e10);
                }
                if (c8.isNull(e11)) {
                    string2 = null;
                } else {
                    string2 = c8.getString(e11);
                }
                if (c8.isNull(e12)) {
                    string3 = null;
                } else {
                    string3 = c8.getString(e12);
                }
                long j9 = c8.getLong(e13);
                if (c8.isNull(e14)) {
                    string4 = null;
                } else {
                    string4 = c8.getString(e14);
                }
                arrayList.add(new LogEntity(j8, string, string2, string3, j9, string4));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public List<LogEntity> g(String str, long j8, int i8) {
        String string;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM LogEntity LEFT JOIN ApplogSync ON LogEntity.uid = ApplogSync.logUid WHERE ApplogSync.logUid is null AND LogEntity.tag = ? AND LogEntity.timestamp <= ? ORDER BY LogEntity.timestamp DESC LIMIT ?", 3);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        e8.B0(2, j8);
        e8.B0(3, i8);
        this.f21094a.d();
        Cursor c8 = DBUtil.c(this.f21094a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, "uid");
            int e10 = CursorUtil.e(c8, "tag");
            int e11 = CursorUtil.e(c8, "message");
            int e12 = CursorUtil.e(c8, "severity");
            int e13 = CursorUtil.e(c8, "timestamp");
            int e14 = CursorUtil.e(c8, "data");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                long j9 = c8.getLong(e9);
                if (c8.isNull(e10)) {
                    string = null;
                } else {
                    string = c8.getString(e10);
                }
                if (c8.isNull(e11)) {
                    string2 = null;
                } else {
                    string2 = c8.getString(e11);
                }
                if (c8.isNull(e12)) {
                    string3 = null;
                } else {
                    string3 = c8.getString(e12);
                }
                long j10 = c8.getLong(e13);
                if (c8.isNull(e14)) {
                    string4 = null;
                } else {
                    string4 = c8.getString(e14);
                }
                arrayList.add(new LogEntity(j9, string, string2, string3, j10, string4));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public List<LogEntity> h(String str) {
        String string;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM LogEntity LEFT JOIN BigQuerySync ON LogEntity.uid = BigQuerySync.logUid WHERE BigQuerySync.logUid is null AND LogEntity.message = ? ORDER BY LogEntity.timestamp DESC", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f21094a.d();
        Cursor c8 = DBUtil.c(this.f21094a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, "uid");
            int e10 = CursorUtil.e(c8, "tag");
            int e11 = CursorUtil.e(c8, "message");
            int e12 = CursorUtil.e(c8, "severity");
            int e13 = CursorUtil.e(c8, "timestamp");
            int e14 = CursorUtil.e(c8, "data");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                long j8 = c8.getLong(e9);
                if (c8.isNull(e10)) {
                    string = null;
                } else {
                    string = c8.getString(e10);
                }
                if (c8.isNull(e11)) {
                    string2 = null;
                } else {
                    string2 = c8.getString(e11);
                }
                if (c8.isNull(e12)) {
                    string3 = null;
                } else {
                    string3 = c8.getString(e12);
                }
                long j9 = c8.getLong(e13);
                if (c8.isNull(e14)) {
                    string4 = null;
                } else {
                    string4 = c8.getString(e14);
                }
                arrayList.add(new LogEntity(j8, string, string2, string3, j9, string4));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public List<LogEntity> i(String str, long j8) {
        String string;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM LogEntity LEFT JOIN ApplogSync ON LogEntity.uid = ApplogSync.logUid WHERE ApplogSync.logUid is null AND LogEntity.message = ? AND LogEntity.timestamp <= ? ORDER BY LogEntity.timestamp DESC", 2);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        e8.B0(2, j8);
        this.f21094a.d();
        Cursor c8 = DBUtil.c(this.f21094a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, "uid");
            int e10 = CursorUtil.e(c8, "tag");
            int e11 = CursorUtil.e(c8, "message");
            int e12 = CursorUtil.e(c8, "severity");
            int e13 = CursorUtil.e(c8, "timestamp");
            int e14 = CursorUtil.e(c8, "data");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                long j9 = c8.getLong(e9);
                if (c8.isNull(e10)) {
                    string = null;
                } else {
                    string = c8.getString(e10);
                }
                if (c8.isNull(e11)) {
                    string2 = null;
                } else {
                    string2 = c8.getString(e11);
                }
                if (c8.isNull(e12)) {
                    string3 = null;
                } else {
                    string3 = c8.getString(e12);
                }
                long j10 = c8.getLong(e13);
                if (c8.isNull(e14)) {
                    string4 = null;
                } else {
                    string4 = c8.getString(e14);
                }
                arrayList.add(new LogEntity(j9, string, string2, string3, j10, string4));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public void j(List<BigQuerySync> list) {
        this.f21094a.d();
        this.f21094a.e();
        try {
            this.f21098e.h(list);
            this.f21094a.E();
        } finally {
            this.f21094a.i();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public List<LogEntity> k() {
        String string;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM LogEntity INNER JOIN ApplogSync ON ApplogSync.logUid = LogEntity.uid WHERE wasUploaded = 0 ORDER BY LogEntity.timestamp ASC", 0);
        this.f21094a.d();
        Cursor c8 = DBUtil.c(this.f21094a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, "uid");
            int e10 = CursorUtil.e(c8, "tag");
            int e11 = CursorUtil.e(c8, "message");
            int e12 = CursorUtil.e(c8, "severity");
            int e13 = CursorUtil.e(c8, "timestamp");
            int e14 = CursorUtil.e(c8, "data");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                long j8 = c8.getLong(e9);
                if (c8.isNull(e10)) {
                    string = null;
                } else {
                    string = c8.getString(e10);
                }
                if (c8.isNull(e11)) {
                    string2 = null;
                } else {
                    string2 = c8.getString(e11);
                }
                if (c8.isNull(e12)) {
                    string3 = null;
                } else {
                    string3 = c8.getString(e12);
                }
                long j9 = c8.getLong(e13);
                if (c8.isNull(e14)) {
                    string4 = null;
                } else {
                    string4 = c8.getString(e14);
                }
                arrayList.add(new LogEntity(j8, string, string2, string3, j9, string4));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public List<LogEntity> l(String str) {
        String string;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM LogEntity LEFT JOIN BigQuerySync ON LogEntity.uid = BigQuerySync.logUid WHERE BigQuerySync.logUid is null AND LogEntity.tag = ? ORDER BY LogEntity.timestamp DESC", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        this.f21094a.d();
        Cursor c8 = DBUtil.c(this.f21094a, e8, false, null);
        try {
            int e9 = CursorUtil.e(c8, "uid");
            int e10 = CursorUtil.e(c8, "tag");
            int e11 = CursorUtil.e(c8, "message");
            int e12 = CursorUtil.e(c8, "severity");
            int e13 = CursorUtil.e(c8, "timestamp");
            int e14 = CursorUtil.e(c8, "data");
            ArrayList arrayList = new ArrayList(c8.getCount());
            while (c8.moveToNext()) {
                long j8 = c8.getLong(e9);
                if (c8.isNull(e10)) {
                    string = null;
                } else {
                    string = c8.getString(e10);
                }
                if (c8.isNull(e11)) {
                    string2 = null;
                } else {
                    string2 = c8.getString(e11);
                }
                if (c8.isNull(e12)) {
                    string3 = null;
                } else {
                    string3 = c8.getString(e12);
                }
                long j9 = c8.getLong(e13);
                if (c8.isNull(e14)) {
                    string4 = null;
                } else {
                    string4 = c8.getString(e14);
                }
                arrayList.add(new LogEntity(j8, string, string2, string3, j9, string4));
            }
            return arrayList;
        } finally {
            c8.close();
            e8.release();
        }
    }

    @Override // ee.mtakso.driver.log.storage.LogDao
    public void m(List<ApplogSync> list) {
        this.f21094a.d();
        this.f21094a.e();
        try {
            this.f21099f.h(list);
            this.f21094a.E();
        } finally {
            this.f21094a.i();
        }
    }
}
