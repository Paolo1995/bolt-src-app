package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import androidx.sqlite.db.SupportSQLiteCompat$Api16Impl;
import androidx.sqlite.db.SupportSQLiteCompat$Api21Impl;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;

/* loaded from: classes.dex */
class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {

    /* renamed from: f  reason: collision with root package name */
    private final Context f7755f;

    /* renamed from: g  reason: collision with root package name */
    private final String f7756g;

    /* renamed from: h  reason: collision with root package name */
    private final SupportSQLiteOpenHelper.Callback f7757h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f7758i;

    /* renamed from: j  reason: collision with root package name */
    private final Object f7759j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private OpenHelper f7760k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7761l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class OpenHelper extends SQLiteOpenHelper {

        /* renamed from: f  reason: collision with root package name */
        final FrameworkSQLiteDatabase[] f7762f;

        /* renamed from: g  reason: collision with root package name */
        final SupportSQLiteOpenHelper.Callback f7763g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f7764h;

        OpenHelper(Context context, String str, final FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, final SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, null, callback.f7739a, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.1
                @Override // android.database.DatabaseErrorHandler
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    SupportSQLiteOpenHelper.Callback.this.c(OpenHelper.e(frameworkSQLiteDatabaseArr, sQLiteDatabase));
                }
            });
            this.f7763g = callback;
            this.f7762f = frameworkSQLiteDatabaseArr;
        }

        static FrameworkSQLiteDatabase e(FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, SQLiteDatabase sQLiteDatabase) {
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
            if (frameworkSQLiteDatabase == null || !frameworkSQLiteDatabase.a(sQLiteDatabase)) {
                frameworkSQLiteDatabaseArr[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
            }
            return frameworkSQLiteDatabaseArr[0];
        }

        synchronized SupportSQLiteDatabase a() {
            this.f7764h = false;
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            if (this.f7764h) {
                close();
                return a();
            }
            return c(readableDatabase);
        }

        FrameworkSQLiteDatabase c(SQLiteDatabase sQLiteDatabase) {
            return e(this.f7762f, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f7762f[0] = null;
        }

        synchronized SupportSQLiteDatabase g() {
            this.f7764h = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f7764h) {
                close();
                return g();
            }
            return c(writableDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f7763g.b(c(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f7763g.d(c(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
            this.f7764h = true;
            this.f7763g.e(c(sQLiteDatabase), i8, i9);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f7764h) {
                this.f7763g.f(c(sQLiteDatabase));
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
            this.f7764h = true;
            this.f7763g.g(c(sQLiteDatabase), i8, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z7) {
        this.f7755f = context;
        this.f7756g = str;
        this.f7757h = callback;
        this.f7758i = z7;
    }

    private OpenHelper a() {
        OpenHelper openHelper;
        synchronized (this.f7759j) {
            if (this.f7760k == null) {
                FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr = new FrameworkSQLiteDatabase[1];
                if (Build.VERSION.SDK_INT >= 23 && this.f7756g != null && this.f7758i) {
                    this.f7760k = new OpenHelper(this.f7755f, new File(SupportSQLiteCompat$Api21Impl.a(this.f7755f), this.f7756g).getAbsolutePath(), frameworkSQLiteDatabaseArr, this.f7757h);
                } else {
                    this.f7760k = new OpenHelper(this.f7755f, this.f7756g, frameworkSQLiteDatabaseArr, this.f7757h);
                }
                SupportSQLiteCompat$Api16Impl.f(this.f7760k, this.f7761l);
            }
            openHelper = this.f7760k;
        }
        return openHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase E0() {
        return a().a();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase H0() {
        return a().g();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a().close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.f7756g;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z7) {
        synchronized (this.f7759j) {
            OpenHelper openHelper = this.f7760k;
            if (openHelper != null) {
                SupportSQLiteCompat$Api16Impl.f(openHelper, z7);
            }
            this.f7761l = z7;
        }
    }
}
