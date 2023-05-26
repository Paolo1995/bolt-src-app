package io.netty.buffer;

import com.google.android.gms.common.api.Api;
import io.netty.util.internal.LongCounter;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class PoolArena<T> {
    static final boolean HAS_UNSAFE = PlatformDependent.hasUnsafe();
    private long allocationsNormal;
    private final List<PoolChunkListMetric> chunkListMetrics;
    final int chunkSize;
    private long deallocationsNormal;
    private long deallocationsSmall;
    private long deallocationsTiny;
    final int directMemoryCacheAlignment;
    final int directMemoryCacheAlignmentMask;
    private final int maxOrder;
    final int numSmallSubpagePools;
    final int pageShifts;
    final int pageSize;
    final PooledByteBufAllocator parent;
    private final PoolChunkList<T> q000;
    private final PoolChunkList<T> q025;
    private final PoolChunkList<T> q050;
    private final PoolChunkList<T> q075;
    private final PoolChunkList<T> q100;
    private final PoolChunkList<T> qInit;
    private final PoolSubpage<T>[] smallSubpagePools;
    final int subpageOverflowMask;
    private final LongCounter allocationsTiny = PlatformDependent.newLongCounter();
    private final LongCounter allocationsSmall = PlatformDependent.newLongCounter();
    private final LongCounter allocationsHuge = PlatformDependent.newLongCounter();
    private final LongCounter activeBytesHuge = PlatformDependent.newLongCounter();
    private final LongCounter deallocationsHuge = PlatformDependent.newLongCounter();
    final AtomicInteger numThreadCaches = new AtomicInteger();
    private final PoolSubpage<T>[] tinySubpagePools = newSubpagePoolArray(32);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.buffer.PoolArena$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        static {
            int[] iArr = new int[SizeClass.values().length];
            $SwitchMap$io$netty$buffer$PoolArena$SizeClass = iArr;
            try {
                iArr[SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Tiny.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class DirectArena extends PoolArena<ByteBuffer> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public DirectArena(PooledByteBufAllocator pooledByteBufAllocator, int i8, int i9, int i10, int i11, int i12) {
            super(pooledByteBufAllocator, i8, i9, i10, i11, i12);
        }

        private static ByteBuffer allocateDirect(int i8) {
            if (PlatformDependent.useDirectBufferNoCleaner()) {
                return PlatformDependent.allocateDirectNoCleaner(i8);
            }
            return ByteBuffer.allocateDirect(i8);
        }

        @Override // io.netty.buffer.PoolArena
        protected void destroyChunk(PoolChunk<ByteBuffer> poolChunk) {
            if (PlatformDependent.useDirectBufferNoCleaner()) {
                PlatformDependent.freeDirectNoCleaner(poolChunk.memory);
            } else {
                PlatformDependent.freeDirectBuffer(poolChunk.memory);
            }
        }

        @Override // io.netty.buffer.PoolArena
        boolean isDirect() {
            return true;
        }

        @Override // io.netty.buffer.PoolArena
        protected PooledByteBuf<ByteBuffer> newByteBuf(int i8) {
            if (PoolArena.HAS_UNSAFE) {
                return PooledUnsafeDirectByteBuf.newInstance(i8);
            }
            return PooledDirectByteBuf.newInstance(i8);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newChunk(int i8, int i9, int i10, int i11) {
            int i12 = this.directMemoryCacheAlignment;
            if (i12 == 0) {
                return new PoolChunk<>(this, allocateDirect(i11), i8, i9, i10, i11, 0);
            }
            ByteBuffer allocateDirect = allocateDirect(i12 + i11);
            return new PoolChunk<>(this, allocateDirect, i8, i9, i10, i11, offsetCacheLine(allocateDirect));
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newUnpooledChunk(int i8) {
            int i9 = this.directMemoryCacheAlignment;
            if (i9 == 0) {
                return new PoolChunk<>(this, allocateDirect(i8), i8, 0);
            }
            ByteBuffer allocateDirect = allocateDirect(i9 + i8);
            return new PoolChunk<>(this, allocateDirect, i8, offsetCacheLine(allocateDirect));
        }

        int offsetCacheLine(ByteBuffer byteBuffer) {
            int i8;
            if (PoolArena.HAS_UNSAFE) {
                i8 = (int) (PlatformDependent.directBufferAddress(byteBuffer) & this.directMemoryCacheAlignmentMask);
            } else {
                i8 = 0;
            }
            return this.directMemoryCacheAlignment - i8;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(ByteBuffer byteBuffer, int i8, PooledByteBuf<ByteBuffer> pooledByteBuf, int i9) {
            if (i9 == 0) {
                return;
            }
            if (PoolArena.HAS_UNSAFE) {
                PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + i8, PlatformDependent.directBufferAddress(pooledByteBuf.memory) + pooledByteBuf.offset, i9);
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            ByteBuffer internalNioBuffer = pooledByteBuf.internalNioBuffer();
            duplicate.position(i8).limit(i8 + i9);
            internalNioBuffer.position(pooledByteBuf.offset);
            internalNioBuffer.put(duplicate);
        }
    }

    /* loaded from: classes5.dex */
    static final class HeapArena extends PoolArena<byte[]> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public HeapArena(PooledByteBufAllocator pooledByteBufAllocator, int i8, int i9, int i10, int i11, int i12) {
            super(pooledByteBufAllocator, i8, i9, i10, i11, i12);
        }

        private static byte[] newByteArray(int i8) {
            return PlatformDependent.allocateUninitializedArray(i8);
        }

        @Override // io.netty.buffer.PoolArena
        protected void destroyChunk(PoolChunk<byte[]> poolChunk) {
        }

        @Override // io.netty.buffer.PoolArena
        boolean isDirect() {
            return false;
        }

        @Override // io.netty.buffer.PoolArena
        protected PooledByteBuf<byte[]> newByteBuf(int i8) {
            if (PoolArena.HAS_UNSAFE) {
                return PooledUnsafeHeapByteBuf.newUnsafeInstance(i8);
            }
            return PooledHeapByteBuf.newInstance(i8);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newChunk(int i8, int i9, int i10, int i11) {
            return new PoolChunk<>(this, newByteArray(i11), i8, i9, i10, i11, 0);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newUnpooledChunk(int i8) {
            return new PoolChunk<>(this, newByteArray(i8), i8, 0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(byte[] bArr, int i8, PooledByteBuf<byte[]> pooledByteBuf, int i9) {
            if (i9 == 0) {
                return;
            }
            System.arraycopy(bArr, i8, pooledByteBuf.memory, pooledByteBuf.offset, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum SizeClass {
        Tiny,
        Small,
        Normal
    }

    protected PoolArena(PooledByteBufAllocator pooledByteBufAllocator, int i8, int i9, int i10, int i11, int i12) {
        this.parent = pooledByteBufAllocator;
        this.pageSize = i8;
        this.maxOrder = i9;
        this.pageShifts = i10;
        this.chunkSize = i11;
        this.directMemoryCacheAlignment = i12;
        this.directMemoryCacheAlignmentMask = i12 - 1;
        this.subpageOverflowMask = ~(i8 - 1);
        int i13 = 0;
        int i14 = 0;
        while (true) {
            PoolSubpage<T>[] poolSubpageArr = this.tinySubpagePools;
            if (i14 >= poolSubpageArr.length) {
                break;
            }
            poolSubpageArr[i14] = newSubpagePoolHead(i8);
            i14++;
        }
        int i15 = i10 - 9;
        this.numSmallSubpagePools = i15;
        this.smallSubpagePools = newSubpagePoolArray(i15);
        while (true) {
            PoolSubpage<T>[] poolSubpageArr2 = this.smallSubpagePools;
            if (i13 < poolSubpageArr2.length) {
                poolSubpageArr2[i13] = newSubpagePoolHead(i8);
                i13++;
            } else {
                PoolChunkList<T> poolChunkList = new PoolChunkList<>(this, null, 100, Api.BaseClientBuilder.API_PRIORITY_OTHER, i11);
                this.q100 = poolChunkList;
                PoolChunkList<T> poolChunkList2 = new PoolChunkList<>(this, poolChunkList, 75, 100, i11);
                this.q075 = poolChunkList2;
                PoolChunkList<T> poolChunkList3 = new PoolChunkList<>(this, poolChunkList2, 50, 100, i11);
                this.q050 = poolChunkList3;
                PoolChunkList<T> poolChunkList4 = new PoolChunkList<>(this, poolChunkList3, 25, 75, i11);
                this.q025 = poolChunkList4;
                PoolChunkList<T> poolChunkList5 = new PoolChunkList<>(this, poolChunkList4, 1, 50, i11);
                this.q000 = poolChunkList5;
                PoolChunkList<T> poolChunkList6 = new PoolChunkList<>(this, poolChunkList5, Integer.MIN_VALUE, 25, i11);
                this.qInit = poolChunkList6;
                poolChunkList.prevList(poolChunkList2);
                poolChunkList2.prevList(poolChunkList3);
                poolChunkList3.prevList(poolChunkList4);
                poolChunkList4.prevList(poolChunkList5);
                poolChunkList5.prevList(null);
                poolChunkList6.prevList(poolChunkList6);
                ArrayList arrayList = new ArrayList(6);
                arrayList.add(poolChunkList6);
                arrayList.add(poolChunkList5);
                arrayList.add(poolChunkList4);
                arrayList.add(poolChunkList3);
                arrayList.add(poolChunkList2);
                arrayList.add(poolChunkList);
                this.chunkListMetrics = Collections.unmodifiableList(arrayList);
                return;
            }
        }
    }

    private void allocateHuge(PooledByteBuf<T> pooledByteBuf, int i8) {
        PoolChunk<T> newUnpooledChunk = newUnpooledChunk(i8);
        this.activeBytesHuge.add(newUnpooledChunk.chunkSize());
        pooledByteBuf.initUnpooled(newUnpooledChunk, i8);
        this.allocationsHuge.increment();
    }

    private void allocateNormal(PooledByteBuf<T> pooledByteBuf, int i8, int i9) {
        if (!this.q050.allocate(pooledByteBuf, i8, i9) && !this.q025.allocate(pooledByteBuf, i8, i9) && !this.q000.allocate(pooledByteBuf, i8, i9) && !this.qInit.allocate(pooledByteBuf, i8, i9) && !this.q075.allocate(pooledByteBuf, i8, i9)) {
            PoolChunk<T> newChunk = newChunk(this.pageSize, this.maxOrder, this.pageShifts, this.chunkSize);
            newChunk.allocate(pooledByteBuf, i8, i9);
            this.qInit.add(newChunk);
        }
    }

    private static void appendPoolSubPages(StringBuilder sb, PoolSubpage<?>[] poolSubpageArr) {
        for (int i8 = 0; i8 < poolSubpageArr.length; i8++) {
            PoolSubpage<?> poolSubpage = poolSubpageArr[i8];
            if (poolSubpage.next != poolSubpage) {
                sb.append(StringUtil.NEWLINE);
                sb.append(i8);
                sb.append(": ");
                PoolSubpage poolSubpage2 = poolSubpage.next;
                do {
                    sb.append(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
    }

    private void destroyPoolChunkLists(PoolChunkList<T>... poolChunkListArr) {
        for (PoolChunkList<T> poolChunkList : poolChunkListArr) {
            poolChunkList.destroy(this);
        }
    }

    private static void destroyPoolSubPages(PoolSubpage<?>[] poolSubpageArr) {
        for (PoolSubpage<?> poolSubpage : poolSubpageArr) {
            poolSubpage.destroy();
        }
    }

    private void incTinySmallAllocation(boolean z7) {
        if (z7) {
            this.allocationsTiny.increment();
        } else {
            this.allocationsSmall.increment();
        }
    }

    static boolean isTiny(int i8) {
        return (i8 & (-512)) == 0;
    }

    private PoolSubpage<T>[] newSubpagePoolArray(int i8) {
        return new PoolSubpage[i8];
    }

    private PoolSubpage<T> newSubpagePoolHead(int i8) {
        PoolSubpage<T> poolSubpage = new PoolSubpage<>(i8);
        poolSubpage.prev = poolSubpage;
        poolSubpage.next = poolSubpage;
        return poolSubpage;
    }

    private SizeClass sizeClass(int i8) {
        if (!isTinyOrSmall(i8)) {
            return SizeClass.Normal;
        }
        if (isTiny(i8)) {
            return SizeClass.Tiny;
        }
        return SizeClass.Small;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int smallIdx(int i8) {
        int i9 = i8 >>> 10;
        int i10 = 0;
        while (i9 != 0) {
            i9 >>>= 1;
            i10++;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int tinyIdx(int i8) {
        return i8 >>> 4;
    }

    int alignCapacity(int i8) {
        int i9 = this.directMemoryCacheAlignmentMask & i8;
        if (i9 != 0) {
            return (i8 + this.directMemoryCacheAlignment) - i9;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PooledByteBuf<T> allocate(PoolThreadCache poolThreadCache, int i8, int i9) {
        PooledByteBuf<T> newByteBuf = newByteBuf(i9);
        allocate(poolThreadCache, newByteBuf, i8);
        return newByteBuf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void destroyChunk(PoolChunk<T> poolChunk);

    protected final void finalize() throws Throwable {
        try {
            super.finalize();
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolSubPages(this.tinySubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
        } catch (Throwable th) {
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolSubPages(this.tinySubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolSubpage<T> findSubpagePoolHead(int i8) {
        PoolSubpage<T>[] poolSubpageArr;
        int i9;
        if (isTiny(i8)) {
            i9 = i8 >>> 4;
            poolSubpageArr = this.tinySubpagePools;
        } else {
            int i10 = 0;
            int i11 = i8 >>> 10;
            while (i11 != 0) {
                i11 >>>= 1;
                i10++;
            }
            int i12 = i10;
            poolSubpageArr = this.smallSubpagePools;
            i9 = i12;
        }
        return poolSubpageArr[i9];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j8, int i8, PoolThreadCache poolThreadCache) {
        if (poolChunk.unpooled) {
            int chunkSize = poolChunk.chunkSize();
            destroyChunk(poolChunk);
            this.activeBytesHuge.add(-chunkSize);
            this.deallocationsHuge.increment();
            return;
        }
        SizeClass sizeClass = sizeClass(i8);
        if (poolThreadCache != null && poolThreadCache.add(this, poolChunk, byteBuffer, j8, i8, sizeClass)) {
            return;
        }
        freeChunk(poolChunk, j8, sizeClass, byteBuffer, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void freeChunk(PoolChunk<T> poolChunk, long j8, SizeClass sizeClass, ByteBuffer byteBuffer, boolean z7) {
        boolean z8;
        synchronized (this) {
            z8 = true;
            if (!z7) {
                int i8 = AnonymousClass1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 == 3) {
                            this.deallocationsTiny++;
                        } else {
                            throw new Error();
                        }
                    } else {
                        this.deallocationsSmall++;
                    }
                } else {
                    this.deallocationsNormal++;
                }
            }
            if (poolChunk.parent.free(poolChunk, j8, byteBuffer)) {
                z8 = false;
            }
        }
        if (z8) {
            destroyChunk(poolChunk);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isDirect();

    boolean isTinyOrSmall(int i8) {
        if ((i8 & this.subpageOverflowMask) == 0) {
            return true;
        }
        return false;
    }

    protected abstract void memoryCopy(T t7, int i8, PooledByteBuf<T> pooledByteBuf, int i9);

    protected abstract PooledByteBuf<T> newByteBuf(int i8);

    protected abstract PoolChunk<T> newChunk(int i8, int i9, int i10, int i11);

    protected abstract PoolChunk<T> newUnpooledChunk(int i8);

    int normalizeCapacity(int i8) {
        ObjectUtil.checkPositiveOrZero(i8, "reqCapacity");
        if (i8 >= this.chunkSize) {
            if (this.directMemoryCacheAlignment != 0) {
                return alignCapacity(i8);
            }
            return i8;
        } else if (!isTiny(i8)) {
            int i9 = i8 - 1;
            int i10 = i9 | (i9 >>> 1);
            int i11 = i10 | (i10 >>> 2);
            int i12 = i11 | (i11 >>> 4);
            int i13 = i12 | (i12 >>> 8);
            int i14 = (i13 | (i13 >>> 16)) + 1;
            if (i14 < 0) {
                return i14 >>> 1;
            }
            return i14;
        } else if (this.directMemoryCacheAlignment > 0) {
            return alignCapacity(i8);
        } else {
            if ((i8 & 15) == 0) {
                return i8;
            }
            return (i8 & (-16)) + 16;
        }
    }

    public long numActiveBytes() {
        long value = this.activeBytesHuge.value();
        synchronized (this) {
            for (int i8 = 0; i8 < this.chunkListMetrics.size(); i8++) {
                for (PoolChunkMetric poolChunkMetric : this.chunkListMetrics.get(i8)) {
                    value += poolChunkMetric.chunkSize();
                }
            }
        }
        return Math.max(0L, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reallocate(PooledByteBuf<T> pooledByteBuf, int i8, boolean z7) {
        int i9 = pooledByteBuf.length;
        if (i9 == i8) {
            return;
        }
        PoolChunk<T> poolChunk = pooledByteBuf.chunk;
        ByteBuffer byteBuffer = pooledByteBuf.tmpNioBuf;
        long j8 = pooledByteBuf.handle;
        T t7 = pooledByteBuf.memory;
        int i10 = pooledByteBuf.offset;
        int i11 = pooledByteBuf.maxLength;
        allocate(this.parent.threadCache(), pooledByteBuf, i8);
        if (i8 > i9) {
            i8 = i9;
        } else {
            pooledByteBuf.trimIndicesToCapacity(i8);
        }
        memoryCopy(t7, i10, pooledByteBuf, i8);
        if (z7) {
            free(poolChunk, byteBuffer, j8, i11, pooledByteBuf.cache);
        }
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Chunk(s) at 0~25%:");
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append(this.qInit);
        sb.append(str);
        sb.append("Chunk(s) at 0~50%:");
        sb.append(str);
        sb.append(this.q000);
        sb.append(str);
        sb.append("Chunk(s) at 25~75%:");
        sb.append(str);
        sb.append(this.q025);
        sb.append(str);
        sb.append("Chunk(s) at 50~100%:");
        sb.append(str);
        sb.append(this.q050);
        sb.append(str);
        sb.append("Chunk(s) at 75~100%:");
        sb.append(str);
        sb.append(this.q075);
        sb.append(str);
        sb.append("Chunk(s) at 100%:");
        sb.append(str);
        sb.append(this.q100);
        sb.append(str);
        sb.append("tiny subpages:");
        appendPoolSubPages(sb, this.tinySubpagePools);
        sb.append(str);
        sb.append("small subpages:");
        appendPoolSubPages(sb, this.smallSubpagePools);
        sb.append(str);
        return sb.toString();
    }

    private void allocate(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i8) {
        int smallIdx;
        PoolSubpage<T>[] poolSubpageArr;
        int normalizeCapacity = normalizeCapacity(i8);
        if (isTinyOrSmall(normalizeCapacity)) {
            boolean isTiny = isTiny(normalizeCapacity);
            if (isTiny) {
                if (poolThreadCache.allocateTiny(this, pooledByteBuf, i8, normalizeCapacity)) {
                    return;
                }
                smallIdx = tinyIdx(normalizeCapacity);
                poolSubpageArr = this.tinySubpagePools;
            } else if (poolThreadCache.allocateSmall(this, pooledByteBuf, i8, normalizeCapacity)) {
                return;
            } else {
                smallIdx = smallIdx(normalizeCapacity);
                poolSubpageArr = this.smallSubpagePools;
            }
            PoolSubpage<T> poolSubpage = poolSubpageArr[smallIdx];
            synchronized (poolSubpage) {
                PoolSubpage<T> poolSubpage2 = poolSubpage.next;
                if (poolSubpage2 != poolSubpage) {
                    poolSubpage2.chunk.initBufWithSubpage(pooledByteBuf, null, poolSubpage2.allocate(), i8);
                    incTinySmallAllocation(isTiny);
                    return;
                }
                synchronized (this) {
                    allocateNormal(pooledByteBuf, i8, normalizeCapacity);
                }
                incTinySmallAllocation(isTiny);
            }
        } else if (normalizeCapacity <= this.chunkSize) {
            if (poolThreadCache.allocateNormal(this, pooledByteBuf, i8, normalizeCapacity)) {
                return;
            }
            synchronized (this) {
                allocateNormal(pooledByteBuf, i8, normalizeCapacity);
                this.allocationsNormal++;
            }
        } else {
            allocateHuge(pooledByteBuf, i8);
        }
    }
}
