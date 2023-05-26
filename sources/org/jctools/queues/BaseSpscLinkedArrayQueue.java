package org.jctools.queues;

import java.util.Iterator;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.PortableJvmInfo;
import org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: classes5.dex */
abstract class BaseSpscLinkedArrayQueue<E> extends BaseSpscLinkedArrayQueueProducerColdFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    private static final Object JUMP = new Object();

    private E newBufferPeek(E[] eArr, long j8) {
        E[] lvNextArrayAndUnlink = lvNextArrayAndUnlink(eArr);
        this.consumerBuffer = lvNextArrayAndUnlink;
        long length = LinkedArrayQueueUtil.length(lvNextArrayAndUnlink) - 2;
        this.consumerMask = length;
        return (E) UnsafeRefArrayAccess.lvElement(lvNextArrayAndUnlink, CircularArrayOffsetCalculator.calcElementOffset(j8, length));
    }

    private E newBufferPoll(E[] eArr, long j8) {
        E[] lvNextArrayAndUnlink = lvNextArrayAndUnlink(eArr);
        this.consumerBuffer = lvNextArrayAndUnlink;
        long length = LinkedArrayQueueUtil.length(lvNextArrayAndUnlink) - 2;
        this.consumerMask = length;
        long calcElementOffset = CircularArrayOffsetCalculator.calcElementOffset(j8, length);
        E e8 = (E) UnsafeRefArrayAccess.lvElement(lvNextArrayAndUnlink, calcElementOffset);
        if (e8 != null) {
            soConsumerIndex(j8 + 1);
            UnsafeRefArrayAccess.soElement(lvNextArrayAndUnlink, calcElementOffset, null);
            return e8;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public abstract /* synthetic */ int capacity();

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return MessagePassingQueueUtil.drain(this, consumer);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        int capacity = capacity();
        long j8 = 0;
        do {
            int fill = fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
            if (fill == 0) {
                return (int) j8;
            }
            j8 += fill;
        } while (j8 <= capacity);
        return (int) j8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void linkOldToNew(long j8, E[] eArr, long j9, E[] eArr2, long j10, E e8) {
        UnsafeRefArrayAccess.soElement(eArr2, j10, e8);
        soNext(eArr, eArr2);
        UnsafeRefArrayAccess.soElement(eArr, j9, JUMP);
        soProducerIndex(j8 + 1);
    }

    protected final E[] lvNextArrayAndUnlink(E[] eArr) {
        long nextArrayOffset = LinkedArrayQueueUtil.nextArrayOffset(eArr);
        E[] eArr2 = (E[]) ((Object[]) UnsafeRefArrayAccess.lvElement(eArr, nextArrayOffset));
        UnsafeRefArrayAccess.soElement(eArr, nextArrayOffset, null);
        return eArr2;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e8) {
        e8.getClass();
        E[] eArr = this.producerBuffer;
        long j8 = this.producerIndex;
        long j9 = this.producerMask;
        long calcElementOffset = CircularArrayOffsetCalculator.calcElementOffset(j8, j9);
        if (j8 < this.producerBufferLimit) {
            writeToQueue(eArr, e8, j8, calcElementOffset);
            return true;
        }
        return offerColdPath(eArr, j9, j8, calcElementOffset, e8, null);
    }

    abstract boolean offerColdPath(E[] eArr, long j8, long j9, long j10, E e8, MessagePassingQueue.Supplier<? extends E> supplier);

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        E[] eArr = this.consumerBuffer;
        long j8 = this.consumerIndex;
        E e8 = (E) UnsafeRefArrayAccess.lvElement(eArr, CircularArrayOffsetCalculator.calcElementOffset(j8, this.consumerMask));
        if (e8 == JUMP) {
            return newBufferPeek(eArr, j8);
        }
        return e8;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        boolean z7;
        E[] eArr = this.consumerBuffer;
        long j8 = this.consumerIndex;
        long calcElementOffset = CircularArrayOffsetCalculator.calcElementOffset(j8, this.consumerMask);
        E e8 = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
        if (e8 == JUMP) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (e8 != null && !z7) {
            soConsumerIndex(j8 + 1);
            UnsafeRefArrayAccess.soElement(eArr, calcElementOffset, null);
            return e8;
        } else if (!z7) {
            return null;
        } else {
            return newBufferPoll(eArr, j8);
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e8) {
        return offer(e8);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return peek();
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        return poll();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public final int size() {
        return IndexedQueueSizeUtil.size(this);
    }

    protected final void soNext(E[] eArr, E[] eArr2) {
        UnsafeRefArrayAccess.soElement(eArr, LinkedArrayQueueUtil.nextArrayOffset(eArr), eArr2);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeToQueue(E[] eArr, E e8, long j8, long j9) {
        UnsafeRefArrayAccess.soElement(eArr, j9, e8);
        soProducerIndex(j8 + 1);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i8) {
        return MessagePassingQueueUtil.drain(this, consumer, i8);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            E[] eArr = this.producerBuffer;
            long j8 = this.producerIndex;
            long j9 = this.producerMask;
            long calcElementOffset = CircularArrayOffsetCalculator.calcElementOffset(j8, j9);
            if (j8 < this.producerBufferLimit) {
                writeToQueue(eArr, supplier.get(), j8, calcElementOffset);
            } else if (!offerColdPath(eArr, j9, j8, calcElementOffset, null, supplier)) {
                return i9;
            }
        }
        return i8;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        while (exitCondition.keepRunning()) {
            while (fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) != 0 && exitCondition.keepRunning()) {
            }
            int i8 = 0;
            while (exitCondition.keepRunning() && fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                i8 = waitStrategy.idle(i8);
            }
        }
    }
}
