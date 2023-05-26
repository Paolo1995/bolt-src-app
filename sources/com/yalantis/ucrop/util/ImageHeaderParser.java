package com.yalantis.ucrop.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class ImageHeaderParser {
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final String TAG = "ImageHeaderParser";
    public static final int UNKNOWN_ORIENTATION = -1;
    private final Reader reader;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] bArr, int i8) {
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i8);
        }

        public short getInt16(int i8) {
            return this.data.getShort(i8);
        }

        public int getInt32(int i8) {
            return this.data.getInt(i8);
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface Reader {
        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i8) throws IOException;

        long skip(long j8) throws IOException;
    }

    /* loaded from: classes3.dex */
    private static class StreamReader implements Reader {
        private final InputStream is;

        public StreamReader(InputStream inputStream) {
            this.is = inputStream;
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public int getUInt16() throws IOException {
            return ((this.is.read() << 8) & 65280) | (this.is.read() & ImageHeaderParser.SEGMENT_START_ID);
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public short getUInt8() throws IOException {
            return (short) (this.is.read() & ImageHeaderParser.SEGMENT_START_ID);
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public int read(byte[] bArr, int i8) throws IOException {
            int i9 = i8;
            while (i9 > 0) {
                int read = this.is.read(bArr, i8 - i9, i9);
                if (read == -1) {
                    break;
                }
                i9 -= read;
            }
            return i8 - i9;
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public long skip(long j8) throws IOException {
            if (j8 < 0) {
                return 0L;
            }
            long j9 = j8;
            while (j9 > 0) {
                long skip = this.is.skip(j9);
                if (skip <= 0) {
                    if (this.is.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j9 -= skip;
            }
            return j8 - j9;
        }
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.reader = new StreamReader(inputStream);
    }

    private static int calcTagOffset(int i8, int i9) {
        return i8 + 2 + (i9 * 12);
    }

    public static void copyExif(ExifInterface exifInterface, int i8, int i9, String str) {
        String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "PhotographicSensitivity", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        try {
            ExifInterface exifInterface2 = new ExifInterface(str);
            for (int i10 = 0; i10 < 22; i10++) {
                String str2 = strArr[i10];
                String g8 = exifInterface.g(str2);
                if (!TextUtils.isEmpty(g8)) {
                    exifInterface2.b0(str2, g8);
                }
            }
            exifInterface2.b0("ImageWidth", String.valueOf(i8));
            exifInterface2.b0("ImageLength", String.valueOf(i9));
            exifInterface2.b0("Orientation", "0");
            exifInterface2.W();
        } catch (IOException e8) {
            Log.d(TAG, e8.getMessage());
        }
    }

    private static boolean handles(int i8) {
        return (i8 & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i8 == MOTOROLA_TIFF_MAGIC_NUMBER || i8 == INTEL_TIFF_MAGIC_NUMBER;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i8) {
        boolean z7;
        if (bArr != null && i8 > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int i9 = 0;
            while (true) {
                byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
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

    private int moveToExifSegmentAndGetLength() throws IOException {
        short uInt8;
        short uInt82;
        int uInt16;
        long j8;
        long skip;
        do {
            if (this.reader.getUInt8() != SEGMENT_START_ID) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unknown segmentId=" + ((int) uInt8));
                }
                return -1;
            }
            uInt82 = this.reader.getUInt8();
            if (uInt82 == SEGMENT_SOS) {
                return -1;
            }
            if (uInt82 == MARKER_EOI) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = this.reader.getUInt16() - 2;
            if (uInt82 != EXIF_SEGMENT_TYPE) {
                j8 = uInt16;
                skip = this.reader.skip(j8);
            } else {
                return uInt16;
            }
        } while (skip == j8);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to skip enough data, type: " + ((int) uInt82) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private int parseExifSegment(byte[] bArr, int i8) throws IOException {
        int read = this.reader.read(bArr, i8);
        if (read != i8) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to read exif segment data, length: " + i8 + ", actually read: " + read);
            }
            return -1;
        } else if (hasJpegExifPreamble(bArr, i8)) {
            return parseExifSegment(new RandomAccessReader(bArr, i8));
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    public int getOrientation() throws IOException {
        int uInt16 = this.reader.getUInt16();
        if (!handles(uInt16)) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Parser doesn't handle magic number: " + uInt16);
            }
            return -1;
        }
        int moveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength();
        if (moveToExifSegmentAndGetLength == -1) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        return parseExifSegment(new byte[moveToExifSegmentAndGetLength], moveToExifSegmentAndGetLength);
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short int16 = randomAccessReader.getInt16(6);
        if (int16 == MOTOROLA_TIFF_MAGIC_NUMBER) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (int16 == INTEL_TIFF_MAGIC_NUMBER) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unknown endianness = " + ((int) int16));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int int32 = randomAccessReader.getInt32(10) + 6;
        short int162 = randomAccessReader.getInt16(int32);
        for (int i8 = 0; i8 < int162; i8++) {
            int calcTagOffset = calcTagOffset(int32, i8);
            short int163 = randomAccessReader.getInt16(calcTagOffset);
            if (int163 == ORIENTATION_TAG_TYPE) {
                short int164 = randomAccessReader.getInt16(calcTagOffset + 2);
                if (int164 >= 1 && int164 <= 12) {
                    int int322 = randomAccessReader.getInt32(calcTagOffset + 4);
                    if (int322 < 0) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Got tagIndex=" + i8 + " tagType=" + ((int) int163) + " formatCode=" + ((int) int164) + " componentCount=" + int322);
                        }
                        int i9 = int322 + BYTES_PER_FORMAT[int164];
                        if (i9 > 4) {
                            if (Log.isLoggable(TAG, 3)) {
                                Log.d(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) int164));
                            }
                        } else {
                            int i10 = calcTagOffset + 8;
                            if (i10 >= 0 && i10 <= randomAccessReader.length()) {
                                if (i9 >= 0 && i9 + i10 <= randomAccessReader.length()) {
                                    return randomAccessReader.getInt16(i10);
                                }
                                if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Illegal number of bytes for TI tag data tagType=" + ((int) int163));
                                }
                            } else if (Log.isLoggable(TAG, 3)) {
                                Log.d(TAG, "Illegal tagValueOffset=" + i10 + " tagType=" + ((int) int163));
                            }
                        }
                    }
                } else if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Got invalid format code = " + ((int) int164));
                }
            }
        }
        return -1;
    }
}
