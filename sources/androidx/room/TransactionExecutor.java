package androidx.room;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class TransactionExecutor implements Executor {

    /* renamed from: f  reason: collision with root package name */
    private final Executor f7631f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayDeque<Runnable> f7632g = new ArrayDeque<>();

    /* renamed from: h  reason: collision with root package name */
    private Runnable f7633h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransactionExecutor(@NonNull Executor executor) {
        this.f7631f = executor;
    }

    synchronized void a() {
        Runnable poll = this.f7632g.poll();
        this.f7633h = poll;
        if (poll != null) {
            this.f7631f.execute(poll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.f7632g.offer(new Runnable() { // from class: androidx.room.TransactionExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    TransactionExecutor.this.a();
                }
            }
        });
        if (this.f7633h == null) {
            a();
        }
    }
}
