package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* loaded from: classes.dex */
public class WorkForegroundUpdater implements ForegroundUpdater {

    /* renamed from: d  reason: collision with root package name */
    private static final String f8719d = Logger.f("WMFgUpdater");

    /* renamed from: a  reason: collision with root package name */
    private final TaskExecutor f8720a;

    /* renamed from: b  reason: collision with root package name */
    final ForegroundProcessor f8721b;

    /* renamed from: c  reason: collision with root package name */
    final WorkSpecDao f8722c;

    public WorkForegroundUpdater(@NonNull WorkDatabase workDatabase, @NonNull ForegroundProcessor foregroundProcessor, @NonNull TaskExecutor taskExecutor) {
        this.f8721b = foregroundProcessor;
        this.f8720a = taskExecutor;
        this.f8722c = workDatabase.P();
    }

    @Override // androidx.work.ForegroundUpdater
    @NonNull
    public ListenableFuture<Void> a(@NonNull final Context context, @NonNull final UUID uuid, @NonNull final ForegroundInfo foregroundInfo) {
        final SettableFuture t7 = SettableFuture.t();
        this.f8720a.b(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundUpdater.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!t7.isCancelled()) {
                        String uuid2 = uuid.toString();
                        WorkInfo.State g8 = WorkForegroundUpdater.this.f8722c.g(uuid2);
                        if (g8 != null && !g8.a()) {
                            WorkForegroundUpdater.this.f8721b.b(uuid2, foregroundInfo);
                            context.startService(SystemForegroundDispatcher.a(context, uuid2, foregroundInfo));
                        } else {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                    }
                    t7.p(null);
                } catch (Throwable th) {
                    t7.q(th);
                }
            }
        });
        return t7;
    }
}
