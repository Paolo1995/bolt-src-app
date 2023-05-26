package io.netty.handler.codec;

import com.google.android.gms.common.api.Api;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ByteProcessor;
import io.netty.util.Signal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
final class ReplayingDecoderByteBuf extends ByteBuf {
    static final ReplayingDecoderByteBuf EMPTY_BUFFER;
    private static final Signal REPLAY = ReplayingDecoder.REPLAY;
    private ByteBuf buffer;
    private SwappedByteBuf swapped;
    private boolean terminated;

    static {
        ReplayingDecoderByteBuf replayingDecoderByteBuf = new ReplayingDecoderByteBuf(Unpooled.EMPTY_BUFFER);
        EMPTY_BUFFER = replayingDecoderByteBuf;
        replayingDecoderByteBuf.terminate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReplayingDecoderByteBuf() {
    }

    private void checkIndex(int i8, int i9) {
        if (i8 + i9 <= this.buffer.writerIndex()) {
            return;
        }
        throw REPLAY;
    }

    private void checkReadableBytes(int i8) {
        if (this.buffer.readableBytes() >= i8) {
            return;
        }
        throw REPLAY;
    }

    private static UnsupportedOperationException reject() {
        return new UnsupportedOperationException("not a replayable operation");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.buffer.alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.terminated ? this.buffer.capacity() : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        int forEachByte = this.buffer.forEachByte(byteProcessor);
        if (forEachByte >= 0) {
            return forEachByte;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i8) {
        checkIndex(i8, 1);
        return this.buffer.getByte(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr, int i9, int i10) {
        checkIndex(i8, i10);
        this.buffer.getBytes(i8, bArr, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i8) {
        checkIndex(i8, 4);
        return this.buffer.getInt(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i8) {
        checkIndex(i8, 4);
        return this.buffer.getIntLE(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i8) {
        checkIndex(i8, 8);
        return this.buffer.getLong(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i8) {
        checkIndex(i8, 3);
        return this.buffer.getMedium(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i8) {
        checkIndex(i8, 2);
        return this.buffer.getShort(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i8) {
        checkIndex(i8, 2);
        return this.buffer.getShortLE(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i8) {
        checkIndex(i8, 1);
        return this.buffer.getUnsignedByte(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i8) {
        checkIndex(i8, 4);
        return this.buffer.getUnsignedInt(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i8) {
        checkIndex(i8, 4);
        return this.buffer.getUnsignedIntLE(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i8) {
        checkIndex(i8, 3);
        return this.buffer.getUnsignedMedium(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i8) {
        checkIndex(i8, 2);
        return this.buffer.getUnsignedShort(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i8) {
        checkIndex(i8, 2);
        return this.buffer.getUnsignedShortLE(i8);
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
    public int hashCode() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i8, int i9, byte b8) {
        if (i8 == i9) {
            return -1;
        }
        if (Math.max(i8, i9) <= this.buffer.writerIndex()) {
            return this.buffer.indexOf(i8, i9, b8);
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i8, int i9) {
        checkIndex(i8, i9);
        return this.buffer.internalNioBuffer(i8, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        if (this.terminated && !this.buffer.isReadable()) {
            return false;
        }
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable(int i8) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        this.buffer.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.buffer.nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.buffer.order();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        checkReadableBytes(1);
        return this.buffer.readByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i8, int i9) {
        checkReadableBytes(i9);
        this.buffer.readBytes(bArr, i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        checkReadableBytes(4);
        return this.buffer.readInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        checkReadableBytes(8);
        return this.buffer.readLong();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i8) {
        checkReadableBytes(i8);
        return this.buffer.readRetainedSlice(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        checkReadableBytes(2);
        return this.buffer.readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i8) {
        checkReadableBytes(i8);
        return this.buffer.readSlice(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        checkReadableBytes(1);
        return this.buffer.readUnsignedByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        checkReadableBytes(4);
        return this.buffer.readUnsignedInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        checkReadableBytes(2);
        return this.buffer.readUnsignedShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        if (this.terminated) {
            return this.buffer.readableBytes();
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER - this.buffer.readerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.buffer.readerIndex();
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.buffer.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        this.buffer.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i8, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, byte[] bArr, int i9, int i10) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i8, CharSequence charSequence, Charset charset) {
        throw reject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCumulation(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i8, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i8, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i8, long j8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i8, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i8, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i8, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i8, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i8, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i8) {
        checkReadableBytes(i8);
        this.buffer.skipBytes(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        throw reject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void terminate() {
        this.terminated = true;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i8, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.buffer.writerIndex();
    }

    ReplayingDecoderByteBuf(ByteBuf byteBuf) {
        setCumulation(byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i8, boolean z7) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i8, int i9) {
        checkIndex(i8, i9);
        return this.buffer.nioBuffer(i8, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i8, int i9) {
        checkIndex(i8, i9);
        return this.buffer.nioBuffers(i8, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (ObjectUtil.checkNotNull(byteOrder, "endianness") == order()) {
            return this;
        }
        SwappedByteBuf swappedByteBuf = this.swapped;
        if (swappedByteBuf == null) {
            SwappedByteBuf swappedByteBuf2 = new SwappedByteBuf(this);
            this.swapped = swappedByteBuf2;
            return swappedByteBuf2;
        }
        return swappedByteBuf;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i8) {
        this.buffer.readerIndex(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i8, int i9) {
        checkIndex(i8, i9);
        return this.buffer.slice(i8, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        return StringUtil.simpleClassName(this) + "(ridx=" + readerIndex() + ", widx=" + writerIndex() + ')';
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        this.buffer.touch(obj);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i8, int i9, ByteProcessor byteProcessor) {
        int writerIndex = this.buffer.writerIndex();
        if (i8 < writerIndex) {
            if (i8 <= writerIndex - i9) {
                return this.buffer.forEachByte(i8, i9, byteProcessor);
            }
            int forEachByte = this.buffer.forEachByte(i8, writerIndex - i8, byteProcessor);
            if (forEachByte >= 0) {
                return forEachByte;
            }
            throw REPLAY;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr) {
        checkIndex(i8, bArr.length);
        this.buffer.getBytes(i8, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        checkReadableBytes(bArr.length);
        this.buffer.readBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i8, ScatteringByteChannel scatteringByteChannel, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i8, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkIndex(i8, i10);
        this.buffer.getBytes(i8, byteBuf, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        checkReadableBytes(byteBuf.writableBytes());
        this.buffer.readBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i8, GatheringByteChannel gatheringByteChannel, int i9) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i8) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i8) {
        checkReadableBytes(i8);
        return this.buffer.readBytes(i8);
    }
}
