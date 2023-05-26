package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class WrappedByteBuf extends ByteBuf {
    protected final ByteBuf buf;

    /* JADX INFO: Access modifiers changed from: protected */
    public WrappedByteBuf(ByteBuf byteBuf) {
        this.buf = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "buf");
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.buf.alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.buf.array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return this.buf.asReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.buf.capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf clear() {
        this.buf.clear();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        this.buf.discardSomeReadBytes();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this.buf.duplicate();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i8) {
        this.buf.ensureWritable(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        return this.buf.equals(obj);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        return this.buf.forEachByte(byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i8) {
        return this.buf.getByte(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        this.buf.getBytes(i8, byteBuf, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i8) {
        return this.buf.getInt(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i8) {
        return this.buf.getIntLE(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i8) {
        return this.buf.getLong(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i8) {
        return this.buf.getMedium(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i8) {
        return this.buf.getShort(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i8) {
        return this.buf.getShortLE(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i8) {
        return this.buf.getUnsignedByte(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i8) {
        return this.buf.getUnsignedInt(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i8) {
        return this.buf.getUnsignedIntLE(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i8) {
        return this.buf.getUnsignedMedium(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i8) {
        return this.buf.getUnsignedShort(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i8) {
        return this.buf.getUnsignedShortLE(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.buf.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return this.buf.hashCode();
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i8, int i9, byte b8) {
        return this.buf.indexOf(i8, i9, b8);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i8, int i9) {
        return this.buf.internalNioBuffer(i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.buffer.ByteBuf
    public final boolean isAccessible() {
        return this.buf.isAccessible();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return this.buf.isContiguous();
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return this.buf.isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return this.buf.isReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isReadable() {
        return this.buf.isReadable();
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isWritable(int i8) {
        return this.buf.isWritable(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf markReaderIndex() {
        this.buf.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int maxCapacity() {
        return this.buf.maxCapacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return this.buf.maxFastWritableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        return this.buf.memoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer();
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return this.buf.nioBuffers();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return this.buf.order();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        return this.buf.readByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i8) {
        return this.buf.readBytes(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        return this.buf.readInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        return this.buf.readLong();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i8) {
        return this.buf.readRetainedSlice(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        return this.buf.readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i8) {
        return this.buf.readSlice(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return this.buf.readUnsignedInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return this.buf.readUnsignedShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readableBytes() {
        return this.buf.readableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readerIndex() {
        return this.buf.readerIndex();
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.buf.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.buf.release();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf resetReaderIndex() {
        this.buf.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this.buf.retainedDuplicate();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this.buf.retainedSlice();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i8, int i9) {
        this.buf.setByte(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        this.buf.setBytes(i8, byteBuf, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i8, CharSequence charSequence, Charset charset) {
        return this.buf.setCharSequence(i8, charSequence, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i8, int i9) {
        this.buf.setIndex(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i8, int i9) {
        this.buf.setInt(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i8, long j8) {
        this.buf.setLong(i8, j8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i8, int i9) {
        this.buf.setMedium(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i8, int i9) {
        this.buf.setMediumLE(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i8, int i9) {
        this.buf.setShort(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i8, int i9) {
        this.buf.setShortLE(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i8, int i9) {
        this.buf.setZero(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i8) {
        this.buf.skipBytes(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this.buf.slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return this.buf.toString(charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return this.buf;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writableBytes() {
        return this.buf.writableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i8) {
        this.buf.writeByte(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        this.buf.writeBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        return this.buf.writeCharSequence(charSequence, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i8) {
        this.buf.writeInt(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j8) {
        this.buf.writeLong(j8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i8) {
        this.buf.writeMedium(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i8) {
        this.buf.writeMediumLE(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i8) {
        this.buf.writeShort(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i8) {
        this.buf.writeShortLE(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writerIndex() {
        return this.buf.writerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i8) {
        this.buf.capacity(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return this.buf.compareTo(byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i8, boolean z7) {
        return this.buf.ensureWritable(i8, z7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i8, int i9, ByteProcessor byteProcessor) {
        return this.buf.forEachByte(i8, i9, byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr) {
        this.buf.getBytes(i8, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i8, int i9) {
        return this.buf.nioBuffer(i8, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i8, int i9) {
        return this.buf.nioBuffers(i8, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        return this.buf.order(byteOrder);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        this.buf.readBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readerIndex(int i8) {
        this.buf.readerIndex(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        this.buf.retain();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, byte[] bArr, int i9, int i10) {
        this.buf.setBytes(i8, bArr, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i8, int i9) {
        return this.buf.slice(i8, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + this.buf.toString() + ')';
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        this.buf.touch(obj);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i8, int i9) {
        this.buf.writeBytes(byteBuf, i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writerIndex(int i8) {
        this.buf.writerIndex(i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr, int i9, int i10) {
        this.buf.getBytes(i8, bArr, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        this.buf.readBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuffer byteBuffer) {
        this.buf.setBytes(i8, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        this.buf.writeBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuffer byteBuffer) {
        this.buf.getBytes(i8, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i8, int i9) {
        this.buf.readBytes(bArr, i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i8, ScatteringByteChannel scatteringByteChannel, int i9) throws IOException {
        return this.buf.setBytes(i8, scatteringByteChannel, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i8, int i9) {
        this.buf.writeBytes(bArr, i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i8, GatheringByteChannel gatheringByteChannel, int i9) throws IOException {
        return this.buf.getBytes(i8, gatheringByteChannel, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        this.buf.readBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        this.buf.writeBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i8) throws IOException {
        return this.buf.readBytes(gatheringByteChannel, i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i8) throws IOException {
        return this.buf.writeBytes(scatteringByteChannel, i8);
    }
}
