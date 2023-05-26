package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class TakePictureRequest {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(ImageCaptureException imageCaptureException) {
        boolean z7;
        boolean z8 = true;
        if (g() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (i() == null) {
            z8 = false;
        }
        if (z7 && !z8) {
            ImageCapture.OnImageCapturedCallback g8 = g();
            Objects.requireNonNull(g8);
            g8.b(imageCaptureException);
        } else if (z8 && !z7) {
            ImageCapture.OnImageSavedCallback i8 = i();
            Objects.requireNonNull(i8);
            i8.b(imageCaptureException);
        } else {
            throw new IllegalStateException("One and only one callback is allowed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(ImageCapture.OutputFileResults outputFileResults) {
        ImageCapture.OnImageSavedCallback i8 = i();
        Objects.requireNonNull(i8);
        Objects.requireNonNull(outputFileResults);
        i8.a(outputFileResults);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(ImageProxy imageProxy) {
        ImageCapture.OnImageCapturedCallback g8 = g();
        Objects.requireNonNull(g8);
        Objects.requireNonNull(imageProxy);
        g8.a(imageProxy);
    }

    @NonNull
    public static TakePictureRequest q(@NonNull Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback, ImageCapture.OnImageSavedCallback onImageSavedCallback, ImageCapture.OutputFileOptions outputFileOptions, @NonNull Rect rect, @NonNull Matrix matrix, int i8, int i9, int i10, @NonNull List<CameraCaptureCallback> list) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11 = true;
        if (onImageSavedCallback == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (outputFileOptions == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 == z8) {
            z9 = true;
        } else {
            z9 = false;
        }
        Preconditions.b(z9, "onDiskCallback and outputFileOptions should be both null or both non-null.");
        if (onImageSavedCallback == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (onImageCapturedCallback != null) {
            z11 = false;
        }
        Preconditions.b(z11 ^ z10, "One and only one on-disk or in-memory callback should be present.");
        return new AutoValue_TakePictureRequest(executor, onImageCapturedCallback, onImageSavedCallback, outputFileOptions, rect, matrix, i8, i9, i10, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public abstract Executor d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public abstract Rect f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImageCapture.OnImageCapturedCallback g();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImageCapture.OnImageSavedCallback i();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImageCapture.OutputFileOptions j();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int k();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public abstract Matrix l();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public abstract List<CameraCaptureCallback> m();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(@NonNull final ImageCaptureException imageCaptureException) {
        d().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.n
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureRequest.this.n(imageCaptureException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(final ImageCapture.OutputFileResults outputFileResults) {
        d().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.o
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureRequest.this.o(outputFileResults);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final ImageProxy imageProxy) {
        d().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.p
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureRequest.this.p(imageProxy);
            }
        });
    }
}
