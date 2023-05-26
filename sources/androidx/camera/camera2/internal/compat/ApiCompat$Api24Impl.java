package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ApiCompat$Api24Impl {
    private ApiCompat$Api24Impl() {
    }

    public static void a(@NonNull CameraCaptureSession.CaptureCallback captureCallback, @NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j8) {
        captureCallback.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j8);
    }
}
