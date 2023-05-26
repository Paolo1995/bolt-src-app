package org.koin.core.definition;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.qualifier.Qualifier;
import org.koin.ext.KClassExtKt;

/* compiled from: BeanDefinition.kt */
/* loaded from: classes5.dex */
public final class BeanDefinitionKt {
    public static final String a(KClass<?> clazz, Qualifier qualifier, Qualifier scopeQualifier) {
        Intrinsics.f(clazz, "clazz");
        Intrinsics.f(scopeQualifier, "scopeQualifier");
        String str = (qualifier == null || (str = qualifier.getValue()) == null) ? "" : "";
        return KClassExtKt.a(clazz) + ':' + str + ':' + scopeQualifier;
    }
}
