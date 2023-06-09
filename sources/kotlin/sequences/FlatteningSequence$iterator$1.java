package kotlin.sequences;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
public final class FlatteningSequence$iterator$1<E> implements Iterator<E>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private final Iterator<T> f51108f;

    /* renamed from: g  reason: collision with root package name */
    private Iterator<? extends E> f51109g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ FlatteningSequence<T, R, E> f51110h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlatteningSequence$iterator$1(FlatteningSequence<T, R, E> flatteningSequence) {
        Sequence sequence;
        this.f51110h = flatteningSequence;
        sequence = ((FlatteningSequence) flatteningSequence).f51105a;
        this.f51108f = sequence.iterator();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean b() {
        /*
            r5 = this;
            java.util.Iterator<? extends E> r0 = r5.f51109g
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Le
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L14
            r0 = 0
            r5.f51109g = r0
        L14:
            java.util.Iterator<? extends E> r0 = r5.f51109g
            if (r0 != 0) goto L45
            java.util.Iterator<T> r0 = r5.f51108f
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L21
            return r2
        L21:
            java.util.Iterator<T> r0 = r5.f51108f
            java.lang.Object r0 = r0.next()
            kotlin.sequences.FlatteningSequence<T, R, E> r3 = r5.f51110h
            kotlin.jvm.functions.Function1 r3 = kotlin.sequences.FlatteningSequence.b(r3)
            kotlin.sequences.FlatteningSequence<T, R, E> r4 = r5.f51110h
            kotlin.jvm.functions.Function1 r4 = kotlin.sequences.FlatteningSequence.d(r4)
            java.lang.Object r0 = r4.invoke(r0)
            java.lang.Object r0 = r3.invoke(r0)
            java.util.Iterator r0 = (java.util.Iterator) r0
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L14
            r5.f51109g = r0
        L45:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.FlatteningSequence$iterator$1.b():boolean");
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
        return b();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public E next() {
        if (b()) {
            java.util.Iterator<? extends E> it = this.f51109g;
            Intrinsics.c(it);
            return it.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
