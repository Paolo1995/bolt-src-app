package kotlin.collections;

import java.util.Arrays;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt___UArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Arrays.kt */
/* loaded from: classes5.dex */
public class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public static <T> boolean d(T[] tArr, T[] tArr2) {
        boolean d8;
        boolean b8;
        boolean a8;
        boolean c8;
        boolean d9;
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == null || tArr2 == null || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            T t7 = tArr[i8];
            T t8 = tArr2[i8];
            if (t7 != t8) {
                if (t7 == null || t8 == null) {
                    return false;
                }
                if ((t7 instanceof Object[]) && (t8 instanceof Object[])) {
                    d9 = d((Object[]) t7, (Object[]) t8);
                    if (!d9) {
                        return false;
                    }
                } else if ((t7 instanceof byte[]) && (t8 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) t7, (byte[]) t8)) {
                        return false;
                    }
                } else if ((t7 instanceof short[]) && (t8 instanceof short[])) {
                    if (!Arrays.equals((short[]) t7, (short[]) t8)) {
                        return false;
                    }
                } else if ((t7 instanceof int[]) && (t8 instanceof int[])) {
                    if (!Arrays.equals((int[]) t7, (int[]) t8)) {
                        return false;
                    }
                } else if ((t7 instanceof long[]) && (t8 instanceof long[])) {
                    if (!Arrays.equals((long[]) t7, (long[]) t8)) {
                        return false;
                    }
                } else if ((t7 instanceof float[]) && (t8 instanceof float[])) {
                    if (!Arrays.equals((float[]) t7, (float[]) t8)) {
                        return false;
                    }
                } else if ((t7 instanceof double[]) && (t8 instanceof double[])) {
                    if (!Arrays.equals((double[]) t7, (double[]) t8)) {
                        return false;
                    }
                } else if ((t7 instanceof char[]) && (t8 instanceof char[])) {
                    if (!Arrays.equals((char[]) t7, (char[]) t8)) {
                        return false;
                    }
                } else if ((t7 instanceof boolean[]) && (t8 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) t7, (boolean[]) t8)) {
                        return false;
                    }
                } else if ((t7 instanceof UByteArray) && (t8 instanceof UByteArray)) {
                    c8 = UArraysKt___UArraysKt.c(((UByteArray) t7).y(), ((UByteArray) t8).y());
                    if (!c8) {
                        return false;
                    }
                } else if ((t7 instanceof UShortArray) && (t8 instanceof UShortArray)) {
                    a8 = UArraysKt___UArraysKt.a(((UShortArray) t7).y(), ((UShortArray) t8).y());
                    if (!a8) {
                        return false;
                    }
                } else if ((t7 instanceof UIntArray) && (t8 instanceof UIntArray)) {
                    b8 = UArraysKt___UArraysKt.b(((UIntArray) t7).y(), ((UIntArray) t8).y());
                    if (!b8) {
                        return false;
                    }
                } else if ((t7 instanceof ULongArray) && (t8 instanceof ULongArray)) {
                    d8 = UArraysKt___UArraysKt.d(((ULongArray) t7).y(), ((ULongArray) t8).y());
                    if (!d8) {
                        return false;
                    }
                } else if (!Intrinsics.a(t7, t8)) {
                    return false;
                }
            }
        }
        return true;
    }
}
