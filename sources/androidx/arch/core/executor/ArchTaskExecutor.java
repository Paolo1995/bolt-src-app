package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: c  reason: collision with root package name */
    private static volatile ArchTaskExecutor f2297c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f2298d = new Executor() { // from class: androidx.arch.core.executor.ArchTaskExecutor.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.e().c(runnable);
        }
    };
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f2299e = new Executor() { // from class: androidx.arch.core.executor.ArchTaskExecutor.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.e().a(runnable);
        }
    };
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private TaskExecutor f2300a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private TaskExecutor f2301b;

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.f2301b = defaultTaskExecutor;
        this.f2300a = defaultTaskExecutor;
    }

    @NonNull
    public static Executor d() {
        return f2299e;
    }

    @NonNull
    public static ArchTaskExecutor e() {
        if (f2297c != null) {
            return f2297c;
        }
        synchronized (ArchTaskExecutor.class) {
            if (f2297c == null) {
                f2297c = new ArchTaskExecutor();
            }
        }
        return f2297c;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void a(Runnable runnable) {
        this.f2300a.a(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean b() {
        return this.f2300a.b();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void c(Runnable runnable) {
        this.f2300a.c(runnable);
    }
}
