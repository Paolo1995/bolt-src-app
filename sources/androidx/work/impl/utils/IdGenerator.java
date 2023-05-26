package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

/* loaded from: classes.dex */
public class IdGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final WorkDatabase f8689a;

    public IdGenerator(@NonNull WorkDatabase workDatabase) {
        this.f8689a = workDatabase;
    }

    public static void a(@NonNull Context context, @NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i8 = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i9 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            supportSQLiteDatabase.n();
            try {
                supportSQLiteDatabase.L("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i8)});
                supportSQLiteDatabase.L("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i9)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.K();
            } finally {
                supportSQLiteDatabase.S();
            }
        }
    }

    private int c(String str) {
        int i8;
        this.f8689a.e();
        try {
            Long b8 = this.f8689a.L().b(str);
            int i9 = 0;
            if (b8 != null) {
                i8 = b8.intValue();
            } else {
                i8 = 0;
            }
            if (i8 != Integer.MAX_VALUE) {
                i9 = i8 + 1;
            }
            e(str, i9);
            this.f8689a.E();
            return i8;
        } finally {
            this.f8689a.i();
        }
    }

    private void e(String str, int i8) {
        this.f8689a.L().a(new Preference(str, i8));
    }

    public int b() {
        int c8;
        synchronized (IdGenerator.class) {
            c8 = c("next_alarm_manager_id");
        }
        return c8;
    }

    public int d(int i8, int i9) {
        synchronized (IdGenerator.class) {
            int c8 = c("next_job_scheduler_id");
            if (c8 >= i8 && c8 <= i9) {
                i8 = c8;
            }
            e("next_job_scheduler_id", i8 + 1);
        }
        return i8;
    }
}
