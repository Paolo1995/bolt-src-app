package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

/* loaded from: classes.dex */
public class PreferenceUtils {

    /* renamed from: a  reason: collision with root package name */
    private final WorkDatabase f8691a;

    public PreferenceUtils(@NonNull WorkDatabase workDatabase) {
        this.f8691a = workDatabase;
    }

    public static void b(@NonNull Context context, @NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j8 = 0;
            long j9 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                j8 = 1;
            }
            supportSQLiteDatabase.n();
            try {
                supportSQLiteDatabase.L("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j9)});
                supportSQLiteDatabase.L("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j8)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.K();
            } finally {
                supportSQLiteDatabase.S();
            }
        }
    }

    public boolean a() {
        Long b8 = this.f8691a.L().b("reschedule_needed");
        if (b8 != null && b8.longValue() == 1) {
            return true;
        }
        return false;
    }

    public void c(boolean z7) {
        this.f8691a.L().a(new Preference("reschedule_needed", z7));
    }
}
