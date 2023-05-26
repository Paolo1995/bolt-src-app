package androidx.room;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.List;

/* loaded from: classes.dex */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {

    /* renamed from: b  reason: collision with root package name */
    private DatabaseConfiguration f7581b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Delegate f7582c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final String f7583d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final String f7584e;

    /* loaded from: classes.dex */
    public static abstract class Delegate {

        /* renamed from: a  reason: collision with root package name */
        public final int f7585a;

        public Delegate(int i8) {
            this.f7585a = i8;
        }

        protected abstract void a(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void b(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void c(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void d(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void e(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void f(SupportSQLiteDatabase supportSQLiteDatabase);

        @NonNull
        protected abstract ValidationResult g(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);
    }

    /* loaded from: classes.dex */
    public static class ValidationResult {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f7586a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7587b;

        public ValidationResult(boolean z7, String str) {
            this.f7586a = z7;
            this.f7587b = str;
        }
    }

    public RoomOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration, @NonNull Delegate delegate, @NonNull String str, @NonNull String str2) {
        super(delegate.f7585a);
        this.f7581b = databaseConfiguration;
        this.f7582c = delegate;
        this.f7583d = str;
        this.f7584e = str2;
    }

    private void h(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (k(supportSQLiteDatabase)) {
            String str = null;
            Cursor a02 = supportSQLiteDatabase.a0(new SimpleSQLiteQuery("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                if (a02.moveToFirst()) {
                    str = a02.getString(0);
                }
                a02.close();
                if (!this.f7583d.equals(str) && !this.f7584e.equals(str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
                return;
            } catch (Throwable th) {
                a02.close();
                throw th;
            }
        }
        ValidationResult g8 = this.f7582c.g(supportSQLiteDatabase);
        if (g8.f7586a) {
            this.f7582c.e(supportSQLiteDatabase);
            l(supportSQLiteDatabase);
            return;
        }
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g8.f7587b);
    }

    private void i(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.u("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean j(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor J0 = supportSQLiteDatabase.J0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z7 = false;
            if (J0.moveToFirst()) {
                if (J0.getInt(0) == 0) {
                    z7 = true;
                }
            }
            return z7;
        } finally {
            J0.close();
        }
    }

    private static boolean k(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor J0 = supportSQLiteDatabase.J0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z7 = false;
            if (J0.moveToFirst()) {
                if (J0.getInt(0) != 0) {
                    z7 = true;
                }
            }
            return z7;
        } finally {
            J0.close();
        }
    }

    private void l(SupportSQLiteDatabase supportSQLiteDatabase) {
        i(supportSQLiteDatabase);
        supportSQLiteDatabase.u(RoomMasterTable.a(this.f7583d));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.b(supportSQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void d(SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean j8 = j(supportSQLiteDatabase);
        this.f7582c.a(supportSQLiteDatabase);
        if (!j8) {
            ValidationResult g8 = this.f7582c.g(supportSQLiteDatabase);
            if (!g8.f7586a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g8.f7587b);
            }
        }
        l(supportSQLiteDatabase);
        this.f7582c.c(supportSQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void e(SupportSQLiteDatabase supportSQLiteDatabase, int i8, int i9) {
        g(supportSQLiteDatabase, i8, i9);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void f(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.f(supportSQLiteDatabase);
        h(supportSQLiteDatabase);
        this.f7582c.d(supportSQLiteDatabase);
        this.f7581b = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void g(SupportSQLiteDatabase supportSQLiteDatabase, int i8, int i9) {
        boolean z7;
        List<Migration> c8;
        DatabaseConfiguration databaseConfiguration = this.f7581b;
        if (databaseConfiguration != null && (c8 = databaseConfiguration.f7446d.c(i8, i9)) != null) {
            this.f7582c.f(supportSQLiteDatabase);
            for (Migration migration : c8) {
                migration.a(supportSQLiteDatabase);
            }
            ValidationResult g8 = this.f7582c.g(supportSQLiteDatabase);
            if (g8.f7586a) {
                this.f7582c.e(supportSQLiteDatabase);
                l(supportSQLiteDatabase);
                z7 = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + g8.f7587b);
            }
        } else {
            z7 = false;
        }
        if (!z7) {
            DatabaseConfiguration databaseConfiguration2 = this.f7581b;
            if (databaseConfiguration2 != null && !databaseConfiguration2.a(i8, i9)) {
                this.f7582c.b(supportSQLiteDatabase);
                this.f7582c.a(supportSQLiteDatabase);
                return;
            }
            throw new IllegalStateException("A migration from " + i8 + " to " + i9 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
    }
}
