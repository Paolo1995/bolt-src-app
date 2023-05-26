package io.netty.handler.codec;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.netty.handler.codec.Headers;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes5.dex */
public class DefaultHeaders<K, V, T extends Headers<K, V, T>> implements Headers<K, V, T> {
    private final HeaderEntry<K, V>[] entries;
    private final byte hashMask;
    private final HashingStrategy<K> hashingStrategy;
    protected final HeaderEntry<K, V> head;
    private final NameValidator<K> nameValidator;
    int size;
    private final ValueConverter<V> valueConverter;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class HeaderIterator implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
        private HeaderEntry<K, V> current;

        private HeaderIterator() {
            this.current = DefaultHeaders.this.head;
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
            if (this.current.after != DefaultHeaders.this.head) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Map.Entry<K, V> next() {
            HeaderEntry<K, V> headerEntry = this.current.after;
            this.current = headerEntry;
            if (headerEntry != DefaultHeaders.this.head) {
                return headerEntry;
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes5.dex */
    public interface NameValidator<K> {
        public static final NameValidator NOT_NULL = new NameValidator() { // from class: io.netty.handler.codec.DefaultHeaders.NameValidator.1
            @Override // io.netty.handler.codec.DefaultHeaders.NameValidator
            public void validateName(Object obj) {
                ObjectUtil.checkNotNull(obj, "name");
            }
        };

        void validateName(K k8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class ValueIterator implements java.util.Iterator<V>, j$.util.Iterator {
        private final int hash;
        private final K name;
        private HeaderEntry<K, V> next;
        private HeaderEntry<K, V> previous;
        private HeaderEntry<K, V> removalPrevious;

        ValueIterator(K k8) {
            this.name = (K) ObjectUtil.checkNotNull(k8, "name");
            int hashCode = DefaultHeaders.this.hashingStrategy.hashCode(k8);
            this.hash = hashCode;
            calculateNext(DefaultHeaders.this.entries[DefaultHeaders.this.index(hashCode)]);
        }

        private void calculateNext(HeaderEntry<K, V> headerEntry) {
            while (headerEntry != null) {
                if (headerEntry.hash == this.hash && DefaultHeaders.this.hashingStrategy.equals(this.name, headerEntry.key)) {
                    this.next = headerEntry;
                    return;
                }
                headerEntry = headerEntry.next;
            }
            this.next = null;
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
            if (this.next != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public V next() {
            if (hasNext()) {
                HeaderEntry<K, V> headerEntry = this.previous;
                if (headerEntry != null) {
                    this.removalPrevious = headerEntry;
                }
                HeaderEntry<K, V> headerEntry2 = this.next;
                this.previous = headerEntry2;
                calculateNext(headerEntry2.next);
                return this.previous.value;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            HeaderEntry<K, V> headerEntry = this.previous;
            if (headerEntry != null) {
                this.removalPrevious = DefaultHeaders.this.remove0(headerEntry, this.removalPrevious);
                this.previous = null;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator) {
        this(hashingStrategy, valueConverter, nameValidator, 16);
    }

    private void add0(int i8, int i9, K k8, V v7) {
        HeaderEntry<K, V>[] headerEntryArr = this.entries;
        headerEntryArr[i9] = newHeaderEntry(i8, k8, v7, headerEntryArr[i9]);
        this.size++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int index(int i8) {
        return i8 & this.hashMask;
    }

    private V remove0(int i8, int i9, K k8) {
        HeaderEntry<K, V> headerEntry = this.entries[i9];
        V v7 = null;
        if (headerEntry == null) {
            return null;
        }
        for (HeaderEntry<K, V> headerEntry2 = headerEntry.next; headerEntry2 != null; headerEntry2 = headerEntry.next) {
            if (headerEntry2.hash == i8 && this.hashingStrategy.equals(k8, headerEntry2.key)) {
                v7 = headerEntry2.value;
                headerEntry.next = headerEntry2.next;
                headerEntry2.remove();
                this.size--;
            } else {
                headerEntry = headerEntry2;
            }
        }
        HeaderEntry<K, V> headerEntry3 = this.entries[i9];
        if (headerEntry3.hash == i8 && this.hashingStrategy.equals(k8, headerEntry3.key)) {
            if (v7 == null) {
                v7 = headerEntry3.value;
            }
            this.entries[i9] = headerEntry3.next;
            headerEntry3.remove();
            this.size--;
        }
        return v7;
    }

    private T thisT() {
        return this;
    }

    public T add(K k8, V v7) {
        this.nameValidator.validateName(k8);
        ObjectUtil.checkNotNull(v7, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        int hashCode = this.hashingStrategy.hashCode(k8);
        add0(hashCode, index(hashCode), k8, v7);
        return thisT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addImpl(Headers<? extends K, ? extends V, ?> headers) {
        if (headers instanceof DefaultHeaders) {
            DefaultHeaders defaultHeaders = (DefaultHeaders) headers;
            HeaderEntry<K, V> headerEntry = defaultHeaders.head.after;
            if (defaultHeaders.hashingStrategy == this.hashingStrategy && defaultHeaders.nameValidator == this.nameValidator) {
                while (headerEntry != defaultHeaders.head) {
                    int i8 = headerEntry.hash;
                    add0(i8, index(i8), headerEntry.key, headerEntry.value);
                    headerEntry = headerEntry.after;
                }
                return;
            }
            while (headerEntry != defaultHeaders.head) {
                add(headerEntry.key, headerEntry.value);
                headerEntry = headerEntry.after;
            }
            return;
        }
        for (Map.Entry<? extends K, ? extends V> entry : headers) {
            add(entry.getKey(), entry.getValue());
        }
    }

    public T addObject(K k8, Object obj) {
        return add(k8, this.valueConverter.convertObject(ObjectUtil.checkNotNull(obj, AppMeasurementSdk.ConditionalUserProperty.VALUE)));
    }

    public T clear() {
        Arrays.fill(this.entries, (Object) null);
        HeaderEntry<K, V> headerEntry = this.head;
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.size = 0;
        return thisT();
    }

    public boolean contains(K k8) {
        return get(k8) != null;
    }

    public DefaultHeaders<K, V, T> copy() {
        DefaultHeaders<K, V, T> defaultHeaders = new DefaultHeaders<>(this.hashingStrategy, this.valueConverter, this.nameValidator, this.entries.length);
        defaultHeaders.addImpl(this);
        return defaultHeaders;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return equals((Headers) obj, HashingStrategy.JAVA_HASHER);
        }
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k8) {
        ObjectUtil.checkNotNull(k8, "name");
        int hashCode = this.hashingStrategy.hashCode(k8);
        V v7 = null;
        for (HeaderEntry<K, V> headerEntry = this.entries[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == hashCode && this.hashingStrategy.equals(k8, headerEntry.key)) {
                v7 = headerEntry.value;
            }
        }
        return v7;
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAll(K k8) {
        ObjectUtil.checkNotNull(k8, "name");
        LinkedList linkedList = new LinkedList();
        int hashCode = this.hashingStrategy.hashCode(k8);
        for (HeaderEntry<K, V> headerEntry = this.entries[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == hashCode && this.hashingStrategy.equals(k8, headerEntry.key)) {
                linkedList.addFirst(headerEntry.getValue());
            }
        }
        return linkedList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getAndRemove(K k8) {
        int hashCode = this.hashingStrategy.hashCode(k8);
        return (V) remove0(hashCode, index(hashCode), ObjectUtil.checkNotNull(k8, "name"));
    }

    public int hashCode() {
        return hashCode(HashingStrategy.JAVA_HASHER);
    }

    public boolean isEmpty() {
        HeaderEntry<K, V> headerEntry = this.head;
        if (headerEntry == headerEntry.after) {
            return true;
        }
        return false;
    }

    @Override // io.netty.handler.codec.Headers, java.lang.Iterable
    public java.util.Iterator<Map.Entry<K, V>> iterator() {
        return new HeaderIterator();
    }

    public Set<K> names() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        for (HeaderEntry<K, V> headerEntry = this.head.after; headerEntry != this.head; headerEntry = headerEntry.after) {
            linkedHashSet.add(headerEntry.getKey());
        }
        return linkedHashSet;
    }

    protected HeaderEntry<K, V> newHeaderEntry(int i8, K k8, V v7, HeaderEntry<K, V> headerEntry) {
        return new HeaderEntry<>(i8, k8, v7, headerEntry, this.head);
    }

    public boolean remove(K k8) {
        if (getAndRemove(k8) != null) {
            return true;
        }
        return false;
    }

    public T set(K k8, V v7) {
        this.nameValidator.validateName(k8);
        ObjectUtil.checkNotNull(v7, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        int hashCode = this.hashingStrategy.hashCode(k8);
        int index = index(hashCode);
        remove0(hashCode, index, k8);
        add0(hashCode, index, k8, v7);
        return thisT();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T setObject(K k8, Object obj) {
        ObjectUtil.checkNotNull(obj, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        return (T) set(k8, ObjectUtil.checkNotNull(this.valueConverter.convertObject(obj), "convertedValue"));
    }

    @Override // io.netty.handler.codec.Headers
    public int size() {
        return this.size;
    }

    public String toString() {
        return HeadersUtils.toString(getClass(), iterator(), size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ValueConverter<V> valueConverter() {
        return this.valueConverter;
    }

    public java.util.Iterator<V> valueIterator(K k8) {
        return new ValueIterator(k8);
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator, int i8) {
        this.valueConverter = (ValueConverter) ObjectUtil.checkNotNull(valueConverter, "valueConverter");
        this.nameValidator = (NameValidator) ObjectUtil.checkNotNull(nameValidator, "nameValidator");
        this.hashingStrategy = (HashingStrategy) ObjectUtil.checkNotNull(hashingStrategy, "nameHashingStrategy");
        HeaderEntry<K, V>[] headerEntryArr = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(i8, 128)))];
        this.entries = headerEntryArr;
        this.hashMask = (byte) (headerEntryArr.length - 1);
        this.head = new HeaderEntry<>();
    }

    public final boolean contains(K k8, V v7, HashingStrategy<? super V> hashingStrategy) {
        ObjectUtil.checkNotNull(k8, "name");
        int hashCode = this.hashingStrategy.hashCode(k8);
        for (HeaderEntry<K, V> headerEntry = this.entries[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == hashCode && this.hashingStrategy.equals(k8, headerEntry.key) && hashingStrategy.equals(v7, (V) headerEntry.value)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode(HashingStrategy<V> hashingStrategy) {
        int i8 = -1028477387;
        for (K k8 : names()) {
            i8 = (i8 * 31) + this.hashingStrategy.hashCode(k8);
            List<V> all = getAll(k8);
            for (int i9 = 0; i9 < all.size(); i9++) {
                i8 = (i8 * 31) + hashingStrategy.hashCode(all.get(i9));
            }
        }
        return i8;
    }

    public final boolean equals(Headers<K, V, ?> headers, HashingStrategy<V> hashingStrategy) {
        if (headers.size() != size()) {
            return false;
        }
        if (this == headers) {
            return true;
        }
        for (K k8 : names()) {
            List<V> all = headers.getAll(k8);
            List<V> all2 = getAll(k8);
            if (all.size() != all2.size()) {
                return false;
            }
            for (int i8 = 0; i8 < all.size(); i8++) {
                if (!hashingStrategy.equals(all.get(i8), all2.get(i8))) {
                    return false;
                }
            }
        }
        return true;
    }

    public T setObject(K k8, Iterable<?> iterable) {
        Object next;
        this.nameValidator.validateName(k8);
        int hashCode = this.hashingStrategy.hashCode(k8);
        int index = index(hashCode);
        remove0(hashCode, index, k8);
        java.util.Iterator<?> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            add0(hashCode, index, k8, this.valueConverter.convertObject(next));
        }
        return thisT();
    }

    public T add(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            addImpl(headers);
            return thisT();
        }
        throw new IllegalArgumentException("can't add to itself.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public static class HeaderEntry<K, V> implements Map.Entry<K, V> {
        protected HeaderEntry<K, V> after;
        protected HeaderEntry<K, V> before;
        protected final int hash;
        protected final K key;
        protected HeaderEntry<K, V> next;
        protected V value;

        HeaderEntry(int i8, K k8, V v7, HeaderEntry<K, V> headerEntry, HeaderEntry<K, V> headerEntry2) {
            this.hash = i8;
            this.key = k8;
            this.value = v7;
            this.next = headerEntry;
            this.after = headerEntry2;
            this.before = headerEntry2.before;
            pointNeighborsToThis();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey() == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!getKey().equals(entry.getKey())) {
                return false;
            }
            if (getValue() == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!getValue().equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            K k8 = this.key;
            int i8 = 0;
            if (k8 == null) {
                hashCode = 0;
            } else {
                hashCode = k8.hashCode();
            }
            V v7 = this.value;
            if (v7 != null) {
                i8 = v7.hashCode();
            }
            return hashCode ^ i8;
        }

        protected final void pointNeighborsToThis() {
            this.before.after = this;
            this.after.before = this;
        }

        protected void remove() {
            HeaderEntry<K, V> headerEntry = this.before;
            headerEntry.after = this.after;
            this.after.before = headerEntry;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v7) {
            ObjectUtil.checkNotNull(v7, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            V v8 = this.value;
            this.value = v7;
            return v8;
        }

        public final String toString() {
            return this.key.toString() + '=' + this.value.toString();
        }

        HeaderEntry() {
            this.hash = -1;
            this.key = null;
            this.after = this;
            this.before = this;
        }
    }

    public T set(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            clear();
            addImpl(headers);
        }
        return thisT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HeaderEntry<K, V> remove0(HeaderEntry<K, V> headerEntry, HeaderEntry<K, V> headerEntry2) {
        int index = index(headerEntry.hash);
        HeaderEntry<K, V>[] headerEntryArr = this.entries;
        if (headerEntryArr[index] == headerEntry) {
            headerEntry2 = headerEntry.next;
            headerEntryArr[index] = headerEntry2;
        } else {
            headerEntry2.next = headerEntry.next;
        }
        headerEntry.remove();
        this.size--;
        return headerEntry2;
    }
}
