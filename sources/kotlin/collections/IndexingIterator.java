package kotlin.collections;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Iterators.kt */
/* loaded from: classes5.dex */
public final class IndexingIterator<T> implements Iterator<IndexedValue<? extends T>>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private final Iterator<T> f50885f;

    /* renamed from: g  reason: collision with root package name */
    private int f50886g;

    /* JADX WARN: Multi-variable type inference failed */
    public IndexingIterator(Iterator<? extends T> iterator) {
        Intrinsics.f(iterator, "iterator");
        this.f50885f = iterator;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    /* renamed from: b */
    public final IndexedValue<T> next() {
        int i8 = this.f50886g;
        this.f50886g = i8 + 1;
        if (i8 < 0) {
            CollectionsKt__CollectionsKt.u();
        }
        return new IndexedValue<>(i8, this.f50885f.next());
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
    public final boolean hasNext() {
        return this.f50885f.hasNext();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
