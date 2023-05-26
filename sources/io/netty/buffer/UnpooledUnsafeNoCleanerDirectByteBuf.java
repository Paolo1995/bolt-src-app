package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class UnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UnpooledUnsafeNoCleanerDirectByteBuf(ByteBufAllocator byteBufAllocator, int i8, int i9) {
        super(byteBufAllocator, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuffer allocateDirect(int i8) {
        return PlatformDependent.allocateDirectNoCleaner(i8);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i8) {
        checkNewCapacity(i8);
        if (i8 == capacity()) {
            return this;
        }
        trimIndicesToCapacity(i8);
        setByteBuffer(reallocateDirect(this.buffer, i8), false);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledDirectByteBuf
    public void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectNoCleaner(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer reallocateDirect(ByteBuffer byteBuffer, int i8) {
        return PlatformDependent.reallocateDirectNoCleaner(byteBuffer, i8);
    }
}
