package io.netty.buffer;

/* loaded from: classes5.dex */
class UnpooledSlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UnpooledSlicedByteBuf(AbstractByteBuf abstractByteBuf, int i8, int i9) {
        super(abstractByteBuf, i8, i9);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i8) {
        return unwrap()._getByte(idx(i8));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i8) {
        return unwrap()._getInt(idx(i8));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i8) {
        return unwrap()._getIntLE(idx(i8));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i8) {
        return unwrap()._getLong(idx(i8));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i8) {
        return unwrap()._getShort(idx(i8));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i8) {
        return unwrap()._getShortLE(idx(i8));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i8) {
        return unwrap()._getUnsignedMedium(idx(i8));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i8, int i9) {
        unwrap()._setByte(idx(i8), i9);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i8, int i9) {
        unwrap()._setInt(idx(i8), i9);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i8, long j8) {
        unwrap()._setLong(idx(i8), j8);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i8, int i9) {
        unwrap()._setMedium(idx(i8), i9);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i8, int i9) {
        unwrap()._setMediumLE(idx(i8), i9);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i8, int i9) {
        unwrap()._setShort(idx(i8), i9);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i8, int i9) {
        unwrap()._setShortLE(idx(i8), i9);
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return maxCapacity();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public AbstractByteBuf unwrap() {
        return (AbstractByteBuf) super.unwrap();
    }
}
