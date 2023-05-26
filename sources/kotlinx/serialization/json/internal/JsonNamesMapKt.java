package kotlinx.serialization.json.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

/* compiled from: JsonNamesMap.kt */
/* loaded from: classes5.dex */
public final class JsonNamesMapKt {

    /* renamed from: a  reason: collision with root package name */
    private static final DescriptorSchemaCache.Key<Map<String, Integer>> f52388a = new DescriptorSchemaCache.Key<>();

    public static final Map<String, Integer> a(SerialDescriptor serialDescriptor) {
        Map<String, Integer> f8;
        Object u02;
        String[] names;
        Intrinsics.f(serialDescriptor, "<this>");
        int e8 = serialDescriptor.e();
        Map<String, Integer> map = null;
        for (int i8 = 0; i8 < e8; i8++) {
            List<Annotation> g8 = serialDescriptor.g(i8);
            ArrayList arrayList = new ArrayList();
            for (Object obj : g8) {
                if (obj instanceof JsonNames) {
                    arrayList.add(obj);
                }
            }
            u02 = CollectionsKt___CollectionsKt.u0(arrayList);
            JsonNames jsonNames = (JsonNames) u02;
            if (jsonNames != null && (names = jsonNames.names()) != null) {
                for (String str : names) {
                    if (map == null) {
                        map = CreateMapForCacheKt.a(serialDescriptor.e());
                    }
                    Intrinsics.c(map);
                    b(map, serialDescriptor, str, i8);
                }
            }
        }
        if (map == null) {
            f8 = MapsKt__MapsKt.f();
            return f8;
        }
        return map;
    }

    private static final void b(Map<String, Integer> map, SerialDescriptor serialDescriptor, String str, int i8) {
        Object g8;
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i8));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The suggested name '");
        sb.append(str);
        sb.append("' for property ");
        sb.append(serialDescriptor.f(i8));
        sb.append(" is already one of the names for property ");
        g8 = MapsKt__MapsKt.g(map, str);
        sb.append(serialDescriptor.f(((Number) g8).intValue()));
        sb.append(" in ");
        sb.append(serialDescriptor);
        throw new JsonException(sb.toString());
    }

    public static final DescriptorSchemaCache.Key<Map<String, Integer>> c() {
        return f52388a;
    }

    public static final int d(SerialDescriptor serialDescriptor, Json json, String name) {
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(json, "json");
        Intrinsics.f(name, "name");
        int c8 = serialDescriptor.c(name);
        if (c8 != -3) {
            return c8;
        }
        if (!json.g().j()) {
            return c8;
        }
        Integer num = (Integer) ((Map) JsonSchemaCacheKt.a(json).b(serialDescriptor, f52388a, new JsonNamesMapKt$getJsonNameIndex$alternativeNamesMap$1(serialDescriptor))).get(name);
        if (num == null) {
            return -3;
        }
        return num.intValue();
    }

    public static final int e(SerialDescriptor serialDescriptor, Json json, String name, String suffix) {
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(json, "json");
        Intrinsics.f(name, "name");
        Intrinsics.f(suffix, "suffix");
        int d8 = d(serialDescriptor, json, name);
        if (d8 != -3) {
            return d8;
        }
        throw new SerializationException(serialDescriptor.i() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static /* synthetic */ int f(SerialDescriptor serialDescriptor, Json json, String str, String str2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str2 = "";
        }
        return e(serialDescriptor, json, str, str2);
    }
}
