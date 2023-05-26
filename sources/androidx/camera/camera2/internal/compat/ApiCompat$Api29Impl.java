package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraManager;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ApiCompat$Api29Impl {
    private ApiCompat$Api29Impl() {
    }

    public static void a(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        availabilityCallback.onCameraAccessPrioritiesChanged();
    }
}
