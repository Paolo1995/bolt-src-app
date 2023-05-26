package io.netty.buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class PoolSubpage<T> {
    private final long[] bitmap;
    private int bitmapLength;
    final PoolChunk<T> chunk;
    boolean doNotDestroy;
    int elemSize;
    private int maxNumElems;
    private final int memoryMapIdx;
    PoolSubpage<T> next;
    private int nextAvail;
    private int numAvail;
    private final int pageSize;
    PoolSubpage<T> prev;
    private final int runOffset;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolSubpage(int i8) {
        this.chunk = null;
        this.memoryMapIdx = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.pageSize = i8;
        this.bitmap = null;
    }

    private void addToPool(PoolSubpage<T> poolSubpage) {
        this.prev = poolSubpage;
        PoolSubpage<T> poolSubpage2 = poolSubpage.next;
        this.next = poolSubpage2;
        poolSubpage2.prev = this;
        poolSubpage.next = this;
    }

    private int findNextAvail() {
        long[] jArr = this.bitmap;
        int i8 = this.bitmapLength;
        for (int i9 = 0; i9 < i8; i9++) {
            long j8 = jArr[i9];
            if ((~j8) != 0) {
                return findNextAvail0(i9, j8);
            }
        }
        return -1;
    }

    private int findNextAvail0(int i8, long j8) {
        int i9 = this.maxNumElems;
        int i10 = i8 << 6;
        for (int i11 = 0; i11 < 64; i11++) {
            if ((1 & j8) == 0) {
                int i12 = i10 | i11;
                if (i12 < i9) {
                    return i12;
                }
                return -1;
            }
            j8 >>>= 1;
        }
        return -1;
    }

    private int getNextAvail() {
        int i8 = this.nextAvail;
        if (i8 >= 0) {
            this.nextAvail = -1;
            return i8;
        }
        return findNextAvail();
    }

    private void removeFromPool() {
        PoolSubpage<T> poolSubpage = this.prev;
        poolSubpage.next = this.next;
        this.next.prev = poolSubpage;
        this.next = null;
        this.prev = null;
    }

    private void setNextAvail(int i8) {
        this.nextAvail = i8;
    }

    private long toHandle(int i8) {
        return (i8 << 32) | 4611686018427387904L | this.memoryMapIdx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long allocate() {
        if (this.elemSize == 0) {
            return toHandle(0);
        }
        if (this.numAvail != 0 && this.doNotDestroy) {
            int nextAvail = getNextAvail();
            int i8 = nextAvail >>> 6;
            long[] jArr = this.bitmap;
            jArr[i8] = jArr[i8] | (1 << (nextAvail & 63));
            int i9 = this.numAvail - 1;
            this.numAvail = i9;
            if (i9 == 0) {
                removeFromPool();
            }
            return toHandle(nextAvail);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk != null) {
            poolChunk.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean free(PoolSubpage<T> poolSubpage, int i8) {
        if (this.elemSize == 0) {
            return true;
        }
        int i9 = i8 >>> 6;
        long[] jArr = this.bitmap;
        jArr[i9] = jArr[i9] ^ (1 << (i8 & 63));
        setNextAvail(i8);
        int i10 = this.numAvail;
        int i11 = i10 + 1;
        this.numAvail = i11;
        if (i10 == 0) {
            addToPool(poolSubpage);
            return true;
        } else if (i11 != this.maxNumElems || this.prev == this.next) {
            return true;
        } else {
            this.doNotDestroy = false;
            removeFromPool();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(PoolSubpage<T> poolSubpage, int i8) {
        this.doNotDestroy = true;
        this.elemSize = i8;
        if (i8 != 0) {
            int i9 = this.pageSize / i8;
            this.numAvail = i9;
            this.maxNumElems = i9;
            this.nextAvail = 0;
            int i10 = i9 >>> 6;
            this.bitmapLength = i10;
            if ((i9 & 63) != 0) {
                this.bitmapLength = i10 + 1;
            }
            for (int i11 = 0; i11 < this.bitmapLength; i11++) {
                this.bitmap[i11] = 0;
            }
        }
        addToPool(poolSubpage);
    }

    public String toString() {
        int i8;
        int i9;
        int i10;
        PoolChunk<T> poolChunk = this.chunk;
        int i11 = -1;
        boolean z7 = true;
        int i12 = 0;
        if (poolChunk == null) {
            i10 = 0;
        } else {
            synchronized (poolChunk.arena) {
                if (!this.doNotDestroy) {
                    z7 = false;
                    i8 = -1;
                    i9 = -1;
                } else {
                    i11 = this.maxNumElems;
                    i8 = this.numAvail;
                    i9 = this.elemSize;
                }
            }
            i10 = i8;
            i12 = i11;
            i11 = i9;
        }
        if (!z7) {
            return "(" + this.memoryMapIdx + ": not in use)";
        }
        return "(" + this.memoryMapIdx + ": " + (i12 - i10) + '/' + i12 + ", offset: " + this.runOffset + ", length: " + this.pageSize + ", elemSize: " + i11 + ')';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolSubpage(PoolSubpage<T> poolSubpage, PoolChunk<T> poolChunk, int i8, int i9, int i10, int i11) {
        this.chunk = poolChunk;
        this.memoryMapIdx = i8;
        this.runOffset = i9;
        this.pageSize = i10;
        this.bitmap = new long[i10 >>> 10];
        init(poolSubpage, i11);
    }
}
