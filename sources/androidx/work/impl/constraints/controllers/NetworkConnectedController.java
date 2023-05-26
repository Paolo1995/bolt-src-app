package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public class NetworkConnectedController extends ConstraintController<NetworkState> {
    public NetworkConnectedController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.c(context, taskExecutor).d());
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    boolean b(@NonNull WorkSpec workSpec) {
        if (workSpec.f8627j.b() == NetworkType.CONNECTED) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    /* renamed from: i */
    public boolean c(@NonNull NetworkState networkState) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (!networkState.a() || !networkState.d()) {
                return true;
            }
            return false;
        }
        return !networkState.a();
    }
}
