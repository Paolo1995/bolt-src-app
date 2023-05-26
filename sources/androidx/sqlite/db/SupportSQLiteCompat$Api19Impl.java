package androidx.sqlite.db;

import android.app.ActivityManager;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class SupportSQLiteCompat$Api19Impl {
    private SupportSQLiteCompat$Api19Impl() {
    }

    @NonNull
    public static Uri a(@NonNull Cursor cursor) {
        return cursor.getNotificationUri();
    }

    public static boolean b(@NonNull ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
