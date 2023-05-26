package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public abstract class AbstractByteBuf extends ByteBuf {
    static final boolean checkAccessible;
    private static final boolean checkBounds;
    static final ResourceLeakDetector<ByteBuf> leakDetector;
    private static final InternalLogger logger;
    private int markedReaderIndex;
    private int markedWriterIndex;
    private int maxCapacity;
    int readerIndex;
    int writerIndex;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(AbstractByteBuf.class);
        logger = internalLoggerFactory;
        if (SystemPropertyUtil.contains("io.netty.buffer.checkAccessible")) {
            checkAccessible = SystemPropertyUtil.getBoolean("io.netty.buffer.checkAccessible", true);
        } else {
            checkAccessible = SystemPropertyUtil.getBoolean("io.netty.buffer.bytebuf.checkAccessible", true);
        }
        boolean z7 = SystemPropertyUtil.getBoolean("io.netty.buffer.checkBounds", true);
        checkBounds = z7;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", "io.netty.buffer.checkAccessible", Boolean.valueOf(checkAccessible));
            internalLoggerFactory.debug("-D{}: {}", "io.netty.buffer.checkBounds", Boolean.valueOf(z7));
        }
        leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ByteBuf.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractByteBuf(int i8) {
        ObjectUtil.checkPositiveOrZero(i8, "maxCapacity");
        this.maxCapacity = i8;
    }

    private static void checkIndexBounds(int i8, int i9, int i10) {
        if (i8 >= 0 && i8 <= i9 && i9 <= i10) {
            return;
        }
        throw new IndexOutOfBoundsException(String.format("readerIndex: %d, writerIndex: %d (expected: 0 <= readerIndex <= writerIndex <= capacity(%d))", Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)));
    }

    private static void checkRangeBounds(String str, int i8, int i9, int i10) {
        if (!MathUtil.isOutOfBounds(i8, i9, i10)) {
            return;
        }
        throw new IndexOutOfBoundsException(String.format("%s: %d, length: %d (expected: range(0, %d))", str, Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)));
    }

    private static void checkReadableBounds(ByteBuf byteBuf, int i8) {
        if (i8 <= byteBuf.readableBytes()) {
            return;
        }
        throw new IndexOutOfBoundsException(String.format("length(%d) exceeds src.readableBytes(%d) where src is: %s", Integer.valueOf(i8), Integer.valueOf(byteBuf.readableBytes()), byteBuf));
    }

    private void checkReadableBytes0(int i8) {
        ensureAccessible();
        if (checkBounds && this.readerIndex > this.writerIndex - i8) {
            throw new IndexOutOfBoundsException(String.format("readerIndex(%d) + length(%d) exceeds writerIndex(%d): %s", Integer.valueOf(this.readerIndex), Integer.valueOf(i8), Integer.valueOf(this.writerIndex), this));
        }
    }

    private int firstIndexOf(int i8, int i9, byte b8) {
        int max = Math.max(i8, 0);
        if (max < i9 && capacity() != 0) {
            checkIndex(max, i9 - max);
            while (max < i9) {
                if (_getByte(max) == b8) {
                    return max;
                }
                max++;
            }
        }
        return -1;
    }

    private int lastIndexOf(int i8, int i9, byte b8) {
        int min = Math.min(i8, capacity());
        if (min >= 0 && capacity() != 0) {
            checkIndex(i9, min - i9);
            for (int i10 = min - 1; i10 >= i9; i10--) {
                if (_getByte(i10) == b8) {
                    return i10;
                }
            }
        }
        return -1;
    }

    private int setCharSequence0(int i8, CharSequence charSequence, Charset charset, boolean z7) {
        if (charset.equals(CharsetUtil.UTF_8)) {
            int utf8MaxBytes = ByteBufUtil.utf8MaxBytes(charSequence);
            if (z7) {
                ensureWritable0(utf8MaxBytes);
                checkIndex0(i8, utf8MaxBytes);
            } else {
                checkIndex(i8, utf8MaxBytes);
            }
            return ByteBufUtil.writeUtf8(this, i8, charSequence, charSequence.length());
        } else if (!charset.equals(CharsetUtil.US_ASCII) && !charset.equals(CharsetUtil.ISO_8859_1)) {
            byte[] bytes = charSequence.toString().getBytes(charset);
            if (z7) {
                ensureWritable0(bytes.length);
            }
            setBytes(i8, bytes);
            return bytes.length;
        } else {
            int length = charSequence.length();
            if (z7) {
                ensureWritable0(length);
                checkIndex0(i8, length);
            } else {
                checkIndex(i8, length);
            }
            return ByteBufUtil.writeAscii(this, i8, charSequence, length);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte _getByte(int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int _getInt(int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int _getIntLE(int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long _getLong(int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract short _getShort(int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract short _getShortLE(int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int _getUnsignedMedium(int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setByte(int i8, int i9);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setInt(int i8, int i9);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setLong(int i8, long j8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setMedium(int i8, int i9);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setMediumLE(int i8, int i9);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setShort(int i8, int i9);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setShortLE(int i8, int i9);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void adjustMarkers(int i8) {
        int i9 = this.markedReaderIndex;
        if (i9 <= i8) {
            this.markedReaderIndex = 0;
            int i10 = this.markedWriterIndex;
            if (i10 <= i8) {
                this.markedWriterIndex = 0;
                return;
            } else {
                this.markedWriterIndex = i10 - i8;
                return;
            }
        }
        this.markedReaderIndex = i9 - i8;
        this.markedWriterIndex -= i8;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        if (isReadOnly()) {
            return this;
        }
        return Unpooled.unmodifiableBuffer(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkDstIndex(int i8, int i9, int i10, int i11) {
        checkIndex(i8, i9);
        if (checkBounds) {
            checkRangeBounds("dstIndex", i10, i9, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkIndex(int i8) {
        checkIndex(i8, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void checkIndex0(int i8, int i9) {
        if (checkBounds) {
            checkRangeBounds("index", i8, i9, capacity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkNewCapacity(int i8) {
        ensureAccessible();
        if (checkBounds) {
            if (i8 < 0 || i8 > maxCapacity()) {
                throw new IllegalArgumentException("newCapacity: " + i8 + " (expected: 0-" + maxCapacity() + ')');
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkReadableBytes(int i8) {
        checkReadableBytes0(ObjectUtil.checkPositiveOrZero(i8, "minimumReadableBytes"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkSrcIndex(int i8, int i9, int i10, int i11) {
        checkIndex(i8, i9);
        if (checkBounds) {
            checkRangeBounds("srcIndex", i10, i9, i11);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        this.writerIndex = 0;
        this.readerIndex = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void discardMarks() {
        this.markedWriterIndex = 0;
        this.markedReaderIndex = 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        int i8 = this.readerIndex;
        if (i8 > 0) {
            if (i8 == this.writerIndex) {
                ensureAccessible();
                adjustMarkers(this.readerIndex);
                this.readerIndex = 0;
                this.writerIndex = 0;
                return this;
            } else if (i8 >= (capacity() >>> 1)) {
                int i9 = this.readerIndex;
                setBytes(0, this, i9, this.writerIndex - i9);
                int i10 = this.writerIndex;
                int i11 = this.readerIndex;
                this.writerIndex = i10 - i11;
                adjustMarkers(i11);
                this.readerIndex = 0;
                return this;
            }
        }
        ensureAccessible();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        ensureAccessible();
        return new UnpooledDuplicatedByteBuf(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ensureAccessible() {
        if (checkAccessible && !isAccessible()) {
            throw new IllegalReferenceCountException(0);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i8) {
        ensureWritable0(ObjectUtil.checkPositiveOrZero(i8, "minWritableBytes"));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void ensureWritable0(int i8) {
        int calculateNewCapacity;
        int writerIndex = writerIndex();
        int i9 = writerIndex + i8;
        if (i9 <= capacity()) {
            ensureAccessible();
        } else if (checkBounds && i9 > this.maxCapacity) {
            ensureAccessible();
            throw new IndexOutOfBoundsException(String.format("writerIndex(%d) + minWritableBytes(%d) exceeds maxCapacity(%d): %s", Integer.valueOf(writerIndex), Integer.valueOf(i8), Integer.valueOf(this.maxCapacity), this));
        } else {
            int maxFastWritableBytes = maxFastWritableBytes();
            if (maxFastWritableBytes >= i8) {
                calculateNewCapacity = writerIndex + maxFastWritableBytes;
            } else {
                calculateNewCapacity = alloc().calculateNewCapacity(i9, this.maxCapacity);
            }
            capacity(calculateNewCapacity);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        if (this != obj && (!(obj instanceof ByteBuf) || !ByteBufUtil.equals(this, (ByteBuf) obj))) {
            return false;
        }
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        ensureAccessible();
        try {
            return forEachByteAsc0(this.readerIndex, this.writerIndex, byteProcessor);
        } catch (Exception e8) {
            PlatformDependent.throwException(e8);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int forEachByteAsc0(int i8, int i9, ByteProcessor byteProcessor) throws Exception {
        while (i8 < i9) {
            if (!byteProcessor.process(_getByte(i8))) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i8) {
        checkIndex(i8);
        return _getByte(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i8, byte[] bArr) {
        getBytes(i8, bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i8) {
        checkIndex(i8, 4);
        return _getInt(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i8) {
        checkIndex(i8, 4);
        return _getIntLE(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i8) {
        checkIndex(i8, 8);
        return _getLong(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i8) {
        int unsignedMedium = getUnsignedMedium(i8);
        if ((8388608 & unsignedMedium) != 0) {
            return unsignedMedium | (-16777216);
        }
        return unsignedMedium;
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i8) {
        checkIndex(i8, 2);
        return _getShort(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i8) {
        checkIndex(i8, 2);
        return _getShortLE(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i8) {
        return (short) (getByte(i8) & 255);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i8) {
        return getInt(i8) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i8) {
        return getIntLE(i8) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i8) {
        checkIndex(i8, 3);
        return _getUnsignedMedium(i8);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i8) {
        return getShort(i8) & 65535;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i8) {
        return getShortLE(i8) & 65535;
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return ByteBufUtil.hashCode(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i8, int i9, byte b8) {
        if (i8 <= i9) {
            return firstIndexOf(i8, i9, b8);
        }
        return lastIndexOf(i8, i9, b8);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        if (this.writerIndex > this.readerIndex) {
            return true;
        }
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable(int i8) {
        if (capacity() - this.writerIndex >= i8) {
            return true;
        }
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        this.markedReaderIndex = this.readerIndex;
        return this;
    }

    public ByteBuf markWriterIndex() {
        this.markedWriterIndex = this.writerIndex;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.maxCapacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return maxCapacity() - this.writerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SwappedByteBuf newSwappedByteBuf() {
        return new SwappedByteBuf(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return nioBuffer(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return nioBuffers(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == order()) {
            return this;
        }
        ObjectUtil.checkNotNull(byteOrder, "endianness");
        return newSwappedByteBuf();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        checkReadableBytes0(1);
        int i8 = this.readerIndex;
        byte _getByte = _getByte(i8);
        this.readerIndex = i8 + 1;
        return _getByte;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i8) {
        checkReadableBytes(i8);
        if (i8 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf buffer = alloc().buffer(i8, this.maxCapacity);
        buffer.writeBytes(this, this.readerIndex, i8);
        this.readerIndex += i8;
        return buffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        checkReadableBytes0(4);
        int _getInt = _getInt(this.readerIndex);
        this.readerIndex += 4;
        return _getInt;
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        checkReadableBytes0(8);
        long _getLong = _getLong(this.readerIndex);
        this.readerIndex += 8;
        return _getLong;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i8) {
        checkReadableBytes(i8);
        ByteBuf retainedSlice = retainedSlice(this.readerIndex, i8);
        this.readerIndex += i8;
        return retainedSlice;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        checkReadableBytes0(2);
        short _getShort = _getShort(this.readerIndex);
        this.readerIndex += 2;
        return _getShort;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i8) {
        checkReadableBytes(i8);
        ByteBuf slice = slice(this.readerIndex, i8);
        this.readerIndex += i8;
        return slice;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return (short) (readByte() & 255);
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return readInt() & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return readShort() & 65535;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        readerIndex(this.markedReaderIndex);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return duplicate().retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return slice().retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i8, int i9) {
        checkIndex(i8);
        _setByte(i8, i9);
        return this;
    }

    public ByteBuf setBytes(int i8, byte[] bArr) {
        setBytes(i8, bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i8, CharSequence charSequence, Charset charset) {
        return setCharSequence0(i8, charSequence, charset, false);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i8, int i9) {
        if (checkBounds) {
            checkIndexBounds(i8, i9, capacity());
        }
        setIndex0(i8, i9);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setIndex0(int i8, int i9) {
        this.readerIndex = i8;
        this.writerIndex = i9;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i8, int i9) {
        checkIndex(i8, 4);
        _setInt(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i8, long j8) {
        checkIndex(i8, 8);
        _setLong(i8, j8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i8, int i9) {
        checkIndex(i8, 3);
        _setMedium(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i8, int i9) {
        checkIndex(i8, 3);
        _setMediumLE(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i8, int i9) {
        checkIndex(i8, 2);
        _setShort(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i8, int i9) {
        checkIndex(i8, 2);
        _setShortLE(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i8, int i9) {
        if (i9 == 0) {
            return this;
        }
        checkIndex(i8, i9);
        int i10 = i9 & 7;
        for (int i11 = i9 >>> 3; i11 > 0; i11--) {
            _setLong(i8, 0L);
            i8 += 8;
        }
        if (i10 == 4) {
            _setInt(i8, 0);
        } else if (i10 < 4) {
            while (i10 > 0) {
                _setByte(i8, 0);
                i8++;
                i10--;
            }
        } else {
            _setInt(i8, 0);
            int i12 = i8 + 4;
            for (int i13 = i10 - 4; i13 > 0; i13--) {
                _setByte(i12, 0);
                i12++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i8) {
        checkReadableBytes(i8);
        this.readerIndex += i8;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return slice(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return toString(this.readerIndex, readableBytes(), charset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void trimIndicesToCapacity(int i8) {
        if (writerIndex() > i8) {
            setIndex0(Math.min(readerIndex(), i8), i8);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return capacity() - this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i8) {
        ensureWritable0(1);
        int i9 = this.writerIndex;
        this.writerIndex = i9 + 1;
        _setByte(i9, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i8, int i9) {
        ensureWritable(i9);
        setBytes(this.writerIndex, bArr, i8, i9);
        this.writerIndex += i9;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        int charSequence0 = setCharSequence0(this.writerIndex, charSequence, charset, true);
        this.writerIndex += charSequence0;
        return charSequence0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i8) {
        ensureWritable0(4);
        _setInt(this.writerIndex, i8);
        this.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j8) {
        ensureWritable0(8);
        _setLong(this.writerIndex, j8);
        this.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i8) {
        ensureWritable0(3);
        _setMedium(this.writerIndex, i8);
        this.writerIndex += 3;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i8) {
        ensureWritable0(3);
        _setMediumLE(this.writerIndex, i8);
        this.writerIndex += 3;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i8) {
        ensureWritable0(2);
        _setShort(this.writerIndex, i8);
        this.writerIndex += 2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i8) {
        ensureWritable0(2);
        _setShortLE(this.writerIndex, i8);
        this.writerIndex += 2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.writerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkIndex(int i8, int i9) {
        ensureAccessible();
        checkIndex0(i8, i9);
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare(this, byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i8, boolean z7) {
        ensureAccessible();
        ObjectUtil.checkPositiveOrZero(i8, "minWritableBytes");
        if (i8 <= writableBytes()) {
            return 0;
        }
        int maxCapacity = maxCapacity();
        int writerIndex = writerIndex();
        if (i8 > maxCapacity - writerIndex) {
            if (!z7 || capacity() == maxCapacity) {
                return 1;
            }
            capacity(maxCapacity);
            return 3;
        }
        int maxFastWritableBytes = maxFastWritableBytes();
        capacity(maxFastWritableBytes >= i8 ? writerIndex + maxFastWritableBytes : alloc().calculateNewCapacity(writerIndex + i8, maxCapacity));
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void maxCapacity(int i8) {
        this.maxCapacity = i8;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i8) {
        if (checkBounds) {
            checkIndexBounds(i8, this.writerIndex, capacity());
        }
        this.readerIndex = i8;
        return this;
    }

    public ByteBuf retainedSlice(int i8, int i9) {
        return slice(i8, i9).retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i8, int i9) {
        ensureAccessible();
        return new UnpooledSlicedByteBuf(this, i8, i9);
    }

    public String toString(int i8, int i9, Charset charset) {
        return ByteBufUtil.decodeString(this, i8, i9, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i8) {
        if (checkBounds) {
            checkIndexBounds(this.readerIndex, i8, capacity());
        }
        this.writerIndex = i8;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        if (refCnt() == 0) {
            return StringUtil.simpleClassName(this) + "(freed)";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(ridx: ");
        sb.append(this.readerIndex);
        sb.append(", widx: ");
        sb.append(this.writerIndex);
        sb.append(", cap: ");
        sb.append(capacity());
        if (this.maxCapacity != Integer.MAX_VALUE) {
            sb.append('/');
            sb.append(this.maxCapacity);
        }
        ByteBuf unwrap = unwrap();
        if (unwrap != null) {
            sb.append(", unwrapped: ");
            sb.append(unwrap);
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkDstIndex(int i8, int i9, int i10) {
        checkReadableBytes(i8);
        if (checkBounds) {
            checkRangeBounds("dstIndex", i9, i8, i10);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i8, int i9, ByteProcessor byteProcessor) {
        checkIndex(i8, i9);
        try {
            return forEachByteAsc0(i8, i9 + i8, byteProcessor);
        } catch (Exception e8) {
            PlatformDependent.throwException(e8);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        writeBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i8, int i9) {
        checkReadableBytes(i9);
        getBytes(this.readerIndex, bArr, i8, i9);
        this.readerIndex += i9;
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int i8) {
        if (checkBounds) {
            checkReadableBounds(byteBuf, i8);
        }
        writeBytes(byteBuf, byteBuf.readerIndex(), i8);
        byteBuf.readerIndex(byteBuf.readerIndex() + i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        readBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        readBytes(byteBuf, byteBuf.writableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i8, int i9) {
        ensureWritable(i9);
        setBytes(this.writerIndex, byteBuf, i8, i9);
        this.writerIndex += i9;
        return this;
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int i8) {
        if (checkBounds && i8 > byteBuf.writableBytes()) {
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds dst.writableBytes(%d) where dst is: %s", Integer.valueOf(i8), Integer.valueOf(byteBuf.writableBytes()), byteBuf));
        }
        readBytes(byteBuf, byteBuf.writerIndex(), i8);
        byteBuf.writerIndex(byteBuf.writerIndex() + i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        ensureWritable0(remaining);
        setBytes(this.writerIndex, byteBuffer);
        this.writerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i8) throws IOException {
        ensureWritable(i8);
        int bytes = setBytes(this.writerIndex, scatteringByteChannel, i8);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int i8, int i9) {
        checkReadableBytes(i9);
        getBytes(this.readerIndex, byteBuf, i8, i9);
        this.readerIndex += i9;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer);
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i8) throws IOException {
        checkReadableBytes(i8);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i8);
        this.readerIndex += bytes;
        return bytes;
    }
}
