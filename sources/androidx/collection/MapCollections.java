package androidx.collection;

import j$.util.Iterator;
import j$.util.Map;
import j$.util.function.Consumer;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class MapCollections<K, V> {

    /* renamed from: a  reason: collision with root package name */
    MapCollections<K, V>.EntrySet f4259a;

    /* renamed from: b  reason: collision with root package name */
    MapCollections<K, V>.KeySet f4260b;

    /* renamed from: c  reason: collision with root package name */
    MapCollections<K, V>.ValuesCollection f4261c;

    /* loaded from: classes.dex */
    final class ArrayIterator<T> implements Iterator<T>, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        final int f4262f;

        /* renamed from: g  reason: collision with root package name */
        int f4263g;

        /* renamed from: h  reason: collision with root package name */
        int f4264h;

        /* renamed from: i  reason: collision with root package name */
        boolean f4265i = false;

        ArrayIterator(int i8) {
            this.f4262f = i8;
            this.f4263g = MapCollections.this.d();
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
            if (this.f4264h < this.f4263g) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public T next() {
            if (hasNext()) {
                T t7 = (T) MapCollections.this.b(this.f4264h, this.f4262f);
                this.f4264h++;
                this.f4265i = true;
                return t7;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            if (this.f4265i) {
                int i8 = this.f4264h - 1;
                this.f4264h = i8;
                this.f4263g--;
                this.f4265i = false;
                MapCollections.this.h(i8);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    final class EntrySet implements Set<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d8 = MapCollections.this.d();
            for (Map.Entry<K, V> entry : collection) {
                MapCollections.this.g(entry.getKey(), entry.getValue());
            }
            if (d8 != MapCollections.this.d()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: b */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MapCollections.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e8 = MapCollections.this.e(entry.getKey());
            if (e8 < 0) {
                return false;
            }
            return ContainerHelpers.c(MapCollections.this.b(e8, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int i8 = 0;
            for (int d8 = MapCollections.this.d() - 1; d8 >= 0; d8--) {
                Object b8 = MapCollections.this.b(d8, 0);
                Object b9 = MapCollections.this.b(d8, 1);
                if (b8 == null) {
                    hashCode = 0;
                } else {
                    hashCode = b8.hashCode();
                }
                if (b9 == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = b9.hashCode();
                }
                i8 += hashCode ^ hashCode2;
            }
            return i8;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (MapCollections.this.d() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return MapCollections.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    final class KeySet implements Set<K> {
        KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k8) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MapCollections.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (MapCollections.this.e(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return MapCollections.j(MapCollections.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int i8 = 0;
            for (int d8 = MapCollections.this.d() - 1; d8 >= 0; d8--) {
                Object b8 = MapCollections.this.b(d8, 0);
                if (b8 == null) {
                    hashCode = 0;
                } else {
                    hashCode = b8.hashCode();
                }
                i8 += hashCode;
            }
            return i8;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (MapCollections.this.d() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<K> iterator() {
            return new ArrayIterator(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e8 = MapCollections.this.e(obj);
            if (e8 >= 0) {
                MapCollections.this.h(e8);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return MapCollections.o(MapCollections.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return MapCollections.p(MapCollections.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return MapCollections.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return MapCollections.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.r(tArr, 0);
        }
    }

    /* loaded from: classes.dex */
    final class MapIterator implements java.util.Iterator<Map.Entry<K, V>>, Map.Entry<K, V>, j$.util.Iterator, Map.Entry {

        /* renamed from: f  reason: collision with root package name */
        int f4269f;

        /* renamed from: h  reason: collision with root package name */
        boolean f4271h = false;

        /* renamed from: g  reason: collision with root package name */
        int f4270g = -1;

        MapIterator() {
            this.f4269f = MapCollections.this.d() - 1;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f4270g++;
                this.f4271h = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.f4271h) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!ContainerHelpers.c(entry.getKey(), MapCollections.this.b(this.f4270g, 0)) || !ContainerHelpers.c(entry.getValue(), MapCollections.this.b(this.f4270g, 1))) {
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public K getKey() {
            if (this.f4271h) {
                return (K) MapCollections.this.b(this.f4270g, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public V getValue() {
            if (this.f4271h) {
                return (V) MapCollections.this.b(this.f4270g, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f4270g < this.f4269f) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public int hashCode() {
            int hashCode;
            if (this.f4271h) {
                int i8 = 0;
                Object b8 = MapCollections.this.b(this.f4270g, 0);
                Object b9 = MapCollections.this.b(this.f4270g, 1);
                if (b8 == null) {
                    hashCode = 0;
                } else {
                    hashCode = b8.hashCode();
                }
                if (b9 != null) {
                    i8 = b9.hashCode();
                }
                return hashCode ^ i8;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            if (this.f4271h) {
                MapCollections.this.h(this.f4270g);
                this.f4270g--;
                this.f4269f--;
                this.f4271h = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public V setValue(V v7) {
            if (this.f4271h) {
                return (V) MapCollections.this.i(this.f4270g, v7);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: classes.dex */
    final class ValuesCollection implements Collection<V> {
        ValuesCollection() {
        }

        @Override // java.util.Collection
        public boolean add(V v7) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            MapCollections.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            if (MapCollections.this.f(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            if (MapCollections.this.d() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public java.util.Iterator<V> iterator() {
            return new ArrayIterator(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f8 = MapCollections.this.f(obj);
            if (f8 >= 0) {
                MapCollections.this.h(f8);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d8 = MapCollections.this.d();
            int i8 = 0;
            boolean z7 = false;
            while (i8 < d8) {
                if (collection.contains(MapCollections.this.b(i8, 1))) {
                    MapCollections.this.h(i8);
                    i8--;
                    d8--;
                    z7 = true;
                }
                i8++;
            }
            return z7;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d8 = MapCollections.this.d();
            int i8 = 0;
            boolean z7 = false;
            while (i8 < d8) {
                if (!collection.contains(MapCollections.this.b(i8, 1))) {
                    MapCollections.this.h(i8);
                    i8--;
                    d8--;
                    z7 = true;
                }
                i8++;
            }
            return z7;
        }

        @Override // java.util.Collection
        public int size() {
            return MapCollections.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return MapCollections.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(java.util.Map<K, V> map, Collection<?> collection) {
        java.util.Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(java.util.Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public static <K, V> boolean p(java.util.Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    protected abstract void a();

    protected abstract Object b(int i8, int i9);

    protected abstract java.util.Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k8, V v7);

    protected abstract void h(int i8);

    protected abstract V i(int i8, V v7);

    public Set<Map.Entry<K, V>> l() {
        if (this.f4259a == null) {
            this.f4259a = new EntrySet();
        }
        return this.f4259a;
    }

    public Set<K> m() {
        if (this.f4260b == null) {
            this.f4260b = new KeySet();
        }
        return this.f4260b;
    }

    public Collection<V> n() {
        if (this.f4261c == null) {
            this.f4261c = new ValuesCollection();
        }
        return this.f4261c;
    }

    public Object[] q(int i8) {
        int d8 = d();
        Object[] objArr = new Object[d8];
        for (int i9 = 0; i9 < d8; i9++) {
            objArr[i9] = b(i9, i8);
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] r(T[] tArr, int i8) {
        int d8 = d();
        if (tArr.length < d8) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d8));
        }
        for (int i9 = 0; i9 < d8; i9++) {
            tArr[i9] = b(i9, i8);
        }
        if (tArr.length > d8) {
            tArr[d8] = null;
        }
        return tArr;
    }
}
