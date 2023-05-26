package kotlinx.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Serializers.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class SerializersKt__SerializersKt {
    private static final KSerializer<? extends Object> a(KClass<Object> kClass, List<? extends KType> list, List<? extends KSerializer<Object>> list2) {
        boolean a8;
        boolean a9;
        boolean a10;
        boolean a11;
        boolean a12;
        boolean a13;
        boolean a14;
        if (Intrinsics.a(kClass, Reflection.b(Collection.class))) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(kClass, Reflection.b(List.class));
        }
        if (a8) {
            a9 = true;
        } else {
            a9 = Intrinsics.a(kClass, Reflection.b(List.class));
        }
        if (a9) {
            a10 = true;
        } else {
            a10 = Intrinsics.a(kClass, Reflection.b(ArrayList.class));
        }
        if (a10) {
            return new ArrayListSerializer(list2.get(0));
        }
        if (Intrinsics.a(kClass, Reflection.b(HashSet.class))) {
            return new HashSetSerializer(list2.get(0));
        }
        if (Intrinsics.a(kClass, Reflection.b(Set.class))) {
            a11 = true;
        } else {
            a11 = Intrinsics.a(kClass, Reflection.b(Set.class));
        }
        if (a11) {
            a12 = true;
        } else {
            a12 = Intrinsics.a(kClass, Reflection.b(LinkedHashSet.class));
        }
        if (a12) {
            return new LinkedHashSetSerializer(list2.get(0));
        }
        if (Intrinsics.a(kClass, Reflection.b(HashMap.class))) {
            return new HashMapSerializer(list2.get(0), list2.get(1));
        }
        if (Intrinsics.a(kClass, Reflection.b(Map.class))) {
            a13 = true;
        } else {
            a13 = Intrinsics.a(kClass, Reflection.b(Map.class));
        }
        if (a13) {
            a14 = true;
        } else {
            a14 = Intrinsics.a(kClass, Reflection.b(LinkedHashMap.class));
        }
        if (a14) {
            return new LinkedHashMapSerializer(list2.get(0), list2.get(1));
        }
        if (Intrinsics.a(kClass, Reflection.b(Map.Entry.class))) {
            return BuiltinSerializersKt.j(list2.get(0), list2.get(1));
        }
        if (Intrinsics.a(kClass, Reflection.b(Pair.class))) {
            return BuiltinSerializersKt.l(list2.get(0), list2.get(1));
        }
        if (Intrinsics.a(kClass, Reflection.b(Triple.class))) {
            return BuiltinSerializersKt.o(list2.get(0), list2.get(1), list2.get(2));
        }
        if (PlatformKt.l(kClass)) {
            KClassifier c8 = list.get(0).c();
            Intrinsics.d(c8, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            return BuiltinSerializersKt.a((KClass) c8, list2.get(0));
        }
        return null;
    }

    private static final KSerializer<? extends Object> b(KClass<Object> kClass, List<? extends KSerializer<Object>> list) {
        Object[] array = list.toArray(new KSerializer[0]);
        Intrinsics.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        KSerializer[] kSerializerArr = (KSerializer[]) array;
        return PlatformKt.d(kClass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    private static final <T> KSerializer<T> c(KSerializer<T> kSerializer, boolean z7) {
        if (z7) {
            return BuiltinSerializersKt.t(kSerializer);
        }
        Intrinsics.d(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return kSerializer;
    }

    public static final KSerializer<? extends Object> d(KClass<Object> kClass, List<? extends KType> types, List<? extends KSerializer<Object>> serializers) {
        Intrinsics.f(kClass, "<this>");
        Intrinsics.f(types, "types");
        Intrinsics.f(serializers, "serializers");
        KSerializer<? extends Object> a8 = a(kClass, types, serializers);
        if (a8 == null) {
            return b(kClass, serializers);
        }
        return a8;
    }

    public static final <T> KSerializer<T> e(KClass<T> kClass) {
        Intrinsics.f(kClass, "<this>");
        KSerializer<T> d8 = SerializersKt.d(kClass);
        if (d8 != null) {
            return d8;
        }
        Platform_commonKt.d(kClass);
        throw new KotlinNothingValueException();
    }

    public static final KSerializer<Object> f(SerializersModule serializersModule, KType type) {
        Intrinsics.f(serializersModule, "<this>");
        Intrinsics.f(type, "type");
        KSerializer<Object> g8 = g(serializersModule, type, true);
        if (g8 != null) {
            return g8;
        }
        PlatformKt.m(Platform_commonKt.c(type));
        throw new KotlinNothingValueException();
    }

    private static final KSerializer<Object> g(SerializersModule serializersModule, KType kType, boolean z7) {
        int v7;
        KSerializer<Object> kSerializer;
        KSerializer<? extends Object> kSerializer2;
        KClass<Object> c8 = Platform_commonKt.c(kType);
        boolean a8 = kType.a();
        List<KTypeProjection> d8 = kType.d();
        v7 = CollectionsKt__IterablesKt.v(d8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (KTypeProjection kTypeProjection : d8) {
            KType c9 = kTypeProjection.c();
            if (c9 != null) {
                arrayList.add(c9);
            } else {
                throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + kType).toString());
            }
        }
        if (arrayList.isEmpty()) {
            kSerializer = SerializersCacheKt.a(c8, a8);
        } else {
            Object b8 = SerializersCacheKt.b(c8, arrayList, a8);
            if (z7) {
                if (Result.g(b8)) {
                    b8 = null;
                }
                kSerializer = (KSerializer) b8;
            } else if (Result.e(b8) != null) {
                return null;
            } else {
                kSerializer = (KSerializer) b8;
            }
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        if (arrayList.isEmpty()) {
            kSerializer2 = SerializersModule.c(serializersModule, c8, null, 2, null);
        } else {
            List<KSerializer<Object>> f8 = SerializersKt.f(serializersModule, arrayList, z7);
            if (f8 == null) {
                return null;
            }
            KSerializer<? extends Object> a9 = SerializersKt.a(c8, arrayList, f8);
            if (a9 == null) {
                kSerializer2 = serializersModule.b(c8, f8);
            } else {
                kSerializer2 = a9;
            }
        }
        if (kSerializer2 == null) {
            return null;
        }
        return c(kSerializer2, a8);
    }

    public static final <T> KSerializer<T> h(KClass<T> kClass) {
        Intrinsics.f(kClass, "<this>");
        KSerializer<T> b8 = PlatformKt.b(kClass);
        if (b8 == null) {
            return PrimitivesKt.b(kClass);
        }
        return b8;
    }

    public static final KSerializer<Object> i(SerializersModule serializersModule, KType type) {
        Intrinsics.f(serializersModule, "<this>");
        Intrinsics.f(type, "type");
        return g(serializersModule, type, false);
    }

    public static final List<KSerializer<Object>> j(SerializersModule serializersModule, List<? extends KType> typeArguments, boolean z7) {
        ArrayList arrayList;
        int v7;
        int v8;
        Intrinsics.f(serializersModule, "<this>");
        Intrinsics.f(typeArguments, "typeArguments");
        if (z7) {
            v8 = CollectionsKt__IterablesKt.v(typeArguments, 10);
            arrayList = new ArrayList(v8);
            for (KType kType : typeArguments) {
                arrayList.add(SerializersKt.c(serializersModule, kType));
            }
        } else {
            v7 = CollectionsKt__IterablesKt.v(typeArguments, 10);
            arrayList = new ArrayList(v7);
            for (KType kType2 : typeArguments) {
                KSerializer<Object> e8 = SerializersKt.e(serializersModule, kType2);
                if (e8 == null) {
                    return null;
                }
                arrayList.add(e8);
            }
        }
        return arrayList;
    }
}
