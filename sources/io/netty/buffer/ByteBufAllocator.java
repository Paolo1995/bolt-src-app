package io.netty.buffer;

/* loaded from: classes5.dex */
public interface ByteBufAllocator {
    public static final ByteBufAllocator DEFAULT = ByteBufUtil.DEFAULT_ALLOCATOR;

    ByteBuf buffer(int i8);

    ByteBuf buffer(int i8, int i9);

    int calculateNewCapacity(int i8, int i9);

    CompositeByteBuf compositeBuffer(int i8);

    ByteBuf directBuffer(int i8);

    ByteBuf directBuffer(int i8, int i9);

    ByteBuf heapBuffer(int i8);

    ByteBuf heapBuffer(int i8, int i9);

    ByteBuf ioBuffer(int i8);

    ByteBuf ioBuffer(int i8, int i9);

    boolean isDirectBufferPooled();
}
