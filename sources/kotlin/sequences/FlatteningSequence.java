package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
public final class FlatteningSequence<T, R, E> implements Sequence<E> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f51105a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<T, R> f51106b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<R, Iterator<E>> f51107c;

    /* JADX WARN: Multi-variable type inference failed */
    public FlatteningSequence(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transformer, Function1<? super R, ? extends Iterator<? extends E>> iterator) {
        Intrinsics.f(sequence, "sequence");
        Intrinsics.f(transformer, "transformer");
        Intrinsics.f(iterator, "iterator");
        this.f51105a = sequence;
        this.f51106b = transformer;
        this.f51107c = iterator;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<E> iterator() {
        return new FlatteningSequence$iterator$1(this);
    }
}
