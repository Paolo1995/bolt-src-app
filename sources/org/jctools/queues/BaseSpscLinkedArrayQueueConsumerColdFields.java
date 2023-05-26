package org.jctools.queues;

/* compiled from: BaseSpscLinkedArrayQueue.java */
/* loaded from: classes5.dex */
abstract class BaseSpscLinkedArrayQueueConsumerColdFields<E> extends BaseSpscLinkedArrayQueuePrePad<E> {
    protected E[] consumerBuffer;
    protected long consumerMask;

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueuePrePad, org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public abstract /* synthetic */ long lvConsumerIndex();

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueuePrePad, org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public abstract /* synthetic */ long lvProducerIndex();
}
