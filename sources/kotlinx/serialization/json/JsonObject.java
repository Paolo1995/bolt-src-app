package kotlinx.serialization.json;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.internal.StringOpsKt;

/* compiled from: JsonElement.kt */
@Serializable(with = JsonObjectSerializer.class)
/* loaded from: classes5.dex */
public final class JsonObject extends JsonElement implements Map<String, JsonElement>, KMappedMarker, j$.util.Map {
    public static final Companion Companion = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, JsonElement> f52355f;

    /* compiled from: JsonElement.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<JsonObject> serializer() {
            return JsonObjectSerializer.f52357a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JsonObject(Map<String, ? extends JsonElement> content) {
        super(null);
        Intrinsics.f(content, "content");
        this.f52355f = content;
    }

    public boolean b(String key) {
        Intrinsics.f(key, "key");
        return this.f52355f.containsKey(key);
    }

    @Override // java.util.Map, j$.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Map
    public /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.serialization.json.JsonElement, java.lang.Object] */
    @Override // java.util.Map
    public /* synthetic */ JsonElement compute(String str, java.util.function.BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        return compute(str, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // j$.util.Map
    public /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.serialization.json.JsonElement, java.lang.Object] */
    @Override // java.util.Map
    public /* synthetic */ JsonElement computeIfAbsent(String str, java.util.function.Function<? super String, ? extends JsonElement> function) {
        return computeIfAbsent(str, Function.VivifiedWrapper.convert(function));
    }

    @Override // j$.util.Map
    public /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.serialization.json.JsonElement, java.lang.Object] */
    @Override // java.util.Map
    public /* synthetic */ JsonElement computeIfPresent(String str, java.util.function.BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        return computeIfPresent(str, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return b((String) obj);
    }

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return false;
        }
        return d((JsonElement) obj);
    }

    public boolean d(JsonElement value) {
        Intrinsics.f(value, "value");
        return this.f52355f.containsValue(value);
    }

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ Set<Map.Entry<String, JsonElement>> entrySet() {
        return i();
    }

    @Override // java.util.Map, j$.util.Map
    public boolean equals(Object obj) {
        return Intrinsics.a(this.f52355f, obj);
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map
    public /* synthetic */ void forEach(java.util.function.BiConsumer<? super String, ? super JsonElement> biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    public JsonElement g(String key) {
        Intrinsics.f(key, "key");
        return this.f52355f.get(key);
    }

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return g((String) obj);
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public int hashCode() {
        return this.f52355f.hashCode();
    }

    public Set<Map.Entry<String, JsonElement>> i() {
        return this.f52355f.entrySet();
    }

    @Override // java.util.Map, j$.util.Map
    public boolean isEmpty() {
        return this.f52355f.isEmpty();
    }

    public Set<String> k() {
        return this.f52355f.keySet();
    }

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ Set<String> keySet() {
        return k();
    }

    public int m() {
        return this.f52355f.size();
    }

    @Override // j$.util.Map
    public /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.serialization.json.JsonElement, java.lang.Object] */
    @Override // java.util.Map
    public /* synthetic */ JsonElement merge(String str, JsonElement jsonElement, java.util.function.BiFunction<? super JsonElement, ? super JsonElement, ? extends JsonElement> biFunction) {
        return merge(str, jsonElement, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public Collection<JsonElement> n() {
        return this.f52355f.values();
    }

    @Override // java.util.Map, j$.util.Map
    /* renamed from: o */
    public JsonElement remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map, j$.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map, j$.util.Map
    public void putAll(java.util.Map<? extends String, ? extends JsonElement> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Map
    public void replaceAll(BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ void replaceAll(java.util.function.BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ int size() {
        return m();
    }

    public String toString() {
        String f02;
        f02 = CollectionsKt___CollectionsKt.f0(this.f52355f.entrySet(), ",", "{", "}", 0, null, new Function1<Map.Entry<? extends String, ? extends JsonElement>, CharSequence>() { // from class: kotlinx.serialization.json.JsonObject$toString$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CharSequence invoke(Map.Entry<String, ? extends JsonElement> entry) {
                Intrinsics.f(entry, "<name for destructuring parameter 0>");
                StringBuilder sb = new StringBuilder();
                StringOpsKt.c(sb, entry.getKey());
                sb.append(':');
                sb.append(entry.getValue());
                String sb2 = sb.toString();
                Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
        }, 24, null);
        return f02;
    }

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ Collection<JsonElement> values() {
        return n();
    }
}
