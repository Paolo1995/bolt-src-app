package io.ktor.util.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionUtilsJvm.kt */
/* loaded from: classes5.dex */
public final class ExceptionUtilsJvmKt {
    public static final void a(Throwable th, Throwable cause) {
        Intrinsics.f(th, "<this>");
        Intrinsics.f(cause, "cause");
        th.initCause(cause);
    }
}
