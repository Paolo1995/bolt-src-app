package j$.util.concurrent;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    final Object f50219a;

    /* renamed from: b  reason: collision with root package name */
    Object f50220b;

    /* renamed from: c  reason: collision with root package name */
    final ConcurrentHashMap f50221c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
        this.f50219a = obj;
        this.f50220b = obj2;
        this.f50221c = concurrentHashMap;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        Object obj2;
        Object obj3;
        return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.f50219a) || key.equals(obj2)) && (value == (obj3 = this.f50220b) || value.equals(obj3));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f50219a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f50220b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f50219a.hashCode() ^ this.f50220b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        obj.getClass();
        Object obj2 = this.f50220b;
        this.f50220b = obj;
        this.f50221c.put(this.f50219a, obj);
        return obj2;
    }

    public final String toString() {
        return this.f50219a + "=" + this.f50220b;
    }
}
