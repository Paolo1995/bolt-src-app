package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileReadWrite.kt */
/* loaded from: classes5.dex */
public class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    public static byte[] a(File file) {
        Intrinsics.f(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                int i8 = (int) length;
                byte[] bArr = new byte[i8];
                int i9 = i8;
                int i10 = 0;
                while (i9 > 0) {
                    int read = fileInputStream.read(bArr, i10, i9);
                    if (read < 0) {
                        break;
                    }
                    i9 -= read;
                    i10 += read;
                }
                if (i9 > 0) {
                    bArr = Arrays.copyOf(bArr, i10);
                    Intrinsics.e(bArr, "copyOf(this, newSize)");
                } else {
                    int read2 = fileInputStream.read();
                    if (read2 != -1) {
                        ExposingBufferByteArrayOutputStream exposingBufferByteArrayOutputStream = new ExposingBufferByteArrayOutputStream(8193);
                        exposingBufferByteArrayOutputStream.write(read2);
                        ByteStreamsKt.b(fileInputStream, exposingBufferByteArrayOutputStream, 0, 2, null);
                        int size = exposingBufferByteArrayOutputStream.size() + i8;
                        if (size >= 0) {
                            byte[] a8 = exposingBufferByteArrayOutputStream.a();
                            byte[] copyOf = Arrays.copyOf(bArr, size);
                            Intrinsics.e(copyOf, "copyOf(this, newSize)");
                            bArr = ArraysKt___ArraysJvmKt.f(a8, copyOf, i8, 0, exposingBufferByteArrayOutputStream.size());
                        } else {
                            throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                        }
                    }
                }
                CloseableKt.a(fileInputStream, null);
                return bArr;
            }
            throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final String b(File file, Charset charset) {
        Intrinsics.f(file, "<this>");
        Intrinsics.f(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String f8 = TextStreamsKt.f(inputStreamReader);
            CloseableKt.a(inputStreamReader, null);
            return f8;
        } finally {
        }
    }

    public static /* synthetic */ String c(File file, Charset charset, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charset = Charsets.f51135b;
        }
        return b(file, charset);
    }

    public static final void d(File file, byte[] array) {
        Intrinsics.f(file, "<this>");
        Intrinsics.f(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            Unit unit = Unit.f50853a;
            CloseableKt.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void e(File file, String text, Charset charset) {
        Intrinsics.f(file, "<this>");
        Intrinsics.f(text, "text");
        Intrinsics.f(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        d(file, bytes);
    }

    public static /* synthetic */ void f(File file, String str, Charset charset, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            charset = Charsets.f51135b;
        }
        e(file, str, charset);
    }
}
