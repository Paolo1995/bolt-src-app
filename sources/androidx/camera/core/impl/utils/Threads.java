package androidx.camera.core.impl.utils;

import android.os.Looper;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class Threads {
    private Threads() {
    }

    public static void a() {
        Preconditions.j(b(), "Not in application's main thread");
    }

    public static boolean b() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }
}
