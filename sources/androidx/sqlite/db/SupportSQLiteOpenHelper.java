package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    /* loaded from: classes.dex */
    public static abstract class Callback {

        /* renamed from: a  reason: collision with root package name */
        public final int f7739a;

        public Callback(int i8) {
            this.f7739a = i8;
        }

        private void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                Log.w("SupportSQLite", "deleting the database file: " + str);
                try {
                    SupportSQLiteCompat$Api16Impl.c(new File(str));
                } catch (Exception e8) {
                    Log.w("SupportSQLite", "delete failed: ", e8);
                }
            }
        }

        public void b(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void c(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + supportSQLiteDatabase.getPath());
            if (!supportSQLiteDatabase.isOpen()) {
                a(supportSQLiteDatabase.getPath());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = supportSQLiteDatabase.r();
                } finally {
                    if (list != null) {
                        for (Pair<String, String> next : list) {
                            a((String) next.second);
                        }
                    } else {
                        a(supportSQLiteDatabase.getPath());
                    }
                }
            } catch (SQLiteException unused) {
            }
            try {
                supportSQLiteDatabase.close();
            } catch (IOException unused2) {
            }
        }

        public abstract void d(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);

        public void e(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i8, int i9) {
            throw new SQLiteException("Can't downgrade database from version " + i8 + " to " + i9);
        }

        public void f(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void g(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i8, int i9);
    }

    /* loaded from: classes.dex */
    public static class Configuration {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final Context f7740a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7741b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final Callback f7742c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f7743d;

        /* loaded from: classes.dex */
        public static class Builder {

            /* renamed from: a  reason: collision with root package name */
            Context f7744a;

            /* renamed from: b  reason: collision with root package name */
            String f7745b;

            /* renamed from: c  reason: collision with root package name */
            Callback f7746c;

            /* renamed from: d  reason: collision with root package name */
            boolean f7747d;

            Builder(@NonNull Context context) {
                this.f7744a = context;
            }

            @NonNull
            public Configuration a() {
                if (this.f7746c != null) {
                    if (this.f7744a != null) {
                        if (this.f7747d && TextUtils.isEmpty(this.f7745b)) {
                            throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                        }
                        return new Configuration(this.f7744a, this.f7745b, this.f7746c, this.f7747d);
                    }
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            @NonNull
            public Builder b(@NonNull Callback callback) {
                this.f7746c = callback;
                return this;
            }

            @NonNull
            public Builder c(String str) {
                this.f7745b = str;
                return this;
            }

            @NonNull
            public Builder d(boolean z7) {
                this.f7747d = z7;
                return this;
            }
        }

        Configuration(@NonNull Context context, String str, @NonNull Callback callback, boolean z7) {
            this.f7740a = context;
            this.f7741b = str;
            this.f7742c = callback;
            this.f7743d = z7;
        }

        @NonNull
        public static Builder a(@NonNull Context context) {
            return new Builder(context);
        }
    }

    /* loaded from: classes.dex */
    public interface Factory {
        @NonNull
        SupportSQLiteOpenHelper a(@NonNull Configuration configuration);
    }

    SupportSQLiteDatabase E0();

    SupportSQLiteDatabase H0();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z7);
}
