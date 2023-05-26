package androidx.core.os;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class ExecutorCompat {

    /* loaded from: classes.dex */
    private static class HandlerExecutor implements Executor {

        /* renamed from: f  reason: collision with root package name */
        private final Handler f5801f;

        HandlerExecutor(@NonNull Handler handler) {
            this.f5801f = (Handler) Preconditions.g(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (this.f5801f.post((Runnable) Preconditions.g(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f5801f + " is shutting down");
        }
    }

    private ExecutorCompat() {
    }

    @NonNull
    public static Executor a(@NonNull Handler handler) {
        return new HandlerExecutor(handler);
    }
}
