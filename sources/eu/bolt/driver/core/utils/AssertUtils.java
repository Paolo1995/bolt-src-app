package eu.bolt.driver.core.utils;

import android.os.Looper;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssertUtils.kt */
/* loaded from: classes5.dex */
public final class AssertUtils {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f41322a;

    public static final void a(String message) {
        Intrinsics.f(message, "message");
        e(false, message);
    }

    public static /* synthetic */ void b(String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = "Illegal state";
        }
        a(str);
    }

    public static final void c(Object obj, String message) {
        boolean z7;
        Intrinsics.f(message, "message");
        if (obj != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        e(z7, message);
    }

    public static final void d(String message) {
        Intrinsics.f(message, "message");
        e(Intrinsics.a(Thread.currentThread().getName(), Looper.getMainLooper().getThread().getName()), message);
    }

    public static final void e(boolean z7, String message) {
        Intrinsics.f(message, "message");
        if (z7) {
            return;
        }
        RuntimeException runtimeException = new RuntimeException(message);
        if (!f41322a) {
            Kalev.e(runtimeException, "Assertion failed!");
            return;
        }
        throw runtimeException;
    }

    public static /* synthetic */ void f(boolean z7, String str, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str = "Assertion failed";
        }
        e(z7, str);
    }

    public static final void g(boolean z7) {
        f41322a = z7;
    }
}
