package io.ktor.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: CaseInsensitiveMap.kt */
/* loaded from: classes5.dex */
public final class CaseInsensitiveMap<Value> implements Map<String, Value>, KMutableMap {

    /* renamed from: f  reason: collision with root package name */
    private final Map<CaseInsensitiveString, Value> f47029f = new LinkedHashMap();

    public boolean a(String key) {
        Intrinsics.f(key, "key");
        return this.f47029f.containsKey(new CaseInsensitiveString(key));
    }

    public Value b(String key) {
        Intrinsics.f(key, "key");
        return this.f47029f.get(TextKt.a(key));
    }

    public Set<Map.Entry<String, Value>> c() {
        return new DelegatingMutableSet(this.f47029f.entrySet(), new Function1<Map.Entry<CaseInsensitiveString, Value>, Map.Entry<String, Value>>() { // from class: io.ktor.util.CaseInsensitiveMap$entries$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Map.Entry<String, Value> invoke(Map.Entry<CaseInsensitiveString, Value> $receiver) {
                Intrinsics.f($receiver, "$this$$receiver");
                return new Entry($receiver.getKey().a(), $receiver.getValue());
            }
        }, new Function1<Map.Entry<String, Value>, Map.Entry<CaseInsensitiveString, Value>>() { // from class: io.ktor.util.CaseInsensitiveMap$entries$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Map.Entry<CaseInsensitiveString, Value> invoke(Map.Entry<String, Value> $receiver) {
                Intrinsics.f($receiver, "$this$$receiver");
                return new Entry(TextKt.a($receiver.getKey()), $receiver.getValue());
            }
        });
    }

    @Override // java.util.Map
    public void clear() {
        this.f47029f.clear();
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return a((String) obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f47029f.containsValue(obj);
    }

    public Set<String> d() {
        return new DelegatingMutableSet(this.f47029f.keySet(), new Function1<CaseInsensitiveString, String>() { // from class: io.ktor.util.CaseInsensitiveMap$keys$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(CaseInsensitiveString $receiver) {
                Intrinsics.f($receiver, "$this$$receiver");
                return $receiver.a();
            }
        }, new Function1<String, CaseInsensitiveString>() { // from class: io.ktor.util.CaseInsensitiveMap$keys$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CaseInsensitiveString invoke(String $receiver) {
                Intrinsics.f($receiver, "$this$$receiver");
                return TextKt.a($receiver);
            }
        });
    }

    public int e() {
        return this.f47029f.size();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Value>> entrySet() {
        return c();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof CaseInsensitiveMap)) {
            return Intrinsics.a(((CaseInsensitiveMap) obj).f47029f, this.f47029f);
        }
        return false;
    }

    public Collection<Value> g() {
        return this.f47029f.values();
    }

    @Override // java.util.Map
    public final /* bridge */ Value get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return b((String) obj);
    }

    @Override // java.util.Map
    /* renamed from: h */
    public Value put(String key, Value value) {
        Intrinsics.f(key, "key");
        Intrinsics.f(value, "value");
        return this.f47029f.put(TextKt.a(key), value);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f47029f.hashCode();
    }

    public Value i(String key) {
        Intrinsics.f(key, "key");
        return this.f47029f.remove(TextKt.a(key));
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f47029f.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return d();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Value> from) {
        Intrinsics.f(from, "from");
        for (Map.Entry<? extends String, ? extends Value> entry : from.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Value remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return i((String) obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return e();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Value> values() {
        return g();
    }
}
