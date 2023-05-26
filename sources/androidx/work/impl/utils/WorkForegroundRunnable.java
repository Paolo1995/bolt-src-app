package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.os.BuildCompat;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public class WorkForegroundRunnable implements Runnable {

    /* renamed from: l  reason: collision with root package name */
    static final String f8708l = Logger.f("WorkForegroundRunnable");

    /* renamed from: f  reason: collision with root package name */
    final SettableFuture<Void> f8709f = SettableFuture.t();

    /* renamed from: g  reason: collision with root package name */
    final Context f8710g;

    /* renamed from: h  reason: collision with root package name */
    final WorkSpec f8711h;

    /* renamed from: i  reason: collision with root package name */
    final ListenableWorker f8712i;

    /* renamed from: j  reason: collision with root package name */
    final ForegroundUpdater f8713j;

    /* renamed from: k  reason: collision with root package name */
    final TaskExecutor f8714k;

    @SuppressLint({"LambdaLast"})
    public WorkForegroundRunnable(@NonNull Context context, @NonNull WorkSpec workSpec, @NonNull ListenableWorker listenableWorker, @NonNull ForegroundUpdater foregroundUpdater, @NonNull TaskExecutor taskExecutor) {
        this.f8710g = context;
        this.f8711h = workSpec;
        this.f8712i = listenableWorker;
        this.f8713j = foregroundUpdater;
        this.f8714k = taskExecutor;
    }

    @NonNull
    public ListenableFuture<Void> a() {
        return this.f8709f;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (this.f8711h.f8634q && !BuildCompat.c()) {
            final SettableFuture t7 = SettableFuture.t();
            this.f8714k.a().execute(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    t7.r(WorkForegroundRunnable.this.f8712i.d());
                }
            });
            t7.f(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundRunnable.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ForegroundInfo foregroundInfo = (ForegroundInfo) t7.get();
                        if (foregroundInfo != null) {
                            Logger.c().a(WorkForegroundRunnable.f8708l, String.format("Updating notification for %s", WorkForegroundRunnable.this.f8711h.f8620c), new Throwable[0]);
                            WorkForegroundRunnable.this.f8712i.n(true);
                            WorkForegroundRunnable workForegroundRunnable = WorkForegroundRunnable.this;
                            workForegroundRunnable.f8709f.r(workForegroundRunnable.f8713j.a(workForegroundRunnable.f8710g, workForegroundRunnable.f8712i.f(), foregroundInfo));
                            return;
                        }
                        throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", WorkForegroundRunnable.this.f8711h.f8620c));
                    } catch (Throwable th) {
                        WorkForegroundRunnable.this.f8709f.q(th);
                    }
                }
            }, this.f8714k.a());
            return;
        }
        this.f8709f.p(null);
    }
}
