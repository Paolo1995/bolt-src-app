package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f10429a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f10430b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: classes.dex */
    private static final class ByteBufferReader implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10431a;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.f10431a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws Reader.EndOfFileException {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws Reader.EndOfFileException {
            if (this.f10431a.remaining() >= 1) {
                return (short) (this.f10431a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i8) {
            int min = Math.min(i8, this.f10431a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f10431a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j8) {
            int min = (int) Math.min(this.f10431a.remaining(), j8);
            ByteBuffer byteBuffer = this.f10431a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class RandomAccessReader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10432a;

        RandomAccessReader(byte[] bArr, int i8) {
            this.f10432a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i8);
        }

        private boolean c(int i8, int i9) {
            if (this.f10432a.remaining() - i8 >= i9) {
                return true;
            }
            return false;
        }

        short a(int i8) {
            if (c(i8, 2)) {
                return this.f10432a.getShort(i8);
            }
            return (short) -1;
        }

        int b(int i8) {
            if (c(i8, 4)) {
                return this.f10432a.getInt(i8);
            }
            return -1;
        }

        int d() {
            return this.f10432a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.f10432a.order(byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface Reader {

        /* loaded from: classes.dex */
        public static final class EndOfFileException extends IOException {
            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i8) throws IOException;

        long skip(long j8) throws IOException;
    }

    /* loaded from: classes.dex */
    private static final class StreamReader implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f10433a;

        StreamReader(InputStream inputStream) {
            this.f10433a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws IOException {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws IOException {
            int read = this.f10433a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i8) throws IOException {
            int i9 = 0;
            int i10 = 0;
            while (i9 < i8 && (i10 = this.f10433a.read(bArr, i9, i8 - i9)) != -1) {
                i9 += i10;
            }
            if (i9 == 0 && i10 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i9;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j8) throws IOException {
            if (j8 < 0) {
                return 0L;
            }
            long j9 = j8;
            while (j9 > 0) {
                long skip = this.f10433a.skip(j9);
                if (skip <= 0) {
                    if (this.f10433a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j9 -= skip;
            }
            return j8 - j9;
        }
    }

    private static int d(int i8, int i9) {
        return i8 + 2 + (i9 * 12);
    }

    private int e(Reader reader, ArrayPool arrayPool) throws IOException {
        try {
            int uInt16 = reader.getUInt16();
            if (!g(uInt16)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + uInt16);
                }
                return -1;
            }
            int i8 = i(reader);
            if (i8 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) arrayPool.c(i8, byte[].class);
            int k8 = k(reader, bArr, i8);
            arrayPool.put(bArr);
            return k8;
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    @NonNull
    private ImageHeaderParser.ImageType f(Reader reader) throws IOException {
        try {
            int uInt16 = reader.getUInt16();
            if (uInt16 == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int uInt8 = (uInt16 << 8) | reader.getUInt8();
            if (uInt8 == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int uInt82 = (uInt8 << 8) | reader.getUInt8();
            if (uInt82 == -1991225785) {
                reader.skip(21L);
                try {
                    if (reader.getUInt8() >= 3) {
                        return ImageHeaderParser.ImageType.PNG_A;
                    }
                    return ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            } else if (uInt82 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            } else {
                reader.skip(4L);
                if (((reader.getUInt16() << 16) | reader.getUInt16()) != 1464156752) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int uInt162 = (reader.getUInt16() << 16) | reader.getUInt16();
                if ((uInt162 & (-256)) != 1448097792) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int i8 = uInt162 & 255;
                if (i8 == 88) {
                    reader.skip(4L);
                    if ((reader.getUInt8() & 16) != 0) {
                        return ImageHeaderParser.ImageType.WEBP_A;
                    }
                    return ImageHeaderParser.ImageType.WEBP;
                } else if (i8 == 76) {
                    reader.skip(4L);
                    if ((reader.getUInt8() & 8) != 0) {
                        return ImageHeaderParser.ImageType.WEBP_A;
                    }
                    return ImageHeaderParser.ImageType.WEBP;
                } else {
                    return ImageHeaderParser.ImageType.WEBP;
                }
            }
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private static boolean g(int i8) {
        return (i8 & 65496) == 65496 || i8 == 19789 || i8 == 18761;
    }

    private boolean h(byte[] bArr, int i8) {
        boolean z7;
        if (bArr != null && i8 > f10429a.length) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int i9 = 0;
            while (true) {
                byte[] bArr2 = f10429a;
                if (i9 >= bArr2.length) {
                    break;
                } else if (bArr[i9] != bArr2[i9]) {
                    return false;
                } else {
                    i9++;
                }
            }
        }
        return z7;
    }

    private int i(Reader reader) throws IOException {
        short uInt8;
        short uInt82;
        int uInt16;
        long j8;
        long skip;
        do {
            if (reader.getUInt8() != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) uInt8));
                }
                return -1;
            }
            uInt82 = reader.getUInt8();
            if (uInt82 == 218) {
                return -1;
            }
            if (uInt82 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = reader.getUInt16() - 2;
            if (uInt82 != 225) {
                j8 = uInt16;
                skip = reader.skip(j8);
            } else {
                return uInt16;
            }
        } while (skip == j8);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) uInt82) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private static int j(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short a8 = randomAccessReader.a(6);
        if (a8 != 18761) {
            if (a8 != 19789) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) a8));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.BIG_ENDIAN;
            }
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        randomAccessReader.e(byteOrder);
        int b8 = randomAccessReader.b(10) + 6;
        short a9 = randomAccessReader.a(b8);
        for (int i8 = 0; i8 < a9; i8++) {
            int d8 = d(b8, i8);
            short a10 = randomAccessReader.a(d8);
            if (a10 == 274) {
                short a11 = randomAccessReader.a(d8 + 2);
                if (a11 >= 1 && a11 <= 12) {
                    int b9 = randomAccessReader.b(d8 + 4);
                    if (b9 < 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i8 + " tagType=" + ((int) a10) + " formatCode=" + ((int) a11) + " componentCount=" + b9);
                        }
                        int i9 = b9 + f10430b[a11];
                        if (i9 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a11));
                            }
                        } else {
                            int i10 = d8 + 8;
                            if (i10 >= 0 && i10 <= randomAccessReader.d()) {
                                if (i9 >= 0 && i9 + i10 <= randomAccessReader.d()) {
                                    return randomAccessReader.a(i10);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a10));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i10 + " tagType=" + ((int) a10));
                            }
                        }
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) a11));
                }
            }
        }
        return -1;
    }

    private int k(Reader reader, byte[] bArr, int i8) throws IOException {
        int read = reader.read(bArr, i8);
        if (read != i8) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i8 + ", actually read: " + read);
            }
            return -1;
        } else if (h(bArr, i8)) {
            return j(new RandomAccessReader(bArr, i8));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException {
        return f(new ByteBufferReader((ByteBuffer) Preconditions.d(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType b(@NonNull InputStream inputStream) throws IOException {
        return f(new StreamReader((InputStream) Preconditions.d(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int c(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        return e(new StreamReader((InputStream) Preconditions.d(inputStream)), (ArrayPool) Preconditions.d(arrayPool));
    }
}
