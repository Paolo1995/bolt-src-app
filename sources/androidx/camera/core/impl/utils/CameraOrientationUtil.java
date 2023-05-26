package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;

/* loaded from: classes.dex */
public final class CameraOrientationUtil {
    private CameraOrientationUtil() {
    }

    public static int a(int i8, int i9, boolean z7) {
        int i10;
        if (z7) {
            i10 = ((i9 - i8) + 360) % 360;
        } else {
            i10 = (i9 + i8) % 360;
        }
        if (Logger.f("CameraOrientationUtil")) {
            Logger.a("CameraOrientationUtil", String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", Integer.valueOf(i8), Integer.valueOf(i9), Boolean.valueOf(z7), Integer.valueOf(i10)));
        }
        return i10;
    }

    public static int b(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        return 270;
                    }
                    throw new IllegalArgumentException("Unsupported surface rotation: " + i8);
                }
                return 180;
            }
            return 90;
        }
        return 0;
    }
}
