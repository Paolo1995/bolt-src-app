package androidx.tracing;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class Trace {

    /* renamed from: a  reason: collision with root package name */
    private static long f7779a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f7780b;

    private Trace() {
    }

    public static void a(@NonNull String str) {
        TraceApi18Impl.a(str);
    }

    public static void b() {
        TraceApi18Impl.b();
    }

    private static void c(@NonNull String str, @NonNull Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    @SuppressLint({"NewApi"})
    public static boolean d() {
        boolean isEnabled;
        try {
            if (f7780b == null) {
                isEnabled = android.os.Trace.isEnabled();
                return isEnabled;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    private static boolean e() {
        try {
            if (f7780b == null) {
                f7779a = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f7780b = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f7780b.invoke(null, Long.valueOf(f7779a))).booleanValue();
        } catch (Exception e8) {
            c("isTagEnabled", e8);
            return false;
        }
    }
}
