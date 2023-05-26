package io.netty.buffer;

import com.google.android.gms.common.api.Api;
import io.netty.buffer.PoolArena;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class PoolThreadCache {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PoolThreadCache.class);
    private int allocations;
    final PoolArena<ByteBuffer> directArena;
    private final int freeSweepAllocationThreshold;
    private final AtomicBoolean freed = new AtomicBoolean();
    final PoolArena<byte[]> heapArena;
    private final MemoryRegionCache<ByteBuffer>[] normalDirectCaches;
    private final MemoryRegionCache<byte[]>[] normalHeapCaches;
    private final int numShiftsNormalDirect;
    private final int numShiftsNormalHeap;
    private final MemoryRegionCache<ByteBuffer>[] smallSubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] smallSubPageHeapCaches;
    private final MemoryRegionCache<ByteBuffer>[] tinySubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] tinySubPageHeapCaches;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.buffer.PoolThreadCache$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        static {
            int[] iArr = new int[PoolArena.SizeClass.values().length];
            $SwitchMap$io$netty$buffer$PoolArena$SizeClass = iArr;
            try {
                iArr[PoolArena.SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[PoolArena.SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[PoolArena.SizeClass.Tiny.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class MemoryRegionCache<T> {
        private static final ObjectPool<Entry> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<Entry>() { // from class: io.netty.buffer.PoolThreadCache.MemoryRegionCache.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public Entry newObject(ObjectPool.Handle<Entry> handle) {
                return new Entry(handle);
            }
        });
        private int allocations;
        private final Queue<Entry<T>> queue;
        private final int size;
        private final PoolArena.SizeClass sizeClass;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class Entry<T> {
            PoolChunk<T> chunk;
            long handle = -1;
            ByteBuffer nioBuffer;
            final ObjectPool.Handle<Entry<?>> recyclerHandle;

            Entry(ObjectPool.Handle<Entry<?>> handle) {
                this.recyclerHandle = handle;
            }

            void recycle() {
                this.chunk = null;
                this.nioBuffer = null;
                this.handle = -1L;
                this.recyclerHandle.recycle(this);
            }
        }

        MemoryRegionCache(int i8, PoolArena.SizeClass sizeClass) {
            int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i8);
            this.size = safeFindNextPositivePowerOfTwo;
            this.queue = PlatformDependent.newFixedMpscQueue(safeFindNextPositivePowerOfTwo);
            this.sizeClass = sizeClass;
        }

        private void freeEntry(Entry entry, boolean z7) {
            PoolChunk<T> poolChunk = entry.chunk;
            long j8 = entry.handle;
            ByteBuffer byteBuffer = entry.nioBuffer;
            if (!z7) {
                entry.recycle();
            }
            poolChunk.arena.freeChunk(poolChunk, j8, this.sizeClass, byteBuffer, z7);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static Entry newEntry(PoolChunk<?> poolChunk, ByteBuffer byteBuffer, long j8) {
            Entry entry = RECYCLER.get();
            entry.chunk = poolChunk;
            entry.nioBuffer = byteBuffer;
            entry.handle = j8;
            return entry;
        }

        public final boolean add(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j8) {
            Entry<T> newEntry = newEntry(poolChunk, byteBuffer, j8);
            boolean offer = this.queue.offer(newEntry);
            if (!offer) {
                newEntry.recycle();
            }
            return offer;
        }

        public final boolean allocate(PooledByteBuf<T> pooledByteBuf, int i8) {
            Entry<T> poll = this.queue.poll();
            if (poll == null) {
                return false;
            }
            initBuf(poll.chunk, poll.nioBuffer, poll.handle, pooledByteBuf, i8);
            poll.recycle();
            this.allocations++;
            return true;
        }

        public final int free(boolean z7) {
            return free(Api.BaseClientBuilder.API_PRIORITY_OTHER, z7);
        }

        protected abstract void initBuf(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j8, PooledByteBuf<T> pooledByteBuf, int i8);

        public final void trim() {
            int i8 = this.size - this.allocations;
            this.allocations = 0;
            if (i8 > 0) {
                free(i8, false);
            }
        }

        private int free(int i8, boolean z7) {
            int i9 = 0;
            while (i9 < i8) {
                Entry<T> poll = this.queue.poll();
                if (poll == null) {
                    break;
                }
                freeEntry(poll, z7);
                i9++;
            }
            return i9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class NormalMemoryRegionCache<T> extends MemoryRegionCache<T> {
        NormalMemoryRegionCache(int i8) {
            super(i8, PoolArena.SizeClass.Normal);
        }

        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected void initBuf(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j8, PooledByteBuf<T> pooledByteBuf, int i8) {
            poolChunk.initBuf(pooledByteBuf, byteBuffer, j8, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class SubPageMemoryRegionCache<T> extends MemoryRegionCache<T> {
        SubPageMemoryRegionCache(int i8, PoolArena.SizeClass sizeClass) {
            super(i8, sizeClass);
        }

        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected void initBuf(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j8, PooledByteBuf<T> pooledByteBuf, int i8) {
            poolChunk.initBufWithSubpage(pooledByteBuf, byteBuffer, j8, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolThreadCache(PoolArena<byte[]> poolArena, PoolArena<ByteBuffer> poolArena2, int i8, int i9, int i10, int i11, int i12) {
        ObjectUtil.checkPositiveOrZero(i11, "maxCachedBufferCapacity");
        this.freeSweepAllocationThreshold = i12;
        this.heapArena = poolArena;
        this.directArena = poolArena2;
        if (poolArena2 != null) {
            this.tinySubPageDirectCaches = createSubPageCaches(i8, 32, PoolArena.SizeClass.Tiny);
            this.smallSubPageDirectCaches = createSubPageCaches(i9, poolArena2.numSmallSubpagePools, PoolArena.SizeClass.Small);
            this.numShiftsNormalDirect = log2(poolArena2.pageSize);
            this.normalDirectCaches = createNormalCaches(i10, i11, poolArena2);
            poolArena2.numThreadCaches.getAndIncrement();
        } else {
            this.tinySubPageDirectCaches = null;
            this.smallSubPageDirectCaches = null;
            this.normalDirectCaches = null;
            this.numShiftsNormalDirect = -1;
        }
        if (poolArena != null) {
            this.tinySubPageHeapCaches = createSubPageCaches(i8, 32, PoolArena.SizeClass.Tiny);
            this.smallSubPageHeapCaches = createSubPageCaches(i9, poolArena.numSmallSubpagePools, PoolArena.SizeClass.Small);
            this.numShiftsNormalHeap = log2(poolArena.pageSize);
            this.normalHeapCaches = createNormalCaches(i10, i11, poolArena);
            poolArena.numThreadCaches.getAndIncrement();
        } else {
            this.tinySubPageHeapCaches = null;
            this.smallSubPageHeapCaches = null;
            this.normalHeapCaches = null;
            this.numShiftsNormalHeap = -1;
        }
        if ((this.tinySubPageDirectCaches == null && this.smallSubPageDirectCaches == null && this.normalDirectCaches == null && this.tinySubPageHeapCaches == null && this.smallSubPageHeapCaches == null && this.normalHeapCaches == null) || i12 >= 1) {
            return;
        }
        throw new IllegalArgumentException("freeSweepAllocationThreshold: " + i12 + " (expected: > 0)");
    }

    private boolean allocate(MemoryRegionCache<?> memoryRegionCache, PooledByteBuf pooledByteBuf, int i8) {
        if (memoryRegionCache == null) {
            return false;
        }
        boolean allocate = memoryRegionCache.allocate(pooledByteBuf, i8);
        int i9 = this.allocations + 1;
        this.allocations = i9;
        if (i9 >= this.freeSweepAllocationThreshold) {
            this.allocations = 0;
            trim();
        }
        return allocate;
    }

    private MemoryRegionCache<?> cache(PoolArena<?> poolArena, int i8, PoolArena.SizeClass sizeClass) {
        int i9 = AnonymousClass1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 == 3) {
                    return cacheForTiny(poolArena, i8);
                }
                throw new Error();
            }
            return cacheForSmall(poolArena, i8);
        }
        return cacheForNormal(poolArena, i8);
    }

    private MemoryRegionCache<?> cacheForNormal(PoolArena<?> poolArena, int i8) {
        if (poolArena.isDirect()) {
            return cache(this.normalDirectCaches, log2(i8 >> this.numShiftsNormalDirect));
        }
        return cache(this.normalHeapCaches, log2(i8 >> this.numShiftsNormalHeap));
    }

    private MemoryRegionCache<?> cacheForSmall(PoolArena<?> poolArena, int i8) {
        int smallIdx = PoolArena.smallIdx(i8);
        if (poolArena.isDirect()) {
            return cache(this.smallSubPageDirectCaches, smallIdx);
        }
        return cache(this.smallSubPageHeapCaches, smallIdx);
    }

    private MemoryRegionCache<?> cacheForTiny(PoolArena<?> poolArena, int i8) {
        int tinyIdx = PoolArena.tinyIdx(i8);
        if (poolArena.isDirect()) {
            return cache(this.tinySubPageDirectCaches, tinyIdx);
        }
        return cache(this.tinySubPageHeapCaches, tinyIdx);
    }

    private static <T> MemoryRegionCache<T>[] createNormalCaches(int i8, int i9, PoolArena<T> poolArena) {
        if (i8 > 0 && i9 > 0) {
            int max = Math.max(1, log2(Math.min(poolArena.chunkSize, i9) / poolArena.pageSize) + 1);
            MemoryRegionCache<T>[] memoryRegionCacheArr = new MemoryRegionCache[max];
            for (int i10 = 0; i10 < max; i10++) {
                memoryRegionCacheArr[i10] = new NormalMemoryRegionCache(i8);
            }
            return memoryRegionCacheArr;
        }
        return null;
    }

    private static <T> MemoryRegionCache<T>[] createSubPageCaches(int i8, int i9, PoolArena.SizeClass sizeClass) {
        if (i8 > 0 && i9 > 0) {
            MemoryRegionCache<T>[] memoryRegionCacheArr = new MemoryRegionCache[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                memoryRegionCacheArr[i10] = new SubPageMemoryRegionCache(i8, sizeClass);
            }
            return memoryRegionCacheArr;
        }
        return null;
    }

    private static int log2(int i8) {
        int i9 = 0;
        while (i8 > 1) {
            i8 >>= 1;
            i9++;
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean add(PoolArena<?> poolArena, PoolChunk poolChunk, ByteBuffer byteBuffer, long j8, int i8, PoolArena.SizeClass sizeClass) {
        MemoryRegionCache<?> cache = cache(poolArena, i8, sizeClass);
        if (cache == null) {
            return false;
        }
        return cache.add(poolChunk, byteBuffer, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocateNormal(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i8, int i9) {
        return allocate(cacheForNormal(poolArena, i9), pooledByteBuf, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocateSmall(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i8, int i9) {
        return allocate(cacheForSmall(poolArena, i9), pooledByteBuf, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocateTiny(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i8, int i9) {
        return allocate(cacheForTiny(poolArena, i9), pooledByteBuf, i8);
    }

    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            free(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free(boolean z7) {
        if (this.freed.compareAndSet(false, true)) {
            int free = free(this.tinySubPageDirectCaches, z7) + free(this.smallSubPageDirectCaches, z7) + free(this.normalDirectCaches, z7) + free((MemoryRegionCache<?>[]) this.tinySubPageHeapCaches, z7) + free((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches, z7) + free((MemoryRegionCache<?>[]) this.normalHeapCaches, z7);
            if (free > 0) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Freed {} thread-local buffer(s) from thread: {}", Integer.valueOf(free), Thread.currentThread().getName());
                }
            }
            PoolArena<ByteBuffer> poolArena = this.directArena;
            if (poolArena != null) {
                poolArena.numThreadCaches.getAndDecrement();
            }
            PoolArena<byte[]> poolArena2 = this.heapArena;
            if (poolArena2 != null) {
                poolArena2.numThreadCaches.getAndDecrement();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void trim() {
        trim(this.tinySubPageDirectCaches);
        trim(this.smallSubPageDirectCaches);
        trim(this.normalDirectCaches);
        trim((MemoryRegionCache<?>[]) this.tinySubPageHeapCaches);
        trim((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches);
        trim((MemoryRegionCache<?>[]) this.normalHeapCaches);
    }

    private static <T> MemoryRegionCache<T> cache(MemoryRegionCache<T>[] memoryRegionCacheArr, int i8) {
        if (memoryRegionCacheArr == null || i8 > memoryRegionCacheArr.length - 1) {
            return null;
        }
        return memoryRegionCacheArr[i8];
    }

    private static void trim(MemoryRegionCache<?>[] memoryRegionCacheArr) {
        if (memoryRegionCacheArr == null) {
            return;
        }
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            trim(memoryRegionCache);
        }
    }

    private static void trim(MemoryRegionCache<?> memoryRegionCache) {
        if (memoryRegionCache == null) {
            return;
        }
        memoryRegionCache.trim();
    }

    private static int free(MemoryRegionCache<?>[] memoryRegionCacheArr, boolean z7) {
        if (memoryRegionCacheArr == null) {
            return 0;
        }
        int i8 = 0;
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            i8 += free(memoryRegionCache, z7);
        }
        return i8;
    }

    private static int free(MemoryRegionCache<?> memoryRegionCache, boolean z7) {
        if (memoryRegionCache == null) {
            return 0;
        }
        return memoryRegionCache.free(z7);
    }
}
