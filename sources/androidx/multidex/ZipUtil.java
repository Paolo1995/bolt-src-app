package androidx.multidex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
import okhttp3.internal.http2.Http2Stream;

/* loaded from: classes.dex */
final class ZipUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CentralDirectory {

        /* renamed from: a  reason: collision with root package name */
        long f6869a;

        /* renamed from: b  reason: collision with root package name */
        long f6870b;

        CentralDirectory() {
        }
    }

    ZipUtil() {
    }

    static long a(RandomAccessFile randomAccessFile, CentralDirectory centralDirectory) throws IOException {
        CRC32 crc32 = new CRC32();
        long j8 = centralDirectory.f6870b;
        randomAccessFile.seek(centralDirectory.f6869a);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min((long) Http2Stream.EMIT_BUFFER_SIZE, j8));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j8 -= read;
            if (j8 == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min((long) Http2Stream.EMIT_BUFFER_SIZE, j8));
        }
        return crc32.getValue();
    }

    static CentralDirectory b(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        long j8 = 0;
        if (length >= 0) {
            long j9 = length - 65536;
            if (j9 >= 0) {
                j8 = j9;
            }
            int reverseBytes = Integer.reverseBytes(101010256);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    CentralDirectory centralDirectory = new CentralDirectory();
                    centralDirectory.f6870b = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                    centralDirectory.f6869a = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                    return centralDirectory;
                }
                length--;
            } while (length >= j8);
            throw new ZipException("End Of Central Directory signature not found");
        }
        throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long c(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, b(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}
