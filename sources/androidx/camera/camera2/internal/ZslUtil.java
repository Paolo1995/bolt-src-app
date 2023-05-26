package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;

/* loaded from: classes.dex */
final class ZslUtil {
    private ZslUtil() {
    }

    public static boolean a(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, int i8) {
        int[] iArr = (int[]) cameraCharacteristicsCompat.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i9 : iArr) {
                if (i9 == i8) {
                    return true;
                }
            }
        }
        return false;
    }
}
