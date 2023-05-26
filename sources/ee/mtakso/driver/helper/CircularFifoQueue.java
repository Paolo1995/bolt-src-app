package ee.mtakso.driver.helper;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* loaded from: classes3.dex */
public class CircularFifoQueue<E> extends AbstractCollection<E> implements Queue<E>, Serializable {

    /* renamed from: f  reason: collision with root package name */
    private transient E[] f20928f;

    /* renamed from: g  reason: collision with root package name */
    private transient int f20929g;

    /* renamed from: h  reason: collision with root package name */
    private transient int f20930h;

    /* renamed from: i  reason: collision with root package name */
    private transient boolean f20931i;

    /* renamed from: j  reason: collision with root package name */
    private final int f20932j;

    /* renamed from: ee.mtakso.driver.helper.CircularFifoQueue$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Iterator<E>, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private int f20933f;

        /* renamed from: g  reason: collision with root package name */
        private int f20934g = -1;

        /* renamed from: h  reason: collision with root package name */
        private boolean f20935h;

        AnonymousClass1() {
            this.f20933f = CircularFifoQueue.this.f20929g;
            this.f20935h = CircularFifoQueue.this.f20931i;
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
            if (!this.f20935h && this.f20933f == CircularFifoQueue.this.f20930h) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public E next() {
            if (hasNext()) {
                this.f20935h = false;
                int i8 = this.f20933f;
                this.f20934g = i8;
                this.f20933f = CircularFifoQueue.this.r(i8);
                return (E) CircularFifoQueue.this.f20928f[this.f20934g];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            int i8 = this.f20934g;
            if (i8 != -1) {
                if (i8 == CircularFifoQueue.this.f20929g) {
                    CircularFifoQueue.this.remove();
                    this.f20934g = -1;
                    return;
                }
                int i9 = this.f20934g + 1;
                if (CircularFifoQueue.this.f20929g < this.f20934g && i9 < CircularFifoQueue.this.f20930h) {
                    System.arraycopy(CircularFifoQueue.this.f20928f, i9, CircularFifoQueue.this.f20928f, this.f20934g, CircularFifoQueue.this.f20930h - i9);
                } else {
                    while (i9 != CircularFifoQueue.this.f20930h) {
                        if (i9 >= CircularFifoQueue.this.f20932j) {
                            CircularFifoQueue.this.f20928f[i9 - 1] = CircularFifoQueue.this.f20928f[0];
                            i9 = 0;
                        } else {
                            CircularFifoQueue.this.f20928f[CircularFifoQueue.this.p(i9)] = CircularFifoQueue.this.f20928f[i9];
                            i9 = CircularFifoQueue.this.r(i9);
                        }
                    }
                }
                this.f20934g = -1;
                CircularFifoQueue circularFifoQueue = CircularFifoQueue.this;
                circularFifoQueue.f20930h = circularFifoQueue.p(circularFifoQueue.f20930h);
                CircularFifoQueue.this.f20928f[CircularFifoQueue.this.f20930h] = null;
                CircularFifoQueue.this.f20931i = false;
                this.f20933f = CircularFifoQueue.this.p(this.f20933f);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public CircularFifoQueue() {
        this(32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p(int i8) {
        int i9 = i8 - 1;
        if (i9 < 0) {
            return this.f20932j - 1;
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int r(int i8) {
        int i9 = i8 + 1;
        if (i9 >= this.f20932j) {
            return 0;
        }
        return i9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e8) {
        if (e8 != null) {
            if (s()) {
                remove();
            }
            E[] eArr = this.f20928f;
            int i8 = this.f20930h;
            int i9 = i8 + 1;
            this.f20930h = i9;
            eArr[i8] = e8;
            if (i9 >= this.f20932j) {
                this.f20930h = 0;
            }
            if (this.f20930h == this.f20929g) {
                this.f20931i = true;
            }
            return true;
        }
        throw new NullPointerException("Attempted to add null object to queue");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f20931i = false;
        this.f20929g = 0;
        this.f20930h = 0;
        Arrays.fill(this.f20928f, (Object) null);
    }

    @Override // java.util.Queue
    public E element() {
        if (!isEmpty()) {
            return peek();
        }
        throw new NoSuchElementException("queue is empty");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public java.util.Iterator<E> iterator() {
        return new AnonymousClass1();
    }

    @Override // java.util.Queue
    public boolean offer(E e8) {
        return add(e8);
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.f20928f[this.f20929g];
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public E remove() {
        if (!isEmpty()) {
            E[] eArr = this.f20928f;
            int i8 = this.f20929g;
            E e8 = eArr[i8];
            if (e8 != null) {
                int i9 = i8 + 1;
                this.f20929g = i9;
                eArr[i8] = null;
                if (i9 >= this.f20932j) {
                    this.f20929g = 0;
                }
                this.f20931i = false;
            }
            return e8;
        }
        throw new NoSuchElementException("queue is empty");
    }

    public boolean s() {
        if (size() == this.f20932j) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i8 = this.f20930h;
        int i9 = this.f20929g;
        if (i8 < i9) {
            return (this.f20932j - i9) + i8;
        }
        if (i8 == i9) {
            if (this.f20931i) {
                return this.f20932j;
            }
            return 0;
        }
        return i8 - i9;
    }

    public CircularFifoQueue(int i8) {
        this.f20929g = 0;
        this.f20930h = 0;
        this.f20931i = false;
        if (i8 > 0) {
            E[] eArr = (E[]) new Object[i8];
            this.f20928f = eArr;
            this.f20932j = eArr.length;
            return;
        }
        throw new IllegalArgumentException("The size must be greater than 0");
    }
}
