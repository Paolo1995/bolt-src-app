package org.koin.core.component;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;

/* compiled from: KoinScopeComponent.kt */
/* loaded from: classes5.dex */
public final class KoinScopeComponentKt {
    public static final <T extends KoinScopeComponent> Scope a(T t7, Object obj) {
        Intrinsics.f(t7, "<this>");
        return t7.e().b(c(t7), d(t7), obj);
    }

    public static /* synthetic */ Scope b(KoinScopeComponent koinScopeComponent, Object obj, int i8, Object obj2) {
        if ((i8 & 1) != 0) {
            obj = null;
        }
        return a(koinScopeComponent, obj);
    }

    public static final <T> String c(T t7) {
        Intrinsics.f(t7, "<this>");
        return KClassExtKt.a(Reflection.b(t7.getClass())) + '@' + t7.hashCode();
    }

    public static final <T> TypeQualifier d(T t7) {
        Intrinsics.f(t7, "<this>");
        return new TypeQualifier(Reflection.b(t7.getClass()));
    }
}
