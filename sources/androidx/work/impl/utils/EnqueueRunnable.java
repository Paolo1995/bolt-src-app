package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.List;

/* loaded from: classes.dex */
public class EnqueueRunnable implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    private static final String f8680h = Logger.f("EnqueueRunnable");

    /* renamed from: f  reason: collision with root package name */
    private final WorkContinuationImpl f8681f;

    /* renamed from: g  reason: collision with root package name */
    private final OperationImpl f8682g = new OperationImpl();

    public EnqueueRunnable(@NonNull WorkContinuationImpl workContinuationImpl) {
        this.f8681f = workContinuationImpl;
    }

    private static boolean b(@NonNull WorkContinuationImpl workContinuationImpl) {
        boolean c8 = c(workContinuationImpl.g(), workContinuationImpl.f(), (String[]) WorkContinuationImpl.l(workContinuationImpl).toArray(new String[0]), workContinuationImpl.d(), workContinuationImpl.b());
        workContinuationImpl.k();
        return c8;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e1 A[LOOP:5: B:125:0x01db->B:127:0x01e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x020a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(androidx.work.impl.WorkManagerImpl r19, @androidx.annotation.NonNull java.util.List<? extends androidx.work.WorkRequest> r20, java.lang.String[] r21, java.lang.String r22, androidx.work.ExistingWorkPolicy r23) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.c(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static boolean e(@NonNull WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> e8 = workContinuationImpl.e();
        boolean z7 = false;
        if (e8 != null) {
            boolean z8 = false;
            for (WorkContinuationImpl workContinuationImpl2 : e8) {
                if (!workContinuationImpl2.j()) {
                    z8 |= e(workContinuationImpl2);
                } else {
                    Logger.c().h(f8680h, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", workContinuationImpl2.c())), new Throwable[0]);
                }
            }
            z7 = z8;
        }
        return b(workContinuationImpl) | z7;
    }

    private static void g(WorkSpec workSpec) {
        Constraints constraints = workSpec.f8627j;
        String str = workSpec.f8620c;
        if (!str.equals(ConstraintTrackingWorker.class.getName())) {
            if (constraints.f() || constraints.i()) {
                Data.Builder builder = new Data.Builder();
                builder.c(workSpec.f8622e).e("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
                workSpec.f8620c = ConstraintTrackingWorker.class.getName();
                workSpec.f8622e = builder.a();
            }
        }
    }

    private static boolean h(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (Scheduler scheduler : workManagerImpl.n()) {
                if (cls.isAssignableFrom(scheduler.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    public boolean a() {
        WorkDatabase o8 = this.f8681f.g().o();
        o8.e();
        try {
            boolean e8 = e(this.f8681f);
            o8.E();
            return e8;
        } finally {
            o8.i();
        }
    }

    @NonNull
    public Operation d() {
        return this.f8682g;
    }

    public void f() {
        WorkManagerImpl g8 = this.f8681f.g();
        Schedulers.b(g8.i(), g8.o(), g8.n());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!this.f8681f.h()) {
                if (a()) {
                    PackageManagerHelper.a(this.f8681f.g().h(), RescheduleReceiver.class, true);
                    f();
                }
                this.f8682g.a(Operation.f8300a);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.f8681f));
        } catch (Throwable th) {
            this.f8682g.a(new Operation.State.FAILURE(th));
        }
    }
}
