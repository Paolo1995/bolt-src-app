package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import com.google.android.gms.common.api.Api;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class BaseMpscLinkedAtomicArrayQueue<E> extends BaseMpscLinkedAtomicArrayQueueColdProducerFields<E> implements MessagePassingQueue<E> {
    private static final Object JUMP = new Object();
    private static final Object BUFFER_CONSUMED = new Object();

    /* loaded from: classes5.dex */
    private static class WeakIterator<E> implements Iterator<E>, j$.util.Iterator {
        private AtomicReferenceArray<E> currentBuffer;
        private int mask;
        private E nextElement;
        private long nextIndex;
        private final long pIndex;

        WeakIterator(AtomicReferenceArray<E> atomicReferenceArray, long j8, long j9) {
            this.pIndex = j9 >> 1;
            this.nextIndex = j8 >> 1;
            setBuffer(atomicReferenceArray);
            this.nextElement = getNext();
        }

        private E getNext() {
            while (true) {
                long j8 = this.nextIndex;
                if (j8 >= this.pIndex) {
                    break;
                }
                this.nextIndex = 1 + j8;
                E e8 = (E) AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(j8, this.mask));
                if (e8 != null) {
                    if (e8 != BaseMpscLinkedAtomicArrayQueue.JUMP) {
                        return e8;
                    }
                    Object lvRefElement = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcRefElementOffset(this.mask + 1));
                    if (lvRefElement == BaseMpscLinkedAtomicArrayQueue.BUFFER_CONSUMED || lvRefElement == null) {
                        break;
                    }
                    setBuffer((AtomicReferenceArray) lvRefElement);
                    E e9 = (E) AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(j8, this.mask));
                    if (e9 != null) {
                        return e9;
                    }
                }
            }
            return null;
        }

        private void setBuffer(AtomicReferenceArray<E> atomicReferenceArray) {
            this.currentBuffer = atomicReferenceArray;
            this.mask = AtomicQueueUtil.length(atomicReferenceArray) - 2;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.nextElement != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public E next() {
            E e8 = this.nextElement;
            if (e8 != null) {
                this.nextElement = getNext();
                return e8;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public BaseMpscLinkedAtomicArrayQueue(int i8) {
        RangeUtil.checkGreaterThanOrEqual(i8, 2, "initialCapacity");
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i8);
        long j8 = (roundToPowerOfTwo - 1) << 1;
        AtomicReferenceArray<E> allocateRefArray = AtomicQueueUtil.allocateRefArray(roundToPowerOfTwo + 1);
        this.producerBuffer = allocateRefArray;
        this.producerMask = j8;
        this.consumerBuffer = allocateRefArray;
        this.consumerMask = j8;
        soProducerLimit(j8);
    }

    private E newBufferPeek(AtomicReferenceArray<E> atomicReferenceArray, long j8) {
        E e8 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j8, this.consumerMask));
        if (e8 != null) {
            return e8;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private E newBufferPoll(AtomicReferenceArray<E> atomicReferenceArray, long j8) {
        int modifiedCalcCircularRefElementOffset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j8, this.consumerMask);
        E e8 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, modifiedCalcCircularRefElementOffset);
        if (e8 != null) {
            AtomicQueueUtil.soRefElement(atomicReferenceArray, modifiedCalcCircularRefElementOffset, null);
            soConsumerIndex(j8 + 2);
            return e8;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private static int nextArrayOffset(long j8) {
        return AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j8 + 2, Long.MAX_VALUE);
    }

    private AtomicReferenceArray<E> nextBuffer(AtomicReferenceArray<E> atomicReferenceArray, long j8) {
        int nextArrayOffset = nextArrayOffset(j8);
        AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray) AtomicQueueUtil.lvRefElement(atomicReferenceArray, nextArrayOffset);
        this.consumerBuffer = atomicReferenceArray2;
        this.consumerMask = (AtomicQueueUtil.length(atomicReferenceArray2) - 2) << 1;
        AtomicQueueUtil.soRefElement(atomicReferenceArray, nextArrayOffset, BUFFER_CONSUMED);
        return atomicReferenceArray2;
    }

    private int offerSlowPath(long j8, long j9, long j10) {
        long lvConsumerIndex = lvConsumerIndex();
        long currentBufferCapacity = getCurrentBufferCapacity(j8) + lvConsumerIndex;
        if (currentBufferCapacity > j9) {
            if (!casProducerLimit(j10, currentBufferCapacity)) {
                return 1;
            }
            return 0;
        } else if (availableInQueue(j9, lvConsumerIndex) <= 0) {
            return 2;
        } else {
            if (!casProducerIndex(j9, 1 + j9)) {
                return 1;
            }
            return 3;
        }
    }

    private void resize(long j8, AtomicReferenceArray<E> atomicReferenceArray, long j9, E e8, MessagePassingQueue.Supplier<E> supplier) {
        int nextBufferSize = getNextBufferSize(atomicReferenceArray);
        try {
            AtomicReferenceArray<E> allocateRefArray = AtomicQueueUtil.allocateRefArray(nextBufferSize);
            this.producerBuffer = allocateRefArray;
            long j10 = (nextBufferSize - 2) << 1;
            this.producerMask = j10;
            int modifiedCalcCircularRefElementOffset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j9, j8);
            int modifiedCalcCircularRefElementOffset2 = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j9, j10);
            if (e8 == null) {
                e8 = supplier.get();
            }
            AtomicQueueUtil.soRefElement(allocateRefArray, modifiedCalcCircularRefElementOffset2, e8);
            AtomicQueueUtil.soRefElement(atomicReferenceArray, nextArrayOffset(j8), allocateRefArray);
            long availableInQueue = availableInQueue(j9, lvConsumerIndex());
            RangeUtil.checkPositive(availableInQueue, "availableInQueue");
            soProducerLimit(Math.min(j10, availableInQueue) + j9);
            soProducerIndex(j9 + 2);
            AtomicQueueUtil.soRefElement(atomicReferenceArray, modifiedCalcCircularRefElementOffset, JUMP);
        } catch (OutOfMemoryError e9) {
            soProducerIndex(j9);
            throw e9;
        }
    }

    protected abstract long availableInQueue(long j8, long j9);

    protected abstract long getCurrentBufferCapacity(long j8);

    protected abstract int getNextBufferSize(AtomicReferenceArray<E> atomicReferenceArray);

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (lvConsumerIndex() == lvProducerIndex()) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public java.util.Iterator<E> iterator() {
        return new WeakIterator(this.consumerBuffer, lvConsumerIndex(), lvProducerIndex());
    }

    @Override // java.util.Queue
    public boolean offer(E e8) {
        e8.getClass();
        while (true) {
            long lvProducerLimit = lvProducerLimit();
            long lvProducerIndex = lvProducerIndex();
            if ((lvProducerIndex & 1) != 1) {
                long j8 = this.producerMask;
                AtomicReferenceArray<E> atomicReferenceArray = this.producerBuffer;
                if (lvProducerLimit <= lvProducerIndex) {
                    int offerSlowPath = offerSlowPath(j8, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath == 1) {
                        continue;
                    } else if (offerSlowPath != 2) {
                        if (offerSlowPath == 3) {
                            resize(j8, atomicReferenceArray, lvProducerIndex, e8, null);
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
                if (casProducerIndex(lvProducerIndex, 2 + lvProducerIndex)) {
                    AtomicQueueUtil.soRefElement(atomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(lvProducerIndex, j8), e8);
                    return true;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d A[RETURN] */
    @Override // java.util.Queue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public E peek() {
        /*
            r10 = this;
            java.util.concurrent.atomic.AtomicReferenceArray<E> r0 = r10.consumerBuffer
            long r1 = r10.lpConsumerIndex()
            long r3 = r10.consumerMask
            int r5 = io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.modifiedCalcCircularRefElementOffset(r1, r3)
            java.lang.Object r6 = io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r5)
            if (r6 != 0) goto L20
            long r7 = r10.lvProducerIndex()
            int r9 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r9 == 0) goto L20
        L1a:
            java.lang.Object r6 = io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r5)
            if (r6 == 0) goto L1a
        L20:
            java.lang.Object r5 = io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.JUMP
            if (r6 != r5) goto L2d
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r10.nextBuffer(r0, r3)
            java.lang.Object r0 = r10.newBufferPeek(r0, r1)
            return r0
        L2d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.peek():java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public E poll() {
        /*
            r10 = this;
            java.util.concurrent.atomic.AtomicReferenceArray<E> r0 = r10.consumerBuffer
            long r1 = r10.lpConsumerIndex()
            long r3 = r10.consumerMask
            int r5 = io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.modifiedCalcCircularRefElementOffset(r1, r3)
            java.lang.Object r6 = io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r5)
            r7 = 0
            if (r6 != 0) goto L23
            long r8 = r10.lvProducerIndex()
            int r6 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r6 == 0) goto L22
        L1b:
            java.lang.Object r6 = io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r5)
            if (r6 == 0) goto L1b
            goto L23
        L22:
            return r7
        L23:
            java.lang.Object r8 = io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.JUMP
            if (r6 != r8) goto L30
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r10.nextBuffer(r0, r3)
            java.lang.Object r0 = r10.newBufferPoll(r0, r1)
            return r0
        L30:
            io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.soRefElement(r0, r5, r7)
            r3 = 2
            long r1 = r1 + r3
            r10.soConsumerIndex(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.poll():java.lang.Object");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long lvProducerIndex;
        long lvConsumerIndex;
        long lvConsumerIndex2 = lvConsumerIndex();
        while (true) {
            lvProducerIndex = lvProducerIndex();
            lvConsumerIndex = lvConsumerIndex();
            if (lvConsumerIndex2 == lvConsumerIndex) {
                break;
            }
            lvConsumerIndex2 = lvConsumerIndex;
        }
        long j8 = (lvProducerIndex - lvConsumerIndex) >> 1;
        if (j8 > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return (int) j8;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }
}
