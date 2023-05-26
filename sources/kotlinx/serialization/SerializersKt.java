package kotlinx.serialization;

import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.modules.SerializersModule;

/* loaded from: classes5.dex */
public final class SerializersKt {
    public static final KSerializer<? extends Object> a(KClass<Object> kClass, List<? extends KType> list, List<? extends KSerializer<Object>> list2) {
        return SerializersKt__SerializersKt.d(kClass, list, list2);
    }

    public static final <T> KSerializer<T> b(KClass<T> kClass) {
        return SerializersKt__SerializersKt.e(kClass);
    }

    public static final KSerializer<Object> c(SerializersModule serializersModule, KType kType) {
        return SerializersKt__SerializersKt.f(serializersModule, kType);
    }

    public static final <T> KSerializer<T> d(KClass<T> kClass) {
        return SerializersKt__SerializersKt.h(kClass);
    }

    public static final KSerializer<Object> e(SerializersModule serializersModule, KType kType) {
        return SerializersKt__SerializersKt.i(serializersModule, kType);
    }

    public static final List<KSerializer<Object>> f(SerializersModule serializersModule, List<? extends KType> list, boolean z7) {
        return SerializersKt__SerializersKt.j(serializersModule, list, z7);
    }
}
