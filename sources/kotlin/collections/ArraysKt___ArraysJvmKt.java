package kotlin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: _ArraysJvm.kt */
/* loaded from: classes5.dex */
public class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    public static <T> List<T> e(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        List<T> a8 = ArraysUtilJVM.a(tArr);
        Intrinsics.e(a8, "asList(this)");
        return a8;
    }

    public static byte[] f(byte[] bArr, byte[] destination, int i8, int i9, int i10) {
        Intrinsics.f(bArr, "<this>");
        Intrinsics.f(destination, "destination");
        System.arraycopy(bArr, i9, destination, i8, i10 - i9);
        return destination;
    }

    public static <T> T[] g(T[] tArr, T[] destination, int i8, int i9, int i10) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(destination, "destination");
        System.arraycopy(tArr, i9, destination, i8, i10 - i9);
        return destination;
    }

    public static /* synthetic */ byte[] h(byte[] bArr, byte[] bArr2, int i8, int i9, int i10, int i11, Object obj) {
        byte[] f8;
        if ((i11 & 2) != 0) {
            i8 = 0;
        }
        if ((i11 & 4) != 0) {
            i9 = 0;
        }
        if ((i11 & 8) != 0) {
            i10 = bArr.length;
        }
        f8 = f(bArr, bArr2, i8, i9, i10);
        return f8;
    }

    public static /* synthetic */ Object[] i(Object[] objArr, Object[] objArr2, int i8, int i9, int i10, int i11, Object obj) {
        Object[] g8;
        if ((i11 & 2) != 0) {
            i8 = 0;
        }
        if ((i11 & 4) != 0) {
            i9 = 0;
        }
        if ((i11 & 8) != 0) {
            i10 = objArr.length;
        }
        g8 = g(objArr, objArr2, i8, i9, i10);
        return g8;
    }

    public static byte[] j(byte[] bArr, int i8, int i9) {
        Intrinsics.f(bArr, "<this>");
        ArraysKt__ArraysJVMKt.c(i9, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i8, i9);
        Intrinsics.e(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static <T> T[] k(T[] tArr, int i8, int i9) {
        Intrinsics.f(tArr, "<this>");
        ArraysKt__ArraysJVMKt.c(i9, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i8, i9);
        Intrinsics.e(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    public static final void l(int[] iArr, int i8, int i9, int i10) {
        Intrinsics.f(iArr, "<this>");
        Arrays.fill(iArr, i9, i10, i8);
    }

    public static <T> void m(T[] tArr, T t7, int i8, int i9) {
        Intrinsics.f(tArr, "<this>");
        Arrays.fill(tArr, i8, i9, t7);
    }

    public static /* synthetic */ void n(int[] iArr, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i9 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = iArr.length;
        }
        l(iArr, i8, i9, i10);
    }

    public static /* synthetic */ void o(Object[] objArr, Object obj, int i8, int i9, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = objArr.length;
        }
        m(objArr, obj, i8, i9);
    }

    public static float[] p(float[] fArr, Collection<Float> elements) {
        Intrinsics.f(fArr, "<this>");
        Intrinsics.f(elements, "elements");
        int length = fArr.length;
        float[] result = Arrays.copyOf(fArr, elements.size() + length);
        for (Float f8 : elements) {
            result[length] = f8.floatValue();
            length++;
        }
        Intrinsics.e(result, "result");
        return result;
    }

    public static int[] q(int[] iArr, int i8) {
        Intrinsics.f(iArr, "<this>");
        int length = iArr.length;
        int[] result = Arrays.copyOf(iArr, length + 1);
        result[length] = i8;
        Intrinsics.e(result, "result");
        return result;
    }

    public static int[] r(int[] iArr, Collection<Integer> elements) {
        Intrinsics.f(iArr, "<this>");
        Intrinsics.f(elements, "elements");
        int length = iArr.length;
        int[] result = Arrays.copyOf(iArr, elements.size() + length);
        for (Integer num : elements) {
            result[length] = num.intValue();
            length++;
        }
        Intrinsics.e(result, "result");
        return result;
    }

    public static <T> T[] s(T[] tArr, T[] elements) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] result = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        Intrinsics.e(result, "result");
        return result;
    }

    public static final <T> void t(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
