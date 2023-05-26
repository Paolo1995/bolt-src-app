package io.ktor.util.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;

/* JADX INFO: Add missing generic type declarations: [Key] */
/* compiled from: ConcurrentSet.kt */
/* loaded from: classes5.dex */
public final class ConcurrentSetKt$ConcurrentSet$1<Key> implements Set<Key>, KMutableCollection {

    /* renamed from: f  reason: collision with root package name */
    private final ConcurrentMap<Key, Unit> f47061f = new ConcurrentMap<>(0, 1, null);

    @Override // java.util.Set, java.util.Collection
    public boolean add(Key element) {
        Intrinsics.f(element, "element");
        if (this.f47061f.containsKey(element)) {
            return false;
        }
        this.f47061f.put(element, Unit.f50853a);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends Key> elements) {
        Intrinsics.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!add(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int b() {
        return this.f47061f.size();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f47061f.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f47061f.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        return elements.containsAll(this.f47061f.keySet());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f47061f.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Key> iterator() {
        return this.f47061f.keySet().iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        if (obj == null || this.f47061f.remove(obj) == null) {
            return false;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!remove(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Key key : this.f47061f.keySet()) {
            if (!elements.contains(key)) {
                linkedHashSet.add(key);
            }
        }
        return removeAll(linkedHashSet);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return b();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.f(array, "array");
        return (T[]) CollectionToArray.b(this, array);
    }
}
