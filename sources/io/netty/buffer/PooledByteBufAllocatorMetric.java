package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import j$.util.Spliterator;

/* loaded from: classes5.dex */
public final class PooledByteBufAllocatorMetric {
    private final PooledByteBufAllocator allocator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PooledByteBufAllocatorMetric(PooledByteBufAllocator pooledByteBufAllocator) {
        this.allocator = pooledByteBufAllocator;
    }

    public int chunkSize() {
        return this.allocator.chunkSize();
    }

    public int normalCacheSize() {
        return this.allocator.normalCacheSize();
    }

    public int numDirectArenas() {
        return this.allocator.numDirectArenas();
    }

    public int numHeapArenas() {
        return this.allocator.numHeapArenas();
    }

    public int numThreadLocalCaches() {
        return this.allocator.numThreadLocalCaches();
    }

    public int smallCacheSize() {
        return this.allocator.smallCacheSize();
    }

    public int tinyCacheSize() {
        return this.allocator.tinyCacheSize();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) Spliterator.NONNULL);
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(usedHeapMemory: ");
        sb.append(usedHeapMemory());
        sb.append("; usedDirectMemory: ");
        sb.append(usedDirectMemory());
        sb.append("; numHeapArenas: ");
        sb.append(numHeapArenas());
        sb.append("; numDirectArenas: ");
        sb.append(numDirectArenas());
        sb.append("; tinyCacheSize: ");
        sb.append(tinyCacheSize());
        sb.append("; smallCacheSize: ");
        sb.append(smallCacheSize());
        sb.append("; normalCacheSize: ");
        sb.append(normalCacheSize());
        sb.append("; numThreadLocalCaches: ");
        sb.append(numThreadLocalCaches());
        sb.append("; chunkSize: ");
        sb.append(chunkSize());
        sb.append(')');
        return sb.toString();
    }

    public long usedDirectMemory() {
        return this.allocator.usedDirectMemory();
    }

    public long usedHeapMemory() {
        return this.allocator.usedHeapMemory();
    }
}
