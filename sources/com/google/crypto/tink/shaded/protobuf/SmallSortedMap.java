package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: f  reason: collision with root package name */
    private final int f15201f;

    /* renamed from: g  reason: collision with root package name */
    private List<SmallSortedMap<K, V>.Entry> f15202g;

    /* renamed from: h  reason: collision with root package name */
    private Map<K, V> f15203h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15204i;

    /* renamed from: j  reason: collision with root package name */
    private volatile SmallSortedMap<K, V>.EntrySet f15205j;

    /* renamed from: k  reason: collision with root package name */
    private Map<K, V> f15206k;

    /* renamed from: l  reason: collision with root package name */
    private volatile SmallSortedMap<K, V>.DescendingEntrySet f15207l;

    /* loaded from: classes.dex */
    private class DescendingEntryIterator implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private int f15208f;

        /* renamed from: g  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f15209g;

        private DescendingEntryIterator() {
            this.f15208f = SmallSortedMap.this.f15202g.size();
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f15209g == null) {
                this.f15209g = SmallSortedMap.this.f15206k.entrySet().iterator();
            }
            return this.f15209g;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: c */
        public Map.Entry<K, V> next() {
            if (!b().hasNext()) {
                List list = SmallSortedMap.this.f15202g;
                int i8 = this.f15208f - 1;
                this.f15208f = i8;
                return (Map.Entry) list.get(i8);
            }
            return b().next();
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
            int i8 = this.f15208f;
            if ((i8 > 0 && i8 <= SmallSortedMap.this.f15202g.size()) || b().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    private class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        private DescendingEntrySet() {
            super();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class EmptySet {

        /* renamed from: a  reason: collision with root package name */
        private static final java.util.Iterator<Object> f15212a = new AnonymousClass1();

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f15213b = new Iterable<Object>() { // from class: com.google.crypto.tink.shaded.protobuf.SmallSortedMap.EmptySet.2
            @Override // java.lang.Iterable
            public java.util.Iterator<Object> iterator() {
                return EmptySet.f15212a;
            }
        };

        /* renamed from: com.google.crypto.tink.shaded.protobuf.SmallSortedMap$EmptySet$1  reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements java.util.Iterator<Object>, j$.util.Iterator {
            AnonymousClass1() {
            }

            @Override // j$.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            @Override // java.util.Iterator
            public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super Object> consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        private EmptySet() {
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f15213b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {

        /* renamed from: f  reason: collision with root package name */
        private final K f15214f;

        /* renamed from: g  reason: collision with root package name */
        private V f15215g;

        Entry(SmallSortedMap smallSortedMap, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean c(Object obj, Object obj2) {
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
                return false;
            }
            return obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(SmallSortedMap<K, V>.Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: e */
        public K getKey() {
            return this.f15214f;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (c(this.f15214f, entry.getKey()) && c(this.f15215g, entry.getValue())) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f15215g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            K k8 = this.f15214f;
            int i8 = 0;
            if (k8 == null) {
                hashCode = 0;
            } else {
                hashCode = k8.hashCode();
            }
            V v7 = this.f15215g;
            if (v7 != null) {
                i8 = v7.hashCode();
            }
            return hashCode ^ i8;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            SmallSortedMap.this.h();
            V v8 = this.f15215g;
            this.f15215g = v7;
            return v8;
        }

        public String toString() {
            return this.f15214f + "=" + this.f15215g;
        }

        Entry(K k8, V v7) {
            this.f15214f = k8;
            this.f15215g = v7;
        }
    }

    /* loaded from: classes.dex */
    private class EntryIterator implements java.util.Iterator<Map.Entry<K, V>>, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private int f15217f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f15218g;

        /* renamed from: h  reason: collision with root package name */
        private java.util.Iterator<Map.Entry<K, V>> f15219h;

        private EntryIterator() {
            this.f15217f = -1;
        }

        private java.util.Iterator<Map.Entry<K, V>> b() {
            if (this.f15219h == null) {
                this.f15219h = SmallSortedMap.this.f15203h.entrySet().iterator();
            }
            return this.f15219h;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: c */
        public Map.Entry<K, V> next() {
            this.f15218g = true;
            int i8 = this.f15217f + 1;
            this.f15217f = i8;
            if (i8 < SmallSortedMap.this.f15202g.size()) {
                return (Map.Entry) SmallSortedMap.this.f15202g.get(this.f15217f);
            }
            return b().next();
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
            if (this.f15217f + 1 < SmallSortedMap.this.f15202g.size()) {
                return true;
            }
            if (!SmallSortedMap.this.f15203h.isEmpty() && b().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            if (this.f15218g) {
                this.f15218g = false;
                SmallSortedMap.this.h();
                if (this.f15217f < SmallSortedMap.this.f15202g.size()) {
                    SmallSortedMap smallSortedMap = SmallSortedMap.this;
                    int i8 = this.f15217f;
                    this.f15217f = i8 - 1;
                    smallSortedMap.t(i8);
                    return;
                }
                b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: b */
        public boolean add(Map.Entry<K, V> entry) {
            if (!contains(entry)) {
                SmallSortedMap.this.put(entry.getKey(), entry.getValue());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SmallSortedMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value && (obj2 == null || !obj2.equals(value))) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                SmallSortedMap.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return SmallSortedMap.this.size();
        }
    }

    private int g(K k8) {
        int size = this.f15202g.size() - 1;
        if (size >= 0) {
            int compareTo = k8.compareTo(this.f15202g.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i8 = 0;
        while (i8 <= size) {
            int i9 = (i8 + size) / 2;
            int compareTo2 = k8.compareTo(this.f15202g.get(i9).getKey());
            if (compareTo2 < 0) {
                size = i9 - 1;
            } else if (compareTo2 > 0) {
                i8 = i9 + 1;
            } else {
                return i9;
            }
        }
        return -(i8 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f15204i) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    private void j() {
        h();
        if (this.f15202g.isEmpty() && !(this.f15202g instanceof ArrayList)) {
            this.f15202g = new ArrayList(this.f15201f);
        }
    }

    private SortedMap<K, V> o() {
        h();
        if (this.f15203h.isEmpty() && !(this.f15203h instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f15203h = treeMap;
            this.f15206k = treeMap.descendingMap();
        }
        return (SortedMap) this.f15203h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> r(int i8) {
        return (SmallSortedMap<FieldDescriptorType, Object>) new SmallSortedMap<FieldDescriptorType, Object>(i8) { // from class: com.google.crypto.tink.shaded.protobuf.SmallSortedMap.1
            @Override // com.google.crypto.tink.shaded.protobuf.SmallSortedMap
            public void q() {
                if (!p()) {
                    for (int i9 = 0; i9 < l(); i9++) {
                        Map.Entry<FieldDescriptorType, Object> k8 = k(i9);
                        if (((FieldSet.FieldDescriptorLite) k8.getKey()).b()) {
                            k8.setValue(Collections.unmodifiableList((List) k8.getValue()));
                        }
                    }
                    for (Map.Entry<FieldDescriptorType, Object> entry : n()) {
                        if (((FieldSet.FieldDescriptorLite) entry.getKey()).b()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                super.q();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V t(int i8) {
        h();
        V value = this.f15202g.remove(i8).getValue();
        if (!this.f15203h.isEmpty()) {
            java.util.Iterator<Map.Entry<K, V>> it = o().entrySet().iterator();
            this.f15202g.add(new Entry(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.f15202g.isEmpty()) {
            this.f15202g.clear();
        }
        if (!this.f15203h.isEmpty()) {
            this.f15203h.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (g(comparable) < 0 && !this.f15203h.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f15205j == null) {
            this.f15205j = new EntrySet();
        }
        return this.f15205j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap)) {
            return super.equals(obj);
        }
        SmallSortedMap smallSortedMap = (SmallSortedMap) obj;
        int size = size();
        if (size != smallSortedMap.size()) {
            return false;
        }
        int l8 = l();
        if (l8 != smallSortedMap.l()) {
            return entrySet().equals(smallSortedMap.entrySet());
        }
        for (int i8 = 0; i8 < l8; i8++) {
            if (!k(i8).equals(smallSortedMap.k(i8))) {
                return false;
            }
        }
        if (l8 == size) {
            return true;
        }
        return this.f15203h.equals(smallSortedMap.f15203h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int g8 = g(comparable);
        if (g8 >= 0) {
            return this.f15202g.get(g8).getValue();
        }
        return this.f15203h.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int l8 = l();
        int i8 = 0;
        for (int i9 = 0; i9 < l8; i9++) {
            i8 += this.f15202g.get(i9).hashCode();
        }
        if (m() > 0) {
            return i8 + this.f15203h.hashCode();
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> i() {
        if (this.f15207l == null) {
            this.f15207l = new DescendingEntrySet();
        }
        return this.f15207l;
    }

    public Map.Entry<K, V> k(int i8) {
        return this.f15202g.get(i8);
    }

    public int l() {
        return this.f15202g.size();
    }

    public int m() {
        return this.f15203h.size();
    }

    public Iterable<Map.Entry<K, V>> n() {
        if (this.f15203h.isEmpty()) {
            return EmptySet.b();
        }
        return this.f15203h.entrySet();
    }

    public boolean p() {
        return this.f15204i;
    }

    public void q() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (!this.f15204i) {
            if (this.f15203h.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.f15203h);
            }
            this.f15203h = unmodifiableMap;
            if (this.f15206k.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.f15206k);
            }
            this.f15206k = unmodifiableMap2;
            this.f15204i = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int g8 = g(comparable);
        if (g8 >= 0) {
            return (V) t(g8);
        }
        if (this.f15203h.isEmpty()) {
            return null;
        }
        return this.f15203h.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: s */
    public V put(K k8, V v7) {
        h();
        int g8 = g(k8);
        if (g8 >= 0) {
            return this.f15202g.get(g8).setValue(v7);
        }
        j();
        int i8 = -(g8 + 1);
        if (i8 >= this.f15201f) {
            return o().put(k8, v7);
        }
        int size = this.f15202g.size();
        int i9 = this.f15201f;
        if (size == i9) {
            SmallSortedMap<K, V>.Entry remove = this.f15202g.remove(i9 - 1);
            o().put((K) remove.getKey(), remove.getValue());
        }
        this.f15202g.add(i8, new Entry(k8, v7));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f15202g.size() + this.f15203h.size();
    }

    private SmallSortedMap(int i8) {
        this.f15201f = i8;
        this.f15202g = Collections.emptyList();
        this.f15203h = Collections.emptyMap();
        this.f15206k = Collections.emptyMap();
    }
}
