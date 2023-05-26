package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class WorkManagerTaskExecutor implements TaskExecutor {

    /* renamed from: a  reason: collision with root package name */
    private final SerialExecutor f8770a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f8771b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final Executor f8772c = new Executor() { // from class: androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor.1
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            WorkManagerTaskExecutor.this.d(runnable);
        }
    };

    public WorkManagerTaskExecutor(@NonNull Executor executor) {
        this.f8770a = new SerialExecutor(executor);
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public Executor a() {
        return this.f8772c;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public void b(Runnable runnable) {
        this.f8770a.execute(runnable);
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    @NonNull
    public SerialExecutor c() {
        return this.f8770a;
    }

    public void d(Runnable runnable) {
        this.f8771b.post(runnable);
    }
}
