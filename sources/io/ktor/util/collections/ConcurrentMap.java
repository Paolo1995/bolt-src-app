package io.ktor.util.collections;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap$EL;
import j$.util.function.Function;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: ConcurrentMapJvm.kt */
/* loaded from: classes5.dex */
public final class ConcurrentMap<Key, Value> implements Map<Key, Value>, KMutableMap {

    /* renamed from: f  reason: collision with root package name */
    private final ConcurrentHashMap<Key, Value> f47060f;

    public ConcurrentMap() {
        this(0, 1, null);
    }

    public ConcurrentMap(int i8) {
        this.f47060f = new ConcurrentHashMap<>(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object c(Function0 block, Object obj) {
        Intrinsics.f(block, "$block");
        return block.invoke();
    }

    public final Value b(Key key, final Function0<? extends Value> block) {
        Intrinsics.f(block, "block");
        return (Value) ConcurrentMap$EL.computeIfAbsent(this.f47060f, key, new Function() { // from class: io.ktor.util.collections.a
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                Object c8;
                c8 = ConcurrentMap.c(Function0.this, obj);
                return c8;
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        });
    }

    @Override // java.util.Map
    public void clear() {
        this.f47060f.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f47060f.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f47060f.containsValue(obj);
    }

    public Set<Map.Entry<Key, Value>> d() {
        Set<Map.Entry<Key, Value>> entrySet = this.f47060f.entrySet();
        Intrinsics.e(entrySet, "delegate.entries");
        return entrySet;
    }

    public Set<Key> e() {
        Set<Key> keySet = this.f47060f.keySet();
        Intrinsics.e(keySet, "delegate.keys");
        return keySet;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<Key, Value>> entrySet() {
        return d();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        return Intrinsics.a(obj, this.f47060f);
    }

    public int g() {
        return this.f47060f.size();
    }

    @Override // java.util.Map
    public Value get(Object obj) {
        return this.f47060f.get(obj);
    }

    public Collection<Value> h() {
        Collection<Value> values = this.f47060f.values();
        Intrinsics.e(values, "delegate.values");
        return values;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f47060f.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f47060f.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Key> keySet() {
        return e();
    }

    @Override // java.util.Map
    public Value put(Key key, Value value) {
        return this.f47060f.put(key, value);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Key, ? extends Value> from) {
        Intrinsics.f(from, "from");
        this.f47060f.putAll(from);
    }

    @Override // java.util.Map
    public Value remove(Object obj) {
        return this.f47060f.remove(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return g();
    }

    public String toString() {
        return "ConcurrentMapJvm by " + this.f47060f;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Value> values() {
        return h();
    }

    public /* synthetic */ ConcurrentMap(int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? 32 : i8);
    }
}
