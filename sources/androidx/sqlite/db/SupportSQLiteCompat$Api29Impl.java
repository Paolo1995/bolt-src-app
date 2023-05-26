package androidx.sqlite.db;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes.dex */
public final class SupportSQLiteCompat$Api29Impl {
    private SupportSQLiteCompat$Api29Impl() {
    }

    @NonNull
    public static List<Uri> a(@NonNull Cursor cursor) {
        List<Uri> notificationUris;
        notificationUris = cursor.getNotificationUris();
        return notificationUris;
    }

    public static void b(@NonNull Cursor cursor, @NonNull ContentResolver contentResolver, @NonNull List<Uri> list) {
        cursor.setNotificationUris(contentResolver, list);
    }
}
