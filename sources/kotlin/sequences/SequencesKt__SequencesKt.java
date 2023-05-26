package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
public class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    public static <T> Sequence<T> c(final Iterator<? extends T> it) {
        Sequence<T> d8;
        Intrinsics.f(it, "<this>");
        d8 = d(new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return it;
            }
        });
        return d8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Sequence<T> d(Sequence<? extends T> sequence) {
        Intrinsics.f(sequence, "<this>");
        if (!(sequence instanceof ConstrainedOnceSequence)) {
            return new ConstrainedOnceSequence(sequence);
        }
        return sequence;
    }

    public static <T> Sequence<T> e() {
        return EmptySequence.f51097a;
    }

    public static final <T> Sequence<T> f(Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.f(sequence, "<this>");
        return g(sequence, new Function1<Sequence<? extends T>, Iterator<? extends T>>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Iterator<T> invoke(Sequence<? extends T> it) {
                Intrinsics.f(it, "it");
                return (Iterator<? extends T>) it.iterator();
            }
        });
    }

    private static final <T, R> Sequence<R> g(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        if (sequence instanceof TransformingSequence) {
            return ((TransformingSequence) sequence).d(function1);
        }
        return new FlatteningSequence(sequence, new Function1<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$3
            @Override // kotlin.jvm.functions.Function1
            public final T invoke(T t7) {
                return t7;
            }
        }, function1);
    }

    public static <T> Sequence<T> h(final T t7, Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.f(nextFunction, "nextFunction");
        if (t7 == null) {
            return EmptySequence.f51097a;
        }
        return new GeneratorSequence(new Function0<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return t7;
            }
        }, nextFunction);
    }

    public static <T> Sequence<T> i(Function0<? extends T> seedFunction, Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.f(seedFunction, "seedFunction");
        Intrinsics.f(nextFunction, "nextFunction");
        return new GeneratorSequence(seedFunction, nextFunction);
    }

    public static <T> Sequence<T> j(T... elements) {
        boolean z7;
        Sequence<T> v7;
        Sequence<T> e8;
        Intrinsics.f(elements, "elements");
        if (elements.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            e8 = e();
            return e8;
        }
        v7 = ArraysKt___ArraysKt.v(elements);
        return v7;
    }
}
