package io.ktor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;

/* compiled from: DelegatingMutableSet.kt */
/* loaded from: classes5.dex */
public class DelegatingMutableSet<From, To> implements Set<To>, KMutableCollection {

    /* renamed from: f  reason: collision with root package name */
    private final Set<From> f47037f;

    /* renamed from: g  reason: collision with root package name */
    private final Function1<From, To> f47038g;

    /* renamed from: h  reason: collision with root package name */
    private final Function1<To, From> f47039h;

    /* renamed from: i  reason: collision with root package name */
    private final int f47040i;

    /* JADX WARN: Multi-variable type inference failed */
    public DelegatingMutableSet(Set<From> delegate, Function1<? super From, ? extends To> convertTo, Function1<? super To, ? extends From> convert) {
        Intrinsics.f(delegate, "delegate");
        Intrinsics.f(convertTo, "convertTo");
        Intrinsics.f(convert, "convert");
        this.f47037f = delegate;
        this.f47038g = convertTo;
        this.f47039h = convert;
        this.f47040i = delegate.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(To to) {
        return this.f47037f.add(this.f47039h.invoke(to));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends To> elements) {
        Intrinsics.f(elements, "elements");
        return this.f47037f.addAll(g(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f47037f.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.f47037f.contains(this.f47039h.invoke(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        return this.f47037f.containsAll(g(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Set)) {
            return false;
        }
        Collection<To> i8 = i(this.f47037f);
        if (!((Set) obj).containsAll(i8) || !i8.containsAll((Collection) obj)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Collection<From> g(Collection<? extends To> collection) {
        int v7;
        Intrinsics.f(collection, "<this>");
        v7 = CollectionsKt__IterablesKt.v(collection, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f47039h.invoke(it.next()));
        }
        return arrayList;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.f47037f.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Collection<To> i(Collection<? extends From> collection) {
        int v7;
        Intrinsics.f(collection, "<this>");
        v7 = CollectionsKt__IterablesKt.v(collection, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f47038g.invoke(it.next()));
        }
        return arrayList;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f47037f.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<To> iterator() {
        return new DelegatingMutableSet$iterator$1(this);
    }

    public int k() {
        return this.f47040i;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.f47037f.remove(this.f47039h.invoke(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        return this.f47037f.removeAll(g(elements));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        return this.f47037f.retainAll(g(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return k();
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

    public String toString() {
        return i(this.f47037f).toString();
    }
}
