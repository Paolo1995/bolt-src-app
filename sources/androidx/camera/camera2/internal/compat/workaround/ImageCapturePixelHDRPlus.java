package androidx.camera.camera2.internal.compat.workaround;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;

/* loaded from: classes.dex */
public class ImageCapturePixelHDRPlus {
    @SuppressLint({"NewApi"})
    public void a(int i8, @NonNull Camera2ImplConfig.Builder builder) {
        if (((ImageCapturePixelHDRPlusQuirk) DeviceQuirks.a(ImageCapturePixelHDRPlusQuirk.class)) == null) {
            return;
        }
        if (i8 != 0) {
            if (i8 == 1) {
                builder.e(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.FALSE);
                return;
            }
            return;
        }
        builder.e(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.TRUE);
    }
}
