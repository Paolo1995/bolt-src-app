package androidx.work.impl.constraints;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WorkConstraintsTracker implements ConstraintController.OnConstraintUpdatedCallback {

    /* renamed from: d  reason: collision with root package name */
    private static final String f8520d = Logger.f("WorkConstraintsTracker");

    /* renamed from: a  reason: collision with root package name */
    private final WorkConstraintsCallback f8521a;

    /* renamed from: b  reason: collision with root package name */
    private final ConstraintController<?>[] f8522b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f8523c;

    public WorkConstraintsTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor, WorkConstraintsCallback workConstraintsCallback) {
        Context applicationContext = context.getApplicationContext();
        this.f8521a = workConstraintsCallback;
        this.f8522b = new ConstraintController[]{new BatteryChargingController(applicationContext, taskExecutor), new BatteryNotLowController(applicationContext, taskExecutor), new StorageNotLowController(applicationContext, taskExecutor), new NetworkConnectedController(applicationContext, taskExecutor), new NetworkUnmeteredController(applicationContext, taskExecutor), new NetworkNotRoamingController(applicationContext, taskExecutor), new NetworkMeteredController(applicationContext, taskExecutor)};
        this.f8523c = new Object();
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void a(@NonNull List<String> list) {
        synchronized (this.f8523c) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (c(str)) {
                    Logger.c().a(f8520d, String.format("Constraints met for %s", str), new Throwable[0]);
                    arrayList.add(str);
                }
            }
            WorkConstraintsCallback workConstraintsCallback = this.f8521a;
            if (workConstraintsCallback != null) {
                workConstraintsCallback.e(arrayList);
            }
        }
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void b(@NonNull List<String> list) {
        synchronized (this.f8523c) {
            WorkConstraintsCallback workConstraintsCallback = this.f8521a;
            if (workConstraintsCallback != null) {
                workConstraintsCallback.b(list);
            }
        }
    }

    public boolean c(@NonNull String str) {
        ConstraintController<?>[] constraintControllerArr;
        synchronized (this.f8523c) {
            for (ConstraintController<?> constraintController : this.f8522b) {
                if (constraintController.d(str)) {
                    Logger.c().a(f8520d, String.format("Work %s constrained by %s", str, constraintController.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void d(@NonNull Iterable<WorkSpec> iterable) {
        synchronized (this.f8523c) {
            for (ConstraintController<?> constraintController : this.f8522b) {
                constraintController.g(null);
            }
            for (ConstraintController<?> constraintController2 : this.f8522b) {
                constraintController2.e(iterable);
            }
            for (ConstraintController<?> constraintController3 : this.f8522b) {
                constraintController3.g(this);
            }
        }
    }

    public void e() {
        synchronized (this.f8523c) {
            for (ConstraintController<?> constraintController : this.f8522b) {
                constraintController.f();
            }
        }
    }
}
