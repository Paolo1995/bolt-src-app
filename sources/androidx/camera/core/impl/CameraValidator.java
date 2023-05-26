package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;

/* loaded from: classes.dex */
public final class CameraValidator {

    /* loaded from: classes.dex */
    public static class CameraIdListIncorrectException extends Exception {
        public CameraIdListIncorrectException(String str, Throwable th) {
            super(str, th);
        }
    }

    private CameraValidator() {
    }

    public static void a(@NonNull Context context, @NonNull CameraRepository cameraRepository, CameraSelector cameraSelector) throws CameraIdListIncorrectException {
        Integer d8;
        if (cameraSelector != null) {
            try {
                d8 = cameraSelector.d();
                if (d8 == null) {
                    Logger.k("CameraValidator", "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e8) {
                Logger.d("CameraValidator", "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e8);
                return;
            }
        } else {
            d8 = null;
        }
        Logger.a("CameraValidator", "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + d8);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera") && (cameraSelector == null || d8.intValue() == 1)) {
                CameraSelector.f3053c.e(cameraRepository.a());
            }
            if (packageManager.hasSystemFeature("android.hardware.camera.front")) {
                if (cameraSelector == null || d8.intValue() == 0) {
                    CameraSelector.f3052b.e(cameraRepository.a());
                }
            }
        } catch (IllegalArgumentException e9) {
            Logger.c("CameraValidator", "Camera LensFacing verification failed, existing cameras: " + cameraRepository.a());
            throw new CameraIdListIncorrectException("Expected camera missing from device.", e9);
        }
    }
}
