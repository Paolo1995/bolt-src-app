package eu.bolt.android.engine.html.util;

import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UtilsExtenisons.kt */
/* loaded from: classes5.dex */
public final class UtilsExtenisonsKt {
    public static final void a() {
        if (Intrinsics.a(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return;
        }
        throw new IllegalStateException("allow call only on main thread");
    }

    public static final long b(long j8) {
        return (((j8 + 1000) / 1000) * 1000) - j8;
    }
}
