package com.hivemq.client.internal.util;

import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public final class Checks {
    private Checks() {
    }

    public static int a(int i8, int i9) {
        if (i8 >= 0 && i8 <= i9) {
            return i8;
        }
        if (i8 < 0) {
            throw new IndexOutOfBoundsException("Cursor index must not be smaller than 0, but was " + i8 + ".");
        }
        throw new IndexOutOfBoundsException("Cursor index must not be greater than the size (" + i9 + "), but was " + i8 + ".");
    }

    public static <E> E b(E e8, String str, int i8) {
        if (e8 != null) {
            return e8;
        }
        throw new NullPointerException(str + " must not contain a null element, found at index " + i8 + ".");
    }

    public static <T> T[] c(T[] tArr, String str) {
        j(tArr, str);
        for (int i8 = 0; i8 < tArr.length; i8++) {
            b(tArr[i8], str, i8);
        }
        return tArr;
    }

    public static int d(int i8, int i9) {
        if (i8 >= 0 && i8 < i9) {
            return i8;
        }
        if (i8 < 0) {
            throw new IndexOutOfBoundsException("Index must not be smaller than 0, but was " + i8 + ".");
        }
        throw new IndexOutOfBoundsException("Index must not be greater than or equal to the size (" + i9 + "), but was " + i8 + ".");
    }

    public static void e(int i8, int i9, int i10) {
        if (i8 >= 0 && i8 <= i9 && i9 <= i10) {
            return;
        }
        if (i8 >= 0) {
            if (i8 > i9) {
                throw new IndexOutOfBoundsException("Start index must not be greater than the end index, but " + i8 + " > " + i9 + ".");
            }
            throw new IndexOutOfBoundsException("End index must not be greater than or equal to the size (" + i10 + "), but was " + i9 + ".");
        }
        throw new IndexOutOfBoundsException("Start index must not be smaller than 0, but was " + i8 + ".");
    }

    public static String f(String str, String str2) {
        j(str, str2);
        if (!str.isEmpty()) {
            return str;
        }
        throw new IllegalArgumentException(str2 + " must be at least one character long.");
    }

    public static <S, T extends S> T g(S s7, Class<T> cls, String str) {
        return (T) h(j(s7, str), cls, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <S, T extends S> T h(S s7, Class<T> cls, String str) {
        String typeName;
        if (cls.isInstance(s7)) {
            return s7;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" must not be implemented by the user, but was implemented by ");
        typeName = s7.getClass().getTypeName();
        sb.append(typeName);
        sb.append(".");
        throw new IllegalArgumentException(sb.toString());
    }

    public static <S, T extends S> T i(S s7, Class<T> cls, String str) {
        if (s7 == null) {
            return null;
        }
        return (T) h(s7, cls, str);
    }

    public static <T> T j(T t7, String str) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(str + " must not be null.");
    }

    public static void k(boolean z7, String str) {
        if (z7) {
            return;
        }
        throw new IllegalStateException(str);
    }

    public static <T> T l(T t7, String str) {
        if (t7 != null) {
            return t7;
        }
        throw new IllegalStateException(str + " must not be null. This must not happen and is a bug.");
    }

    public static long m(long j8, String str) {
        if (UnsignedDataTypes.a(j8)) {
            return j8;
        }
        throw new IllegalArgumentException(str + " must not exceed the value range of unsigned int [0, 4294967295], but was " + j8 + ".");
    }

    public static int n(int i8, String str) {
        if (UnsignedDataTypes.b(i8)) {
            return i8;
        }
        throw new IllegalArgumentException(str + " must not exceed the value range of unsigned short [0, " + Settings.DEFAULT_INITIAL_WINDOW_SIZE + "], but was " + i8 + ".");
    }
}
