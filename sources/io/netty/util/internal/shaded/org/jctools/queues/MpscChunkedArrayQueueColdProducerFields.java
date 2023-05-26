package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;

/* compiled from: MpscChunkedArrayQueue.java */
/* loaded from: classes5.dex */
abstract class MpscChunkedArrayQueueColdProducerFields<E> extends BaseMpscLinkedArrayQueue<E> {
    protected final long maxQueueCapacity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MpscChunkedArrayQueueColdProducerFields(int i8, int i9) {
        super(i8);
        RangeUtil.checkGreaterThanOrEqual(i9, 4, "maxCapacity");
        RangeUtil.checkLessThan(Pow2.roundToPowerOfTwo(i8), Pow2.roundToPowerOfTwo(i9), "initialCapacity");
        this.maxQueueCapacity = Pow2.roundToPowerOfTwo(i9) << 1;
    }
}
