package io.ktor.util.date;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Date.kt */
/* loaded from: classes5.dex */
public final class DateKt {
    public static final GMTDate a(GMTDate gMTDate, long j8) {
        Intrinsics.f(gMTDate, "<this>");
        return DateJvmKt.b(Long.valueOf(gMTDate.c() + j8));
    }
}
