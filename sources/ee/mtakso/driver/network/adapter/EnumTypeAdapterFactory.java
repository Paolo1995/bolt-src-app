package ee.mtakso.driver.network.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnumTypeAdapterFactory.kt */
/* loaded from: classes3.dex */
public final class EnumTypeAdapterFactory implements TypeAdapterFactory {
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
        r4 = kotlin.collections.ArraysKt___ArraysJvmKt.e(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<java.lang.Enum<?>> a(java.lang.Class<?> r4) {
        /*
            r3 = this;
            java.lang.Object[] r4 = r4.getEnumConstants()
            if (r4 == 0) goto L30
            java.util.List r4 = kotlin.collections.ArraysKt.e(r4)
            if (r4 == 0) goto L30
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.v(r4, r1)
            r0.<init>(r1)
            java.util.Iterator r4 = r4.iterator()
        L1b:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L34
            java.lang.Object r1 = r4.next()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Enum<*>"
            kotlin.jvm.internal.Intrinsics.d(r1, r2)
            java.lang.Enum r1 = (java.lang.Enum) r1
            r0.add(r1)
            goto L1b
        L30:
            java.util.List r0 = kotlin.collections.CollectionsKt.k()
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.network.adapter.EnumTypeAdapterFactory.a(java.lang.Class):java.util.List");
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        boolean z7;
        Intrinsics.f(gson, "gson");
        Intrinsics.f(type, "type");
        Class<? super T> rawType = type.getRawType();
        Enum r02 = null;
        if (!Enum.class.isAssignableFrom(rawType)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Intrinsics.e(rawType, "rawType");
        Iterator<T> it = a(rawType).iterator();
        while (it.hasNext()) {
            Enum r22 = (Enum) it.next();
            String name = r22.name();
            Field field = rawType.getField(name);
            SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
            if (serializedName != null) {
                hashMap.put(serializedName.value(), r22);
            } else {
                hashMap.put(name, r22);
            }
            if (((DefaultEnumValue) field.getAnnotation(DefaultEnumValue.class)) != null) {
                if (r02 == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    r02 = r22;
                } else {
                    throw new IllegalStateException("Class can't contains more then 1 default value".toString());
                }
            }
        }
        return new EnumTypeAdapter(hashMap, r02);
    }
}
