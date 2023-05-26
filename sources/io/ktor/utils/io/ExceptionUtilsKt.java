package io.ktor.utils.io;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionUtils.kt */
/* loaded from: classes5.dex */
public final class ExceptionUtilsKt {
    public static final Throwable a(Throwable th) {
        Intrinsics.f(th, "<this>");
        Throwable th2 = th;
        while (th2 instanceof CancellationException) {
            if (Intrinsics.a(th2, th2.getCause())) {
                return th;
            }
            Throwable cause = th2.getCause();
            if (cause == null) {
                return th2;
            }
            th2 = cause;
        }
        return th2;
    }
}
