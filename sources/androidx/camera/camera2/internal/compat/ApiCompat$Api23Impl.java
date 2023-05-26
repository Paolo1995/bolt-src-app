package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ApiCompat$Api23Impl {
    private ApiCompat$Api23Impl() {
    }

    public static void a(@NonNull CameraCaptureSession.StateCallback stateCallback, @NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
        stateCallback.onSurfacePrepared(cameraCaptureSession, surface);
    }
}
