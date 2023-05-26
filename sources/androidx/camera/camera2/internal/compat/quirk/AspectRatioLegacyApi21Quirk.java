package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* loaded from: classes.dex */
public class AspectRatioLegacyApi21Quirk implements Quirk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Integer num = (Integer) cameraCharacteristicsCompat.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num != null && num.intValue() == 2 && Build.VERSION.SDK_INT == 21) {
            return true;
        }
        return false;
    }

    public int a() {
        return 2;
    }
}
