package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
abstract class AbstractUnsafeSwappedByteBuf extends SwappedByteBuf {
    private final boolean nativeByteOrder;
    private final AbstractByteBuf wrapped;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractUnsafeSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
        boolean z7;
        this.wrapped = abstractByteBuf;
        boolean z8 = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER;
        if (order() == ByteOrder.BIG_ENDIAN) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.nativeByteOrder = z8 == z7;
    }

    protected abstract int _getInt(AbstractByteBuf abstractByteBuf, int i8);

    protected abstract long _getLong(AbstractByteBuf abstractByteBuf, int i8);

    protected abstract short _getShort(AbstractByteBuf abstractByteBuf, int i8);

    protected abstract void _setInt(AbstractByteBuf abstractByteBuf, int i8, int i9);

    protected abstract void _setLong(AbstractByteBuf abstractByteBuf, int i8, long j8);

    protected abstract void _setShort(AbstractByteBuf abstractByteBuf, int i8, short s7);

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final int getInt(int i8) {
        this.wrapped.checkIndex(i8, 4);
        int _getInt = _getInt(this.wrapped, i8);
        if (!this.nativeByteOrder) {
            return Integer.reverseBytes(_getInt);
        }
        return _getInt;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getLong(int i8) {
        this.wrapped.checkIndex(i8, 8);
        long _getLong = _getLong(this.wrapped, i8);
        if (!this.nativeByteOrder) {
            return Long.reverseBytes(_getLong);
        }
        return _getLong;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final short getShort(int i8) {
        this.wrapped.checkIndex(i8, 2);
        short _getShort = _getShort(this.wrapped, i8);
        if (!this.nativeByteOrder) {
            return Short.reverseBytes(_getShort);
        }
        return _getShort;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getUnsignedInt(int i8) {
        return getInt(i8) & 4294967295L;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final int getUnsignedShort(int i8) {
        return getShort(i8) & 65535;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setInt(int i8, int i9) {
        this.wrapped.checkIndex(i8, 4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            i9 = Integer.reverseBytes(i9);
        }
        _setInt(abstractByteBuf, i8, i9);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setLong(int i8, long j8) {
        this.wrapped.checkIndex(i8, 8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            j8 = Long.reverseBytes(j8);
        }
        _setLong(abstractByteBuf, i8, j8);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setShort(int i8, int i9) {
        this.wrapped.checkIndex(i8, 2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        short s7 = (short) i9;
        if (!this.nativeByteOrder) {
            s7 = Short.reverseBytes(s7);
        }
        _setShort(abstractByteBuf, i8, s7);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeInt(int i8) {
        this.wrapped.ensureWritable0(4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i9 = abstractByteBuf.writerIndex;
        if (!this.nativeByteOrder) {
            i8 = Integer.reverseBytes(i8);
        }
        _setInt(abstractByteBuf, i9, i8);
        this.wrapped.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeLong(long j8) {
        this.wrapped.ensureWritable0(8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i8 = abstractByteBuf.writerIndex;
        if (!this.nativeByteOrder) {
            j8 = Long.reverseBytes(j8);
        }
        _setLong(abstractByteBuf, i8, j8);
        this.wrapped.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeShort(int i8) {
        this.wrapped.ensureWritable0(2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i9 = abstractByteBuf.writerIndex;
        short s7 = (short) i8;
        if (!this.nativeByteOrder) {
            s7 = Short.reverseBytes(s7);
        }
        _setShort(abstractByteBuf, i9, s7);
        this.wrapped.writerIndex += 2;
        return this;
    }
}
