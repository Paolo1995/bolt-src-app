package org.jctools.queues;

import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.Pow2;
import org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: classes5.dex */
public class SpscUnboundedArrayQueue<E> extends BaseSpscLinkedArrayQueue<E> {
    public SpscUnboundedArrayQueue(int i8) {
        int max = Math.max(Pow2.roundToPowerOfTwo(i8), 16);
        long j8 = max - 1;
        E[] eArr = (E[]) CircularArrayOffsetCalculator.allocate(max + 1);
        this.producerBuffer = eArr;
        this.producerMask = j8;
        this.consumerBuffer = eArr;
        this.consumerMask = j8;
        this.producerBufferLimit = j8 - 1;
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return -1;
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return super.currentConsumerIndex();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return super.currentProducerIndex();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return super.drain(consumer);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier) {
        return super.fill(supplier);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean offer(Object obj) {
        return super.offer(obj);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue
    final boolean offerColdPath(E[] eArr, long j8, long j9, long j10, E e8, MessagePassingQueue.Supplier<? extends E> supplier) {
        E e9;
        E e10;
        E e11;
        long j11 = ((j8 + 1) / 4) + j9;
        if (UnsafeRefArrayAccess.lvElement(eArr, CircularArrayOffsetCalculator.calcElementOffset(j11, j8)) == null) {
            this.producerBufferLimit = j11 - 1;
            if (e8 == null) {
                e11 = supplier.get();
            } else {
                e11 = e8;
            }
            writeToQueue(eArr, e11, j9, j10);
            return true;
        } else if (UnsafeRefArrayAccess.lvElement(eArr, CircularArrayOffsetCalculator.calcElementOffset(j9 + 1, j8)) == null) {
            if (e8 == null) {
                e10 = supplier.get();
            } else {
                e10 = e8;
            }
            writeToQueue(eArr, e10, j9, j10);
            return true;
        } else {
            E[] eArr2 = (E[]) CircularArrayOffsetCalculator.allocate((int) (2 + j8));
            this.producerBuffer = eArr2;
            this.producerBufferLimit = (j8 + j9) - 1;
            if (e8 == null) {
                e9 = supplier.get();
            } else {
                e9 = e8;
            }
            linkOldToNew(j9, eArr, j10, eArr2, j10, e9);
            return true;
        }
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object peek() {
        return super.peek();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object poll() {
        return super.poll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return super.relaxedOffer(obj);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return super.relaxedPeek();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return super.relaxedPoll();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i8) {
        return super.drain(consumer, i8);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier, int i8) {
        return super.fill(supplier, i8);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void fill(MessagePassingQueue.Supplier supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.fill(supplier, waitStrategy, exitCondition);
    }
}
