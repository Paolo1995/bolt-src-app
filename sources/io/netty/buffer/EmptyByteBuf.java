package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public final class EmptyByteBuf extends ByteBuf {
    private static final ByteBuffer EMPTY_BYTE_BUFFER;
    private static final long EMPTY_BYTE_BUFFER_ADDRESS;
    private final ByteBufAllocator alloc;
    private final ByteOrder order;
    private final String str;
    private EmptyByteBuf swapped;

    static {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(0);
        EMPTY_BYTE_BUFFER = allocateDirect;
        long j8 = 0;
        try {
            if (PlatformDependent.hasUnsafe()) {
                j8 = PlatformDependent.directBufferAddress(allocateDirect);
            }
        } catch (Throwable unused) {
        }
        EMPTY_BYTE_BUFFER_ADDRESS = j8;
    }

    public EmptyByteBuf(ByteBufAllocator byteBufAllocator) {
        this(byteBufAllocator, ByteOrder.BIG_ENDIAN);
    }

    private ByteBuf checkIndex(int i8) {
        if (i8 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    private ByteBuf checkLength(int i8) {
        ObjectUtil.checkPositiveOrZero(i8, Name.LENGTH);
        if (i8 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return EmptyArrays.EMPTY_BYTES;
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i8) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i8) {
        ObjectUtil.checkPositiveOrZero(i8, "minWritableBytes");
        if (i8 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        if ((obj instanceof ByteBuf) && !((ByteBuf) obj).isReadable()) {
            return true;
        }
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i8, int i9, ByteProcessor byteProcessor) {
        checkIndex(i8, i9);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        return checkIndex(i8, i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        if (EMPTY_BYTE_BUFFER_ADDRESS != 0) {
            return true;
        }
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i8, int i9, byte b8) {
        checkIndex(i8);
        checkIndex(i9);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i8, int i9) {
        return EMPTY_BYTE_BUFFER;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable(int i8) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        if (hasMemoryAddress()) {
            return EMPTY_BYTE_BUFFER_ADDRESS;
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return EMPTY_BYTE_BUFFER;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return new ByteBuffer[]{EMPTY_BYTE_BUFFER};
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i8) {
        return checkLength(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i8) {
        return checkLength(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i8) {
        return checkLength(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i8) {
        return checkIndex(i8);
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return 1;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i8, int i9) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        return checkIndex(i8, i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i8, CharSequence charSequence, Charset charset) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i8, int i9) {
        checkIndex(i8);
        checkIndex(i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i8, int i9) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i8, long j8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i8, int i9) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i8, int i9) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i8, int i9) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i8, int i9) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i8, int i9) {
        return checkIndex(i8, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i8) {
        return checkLength(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i8, int i9) {
        return checkIndex(i8, i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        return this.str;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return "";
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        return checkLength(byteBuf.readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i8) {
        return checkIndex(i8);
    }

    private EmptyByteBuf(ByteBufAllocator byteBufAllocator, ByteOrder byteOrder) {
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        this.order = byteOrder;
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append(byteOrder == ByteOrder.BIG_ENDIAN ? "BE" : "LE");
        this.str = sb.toString();
    }

    private ByteBuf checkIndex(int i8, int i9) {
        ObjectUtil.checkPositiveOrZero(i9, Name.LENGTH);
        if (i8 == 0 && i9 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return byteBuf.isReadable() ? -1 : 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr) {
        return checkIndex(i8, bArr.length);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i8, int i9) {
        checkIndex(i8, i9);
        return nioBuffer();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i8, int i9) {
        checkIndex(i8, i9);
        return nioBuffers();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (ObjectUtil.checkNotNull(byteOrder, "endianness") == order()) {
            return this;
        }
        EmptyByteBuf emptyByteBuf = this.swapped;
        if (emptyByteBuf != null) {
            return emptyByteBuf;
        }
        EmptyByteBuf emptyByteBuf2 = new EmptyByteBuf(alloc(), byteOrder);
        this.swapped = emptyByteBuf2;
        return emptyByteBuf2;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        return checkLength(byteBuf.writableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, byte[] bArr, int i9, int i10) {
        return checkIndex(i8, i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i8, int i9) {
        return checkLength(i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i8, boolean z7) {
        ObjectUtil.checkPositiveOrZero(i8, "minWritableBytes");
        return i8 == 0 ? 0 : 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr, int i9, int i10) {
        return checkIndex(i8, i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        return checkLength(bArr.length);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuffer byteBuffer) {
        return checkIndex(i8, byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        return checkLength(bArr.length);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuffer byteBuffer) {
        return checkIndex(i8, byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i8, int i9) {
        return checkLength(i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i8, ScatteringByteChannel scatteringByteChannel, int i9) {
        checkIndex(i8, i9);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i8, int i9) {
        return checkLength(i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i8, GatheringByteChannel gatheringByteChannel, int i9) {
        checkIndex(i8, i9);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        return checkLength(byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        return checkLength(byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i8) {
        checkLength(i8);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i8) {
        checkLength(i8);
        return 0;
    }
}
