package com.google.crypto.tink.shaded.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class LazyField extends LazyFieldLite {

    /* renamed from: f  reason: collision with root package name */
    private final MessageLite f15135f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LazyEntry<K> implements Map.Entry<K, Object> {

        /* renamed from: f  reason: collision with root package name */
        private Map.Entry<K, LazyField> f15136f;

        public LazyField a() {
            return this.f15136f.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f15136f.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField value = this.f15136f.getValue();
            if (value == null) {
                return null;
            }
            return value.f();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.f15136f.getValue().d((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private LazyEntry(Map.Entry<K, LazyField> entry) {
            this.f15136f = entry;
        }
    }

    /* loaded from: classes.dex */
    static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>>, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f15137f;

        public LazyIterator(Iterator<Map.Entry<K, Object>> it) {
            this.f15137f = it;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f15137f.next();
            if (next.getValue() instanceof LazyField) {
                return new LazyEntry(next);
            }
            return next;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.f15137f.hasNext();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            this.f15137f.remove();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyFieldLite
    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public MessageLite f() {
        return c(this.f15135f);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyFieldLite
    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
