package kotlin.sequences;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
public final class FilteringSequence$iterator$1<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private final Iterator<T> f51101f;

    /* renamed from: g  reason: collision with root package name */
    private int f51102g;

    /* renamed from: h  reason: collision with root package name */
    private T f51103h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ FilteringSequence<T> f51104i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilteringSequence$iterator$1(FilteringSequence<T> filteringSequence) {
        Sequence sequence;
        this.f51104i = filteringSequence;
        sequence = ((FilteringSequence) filteringSequence).f51098a;
        this.f51101f = sequence.iterator();
        this.f51102g = -1;
    }

    private final void b() {
        Function1 function1;
        boolean z7;
        while (this.f51101f.hasNext()) {
            T next = this.f51101f.next();
            function1 = ((FilteringSequence) this.f51104i).f51100c;
            boolean booleanValue = ((Boolean) function1.invoke(next)).booleanValue();
            z7 = ((FilteringSequence) this.f51104i).f51099b;
            if (booleanValue == z7) {
                this.f51103h = next;
                this.f51102g = 1;
                return;
            }
        }
        this.f51102g = 0;
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
        if (this.f51102g == -1) {
            b();
        }
        if (this.f51102g == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public T next() {
        if (this.f51102g == -1) {
            b();
        }
        if (this.f51102g != 0) {
            T t7 = this.f51103h;
            this.f51103h = null;
            this.f51102g = -1;
            return t7;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
