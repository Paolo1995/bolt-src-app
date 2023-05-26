package io.netty.util.internal.shaded.org.jctools.util;

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
            throw new IllegalStateException("Unknown pointer size: " + arrayIndexScale);
        }
        REF_ARRAY_BASE = unsafe.arrayBaseOffset(Object[].class);
    }

    public static <E> E[] allocateRefArray(int i8) {
        return (E[]) new Object[i8];
    }

    public static long calcCircularRefElementOffset(long j8, long j9) {
        return REF_ARRAY_BASE + ((j8 & j9) << REF_ELEMENT_SHIFT);
    }

    public static long calcRefElementOffset(long j8) {
        return REF_ARRAY_BASE + (j8 << REF_ELEMENT_SHIFT);
    }

    public static <E> E lvRefElement(E[] eArr, long j8) {
        return (E) UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j8);
    }

    public static <E> void soRefElement(E[] eArr, long j8, E e8) {
        UnsafeAccess.UNSAFE.putOrderedObject(eArr, j8, e8);
    }
}
