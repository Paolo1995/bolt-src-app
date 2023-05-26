package androidx.camera.core.imagecapture;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import j$.util.Spliterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes.dex */
class JpegBytes2Disk implements Operation<In, ImageCapture.OutputFileResults> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class In {
        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public static In c(@NonNull Packet<byte[]> packet, @NonNull ImageCapture.OutputFileOptions outputFileOptions) {
            return new AutoValue_JpegBytes2Disk_In(packet, outputFileOptions);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public abstract ImageCapture.OutputFileOptions a();

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public abstract Packet<byte[]> b();
    }

    private static Uri b(@NonNull File file, @NonNull File file2) throws ImageCaptureException {
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            return Uri.fromFile(file2);
        }
        throw new ImageCaptureException(1, "Failed to overwrite the file: " + file2.getAbsolutePath(), null);
    }

    private static Uri c(@NonNull File file, @NonNull ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        ContentValues contentValues;
        ContentResolver a8 = outputFileOptions.a();
        Objects.requireNonNull(a8);
        if (outputFileOptions.b() != null) {
            contentValues = new ContentValues(outputFileOptions.b());
        } else {
            contentValues = new ContentValues();
        }
        k(contentValues, 1);
        Uri insert = a8.insert(outputFileOptions.f(), contentValues);
        if (insert != null) {
            try {
                try {
                    f(file, insert, a8);
                    return insert;
                } catch (IOException e8) {
                    throw new ImageCaptureException(1, "Failed to write to MediaStore URI: " + insert, e8);
                }
            } finally {
                m(insert, a8, 0);
            }
        }
        throw new ImageCaptureException(1, "Failed to insert a MediaStore URI.", null);
    }

    private static void d(@NonNull File file, @NonNull OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[Spliterator.IMMUTABLE];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static Uri e(@NonNull File file, @NonNull ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        if (i(outputFileOptions)) {
            return c(file, outputFileOptions);
        }
        if (j(outputFileOptions)) {
            try {
                OutputStream e8 = outputFileOptions.e();
                Objects.requireNonNull(e8);
                OutputStream outputStream = e8;
                d(file, e8);
                return null;
            } catch (IOException unused) {
                throw new ImageCaptureException(1, "Failed to write to OutputStream.", null);
            }
        } else if (h(outputFileOptions)) {
            File c8 = outputFileOptions.c();
            Objects.requireNonNull(c8);
            return b(file, c8);
        } else {
            throw new ImageCaptureException(0, "Invalid OutputFileOptions", null);
        }
    }

    private static void f(@NonNull File file, @NonNull Uri uri, @NonNull ContentResolver contentResolver) throws IOException {
        OutputStream openOutputStream = contentResolver.openOutputStream(uri);
        try {
            if (openOutputStream != null) {
                d(file, openOutputStream);
                openOutputStream.close();
                return;
            }
            throw new FileNotFoundException(uri + " cannot be resolved.");
        } catch (Throwable th) {
            if (openOutputStream != null) {
                try {
                    openOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @NonNull
    private static File g(@NonNull ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        try {
            File c8 = outputFileOptions.c();
            if (c8 != null) {
                String parent = c8.getParent();
                return new File(parent, "CameraX" + UUID.randomUUID().toString() + ".tmp");
            }
            return File.createTempFile("CameraX", ".tmp");
        } catch (IOException e8) {
            throw new ImageCaptureException(1, "Failed to create temp file.", e8);
        }
    }

    private static boolean h(ImageCapture.OutputFileOptions outputFileOptions) {
        if (outputFileOptions.c() != null) {
            return true;
        }
        return false;
    }

    private static boolean i(ImageCapture.OutputFileOptions outputFileOptions) {
        if (outputFileOptions.f() != null && outputFileOptions.a() != null && outputFileOptions.b() != null) {
            return true;
        }
        return false;
    }

    private static boolean j(ImageCapture.OutputFileOptions outputFileOptions) {
        if (outputFileOptions.e() != null) {
            return true;
        }
        return false;
    }

    private static void k(@NonNull ContentValues contentValues, int i8) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i8));
        }
    }

    private static void l(@NonNull File file, @NonNull Exif exif, @NonNull ImageCapture.OutputFileOptions outputFileOptions, int i8) throws ImageCaptureException {
        try {
            Exif h8 = Exif.h(file);
            exif.g(h8);
            if (h8.s() == 0 && i8 != 0) {
                h8.z(i8);
            }
            ImageCapture.Metadata d8 = outputFileOptions.d();
            if (d8.b()) {
                h8.l();
            }
            if (d8.c()) {
                h8.m();
            }
            if (d8.a() != null) {
                h8.b(d8.a());
            }
            h8.A();
        } catch (IOException e8) {
            throw new ImageCaptureException(1, "Failed to update Exif data", e8);
        }
    }

    private static void m(@NonNull Uri uri, @NonNull ContentResolver contentResolver, int i8) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            k(contentValues, i8);
            contentResolver.update(uri, contentValues, null, null);
        }
    }

    private static void n(@NonNull File file, @NonNull byte[] bArr) throws ImageCaptureException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (IOException e8) {
            throw new ImageCaptureException(1, "Failed to write to temp file", e8);
        }
    }

    @Override // androidx.camera.core.processing.Operation
    @NonNull
    /* renamed from: a */
    public ImageCapture.OutputFileResults apply(@NonNull In in) throws ImageCaptureException {
        Packet<byte[]> b8 = in.b();
        ImageCapture.OutputFileOptions a8 = in.a();
        File g8 = g(a8);
        n(g8, b8.c());
        Exif d8 = b8.d();
        Objects.requireNonNull(d8);
        l(g8, d8, a8, b8.f());
        return new ImageCapture.OutputFileResults(e(g8, a8));
    }
}
