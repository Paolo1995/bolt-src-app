package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat$Api16Impl;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f7748g = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f7749h = new String[0];

    /* renamed from: f  reason: collision with root package name */
    private final SQLiteDatabase f7750f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.f7750f = sQLiteDatabase;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor C(final SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        return SupportSQLiteCompat$Api16Impl.e(this.f7750f, supportSQLiteQuery.a(), f7749h, null, cancellationSignal, new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase.2
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                supportSQLiteQuery.c(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        });
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor J0(String str) {
        return a0(new SimpleSQLiteQuery(str));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void K() {
        this.f7750f.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void L(String str, Object[] objArr) throws SQLException {
        this.f7750f.execSQL(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void M() {
        this.f7750f.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void S() {
        this.f7750f.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean T0() {
        return this.f7750f.inTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SQLiteDatabase sQLiteDatabase) {
        if (this.f7750f == sQLiteDatabase) {
            return true;
        }
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor a0(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.f7750f.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase.1
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                supportSQLiteQuery.c(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, supportSQLiteQuery.a(), f7749h, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f7750f.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean d1() {
        return SupportSQLiteCompat$Api16Impl.d(this.f7750f);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.f7750f.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.f7750f.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void n() {
        this.f7750f.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void p0(int i8) {
        this.f7750f.setVersion(i8);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> r() {
        return this.f7750f.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement r0(String str) {
        return new FrameworkSQLiteStatement(this.f7750f.compileStatement(str));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void u(String str) throws SQLException {
        this.f7750f.execSQL(str);
    }
}
