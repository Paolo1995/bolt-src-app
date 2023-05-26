package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class ReadOnlyUnsafeDirectByteBuf extends ReadOnlyByteBufferBuf {
    private final long memoryAddress;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadOnlyUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer) {
        super(byteBufAllocator, byteBuffer);
        this.memoryAddress = PlatformDependent.directBufferAddress(this.buffer);
    }

    private long addr(int i8) {
        return this.memoryAddress + i8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i8) {
        return UnsafeByteBufUtil.getByte(addr(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i8) {
        return UnsafeByteBufUtil.getInt(addr(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i8) {
        return UnsafeByteBufUtil.getLong(addr(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i8) {
        return UnsafeByteBufUtil.getShort(addr(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i8) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i8));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkIndex(i8, i10);
        ObjectUtil.checkNotNull(byteBuf, "dst");
        if (i9 >= 0 && i9 <= byteBuf.capacity() - i10) {
            if (byteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(addr(i8), i9 + byteBuf.memoryAddress(), i10);
            } else if (byteBuf.hasArray()) {
                PlatformDependent.copyMemory(addr(i8), byteBuf.array(), byteBuf.arrayOffset() + i9, i10);
            } else {
                byteBuf.setBytes(i9, this, i8, i10);
            }
            return this;
        }
        throw new IndexOutOfBoundsException("dstIndex: " + i9);
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.memoryAddress;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr, int i9, int i10) {
        checkIndex(i8, i10);
        ObjectUtil.checkNotNull(bArr, "dst");
        if (i9 < 0 || i9 > bArr.length - i10) {
            throw new IndexOutOfBoundsException(String.format("dstIndex: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(bArr.length)));
        }
        if (i10 != 0) {
            PlatformDependent.copyMemory(addr(i8), bArr, i9, i10);
        }
        return this;
    }
}
