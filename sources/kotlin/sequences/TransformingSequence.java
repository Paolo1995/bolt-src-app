package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
public final class TransformingSequence<T, R> implements Sequence<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f51130a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<T, R> f51131b;

    /* JADX WARN: Multi-variable type inference failed */
    public TransformingSequence(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transformer) {
        Intrinsics.f(sequence, "sequence");
        Intrinsics.f(transformer, "transformer");
        this.f51130a = sequence;
        this.f51131b = transformer;
    }

    public final <E> Sequence<E> d(Function1<? super R, ? extends Iterator<? extends E>> iterator) {
        Intrinsics.f(iterator, "iterator");
        return new FlatteningSequence(this.f51130a, this.f51131b, iterator);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new TransformingSequence$iterator$1(this);
    }
}
