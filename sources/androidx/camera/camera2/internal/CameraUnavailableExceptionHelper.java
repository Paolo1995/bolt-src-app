package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

/* loaded from: classes.dex */
public final class CameraUnavailableExceptionHelper {
    private CameraUnavailableExceptionHelper() {
    }

    @NonNull
    public static CameraUnavailableException a(@NonNull CameraAccessExceptionCompat cameraAccessExceptionCompat) {
        int d8 = cameraAccessExceptionCompat.d();
        int i8 = 5;
        if (d8 != 1) {
            if (d8 != 2) {
                if (d8 != 3) {
                    if (d8 != 4) {
                        if (d8 != 5) {
                            if (d8 != 10001) {
                                i8 = 0;
                            } else {
                                i8 = 6;
                            }
                        }
                    } else {
                        i8 = 4;
                    }
                } else {
                    i8 = 3;
                }
            } else {
                i8 = 2;
            }
        } else {
            i8 = 1;
        }
        return new CameraUnavailableException(i8, cameraAccessExceptionCompat);
    }
}
