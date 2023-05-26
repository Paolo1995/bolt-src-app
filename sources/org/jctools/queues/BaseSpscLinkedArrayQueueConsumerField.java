package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: BaseSpscLinkedArrayQueue.java */
/* loaded from: classes5.dex */
abstract class BaseSpscLinkedArrayQueueConsumerField<E> extends BaseSpscLinkedArrayQueueConsumerColdFields<E> {
    private static final long C_INDEX_OFFSET = UnsafeAccess.fieldOffset(BaseSpscLinkedArrayQueueConsumerField.class, "consumerIndex");
    protected long consumerIndex;

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueueConsumerColdFields, org.jctools.queues.BaseSpscLinkedArrayQueuePrePad, org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueueConsumerColdFields, org.jctools.queues.BaseSpscLinkedArrayQueuePrePad, org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public abstract /* synthetic */ long lvProducerIndex();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void soConsumerIndex(long j8) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j8);
    }
}
