package org.jctools.queues;

import org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: classes5.dex */
public final class CircularArrayOffsetCalculator {
    public static <E> E[] allocate(int i8) {
        return (E[]) new Object[i8];
    }

    public static long calcElementOffset(long j8, long j9) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j8 & j9) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
