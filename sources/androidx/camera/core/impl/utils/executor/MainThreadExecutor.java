package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MainThreadExecutor {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ScheduledExecutorService f3841a;

    private MainThreadExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ScheduledExecutorService a() {
        if (f3841a != null) {
            return f3841a;
        }
        synchronized (MainThreadExecutor.class) {
            if (f3841a == null) {
                f3841a = new HandlerScheduledExecutorService(new Handler(Looper.getMainLooper()));
            }
        }
        return f3841a;
    }
}
