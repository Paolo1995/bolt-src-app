package androidx.sqlite.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: classes.dex */
public final class SupportSQLiteCompat$Api16Impl {
    private SupportSQLiteCompat$Api16Impl() {
    }

    public static void a(@NonNull CancellationSignal cancellationSignal) {
        cancellationSignal.cancel();
    }

    @NonNull
    public static CancellationSignal b() {
        return new CancellationSignal();
    }

    public static boolean c(@NonNull File file) {
        return SQLiteDatabase.deleteDatabase(file);
    }

    public static boolean d(@NonNull SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    @NonNull
    public static Cursor e(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull String str, @NonNull String[] strArr, @NonNull String str2, @NonNull CancellationSignal cancellationSignal, @NonNull SQLiteDatabase.CursorFactory cursorFactory) {
        return sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
    }

    public static void f(@NonNull SQLiteOpenHelper sQLiteOpenHelper, boolean z7) {
        sQLiteOpenHelper.setWriteAheadLoggingEnabled(z7);
    }
}
