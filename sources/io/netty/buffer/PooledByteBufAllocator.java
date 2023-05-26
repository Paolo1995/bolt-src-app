package io.netty.buffer;

import androidx.fragment.app.FragmentTransaction;
import io.netty.buffer.PoolArena;
import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j$.util.Spliterator;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jctools.util.Pow2;

/* loaded from: classes5.dex */
public class PooledByteBufAllocator extends AbstractByteBufAllocator {
    public static final PooledByteBufAllocator DEFAULT;
    private static final int DEFAULT_CACHE_TRIM_INTERVAL;
    private static final long DEFAULT_CACHE_TRIM_INTERVAL_MILLIS;
    private static final int DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT;
    private static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
    static final int DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK;
    private static final int DEFAULT_MAX_ORDER;
    private static final int DEFAULT_NORMAL_CACHE_SIZE;
    private static final int DEFAULT_NUM_DIRECT_ARENA;
    private static final int DEFAULT_NUM_HEAP_ARENA;
    private static final int DEFAULT_PAGE_SIZE;
    private static final int DEFAULT_SMALL_CACHE_SIZE;
    private static final int DEFAULT_TINY_CACHE_SIZE;
    private static final boolean DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PooledByteBufAllocator.class);
    private final int chunkSize;
    private final List<Object> directArenaMetrics;
    private final PoolArena<ByteBuffer>[] directArenas;
    private final List<Object> heapArenaMetrics;
    private final PoolArena<byte[]>[] heapArenas;
    private final PooledByteBufAllocatorMetric metric;
    private final int normalCacheSize;
    private final int smallCacheSize;
    private final PoolThreadLocalCache threadCache;
    private final int tinyCacheSize;
    private final Runnable trimTask;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class PoolThreadLocalCache extends FastThreadLocal<PoolThreadCache> {
        private final boolean useCacheForAllThreads;

        PoolThreadLocalCache(boolean z7) {
            this.useCacheForAllThreads = z7;
        }

        private <T> PoolArena<T> leastUsedArena(PoolArena<T>[] poolArenaArr) {
            if (poolArenaArr != null && poolArenaArr.length != 0) {
                PoolArena<T> poolArena = poolArenaArr[0];
                for (int i8 = 1; i8 < poolArenaArr.length; i8++) {
                    PoolArena<T> poolArena2 = poolArenaArr[i8];
                    if (poolArena2.numThreadCaches.get() < poolArena.numThreadCaches.get()) {
                        poolArena = poolArena2;
                    }
                }
                return poolArena;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public synchronized PoolThreadCache initialValue() {
            EventExecutor currentExecutor;
            PoolArena leastUsedArena = leastUsedArena(PooledByteBufAllocator.this.heapArenas);
            PoolArena leastUsedArena2 = leastUsedArena(PooledByteBufAllocator.this.directArenas);
            Thread currentThread = Thread.currentThread();
            if (!this.useCacheForAllThreads && !(currentThread instanceof FastThreadLocalThread)) {
                return new PoolThreadCache(leastUsedArena, leastUsedArena2, 0, 0, 0, 0, 0);
            }
            PoolThreadCache poolThreadCache = new PoolThreadCache(leastUsedArena, leastUsedArena2, PooledByteBufAllocator.this.tinyCacheSize, PooledByteBufAllocator.this.smallCacheSize, PooledByteBufAllocator.this.normalCacheSize, PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL);
            if (PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS > 0 && (currentExecutor = ThreadExecutorMap.currentExecutor()) != null) {
                currentExecutor.scheduleAtFixedRate(PooledByteBufAllocator.this.trimTask, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
            }
            return poolThreadCache;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public void onRemoval(PoolThreadCache poolThreadCache) {
            poolThreadCache.free(false);
        }
    }

    static {
        Object obj;
        int i8 = SystemPropertyUtil.getInt("io.netty.allocator.pageSize", FragmentTransaction.TRANSIT_EXIT_MASK);
        Object obj2 = null;
        try {
            validateAndCalculatePageShifts(i8);
            obj = null;
        } catch (Throwable th) {
            obj = th;
            i8 = FragmentTransaction.TRANSIT_EXIT_MASK;
        }
        DEFAULT_PAGE_SIZE = i8;
        int i9 = 11;
        int i10 = SystemPropertyUtil.getInt("io.netty.allocator.maxOrder", 11);
        try {
            validateAndCalculateChunkSize(i8, i10);
            i9 = i10;
        } catch (Throwable th2) {
            obj2 = th2;
        }
        DEFAULT_MAX_ORDER = i9;
        Runtime runtime = Runtime.getRuntime();
        int i11 = DEFAULT_PAGE_SIZE;
        long availableProcessors = NettyRuntime.availableProcessors() * 2;
        long j8 = i11 << i9;
        int max = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numHeapArenas", (int) Math.min(availableProcessors, ((runtime.maxMemory() / j8) / 2) / 3)));
        DEFAULT_NUM_HEAP_ARENA = max;
        int max2 = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numDirectArenas", (int) Math.min(availableProcessors, ((PlatformDependent.maxDirectMemory() / j8) / 2) / 3)));
        DEFAULT_NUM_DIRECT_ARENA = max2;
        int i12 = SystemPropertyUtil.getInt("io.netty.allocator.tinyCacheSize", 512);
        DEFAULT_TINY_CACHE_SIZE = i12;
        int i13 = SystemPropertyUtil.getInt("io.netty.allocator.smallCacheSize", Spliterator.NONNULL);
        DEFAULT_SMALL_CACHE_SIZE = i13;
        int i14 = SystemPropertyUtil.getInt("io.netty.allocator.normalCacheSize", 64);
        DEFAULT_NORMAL_CACHE_SIZE = i14;
        int i15 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedBufferCapacity", 32768);
        DEFAULT_MAX_CACHED_BUFFER_CAPACITY = i15;
        int i16 = SystemPropertyUtil.getInt("io.netty.allocator.cacheTrimInterval", FragmentTransaction.TRANSIT_EXIT_MASK);
        DEFAULT_CACHE_TRIM_INTERVAL = i16;
        if (SystemPropertyUtil.contains("io.netty.allocation.cacheTrimIntervalMillis")) {
            logger.warn("-Dio.netty.allocation.cacheTrimIntervalMillis is deprecated, use -Dio.netty.allocator.cacheTrimIntervalMillis");
            if (SystemPropertyUtil.contains("io.netty.allocator.cacheTrimIntervalMillis")) {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0L);
            } else {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocation.cacheTrimIntervalMillis", 0L);
            }
        } else {
            DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0L);
        }
        boolean z7 = SystemPropertyUtil.getBoolean("io.netty.allocator.useCacheForAllThreads", true);
        DEFAULT_USE_CACHE_FOR_ALL_THREADS = z7;
        DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = SystemPropertyUtil.getInt("io.netty.allocator.directMemoryCacheAlignment", 0);
        int i17 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedByteBuffersPerChunk", 1023);
        DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK = i17;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.allocator.numHeapArenas: {}", Integer.valueOf(max));
            internalLogger.debug("-Dio.netty.allocator.numDirectArenas: {}", Integer.valueOf(max2));
            if (obj == null) {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i11));
            } else {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i11), obj);
            }
            if (obj2 == null) {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i9));
            } else {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i9), obj2);
            }
            internalLogger.debug("-Dio.netty.allocator.chunkSize: {}", Integer.valueOf(i11 << i9));
            internalLogger.debug("-Dio.netty.allocator.tinyCacheSize: {}", Integer.valueOf(i12));
            internalLogger.debug("-Dio.netty.allocator.smallCacheSize: {}", Integer.valueOf(i13));
            internalLogger.debug("-Dio.netty.allocator.normalCacheSize: {}", Integer.valueOf(i14));
            internalLogger.debug("-Dio.netty.allocator.maxCachedBufferCapacity: {}", Integer.valueOf(i15));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimInterval: {}", Integer.valueOf(i16));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimIntervalMillis: {}", Long.valueOf(DEFAULT_CACHE_TRIM_INTERVAL_MILLIS));
            internalLogger.debug("-Dio.netty.allocator.useCacheForAllThreads: {}", Boolean.valueOf(z7));
            internalLogger.debug("-Dio.netty.allocator.maxCachedByteBuffersPerChunk: {}", Integer.valueOf(i17));
        }
        DEFAULT = new PooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    }

    public PooledByteBufAllocator() {
        this(false);
    }

    public static boolean isDirectMemoryCacheAlignmentSupported() {
        return PlatformDependent.hasUnsafe();
    }

    private static <T> PoolArena<T>[] newArenaArray(int i8) {
        return new PoolArena[i8];
    }

    private static long usedMemory(PoolArena<?>[] poolArenaArr) {
        if (poolArenaArr == null) {
            return -1L;
        }
        long j8 = 0;
        for (PoolArena<?> poolArena : poolArenaArr) {
            j8 += poolArena.numActiveBytes();
            if (j8 < 0) {
                return Long.MAX_VALUE;
            }
        }
        return j8;
    }

    private static int validateAndCalculateChunkSize(int i8, int i9) {
        if (i9 <= 14) {
            int i10 = i8;
            for (int i11 = i9; i11 > 0; i11--) {
                if (i10 <= 536870912) {
                    i10 <<= 1;
                } else {
                    throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf((int) Pow2.MAX_POW2)));
                }
            }
            return i10;
        }
        throw new IllegalArgumentException("maxOrder: " + i9 + " (expected: 0-14)");
    }

    private static int validateAndCalculatePageShifts(int i8) {
        if (i8 >= 4096) {
            if (((i8 - 1) & i8) == 0) {
                return 31 - Integer.numberOfLeadingZeros(i8);
            }
            throw new IllegalArgumentException("pageSize: " + i8 + " (expected: power of 2)");
        }
        throw new IllegalArgumentException("pageSize: " + i8 + " (expected: 4096)");
    }

    @Deprecated
    public final int chunkSize() {
        return this.chunkSize;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        if (this.directArenas != null) {
            return true;
        }
        return false;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int i8, int i9) {
        ByteBuf unpooledDirectByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<ByteBuffer> poolArena = poolThreadCache.directArena;
        if (poolArena != null) {
            unpooledDirectByteBuf = poolArena.allocate(poolThreadCache, i8, i9);
        } else if (PlatformDependent.hasUnsafe()) {
            unpooledDirectByteBuf = UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, i8, i9);
        } else {
            unpooledDirectByteBuf = new UnpooledDirectByteBuf(this, i8, i9);
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(unpooledDirectByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int i8, int i9) {
        AbstractByteBuf unpooledHeapByteBuf;
        AbstractByteBuf abstractByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<byte[]> poolArena = poolThreadCache.heapArena;
        if (poolArena != null) {
            abstractByteBuf = poolArena.allocate(poolThreadCache, i8, i9);
        } else {
            if (PlatformDependent.hasUnsafe()) {
                unpooledHeapByteBuf = new UnpooledUnsafeHeapByteBuf(this, i8, i9);
            } else {
                unpooledHeapByteBuf = new UnpooledHeapByteBuf(this, i8, i9);
            }
            abstractByteBuf = unpooledHeapByteBuf;
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(abstractByteBuf);
    }

    @Deprecated
    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    @Deprecated
    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    @Deprecated
    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    @Deprecated
    public int numThreadLocalCaches() {
        PoolArena[] poolArenaArr = this.heapArenas;
        if (poolArenaArr == null) {
            poolArenaArr = this.directArenas;
        }
        if (poolArenaArr == null) {
            return 0;
        }
        int i8 = 0;
        for (PoolArena poolArena : poolArenaArr) {
            i8 += poolArena.numThreadCaches.get();
        }
        return i8;
    }

    @Deprecated
    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PoolThreadCache threadCache() {
        return this.threadCache.get();
    }

    @Deprecated
    public int tinyCacheSize() {
        return this.tinyCacheSize;
    }

    public boolean trimCurrentThreadCache() {
        PoolThreadCache ifExists = this.threadCache.getIfExists();
        if (ifExists != null) {
            ifExists.trim();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long usedDirectMemory() {
        return usedMemory(this.directArenas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long usedHeapMemory() {
        return usedMemory(this.heapArenas);
    }

    public PooledByteBufAllocator(boolean z7) {
        this(z7, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z7, int i8, int i9, int i10, int i11) {
        this(z7, i8, i9, i10, i11, DEFAULT_TINY_CACHE_SIZE, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        this(z7, i8, i9, i10, i11, i12, i13, i14, DEFAULT_USE_CACHE_FOR_ALL_THREADS, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    public PooledByteBufAllocator(boolean z7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, boolean z8, int i15) {
        super(z7);
        this.trimTask = new Runnable() { // from class: io.netty.buffer.PooledByteBufAllocator.1
            @Override // java.lang.Runnable
            public void run() {
                PooledByteBufAllocator.this.trimCurrentThreadCache();
            }
        };
        this.threadCache = new PoolThreadLocalCache(z8);
        this.tinyCacheSize = i12;
        this.smallCacheSize = i13;
        this.normalCacheSize = i14;
        this.chunkSize = validateAndCalculateChunkSize(i10, i11);
        ObjectUtil.checkPositiveOrZero(i8, "nHeapArena");
        ObjectUtil.checkPositiveOrZero(i9, "nDirectArena");
        ObjectUtil.checkPositiveOrZero(i15, "directMemoryCacheAlignment");
        if (i15 > 0 && !isDirectMemoryCacheAlignmentSupported()) {
            throw new IllegalArgumentException("directMemoryCacheAlignment is not supported");
        }
        if (((-i15) & i15) == i15) {
            int validateAndCalculatePageShifts = validateAndCalculatePageShifts(i10);
            if (i8 > 0) {
                PoolArena<byte[]>[] newArenaArray = newArenaArray(i8);
                this.heapArenas = newArenaArray;
                ArrayList arrayList = new ArrayList(newArenaArray.length);
                for (int i16 = 0; i16 < this.heapArenas.length; i16++) {
                    PoolArena.HeapArena heapArena = new PoolArena.HeapArena(this, i10, i11, validateAndCalculatePageShifts, this.chunkSize, i15);
                    this.heapArenas[i16] = heapArena;
                    arrayList.add(heapArena);
                }
                this.heapArenaMetrics = Collections.unmodifiableList(arrayList);
            } else {
                this.heapArenas = null;
                this.heapArenaMetrics = Collections.emptyList();
            }
            if (i9 > 0) {
                PoolArena<ByteBuffer>[] newArenaArray2 = newArenaArray(i9);
                this.directArenas = newArenaArray2;
                ArrayList arrayList2 = new ArrayList(newArenaArray2.length);
                for (int i17 = 0; i17 < this.directArenas.length; i17++) {
                    PoolArena.DirectArena directArena = new PoolArena.DirectArena(this, i10, i11, validateAndCalculatePageShifts, this.chunkSize, i15);
                    this.directArenas[i17] = directArena;
                    arrayList2.add(directArena);
                }
                this.directArenaMetrics = Collections.unmodifiableList(arrayList2);
            } else {
                this.directArenas = null;
                this.directArenaMetrics = Collections.emptyList();
            }
            this.metric = new PooledByteBufAllocatorMetric(this);
            return;
        }
        throw new IllegalArgumentException("directMemoryCacheAlignment: " + i15 + " (expected: power of two)");
    }
}
