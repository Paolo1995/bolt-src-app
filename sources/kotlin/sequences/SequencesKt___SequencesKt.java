package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__AppendableKt;

/* compiled from: _Sequences.kt */
/* loaded from: classes5.dex */
public class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {
    public static <T> Sequence<T> A(final Sequence<? extends T> sequence, final Comparator<? super T> comparator) {
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(comparator, "comparator");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$sortedWith$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                List E = SequencesKt___SequencesKt.E(sequence);
                CollectionsKt__MutableCollectionsJVMKt.z(E, comparator);
                return E.iterator();
            }
        };
    }

    public static long B(Sequence<Long> sequence) {
        Intrinsics.f(sequence, "<this>");
        long j8 = 0;
        for (Long l8 : sequence) {
            j8 += l8.longValue();
        }
        return j8;
    }

    public static final <T, C extends Collection<? super T>> C C(Sequence<? extends T> sequence, C destination) {
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(destination, "destination");
        for (T t7 : sequence) {
            destination.add(t7);
        }
        return destination;
    }

    public static <T> List<T> D(Sequence<? extends T> sequence) {
        List<T> r7;
        Intrinsics.f(sequence, "<this>");
        r7 = CollectionsKt__CollectionsKt.r(E(sequence));
        return r7;
    }

    public static final <T> List<T> E(Sequence<? extends T> sequence) {
        Intrinsics.f(sequence, "<this>");
        return (List) C(sequence, new ArrayList());
    }

    public static <T> Set<T> F(Sequence<? extends T> sequence) {
        Set<T> e8;
        Intrinsics.f(sequence, "<this>");
        e8 = SetsKt__SetsKt.e((Set) C(sequence, new LinkedHashSet()));
        return e8;
    }

    public static <T> Iterable<T> k(Sequence<? extends T> sequence) {
        Intrinsics.f(sequence, "<this>");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }

    public static <T> int l(Sequence<? extends T> sequence) {
        Intrinsics.f(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            it.next();
            i8++;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
        }
        return i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Sequence<T> m(Sequence<? extends T> sequence, int i8) {
        boolean z7;
        Intrinsics.f(sequence, "<this>");
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 != 0) {
                if (sequence instanceof DropTakeSequence) {
                    return ((DropTakeSequence) sequence).a(i8);
                }
                return new DropSequence(sequence, i8);
            }
            return sequence;
        }
        throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
    }

    public static <T> Sequence<T> n(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(predicate, "predicate");
        return new FilteringSequence(sequence, true, predicate);
    }

    public static final <T> Sequence<T> o(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(predicate, "predicate");
        return new FilteringSequence(sequence, false, predicate);
    }

    public static <T> Sequence<T> p(Sequence<? extends T> sequence) {
        Intrinsics.f(sequence, "<this>");
        Sequence<T> o8 = o(sequence, new Function1<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterNotNull$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(T t7) {
                boolean z7;
                if (t7 == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        });
        Intrinsics.d(o8, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return o8;
    }

    public static <T, R> Sequence<R> q(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(transform, "transform");
        return new FlatteningSequence(sequence, transform, SequencesKt___SequencesKt$flatMap$1.f51127o);
    }

    public static final <T, A extends Appendable> A r(Sequence<? extends T> sequence, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(buffer, "buffer");
        Intrinsics.f(separator, "separator");
        Intrinsics.f(prefix, "prefix");
        Intrinsics.f(postfix, "postfix");
        Intrinsics.f(truncated, "truncated");
        buffer.append(prefix);
        int i9 = 0;
        for (T t7 : sequence) {
            i9++;
            if (i9 > 1) {
                buffer.append(separator);
            }
            if (i8 >= 0 && i9 > i8) {
                break;
            }
            StringsKt__AppendableKt.a(buffer, t7, function1);
        }
        if (i8 >= 0 && i9 > i8) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String s(Sequence<? extends T> sequence, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(separator, "separator");
        Intrinsics.f(prefix, "prefix");
        Intrinsics.f(postfix, "postfix");
        Intrinsics.f(truncated, "truncated");
        String sb = ((StringBuilder) r(sequence, new StringBuilder(), separator, prefix, postfix, i8, truncated, function1)).toString();
        Intrinsics.e(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String t(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i8, CharSequence charSequence4, Function1 function1, int i9, Object obj) {
        CharSequence charSequence5;
        int i10;
        if ((i9 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i9 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i9 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i9 & 8) != 0) {
            i10 = -1;
        } else {
            i10 = i8;
        }
        if ((i9 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i9 & 32) != 0) {
            function1 = null;
        }
        return s(sequence, charSequence, charSequence5, charSequence6, i10, charSequence7, function1);
    }

    public static <T> T u(Sequence<? extends T> sequence) {
        Intrinsics.f(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static <T, R> Sequence<R> v(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transform) {
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(transform, "transform");
        return new TransformingSequence(sequence, transform);
    }

    public static <T, R> Sequence<R> w(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transform) {
        Sequence<R> p8;
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(transform, "transform");
        p8 = p(new TransformingSequence(sequence, transform));
        return p8;
    }

    public static <T> Sequence<T> x(Sequence<? extends T> sequence, Iterable<? extends T> elements) {
        Sequence O;
        Sequence j8;
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(elements, "elements");
        O = CollectionsKt___CollectionsKt.O(elements);
        j8 = SequencesKt__SequencesKt.j(sequence, O);
        return SequencesKt__SequencesKt.f(j8);
    }

    public static <T> Sequence<T> y(Sequence<? extends T> sequence, Sequence<? extends T> elements) {
        Sequence j8;
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(elements, "elements");
        j8 = SequencesKt__SequencesKt.j(sequence, elements);
        return SequencesKt__SequencesKt.f(j8);
    }

    public static <T> Sequence<T> z(Sequence<? extends T> sequence, T[] elements) {
        List e8;
        Sequence<T> x7;
        Intrinsics.f(sequence, "<this>");
        Intrinsics.f(elements, "elements");
        e8 = ArraysKt___ArraysJvmKt.e(elements);
        x7 = x(sequence, e8);
        return x7;
    }
}
