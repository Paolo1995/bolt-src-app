package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SystemJobService extends JobService implements ExecutionListener {

    /* renamed from: h  reason: collision with root package name */
    private static final String f8513h = Logger.f("SystemJobService");

    /* renamed from: f  reason: collision with root package name */
    private WorkManagerImpl f8514f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, JobParameters> f8515g = new HashMap();

    private static String a(@NonNull JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras != null && extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void d(@NonNull String str, boolean z7) {
        JobParameters remove;
        Logger.c().a(f8513h, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.f8515g) {
            remove = this.f8515g.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z7);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl k8 = WorkManagerImpl.k(getApplicationContext());
            this.f8514f = k8;
            k8.m().c(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                Logger.c().h(f8513h, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.f8514f;
        if (workManagerImpl != null) {
            workManagerImpl.m().i(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(@NonNull JobParameters jobParameters) {
        Uri[] triggeredContentUris;
        String[] triggeredContentAuthorities;
        Network network;
        String[] triggeredContentAuthorities2;
        Uri[] triggeredContentUris2;
        if (this.f8514f == null) {
            Logger.c().a(f8513h, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String a8 = a(jobParameters);
        if (TextUtils.isEmpty(a8)) {
            Logger.c().b(f8513h, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.f8515g) {
            if (this.f8515g.containsKey(a8)) {
                Logger.c().a(f8513h, String.format("Job is already being executed by SystemJobService: %s", a8), new Throwable[0]);
                return false;
            }
            Logger.c().a(f8513h, String.format("onStartJob for %s", a8), new Throwable[0]);
            this.f8515g.put(a8, jobParameters);
            WorkerParameters.RuntimeExtras runtimeExtras = null;
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 24) {
                runtimeExtras = new WorkerParameters.RuntimeExtras();
                triggeredContentUris = jobParameters.getTriggeredContentUris();
                if (triggeredContentUris != null) {
                    triggeredContentUris2 = jobParameters.getTriggeredContentUris();
                    runtimeExtras.f8342b = Arrays.asList(triggeredContentUris2);
                }
                triggeredContentAuthorities = jobParameters.getTriggeredContentAuthorities();
                if (triggeredContentAuthorities != null) {
                    triggeredContentAuthorities2 = jobParameters.getTriggeredContentAuthorities();
                    runtimeExtras.f8341a = Arrays.asList(triggeredContentAuthorities2);
                }
                if (i8 >= 28) {
                    network = jobParameters.getNetwork();
                    runtimeExtras.f8343c = network;
                }
            }
            this.f8514f.v(a8, runtimeExtras);
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(@NonNull JobParameters jobParameters) {
        if (this.f8514f == null) {
            Logger.c().a(f8513h, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String a8 = a(jobParameters);
        if (TextUtils.isEmpty(a8)) {
            Logger.c().b(f8513h, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        Logger.c().a(f8513h, String.format("onStopJob for %s", a8), new Throwable[0]);
        synchronized (this.f8515g) {
            this.f8515g.remove(a8);
        }
        this.f8514f.x(a8);
        return !this.f8514f.m().f(a8);
    }
}
