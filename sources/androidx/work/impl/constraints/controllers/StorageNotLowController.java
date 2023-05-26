package androidx.work.impl.constraints.controllers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public class StorageNotLowController extends ConstraintController<Boolean> {
    public StorageNotLowController(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(Trackers.c(context, taskExecutor).e());
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    boolean b(@NonNull WorkSpec workSpec) {
        return workSpec.f8627j.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    /* renamed from: i */
    public boolean c(@NonNull Boolean bool) {
        return !bool.booleanValue();
    }
}
