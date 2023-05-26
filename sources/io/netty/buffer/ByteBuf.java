package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public abstract class ByteBuf implements ReferenceCounted, Comparable<ByteBuf> {
    public abstract ByteBufAllocator alloc();

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract ByteBuf asReadOnly();

    public abstract int capacity();

    public abstract ByteBuf capacity(int i8);

    public abstract ByteBuf clear();

    @Override // java.lang.Comparable
    public abstract int compareTo(ByteBuf byteBuf);

    public abstract ByteBuf discardSomeReadBytes();

    public abstract ByteBuf duplicate();

    public abstract int ensureWritable(int i8, boolean z7);

    public abstract ByteBuf ensureWritable(int i8);

    public abstract boolean equals(Object obj);

    public abstract int forEachByte(int i8, int i9, ByteProcessor byteProcessor);

    public abstract int forEachByte(ByteProcessor byteProcessor);

    public abstract byte getByte(int i8);

    public abstract int getBytes(int i8, GatheringByteChannel gatheringByteChannel, int i9) throws IOException;

    public abstract ByteBuf getBytes(int i8, ByteBuf byteBuf, int i9, int i10);

    public abstract ByteBuf getBytes(int i8, ByteBuffer byteBuffer);

    public abstract ByteBuf getBytes(int i8, byte[] bArr);

    public abstract ByteBuf getBytes(int i8, byte[] bArr, int i9, int i10);

    public abstract int getInt(int i8);

    public abstract int getIntLE(int i8);

    public abstract long getLong(int i8);

    public abstract int getMedium(int i8);

    public abstract short getShort(int i8);

    public abstract short getShortLE(int i8);

    public abstract short getUnsignedByte(int i8);

    public abstract long getUnsignedInt(int i8);

    public abstract long getUnsignedIntLE(int i8);

    public abstract int getUnsignedMedium(int i8);

    public abstract int getUnsignedShort(int i8);

    public abstract int getUnsignedShortLE(int i8);

    public abstract boolean hasArray();

    public abstract boolean hasMemoryAddress();

    public abstract int hashCode();

    public abstract int indexOf(int i8, int i9, byte b8);

    public abstract ByteBuffer internalNioBuffer(int i8, int i9);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAccessible() {
        if (refCnt() != 0) {
            return true;
        }
        return false;
    }

    public boolean isContiguous() {
        return false;
    }

    public abstract boolean isDirect();

    public abstract boolean isReadOnly();

    public abstract boolean isReadable();

    public abstract boolean isWritable(int i8);

    public abstract ByteBuf markReaderIndex();

    public abstract int maxCapacity();

    public int maxFastWritableBytes() {
        return writableBytes();
    }

    public abstract int maxWritableBytes();

    public abstract long memoryAddress();

    public abstract ByteBuffer nioBuffer();

    public abstract ByteBuffer nioBuffer(int i8, int i9);

    public abstract int nioBufferCount();

    public abstract ByteBuffer[] nioBuffers();

    public abstract ByteBuffer[] nioBuffers(int i8, int i9);

    @Deprecated
    public abstract ByteBuf order(ByteOrder byteOrder);

    @Deprecated
    public abstract ByteOrder order();

    public abstract byte readByte();

    public abstract int readBytes(GatheringByteChannel gatheringByteChannel, int i8) throws IOException;

    public abstract ByteBuf readBytes(int i8);

    public abstract ByteBuf readBytes(ByteBuf byteBuf);

    public abstract ByteBuf readBytes(ByteBuffer byteBuffer);

    public abstract ByteBuf readBytes(byte[] bArr);

    public abstract ByteBuf readBytes(byte[] bArr, int i8, int i9);

    public abstract int readInt();

    public abstract long readLong();

    public abstract ByteBuf readRetainedSlice(int i8);

    public abstract short readShort();

    public abstract ByteBuf readSlice(int i8);

    public abstract short readUnsignedByte();

    public abstract long readUnsignedInt();

    public abstract int readUnsignedShort();

    public abstract int readableBytes();

    public abstract int readerIndex();

    public abstract ByteBuf readerIndex(int i8);

    public abstract ByteBuf resetReaderIndex();

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf retain();

    public abstract ByteBuf retainedDuplicate();

    public abstract ByteBuf retainedSlice();

    public abstract ByteBuf setByte(int i8, int i9);

    public abstract int setBytes(int i8, ScatteringByteChannel scatteringByteChannel, int i9) throws IOException;

    public abstract ByteBuf setBytes(int i8, ByteBuf byteBuf, int i9, int i10);

    public abstract ByteBuf setBytes(int i8, ByteBuffer byteBuffer);

    public abstract ByteBuf setBytes(int i8, byte[] bArr, int i9, int i10);

    public abstract int setCharSequence(int i8, CharSequence charSequence, Charset charset);

    public abstract ByteBuf setIndex(int i8, int i9);

    public abstract ByteBuf setInt(int i8, int i9);

    public abstract ByteBuf setLong(int i8, long j8);

    public abstract ByteBuf setMedium(int i8, int i9);

    public abstract ByteBuf setMediumLE(int i8, int i9);

    public abstract ByteBuf setShort(int i8, int i9);

    public abstract ByteBuf setShortLE(int i8, int i9);

    public abstract ByteBuf setZero(int i8, int i9);

    public abstract ByteBuf skipBytes(int i8);

    public abstract ByteBuf slice();

    public abstract ByteBuf slice(int i8, int i9);

    public abstract String toString();

    public abstract String toString(Charset charset);

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf touch(Object obj);

    public abstract ByteBuf unwrap();

    public abstract int writableBytes();

    public abstract ByteBuf writeByte(int i8);

    public abstract int writeBytes(ScatteringByteChannel scatteringByteChannel, int i8) throws IOException;

    public abstract ByteBuf writeBytes(ByteBuf byteBuf);

    public abstract ByteBuf writeBytes(ByteBuf byteBuf, int i8, int i9);

    public abstract ByteBuf writeBytes(ByteBuffer byteBuffer);

    public abstract ByteBuf writeBytes(byte[] bArr);

    public abstract ByteBuf writeBytes(byte[] bArr, int i8, int i9);

    public abstract int writeCharSequence(CharSequence charSequence, Charset charset);

    public abstract ByteBuf writeInt(int i8);

    public abstract ByteBuf writeLong(long j8);

    public abstract ByteBuf writeMedium(int i8);

    public abstract ByteBuf writeMediumLE(int i8);

    public abstract ByteBuf writeShort(int i8);

    public abstract ByteBuf writeShortLE(int i8);

    public abstract int writerIndex();

    public abstract ByteBuf writerIndex(int i8);
}
