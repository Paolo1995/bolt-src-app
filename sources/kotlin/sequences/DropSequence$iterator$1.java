package kotlin.sequences;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
public final class DropSequence$iterator$1<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private final Iterator<T> f51095f;

    /* renamed from: g  reason: collision with root package name */
    private int f51096g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropSequence$iterator$1(DropSequence<T> dropSequence) {
        Sequence sequence;
        int i8;
        sequence = ((DropSequence) dropSequence).f51093a;
        this.f51095f = sequence.iterator();
        i8 = ((DropSequence) dropSequence).f51094b;
        this.f51096g = i8;
    }

    private final void b() {
        while (this.f51096g > 0 && this.f51095f.hasNext()) {
            this.f51095f.next();
            this.f51096g--;
        }
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
        b();
        return this.f51095f.hasNext();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public T next() {
        b();
        return this.f51095f.next();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
