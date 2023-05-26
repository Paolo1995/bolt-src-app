package io.ktor.client.utils;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionUtilsJvm.kt */
/* loaded from: classes5.dex */
public final class ExceptionUtilsJvmKt {
    public static final Throwable a(Throwable th) {
        Intrinsics.f(th, "<this>");
        Throwable th2 = th;
        while (th2 instanceof CancellationException) {
            CancellationException cancellationException = (CancellationException) th2;
            if (Intrinsics.a(th2, cancellationException.getCause())) {
                return th;
            }
            th2 = cancellationException.getCause();
        }
        if (th2 != null) {
            return th2;
        }
        return th;
    }
}
