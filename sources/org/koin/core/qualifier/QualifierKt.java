package org.koin.core.qualifier;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Qualifier.kt */
/* loaded from: classes5.dex */
public final class QualifierKt {
    public static final StringQualifier a(String name) {
        Intrinsics.f(name, "name");
        return new StringQualifier(name);
    }

    public static final <E extends Enum<E>> Qualifier b(Enum<E> r22) {
        Intrinsics.f(r22, "<this>");
        String lowerCase = r22.toString().toLowerCase();
        Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase()");
        return new StringQualifier(lowerCase);
    }

    public static final <E extends Enum<E>> Qualifier c(Enum<E> r12) {
        Intrinsics.f(r12, "enum");
        return b(r12);
    }
}
