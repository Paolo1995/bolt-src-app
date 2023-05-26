package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes5.dex */
final class AtomicQueueUtil {
    AtomicQueueUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> AtomicReferenceArray<E> allocateRefArray(int i8) {
        return new AtomicReferenceArray<>(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int calcCircularRefElementOffset(long j8, long j9) {
        return (int) (j8 & j9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int calcRefElementOffset(long j8) {
        return (int) j8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int length(AtomicReferenceArray<?> atomicReferenceArray) {
        return atomicReferenceArray.length();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> E lvRefElement(AtomicReferenceArray<E> atomicReferenceArray, int i8) {
        return atomicReferenceArray.get(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int modifiedCalcCircularRefElementOffset(long j8, long j9) {
        return ((int) (j8 & j9)) >> 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void soRefElement(AtomicReferenceArray atomicReferenceArray, int i8, Object obj) {
        atomicReferenceArray.lazySet(i8, obj);
    }
}
