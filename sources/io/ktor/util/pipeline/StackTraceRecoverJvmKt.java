package io.ktor.util.pipeline;

import io.ktor.utils.io.ExceptionUtilsJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StackTraceRecoverJvm.kt */
/* loaded from: classes5.dex */
public final class StackTraceRecoverJvmKt {
    public static final Throwable a(Throwable th, Throwable th2) {
        Intrinsics.f(th, "<this>");
        if (th2 != null && !Intrinsics.a(th.getCause(), th2)) {
            Throwable e8 = ExceptionUtilsJvmKt.e(th, th2);
            if (e8 == null) {
                return th;
            }
            e8.setStackTrace(th.getStackTrace());
            return e8;
        }
        return th;
    }
}
