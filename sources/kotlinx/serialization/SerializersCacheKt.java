package kotlinx.serialization;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.CachingKt;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import kotlinx.serialization.internal.SerializerCache;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/* compiled from: SerializersCache.kt */
/* loaded from: classes5.dex */
public final class SerializersCacheKt {

    /* renamed from: a  reason: collision with root package name */
    private static final SerializerCache<? extends Object> f52072a = CachingKt.a(new Function1<KClass<?>, KSerializer<? extends Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$SERIALIZERS_CACHE$1
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final KSerializer<? extends Object> invoke(KClass<?> it) {
            Intrinsics.f(it, "it");
            return SerializersKt.d(it);
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private static final SerializerCache<Object> f52073b = CachingKt.a(new Function1<KClass<?>, KSerializer<Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final KSerializer<Object> invoke(KClass<?> it) {
            KSerializer<Object> t7;
            Intrinsics.f(it, "it");
            KSerializer d8 = SerializersKt.d(it);
            if (d8 == null || (t7 = BuiltinSerializersKt.t(d8)) == null) {
                return null;
            }
            return t7;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private static final ParametrizedSerializerCache<? extends Object> f52074c = CachingKt.b(new Function2<KClass<Object>, List<? extends KType>, KSerializer<? extends Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1
        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final KSerializer<? extends Object> s(KClass<Object> clazz, List<? extends KType> types) {
            Intrinsics.f(clazz, "clazz");
            Intrinsics.f(types, "types");
            List<KSerializer<Object>> f8 = SerializersKt.f(SerializersModuleBuildersKt.a(), types, true);
            Intrinsics.c(f8);
            return SerializersKt.a(clazz, types, f8);
        }
    });

    /* renamed from: d  reason: collision with root package name */
    private static final ParametrizedSerializerCache<Object> f52075d = CachingKt.b(new Function2<KClass<Object>, List<? extends KType>, KSerializer<Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1
        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final KSerializer<Object> s(KClass<Object> clazz, List<? extends KType> types) {
            KSerializer<Object> t7;
            Intrinsics.f(clazz, "clazz");
            Intrinsics.f(types, "types");
            List<KSerializer<Object>> f8 = SerializersKt.f(SerializersModuleBuildersKt.a(), types, true);
            Intrinsics.c(f8);
            KSerializer<? extends Object> a8 = SerializersKt.a(clazz, types, f8);
            if (a8 == null || (t7 = BuiltinSerializersKt.t(a8)) == null) {
                return null;
            }
            return t7;
        }
    });

    public static final KSerializer<Object> a(KClass<Object> clazz, boolean z7) {
        Intrinsics.f(clazz, "clazz");
        if (!z7) {
            KSerializer<? extends Object> a8 = f52072a.a(clazz);
            if (a8 == null) {
                return null;
            }
            return a8;
        }
        return f52073b.a(clazz);
    }

    public static final Object b(KClass<Object> clazz, List<? extends KType> types, boolean z7) {
        Intrinsics.f(clazz, "clazz");
        Intrinsics.f(types, "types");
        if (!z7) {
            return f52074c.a(clazz, types);
        }
        return f52075d.a(clazz, types);
    }
}
