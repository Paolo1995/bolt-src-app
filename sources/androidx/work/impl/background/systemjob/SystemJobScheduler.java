package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class SystemJobScheduler implements Scheduler {

    /* renamed from: j  reason: collision with root package name */
    private static final String f8508j = Logger.f("SystemJobScheduler");

    /* renamed from: f  reason: collision with root package name */
    private final Context f8509f;

    /* renamed from: g  reason: collision with root package name */
    private final JobScheduler f8510g;

    /* renamed from: h  reason: collision with root package name */
    private final WorkManagerImpl f8511h;

    /* renamed from: i  reason: collision with root package name */
    private final SystemJobInfoConverter f8512i;

    public SystemJobScheduler(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this(context, workManagerImpl, (JobScheduler) context.getSystemService("jobscheduler"), new SystemJobInfoConverter(context));
    }

    public static void b(@NonNull Context context) {
        List<JobInfo> f8;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (f8 = f(context, jobScheduler)) != null && !f8.isEmpty()) {
            for (JobInfo jobInfo : f8) {
                d(jobScheduler, jobInfo.getId());
            }
        }
    }

    private static void d(@NonNull JobScheduler jobScheduler, int i8) {
        try {
            jobScheduler.cancel(i8);
        } catch (Throwable th) {
            Logger.c().b(f8508j, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i8)), th);
        }
    }

    private static List<Integer> e(@NonNull Context context, @NonNull JobScheduler jobScheduler, @NonNull String str) {
        List<JobInfo> f8 = f(context, jobScheduler);
        if (f8 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : f8) {
            if (str.equals(g(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    private static List<JobInfo> f(@NonNull Context context, @NonNull JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.c().b(f8508j, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static String g(@NonNull JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras != null) {
            try {
                if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                    return extras.getString("EXTRA_WORK_SPEC_ID");
                }
                return null;
            } catch (NullPointerException unused) {
                return null;
            }
        }
        return null;
    }

    public static boolean h(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        int i8;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> f8 = f(context, jobScheduler);
        List<String> b8 = workManagerImpl.o().M().b();
        boolean z7 = false;
        if (f8 != null) {
            i8 = f8.size();
        } else {
            i8 = 0;
        }
        HashSet hashSet = new HashSet(i8);
        if (f8 != null && !f8.isEmpty()) {
            for (JobInfo jobInfo : f8) {
                String g8 = g(jobInfo);
                if (!TextUtils.isEmpty(g8)) {
                    hashSet.add(g8);
                } else {
                    d(jobScheduler, jobInfo.getId());
                }
            }
        }
        Iterator<String> it = b8.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!hashSet.contains(it.next())) {
                    Logger.c().a(f8508j, "Reconciling jobs", new Throwable[0]);
                    z7 = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z7) {
            WorkDatabase o8 = workManagerImpl.o();
            o8.e();
            try {
                WorkSpecDao P = o8.P();
                for (String str : b8) {
                    P.m(str, -1L);
                }
                o8.E();
            } finally {
                o8.i();
            }
        }
        return z7;
    }

    @Override // androidx.work.impl.Scheduler
    public void a(@NonNull WorkSpec... workSpecArr) {
        int d8;
        List<Integer> e8;
        int d9;
        WorkDatabase o8 = this.f8511h.o();
        IdGenerator idGenerator = new IdGenerator(o8);
        for (WorkSpec workSpec : workSpecArr) {
            o8.e();
            try {
                WorkSpec h8 = o8.P().h(workSpec.f8618a);
                if (h8 == null) {
                    Logger.c().h(f8508j, "Skipping scheduling " + workSpec.f8618a + " because it's no longer in the DB", new Throwable[0]);
                    o8.E();
                } else if (h8.f8619b != WorkInfo.State.ENQUEUED) {
                    Logger.c().h(f8508j, "Skipping scheduling " + workSpec.f8618a + " because it is no longer enqueued", new Throwable[0]);
                    o8.E();
                } else {
                    SystemIdInfo a8 = o8.M().a(workSpec.f8618a);
                    if (a8 != null) {
                        d8 = a8.f8596b;
                    } else {
                        d8 = idGenerator.d(this.f8511h.i().h(), this.f8511h.i().f());
                    }
                    if (a8 == null) {
                        this.f8511h.o().M().c(new SystemIdInfo(workSpec.f8618a, d8));
                    }
                    i(workSpec, d8);
                    if (Build.VERSION.SDK_INT == 23 && (e8 = e(this.f8509f, this.f8510g, workSpec.f8618a)) != null) {
                        int indexOf = e8.indexOf(Integer.valueOf(d8));
                        if (indexOf >= 0) {
                            e8.remove(indexOf);
                        }
                        if (!e8.isEmpty()) {
                            d9 = e8.get(0).intValue();
                        } else {
                            d9 = idGenerator.d(this.f8511h.i().h(), this.f8511h.i().f());
                        }
                        i(workSpec, d9);
                    }
                    o8.E();
                }
                o8.i();
            } catch (Throwable th) {
                o8.i();
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.Scheduler
    public boolean c() {
        return true;
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(@NonNull String str) {
        List<Integer> e8 = e(this.f8509f, this.f8510g, str);
        if (e8 != null && !e8.isEmpty()) {
            for (Integer num : e8) {
                d(this.f8510g, num.intValue());
            }
            this.f8511h.o().M().d(str);
        }
    }

    public void i(WorkSpec workSpec, int i8) {
        int i9;
        JobInfo a8 = this.f8512i.a(workSpec, i8);
        Logger c8 = Logger.c();
        String str = f8508j;
        c8.a(str, String.format("Scheduling work ID %s Job ID %s", workSpec.f8618a, Integer.valueOf(i8)), new Throwable[0]);
        try {
            if (this.f8510g.schedule(a8) == 0) {
                Logger.c().h(str, String.format("Unable to schedule work ID %s", workSpec.f8618a), new Throwable[0]);
                if (workSpec.f8634q && workSpec.f8635r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.f8634q = false;
                    Logger.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", workSpec.f8618a), new Throwable[0]);
                    i(workSpec, i8);
                }
            }
        } catch (IllegalStateException e8) {
            List<JobInfo> f8 = f(this.f8509f, this.f8510g);
            if (f8 != null) {
                i9 = f8.size();
            } else {
                i9 = 0;
            }
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(i9), Integer.valueOf(this.f8511h.o().P().e().size()), Integer.valueOf(this.f8511h.i().g()));
            Logger.c().b(f8508j, format, new Throwable[0]);
            throw new IllegalStateException(format, e8);
        } catch (Throwable th) {
            Logger.c().b(f8508j, String.format("Unable to schedule %s", workSpec), th);
        }
    }

    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.f8509f = context;
        this.f8511h = workManagerImpl;
        this.f8510g = jobScheduler;
        this.f8512i = systemJobInfoConverter;
    }
}
