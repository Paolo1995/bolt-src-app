package org.jctools.queues;

/* compiled from: BaseSpscLinkedArrayQueue.java */
/* loaded from: classes5.dex */
abstract class BaseSpscLinkedArrayQueueProducerColdFields<E> extends BaseSpscLinkedArrayQueueProducerFields<E> {
    protected E[] producerBuffer;
    protected long producerBufferLimit;
    protected long producerMask;
}
