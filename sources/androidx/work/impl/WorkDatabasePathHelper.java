package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class WorkDatabasePathHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8384a = Logger.f("WrkDbPathHelper");

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f8385b = {"-journal", "-shm", "-wal"};

    private WorkDatabasePathHelper() {
    }

    @NonNull
    public static File a(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return b(context);
        }
        return c(context, "androidx.work.workdb");
    }

    @NonNull
    public static File b(@NonNull Context context) {
        return context.getDatabasePath("androidx.work.workdb");
    }

    private static File c(@NonNull Context context, @NonNull String str) {
        return new File(context.getNoBackupFilesDir(), str);
    }

    @NonNull
    public static String d() {
        return "androidx.work.workdb";
    }

    public static void e(@NonNull Context context) {
        String format;
        File b8 = b(context);
        if (Build.VERSION.SDK_INT >= 23 && b8.exists()) {
            Logger.c().a(f8384a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            Map<File, File> f8 = f(context);
            for (File file : f8.keySet()) {
                File file2 = f8.get(file);
                if (file.exists() && file2 != null) {
                    if (file2.exists()) {
                        Logger.c().h(f8384a, String.format("Over-writing contents of %s", file2), new Throwable[0]);
                    }
                    if (file.renameTo(file2)) {
                        format = String.format("Migrated %s to %s", file, file2);
                    } else {
                        format = String.format("Renaming %s to %s failed", file, file2);
                    }
                    Logger.c().a(f8384a, format, new Throwable[0]);
                }
            }
        }
    }

    @NonNull
    public static Map<File, File> f(@NonNull Context context) {
        File b8;
        File a8;
        String[] strArr;
        HashMap hashMap = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            hashMap.put(b(context), a(context));
            for (String str : f8385b) {
                hashMap.put(new File(b8.getPath() + str), new File(a8.getPath() + str));
            }
        }
        return hashMap;
    }
}
