package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j$.util.Spliterator;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public abstract class Recycler<T> {
    private static final int DEFAULT_MAX_CAPACITY_PER_THREAD;
    private static final FastThreadLocal<Map<Stack<?>, WeakOrderQueue>> DELAYED_RECYCLED;
    private static final AtomicInteger ID_GENERATOR;
    private static final int INITIAL_CAPACITY;
    private static final int LINK_CAPACITY;
    private static final int MAX_DELAYED_QUEUES_PER_THREAD;
    private static final int MAX_SHARED_CAPACITY_FACTOR;
    private static final Handle NOOP_HANDLE;
    private static final int OWN_THREAD_ID;
    private static final int RATIO;
    private static final InternalLogger logger;
    private final int interval;
    private final int maxCapacityPerThread;
    private final int maxDelayedQueuesPerThread;
    private final int maxSharedCapacityFactor;
    private final FastThreadLocal<Stack<T>> threadLocal;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class DefaultHandle<T> implements Handle<T> {
        boolean hasBeenRecycled;
        int lastRecycledId;
        int recycleId;
        Stack<?> stack;
        Object value;

        DefaultHandle(Stack<?> stack) {
            this.stack = stack;
        }

        @Override // io.netty.util.internal.ObjectPool.Handle
        public void recycle(Object obj) {
            if (obj == this.value) {
                Stack<?> stack = this.stack;
                if (this.lastRecycledId == this.recycleId && stack != null) {
                    stack.push(this);
                    return;
                }
                throw new IllegalStateException("recycled already");
            }
            throw new IllegalArgumentException("object does not belong to handle");
        }
    }

    /* loaded from: classes5.dex */
    public interface Handle<T> extends ObjectPool.Handle<T> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Stack<T> {
        final AtomicInteger availableSharedCapacity;
        private WeakOrderQueue cursor;
        DefaultHandle<?>[] elements;
        private int handleRecycleCount;
        private volatile WeakOrderQueue head;
        private final int interval;
        private final int maxCapacity;
        private final int maxDelayedQueues;
        final Recycler<T> parent;
        private WeakOrderQueue prev;
        int size;
        final WeakReference<Thread> threadRef;

        Stack(Recycler<T> recycler, Thread thread, int i8, int i9, int i10, int i11) {
            this.parent = recycler;
            this.threadRef = new WeakReference<>(thread);
            this.maxCapacity = i8;
            this.availableSharedCapacity = new AtomicInteger(Math.max(i8 / i9, Recycler.LINK_CAPACITY));
            this.elements = new DefaultHandle[Math.min(Recycler.INITIAL_CAPACITY, i8)];
            this.interval = i10;
            this.handleRecycleCount = i10;
            this.maxDelayedQueues = i11;
        }

        private WeakOrderQueue newWeakOrderQueue(Thread thread) {
            return WeakOrderQueue.newQueue(this, thread);
        }

        private void pushLater(DefaultHandle<?> defaultHandle, Thread thread) {
            if (this.maxDelayedQueues == 0) {
                return;
            }
            Map map = (Map) Recycler.DELAYED_RECYCLED.get();
            WeakOrderQueue weakOrderQueue = (WeakOrderQueue) map.get(this);
            if (weakOrderQueue == null) {
                if (map.size() >= this.maxDelayedQueues) {
                    map.put(this, WeakOrderQueue.DUMMY);
                    return;
                }
                weakOrderQueue = newWeakOrderQueue(thread);
                if (weakOrderQueue == null) {
                    return;
                }
                map.put(this, weakOrderQueue);
            } else if (weakOrderQueue == WeakOrderQueue.DUMMY) {
                return;
            }
            weakOrderQueue.add(defaultHandle);
        }

        private void pushNow(DefaultHandle<?> defaultHandle) {
            if ((defaultHandle.recycleId | defaultHandle.lastRecycledId) == 0) {
                int i8 = Recycler.OWN_THREAD_ID;
                defaultHandle.lastRecycledId = i8;
                defaultHandle.recycleId = i8;
                int i9 = this.size;
                if (i9 < this.maxCapacity && !dropHandle(defaultHandle)) {
                    DefaultHandle<?>[] defaultHandleArr = this.elements;
                    if (i9 == defaultHandleArr.length) {
                        this.elements = (DefaultHandle[]) Arrays.copyOf(defaultHandleArr, Math.min(i9 << 1, this.maxCapacity));
                    }
                    this.elements[i9] = defaultHandle;
                    this.size = i9 + 1;
                    return;
                }
                return;
            }
            throw new IllegalStateException("recycled already");
        }

        private boolean scavenge() {
            if (scavengeSome()) {
                return true;
            }
            this.prev = null;
            this.cursor = this.head;
            return false;
        }

        private boolean scavengeSome() {
            WeakOrderQueue weakOrderQueue;
            boolean z7;
            WeakOrderQueue next;
            WeakOrderQueue weakOrderQueue2 = this.cursor;
            boolean z8 = false;
            if (weakOrderQueue2 == null) {
                WeakOrderQueue weakOrderQueue3 = this.head;
                if (weakOrderQueue3 == null) {
                    return false;
                }
                weakOrderQueue = null;
                weakOrderQueue2 = weakOrderQueue3;
            } else {
                weakOrderQueue = this.prev;
            }
            while (true) {
                z7 = true;
                if (weakOrderQueue2.transfer(this)) {
                    break;
                }
                next = weakOrderQueue2.getNext();
                if (weakOrderQueue2.get() == null) {
                    if (weakOrderQueue2.hasFinalData()) {
                        while (weakOrderQueue2.transfer(this)) {
                            z8 = true;
                        }
                    }
                    if (weakOrderQueue != null) {
                        weakOrderQueue2.reclaimAllSpaceAndUnlink();
                        weakOrderQueue.setNext(next);
                    }
                } else {
                    weakOrderQueue = weakOrderQueue2;
                }
                if (next == null || z8) {
                    break;
                }
                weakOrderQueue2 = next;
            }
            z7 = z8;
            weakOrderQueue2 = next;
            this.prev = weakOrderQueue;
            this.cursor = weakOrderQueue2;
            return z7;
        }

        boolean dropHandle(DefaultHandle<?> defaultHandle) {
            if (!defaultHandle.hasBeenRecycled) {
                int i8 = this.handleRecycleCount;
                if (i8 < this.interval) {
                    this.handleRecycleCount = i8 + 1;
                    return true;
                }
                this.handleRecycleCount = 0;
                defaultHandle.hasBeenRecycled = true;
            }
            return false;
        }

        int increaseCapacity(int i8) {
            int length = this.elements.length;
            int i9 = this.maxCapacity;
            do {
                length <<= 1;
                if (length >= i8) {
                    break;
                }
            } while (length < i9);
            int min = Math.min(length, i9);
            DefaultHandle<?>[] defaultHandleArr = this.elements;
            if (min != defaultHandleArr.length) {
                this.elements = (DefaultHandle[]) Arrays.copyOf(defaultHandleArr, min);
            }
            return min;
        }

        DefaultHandle<T> newHandle() {
            return new DefaultHandle<>(this);
        }

        DefaultHandle<T> pop() {
            int i8 = this.size;
            if (i8 == 0 && (!scavenge() || (i8 = this.size) <= 0)) {
                return null;
            }
            int i9 = i8 - 1;
            DefaultHandle<?>[] defaultHandleArr = this.elements;
            DefaultHandle<T> defaultHandle = (DefaultHandle<T>) defaultHandleArr[i9];
            defaultHandleArr[i9] = null;
            this.size = i9;
            if (defaultHandle.lastRecycledId == defaultHandle.recycleId) {
                defaultHandle.recycleId = 0;
                defaultHandle.lastRecycledId = 0;
                return defaultHandle;
            }
            throw new IllegalStateException("recycled multiple times");
        }

        void push(DefaultHandle<?> defaultHandle) {
            Thread currentThread = Thread.currentThread();
            if (this.threadRef.get() == currentThread) {
                pushNow(defaultHandle);
            } else {
                pushLater(defaultHandle, currentThread);
            }
        }

        synchronized void setHead(WeakOrderQueue weakOrderQueue) {
            weakOrderQueue.setNext(this.head);
            this.head = weakOrderQueue;
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(Recycler.class);
        logger = internalLoggerFactory;
        NOOP_HANDLE = new Handle() { // from class: io.netty.util.Recycler.1
            @Override // io.netty.util.internal.ObjectPool.Handle
            public void recycle(Object obj) {
            }
        };
        AtomicInteger atomicInteger = new AtomicInteger(Integer.MIN_VALUE);
        ID_GENERATOR = atomicInteger;
        OWN_THREAD_ID = atomicInteger.getAndIncrement();
        int i8 = 4096;
        int i9 = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 4096));
        if (i9 >= 0) {
            i8 = i9;
        }
        DEFAULT_MAX_CAPACITY_PER_THREAD = i8;
        int max = Math.max(2, SystemPropertyUtil.getInt("io.netty.recycler.maxSharedCapacityFactor", 2));
        MAX_SHARED_CAPACITY_FACTOR = max;
        MAX_DELAYED_QUEUES_PER_THREAD = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.maxDelayedQueuesPerThread", NettyRuntime.availableProcessors() * 2));
        int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(Math.max(SystemPropertyUtil.getInt("io.netty.recycler.linkCapacity", 16), 16));
        LINK_CAPACITY = safeFindNextPositivePowerOfTwo;
        int safeFindNextPositivePowerOfTwo2 = MathUtil.safeFindNextPositivePowerOfTwo(SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
        RATIO = safeFindNextPositivePowerOfTwo2;
        if (internalLoggerFactory.isDebugEnabled()) {
            if (i8 == 0) {
                internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.maxSharedCapacityFactor: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.linkCapacity: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.ratio: disabled");
            } else {
                internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", Integer.valueOf(i8));
                internalLoggerFactory.debug("-Dio.netty.recycler.maxSharedCapacityFactor: {}", Integer.valueOf(max));
                internalLoggerFactory.debug("-Dio.netty.recycler.linkCapacity: {}", Integer.valueOf(safeFindNextPositivePowerOfTwo));
                internalLoggerFactory.debug("-Dio.netty.recycler.ratio: {}", Integer.valueOf(safeFindNextPositivePowerOfTwo2));
            }
        }
        INITIAL_CAPACITY = Math.min(i8, (int) Spliterator.NONNULL);
        DELAYED_RECYCLED = new FastThreadLocal<Map<Stack<?>, WeakOrderQueue>>() { // from class: io.netty.util.Recycler.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public Map<Stack<?>, WeakOrderQueue> initialValue() {
                return new WeakHashMap();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Recycler() {
        this(DEFAULT_MAX_CAPACITY_PER_THREAD);
    }

    public final T get() {
        if (this.maxCapacityPerThread == 0) {
            return newObject(NOOP_HANDLE);
        }
        Stack<T> stack = this.threadLocal.get();
        DefaultHandle<T> pop = stack.pop();
        if (pop == null) {
            pop = stack.newHandle();
            pop.value = newObject(pop);
        }
        return (T) pop.value;
    }

    protected abstract T newObject(Handle<T> handle);

    protected Recycler(int i8) {
        this(i8, MAX_SHARED_CAPACITY_FACTOR);
    }

    protected Recycler(int i8, int i9) {
        this(i8, i9, RATIO, MAX_DELAYED_QUEUES_PER_THREAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class WeakOrderQueue extends WeakReference<Thread> {
        static final WeakOrderQueue DUMMY = new WeakOrderQueue();
        private int handleRecycleCount;
        private final Head head;
        private final int id;
        private final int interval;
        private WeakOrderQueue next;
        private Link tail;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class Head {
            private final AtomicInteger availableSharedCapacity;
            Link link;

            Head(AtomicInteger atomicInteger) {
                this.availableSharedCapacity = atomicInteger;
            }

            private void reclaimSpace(int i8) {
                this.availableSharedCapacity.addAndGet(i8);
            }

            static boolean reserveSpaceForLink(AtomicInteger atomicInteger) {
                int i8;
                do {
                    i8 = atomicInteger.get();
                    if (i8 < Recycler.LINK_CAPACITY) {
                        return false;
                    }
                } while (!atomicInteger.compareAndSet(i8, i8 - Recycler.LINK_CAPACITY));
                return true;
            }

            Link newLink() {
                if (reserveSpaceForLink(this.availableSharedCapacity)) {
                    return new Link();
                }
                return null;
            }

            void reclaimAllSpaceAndUnlink() {
                Link link = this.link;
                this.link = null;
                int i8 = 0;
                while (link != null) {
                    i8 += Recycler.LINK_CAPACITY;
                    Link link2 = link.next;
                    link.next = null;
                    link = link2;
                }
                if (i8 > 0) {
                    reclaimSpace(i8);
                }
            }

            void relink(Link link) {
                reclaimSpace(Recycler.LINK_CAPACITY);
                this.link = link;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class Link extends AtomicInteger {
            final DefaultHandle<?>[] elements = new DefaultHandle[Recycler.LINK_CAPACITY];
            Link next;
            int readIndex;

            Link() {
            }
        }

        private WeakOrderQueue() {
            super(null);
            this.id = Recycler.ID_GENERATOR.getAndIncrement();
            this.head = new Head(null);
            this.interval = 0;
        }

        static WeakOrderQueue newQueue(Stack<?> stack, Thread thread) {
            if (!Head.reserveSpaceForLink(stack.availableSharedCapacity)) {
                return null;
            }
            WeakOrderQueue weakOrderQueue = new WeakOrderQueue(stack, thread);
            stack.setHead(weakOrderQueue);
            return weakOrderQueue;
        }

        void add(DefaultHandle<?> defaultHandle) {
            defaultHandle.lastRecycledId = this.id;
            int i8 = this.handleRecycleCount;
            if (i8 < this.interval) {
                this.handleRecycleCount = i8 + 1;
                return;
            }
            this.handleRecycleCount = 0;
            Link link = this.tail;
            int i9 = link.get();
            if (i9 == Recycler.LINK_CAPACITY) {
                Link newLink = this.head.newLink();
                if (newLink == null) {
                    return;
                }
                link.next = newLink;
                this.tail = newLink;
                i9 = newLink.get();
                link = newLink;
            }
            link.elements[i9] = defaultHandle;
            defaultHandle.stack = null;
            link.lazySet(i9 + 1);
        }

        WeakOrderQueue getNext() {
            return this.next;
        }

        boolean hasFinalData() {
            Link link = this.tail;
            if (link.readIndex != link.get()) {
                return true;
            }
            return false;
        }

        void reclaimAllSpaceAndUnlink() {
            this.head.reclaimAllSpaceAndUnlink();
            this.next = null;
        }

        void setNext(WeakOrderQueue weakOrderQueue) {
            this.next = weakOrderQueue;
        }

        boolean transfer(Stack<?> stack) {
            Link link;
            Link link2 = this.head.link;
            if (link2 == null) {
                return false;
            }
            if (link2.readIndex == Recycler.LINK_CAPACITY) {
                link2 = link2.next;
                if (link2 == null) {
                    return false;
                }
                this.head.relink(link2);
            }
            int i8 = link2.readIndex;
            int i9 = link2.get();
            int i10 = i9 - i8;
            if (i10 == 0) {
                return false;
            }
            int i11 = stack.size;
            int i12 = i10 + i11;
            if (i12 > stack.elements.length) {
                i9 = Math.min((stack.increaseCapacity(i12) + i8) - i11, i9);
            }
            if (i8 == i9) {
                return false;
            }
            DefaultHandle<?>[] defaultHandleArr = link2.elements;
            DefaultHandle<?>[] defaultHandleArr2 = stack.elements;
            while (i8 < i9) {
                DefaultHandle<?> defaultHandle = defaultHandleArr[i8];
                int i13 = defaultHandle.recycleId;
                if (i13 == 0) {
                    defaultHandle.recycleId = defaultHandle.lastRecycledId;
                } else if (i13 != defaultHandle.lastRecycledId) {
                    throw new IllegalStateException("recycled already");
                }
                defaultHandleArr[i8] = null;
                if (!stack.dropHandle(defaultHandle)) {
                    defaultHandle.stack = stack;
                    defaultHandleArr2[i11] = defaultHandle;
                    i11++;
                }
                i8++;
            }
            if (i9 == Recycler.LINK_CAPACITY && (link = link2.next) != null) {
                this.head.relink(link);
            }
            link2.readIndex = i9;
            if (stack.size == i11) {
                return false;
            }
            stack.size = i11;
            return true;
        }

        private WeakOrderQueue(Stack<?> stack, Thread thread) {
            super(thread);
            this.id = Recycler.ID_GENERATOR.getAndIncrement();
            this.tail = new Link();
            Head head = new Head(stack.availableSharedCapacity);
            this.head = head;
            head.link = this.tail;
            int i8 = ((Stack) stack).interval;
            this.interval = i8;
            this.handleRecycleCount = i8;
        }
    }

    protected Recycler(int i8, int i9, int i10, int i11) {
        this.threadLocal = new FastThreadLocal<Stack<T>>() { // from class: io.netty.util.Recycler.2
            @Override // io.netty.util.concurrent.FastThreadLocal
            protected /* bridge */ /* synthetic */ void onRemoval(Object obj) throws Exception {
                onRemoval((Stack) ((Stack) obj));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public Stack<T> initialValue() {
                return new Stack<>(Recycler.this, Thread.currentThread(), Recycler.this.maxCapacityPerThread, Recycler.this.maxSharedCapacityFactor, Recycler.this.interval, Recycler.this.maxDelayedQueuesPerThread);
            }

            protected void onRemoval(Stack<T> stack) {
                if (stack.threadRef.get() == Thread.currentThread() && Recycler.DELAYED_RECYCLED.isSet()) {
                    ((Map) Recycler.DELAYED_RECYCLED.get()).remove(stack);
                }
            }
        };
        this.interval = MathUtil.safeFindNextPositivePowerOfTwo(i10);
        if (i8 <= 0) {
            this.maxCapacityPerThread = 0;
            this.maxSharedCapacityFactor = 1;
            this.maxDelayedQueuesPerThread = 0;
            return;
        }
        this.maxCapacityPerThread = i8;
        this.maxSharedCapacityFactor = Math.max(1, i9);
        this.maxDelayedQueuesPerThread = Math.max(0, i11);
    }
}
