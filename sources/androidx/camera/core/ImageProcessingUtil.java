package androidx.camera.core;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class ImageProcessingUtil {
    static {
        System.loadLibrary("image_processing_util_jni");
    }

    private ImageProcessingUtil() {
    }

    public static ImageProxy a(@NonNull ImageReaderProxy imageReaderProxy, @NonNull byte[] bArr) {
        boolean z7;
        if (imageReaderProxy.c() == 256) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.a(z7);
        Preconditions.g(bArr);
        Surface surface = imageReaderProxy.getSurface();
        Preconditions.g(surface);
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            Logger.c("ImageProcessingUtil", "Failed to enqueue JPEG image.");
            return null;
        }
        ImageProxy b8 = imageReaderProxy.b();
        if (b8 == null) {
            Logger.c("ImageProcessingUtil", "Failed to get acquire JPEG image.");
        }
        return b8;
    }

    private static native int nativeWriteJpegToSurface(@NonNull byte[] bArr, @NonNull Surface surface);
}
