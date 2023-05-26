package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* loaded from: classes5.dex */
final class UnsafeHeapSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UnsafeHeapSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static int idx(ByteBuf byteBuf, int i8) {
        return byteBuf.arrayOffset() + i8;
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected int _getInt(AbstractByteBuf abstractByteBuf, int i8) {
        return PlatformDependent.getInt(abstractByteBuf.array(), idx(abstractByteBuf, i8));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected long _getLong(AbstractByteBuf abstractByteBuf, int i8) {
        return PlatformDependent.getLong(abstractByteBuf.array(), idx(abstractByteBuf, i8));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected short _getShort(AbstractByteBuf abstractByteBuf, int i8) {
        return PlatformDependent.getShort(abstractByteBuf.array(), idx(abstractByteBuf, i8));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setInt(AbstractByteBuf abstractByteBuf, int i8, int i9) {
        PlatformDependent.putInt(abstractByteBuf.array(), idx(abstractByteBuf, i8), i9);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setLong(AbstractByteBuf abstractByteBuf, int i8, long j8) {
        PlatformDependent.putLong(abstractByteBuf.array(), idx(abstractByteBuf, i8), j8);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setShort(AbstractByteBuf abstractByteBuf, int i8, short s7) {
        PlatformDependent.putShort(abstractByteBuf.array(), idx(abstractByteBuf, i8), s7);
    }
}
