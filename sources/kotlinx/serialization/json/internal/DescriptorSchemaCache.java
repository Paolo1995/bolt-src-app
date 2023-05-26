package kotlinx.serialization.json.internal;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: SchemaCache.kt */
/* loaded from: classes5.dex */
public final class DescriptorSchemaCache {

    /* renamed from: a  reason: collision with root package name */
    private final Map<SerialDescriptor, Map<Key<Object>, Object>> f52383a = CreateMapForCacheKt.a(1);

    /* compiled from: SchemaCache.kt */
    /* loaded from: classes5.dex */
    public static final class Key<T> {
    }

    public final <T> T a(SerialDescriptor descriptor, Key<T> key) {
        Object obj;
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(key, "key");
        Map<Key<Object>, Object> map = this.f52383a.get(descriptor);
        if (map != null) {
            obj = map.get(key);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return (T) obj;
    }

    public final <T> T b(SerialDescriptor descriptor, Key<T> key, Function0<? extends T> defaultValue) {
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(key, "key");
        Intrinsics.f(defaultValue, "defaultValue");
        T t7 = (T) a(descriptor, key);
        if (t7 != null) {
            return t7;
        }
        T invoke = defaultValue.invoke();
        c(descriptor, key, invoke);
        return invoke;
    }

    public final <T> void c(SerialDescriptor descriptor, Key<T> key, T value) {
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(key, "key");
        Intrinsics.f(value, "value");
        Map<SerialDescriptor, Map<Key<Object>, Object>> map = this.f52383a;
        Map<Key<Object>, Object> map2 = map.get(descriptor);
        if (map2 == null) {
            map2 = CreateMapForCacheKt.a(1);
            map.put(descriptor, map2);
        }
        map2.put(key, value);
    }
}
