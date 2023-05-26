package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class SerialExecutor implements Executor {

    /* renamed from: g  reason: collision with root package name */
    private final Executor f8694g;

    /* renamed from: i  reason: collision with root package name */
    private volatile Runnable f8696i;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<Task> f8693f = new ArrayDeque<>();

    /* renamed from: h  reason: collision with root package name */
    private final Object f8695h = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Task implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        final SerialExecutor f8697f;

        /* renamed from: g  reason: collision with root package name */
        final Runnable f8698g;

        Task(@NonNull SerialExecutor serialExecutor, @NonNull Runnable runnable) {
            this.f8697f = serialExecutor;
            this.f8698g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f8698g.run();
            } finally {
                this.f8697f.b();
            }
        }
    }

    public SerialExecutor(@NonNull Executor executor) {
        this.f8694g = executor;
    }

    public boolean a() {
        boolean z7;
        synchronized (this.f8695h) {
            if (!this.f8693f.isEmpty()) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    void b() {
        synchronized (this.f8695h) {
            Task poll = this.f8693f.poll();
            this.f8696i = poll;
            if (poll != null) {
                this.f8694g.execute(this.f8696i);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        synchronized (this.f8695h) {
            this.f8693f.add(new Task(this, runnable));
            if (this.f8696i == null) {
                b();
            }
        }
    }
}
