package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public class WorkProgressUpdater implements ProgressUpdater {

    /* renamed from: c  reason: collision with root package name */
    static final String f8728c = Logger.f("WorkProgressUpdater");

    /* renamed from: a  reason: collision with root package name */
    final WorkDatabase f8729a;

    /* renamed from: b  reason: collision with root package name */
    final TaskExecutor f8730b;

    public WorkProgressUpdater(@NonNull WorkDatabase workDatabase, @NonNull TaskExecutor taskExecutor) {
        this.f8729a = workDatabase;
        this.f8730b = taskExecutor;
    }
}
