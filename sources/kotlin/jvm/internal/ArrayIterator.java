package kotlin.jvm.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes5.dex */
final class ArrayIterator<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private final T[] f50983f;

    /* renamed from: g  reason: collision with root package name */
    private int f50984g;

    public ArrayIterator(T[] array) {
        Intrinsics.f(array, "array");
        this.f50983f = array;
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
        if (this.f50984g < this.f50983f.length) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f50983f;
            int i8 = this.f50984g;
            this.f50984g = i8 + 1;
            return tArr[i8];
        } catch (ArrayIndexOutOfBoundsException e8) {
            this.f50984g--;
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
