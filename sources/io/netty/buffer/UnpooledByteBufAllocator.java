package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class UnpooledByteBufAllocator extends AbstractByteBufAllocator {
    public static final UnpooledByteBufAllocator DEFAULT = new UnpooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    private final boolean disableLeakDetector;
    private final UnpooledByteBufAllocatorMetric metric;
    private final boolean noCleaner;

    /* loaded from: classes5.dex */
    private static final class InstrumentedUnpooledDirectByteBuf extends UnpooledDirectByteBuf {
        InstrumentedUnpooledDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i8, int i9) {
            super(unpooledByteBufAllocator, i8, i9);
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int i8) {
            ByteBuffer allocateDirect = super.allocateDirect(i8);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(allocateDirect.capacity());
            return allocateDirect;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int capacity = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }
    }

    /* loaded from: classes5.dex */
    private static final class InstrumentedUnpooledHeapByteBuf extends UnpooledHeapByteBuf {
        InstrumentedUnpooledHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i8, int i9) {
            super(unpooledByteBufAllocator, i8, i9);
        }

        @Override // io.netty.buffer.UnpooledHeapByteBuf
        protected byte[] allocateArray(int i8) {
            byte[] allocateArray = super.allocateArray(i8);
            ((UnpooledByteBufAllocator) alloc()).incrementHeap(allocateArray.length);
            return allocateArray;
        }

        @Override // io.netty.buffer.UnpooledHeapByteBuf
        protected void freeArray(byte[] bArr) {
            int length = bArr.length;
            super.freeArray(bArr);
            ((UnpooledByteBufAllocator) alloc()).decrementHeap(length);
        }
    }

    /* loaded from: classes5.dex */
    private static final class InstrumentedUnpooledUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        InstrumentedUnpooledUnsafeDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i8, int i9) {
            super(unpooledByteBufAllocator, i8, i9);
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int i8) {
            ByteBuffer allocateDirect = super.allocateDirect(i8);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(allocateDirect.capacity());
            return allocateDirect;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int capacity = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }
    }

    /* loaded from: classes5.dex */
    private static final class InstrumentedUnpooledUnsafeHeapByteBuf extends UnpooledUnsafeHeapByteBuf {
        InstrumentedUnpooledUnsafeHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i8, int i9) {
            super(unpooledByteBufAllocator, i8, i9);
        }

        @Override // io.netty.buffer.UnpooledUnsafeHeapByteBuf, io.netty.buffer.UnpooledHeapByteBuf
        protected byte[] allocateArray(int i8) {
            byte[] allocateArray = super.allocateArray(i8);
            ((UnpooledByteBufAllocator) alloc()).incrementHeap(allocateArray.length);
            return allocateArray;
        }

        @Override // io.netty.buffer.UnpooledHeapByteBuf
        protected void freeArray(byte[] bArr) {
            int length = bArr.length;
            super.freeArray(bArr);
            ((UnpooledByteBufAllocator) alloc()).decrementHeap(length);
        }
    }

    /* loaded from: classes5.dex */
    private static final class InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeNoCleanerDirectByteBuf {
        InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i8, int i9) {
            super(unpooledByteBufAllocator, i8, i9);
        }

        @Override // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf, io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int i8) {
            ByteBuffer allocateDirect = super.allocateDirect(i8);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(allocateDirect.capacity());
            return allocateDirect;
        }

        @Override // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf, io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int capacity = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }

        @Override // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf
        ByteBuffer reallocateDirect(ByteBuffer byteBuffer, int i8) {
            int capacity = byteBuffer.capacity();
            ByteBuffer reallocateDirect = super.reallocateDirect(byteBuffer, i8);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(reallocateDirect.capacity() - capacity);
            return reallocateDirect;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class UnpooledByteBufAllocatorMetric {
        final LongCounter directCounter;
        final LongCounter heapCounter;

        private UnpooledByteBufAllocatorMetric() {
            this.directCounter = PlatformDependent.newLongCounter();
            this.heapCounter = PlatformDependent.newLongCounter();
        }

        public String toString() {
            return StringUtil.simpleClassName(this) + "(usedHeapMemory: " + usedHeapMemory() + "; usedDirectMemory: " + usedDirectMemory() + ')';
        }

        public long usedDirectMemory() {
            return this.directCounter.value();
        }

        public long usedHeapMemory() {
            return this.heapCounter.value();
        }
    }

    public UnpooledByteBufAllocator(boolean z7) {
        this(z7, false);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int i8) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf(this, true, i8);
        if (!this.disableLeakDetector) {
            return AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf);
        }
        return compositeByteBuf;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int i8) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf(this, false, i8);
        if (!this.disableLeakDetector) {
            return AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf);
        }
        return compositeByteBuf;
    }

    void decrementDirect(int i8) {
        this.metric.directCounter.add(-i8);
    }

    void decrementHeap(int i8) {
        this.metric.heapCounter.add(-i8);
    }

    void incrementDirect(int i8) {
        this.metric.directCounter.add(i8);
    }

    void incrementHeap(int i8) {
        this.metric.heapCounter.add(i8);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return false;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int i8, int i9) {
        ByteBuf instrumentedUnpooledDirectByteBuf;
        if (PlatformDependent.hasUnsafe()) {
            if (this.noCleaner) {
                instrumentedUnpooledDirectByteBuf = new InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(this, i8, i9);
            } else {
                instrumentedUnpooledDirectByteBuf = new InstrumentedUnpooledUnsafeDirectByteBuf(this, i8, i9);
            }
        } else {
            instrumentedUnpooledDirectByteBuf = new InstrumentedUnpooledDirectByteBuf(this, i8, i9);
        }
        if (!this.disableLeakDetector) {
            return AbstractByteBufAllocator.toLeakAwareBuffer(instrumentedUnpooledDirectByteBuf);
        }
        return instrumentedUnpooledDirectByteBuf;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int i8, int i9) {
        if (PlatformDependent.hasUnsafe()) {
            return new InstrumentedUnpooledUnsafeHeapByteBuf(this, i8, i9);
        }
        return new InstrumentedUnpooledHeapByteBuf(this, i8, i9);
    }

    public UnpooledByteBufAllocator(boolean z7, boolean z8) {
        this(z7, z8, PlatformDependent.useDirectBufferNoCleaner());
    }

    public UnpooledByteBufAllocator(boolean z7, boolean z8, boolean z9) {
        super(z7);
        this.metric = new UnpooledByteBufAllocatorMetric();
        this.disableLeakDetector = z8;
        this.noCleaner = z9 && PlatformDependent.hasUnsafe() && PlatformDependent.hasDirectBufferNoCleanerConstructor();
    }
}
