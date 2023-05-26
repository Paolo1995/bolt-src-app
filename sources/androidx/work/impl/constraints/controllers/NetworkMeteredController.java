package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public class NetworkMeteredController extends ConstraintController<NetworkState> {

    /* renamed from: e  reason: collision with root package name */
    private static final String f8528e = Logger.f("NetworkMeteredCtrlr");

    public NetworkMeteredController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.c(context, taskExecutor).d());
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    boolean b(@NonNull WorkSpec workSpec) {
        if (workSpec.f8627j.b() == NetworkType.METERED) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    /* renamed from: i */
    public boolean c(@NonNull NetworkState networkState) {
        if (Build.VERSION.SDK_INT < 26) {
            Logger.c().a(f8528e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return !networkState.a();
        } else if (!networkState.a() || !networkState.b()) {
            return true;
        } else {
            return false;
        }
    }
}
