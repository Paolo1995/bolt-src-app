package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import androidx.camera.core.Logger;
import java.nio.BufferUnderflowException;

/* loaded from: classes.dex */
public final class FlashAvailabilityChecker {
    private FlashAvailabilityChecker() {
    }

    private static boolean a(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Boolean bool = (Boolean) cameraCharacteristicsCompat.a(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool == null) {
            Logger.k("FlashAvailability", "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static boolean b(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        try {
            return a(cameraCharacteristicsCompat);
        } catch (BufferUnderflowException unused) {
            return false;
        }
    }

    public static boolean c(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        if (DeviceQuirks.a(FlashAvailabilityBufferUnderflowQuirk.class) != null) {
            Logger.a("FlashAvailability", "Device has quirk " + FlashAvailabilityBufferUnderflowQuirk.class.getSimpleName() + ". Checking for flash availability safely...");
            return b(cameraCharacteristicsCompat);
        }
        return a(cameraCharacteristicsCompat);
    }
}
