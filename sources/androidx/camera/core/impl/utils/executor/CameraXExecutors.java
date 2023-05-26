package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class CameraXExecutors {
    private CameraXExecutors() {
    }

    @NonNull
    public static Executor a() {
        return DirectExecutor.a();
    }

    @NonNull
    public static Executor b() {
        return HighPriorityExecutor.a();
    }

    @NonNull
    public static Executor c() {
        return IoExecutor.a();
    }

    @NonNull
    public static ScheduledExecutorService d() {
        return MainThreadExecutor.a();
    }

    @NonNull
    public static ScheduledExecutorService e(@NonNull Handler handler) {
        return new HandlerScheduledExecutorService(handler);
    }

    @NonNull
    public static Executor f(@NonNull Executor executor) {
        return new SequentialExecutor(executor);
    }
}
