package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes.dex */
public final class TraceCompat {

    /* renamed from: a  reason: collision with root package name */
    private static long f5812a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f5813b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f5814c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f5815d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f5816e;

    /* loaded from: classes.dex */
    static class Api18Impl {
        private Api18Impl() {
        }

        static void a(String str) {
            Trace.beginSection(str);
        }

        static void b() {
            Trace.endSection();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f5812a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f5813b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f5814c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f5815d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f5816e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e8) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e8);
            }
        }
    }

    private TraceCompat() {
    }

    public static void a(@NonNull String str) {
        Api18Impl.a(str);
    }

    public static void b() {
        Api18Impl.b();
    }
}
