package kotlin.collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArraysJVM.kt */
/* loaded from: classes5.dex */
public class ArraysKt__ArraysJVMKt {
    public static final <T> T[] a(T[] reference, int i8) {
        Intrinsics.f(reference, "reference");
        Object newInstance = Array.newInstance(reference.getClass().getComponentType(), i8);
        Intrinsics.d(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) newInstance);
    }

    public static <T> int b(T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    public static final void c(int i8, int i9) {
        if (i8 <= i9) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i8 + ") is greater than size (" + i9 + ").");
    }
}
