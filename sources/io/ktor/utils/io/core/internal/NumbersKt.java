package io.ktor.utils.io.core.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Numbers.kt */
/* loaded from: classes5.dex */
public final class NumbersKt {
    public static final Void a(long j8, String name) {
        Intrinsics.f(name, "name");
        throw new IllegalArgumentException("Long value " + j8 + " of " + name + " doesn't fit into 32-bit integer");
    }
}
