package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.os.BuildCompat;
import androidx.work.Configuration;
import androidx.work.InitializationExceptionHandler;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    private static final String f8683i = Logger.f("ForceStopRunnable");

    /* renamed from: j  reason: collision with root package name */
    private static final long f8684j = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: f  reason: collision with root package name */
    private final Context f8685f;

    /* renamed from: g  reason: collision with root package name */
    private final WorkManagerImpl f8686g;

    /* renamed from: h  reason: collision with root package name */
    private int f8687h = 0;

    /* loaded from: classes.dex */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static final String f8688a = Logger.f("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                Logger.c().g(f8688a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.g(context);
            }
        }
    }

    public ForceStopRunnable(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this.f8685f = context.getApplicationContext();
        this.f8686g = workManagerImpl;
    }

    static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent d(Context context, int i8) {
        return PendingIntent.getBroadcast(context, -1, c(context), i8);
    }

    @SuppressLint({"ClassVerificationFailure"})
    static void g(Context context) {
        int i8;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (BuildCompat.c()) {
            i8 = 167772160;
        } else {
            i8 = 134217728;
        }
        PendingIntent d8 = d(context, i8);
        long currentTimeMillis = System.currentTimeMillis() + f8684j;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, d8);
        }
    }

    public boolean a() {
        boolean z7;
        boolean z8;
        if (Build.VERSION.SDK_INT >= 23) {
            z7 = SystemJobScheduler.h(this.f8685f, this.f8686g);
        } else {
            z7 = false;
        }
        WorkDatabase o8 = this.f8686g.o();
        WorkSpecDao P = o8.P();
        WorkProgressDao O = o8.O();
        o8.e();
        try {
            List<WorkSpec> q8 = P.q();
            if (q8 != null && !q8.isEmpty()) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                for (WorkSpec workSpec : q8) {
                    P.a(WorkInfo.State.ENQUEUED, workSpec.f8618a);
                    P.m(workSpec.f8618a, -1L);
                }
            }
            O.a();
            o8.E();
            if (!z8 && !z7) {
                return false;
            }
            return true;
        } finally {
            o8.i();
        }
    }

    public void b() {
        boolean a8 = a();
        if (h()) {
            Logger.c().a(f8683i, "Rescheduling Workers.", new Throwable[0]);
            this.f8686g.s();
            this.f8686g.l().c(false);
        } else if (e()) {
            Logger.c().a(f8683i, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f8686g.s();
        } else if (a8) {
            Logger.c().a(f8683i, "Found unfinished work, scheduling it.", new Throwable[0]);
            Schedulers.b(this.f8686g.i(), this.f8686g.o(), this.f8686g.n());
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean e() {
        List historicalProcessExitReasons;
        int i8 = 536870912;
        try {
            if (BuildCompat.c()) {
                i8 = 570425344;
            }
            PendingIntent d8 = d(this.f8685f, i8);
            if (Build.VERSION.SDK_INT >= 30) {
                if (d8 != null) {
                    d8.cancel();
                }
                historicalProcessExitReasons = ((ActivityManager) this.f8685f.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i9 = 0; i9 < historicalProcessExitReasons.size(); i9++) {
                        if (((ApplicationExitInfo) historicalProcessExitReasons.get(i9)).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (d8 == null) {
                g(this.f8685f);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e8) {
            Logger.c().h(f8683i, "Ignoring exception", e8);
            return true;
        }
    }

    public boolean f() {
        Configuration i8 = this.f8686g.i();
        if (TextUtils.isEmpty(i8.b())) {
            Logger.c().a(f8683i, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean b8 = ProcessUtils.b(this.f8685f, i8);
        Logger.c().a(f8683i, String.format("Is default app process = %s", Boolean.valueOf(b8)), new Throwable[0]);
        return b8;
    }

    boolean h() {
        return this.f8686g.l().a();
    }

    public void i(long j8) {
        try {
            Thread.sleep(j8);
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i8;
        try {
            if (!f()) {
                return;
            }
            while (true) {
                WorkDatabasePathHelper.e(this.f8685f);
                Logger.c().a(f8683i, "Performing cleanup operations.", new Throwable[0]);
                try {
                    b();
                    break;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e8) {
                    i8 = this.f8687h + 1;
                    this.f8687h = i8;
                    if (i8 >= 3) {
                        Logger c8 = Logger.c();
                        String str = f8683i;
                        c8.b(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e8);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e8);
                        InitializationExceptionHandler c9 = this.f8686g.i().c();
                        if (c9 != null) {
                            Logger.c().a(str, "Routing exception to the specified exception handler", illegalStateException);
                            c9.a(illegalStateException);
                        } else {
                            throw illegalStateException;
                        }
                    } else {
                        Logger.c().a(f8683i, String.format("Retrying after %s", Long.valueOf(i8 * 300)), e8);
                        i(this.f8687h * 300);
                    }
                }
                Logger.c().a(f8683i, String.format("Retrying after %s", Long.valueOf(i8 * 300)), e8);
                i(this.f8687h * 300);
            }
        } finally {
            this.f8686g.r();
        }
    }
}
