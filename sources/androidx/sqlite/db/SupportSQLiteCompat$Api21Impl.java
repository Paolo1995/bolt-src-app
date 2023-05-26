package androidx.sqlite.db;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: classes.dex */
public final class SupportSQLiteCompat$Api21Impl {
    private SupportSQLiteCompat$Api21Impl() {
    }

    @NonNull
    public static File a(@NonNull Context context) {
        return context.getNoBackupFilesDir();
    }
}
