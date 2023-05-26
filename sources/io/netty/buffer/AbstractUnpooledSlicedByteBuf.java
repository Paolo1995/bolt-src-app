package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.MathUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class AbstractUnpooledSlicedByteBuf extends AbstractDerivedByteBuf {
    private final int adjustment;
    private final ByteBuf buffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractUnpooledSlicedByteBuf(ByteBuf byteBuf, int i8, int i9) {
        super(i9);
        checkSliceOutOfBounds(i8, i9, byteBuf);
        if (byteBuf instanceof AbstractUnpooledSlicedByteBuf) {
            AbstractUnpooledSlicedByteBuf abstractUnpooledSlicedByteBuf = (AbstractUnpooledSlicedByteBuf) byteBuf;
            this.buffer = abstractUnpooledSlicedByteBuf.buffer;
            this.adjustment = abstractUnpooledSlicedByteBuf.adjustment + i8;
        } else if (byteBuf instanceof DuplicatedByteBuf) {
            this.buffer = byteBuf.unwrap();
            this.adjustment = i8;
        } else {
            this.buffer = byteBuf;
            this.adjustment = i8;
        }
        initLength(i9);
        writerIndex(i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkSliceOutOfBounds(int i8, int i9, ByteBuf byteBuf) {
        if (!MathUtil.isOutOfBounds(i8, i9, byteBuf.capacity())) {
            return;
        }
        throw new IndexOutOfBoundsException(byteBuf + ".slice(" + i8 + ", " + i9 + ')');
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i8) {
        return unwrap().getByte(idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i8) {
        return unwrap().getInt(idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i8) {
        return unwrap().getIntLE(idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i8) {
        return unwrap().getLong(idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i8) {
        return unwrap().getShort(idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i8) {
        return unwrap().getShortLE(idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i8) {
        return unwrap().getUnsignedMedium(idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i8, int i9) {
        unwrap().setByte(idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i8, int i9) {
        unwrap().setInt(idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i8, long j8) {
        unwrap().setLong(idx(i8), j8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i8, int i9) {
        unwrap().setMedium(idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i8, int i9) {
        unwrap().setMediumLE(idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i8, int i9) {
        unwrap().setShort(idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i8, int i9) {
        unwrap().setShortLE(idx(i8), i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return unwrap().alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return unwrap().array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return idx(unwrap().arrayOffset());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i8) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return unwrap().duplicate().setIndex(idx(readerIndex()), idx(writerIndex()));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i8, int i9, ByteProcessor byteProcessor) {
        checkIndex0(i8, i9);
        int forEachByte = unwrap().forEachByte(idx(i8), i9, byteProcessor);
        int i10 = this.adjustment;
        if (forEachByte >= i10) {
            return forEachByte - i10;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i8) {
        checkIndex0(i8, 1);
        return unwrap().getByte(idx(i8));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkIndex0(i8, i10);
        unwrap().getBytes(idx(i8), byteBuf, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i8) {
        checkIndex0(i8, 4);
        return unwrap().getInt(idx(i8));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i8) {
        checkIndex0(i8, 4);
        return unwrap().getIntLE(idx(i8));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i8) {
        checkIndex0(i8, 8);
        return unwrap().getLong(idx(i8));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i8) {
        checkIndex0(i8, 2);
        return unwrap().getShort(idx(i8));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i8) {
        checkIndex0(i8, 2);
        return unwrap().getShortLE(idx(i8));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i8) {
        checkIndex0(i8, 3);
        return unwrap().getUnsignedMedium(idx(i8));
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return unwrap().hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int idx(int i8) {
        return i8 + this.adjustment;
    }

    void initLength(int i8) {
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return unwrap().isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return unwrap().memoryAddress() + this.adjustment;
    }

    @Override // io.netty.buffer.AbstractDerivedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i8, int i9) {
        checkIndex0(i8, i9);
        return unwrap().nioBuffer(idx(i8), i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i8, int i9) {
        checkIndex0(i8, i9);
        return unwrap().nioBuffers(idx(i8), i9);
    }

    @Override // io.netty.buffer.ByteBuf
    @Deprecated
    public ByteOrder order() {
        return unwrap().order();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i8, int i9) {
        checkIndex0(i8, 1);
        unwrap().setByte(idx(i8), i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, byte[] bArr, int i9, int i10) {
        checkIndex0(i8, i10);
        unwrap().setBytes(idx(i8), bArr, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i8, int i9) {
        checkIndex0(i8, 4);
        unwrap().setInt(idx(i8), i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i8, long j8) {
        checkIndex0(i8, 8);
        unwrap().setLong(idx(i8), j8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i8, int i9) {
        checkIndex0(i8, 3);
        unwrap().setMedium(idx(i8), i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i8, int i9) {
        checkIndex0(i8, 3);
        unwrap().setMediumLE(idx(i8), i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i8, int i9) {
        checkIndex0(i8, 2);
        unwrap().setShort(idx(i8), i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i8, int i9) {
        checkIndex0(i8, 2);
        unwrap().setShortLE(idx(i8), i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i8, int i9) {
        checkIndex0(i8, i9);
        return unwrap().slice(idx(i8), i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr, int i9, int i10) {
        checkIndex0(i8, i10);
        unwrap().getBytes(idx(i8), bArr, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkIndex0(i8, i10);
        unwrap().setBytes(idx(i8), byteBuf, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuffer byteBuffer) {
        checkIndex0(i8, byteBuffer.remaining());
        unwrap().getBytes(idx(i8), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuffer byteBuffer) {
        checkIndex0(i8, byteBuffer.remaining());
        unwrap().setBytes(idx(i8), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i8, GatheringByteChannel gatheringByteChannel, int i9) throws IOException {
        checkIndex0(i8, i9);
        return unwrap().getBytes(idx(i8), gatheringByteChannel, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i8, ScatteringByteChannel scatteringByteChannel, int i9) throws IOException {
        checkIndex0(i8, i9);
        return unwrap().setBytes(idx(i8), scatteringByteChannel, i9);
    }
}
