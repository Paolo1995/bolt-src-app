package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.text.StringsKt__AppendableKt;

/* compiled from: _Arrays.kt */
/* loaded from: classes5.dex */
public class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static boolean A(short[] sArr, short s7) {
        Intrinsics.f(sArr, "<this>");
        if (P(sArr, s7) >= 0) {
            return true;
        }
        return false;
    }

    public static <T> List<T> B(T[] tArr) {
        List<T> H0;
        Intrinsics.f(tArr, "<this>");
        H0 = CollectionsKt___CollectionsKt.H0(i0(tArr));
        return H0;
    }

    public static <T> List<T> C(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        return (List) D(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C D(T[] tArr, C destination) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(destination, "destination");
        for (T t7 : tArr) {
            if (t7 != null) {
                destination.add(t7);
            }
        }
        return destination;
    }

    public static int E(int[] iArr) {
        boolean z7;
        Intrinsics.f(iArr, "<this>");
        if (iArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T F(T[] tArr) {
        boolean z7;
        Intrinsics.f(tArr, "<this>");
        if (tArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T G(T[] tArr) {
        boolean z7;
        Intrinsics.f(tArr, "<this>");
        if (tArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return null;
        }
        return tArr[0];
    }

    public static final int H(int[] iArr) {
        Intrinsics.f(iArr, "<this>");
        return iArr.length - 1;
    }

    public static int I(long[] jArr) {
        Intrinsics.f(jArr, "<this>");
        return jArr.length - 1;
    }

    public static <T> int J(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        return tArr.length - 1;
    }

    public static <T> T K(T[] tArr, int i8) {
        int J;
        Intrinsics.f(tArr, "<this>");
        if (i8 >= 0) {
            J = J(tArr);
            if (i8 <= J) {
                return tArr[i8];
            }
        }
        return null;
    }

    public static final int L(byte[] bArr, byte b8) {
        Intrinsics.f(bArr, "<this>");
        int length = bArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (b8 == bArr[i8]) {
                return i8;
            }
        }
        return -1;
    }

    public static final int M(int[] iArr, int i8) {
        Intrinsics.f(iArr, "<this>");
        int length = iArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (i8 == iArr[i9]) {
                return i9;
            }
        }
        return -1;
    }

    public static final int N(long[] jArr, long j8) {
        Intrinsics.f(jArr, "<this>");
        int length = jArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (j8 == jArr[i8]) {
                return i8;
            }
        }
        return -1;
    }

    public static <T> int O(T[] tArr, T t7) {
        Intrinsics.f(tArr, "<this>");
        int i8 = 0;
        if (t7 == null) {
            int length = tArr.length;
            while (i8 < length) {
                if (tArr[i8] == null) {
                    return i8;
                }
                i8++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i8 < length2) {
            if (Intrinsics.a(t7, tArr[i8])) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public static final int P(short[] sArr, short s7) {
        Intrinsics.f(sArr, "<this>");
        int length = sArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (s7 == sArr[i8]) {
                return i8;
            }
        }
        return -1;
    }

    public static final <T, A extends Appendable> A Q(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(buffer, "buffer");
        Intrinsics.f(separator, "separator");
        Intrinsics.f(prefix, "prefix");
        Intrinsics.f(postfix, "postfix");
        Intrinsics.f(truncated, "truncated");
        buffer.append(prefix);
        int i9 = 0;
        for (T t7 : tArr) {
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

    public static /* synthetic */ Appendable R(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i8, CharSequence charSequence4, Function1 function1, int i9, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i10;
        CharSequence charSequence7;
        Function1 function12;
        if ((i9 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i9 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i9 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i9 & 16) != 0) {
            i10 = -1;
        } else {
            i10 = i8;
        }
        if ((i9 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i9 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return Q(objArr, appendable, charSequence5, charSequence6, charSequence8, i10, charSequence7, function12);
    }

    public static final <T> String S(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(separator, "separator");
        Intrinsics.f(prefix, "prefix");
        Intrinsics.f(postfix, "postfix");
        Intrinsics.f(truncated, "truncated");
        String sb = ((StringBuilder) Q(tArr, new StringBuilder(), separator, prefix, postfix, i8, truncated, function1)).toString();
        Intrinsics.e(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String T(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i8, CharSequence charSequence4, Function1 function1, int i9, Object obj) {
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
        return S(objArr, charSequence, charSequence5, charSequence6, i10, charSequence7, function1);
    }

    public static <T> T U(T[] tArr) {
        boolean z7;
        int J;
        Intrinsics.f(tArr, "<this>");
        if (tArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            J = J(tArr);
            return tArr[J];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T V(T[] tArr) {
        boolean z7;
        Intrinsics.f(tArr, "<this>");
        if (tArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    public static Integer W(int[] iArr) {
        boolean z7;
        Intrinsics.f(iArr, "<this>");
        if (iArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return null;
        }
        int i8 = iArr[0];
        IntIterator it = new IntRange(1, H(iArr)).iterator();
        while (it.hasNext()) {
            int i9 = iArr[it.nextInt()];
            if (i8 < i9) {
                i8 = i9;
            }
        }
        return Integer.valueOf(i8);
    }

    public static List<Integer> X(int[] iArr) {
        boolean z7;
        List<Integer> k8;
        Intrinsics.f(iArr, "<this>");
        if (iArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        List<Integer> g02 = g0(iArr);
        CollectionsKt___CollectionsJvmKt.N(g02);
        return g02;
    }

    public static char Y(char[] cArr) {
        Intrinsics.f(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T Z(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> T[] a0(T[] tArr, Comparator<? super T> comparator) {
        boolean z7;
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(comparator, "comparator");
        if (tArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.e(tArr2, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.t(tArr2, comparator);
        return tArr2;
    }

    public static <T> List<T> b0(T[] tArr, Comparator<? super T> comparator) {
        List<T> e8;
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(comparator, "comparator");
        e8 = ArraysKt___ArraysJvmKt.e(a0(tArr, comparator));
        return e8;
    }

    public static int c0(Integer[] numArr) {
        Intrinsics.f(numArr, "<this>");
        int i8 = 0;
        for (Integer num : numArr) {
            i8 += num.intValue();
        }
        return i8;
    }

    public static <T> List<T> d0(T[] tArr, int i8) {
        boolean z7;
        List<T> e8;
        List<T> f02;
        List<T> k8;
        Intrinsics.f(tArr, "<this>");
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 == 0) {
                k8 = CollectionsKt__CollectionsKt.k();
                return k8;
            } else if (i8 >= tArr.length) {
                f02 = f0(tArr);
                return f02;
            } else if (i8 == 1) {
                e8 = CollectionsKt__CollectionsJVMKt.e(tArr[0]);
                return e8;
            } else {
                ArrayList arrayList = new ArrayList(i8);
                int i9 = 0;
                for (T t7 : tArr) {
                    arrayList.add(t7);
                    i9++;
                    if (i9 == i8) {
                        break;
                    }
                }
                return arrayList;
            }
        }
        throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
    }

    public static final <T, C extends Collection<? super T>> C e0(T[] tArr, C destination) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(destination, "destination");
        for (T t7 : tArr) {
            destination.add(t7);
        }
        return destination;
    }

    public static <T> List<T> f0(T[] tArr) {
        List<T> k8;
        List<T> e8;
        List<T> h02;
        Intrinsics.f(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                h02 = h0(tArr);
                return h02;
            }
            e8 = CollectionsKt__CollectionsJVMKt.e(tArr[0]);
            return e8;
        }
        k8 = CollectionsKt__CollectionsKt.k();
        return k8;
    }

    public static final List<Integer> g0(int[] iArr) {
        Intrinsics.f(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i8 : iArr) {
            arrayList.add(Integer.valueOf(i8));
        }
        return arrayList;
    }

    public static <T> List<T> h0(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        return new ArrayList(CollectionsKt__CollectionsKt.f(tArr));
    }

    public static final <T> Set<T> i0(T[] tArr) {
        int b8;
        Intrinsics.f(tArr, "<this>");
        b8 = MapsKt__MapsJVMKt.b(tArr.length);
        return (Set) e0(tArr, new LinkedHashSet(b8));
    }

    public static final <T> Set<T> j0(T[] tArr) {
        Set<T> b8;
        Set<T> a8;
        int b9;
        Intrinsics.f(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                b9 = MapsKt__MapsJVMKt.b(tArr.length);
                return (Set) e0(tArr, new LinkedHashSet(b9));
            }
            a8 = SetsKt__SetsJVMKt.a(tArr[0]);
            return a8;
        }
        b8 = SetsKt__SetsKt.b();
        return b8;
    }

    public static <T> Iterable<IndexedValue<T>> k0(final T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        return new IndexingIterable(new Function0<Iterator<? extends T>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Iterator<T> invoke() {
                return ArrayIteratorKt.a(tArr);
            }
        });
    }

    public static <T, R> List<Pair<T, R>> l0(T[] tArr, R[] other) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(other, "other");
        int min = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i8 = 0; i8 < min; i8++) {
            arrayList.add(TuplesKt.a(tArr[i8], other[i8]));
        }
        return arrayList;
    }

    public static <T> Iterable<T> u(T[] tArr) {
        boolean z7;
        List k8;
        Intrinsics.f(tArr, "<this>");
        if (tArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(tArr);
    }

    public static <T> Sequence<T> v(final T[] tArr) {
        boolean z7;
        Sequence<T> e8;
        Intrinsics.f(tArr, "<this>");
        if (tArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            e8 = SequencesKt__SequencesKt.e();
            return e8;
        }
        return new Sequence<T>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return ArrayIteratorKt.a(tArr);
            }
        };
    }

    public static boolean w(byte[] bArr, byte b8) {
        Intrinsics.f(bArr, "<this>");
        if (L(bArr, b8) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean x(int[] iArr, int i8) {
        Intrinsics.f(iArr, "<this>");
        if (M(iArr, i8) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean y(long[] jArr, long j8) {
        Intrinsics.f(jArr, "<this>");
        if (N(jArr, j8) >= 0) {
            return true;
        }
        return false;
    }

    public static <T> boolean z(T[] tArr, T t7) {
        int O;
        Intrinsics.f(tArr, "<this>");
        O = O(tArr, t7);
        if (O >= 0) {
            return true;
        }
        return false;
    }
}
