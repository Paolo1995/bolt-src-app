package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ApiCompat$Api21Impl {
    private ApiCompat$Api21Impl() {
    }

    public static void a(@NonNull CameraDevice cameraDevice) {
        cameraDevice.close();
    }
}
