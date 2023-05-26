package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public abstract class Packet<T> {
    @NonNull
    public static Packet<Bitmap> j(@NonNull Bitmap bitmap, @NonNull Exif exif, @NonNull Rect rect, int i8, @NonNull Matrix matrix, @NonNull CameraCaptureResult cameraCaptureResult) {
        return new AutoValue_Packet(bitmap, exif, 42, new Size(bitmap.getWidth(), bitmap.getHeight()), rect, i8, matrix, cameraCaptureResult);
    }

    @NonNull
    public static Packet<ImageProxy> k(@NonNull ImageProxy imageProxy, Exif exif, @NonNull Rect rect, int i8, @NonNull Matrix matrix, @NonNull CameraCaptureResult cameraCaptureResult) {
        if (imageProxy.getFormat() == 256) {
            Preconditions.h(exif, "JPEG image must have Exif.");
        }
        return new AutoValue_Packet(imageProxy, exif, imageProxy.getFormat(), new Size(imageProxy.getWidth(), imageProxy.getHeight()), rect, i8, matrix, cameraCaptureResult);
    }

    @NonNull
    public static Packet<byte[]> l(@NonNull byte[] bArr, @NonNull Exif exif, int i8, @NonNull Size size, @NonNull Rect rect, int i9, @NonNull Matrix matrix, @NonNull CameraCaptureResult cameraCaptureResult) {
        return new AutoValue_Packet(bArr, exif, i8, size, rect, i9, matrix, cameraCaptureResult);
    }

    @NonNull
    public abstract CameraCaptureResult a();

    @NonNull
    public abstract Rect b();

    @NonNull
    public abstract T c();

    public abstract Exif d();

    public abstract int e();

    public abstract int f();

    @NonNull
    public abstract Matrix g();

    @NonNull
    public abstract Size h();

    public boolean i() {
        return TransformUtils.e(b(), h());
    }
}
