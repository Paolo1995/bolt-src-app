package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.utils.IdGenerator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Alarms {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8457a = Logger.f("Alarms");

    private Alarms() {
    }

    public static void a(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        SystemIdInfoDao M = workManagerImpl.o().M();
        SystemIdInfo a8 = M.a(str);
        if (a8 != null) {
            b(context, str, a8.f8596b);
            Logger.c().a(f8457a, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            M.d(str);
        }
    }

    private static void b(@NonNull Context context, @NonNull String str, int i8) {
        int i9;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent b8 = CommandHandler.b(context, str);
        if (Build.VERSION.SDK_INT >= 23) {
            i9 = 603979776;
        } else {
            i9 = 536870912;
        }
        PendingIntent service = PendingIntent.getService(context, i8, b8, i9);
        if (service != null && alarmManager != null) {
            Logger.c().a(f8457a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i8)), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void c(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, @NonNull String str, long j8) {
        WorkDatabase o8 = workManagerImpl.o();
        SystemIdInfoDao M = o8.M();
        SystemIdInfo a8 = M.a(str);
        if (a8 != null) {
            b(context, str, a8.f8596b);
            d(context, str, a8.f8596b, j8);
            return;
        }
        int b8 = new IdGenerator(o8).b();
        M.c(new SystemIdInfo(str, b8));
        d(context, str, b8, j8);
    }

    private static void d(@NonNull Context context, @NonNull String str, int i8, long j8) {
        int i9;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (Build.VERSION.SDK_INT >= 23) {
            i9 = 201326592;
        } else {
            i9 = 134217728;
        }
        PendingIntent service = PendingIntent.getService(context, i8, CommandHandler.b(context, str), i9);
        if (alarmManager != null) {
            alarmManager.setExact(0, j8, service);
        }
    }
}
