package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* loaded from: classes5.dex */
final class UnsafeDirectSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UnsafeDirectSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static long addr(AbstractByteBuf abstractByteBuf, int i8) {
        return abstractByteBuf.memoryAddress() + i8;
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected int _getInt(AbstractByteBuf abstractByteBuf, int i8) {
        return PlatformDependent.getInt(addr(abstractByteBuf, i8));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected long _getLong(AbstractByteBuf abstractByteBuf, int i8) {
        return PlatformDependent.getLong(addr(abstractByteBuf, i8));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected short _getShort(AbstractByteBuf abstractByteBuf, int i8) {
        return PlatformDependent.getShort(addr(abstractByteBuf, i8));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setInt(AbstractByteBuf abstractByteBuf, int i8, int i9) {
        PlatformDependent.putInt(addr(abstractByteBuf, i8), i9);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setLong(AbstractByteBuf abstractByteBuf, int i8, long j8) {
        PlatformDependent.putLong(addr(abstractByteBuf, i8), j8);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setShort(AbstractByteBuf abstractByteBuf, int i8, short s7) {
        PlatformDependent.putShort(addr(abstractByteBuf, i8), s7);
    }
}
