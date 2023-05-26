package androidx.tracing;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
final class TraceApi18Impl {
    private TraceApi18Impl() {
    }

    public static void a(@NonNull String str) {
        android.os.Trace.beginSection(str);
    }

    public static void b() {
        android.os.Trace.endSection();
    }
}
