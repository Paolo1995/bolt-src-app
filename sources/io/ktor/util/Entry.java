package io.ktor.util;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: CaseInsensitiveMap.kt */
/* loaded from: classes5.dex */
final class Entry<Key, Value> implements Map.Entry<Key, Value>, KMappedMarker {

    /* renamed from: f  reason: collision with root package name */
    private final Key f47043f;

    /* renamed from: g  reason: collision with root package name */
    private Value f47044g;

    public Entry(Key key, Value value) {
        this.f47043f = key;
        this.f47044g = value;
    }

    public void a(Value value) {
        this.f47044g = value;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Intrinsics.a(entry.getKey(), getKey()) || !Intrinsics.a(entry.getValue(), getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public Key getKey() {
        return this.f47043f;
    }

    @Override // java.util.Map.Entry
    public Value getValue() {
        return this.f47044g;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        Key key = getKey();
        Intrinsics.c(key);
        Value value = getValue();
        Intrinsics.c(value);
        return key.hashCode() + 527 + value.hashCode();
    }

    @Override // java.util.Map.Entry
    public Value setValue(Value value) {
        a(value);
        return getValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
