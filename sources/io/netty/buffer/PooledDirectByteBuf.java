package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class PooledDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final ObjectPool<PooledDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledDirectByteBuf>() { // from class: io.netty.buffer.PooledDirectByteBuf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledDirectByteBuf newObject(ObjectPool.Handle<PooledDirectByteBuf> handle) {
            return new PooledDirectByteBuf(handle, 0);
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PooledDirectByteBuf newInstance(int i8) {
        PooledDirectByteBuf pooledDirectByteBuf = RECYCLER.get();
        pooledDirectByteBuf.reuse(i8);
        return pooledDirectByteBuf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i8) {
        return ((ByteBuffer) this.memory).get(idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i8) {
        return ((ByteBuffer) this.memory).getInt(idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i8) {
        return ByteBufUtil.swapInt(_getInt(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i8) {
        return ((ByteBuffer) this.memory).getLong(idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i8) {
        return ((ByteBuffer) this.memory).getShort(idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i8) {
        return ByteBufUtil.swapShort(_getShort(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i8) {
        int idx = idx(i8);
        return (((ByteBuffer) this.memory).get(idx + 2) & 255) | ((((ByteBuffer) this.memory).get(idx) & 255) << 16) | ((((ByteBuffer) this.memory).get(idx + 1) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i8, int i9) {
        ((ByteBuffer) this.memory).put(idx(i8), (byte) i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i8, int i9) {
        ((ByteBuffer) this.memory).putInt(idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i8, long j8) {
        ((ByteBuffer) this.memory).putLong(idx(i8), j8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i8, int i9) {
        int idx = idx(i8);
        ((ByteBuffer) this.memory).put(idx, (byte) (i9 >>> 16));
        ((ByteBuffer) this.memory).put(idx + 1, (byte) (i9 >>> 8));
        ((ByteBuffer) this.memory).put(idx + 2, (byte) i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i8, int i9) {
        int idx = idx(i8);
        ((ByteBuffer) this.memory).put(idx, (byte) i9);
        ((ByteBuffer) this.memory).put(idx + 1, (byte) (i9 >>> 8));
        ((ByteBuffer) this.memory).put(idx + 2, (byte) (i9 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i8, int i9) {
        ((ByteBuffer) this.memory).putShort(idx(i8), (short) i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i8, int i9) {
        _setShort(i8, ByteBufUtil.swapShort((short) i9));
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkDstIndex(i8, i10, i9, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            getBytes(i8, byteBuf.array(), byteBuf.arrayOffset() + i9, i10);
        } else if (byteBuf.nioBufferCount() > 0) {
            ByteBuffer[] nioBuffers = byteBuf.nioBuffers(i9, i10);
            for (ByteBuffer byteBuffer : nioBuffers) {
                int remaining = byteBuffer.remaining();
                getBytes(i8, byteBuffer);
                i8 += remaining;
            }
        } else {
            byteBuf.setBytes(i9, this, i8, i10);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i8, int i9) {
        checkDstIndex(i9, i8, bArr.length);
        _internalNioBuffer(this.readerIndex, i9, false).get(bArr, i8, i9);
        this.readerIndex += i9;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkSrcIndex(i8, i10, i9, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            setBytes(i8, byteBuf.array(), byteBuf.arrayOffset() + i9, i10);
        } else if (byteBuf.nioBufferCount() > 0) {
            ByteBuffer[] nioBuffers = byteBuf.nioBuffers(i9, i10);
            for (ByteBuffer byteBuffer : nioBuffers) {
                int remaining = byteBuffer.remaining();
                setBytes(i8, byteBuffer);
                i8 += remaining;
            }
        } else {
            byteBuf.getBytes(i9, this, i8, i10);
        }
        return this;
    }

    private PooledDirectByteBuf(ObjectPool.Handle<PooledDirectByteBuf> handle, int i8) {
        super(handle, i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        byteBuffer.put(_internalNioBuffer(this.readerIndex, remaining, false));
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr, int i9, int i10) {
        checkDstIndex(i8, i10, i9, bArr.length);
        _internalNioBuffer(i8, i10, true).get(bArr, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, byte[] bArr, int i9, int i10) {
        checkSrcIndex(i8, i10, i9, bArr.length);
        _internalNioBuffer(i8, i10, false).put(bArr, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuffer byteBuffer) {
        byteBuffer.put(duplicateInternalNioBuffer(i8, byteBuffer.remaining()));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkIndex(i8, remaining);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        if (byteBuffer == internalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        int idx = idx(i8);
        internalNioBuffer.limit(remaining + idx).position(idx);
        internalNioBuffer.put(byteBuffer);
        return this;
    }
}
