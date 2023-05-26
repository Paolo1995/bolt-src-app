package org.jctools.queues;

import org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: classes5.dex */
final class LinkedArrayQueueUtil {
    private LinkedArrayQueueUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int length(Object[] objArr) {
        return objArr.length;
    }

    static long modifiedCalcElementOffset(long j8, long j9) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j8 & j9) << (UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long nextArrayOffset(Object[] objArr) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((length(objArr) - 1) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
