package androidx.camera.core.impl.utils.executor;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class DirectExecutor implements Executor {

    /* renamed from: f  reason: collision with root package name */
    private static volatile DirectExecutor f3821f;

    DirectExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a() {
        if (f3821f != null) {
            return f3821f;
        }
        synchronized (DirectExecutor.class) {
            if (f3821f == null) {
                f3821f = new DirectExecutor();
            }
        }
        return f3821f;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
