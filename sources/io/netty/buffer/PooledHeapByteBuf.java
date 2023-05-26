package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class PooledHeapByteBuf extends PooledByteBuf<byte[]> {
    private static final ObjectPool<PooledHeapByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledHeapByteBuf>() { // from class: io.netty.buffer.PooledHeapByteBuf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledHeapByteBuf newObject(ObjectPool.Handle<PooledHeapByteBuf> handle) {
            return new PooledHeapByteBuf(handle, 0);
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    public PooledHeapByteBuf(ObjectPool.Handle<? extends PooledHeapByteBuf> handle, int i8) {
        super(handle, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PooledHeapByteBuf newInstance(int i8) {
        PooledHeapByteBuf pooledHeapByteBuf = RECYCLER.get();
        pooledHeapByteBuf.reuse(i8);
        return pooledHeapByteBuf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i8) {
        return HeapByteBufUtil.getByte((byte[]) this.memory, idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i8) {
        return HeapByteBufUtil.getInt((byte[]) this.memory, idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i8) {
        return HeapByteBufUtil.getIntLE((byte[]) this.memory, idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i8) {
        return HeapByteBufUtil.getLong((byte[]) this.memory, idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i8) {
        return HeapByteBufUtil.getShort((byte[]) this.memory, idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i8) {
        return HeapByteBufUtil.getShortLE((byte[]) this.memory, idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i8) {
        return HeapByteBufUtil.getUnsignedMedium((byte[]) this.memory, idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i8, int i9) {
        HeapByteBufUtil.setByte((byte[]) this.memory, idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i8, int i9) {
        HeapByteBufUtil.setInt((byte[]) this.memory, idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i8, long j8) {
        HeapByteBufUtil.setLong((byte[]) this.memory, idx(i8), j8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i8, int i9) {
        HeapByteBufUtil.setMedium((byte[]) this.memory, idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i8, int i9) {
        HeapByteBufUtil.setMediumLE((byte[]) this.memory, idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i8, int i9) {
        HeapByteBufUtil.setShort((byte[]) this.memory, idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i8, int i9) {
        HeapByteBufUtil.setShortLE((byte[]) this.memory, idx(i8), i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public final byte[] array() {
        ensureAccessible();
        return (byte[]) this.memory;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        return this.offset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.buffer.PooledByteBuf
    public final ByteBuffer duplicateInternalNioBuffer(int i8, int i9) {
        checkIndex(i8, i9);
        return ByteBuffer.wrap((byte[]) this.memory, idx(i8), i9).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkDstIndex(i8, i10, i9, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory((byte[]) this.memory, idx(i8), i9 + byteBuf.memoryAddress(), i10);
        } else if (byteBuf.hasArray()) {
            getBytes(i8, byteBuf.array(), byteBuf.arrayOffset() + i9, i10);
        } else {
            byteBuf.setBytes(i9, (byte[]) this.memory, idx(i8), i10);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkSrcIndex(i8, i10, i9, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf.memoryAddress() + i9, (byte[]) this.memory, idx(i8), i10);
        } else if (byteBuf.hasArray()) {
            setBytes(i8, byteBuf.array(), byteBuf.arrayOffset() + i9, i10);
        } else {
            byteBuf.getBytes(i9, (byte[]) this.memory, idx(i8), i10);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public final ByteBuffer newInternalNioBuffer(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i8, byte[] bArr, int i9, int i10) {
        checkDstIndex(i8, i10, i9, bArr.length);
        System.arraycopy(this.memory, idx(i8), bArr, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i8, byte[] bArr, int i9, int i10) {
        checkSrcIndex(i8, i10, i9, bArr.length);
        System.arraycopy(bArr, i9, this.memory, idx(i8), i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i8, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkIndex(i8, remaining);
        byteBuffer.put((byte[]) this.memory, idx(i8), remaining);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i8, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkIndex(i8, remaining);
        byteBuffer.get((byte[]) this.memory, idx(i8), remaining);
        return this;
    }
}
