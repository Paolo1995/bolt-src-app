package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: classes5.dex */
final class LinkedArrayQueueUtil {
    LinkedArrayQueueUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int length(Object[] objArr) {
        return objArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long modifiedCalcCircularRefElementOffset(long j8, long j9) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j8 & j9) << (UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1));
    }
}
