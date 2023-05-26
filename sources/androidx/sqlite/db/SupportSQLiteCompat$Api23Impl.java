package androidx.sqlite.db;

import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class SupportSQLiteCompat$Api23Impl {
    private SupportSQLiteCompat$Api23Impl() {
    }

    public static void a(@NonNull Cursor cursor, @NonNull Bundle bundle) {
        cursor.setExtras(bundle);
    }
}
