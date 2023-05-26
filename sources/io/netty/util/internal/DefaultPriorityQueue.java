package io.netty.util.internal;

import io.netty.util.internal.PriorityQueueNode;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public final class DefaultPriorityQueue<T extends PriorityQueueNode> extends AbstractQueue<T> implements PriorityQueue<T> {
    private static final PriorityQueueNode[] EMPTY_ARRAY = new PriorityQueueNode[0];
    private final Comparator<T> comparator;
    private T[] queue;
    private int size;

    /* loaded from: classes5.dex */
    private final class PriorityQueueIterator implements Iterator<T>, j$.util.Iterator {
        private int index;

        private PriorityQueueIterator() {
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
            if (this.index < DefaultPriorityQueue.this.size) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public T next() {
            if (this.index < DefaultPriorityQueue.this.size) {
                PriorityQueueNode[] priorityQueueNodeArr = DefaultPriorityQueue.this.queue;
                int i8 = this.index;
                this.index = i8 + 1;
                return (T) priorityQueueNodeArr[i8];
            }
            throw new NoSuchElementException();
        }
    }

    public DefaultPriorityQueue(Comparator<T> comparator, int i8) {
        PriorityQueueNode[] priorityQueueNodeArr;
        this.comparator = (Comparator) ObjectUtil.checkNotNull(comparator, "comparator");
        if (i8 != 0) {
            priorityQueueNodeArr = new PriorityQueueNode[i8];
        } else {
            priorityQueueNodeArr = EMPTY_ARRAY;
        }
        this.queue = (T[]) priorityQueueNodeArr;
    }

    private void bubbleDown(int i8, T t7) {
        int i9 = this.size >>> 1;
        while (i8 < i9) {
            int i10 = (i8 << 1) + 1;
            T[] tArr = this.queue;
            T t8 = tArr[i10];
            int i11 = i10 + 1;
            if (i11 < this.size && this.comparator.compare(t8, tArr[i11]) > 0) {
                t8 = this.queue[i11];
                i10 = i11;
            }
            if (this.comparator.compare(t7, t8) <= 0) {
                break;
            }
            this.queue[i8] = t8;
            t8.priorityQueueIndex(this, i8);
            i8 = i10;
        }
        this.queue[i8] = t7;
        t7.priorityQueueIndex(this, i8);
    }

    private void bubbleUp(int i8, T t7) {
        while (i8 > 0) {
            int i9 = (i8 - 1) >>> 1;
            T t8 = this.queue[i9];
            if (this.comparator.compare(t7, t8) >= 0) {
                break;
            }
            this.queue[i8] = t8;
            t8.priorityQueueIndex(this, i8);
            i8 = i9;
        }
        this.queue[i8] = t7;
        t7.priorityQueueIndex(this, i8);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i8 = 0; i8 < this.size; i8++) {
            T t7 = this.queue[i8];
            if (t7 != null) {
                t7.priorityQueueIndex(this, -1);
                this.queue[i8] = null;
            }
        }
        this.size = 0;
    }

    @Override // io.netty.util.internal.PriorityQueue
    public void clearIgnoringIndexes() {
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj instanceof PriorityQueueNode) {
            PriorityQueueNode priorityQueueNode = (PriorityQueueNode) obj;
            return contains(priorityQueueNode, priorityQueueNode.priorityQueueIndex(this));
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        return new PriorityQueueIterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue
    public /* bridge */ /* synthetic */ boolean offer(Object obj) {
        return offer((DefaultPriorityQueue<T>) ((PriorityQueueNode) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        try {
            return removeTyped((DefaultPriorityQueue<T>) ((PriorityQueueNode) obj));
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.PriorityQueue
    public /* bridge */ /* synthetic */ boolean removeTyped(Object obj) {
        return removeTyped((DefaultPriorityQueue<T>) ((PriorityQueueNode) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return Arrays.copyOf(this.queue, this.size);
    }

    public boolean offer(T t7) {
        if (t7.priorityQueueIndex(this) == -1) {
            int i8 = this.size;
            T[] tArr = this.queue;
            if (i8 >= tArr.length) {
                this.queue = (T[]) ((PriorityQueueNode[]) Arrays.copyOf(tArr, tArr.length + (tArr.length < 64 ? tArr.length + 2 : tArr.length >>> 1)));
            }
            int i9 = this.size;
            this.size = i9 + 1;
            bubbleUp(i9, t7);
            return true;
        }
        throw new IllegalArgumentException("e.priorityQueueIndex(): " + t7.priorityQueueIndex(this) + " (expected: -1) + e: " + t7);
    }

    @Override // java.util.Queue
    public T peek() {
        if (this.size == 0) {
            return null;
        }
        return this.queue[0];
    }

    @Override // java.util.Queue
    public T poll() {
        if (this.size == 0) {
            return null;
        }
        T t7 = this.queue[0];
        t7.priorityQueueIndex(this, -1);
        T[] tArr = this.queue;
        int i8 = this.size - 1;
        this.size = i8;
        T t8 = tArr[i8];
        tArr[i8] = null;
        if (i8 != 0) {
            bubbleDown(0, t8);
        }
        return t7;
    }

    public boolean removeTyped(T t7) {
        int priorityQueueIndex = t7.priorityQueueIndex(this);
        if (contains(t7, priorityQueueIndex)) {
            t7.priorityQueueIndex(this, -1);
            int i8 = this.size - 1;
            this.size = i8;
            if (i8 != 0 && i8 != priorityQueueIndex) {
                T[] tArr = this.queue;
                T t8 = tArr[i8];
                tArr[priorityQueueIndex] = t8;
                tArr[i8] = null;
                if (this.comparator.compare(t7, t8) < 0) {
                    bubbleDown(priorityQueueIndex, t8);
                } else {
                    bubbleUp(priorityQueueIndex, t8);
                }
                return true;
            }
            this.queue[priorityQueueIndex] = null;
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <X> X[] toArray(X[] xArr) {
        int length = xArr.length;
        int i8 = this.size;
        if (length < i8) {
            return (X[]) Arrays.copyOf(this.queue, i8, xArr.getClass());
        }
        System.arraycopy(this.queue, 0, xArr, 0, i8);
        int length2 = xArr.length;
        int i9 = this.size;
        if (length2 > i9) {
            xArr[i9] = null;
        }
        return xArr;
    }

    private boolean contains(PriorityQueueNode priorityQueueNode, int i8) {
        return i8 >= 0 && i8 < this.size && priorityQueueNode.equals(this.queue[i8]);
    }
}
