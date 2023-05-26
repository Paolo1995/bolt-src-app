package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* loaded from: classes.dex */
public class JobInfoScheduler implements WorkScheduler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f12222a;

    /* renamed from: b  reason: collision with root package name */
    private final EventStore f12223b;

    /* renamed from: c  reason: collision with root package name */
    private final SchedulerConfig f12224c;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.f12222a = context;
        this.f12223b = eventStore;
        this.f12224c = schedulerConfig;
    }

    private boolean d(JobScheduler jobScheduler, int i8, int i9) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i10 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i8) {
                if (i10 < i9) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void a(TransportContext transportContext, int i8) {
        b(transportContext, i8, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void b(TransportContext transportContext, int i8, boolean z7) {
        ComponentName componentName = new ComponentName(this.f12222a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f12222a.getSystemService("jobscheduler");
        int c8 = c(transportContext);
        if (!z7 && d(jobScheduler, c8, i8)) {
            Logging.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long g02 = this.f12223b.g0(transportContext);
        JobInfo.Builder c9 = this.f12224c.c(new JobInfo.Builder(c8, componentName), transportContext.d(), g02, i8);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i8);
        persistableBundle.putString("backendName", transportContext.b());
        persistableBundle.putInt("priority", PriorityMapping.a(transportContext.d()));
        if (transportContext.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        c9.setExtras(persistableBundle);
        Logging.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Integer.valueOf(c8), Long.valueOf(this.f12224c.g(transportContext.d(), g02, i8)), Long.valueOf(g02), Integer.valueOf(i8));
        jobScheduler.schedule(c9.build());
    }

    int c(TransportContext transportContext) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f12222a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(transportContext.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.a(transportContext.d())).array());
        if (transportContext.c() != null) {
            adler32.update(transportContext.c());
        }
        return (int) adler32.getValue();
    }
}
