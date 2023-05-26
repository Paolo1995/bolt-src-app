package eu.bolt.driver.core.util;

import android.os.Looper;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssertUtils.kt */
/* loaded from: classes5.dex */
public final class AssertUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final AssertUtils f41299a = new AssertUtils();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f41300b;

    private AssertUtils() {
    }

    public static /* synthetic */ void b(AssertUtils assertUtils, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = "Illegal state";
        }
        assertUtils.a(str);
    }

    public static /* synthetic */ void e(AssertUtils assertUtils, boolean z7, String str, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str = "Assertion failed";
        }
        assertUtils.d(z7, str);
    }

    public final void a(String message) {
        Intrinsics.f(message, "message");
        d(false, message);
    }

    public final void c(String message) {
        Intrinsics.f(message, "message");
        d(Intrinsics.a(Thread.currentThread().getName(), Looper.getMainLooper().getThread().getName()), message);
    }

    public final void d(boolean z7, String message) {
        Intrinsics.f(message, "message");
        if (z7) {
            return;
        }
        AssertionError assertionError = new AssertionError(message);
        if (!f41300b) {
            Kalev.e(assertionError, "Assertion failed!");
            return;
        }
        throw assertionError;
    }
}
