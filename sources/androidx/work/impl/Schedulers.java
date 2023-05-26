package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmScheduler;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.List;

/* loaded from: classes.dex */
public class Schedulers {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8362a = Logger.f("Schedulers");

    private Schedulers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Scheduler a(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workManagerImpl);
            PackageManagerHelper.a(context, SystemJobService.class, true);
            Logger.c().a(f8362a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return systemJobScheduler;
        }
        Scheduler c8 = c(context);
        if (c8 == null) {
            SystemAlarmScheduler systemAlarmScheduler = new SystemAlarmScheduler(context);
            PackageManagerHelper.a(context, SystemAlarmService.class, true);
            Logger.c().a(f8362a, "Created SystemAlarmScheduler", new Throwable[0]);
            return systemAlarmScheduler;
        }
        return c8;
    }

    public static void b(@NonNull Configuration configuration, @NonNull WorkDatabase workDatabase, List<Scheduler> list) {
        if (list != null && list.size() != 0) {
            WorkSpecDao P = workDatabase.P();
            workDatabase.e();
            try {
                List<WorkSpec> o8 = P.o(configuration.g());
                List<WorkSpec> k8 = P.k(200);
                if (o8 != null && o8.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (WorkSpec workSpec : o8) {
                        P.m(workSpec.f8618a, currentTimeMillis);
                    }
                }
                workDatabase.E();
                if (o8 != null && o8.size() > 0) {
                    WorkSpec[] workSpecArr = (WorkSpec[]) o8.toArray(new WorkSpec[o8.size()]);
                    for (Scheduler scheduler : list) {
                        if (scheduler.c()) {
                            scheduler.a(workSpecArr);
                        }
                    }
                }
                if (k8 != null && k8.size() > 0) {
                    WorkSpec[] workSpecArr2 = (WorkSpec[]) k8.toArray(new WorkSpec[k8.size()]);
                    for (Scheduler scheduler2 : list) {
                        if (!scheduler2.c()) {
                            scheduler2.a(workSpecArr2);
                        }
                    }
                }
            } finally {
                workDatabase.i();
            }
        }
    }

    private static Scheduler c(@NonNull Context context) {
        try {
            Scheduler scheduler = (Scheduler) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
            Logger.c().a(f8362a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
            return scheduler;
        } catch (Throwable th) {
            Logger.c().a(f8362a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}
