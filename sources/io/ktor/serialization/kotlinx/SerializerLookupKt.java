package io.ktor.serialization.kotlinx;

import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: SerializerLookup.kt */
/* loaded from: classes5.dex */
public final class SerializerLookupKt {
    private static final KSerializer<?> a(Collection<?> collection, SerializersModule serializersModule) {
        List<Object> T;
        int v7;
        Object u02;
        boolean z7;
        int v8;
        T = CollectionsKt___CollectionsKt.T(collection);
        v7 = CollectionsKt__IterablesKt.v(T, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Object obj : T) {
            arrayList.add(b(obj, serializersModule));
        }
        HashSet hashSet = new HashSet();
        ArrayList<KSerializer> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (hashSet.add(((KSerializer) obj2).a().i())) {
                arrayList2.add(obj2);
            }
        }
        boolean z8 = true;
        if (arrayList2.size() > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Serializing collections of different element types is not yet supported. Selected serializers: ");
            v8 = CollectionsKt__IterablesKt.v(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(v8);
            for (KSerializer kSerializer : arrayList2) {
                arrayList3.add(kSerializer.a().i());
            }
            sb.append(arrayList3);
            throw new IllegalStateException(sb.toString().toString());
        }
        u02 = CollectionsKt___CollectionsKt.u0(arrayList2);
        KSerializer<String> kSerializer2 = (KSerializer) u02;
        if (kSerializer2 == null) {
            kSerializer2 = BuiltinSerializersKt.H(StringCompanionObject.f51021a);
        }
        if (kSerializer2.a().b()) {
            return kSerializer2;
        }
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (z7) {
                    break;
                }
            }
        }
        z8 = false;
        if (z8) {
            return BuiltinSerializersKt.t(kSerializer2);
        }
        return kSerializer2;
    }

    public static final KSerializer<Object> b(Object obj, SerializersModule module) {
        Object G;
        KSerializer<Object> b8;
        Intrinsics.f(module, "module");
        if (obj == null) {
            return BuiltinSerializersKt.t(BuiltinSerializersKt.H(StringCompanionObject.f51021a));
        }
        if (obj instanceof List) {
            return BuiltinSerializersKt.h(a((Collection) obj, module));
        }
        if (obj instanceof Object[]) {
            G = ArraysKt___ArraysKt.G((Object[]) obj);
            if (G == null || (b8 = b(G, module)) == null) {
                return BuiltinSerializersKt.h(BuiltinSerializersKt.H(StringCompanionObject.f51021a));
            }
            return b8;
        } else if (obj instanceof Set) {
            return BuiltinSerializersKt.m(a((Collection) obj, module));
        } else {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                return BuiltinSerializersKt.k(a(map.keySet(), module), a(map.values(), module));
            }
            KSerializer<Object> c8 = SerializersModule.c(module, Reflection.b(obj.getClass()), null, 2, null);
            if (c8 == null) {
                return SerializersKt.b(Reflection.b(obj.getClass()));
            }
            return c8;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> KSerializer<?> c(KSerializer<T> kSerializer, TypeInfo typeInfo) {
        KType a8 = typeInfo.a();
        boolean z7 = true;
        if ((a8 == null || !a8.a()) ? false : false) {
            return BuiltinSerializersKt.t(kSerializer);
        }
        return kSerializer;
    }

    public static final KSerializer<?> d(TypeInfo typeInfo, SerializersModule module) {
        KSerializer<?> e8;
        Intrinsics.f(typeInfo, "typeInfo");
        Intrinsics.f(module, "module");
        KType a8 = typeInfo.a();
        if (a8 != null) {
            if (a8.d().isEmpty()) {
                e8 = null;
            } else {
                e8 = SerializersKt.e(module, a8);
            }
            if (e8 != null) {
                return e8;
            }
        }
        KSerializer c8 = SerializersModule.c(module, typeInfo.b(), null, 2, null);
        if (c8 != null) {
            return c(c8, typeInfo);
        }
        return c(SerializersKt.b(typeInfo.b()), typeInfo);
    }
}
