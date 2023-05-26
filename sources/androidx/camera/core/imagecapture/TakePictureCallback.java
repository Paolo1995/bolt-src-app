package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;

/* loaded from: classes.dex */
interface TakePictureCallback {
    void a(@NonNull ImageCapture.OutputFileResults outputFileResults);

    void b(@NonNull ImageCaptureException imageCaptureException);

    void c(@NonNull ImageProxy imageProxy);

    void d(@NonNull ImageCaptureException imageCaptureException);

    void e();

    boolean isAborted();
}
