package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class UnpooledUnsafeDirectByteBuf extends UnpooledDirectByteBuf {
    long memoryAddress;

    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int i8, int i9) {
        super(byteBufAllocator, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i8) {
        return UnsafeByteBufUtil.getByte(addr(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i8) {
        return UnsafeByteBufUtil.getInt(addr(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i8) {
        return UnsafeByteBufUtil.getIntLE(addr(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i8) {
        return UnsafeByteBufUtil.getLong(addr(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i8) {
        return UnsafeByteBufUtil.getShort(addr(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i8) {
        return UnsafeByteBufUtil.getShortLE(addr(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i8) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setByte(int i8, int i9) {
        UnsafeByteBufUtil.setByte(addr(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setInt(int i8, int i9) {
        UnsafeByteBufUtil.setInt(addr(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLong(int i8, long j8) {
        UnsafeByteBufUtil.setLong(addr(i8), j8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i8, int i9) {
        UnsafeByteBufUtil.setMedium(addr(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i8, int i9) {
        UnsafeByteBufUtil.setMediumLE(addr(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShort(int i8, int i9) {
        UnsafeByteBufUtil.setShort(addr(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i8, int i9) {
        UnsafeByteBufUtil.setShortLE(addr(i8), i9);
    }

    final long addr(int i8) {
        return this.memoryAddress + i8;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i8) {
        checkIndex(i8);
        return _getByte(i8);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        UnsafeByteBufUtil.getBytes(this, addr(i8), i8, byteBuf, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i8) {
        checkIndex(i8, 4);
        return _getInt(i8);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i8) {
        checkIndex(i8, 8);
        return _getLong(i8);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i8) {
        checkIndex(i8, 2);
        return _getShort(i8);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i8) {
        checkIndex(i8, 3);
        return _getUnsignedMedium(i8);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public long memoryAddress() {
        ensureAccessible();
        return this.memoryAddress;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeDirectSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i8, int i9) {
        checkIndex(i8);
        _setByte(i8, i9);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.buffer.UnpooledDirectByteBuf
    public final void setByteBuffer(ByteBuffer byteBuffer, boolean z7) {
        super.setByteBuffer(byteBuffer, z7);
        this.memoryAddress = PlatformDependent.directBufferAddress(byteBuffer);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        UnsafeByteBufUtil.setBytes(this, addr(i8), i8, byteBuf, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i8, int i9) {
        checkIndex(i8, 4);
        _setInt(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i8, long j8) {
        checkIndex(i8, 8);
        _setLong(i8, j8);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i8, int i9) {
        checkIndex(i8, 3);
        _setMedium(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i8, int i9) {
        checkIndex(i8, 2);
        _setShort(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i8, int i9) {
        checkIndex(i8, i9);
        UnsafeByteBufUtil.setZero(addr(i8), i9);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i8) {
        super(byteBufAllocator, byteBuffer, i8, false, true);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    void getBytes(int i8, byte[] bArr, int i9, int i10, boolean z7) {
        UnsafeByteBufUtil.getBytes(this, addr(i8), i8, bArr, i9, i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, byte[] bArr, int i9, int i10) {
        UnsafeByteBufUtil.setBytes(this, addr(i8), i8, bArr, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    void getBytes(int i8, ByteBuffer byteBuffer, boolean z7) {
        UnsafeByteBufUtil.getBytes(this, addr(i8), i8, byteBuffer);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.setBytes(this, addr(i8), i8, byteBuffer);
        return this;
    }
}
