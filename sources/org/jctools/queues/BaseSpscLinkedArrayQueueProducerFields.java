package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: BaseSpscLinkedArrayQueue.java */
/* loaded from: classes5.dex */
abstract class BaseSpscLinkedArrayQueueProducerFields<E> extends BaseSpscLinkedArrayQueueL2Pad<E> {
    private static final long P_INDEX_OFFSET = UnsafeAccess.fieldOffset(BaseSpscLinkedArrayQueueProducerFields.class, "producerIndex");
    protected long producerIndex;

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueueL2Pad, org.jctools.queues.BaseSpscLinkedArrayQueueConsumerField, org.jctools.queues.BaseSpscLinkedArrayQueueConsumerColdFields, org.jctools.queues.BaseSpscLinkedArrayQueuePrePad, org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void soProducerIndex(long j8) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j8);
    }
}
