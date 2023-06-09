package org.jctools.util;

import sun.misc.Unsafe;

/* loaded from: classes5.dex */
public final class UnsafeRefArrayAccess {
    public static final long REF_ARRAY_BASE;
    public static final int REF_ELEMENT_SHIFT;

    static {
        Unsafe unsafe = UnsafeAccess.UNSAFE;
        int arrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 2;
        } else if (8 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        REF_ARRAY_BASE = unsafe.arrayBaseOffset(Object[].class);
    }

    public static long calcElementOffset(long j8) {
        return REF_ARRAY_BASE + (j8 << REF_ELEMENT_SHIFT);
    }

    public static <E> E lpElement(E[] eArr, long j8) {
        return (E) UnsafeAccess.UNSAFE.getObject(eArr, j8);
    }

    public static <E> E lvElement(E[] eArr, long j8) {
        return (E) UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j8);
    }

    public static <E> void soElement(E[] eArr, long j8, E e8) {
        UnsafeAccess.UNSAFE.putOrderedObject(eArr, j8, e8);
    }

    public static <E> void spElement(E[] eArr, long j8, E e8) {
        UnsafeAccess.UNSAFE.putObject(eArr, j8, e8);
    }
}
