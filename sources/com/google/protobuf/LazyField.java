package com.google.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class LazyField extends LazyFieldLite {

    /* renamed from: f  reason: collision with root package name */
    private final MessageLite f17482f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class LazyEntry<K> implements Map.Entry<K, Object> {

        /* renamed from: f  reason: collision with root package name */
        private Map.Entry<K, LazyField> f17483f;

        public LazyField a() {
            return this.f17483f.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f17483f.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField value = this.f17483f.getValue();
            if (value == null) {
                return null;
            }
            return value.f();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.f17483f.getValue().d((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private LazyEntry(Map.Entry<K, LazyField> entry) {
            this.f17483f = entry;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>>, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f17484f;

        public LazyIterator(Iterator<Map.Entry<K, Object>> it) {
            this.f17484f = it;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f17484f.next();
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
            return this.f17484f.hasNext();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            this.f17484f.remove();
        }
    }

    @Override // com.google.protobuf.LazyFieldLite
    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public MessageLite f() {
        return c(this.f17482f);
    }

    @Override // com.google.protobuf.LazyFieldLite
    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
