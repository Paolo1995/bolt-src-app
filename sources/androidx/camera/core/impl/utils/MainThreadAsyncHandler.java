package androidx.camera.core.impl.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.os.HandlerCompat;

/* loaded from: classes.dex */
public final class MainThreadAsyncHandler {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Handler f3818a;

    private MainThreadAsyncHandler() {
    }

    @NonNull
    public static Handler a() {
        if (f3818a != null) {
            return f3818a;
        }
        synchronized (MainThreadAsyncHandler.class) {
            if (f3818a == null) {
                f3818a = HandlerCompat.a(Looper.getMainLooper());
            }
        }
        return f3818a;
    }
}
