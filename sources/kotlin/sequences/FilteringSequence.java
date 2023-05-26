package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
public final class FilteringSequence<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f51098a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f51099b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<T, Boolean> f51100c;

    /* JADX WARN: Multi-variable type inference failed */
    public FilteringSequence(Sequence<? extends T> sequence, boolean z7, Function1<? super T, Boolean> predicate) {
        Intrinsics.f(sequence, "sequence");
        Intrinsics.f(predicate, "predicate");
        this.f51098a = sequence;
        this.f51099b = z7;
        this.f51100c = predicate;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new FilteringSequence$iterator$1(this);
    }
}
