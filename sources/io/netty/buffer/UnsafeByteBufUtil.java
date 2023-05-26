package io.netty.buffer;

import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class UnsafeByteBufUtil {
    private static final boolean UNALIGNED = PlatformDependent.isUnaligned();

    private UnsafeByteBufUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(long j8) {
        return PlatformDependent.getByte(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf abstractByteBuf, long j8, int i8, ByteBuf byteBuf, int i9, int i10) {
        abstractByteBuf.checkIndex(i8, i10);
        ObjectUtil.checkNotNull(byteBuf, "dst");
        if (!MathUtil.isOutOfBounds(i9, i10, byteBuf.capacity())) {
            if (byteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(j8, byteBuf.memoryAddress() + i9, i10);
                return;
            } else if (byteBuf.hasArray()) {
                PlatformDependent.copyMemory(j8, byteBuf.array(), byteBuf.arrayOffset() + i9, i10);
                return;
            } else {
                byteBuf.setBytes(i9, abstractByteBuf, i8, i10);
                return;
            }
        }
        throw new IndexOutOfBoundsException("dstIndex: " + i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(long j8) {
        if (UNALIGNED) {
            int i8 = PlatformDependent.getInt(j8);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i8 : Integer.reverseBytes(i8);
        }
        return (PlatformDependent.getByte(j8 + 3) & 255) | (PlatformDependent.getByte(j8) << 24) | ((PlatformDependent.getByte(1 + j8) & 255) << 16) | ((PlatformDependent.getByte(2 + j8) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIntLE(long j8) {
        if (UNALIGNED) {
            int i8 = PlatformDependent.getInt(j8);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i8) : i8;
        }
        return (PlatformDependent.getByte(j8 + 3) << 24) | (PlatformDependent.getByte(j8) & 255) | ((PlatformDependent.getByte(1 + j8) & 255) << 8) | ((PlatformDependent.getByte(2 + j8) & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(long j8) {
        if (UNALIGNED) {
            long j9 = PlatformDependent.getLong(j8);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j9 : Long.reverseBytes(j9);
        }
        return (PlatformDependent.getByte(j8 + 7) & 255) | (PlatformDependent.getByte(j8) << 56) | ((PlatformDependent.getByte(1 + j8) & 255) << 48) | ((PlatformDependent.getByte(2 + j8) & 255) << 40) | ((PlatformDependent.getByte(3 + j8) & 255) << 32) | ((PlatformDependent.getByte(4 + j8) & 255) << 24) | ((PlatformDependent.getByte(5 + j8) & 255) << 16) | ((PlatformDependent.getByte(6 + j8) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(long j8) {
        if (UNALIGNED) {
            short s7 = PlatformDependent.getShort(j8);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s7 : Short.reverseBytes(s7);
        }
        return (short) ((PlatformDependent.getByte(j8 + 1) & 255) | (PlatformDependent.getByte(j8) << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShortLE(long j8) {
        if (UNALIGNED) {
            short s7 = PlatformDependent.getShort(j8);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s7) : s7;
        }
        return (short) ((PlatformDependent.getByte(j8 + 1) << 8) | (PlatformDependent.getByte(j8) & 255));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMedium(long j8) {
        int i8;
        int i9;
        short reverseBytes;
        if (UNALIGNED) {
            i8 = (PlatformDependent.getByte(j8) & 255) << 16;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                reverseBytes = PlatformDependent.getShort(j8 + 1);
            } else {
                reverseBytes = Short.reverseBytes(PlatformDependent.getShort(j8 + 1));
            }
            i9 = reverseBytes & 65535;
        } else {
            i8 = ((PlatformDependent.getByte(j8) & 255) << 16) | ((PlatformDependent.getByte(1 + j8) & 255) << 8);
            i9 = PlatformDependent.getByte(j8 + 2) & 255;
        }
        return i9 | i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnpooledUnsafeDirectByteBuf newUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int i8, int i9) {
        if (PlatformDependent.useDirectBufferNoCleaner()) {
            return new UnpooledUnsafeNoCleanerDirectByteBuf(byteBufAllocator, i8, i9);
        }
        return new UnpooledUnsafeDirectByteBuf(byteBufAllocator, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setByte(long j8, int i8) {
        PlatformDependent.putByte(j8, (byte) i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf abstractByteBuf, long j8, int i8, ByteBuf byteBuf, int i9, int i10) {
        abstractByteBuf.checkIndex(i8, i10);
        ObjectUtil.checkNotNull(byteBuf, "src");
        if (MathUtil.isOutOfBounds(i9, i10, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException("srcIndex: " + i9);
        } else if (i10 != 0) {
            if (byteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(byteBuf.memoryAddress() + i9, j8, i10);
            } else if (byteBuf.hasArray()) {
                PlatformDependent.copyMemory(byteBuf.array(), byteBuf.arrayOffset() + i9, j8, i10);
            } else {
                byteBuf.getBytes(i9, abstractByteBuf, i8, i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setInt(long j8, int i8) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i8 = Integer.reverseBytes(i8);
            }
            PlatformDependent.putInt(j8, i8);
            return;
        }
        PlatformDependent.putByte(j8, (byte) (i8 >>> 24));
        PlatformDependent.putByte(1 + j8, (byte) (i8 >>> 16));
        PlatformDependent.putByte(2 + j8, (byte) (i8 >>> 8));
        PlatformDependent.putByte(j8 + 3, (byte) i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLong(long j8, long j9) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j9 = Long.reverseBytes(j9);
            }
            PlatformDependent.putLong(j8, j9);
            return;
        }
        PlatformDependent.putByte(j8, (byte) (j9 >>> 56));
        PlatformDependent.putByte(1 + j8, (byte) (j9 >>> 48));
        PlatformDependent.putByte(2 + j8, (byte) (j9 >>> 40));
        PlatformDependent.putByte(3 + j8, (byte) (j9 >>> 32));
        PlatformDependent.putByte(4 + j8, (byte) (j9 >>> 24));
        PlatformDependent.putByte(5 + j8, (byte) (j9 >>> 16));
        PlatformDependent.putByte(6 + j8, (byte) (j9 >>> 8));
        PlatformDependent.putByte(j8 + 7, (byte) j9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMedium(long j8, int i8) {
        PlatformDependent.putByte(j8, (byte) (i8 >>> 16));
        if (UNALIGNED) {
            long j9 = j8 + 1;
            short s7 = (short) i8;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s7 = Short.reverseBytes(s7);
            }
            PlatformDependent.putShort(j9, s7);
            return;
        }
        PlatformDependent.putByte(1 + j8, (byte) (i8 >>> 8));
        PlatformDependent.putByte(j8 + 2, (byte) i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMediumLE(long j8, int i8) {
        PlatformDependent.putByte(j8, (byte) i8);
        if (UNALIGNED) {
            long j9 = j8 + 1;
            short s7 = (short) (i8 >>> 8);
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s7 = Short.reverseBytes(s7);
            }
            PlatformDependent.putShort(j9, s7);
            return;
        }
        PlatformDependent.putByte(1 + j8, (byte) (i8 >>> 8));
        PlatformDependent.putByte(j8 + 2, (byte) (i8 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShort(long j8, int i8) {
        if (UNALIGNED) {
            short s7 = (short) i8;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s7 = Short.reverseBytes(s7);
            }
            PlatformDependent.putShort(j8, s7);
            return;
        }
        PlatformDependent.putByte(j8, (byte) (i8 >>> 8));
        PlatformDependent.putByte(j8 + 1, (byte) i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShortLE(long j8, int i8) {
        if (UNALIGNED) {
            PlatformDependent.putShort(j8, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) i8) : (short) i8);
            return;
        }
        PlatformDependent.putByte(j8, (byte) i8);
        PlatformDependent.putByte(j8 + 1, (byte) (i8 >>> 8));
    }

    private static void setSingleBytes(AbstractByteBuf abstractByteBuf, long j8, int i8, ByteBuffer byteBuffer, int i9) {
        abstractByteBuf.checkIndex(i8, i9);
        int limit = byteBuffer.limit();
        for (int position = byteBuffer.position(); position < limit; position++) {
            PlatformDependent.putByte(j8, byteBuffer.get(position));
            j8++;
        }
        byteBuffer.position(limit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setZero(byte[] bArr, int i8, int i9) {
        if (i9 == 0) {
            return;
        }
        PlatformDependent.setMemory(bArr, i8, i9, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(byte[] bArr, int i8) {
        return PlatformDependent.getByte(bArr, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setByte(byte[] bArr, int i8, int i9) {
        PlatformDependent.putByte(bArr, i8, (byte) i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setZero(long j8, int i8) {
        if (i8 == 0) {
            return;
        }
        PlatformDependent.setMemory(j8, i8, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(byte[] bArr, int i8) {
        if (UNALIGNED) {
            short s7 = PlatformDependent.getShort(bArr, i8);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s7 : Short.reverseBytes(s7);
        }
        return (short) ((PlatformDependent.getByte(bArr, i8 + 1) & 255) | (PlatformDependent.getByte(bArr, i8) << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShortLE(byte[] bArr, int i8) {
        if (UNALIGNED) {
            short s7 = PlatformDependent.getShort(bArr, i8);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s7) : s7;
        }
        return (short) ((PlatformDependent.getByte(bArr, i8 + 1) << 8) | (PlatformDependent.getByte(bArr, i8) & 255));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMediumLE(byte[] bArr, int i8, int i9) {
        PlatformDependent.putByte(bArr, i8, (byte) i9);
        if (UNALIGNED) {
            PlatformDependent.putShort(bArr, i8 + 1, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) (i9 >>> 8)) : (short) (i9 >>> 8));
            return;
        }
        PlatformDependent.putByte(bArr, i8 + 1, (byte) (i9 >>> 8));
        PlatformDependent.putByte(bArr, i8 + 2, (byte) (i9 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setInt(byte[] bArr, int i8, int i9) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i9 = Integer.reverseBytes(i9);
            }
            PlatformDependent.putInt(bArr, i8, i9);
            return;
        }
        PlatformDependent.putByte(bArr, i8, (byte) (i9 >>> 24));
        PlatformDependent.putByte(bArr, i8 + 1, (byte) (i9 >>> 16));
        PlatformDependent.putByte(bArr, i8 + 2, (byte) (i9 >>> 8));
        PlatformDependent.putByte(bArr, i8 + 3, (byte) i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShort(byte[] bArr, int i8, int i9) {
        if (UNALIGNED) {
            short s7 = (short) i9;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s7 = Short.reverseBytes(s7);
            }
            PlatformDependent.putShort(bArr, i8, s7);
            return;
        }
        PlatformDependent.putByte(bArr, i8, (byte) (i9 >>> 8));
        PlatformDependent.putByte(bArr, i8 + 1, (byte) i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShortLE(byte[] bArr, int i8, int i9) {
        if (UNALIGNED) {
            PlatformDependent.putShort(bArr, i8, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) i9) : (short) i9);
            return;
        }
        PlatformDependent.putByte(bArr, i8, (byte) i9);
        PlatformDependent.putByte(bArr, i8 + 1, (byte) (i9 >>> 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(byte[] bArr, int i8) {
        if (UNALIGNED) {
            int i9 = PlatformDependent.getInt(bArr, i8);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i9 : Integer.reverseBytes(i9);
        }
        return (PlatformDependent.getByte(bArr, i8 + 3) & 255) | (PlatformDependent.getByte(bArr, i8) << 24) | ((PlatformDependent.getByte(bArr, i8 + 1) & 255) << 16) | ((PlatformDependent.getByte(bArr, i8 + 2) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIntLE(byte[] bArr, int i8) {
        if (UNALIGNED) {
            int i9 = PlatformDependent.getInt(bArr, i8);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i9) : i9;
        }
        return (PlatformDependent.getByte(bArr, i8 + 3) << 24) | (PlatformDependent.getByte(bArr, i8) & 255) | ((PlatformDependent.getByte(bArr, i8 + 1) & 255) << 8) | ((PlatformDependent.getByte(bArr, i8 + 2) & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMedium(byte[] bArr, int i8) {
        int i9;
        int i10;
        short reverseBytes;
        if (UNALIGNED) {
            i9 = (PlatformDependent.getByte(bArr, i8) & 255) << 16;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                reverseBytes = PlatformDependent.getShort(bArr, i8 + 1);
            } else {
                reverseBytes = Short.reverseBytes(PlatformDependent.getShort(bArr, i8 + 1));
            }
            i10 = reverseBytes & 65535;
        } else {
            i9 = ((PlatformDependent.getByte(bArr, i8) & 255) << 16) | ((PlatformDependent.getByte(bArr, i8 + 1) & 255) << 8);
            i10 = PlatformDependent.getByte(bArr, i8 + 2) & 255;
        }
        return i10 | i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMedium(byte[] bArr, int i8, int i9) {
        PlatformDependent.putByte(bArr, i8, (byte) (i9 >>> 16));
        if (UNALIGNED) {
            int i10 = i8 + 1;
            short s7 = (short) i9;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s7 = Short.reverseBytes(s7);
            }
            PlatformDependent.putShort(bArr, i10, s7);
            return;
        }
        PlatformDependent.putByte(bArr, i8 + 1, (byte) (i9 >>> 8));
        PlatformDependent.putByte(bArr, i8 + 2, (byte) i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf abstractByteBuf, long j8, int i8, byte[] bArr, int i9, int i10) {
        abstractByteBuf.checkIndex(i8, i10);
        ObjectUtil.checkNotNull(bArr, "dst");
        if (MathUtil.isOutOfBounds(i9, i10, bArr.length)) {
            throw new IndexOutOfBoundsException("dstIndex: " + i9);
        } else if (i10 != 0) {
            PlatformDependent.copyMemory(j8, bArr, i9, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf abstractByteBuf, long j8, int i8, byte[] bArr, int i9, int i10) {
        abstractByteBuf.checkIndex(i8, i10);
        if (i10 != 0) {
            PlatformDependent.copyMemory(bArr, i9, j8, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLong(byte[] bArr, int i8, long j8) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j8 = Long.reverseBytes(j8);
            }
            PlatformDependent.putLong(bArr, i8, j8);
            return;
        }
        PlatformDependent.putByte(bArr, i8, (byte) (j8 >>> 56));
        PlatformDependent.putByte(bArr, i8 + 1, (byte) (j8 >>> 48));
        PlatformDependent.putByte(bArr, i8 + 2, (byte) (j8 >>> 40));
        PlatformDependent.putByte(bArr, i8 + 3, (byte) (j8 >>> 32));
        PlatformDependent.putByte(bArr, i8 + 4, (byte) (j8 >>> 24));
        PlatformDependent.putByte(bArr, i8 + 5, (byte) (j8 >>> 16));
        PlatformDependent.putByte(bArr, i8 + 6, (byte) (j8 >>> 8));
        PlatformDependent.putByte(bArr, i8 + 7, (byte) j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(byte[] bArr, int i8) {
        if (UNALIGNED) {
            long j8 = PlatformDependent.getLong(bArr, i8);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j8 : Long.reverseBytes(j8);
        }
        return (PlatformDependent.getByte(bArr, i8 + 7) & 255) | (PlatformDependent.getByte(bArr, i8) << 56) | ((PlatformDependent.getByte(bArr, i8 + 1) & 255) << 48) | ((PlatformDependent.getByte(bArr, i8 + 2) & 255) << 40) | ((PlatformDependent.getByte(bArr, i8 + 3) & 255) << 32) | ((PlatformDependent.getByte(bArr, i8 + 4) & 255) << 24) | ((PlatformDependent.getByte(bArr, i8 + 5) & 255) << 16) | ((PlatformDependent.getByte(bArr, i8 + 6) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf abstractByteBuf, long j8, int i8, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            abstractByteBuf.checkIndex(i8, remaining);
            PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + byteBuffer.position(), j8, remaining);
            byteBuffer.position(byteBuffer.position() + remaining);
        } else if (byteBuffer.hasArray()) {
            abstractByteBuf.checkIndex(i8, remaining);
            PlatformDependent.copyMemory(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), j8, remaining);
            byteBuffer.position(byteBuffer.position() + remaining);
        } else if (remaining < 8) {
            setSingleBytes(abstractByteBuf, j8, i8, byteBuffer, remaining);
        } else {
            abstractByteBuf.internalNioBuffer(i8, remaining).put(byteBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf abstractByteBuf, long j8, int i8, ByteBuffer byteBuffer) {
        abstractByteBuf.checkIndex(i8, byteBuffer.remaining());
        if (byteBuffer.remaining() == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            if (!byteBuffer.isReadOnly()) {
                PlatformDependent.copyMemory(j8, PlatformDependent.directBufferAddress(byteBuffer) + byteBuffer.position(), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
                return;
            }
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            PlatformDependent.copyMemory(j8, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        } else {
            byteBuffer.put(abstractByteBuf.nioBuffer());
        }
    }
}
