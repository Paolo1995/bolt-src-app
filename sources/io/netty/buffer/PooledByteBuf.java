package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class PooledByteBuf<T> extends AbstractReferenceCountedByteBuf {
    private ByteBufAllocator allocator;
    PoolThreadCache cache;
    protected PoolChunk<T> chunk;
    protected long handle;
    protected int length;
    int maxLength;
    protected T memory;
    protected int offset;
    private final ObjectPool.Handle<PooledByteBuf<T>> recyclerHandle;
    ByteBuffer tmpNioBuf;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public PooledByteBuf(ObjectPool.Handle<? extends PooledByteBuf<T>> handle, int i8) {
        super(i8);
        this.recyclerHandle = handle;
    }

    private void init0(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j8, int i8, int i9, int i10, PoolThreadCache poolThreadCache) {
        this.chunk = poolChunk;
        this.memory = poolChunk.memory;
        this.tmpNioBuf = byteBuffer;
        this.allocator = poolChunk.arena.parent;
        this.cache = poolThreadCache;
        this.handle = j8;
        this.offset = i8;
        this.length = i9;
        this.maxLength = i10;
    }

    private void recycle() {
        this.recyclerHandle.recycle(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteBuffer _internalNioBuffer(int i8, int i9, boolean z7) {
        ByteBuffer internalNioBuffer;
        int idx = idx(i8);
        if (z7) {
            internalNioBuffer = newInternalNioBuffer(this.memory);
        } else {
            internalNioBuffer = internalNioBuffer();
        }
        internalNioBuffer.limit(i9 + idx).position(idx);
        return internalNioBuffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.length;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected final void deallocate() {
        long j8 = this.handle;
        if (j8 >= 0) {
            this.handle = -1L;
            this.memory = null;
            PoolChunk<T> poolChunk = this.chunk;
            poolChunk.arena.free(poolChunk, this.tmpNioBuf, j8, this.maxLength, this.cache);
            this.tmpNioBuf = null;
            this.chunk = null;
            recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer duplicateInternalNioBuffer(int i8, int i9) {
        checkIndex(i8, i9);
        return _internalNioBuffer(i8, i9, true);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getBytes(int i8, GatheringByteChannel gatheringByteChannel, int i9) throws IOException {
        return gatheringByteChannel.write(duplicateInternalNioBuffer(i8, i9));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int idx(int i8) {
        return this.offset + i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j8, int i8, int i9, int i10, PoolThreadCache poolThreadCache) {
        init0(poolChunk, byteBuffer, j8, i8, i9, i10, poolThreadCache);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initUnpooled(PoolChunk<T> poolChunk, int i8) {
        init0(poolChunk, null, 0L, poolChunk.offset, i8, i8, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer == null) {
            ByteBuffer newInternalNioBuffer = newInternalNioBuffer(this.memory);
            this.tmpNioBuf = newInternalNioBuffer;
            return newInternalNioBuffer;
        }
        byteBuffer.clear();
        return byteBuffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isContiguous() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return Math.min(this.maxLength, maxCapacity()) - this.writerIndex;
    }

    protected abstract ByteBuffer newInternalNioBuffer(T t7);

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer(int i8, int i9) {
        return duplicateInternalNioBuffer(i8, i9).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers(int i8, int i9) {
        return new ByteBuffer[]{nioBuffer(i8, i9)};
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int readBytes(GatheringByteChannel gatheringByteChannel, int i8) throws IOException {
        checkReadableBytes(i8);
        int write = gatheringByteChannel.write(_internalNioBuffer(this.readerIndex, i8, false));
        this.readerIndex += write;
        return write;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedDuplicate() {
        return PooledDuplicatedByteBuf.newInstance(this, this, readerIndex(), writerIndex());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedSlice() {
        int readerIndex = readerIndex();
        return retainedSlice(readerIndex, writerIndex() - readerIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void reuse(int i8) {
        maxCapacity(i8);
        resetRefCnt();
        setIndex0(0, 0);
        discardMarks();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i8, ScatteringByteChannel scatteringByteChannel, int i9) throws IOException {
        try {
            return scatteringByteChannel.read(internalNioBuffer(i8, i9));
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf capacity(int i8) {
        if (i8 == this.length) {
            ensureAccessible();
            return this;
        }
        checkNewCapacity(i8);
        PoolChunk<T> poolChunk = this.chunk;
        if (!poolChunk.unpooled) {
            if (i8 > this.length) {
                if (i8 <= this.maxLength) {
                    this.length = i8;
                    return this;
                }
            } else {
                int i9 = this.maxLength;
                if (i8 > (i9 >>> 1) && (i9 > 512 || i8 > i9 - 16)) {
                    this.length = i8;
                    trimIndicesToCapacity(i8);
                    return this;
                }
            }
        }
        poolChunk.arena.reallocate(this, i8, true);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public final ByteBuf retainedSlice(int i8, int i9) {
        return PooledSlicedByteBuf.newInstance(this, this, i8, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int i8, int i9) {
        checkIndex(i8, i9);
        return _internalNioBuffer(i8, i9, false);
    }
}
