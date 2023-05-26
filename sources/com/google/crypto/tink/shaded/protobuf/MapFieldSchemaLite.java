package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import java.util.Map;

/* loaded from: classes.dex */
class MapFieldSchemaLite implements MapFieldSchema {
    private static <K, V> int i(int i8, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        MapEntryLite mapEntryLite = (MapEntryLite) obj2;
        int i9 = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry<K, V> entry : mapFieldLite.entrySet()) {
            i9 += mapEntryLite.a(i8, entry.getKey(), entry.getValue());
        }
        return i9;
    }

    private static <K, V> MapFieldLite<K, V> j(Object obj, Object obj2) {
        MapFieldLite<K, V> mapFieldLite = (MapFieldLite) obj;
        MapFieldLite<K, V> mapFieldLite2 = (MapFieldLite) obj2;
        if (!mapFieldLite2.isEmpty()) {
            if (!mapFieldLite.j()) {
                mapFieldLite = mapFieldLite.m();
            }
            mapFieldLite.l(mapFieldLite2);
        }
        return mapFieldLite;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public MapEntryLite.Metadata<?, ?> b(Object obj) {
        ((MapEntryLite) obj).c();
        return null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public Map<?, ?> c(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public Object d(Object obj) {
        return MapFieldLite.d().m();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public Map<?, ?> e(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public Object f(Object obj) {
        ((MapFieldLite) obj).k();
        return obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public int g(int i8, Object obj, Object obj2) {
        return i(i8, obj, obj2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public boolean h(Object obj) {
        return !((MapFieldLite) obj).j();
    }
}
