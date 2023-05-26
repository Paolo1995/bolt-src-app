package kotlin.sequences;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
public final class TransformingSequence$iterator$1<R> implements Iterator<R>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private final Iterator<T> f51132f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ TransformingSequence<T, R> f51133g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformingSequence$iterator$1(TransformingSequence<T, R> transformingSequence) {
        Sequence sequence;
        this.f51133g = transformingSequence;
        sequence = ((TransformingSequence) transformingSequence).f51130a;
        this.f51132f = sequence.iterator();
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
        return this.f51132f.hasNext();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public R next() {
        Function1 function1;
        function1 = ((TransformingSequence) this.f51133g).f51131b;
        return (R) function1.invoke(this.f51132f.next());
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
