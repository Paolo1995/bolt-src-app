package io.netty.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class PoolChunk<T> implements PoolChunkMetric {
    final PoolArena<T> arena;
    private final Deque<ByteBuffer> cachedNioBuffers;
    private final int chunkSize;
    private final byte[] depthMap;
    private int freeBytes;
    private final int log2ChunkSize;
    private final int maxOrder;
    private final int maxSubpageAllocs;
    final T memory;
    private final byte[] memoryMap;
    PoolChunk<T> next;
    final int offset;
    private final int pageShifts;
    private final int pageSize;
    PoolChunkList<T> parent;
    PoolChunk<T> prev;
    private final int subpageOverflowMask;
    private final PoolSubpage<T>[] subpages;
    final boolean unpooled;
    private final byte unusable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolChunk(PoolArena<T> poolArena, T t7, int i8, int i9, int i10, int i11, int i12) {
        this.unpooled = false;
        this.arena = poolArena;
        this.memory = t7;
        this.pageSize = i8;
        this.pageShifts = i10;
        this.maxOrder = i9;
        this.chunkSize = i11;
        this.offset = i12;
        this.unusable = (byte) (i9 + 1);
        this.log2ChunkSize = log2(i11);
        this.subpageOverflowMask = ~(i8 - 1);
        this.freeBytes = i11;
        int i13 = 1 << i9;
        this.maxSubpageAllocs = i13;
        byte[] bArr = new byte[i13 << 1];
        this.memoryMap = bArr;
        this.depthMap = new byte[bArr.length];
        int i14 = 1;
        for (int i15 = 0; i15 <= i9; i15++) {
            int i16 = 1 << i15;
            for (int i17 = 0; i17 < i16; i17++) {
                byte b8 = (byte) i15;
                this.memoryMap[i14] = b8;
                this.depthMap[i14] = b8;
                i14++;
            }
        }
        this.subpages = newSubpageArray(this.maxSubpageAllocs);
        this.cachedNioBuffers = new ArrayDeque(8);
    }

    private int allocateNode(int i8) {
        int i9 = 1;
        int i10 = -(1 << i8);
        byte value = value(1);
        if (value > i8) {
            return -1;
        }
        while (true) {
            if (value >= i8 && (i9 & i10) != 0) {
                value(i9);
                setValue(i9, this.unusable);
                updateParentsAlloc(i9);
                return i9;
            }
            i9 <<= 1;
            value = value(i9);
            if (value > i8) {
                i9 ^= 1;
                value = value(i9);
            }
        }
    }

    private long allocateRun(int i8) {
        int allocateNode = allocateNode(this.maxOrder - (log2(i8) - this.pageShifts));
        if (allocateNode < 0) {
            return allocateNode;
        }
        this.freeBytes -= runLength(allocateNode);
        return allocateNode;
    }

    private long allocateSubpage(int i8) {
        PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(i8);
        int i9 = this.maxOrder;
        synchronized (findSubpagePoolHead) {
            int allocateNode = allocateNode(i9);
            if (allocateNode < 0) {
                return allocateNode;
            }
            PoolSubpage<T>[] poolSubpageArr = this.subpages;
            int i10 = this.pageSize;
            this.freeBytes -= i10;
            int subpageIdx = subpageIdx(allocateNode);
            PoolSubpage<T> poolSubpage = poolSubpageArr[subpageIdx];
            if (poolSubpage == null) {
                PoolSubpage<T> poolSubpage2 = new PoolSubpage<>(findSubpagePoolHead, this, allocateNode, runOffset(allocateNode), i10, i8);
                poolSubpageArr[subpageIdx] = poolSubpage2;
                poolSubpage = poolSubpage2;
            } else {
                poolSubpage.init(findSubpagePoolHead, i8);
            }
            return poolSubpage.allocate();
        }
    }

    private static int bitmapIdx(long j8) {
        return (int) (j8 >>> 32);
    }

    private byte depth(int i8) {
        return this.depthMap[i8];
    }

    private static int log2(int i8) {
        return 31 - Integer.numberOfLeadingZeros(i8);
    }

    private static int memoryMapIdx(long j8) {
        return (int) j8;
    }

    private PoolSubpage<T>[] newSubpageArray(int i8) {
        return new PoolSubpage[i8];
    }

    private int runLength(int i8) {
        return 1 << (this.log2ChunkSize - depth(i8));
    }

    private int runOffset(int i8) {
        return ((1 << depth(i8)) ^ i8) * runLength(i8);
    }

    private void setValue(int i8, byte b8) {
        this.memoryMap[i8] = b8;
    }

    private int subpageIdx(int i8) {
        return i8 ^ this.maxSubpageAllocs;
    }

    private void updateParentsAlloc(int i8) {
        while (i8 > 1) {
            int i9 = i8 >>> 1;
            byte value = value(i8);
            byte value2 = value(i8 ^ 1);
            if (value >= value2) {
                value = value2;
            }
            setValue(i9, value);
            i8 = i9;
        }
    }

    private void updateParentsFree(int i8) {
        int depth = depth(i8) + 1;
        while (i8 > 1) {
            int i9 = i8 >>> 1;
            byte value = value(i8);
            byte value2 = value(i8 ^ 1);
            depth--;
            if (value == depth && value2 == depth) {
                setValue(i9, (byte) (depth - 1));
            } else {
                if (value >= value2) {
                    value = value2;
                }
                setValue(i9, value);
            }
            i8 = i9;
        }
    }

    private byte value(int i8) {
        return this.memoryMap[i8];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocate(PooledByteBuf<T> pooledByteBuf, int i8, int i9) {
        long allocateSubpage;
        ByteBuffer byteBuffer;
        if ((this.subpageOverflowMask & i9) != 0) {
            allocateSubpage = allocateRun(i9);
        } else {
            allocateSubpage = allocateSubpage(i9);
        }
        long j8 = allocateSubpage;
        if (j8 < 0) {
            return false;
        }
        Deque<ByteBuffer> deque = this.cachedNioBuffers;
        if (deque != null) {
            byteBuffer = deque.pollLast();
        } else {
            byteBuffer = null;
        }
        initBuf(pooledByteBuf, byteBuffer, j8, i8);
        return true;
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int chunkSize() {
        return this.chunkSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        this.arena.destroyChunk(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free(long j8, ByteBuffer byteBuffer) {
        Deque<ByteBuffer> deque;
        int memoryMapIdx = memoryMapIdx(j8);
        int bitmapIdx = bitmapIdx(j8);
        if (bitmapIdx != 0) {
            PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(memoryMapIdx)];
            PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(poolSubpage.elemSize);
            synchronized (findSubpagePoolHead) {
                if (poolSubpage.free(findSubpagePoolHead, bitmapIdx & 1073741823)) {
                    return;
                }
            }
        }
        this.freeBytes += runLength(memoryMapIdx);
        setValue(memoryMapIdx, depth(memoryMapIdx));
        updateParentsFree(memoryMapIdx);
        if (byteBuffer != null && (deque = this.cachedNioBuffers) != null && deque.size() < PooledByteBufAllocator.DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK) {
            this.cachedNioBuffers.offer(byteBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initBuf(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j8, int i8) {
        int memoryMapIdx = memoryMapIdx(j8);
        int bitmapIdx = bitmapIdx(j8);
        if (bitmapIdx == 0) {
            value(memoryMapIdx);
            pooledByteBuf.init(this, byteBuffer, j8, runOffset(memoryMapIdx) + this.offset, i8, runLength(memoryMapIdx), this.arena.parent.threadCache());
            return;
        }
        initBufWithSubpage(pooledByteBuf, byteBuffer, j8, bitmapIdx, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j8, int i8) {
        initBufWithSubpage(pooledByteBuf, byteBuffer, j8, bitmapIdx(j8), i8);
    }

    public String toString() {
        int i8;
        synchronized (this.arena) {
            i8 = this.freeBytes;
        }
        return "Chunk(" + Integer.toHexString(System.identityHashCode(this)) + ": " + usage(i8) + "%, " + (this.chunkSize - i8) + '/' + this.chunkSize + ')';
    }

    public int usage() {
        int i8;
        synchronized (this.arena) {
            i8 = this.freeBytes;
        }
        return usage(i8);
    }

    private void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j8, int i8, int i9) {
        int memoryMapIdx = memoryMapIdx(j8);
        PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(memoryMapIdx)];
        int runOffset = runOffset(memoryMapIdx);
        int i10 = poolSubpage.elemSize;
        pooledByteBuf.init(this, byteBuffer, j8, runOffset + ((1073741823 & i8) * i10) + this.offset, i9, i10, this.arena.parent.threadCache());
    }

    private int usage(int i8) {
        if (i8 == 0) {
            return 100;
        }
        int i9 = (int) ((i8 * 100) / this.chunkSize);
        if (i9 == 0) {
            return 99;
        }
        return 100 - i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolChunk(PoolArena<T> poolArena, T t7, int i8, int i9) {
        this.unpooled = true;
        this.arena = poolArena;
        this.memory = t7;
        this.offset = i9;
        this.memoryMap = null;
        this.depthMap = null;
        this.subpages = null;
        this.subpageOverflowMask = 0;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.maxOrder = 0;
        this.unusable = (byte) (1 + 0);
        this.chunkSize = i8;
        this.log2ChunkSize = log2(i8);
        this.maxSubpageAllocs = 0;
        this.cachedNioBuffers = null;
    }
}
