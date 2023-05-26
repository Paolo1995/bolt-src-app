package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* loaded from: classes5.dex */
public class UnpooledDirectByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    ByteBuffer buffer;
    private int capacity;
    private boolean doNotFree;
    private ByteBuffer tmpNioBuf;

    public UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator, int i8, int i9) {
        super(i9);
        ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        ObjectUtil.checkPositiveOrZero(i8, "initialCapacity");
        ObjectUtil.checkPositiveOrZero(i9, "maxCapacity");
        if (i8 <= i9) {
            this.alloc = byteBufAllocator;
            setByteBuffer(allocateDirect(i8), false);
            return;
        }
        throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(i8), Integer.valueOf(i9)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i8) {
        return this.buffer.get(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i8) {
        return this.buffer.getInt(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i8) {
        return ByteBufUtil.swapInt(this.buffer.getInt(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i8) {
        return this.buffer.getLong(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i8) {
        return this.buffer.getShort(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i8) {
        return ByteBufUtil.swapShort(this.buffer.getShort(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i8) {
        return (getByte(i8 + 2) & 255) | ((getByte(i8) & 255) << 16) | ((getByte(i8 + 1) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i8, int i9) {
        this.buffer.put(i8, (byte) i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i8, int i9) {
        this.buffer.putInt(i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i8, long j8) {
        this.buffer.putLong(i8, j8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i8, int i9) {
        setByte(i8, (byte) (i9 >>> 16));
        setByte(i8 + 1, (byte) (i9 >>> 8));
        setByte(i8 + 2, (byte) i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i8, int i9) {
        setByte(i8, (byte) i9);
        setByte(i8 + 1, (byte) (i9 >>> 8));
        setByte(i8 + 2, (byte) (i9 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i8, int i9) {
        this.buffer.putShort(i8, (short) i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i8, int i9) {
        this.buffer.putShort(i8, ByteBufUtil.swapShort((short) i9));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteBuffer allocateDirect(int i8) {
        return ByteBuffer.allocateDirect(i8);
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
    public int capacity() {
        return this.capacity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null) {
            return;
        }
        this.buffer = null;
        if (!this.doNotFree) {
            freeDirect(byteBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectBuffer(byteBuffer);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i8) {
        ensureAccessible();
        return _getByte(i8);
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

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i8) {
        ensureAccessible();
        return _getInt(i8);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i8) {
        ensureAccessible();
        return _getLong(i8);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i8) {
        ensureAccessible();
        return _getShort(i8);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i8) {
        ensureAccessible();
        return _getUnsignedMedium(i8);
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
    public ByteBuffer internalNioBuffer(int i8, int i9) {
        checkIndex(i8, i9);
        return (ByteBuffer) internalNioBuffer().clear().position(i8).limit(i8 + i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isContiguous() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i8, int i9) {
        checkIndex(i8, i9);
        return ((ByteBuffer) this.buffer.duplicate().position(i8).limit(i8 + i9)).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i8, int i9) {
        return new ByteBuffer[]{nioBuffer(i8, i9)};
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i8, int i9) {
        checkReadableBytes(i9);
        getBytes(this.readerIndex, bArr, i8, i9, true);
        this.readerIndex += i9;
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i8, int i9) {
        ensureAccessible();
        _setByte(i8, i9);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setByteBuffer(ByteBuffer byteBuffer, boolean z7) {
        ByteBuffer byteBuffer2;
        if (z7 && (byteBuffer2 = this.buffer) != null) {
            if (this.doNotFree) {
                this.doNotFree = false;
            } else {
                freeDirect(byteBuffer2);
            }
        }
        this.buffer = byteBuffer;
        this.tmpNioBuf = null;
        this.capacity = byteBuffer.remaining();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkSrcIndex(i8, i10, i9, byteBuf.capacity());
        if (byteBuf.nioBufferCount() > 0) {
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

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i8, int i9) {
        ensureAccessible();
        _setInt(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i8, long j8) {
        ensureAccessible();
        _setLong(i8, j8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i8, int i9) {
        ensureAccessible();
        _setMedium(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i8, int i9) {
        ensureAccessible();
        _setShort(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i8) {
        checkNewCapacity(i8);
        int i9 = this.capacity;
        if (i8 == i9) {
            return this;
        }
        if (i8 <= i9) {
            trimIndicesToCapacity(i8);
            i9 = i8;
        }
        ByteBuffer byteBuffer = this.buffer;
        ByteBuffer allocateDirect = allocateDirect(i8);
        byteBuffer.position(0).limit(i9);
        allocateDirect.position(0).limit(i9);
        allocateDirect.put(byteBuffer).clear();
        setByteBuffer(allocateDirect, true);
        return this;
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer == null) {
            ByteBuffer duplicate = this.buffer.duplicate();
            this.tmpNioBuf = duplicate;
            return duplicate;
        }
        return byteBuffer;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer, true);
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, byte[] bArr, int i9, int i10) {
        checkSrcIndex(i8, i10, i9, bArr.length);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i8).limit(i8 + i10);
        internalNioBuffer.put(bArr, i9, i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i8) throws IOException {
        checkReadableBytes(i8);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i8, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr, int i9, int i10) {
        getBytes(i8, bArr, i9, i10, false);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i8) {
        this(byteBufAllocator, byteBuffer, i8, false, true);
    }

    void getBytes(int i8, byte[] bArr, int i9, int i10, boolean z7) {
        ByteBuffer duplicate;
        checkDstIndex(i8, i10, i9, bArr.length);
        if (z7) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = this.buffer.duplicate();
        }
        duplicate.clear().position(i8).limit(i8 + i10);
        duplicate.get(bArr, i9, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i8, boolean z7, boolean z8) {
        super(i8);
        ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        ObjectUtil.checkNotNull(byteBuffer, "initialBuffer");
        if (byteBuffer.isDirect()) {
            if (!byteBuffer.isReadOnly()) {
                int remaining = byteBuffer.remaining();
                if (remaining <= i8) {
                    this.alloc = byteBufAllocator;
                    this.doNotFree = !z7;
                    setByteBuffer((z8 ? byteBuffer.slice() : byteBuffer).order(ByteOrder.BIG_ENDIAN), false);
                    writerIndex(remaining);
                    return;
                }
                throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(remaining), Integer.valueOf(i8)));
            }
            throw new IllegalArgumentException("initialBuffer is a read-only buffer.");
        }
        throw new IllegalArgumentException("initialBuffer is not a direct buffer.");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuffer byteBuffer) {
        ensureAccessible();
        ByteBuffer internalNioBuffer = internalNioBuffer();
        if (byteBuffer == internalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        internalNioBuffer.clear().position(i8).limit(i8 + byteBuffer.remaining());
        internalNioBuffer.put(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuffer byteBuffer) {
        getBytes(i8, byteBuffer, false);
        return this;
    }

    void getBytes(int i8, ByteBuffer byteBuffer, boolean z7) {
        ByteBuffer duplicate;
        checkIndex(i8, byteBuffer.remaining());
        if (z7) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = this.buffer.duplicate();
        }
        duplicate.clear().position(i8).limit(i8 + byteBuffer.remaining());
        byteBuffer.put(duplicate);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i8, ScatteringByteChannel scatteringByteChannel, int i9) throws IOException {
        ensureAccessible();
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i8).limit(i8 + i9);
        try {
            return scatteringByteChannel.read(internalNioBuffer);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i8, GatheringByteChannel gatheringByteChannel, int i9) throws IOException {
        return getBytes(i8, gatheringByteChannel, i9, false);
    }

    private int getBytes(int i8, GatheringByteChannel gatheringByteChannel, int i9, boolean z7) throws IOException {
        ByteBuffer duplicate;
        ensureAccessible();
        if (i9 == 0) {
            return 0;
        }
        if (z7) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = this.buffer.duplicate();
        }
        duplicate.clear().position(i8).limit(i8 + i9);
        return gatheringByteChannel.write(duplicate);
    }
}
