package io.netty.buffer;

import com.google.android.gms.common.api.Api;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class FixedCompositeByteBuf extends AbstractReferenceCountedByteBuf {
    private static final ByteBuf[] EMPTY = {Unpooled.EMPTY_BUFFER};
    private final ByteBufAllocator allocator;
    private final ByteBuf[] buffers;
    private final int capacity;
    private final boolean direct;
    private final int nioBufferCount;
    private final ByteOrder order;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Component extends WrappedByteBuf {
        private final int endOffset;
        private final int index;
        private final int offset;

        Component(int i8, int i9, ByteBuf byteBuf) {
            super(byteBuf);
            this.index = i8;
            this.offset = i9;
            this.endOffset = i9 + byteBuf.readableBytes();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FixedCompositeByteBuf(ByteBufAllocator byteBufAllocator, ByteBuf... byteBufArr) {
        super(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (byteBufArr.length == 0) {
            this.buffers = EMPTY;
            this.order = ByteOrder.BIG_ENDIAN;
            this.nioBufferCount = 1;
            this.capacity = 0;
            this.direct = Unpooled.EMPTY_BUFFER.isDirect();
        } else {
            ByteBuf byteBuf = byteBufArr[0];
            this.buffers = byteBufArr;
            int nioBufferCount = byteBuf.nioBufferCount();
            int readableBytes = byteBuf.readableBytes();
            this.order = byteBuf.order();
            boolean z7 = true;
            for (int i8 = 1; i8 < byteBufArr.length; i8++) {
                ByteBuf byteBuf2 = byteBufArr[i8];
                if (byteBuf2.order() == this.order) {
                    nioBufferCount += byteBuf2.nioBufferCount();
                    readableBytes += byteBuf2.readableBytes();
                    if (!byteBuf2.isDirect()) {
                        z7 = false;
                    }
                } else {
                    throw new IllegalArgumentException("All ByteBufs need to have same ByteOrder");
                }
            }
            this.nioBufferCount = nioBufferCount;
            this.capacity = readableBytes;
            this.direct = z7;
        }
        setIndex(0, capacity());
        this.allocator = byteBufAllocator;
    }

    private ByteBuf buffer(int i8) {
        ByteBuf byteBuf = this.buffers[i8];
        if (byteBuf instanceof Component) {
            return ((Component) byteBuf).buf;
        }
        return byteBuf;
    }

    private Component findComponent(int i8) {
        int i9 = 0;
        int i10 = 0;
        while (true) {
            ByteBuf[] byteBufArr = this.buffers;
            if (i9 < byteBufArr.length) {
                Component component = null;
                ByteBuf byteBuf = byteBufArr[i9];
                if (byteBuf instanceof Component) {
                    component = (Component) byteBuf;
                    byteBuf = component.buf;
                }
                i10 += byteBuf.readableBytes();
                if (i8 < i10) {
                    if (component == null) {
                        Component component2 = new Component(i9, i10 - byteBuf.readableBytes(), byteBuf);
                        this.buffers[i9] = component2;
                        return component2;
                    }
                    return component;
                }
                i9++;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i8) {
        Component findComponent = findComponent(i8);
        return findComponent.buf.getByte(i8 - findComponent.offset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i8) {
        Component findComponent = findComponent(i8);
        if (i8 + 4 <= findComponent.endOffset) {
            return findComponent.buf.getInt(i8 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i8 + 2) & 65535) | ((_getShort(i8) & 65535) << 16);
        }
        return ((_getShort(i8 + 2) & 65535) << 16) | (_getShort(i8) & 65535);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i8) {
        Component findComponent = findComponent(i8);
        if (i8 + 4 <= findComponent.endOffset) {
            return findComponent.buf.getIntLE(i8 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i8 + 2) & 65535) << 16) | (_getShortLE(i8) & 65535);
        }
        return (_getShortLE(i8 + 2) & 65535) | ((_getShortLE(i8) & 65535) << 16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i8) {
        Component findComponent = findComponent(i8);
        if (i8 + 8 <= findComponent.endOffset) {
            return findComponent.buf.getLong(i8 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getInt(i8) & 4294967295L) << 32) | (_getInt(i8 + 4) & 4294967295L);
        }
        return (_getInt(i8) & 4294967295L) | ((4294967295L & _getInt(i8 + 4)) << 32);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i8) {
        Component findComponent = findComponent(i8);
        if (i8 + 2 <= findComponent.endOffset) {
            return findComponent.buf.getShort(i8 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i8 + 1) & 255) | ((_getByte(i8) & 255) << 8));
        }
        return (short) (((_getByte(i8 + 1) & 255) << 8) | (_getByte(i8) & 255));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i8) {
        Component findComponent = findComponent(i8);
        if (i8 + 2 <= findComponent.endOffset) {
            return findComponent.buf.getShortLE(i8 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i8 + 1) & 255) << 8) | (_getByte(i8) & 255));
        }
        return (short) ((_getByte(i8 + 1) & 255) | ((_getByte(i8) & 255) << 8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i8) {
        Component findComponent = findComponent(i8);
        if (i8 + 3 <= findComponent.endOffset) {
            return findComponent.buf.getUnsignedMedium(i8 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i8 + 2) & 255) | ((_getShort(i8) & 65535) << 8);
        }
        return ((_getByte(i8 + 2) & 255) << 16) | (_getShort(i8) & 65535);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i8, int i9) {
        throw new ReadOnlyBufferException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i8, int i9) {
        throw new ReadOnlyBufferException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i8, long j8) {
        throw new ReadOnlyBufferException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i8, int i9) {
        throw new ReadOnlyBufferException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i8, int i9) {
        throw new ReadOnlyBufferException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i8, int i9) {
        throw new ReadOnlyBufferException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i8, int i9) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        int length = this.buffers.length;
        if (length != 0) {
            if (length == 1) {
                return buffer(0).array();
            }
            throw new UnsupportedOperationException();
        }
        return EmptyArrays.EMPTY_BYTES;
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        int length = this.buffers.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return buffer(0).arrayOffset();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
        for (int i8 = 0; i8 < this.buffers.length; i8++) {
            buffer(i8).release();
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i8) {
        return _getByte(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr, int i9, int i10) {
        checkDstIndex(i8, i10, i9, bArr.length);
        if (i10 == 0) {
            return this;
        }
        Component findComponent = findComponent(i8);
        int i11 = findComponent.index;
        int i12 = findComponent.offset;
        ByteBuf byteBuf = findComponent.buf;
        while (true) {
            int i13 = i8 - i12;
            int min = Math.min(i10, byteBuf.readableBytes() - i13);
            byteBuf.getBytes(i13, bArr, i9, min);
            i8 += min;
            i9 += min;
            i10 -= min;
            i12 += byteBuf.readableBytes();
            if (i10 <= 0) {
                return this;
            }
            i11++;
            byteBuf = buffer(i11);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        int length = this.buffers.length;
        if (length == 0) {
            return true;
        }
        if (length != 1) {
            return false;
        }
        return buffer(0).hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        int length = this.buffers.length;
        if (length != 0) {
            if (length != 1) {
                return false;
            }
            return buffer(0).hasMemoryAddress();
        }
        return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i8, int i9) {
        if (this.buffers.length == 1) {
            return buffer(0).internalNioBuffer(i8, i9);
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.direct;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isWritable(int i8) {
        return false;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        int length = this.buffers.length;
        if (length != 0) {
            if (length == 1) {
                return buffer(0).memoryAddress();
            }
            throw new UnsupportedOperationException();
        }
        return Unpooled.EMPTY_BUFFER.memoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i8, int i9) {
        checkIndex(i8, i9);
        if (this.buffers.length == 1) {
            ByteBuf buffer = buffer(0);
            if (buffer.nioBufferCount() == 1) {
                return buffer.nioBuffer(i8, i9);
            }
        }
        ByteBuffer order = ByteBuffer.allocate(i9).order(order());
        for (ByteBuffer byteBuffer : nioBuffers(i8, i9)) {
            order.put(byteBuffer);
        }
        order.flip();
        return order;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i8, int i9) {
        checkIndex(i8, i9);
        if (i9 == 0) {
            return EmptyArrays.EMPTY_BYTE_BUFFERS;
        }
        RecyclableArrayList newInstance = RecyclableArrayList.newInstance(this.buffers.length);
        try {
            Component findComponent = findComponent(i8);
            int i10 = findComponent.index;
            int i11 = findComponent.offset;
            ByteBuf byteBuf = findComponent.buf;
            while (true) {
                int i12 = i8 - i11;
                int min = Math.min(i9, byteBuf.readableBytes() - i12);
                int nioBufferCount = byteBuf.nioBufferCount();
                if (nioBufferCount != 0) {
                    if (nioBufferCount != 1) {
                        Collections.addAll(newInstance, byteBuf.nioBuffers(i12, min));
                    } else {
                        newInstance.add(byteBuf.nioBuffer(i12, min));
                    }
                    i8 += min;
                    i9 -= min;
                    i11 += byteBuf.readableBytes();
                    if (i9 <= 0) {
                        return (ByteBuffer[]) newInstance.toArray(new ByteBuffer[0]);
                    }
                    i10++;
                    byteBuf = buffer(i10);
                } else {
                    throw new UnsupportedOperationException();
                }
            }
        } finally {
            newInstance.recycle();
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i8, int i9) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i8, int i9) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i8, long j8) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i8, int i9) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i8, int i9) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString() {
        String abstractByteBuf = super.toString();
        String substring = abstractByteBuf.substring(0, abstractByteBuf.length() - 1);
        return substring + ", components=" + this.buffers.length + ')';
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i8) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, byte[] bArr, int i9, int i10) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i8, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i8, ScatteringByteChannel scatteringByteChannel, int i9) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i8, remaining);
        if (remaining == 0) {
            return this;
        }
        try {
            Component findComponent = findComponent(i8);
            int i9 = findComponent.index;
            int i10 = findComponent.offset;
            ByteBuf byteBuf = findComponent.buf;
            while (true) {
                int i11 = i8 - i10;
                int min = Math.min(remaining, byteBuf.readableBytes() - i11);
                byteBuffer.limit(byteBuffer.position() + min);
                byteBuf.getBytes(i11, byteBuffer);
                i8 += min;
                remaining -= min;
                i10 += byteBuf.readableBytes();
                if (remaining <= 0) {
                    return this;
                }
                i9++;
                byteBuf = buffer(i9);
            }
        } finally {
            byteBuffer.limit(limit);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkDstIndex(i8, i10, i9, byteBuf.capacity());
        if (i10 == 0) {
            return this;
        }
        Component findComponent = findComponent(i8);
        int i11 = findComponent.index;
        int i12 = findComponent.offset;
        ByteBuf byteBuf2 = findComponent.buf;
        while (true) {
            int i13 = i8 - i12;
            int min = Math.min(i10, byteBuf2.readableBytes() - i13);
            byteBuf2.getBytes(i13, byteBuf, i9, min);
            i8 += min;
            i9 += min;
            i10 -= min;
            i12 += byteBuf2.readableBytes();
            if (i10 <= 0) {
                return this;
            }
            i11++;
            byteBuf2 = buffer(i11);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i8, GatheringByteChannel gatheringByteChannel, int i9) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i8, i9));
        }
        long write = gatheringByteChannel.write(nioBuffers(i8, i9));
        return write > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) write;
    }
}
