package androidx.camera.core;

import android.content.ContentValues;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import j$.util.Spliterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ImageSaver implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final ImageProxy f3188f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3189g;

    /* renamed from: h  reason: collision with root package name */
    private final int f3190h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ImageCapture.OutputFileOptions f3191i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final Executor f3192j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final OnImageSavedCallback f3193k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final Executor f3194l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.core.ImageSaver$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3195a;

        static {
            int[] iArr = new int[ImageUtil.CodecFailedException.FailureType.values().length];
            f3195a = iArr;
            try {
                iArr[ImageUtil.CodecFailedException.FailureType.ENCODE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3195a[ImageUtil.CodecFailedException.FailureType.DECODE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3195a[ImageUtil.CodecFailedException.FailureType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnImageSavedCallback {
        void a(@NonNull ImageCapture.OutputFileResults outputFileResults);

        void b(@NonNull SaveError saveError, @NonNull String str, Throwable th);
    }

    /* loaded from: classes.dex */
    public enum SaveError {
        FILE_IO_FAILED,
        ENCODE_FAILED,
        CROP_FAILED,
        UNKNOWN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageSaver(@NonNull ImageProxy imageProxy, @NonNull ImageCapture.OutputFileOptions outputFileOptions, int i8, int i9, @NonNull Executor executor, @NonNull Executor executor2, @NonNull OnImageSavedCallback onImageSavedCallback) {
        this.f3188f = imageProxy;
        this.f3191i = outputFileOptions;
        this.f3189g = i8;
        this.f3190h = i9;
        this.f3193k = onImageSavedCallback;
        this.f3192j = executor;
        this.f3194l = executor2;
    }

    private void e(@NonNull File file, @NonNull OutputStream outputStream) throws IOException {
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

    private boolean f(@NonNull File file, @NonNull Uri uri) throws IOException {
        OutputStream openOutputStream = this.f3191i.a().openOutputStream(uri);
        if (openOutputStream == null) {
            if (openOutputStream != null) {
                openOutputStream.close();
            }
            return false;
        }
        try {
            e(file, openOutputStream);
            openOutputStream.close();
            return true;
        } catch (Throwable th) {
            try {
                openOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NonNull
    private byte[] g(@NonNull ImageProxy imageProxy, int i8) throws ImageUtil.CodecFailedException {
        boolean n8 = ImageUtil.n(imageProxy);
        int format = imageProxy.getFormat();
        if (format == 256) {
            if (!n8) {
                return ImageUtil.i(imageProxy);
            }
            return ImageUtil.j(imageProxy, imageProxy.x0(), i8);
        }
        Rect rect = null;
        if (format == 35) {
            if (n8) {
                rect = imageProxy.x0();
            }
            return ImageUtil.p(imageProxy, rect, i8);
        }
        Logger.k("ImageSaver", "Unrecognized image format: " + format);
        return null;
    }

    private boolean h() {
        if (this.f3191i.c() != null) {
            return true;
        }
        return false;
    }

    private boolean i() {
        if (this.f3191i.f() != null && this.f3191i.a() != null && this.f3191i.b() != null) {
            return true;
        }
        return false;
    }

    private boolean j() {
        if (this.f3191i.e() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(SaveError saveError, String str, Throwable th) {
        this.f3193k.b(saveError, str, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Uri uri) {
        this.f3193k.a(new ImageCapture.OutputFileResults(uri));
    }

    private void n(final SaveError saveError, final String str, final Throwable th) {
        try {
            this.f3192j.execute(new Runnable() { // from class: androidx.camera.core.h0
                @Override // java.lang.Runnable
                public final void run() {
                    ImageSaver.this.k(saveError, str, th);
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.c("ImageSaver", "Application executor rejected executing OnImageSavedCallback.onError callback. Skipping.");
        }
    }

    private void o(final Uri uri) {
        try {
            this.f3192j.execute(new Runnable() { // from class: androidx.camera.core.g0
                @Override // java.lang.Runnable
                public final void run() {
                    ImageSaver.this.l(uri);
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.c("ImageSaver", "Application executor rejected executing OnImageSavedCallback.onImageSaved callback. Skipping.");
        }
    }

    private File p() {
        File createTempFile;
        SaveError saveError;
        String str;
        ImageUtil.CodecFailedException codecFailedException;
        ImageProxy imageProxy;
        try {
            if (h()) {
                createTempFile = new File(this.f3191i.c().getParent(), "CameraX" + UUID.randomUUID().toString() + ".tmp");
            } else {
                createTempFile = File.createTempFile("CameraX", ".tmp");
            }
            try {
                imageProxy = this.f3188f;
            } catch (ImageUtil.CodecFailedException e8) {
                int i8 = AnonymousClass1.f3195a[e8.a().ordinal()];
                if (i8 != 1) {
                    if (i8 != 2) {
                        saveError = SaveError.UNKNOWN;
                        str = "Failed to transcode mImage";
                        codecFailedException = e8;
                    } else {
                        saveError = SaveError.CROP_FAILED;
                        str = "Failed to crop mImage";
                        codecFailedException = e8;
                    }
                } else {
                    saveError = SaveError.ENCODE_FAILED;
                    str = "Failed to encode mImage";
                    codecFailedException = e8;
                }
            } catch (IOException e9) {
                e = e9;
                saveError = SaveError.FILE_IO_FAILED;
                str = "Failed to write temp file";
                codecFailedException = e;
            } catch (IllegalArgumentException e10) {
                e = e10;
                saveError = SaveError.FILE_IO_FAILED;
                str = "Failed to write temp file";
                codecFailedException = e;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                fileOutputStream.write(g(this.f3188f, this.f3190h));
                Exif h8 = Exif.h(createTempFile);
                Exif.j(this.f3188f).g(h8);
                if (!new ExifRotationAvailability().b(this.f3188f)) {
                    h8.z(this.f3189g);
                }
                ImageCapture.Metadata d8 = this.f3191i.d();
                if (d8.b()) {
                    h8.l();
                }
                if (d8.c()) {
                    h8.m();
                }
                if (d8.a() != null) {
                    h8.b(this.f3191i.d().a());
                }
                h8.A();
                fileOutputStream.close();
                if (imageProxy != null) {
                    imageProxy.close();
                }
                codecFailedException = null;
                saveError = null;
                str = null;
                if (saveError != null) {
                    n(saveError, str, codecFailedException);
                    createTempFile.delete();
                    return null;
                }
                return createTempFile;
            } catch (Throwable th) {
                if (imageProxy != null) {
                    try {
                        imageProxy.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e11) {
            n(SaveError.FILE_IO_FAILED, "Failed to create temp file", e11);
            return null;
        }
    }

    private void q(@NonNull ContentValues contentValues, int i8) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i8));
        }
    }

    private void r(@NonNull Uri uri) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            q(contentValues, 0);
            this.f3191i.a().update(uri, contentValues, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m(@androidx.annotation.NonNull java.io.File r6) {
        /*
            r5 = this;
            androidx.core.util.Preconditions.g(r6)
            r0 = 0
            boolean r1 = r5.i()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            if (r1 == 0) goto L54
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.f3191i     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            android.content.ContentValues r1 = r1.b()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            if (r1 == 0) goto L1e
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            androidx.camera.core.ImageCapture$OutputFileOptions r2 = r5.f3191i     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            android.content.ContentValues r2 = r2.b()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            goto L23
        L1e:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            r1.<init>()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
        L23:
            r2 = 1
            r5.q(r1, r2)     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            androidx.camera.core.ImageCapture$OutputFileOptions r2 = r5.f3191i     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            android.content.ContentResolver r2 = r2.a()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            androidx.camera.core.ImageCapture$OutputFileOptions r3 = r5.f3191i     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            android.net.Uri r3 = r3.f()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            android.net.Uri r1 = r2.insert(r3, r1)     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            if (r1 != 0) goto L3f
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch: java.lang.IllegalArgumentException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L8f
            java.lang.String r3 = "Failed to insert URI."
            goto L9b
        L3f:
            boolean r2 = r5.f(r6, r1)     // Catch: java.lang.IllegalArgumentException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L8f
            if (r2 != 0) goto L4a
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch: java.lang.IllegalArgumentException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L8f
            java.lang.String r3 = "Failed to save to URI."
            goto L4c
        L4a:
            r2 = r0
            r3 = r2
        L4c:
            r5.r(r1)     // Catch: java.lang.IllegalArgumentException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L8f
            goto L9b
        L50:
            r0 = move-exception
            goto L97
        L52:
            r0 = move-exception
            goto L97
        L54:
            boolean r1 = r5.j()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            if (r1 == 0) goto L64
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.f3191i     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            java.io.OutputStream r1 = r1.e()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            r5.e(r6, r1)     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            goto L8b
        L64:
            boolean r1 = r5.h()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            if (r1 == 0) goto L8b
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.f3191i     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            java.io.File r1 = r1.c()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            if (r2 == 0) goto L79
            r1.delete()     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
        L79:
            boolean r2 = r6.renameTo(r1)     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            if (r2 != 0) goto L84
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            java.lang.String r3 = "Failed to rename file."
            goto L86
        L84:
            r2 = r0
            r3 = r2
        L86:
            android.net.Uri r1 = android.net.Uri.fromFile(r1)     // Catch: java.lang.Throwable -> L8f java.lang.IllegalArgumentException -> L91 java.io.IOException -> L93
            goto L9b
        L8b:
            r1 = r0
            r2 = r1
            r3 = r2
            goto L9b
        L8f:
            r0 = move-exception
            goto La8
        L91:
            r1 = move-exception
            goto L94
        L93:
            r1 = move-exception
        L94:
            r4 = r1
            r1 = r0
            r0 = r4
        L97:
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch: java.lang.Throwable -> L8f
            java.lang.String r3 = "Failed to write destination file."
        L9b:
            r6.delete()
            if (r2 == 0) goto La4
            r5.n(r2, r3, r0)
            goto La7
        La4:
            r5.o(r1)
        La7:
            return
        La8:
            r6.delete()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.m(java.io.File):void");
    }

    @Override // java.lang.Runnable
    public void run() {
        final File p8 = p();
        if (p8 != null) {
            this.f3194l.execute(new Runnable() { // from class: androidx.camera.core.f0
                @Override // java.lang.Runnable
                public final void run() {
                    ImageSaver.this.m(p8);
                }
            });
        }
    }
}
