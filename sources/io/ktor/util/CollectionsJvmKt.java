package io.ktor.util;

import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CollectionsJvm.kt */
/* loaded from: classes5.dex */
public final class CollectionsJvmKt {
    public static final <T> Set<T> a(Set<? extends T> set) {
        Intrinsics.f(set, "<this>");
        Set<T> unmodifiableSet = Collections.unmodifiableSet(set);
        Intrinsics.e(unmodifiableSet, "unmodifiableSet(this)");
        return unmodifiableSet;
    }
}
