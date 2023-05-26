package kotlin.collections.builders;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListBuilder.kt */
/* loaded from: classes5.dex */
public final class ListBuilderKt {
    public static final <E> E[] d(int i8) {
        boolean z7;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return (E[]) new Object[i8];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] e(T[] tArr, int i8) {
        Intrinsics.f(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i8);
        Intrinsics.e(tArr2, "copyOf(this, newSize)");
        return tArr2;
    }

    public static final <E> void f(E[] eArr, int i8) {
        Intrinsics.f(eArr, "<this>");
        eArr[i8] = null;
    }

    public static final <E> void g(E[] eArr, int i8, int i9) {
        Intrinsics.f(eArr, "<this>");
        while (i8 < i9) {
            f(eArr, i8);
            i8++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean h(T[] tArr, int i8, int i9, List<?> list) {
        if (i9 != list.size()) {
            return false;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            if (!Intrinsics.a(tArr[i8 + i10], list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int i(T[] tArr, int i8, int i9) {
        int i10;
        int i11 = 1;
        for (int i12 = 0; i12 < i9; i12++) {
            T t7 = tArr[i8 + i12];
            int i13 = i11 * 31;
            if (t7 != null) {
                i10 = t7.hashCode();
            } else {
                i10 = 0;
            }
            i11 = i13 + i10;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String j(T[] tArr, int i8, int i9) {
        StringBuilder sb = new StringBuilder((i9 * 3) + 2);
        sb.append("[");
        for (int i10 = 0; i10 < i9; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(tArr[i8 + i10]);
        }
        sb.append("]");
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "sb.toString()");
        return sb2;
    }
}
