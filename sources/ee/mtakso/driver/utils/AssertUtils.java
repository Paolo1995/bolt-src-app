package ee.mtakso.driver.utils;

import android.os.Looper;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssertUtils.kt */
/* loaded from: classes5.dex */
public final class AssertUtils {
    public static final void a(String message) {
        Intrinsics.f(message, "message");
        f(false, message);
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
        f(z7, message);
    }

    public static /* synthetic */ void d(Object obj, String str, int i8, Object obj2) {
        if ((i8 & 2) != 0) {
            str = "Expected not null, but was null";
        }
        c(obj, str);
    }

    public static final void e(String message) {
        Intrinsics.f(message, "message");
        f(!Intrinsics.a(Thread.currentThread().getName(), Looper.getMainLooper().getThread().getName()), message);
    }

    public static final void f(boolean z7, String message) {
        Intrinsics.f(message, "message");
        if (z7) {
            return;
        }
        Kalev.e(new RuntimeException(message), "Assertion failed!");
    }

    public static /* synthetic */ void g(boolean z7, String str, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str = "Assertion failed";
        }
        f(z7, str);
    }
}
