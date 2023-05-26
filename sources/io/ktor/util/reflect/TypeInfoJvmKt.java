package io.ktor.util.reflect;

import java.lang.reflect.Type;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: TypeInfoJvm.kt */
/* loaded from: classes5.dex */
public final class TypeInfoJvmKt {
    public static final boolean a(Object obj, KClass<?> type) {
        Intrinsics.f(obj, "<this>");
        Intrinsics.f(type, "type");
        return JvmClassMappingKt.a(type).isInstance(obj);
    }

    public static final TypeInfo b(Type reifiedType, KClass<?> kClass, KType kType) {
        Intrinsics.f(reifiedType, "reifiedType");
        Intrinsics.f(kClass, "kClass");
        return new TypeInfo(kClass, reifiedType, kType);
    }
}
