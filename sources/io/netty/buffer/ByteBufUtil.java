package io.netty.buffer;

import com.google.android.gms.common.api.Api;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j$.util.Spliterator;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Locale;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public final class ByteBufUtil {
    private static final FastThreadLocal<byte[]> BYTE_ARRAYS;
    static final ByteBufAllocator DEFAULT_ALLOCATOR;
    private static final ByteProcessor FIND_NON_ASCII;
    private static final int MAX_BYTES_PER_CHAR_UTF8;
    private static final int MAX_CHAR_BUFFER_SIZE;
    private static final int THREAD_LOCAL_BUFFER_SIZE;
    private static final InternalLogger logger;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ThreadLocalDirectByteBuf extends UnpooledDirectByteBuf {
        private static final ObjectPool<ThreadLocalDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalDirectByteBuf.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public ThreadLocalDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle) {
                return new ThreadLocalDirectByteBuf(handle);
            }
        });
        private final ObjectPool.Handle<ThreadLocalDirectByteBuf> handle;

        static ThreadLocalDirectByteBuf newInstance() {
            ThreadLocalDirectByteBuf threadLocalDirectByteBuf = RECYCLER.get();
            threadLocalDirectByteBuf.resetRefCnt();
            return threadLocalDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        protected void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
                return;
            }
            clear();
            this.handle.recycle(this);
        }

        private ThreadLocalDirectByteBuf(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, (int) Spliterator.NONNULL, (int) Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.handle = handle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ThreadLocalUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        private static final ObjectPool<ThreadLocalUnsafeDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalUnsafeDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalUnsafeDirectByteBuf.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public ThreadLocalUnsafeDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
                return new ThreadLocalUnsafeDirectByteBuf(handle);
            }
        });
        private final ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle;

        static ThreadLocalUnsafeDirectByteBuf newInstance() {
            ThreadLocalUnsafeDirectByteBuf threadLocalUnsafeDirectByteBuf = RECYCLER.get();
            threadLocalUnsafeDirectByteBuf.resetRefCnt();
            return threadLocalUnsafeDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        protected void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
                return;
            }
            clear();
            this.handle.recycle(this);
        }

        private ThreadLocalUnsafeDirectByteBuf(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, (int) Spliterator.NONNULL, (int) Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.handle = handle;
        }
    }

    static {
        String str;
        ByteBufAllocator byteBufAllocator;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(ByteBufUtil.class);
        logger = internalLoggerFactory;
        BYTE_ARRAYS = new FastThreadLocal<byte[]>() { // from class: io.netty.buffer.ByteBufUtil.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public byte[] initialValue() throws Exception {
                return PlatformDependent.allocateUninitializedArray(Spliterator.IMMUTABLE);
            }
        };
        MAX_BYTES_PER_CHAR_UTF8 = (int) CharsetUtil.encoder(CharsetUtil.UTF_8).maxBytesPerChar();
        if (PlatformDependent.isAndroid()) {
            str = "unpooled";
        } else {
            str = "pooled";
        }
        String trim = SystemPropertyUtil.get("io.netty.allocator.type", str).toLowerCase(Locale.US).trim();
        if ("unpooled".equals(trim)) {
            byteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", trim);
        } else if ("pooled".equals(trim)) {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", trim);
        } else {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: pooled (unknown: {})", trim);
        }
        DEFAULT_ALLOCATOR = byteBufAllocator;
        int i8 = SystemPropertyUtil.getInt("io.netty.threadLocalDirectBufferSize", 0);
        THREAD_LOCAL_BUFFER_SIZE = i8;
        internalLoggerFactory.debug("-Dio.netty.threadLocalDirectBufferSize: {}", Integer.valueOf(i8));
        int i9 = SystemPropertyUtil.getInt("io.netty.maxThreadLocalCharBufferSize", 16384);
        MAX_CHAR_BUFFER_SIZE = i9;
        internalLoggerFactory.debug("-Dio.netty.maxThreadLocalCharBufferSize: {}", Integer.valueOf(i9));
        FIND_NON_ASCII = new ByteProcessor() { // from class: io.netty.buffer.ByteBufUtil.2
            @Override // io.netty.util.ByteProcessor
            public boolean process(byte b8) {
                return b8 >= 0;
            }
        };
    }

    private ByteBufUtil() {
    }

    public static int compare(ByteBuf byteBuf, ByteBuf byteBuf2) {
        boolean z7;
        long compareUintBigEndianB;
        int readableBytes = byteBuf.readableBytes();
        int readableBytes2 = byteBuf2.readableBytes();
        int min = Math.min(readableBytes, readableBytes2);
        int i8 = min >>> 2;
        int i9 = min & 3;
        int readerIndex = byteBuf.readerIndex();
        int readerIndex2 = byteBuf2.readerIndex();
        if (i8 > 0) {
            if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
                z7 = true;
            } else {
                z7 = false;
            }
            int i10 = i8 << 2;
            if (byteBuf.order() == byteBuf2.order()) {
                if (z7) {
                    compareUintBigEndianB = compareUintBigEndian(byteBuf, byteBuf2, readerIndex, readerIndex2, i10);
                } else {
                    compareUintBigEndianB = compareUintLittleEndian(byteBuf, byteBuf2, readerIndex, readerIndex2, i10);
                }
            } else if (z7) {
                compareUintBigEndianB = compareUintBigEndianA(byteBuf, byteBuf2, readerIndex, readerIndex2, i10);
            } else {
                compareUintBigEndianB = compareUintBigEndianB(byteBuf, byteBuf2, readerIndex, readerIndex2, i10);
            }
            if (compareUintBigEndianB != 0) {
                return (int) Math.min(2147483647L, Math.max(-2147483648L, compareUintBigEndianB));
            }
            readerIndex += i10;
            readerIndex2 += i10;
        }
        int i11 = i9 + readerIndex;
        while (readerIndex < i11) {
            int unsignedByte = byteBuf.getUnsignedByte(readerIndex) - byteBuf2.getUnsignedByte(readerIndex2);
            if (unsignedByte != 0) {
                return unsignedByte;
            }
            readerIndex++;
            readerIndex2++;
        }
        return readableBytes - readableBytes2;
    }

    private static long compareUintBigEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i8, int i9, int i10) {
        int i11 = i10 + i8;
        while (i8 < i11) {
            long unsignedInt = byteBuf.getUnsignedInt(i8) - byteBuf2.getUnsignedInt(i9);
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i8 += 4;
            i9 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianA(ByteBuf byteBuf, ByteBuf byteBuf2, int i8, int i9, int i10) {
        int i11 = i10 + i8;
        while (i8 < i11) {
            long unsignedInt = byteBuf.getUnsignedInt(i8) - byteBuf2.getUnsignedIntLE(i9);
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i8 += 4;
            i9 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianB(ByteBuf byteBuf, ByteBuf byteBuf2, int i8, int i9, int i10) {
        int i11 = i10 + i8;
        while (i8 < i11) {
            long unsignedIntLE = byteBuf.getUnsignedIntLE(i8) - byteBuf2.getUnsignedInt(i9);
            if (unsignedIntLE != 0) {
                return unsignedIntLE;
            }
            i8 += 4;
            i9 += 4;
        }
        return 0L;
    }

    private static long compareUintLittleEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i8, int i9, int i10) {
        int i11 = i10 + i8;
        while (i8 < i11) {
            long unsignedIntLE = byteBuf.getUnsignedIntLE(i8) - byteBuf2.getUnsignedIntLE(i9);
            if (unsignedIntLE != 0) {
                return unsignedIntLE;
            }
            i8 += 4;
            i9 += 4;
        }
        return 0L;
    }

    public static void copy(AsciiString asciiString, ByteBuf byteBuf) {
        copy(asciiString, 0, byteBuf, asciiString.length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeString(ByteBuf byteBuf, int i8, int i9, Charset charset) {
        byte[] threadLocalTempArray;
        int i10;
        if (i9 == 0) {
            return "";
        }
        if (byteBuf.hasArray()) {
            threadLocalTempArray = byteBuf.array();
            i10 = byteBuf.arrayOffset() + i8;
        } else {
            threadLocalTempArray = threadLocalTempArray(i9);
            byteBuf.getBytes(i8, threadLocalTempArray, 0, i9);
            i10 = 0;
        }
        if (CharsetUtil.US_ASCII.equals(charset)) {
            return new String(threadLocalTempArray, 0, i10, i9);
        }
        return new String(threadLocalTempArray, i10, i9, charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuf encodeString0(ByteBufAllocator byteBufAllocator, boolean z7, CharBuffer charBuffer, Charset charset, int i8) {
        ByteBuf buffer;
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        int remaining = ((int) (charBuffer.remaining() * encoder.maxBytesPerChar())) + i8;
        if (z7) {
            buffer = byteBufAllocator.heapBuffer(remaining);
        } else {
            buffer = byteBufAllocator.buffer(remaining);
        }
        try {
            try {
                ByteBuffer internalNioBuffer = buffer.internalNioBuffer(buffer.readerIndex(), remaining);
                int position = internalNioBuffer.position();
                CoderResult encode = encoder.encode(charBuffer, internalNioBuffer, true);
                if (!encode.isUnderflow()) {
                    encode.throwException();
                }
                CoderResult flush = encoder.flush(internalNioBuffer);
                if (!flush.isUnderflow()) {
                    flush.throwException();
                }
                buffer.writerIndex((buffer.writerIndex() + internalNioBuffer.position()) - position);
                return buffer;
            } catch (CharacterCodingException e8) {
                throw new IllegalStateException(e8);
            }
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    public static boolean ensureWritableSuccess(int i8) {
        return i8 == 0 || i8 == 2;
    }

    public static boolean equals(ByteBuf byteBuf, int i8, ByteBuf byteBuf2, int i9, int i10) {
        if (i8 >= 0 && i9 >= 0 && i10 >= 0) {
            if (byteBuf.writerIndex() - i10 < i8 || byteBuf2.writerIndex() - i10 < i9) {
                return false;
            }
            int i11 = i10 >>> 3;
            if (byteBuf.order() == byteBuf2.order()) {
                while (i11 > 0) {
                    if (byteBuf.getLong(i8) != byteBuf2.getLong(i9)) {
                        return false;
                    }
                    i8 += 8;
                    i9 += 8;
                    i11--;
                }
            } else {
                while (i11 > 0) {
                    if (byteBuf.getLong(i8) != swapLong(byteBuf2.getLong(i9))) {
                        return false;
                    }
                    i8 += 8;
                    i9 += 8;
                    i11--;
                }
            }
            for (int i12 = i10 & 7; i12 > 0; i12--) {
                if (byteBuf.getByte(i8) != byteBuf2.getByte(i9)) {
                    return false;
                }
                i8++;
                i9++;
            }
            return true;
        }
        throw new IllegalArgumentException("All indexes and lengths must be non-negative");
    }

    public static int hashCode(ByteBuf byteBuf) {
        int i8;
        int readableBytes = byteBuf.readableBytes();
        int i9 = readableBytes >>> 2;
        int i10 = readableBytes & 3;
        int readerIndex = byteBuf.readerIndex();
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            i8 = 1;
            while (i9 > 0) {
                i8 = (i8 * 31) + byteBuf.getInt(readerIndex);
                readerIndex += 4;
                i9--;
            }
        } else {
            i8 = 1;
            while (i9 > 0) {
                i8 = (i8 * 31) + swapInt(byteBuf.getInt(readerIndex));
                readerIndex += 4;
                i9--;
            }
        }
        while (i10 > 0) {
            i8 = (i8 * 31) + byteBuf.getByte(readerIndex);
            i10--;
            readerIndex++;
        }
        if (i8 == 0) {
            return 1;
        }
        return i8;
    }

    public static String hexDump(ByteBuf byteBuf) {
        return hexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static ByteBuf readBytes(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int i8) {
        ByteBuf buffer = byteBufAllocator.buffer(i8);
        try {
            byteBuf.readBytes(buffer);
            return buffer;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    public static ByteBuf setShortBE(ByteBuf byteBuf, int i8, int i9) {
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            return byteBuf.setShort(i8, i9);
        }
        return byteBuf.setShortLE(i8, i9);
    }

    public static int swapInt(int i8) {
        return Integer.reverseBytes(i8);
    }

    public static long swapLong(long j8) {
        return Long.reverseBytes(j8);
    }

    public static int swapMedium(int i8) {
        int i9 = ((i8 >>> 16) & 255) | ((i8 << 16) & 16711680) | (65280 & i8);
        return (8388608 & i9) != 0 ? i9 | (-16777216) : i9;
    }

    public static short swapShort(short s7) {
        return Short.reverseBytes(s7);
    }

    public static ByteBuf threadLocalDirectBuffer() {
        if (THREAD_LOCAL_BUFFER_SIZE <= 0) {
            return null;
        }
        if (PlatformDependent.hasUnsafe()) {
            return ThreadLocalUnsafeDirectByteBuf.newInstance();
        }
        return ThreadLocalDirectByteBuf.newInstance();
    }

    static byte[] threadLocalTempArray(int i8) {
        if (i8 <= 1024) {
            return BYTE_ARRAYS.get();
        }
        return PlatformDependent.allocateUninitializedArray(i8);
    }

    public static int utf8MaxBytes(int i8) {
        return i8 * MAX_BYTES_PER_CHAR_UTF8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int writeAscii(AbstractByteBuf abstractByteBuf, int i8, CharSequence charSequence, int i9) {
        int i10 = 0;
        while (i10 < i9) {
            abstractByteBuf._setByte(i8, AsciiString.c2b(charSequence.charAt(i10)));
            i10++;
            i8++;
        }
        return i9;
    }

    public static ByteBuf writeMediumBE(ByteBuf byteBuf, int i8) {
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            return byteBuf.writeMedium(i8);
        }
        return byteBuf.writeMediumLE(i8);
    }

    public static ByteBuf writeShortBE(ByteBuf byteBuf, int i8) {
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            return byteBuf.writeShort(i8);
        }
        return byteBuf.writeShortLE(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int writeUtf8(AbstractByteBuf abstractByteBuf, int i8, CharSequence charSequence, int i9) {
        return writeUtf8(abstractByteBuf, i8, charSequence, 0, i9);
    }

    private static int writeUtf8Surrogate(AbstractByteBuf abstractByteBuf, int i8, char c8, char c9) {
        if (!Character.isLowSurrogate(c9)) {
            int i9 = i8 + 1;
            abstractByteBuf._setByte(i8, 63);
            int i10 = i9 + 1;
            if (Character.isHighSurrogate(c9)) {
                c9 = '?';
            }
            abstractByteBuf._setByte(i9, c9);
            return i10;
        }
        int codePoint = Character.toCodePoint(c8, c9);
        int i11 = i8 + 1;
        abstractByteBuf._setByte(i8, (byte) ((codePoint >> 18) | 240));
        int i12 = i11 + 1;
        abstractByteBuf._setByte(i11, (byte) (((codePoint >> 12) & 63) | 128));
        int i13 = i12 + 1;
        abstractByteBuf._setByte(i12, (byte) (((codePoint >> 6) & 63) | 128));
        int i14 = i13 + 1;
        abstractByteBuf._setByte(i13, (byte) ((codePoint & 63) | 128));
        return i14;
    }

    public static void copy(AsciiString asciiString, int i8, ByteBuf byteBuf, int i9, int i10) {
        if (!MathUtil.isOutOfBounds(i8, i10, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).setBytes(i9, asciiString.array(), i8 + asciiString.arrayOffset(), i10);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i8 + ") <= srcIdx + length(" + i10 + ") <= srcLen(" + asciiString.length() + ')');
    }

    public static String hexDump(ByteBuf byteBuf, int i8, int i9) {
        return HexUtil.hexDump(byteBuf, i8, i9);
    }

    public static int utf8MaxBytes(CharSequence charSequence) {
        return utf8MaxBytes(charSequence.length());
    }

    static int writeUtf8(AbstractByteBuf abstractByteBuf, int i8, CharSequence charSequence, int i9, int i10) {
        int i11 = i8;
        while (true) {
            if (i9 >= i10) {
                break;
            }
            char charAt = charSequence.charAt(i9);
            if (charAt < 128) {
                abstractByteBuf._setByte(i11, (byte) charAt);
                i11++;
            } else if (charAt < 2048) {
                int i12 = i11 + 1;
                abstractByteBuf._setByte(i11, (byte) ((charAt >> 6) | 192));
                i11 = i12 + 1;
                abstractByteBuf._setByte(i12, (byte) ((charAt & '?') | 128));
            } else if (StringUtil.isSurrogate(charAt)) {
                if (Character.isHighSurrogate(charAt)) {
                    i9++;
                    if (i9 == i10) {
                        abstractByteBuf._setByte(i11, 63);
                        i11++;
                        break;
                    }
                    i11 = writeUtf8Surrogate(abstractByteBuf, i11, charAt, charSequence.charAt(i9));
                } else {
                    abstractByteBuf._setByte(i11, 63);
                    i11++;
                }
            } else {
                int i13 = i11 + 1;
                abstractByteBuf._setByte(i11, (byte) ((charAt >> '\f') | 224));
                int i14 = i13 + 1;
                abstractByteBuf._setByte(i13, (byte) ((63 & (charAt >> 6)) | 128));
                abstractByteBuf._setByte(i14, (byte) ((charAt & '?') | 128));
                i11 = i14 + 1;
            }
            i9++;
        }
        return i11 - i8;
    }

    public static String hexDump(byte[] bArr, int i8, int i9) {
        return HexUtil.hexDump(bArr, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class HexUtil {
        private static final char[] BYTE2CHAR = new char[Spliterator.NONNULL];
        private static final char[] HEXDUMP_TABLE = new char[Spliterator.IMMUTABLE];
        private static final String[] HEXPADDING = new String[16];
        private static final String[] HEXDUMP_ROWPREFIXES = new String[4096];
        private static final String[] BYTE2HEX = new String[Spliterator.NONNULL];
        private static final String[] BYTEPADDING = new String[16];

        static {
            char[] charArray = "0123456789abcdef".toCharArray();
            int i8 = 0;
            for (int i9 = 0; i9 < 256; i9++) {
                char[] cArr = HEXDUMP_TABLE;
                int i10 = i9 << 1;
                cArr[i10] = charArray[(i9 >>> 4) & 15];
                cArr[i10 + 1] = charArray[i9 & 15];
            }
            int i11 = 0;
            while (true) {
                String[] strArr = HEXPADDING;
                if (i11 >= strArr.length) {
                    break;
                }
                int length = strArr.length - i11;
                StringBuilder sb = new StringBuilder(length * 3);
                for (int i12 = 0; i12 < length; i12++) {
                    sb.append("   ");
                }
                HEXPADDING[i11] = sb.toString();
                i11++;
            }
            int i13 = 0;
            while (true) {
                String[] strArr2 = HEXDUMP_ROWPREFIXES;
                if (i13 >= strArr2.length) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder(12);
                sb2.append(StringUtil.NEWLINE);
                sb2.append(Long.toHexString(((i13 << 4) & 4294967295L) | 4294967296L));
                sb2.setCharAt(sb2.length() - 9, '|');
                sb2.append('|');
                strArr2[i13] = sb2.toString();
                i13++;
            }
            int i14 = 0;
            while (true) {
                String[] strArr3 = BYTE2HEX;
                if (i14 >= strArr3.length) {
                    break;
                }
                strArr3[i14] = ' ' + StringUtil.byteToHexStringPadded(i14);
                i14++;
            }
            int i15 = 0;
            while (true) {
                String[] strArr4 = BYTEPADDING;
                if (i15 >= strArr4.length) {
                    break;
                }
                int length2 = strArr4.length - i15;
                StringBuilder sb3 = new StringBuilder(length2);
                for (int i16 = 0; i16 < length2; i16++) {
                    sb3.append(' ');
                }
                BYTEPADDING[i15] = sb3.toString();
                i15++;
            }
            while (true) {
                char[] cArr2 = BYTE2CHAR;
                if (i8 < cArr2.length) {
                    if (i8 > 31 && i8 < 127) {
                        cArr2[i8] = (char) i8;
                    } else {
                        cArr2[i8] = '.';
                    }
                    i8++;
                } else {
                    return;
                }
            }
        }

        private HexUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(ByteBuf byteBuf, int i8, int i9) {
            ObjectUtil.checkPositiveOrZero(i9, Name.LENGTH);
            if (i9 == 0) {
                return "";
            }
            int i10 = i8 + i9;
            char[] cArr = new char[i9 << 1];
            int i11 = 0;
            while (i8 < i10) {
                System.arraycopy(HEXDUMP_TABLE, byteBuf.getUnsignedByte(i8) << 1, cArr, i11, 2);
                i8++;
                i11 += 2;
            }
            return new String(cArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(byte[] bArr, int i8, int i9) {
            ObjectUtil.checkPositiveOrZero(i9, Name.LENGTH);
            if (i9 == 0) {
                return "";
            }
            int i10 = i8 + i9;
            char[] cArr = new char[i9 << 1];
            int i11 = 0;
            while (i8 < i10) {
                System.arraycopy(HEXDUMP_TABLE, (bArr[i8] & 255) << 1, cArr, i11, 2);
                i8++;
                i11 += 2;
            }
            return new String(cArr);
        }
    }

    public static void copy(AsciiString asciiString, int i8, ByteBuf byteBuf, int i9) {
        if (!MathUtil.isOutOfBounds(i8, i9, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).writeBytes(asciiString.array(), i8 + asciiString.arrayOffset(), i9);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i8 + ") <= srcIdx + length(" + i9 + ") <= srcLen(" + asciiString.length() + ')');
    }

    public static boolean equals(ByteBuf byteBuf, ByteBuf byteBuf2) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes != byteBuf2.readableBytes()) {
            return false;
        }
        return equals(byteBuf, byteBuf.readerIndex(), byteBuf2, byteBuf2.readerIndex(), readableBytes);
    }
}
