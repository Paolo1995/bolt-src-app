package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: f  reason: collision with root package name */
    Entry<K, V> f2308f;

    /* renamed from: g  reason: collision with root package name */
    private Entry<K, V> f2309g;

    /* renamed from: h  reason: collision with root package name */
    private WeakHashMap<SupportRemove<K, V>, Boolean> f2310h = new WeakHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private int f2311i = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> c(Entry<K, V> entry) {
            return entry.f2315i;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> d(Entry<K, V> entry) {
            return entry.f2314h;
        }
    }

    /* loaded from: classes.dex */
    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> c(Entry<K, V> entry) {
            return entry.f2314h;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> d(Entry<K, V> entry) {
            return entry.f2315i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Entry<K, V> implements Map.Entry<K, V> {
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        final K f2312f;
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        final V f2313g;

        /* renamed from: h  reason: collision with root package name */
        Entry<K, V> f2314h;

        /* renamed from: i  reason: collision with root package name */
        Entry<K, V> f2315i;

        Entry(@NonNull K k8, @NonNull V v7) {
            this.f2312f = k8;
            this.f2313g = v7;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.f2312f.equals(entry.f2312f) && this.f2313g.equals(entry.f2313g)) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.f2312f;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.f2313g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f2312f.hashCode() ^ this.f2313g.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f2312f + "=" + this.f2313g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class IteratorWithAdditions implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {

        /* renamed from: f  reason: collision with root package name */
        private Entry<K, V> f2316f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2317g = true;

        IteratorWithAdditions() {
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void b(@NonNull Entry<K, V> entry) {
            boolean z7;
            Entry<K, V> entry2 = this.f2316f;
            if (entry == entry2) {
                Entry<K, V> entry3 = entry2.f2315i;
                this.f2316f = entry3;
                if (entry3 == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                this.f2317g = z7;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public Map.Entry<K, V> next() {
            Entry<K, V> entry;
            if (this.f2317g) {
                this.f2317g = false;
                this.f2316f = SafeIterableMap.this.f2308f;
            } else {
                Entry<K, V> entry2 = this.f2316f;
                if (entry2 != null) {
                    entry = entry2.f2314h;
                } else {
                    entry = null;
                }
                this.f2316f = entry;
            }
            return this.f2316f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f2317g) {
                if (SafeIterableMap.this.f2308f != null) {
                    return true;
                }
                return false;
            }
            Entry<K, V> entry = this.f2316f;
            if (entry != null && entry.f2314h != null) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class ListIterator<K, V> implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {

        /* renamed from: f  reason: collision with root package name */
        Entry<K, V> f2319f;

        /* renamed from: g  reason: collision with root package name */
        Entry<K, V> f2320g;

        ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.f2319f = entry2;
            this.f2320g = entry;
        }

        private Entry<K, V> f() {
            Entry<K, V> entry = this.f2320g;
            Entry<K, V> entry2 = this.f2319f;
            if (entry != entry2 && entry2 != null) {
                return d(entry);
            }
            return null;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void b(@NonNull Entry<K, V> entry) {
            if (this.f2319f == entry && entry == this.f2320g) {
                this.f2320g = null;
                this.f2319f = null;
            }
            Entry<K, V> entry2 = this.f2319f;
            if (entry2 == entry) {
                this.f2319f = c(entry2);
            }
            if (this.f2320g == entry) {
                this.f2320g = f();
            }
        }

        abstract Entry<K, V> c(Entry<K, V> entry);

        abstract Entry<K, V> d(Entry<K, V> entry);

        @Override // java.util.Iterator
        /* renamed from: e */
        public Map.Entry<K, V> next() {
            Entry<K, V> entry = this.f2320g;
            this.f2320g = f();
            return entry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f2320g != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface SupportRemove<K, V> {
        void b(@NonNull Entry<K, V> entry);
    }

    public Map.Entry<K, V> b() {
        return this.f2308f;
    }

    protected Entry<K, V> d(K k8) {
        Entry<K, V> entry = this.f2308f;
        while (entry != null && !entry.f2312f.equals(k8)) {
            entry = entry.f2314h;
        }
        return entry;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator descendingIterator = new DescendingIterator(this.f2309g, this.f2308f);
        this.f2310h.put(descendingIterator, Boolean.FALSE);
        return descendingIterator;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        return false;
    }

    public SafeIterableMap<K, V>.IteratorWithAdditions f() {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.f2310h.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    public Map.Entry<K, V> g() {
        return this.f2309g;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i8 = 0;
        while (it.hasNext()) {
            i8 += it.next().hashCode();
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Entry<K, V> i(@NonNull K k8, @NonNull V v7) {
        Entry<K, V> entry = new Entry<>(k8, v7);
        this.f2311i++;
        Entry<K, V> entry2 = this.f2309g;
        if (entry2 == null) {
            this.f2308f = entry;
            this.f2309g = entry;
            return entry;
        }
        entry2.f2314h = entry;
        entry.f2315i = entry2;
        this.f2309g = entry;
        return entry;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.f2308f, this.f2309g);
        this.f2310h.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public V k(@NonNull K k8, @NonNull V v7) {
        Entry<K, V> d8 = d(k8);
        if (d8 != null) {
            return d8.f2313g;
        }
        i(k8, v7);
        return null;
    }

    public V m(@NonNull K k8) {
        Entry<K, V> d8 = d(k8);
        if (d8 == null) {
            return null;
        }
        this.f2311i--;
        if (!this.f2310h.isEmpty()) {
            for (SupportRemove<K, V> supportRemove : this.f2310h.keySet()) {
                supportRemove.b(d8);
            }
        }
        Entry<K, V> entry = d8.f2315i;
        if (entry != null) {
            entry.f2314h = d8.f2314h;
        } else {
            this.f2308f = d8.f2314h;
        }
        Entry<K, V> entry2 = d8.f2314h;
        if (entry2 != null) {
            entry2.f2315i = entry;
        } else {
            this.f2309g = entry;
        }
        d8.f2314h = null;
        d8.f2315i = null;
        return d8.f2313g;
    }

    public int size() {
        return this.f2311i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
