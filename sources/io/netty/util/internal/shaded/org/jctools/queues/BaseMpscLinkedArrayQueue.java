package io.netty.util.internal.shaded.org.jctools.queues;

import com.google.android.gms.common.api.Api;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class BaseMpscLinkedArrayQueue<E> extends BaseMpscLinkedArrayQueueColdProducerFields<E> implements MessagePassingQueue<E> {
    private static final Object JUMP = new Object();
    private static final Object BUFFER_CONSUMED = new Object();

    /* loaded from: classes5.dex */
    private static class WeakIterator<E> implements Iterator<E>, j$.util.Iterator {
        private E[] currentBuffer;
        private int mask;
        private E nextElement;
        private long nextIndex;
        private final long pIndex;

        WeakIterator(E[] eArr, long j8, long j9) {
            this.pIndex = j9 >> 1;
            this.nextIndex = j8 >> 1;
            setBuffer(eArr);
            this.nextElement = getNext();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private E getNext() {
            while (true) {
                long j8 = this.nextIndex;
                if (j8 >= this.pIndex) {
                    break;
                }
                this.nextIndex = 1 + j8;
                E e8 = (E) UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(j8, this.mask));
                if (e8 != null) {
                    if (e8 != BaseMpscLinkedArrayQueue.JUMP) {
                        return e8;
                    }
                    Object lvRefElement = UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcRefElementOffset(this.mask + 1));
                    if (lvRefElement == BaseMpscLinkedArrayQueue.BUFFER_CONSUMED || lvRefElement == null) {
                        break;
                    }
                    setBuffer((Object[]) lvRefElement);
                    E e9 = (E) UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(j8, this.mask));
                    if (e9 != null) {
                        return e9;
                    }
                }
            }
            return null;
        }

        private void setBuffer(E[] eArr) {
            this.currentBuffer = eArr;
            this.mask = LinkedArrayQueueUtil.length(eArr) - 2;
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

    public BaseMpscLinkedArrayQueue(int i8) {
        RangeUtil.checkGreaterThanOrEqual(i8, 2, "initialCapacity");
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i8);
        long j8 = (roundToPowerOfTwo - 1) << 1;
        E[] eArr = (E[]) UnsafeRefArrayAccess.allocateRefArray(roundToPowerOfTwo + 1);
        this.producerBuffer = eArr;
        this.producerMask = j8;
        this.consumerBuffer = eArr;
        this.consumerMask = j8;
        soProducerLimit(j8);
    }

    private E newBufferPeek(E[] eArr, long j8) {
        E e8 = (E) UnsafeRefArrayAccess.lvRefElement(eArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j8, this.consumerMask));
        if (e8 != null) {
            return e8;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private E newBufferPoll(E[] eArr, long j8) {
        long modifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j8, this.consumerMask);
        E e8 = (E) UnsafeRefArrayAccess.lvRefElement(eArr, modifiedCalcCircularRefElementOffset);
        if (e8 != null) {
            UnsafeRefArrayAccess.soRefElement(eArr, modifiedCalcCircularRefElementOffset, null);
            soConsumerIndex(j8 + 2);
            return e8;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private static long nextArrayOffset(long j8) {
        return LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j8 + 2, Long.MAX_VALUE);
    }

    private E[] nextBuffer(E[] eArr, long j8) {
        long nextArrayOffset = nextArrayOffset(j8);
        E[] eArr2 = (E[]) ((Object[]) UnsafeRefArrayAccess.lvRefElement(eArr, nextArrayOffset));
        this.consumerBuffer = eArr2;
        this.consumerMask = (LinkedArrayQueueUtil.length(eArr2) - 2) << 1;
        UnsafeRefArrayAccess.soRefElement(eArr, nextArrayOffset, BUFFER_CONSUMED);
        return eArr2;
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

    private void resize(long j8, E[] eArr, long j9, E e8, MessagePassingQueue.Supplier<E> supplier) {
        int nextBufferSize = getNextBufferSize(eArr);
        try {
            E[] eArr2 = (E[]) UnsafeRefArrayAccess.allocateRefArray(nextBufferSize);
            this.producerBuffer = eArr2;
            long j10 = (nextBufferSize - 2) << 1;
            this.producerMask = j10;
            long modifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j9, j8);
            long modifiedCalcCircularRefElementOffset2 = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j9, j10);
            if (e8 == null) {
                e8 = supplier.get();
            }
            UnsafeRefArrayAccess.soRefElement(eArr2, modifiedCalcCircularRefElementOffset2, e8);
            UnsafeRefArrayAccess.soRefElement(eArr, nextArrayOffset(j8), eArr2);
            long availableInQueue = availableInQueue(j9, lvConsumerIndex());
            RangeUtil.checkPositive(availableInQueue, "availableInQueue");
            soProducerLimit(Math.min(j10, availableInQueue) + j9);
            soProducerIndex(j9 + 2);
            UnsafeRefArrayAccess.soRefElement(eArr, modifiedCalcCircularRefElementOffset, JUMP);
        } catch (OutOfMemoryError e9) {
            soProducerIndex(j9);
            throw e9;
        }
    }

    protected abstract long availableInQueue(long j8, long j9);

    protected abstract long getCurrentBufferCapacity(long j8);

    protected abstract int getNextBufferSize(E[] eArr);

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
                E[] eArr = this.producerBuffer;
                if (lvProducerLimit <= lvProducerIndex) {
                    int offerSlowPath = offerSlowPath(j8, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath == 1) {
                        continue;
                    } else if (offerSlowPath != 2) {
                        if (offerSlowPath == 3) {
                            resize(j8, eArr, lvProducerIndex, e8, null);
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
                if (casProducerIndex(lvProducerIndex, 2 + lvProducerIndex)) {
                    UnsafeRefArrayAccess.soRefElement(eArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(lvProducerIndex, j8), e8);
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
            r11 = this;
            E[] r0 = r11.consumerBuffer
            long r1 = r11.lpConsumerIndex()
            long r3 = r11.consumerMask
            long r5 = io.netty.util.internal.shaded.org.jctools.queues.LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(r1, r3)
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r0, r5)
            if (r7 != 0) goto L20
            long r8 = r11.lvProducerIndex()
            int r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r10 == 0) goto L20
        L1a:
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r0, r5)
            if (r7 == 0) goto L1a
        L20:
            java.lang.Object r5 = io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.JUMP
            if (r7 != r5) goto L2d
            java.lang.Object[] r0 = r11.nextBuffer(r0, r3)
            java.lang.Object r0 = r11.newBufferPeek(r0, r1)
            return r0
        L2d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.peek():java.lang.Object");
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
            r11 = this;
            E[] r0 = r11.consumerBuffer
            long r1 = r11.lpConsumerIndex()
            long r3 = r11.consumerMask
            long r5 = io.netty.util.internal.shaded.org.jctools.queues.LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(r1, r3)
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r0, r5)
            r8 = 0
            if (r7 != 0) goto L23
            long r9 = r11.lvProducerIndex()
            int r7 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r7 == 0) goto L22
        L1b:
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r0, r5)
            if (r7 == 0) goto L1b
            goto L23
        L22:
            return r8
        L23:
            java.lang.Object r9 = io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.JUMP
            if (r7 != r9) goto L30
            java.lang.Object[] r0 = r11.nextBuffer(r0, r3)
            java.lang.Object r0 = r11.newBufferPoll(r0, r1)
            return r0
        L30:
            io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.soRefElement(r0, r5, r8)
            r3 = 2
            long r1 = r1 + r3
            r11.soConsumerIndex(r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.poll():java.lang.Object");
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
