package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ApiCompat$Api26Impl {
    private ApiCompat$Api26Impl() {
    }

    @NonNull
    public static <T> OutputConfiguration a(@NonNull Size size, @NonNull Class<T> cls) {
        return new OutputConfiguration(size, cls);
    }

    public static void b(@NonNull CameraCaptureSession.StateCallback stateCallback, @NonNull CameraCaptureSession cameraCaptureSession) {
        stateCallback.onCaptureQueueEmpty(cameraCaptureSession);
    }
}
