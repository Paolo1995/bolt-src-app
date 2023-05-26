package androidx.camera.core.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;

/* loaded from: classes.dex */
public class ExifRotationAvailability {
    public boolean a() {
        ImageCaptureRotationOptionQuirk imageCaptureRotationOptionQuirk = (ImageCaptureRotationOptionQuirk) DeviceQuirks.a(ImageCaptureRotationOptionQuirk.class);
        if (imageCaptureRotationOptionQuirk != null && !imageCaptureRotationOptionQuirk.c(CaptureConfig.f3613h)) {
            return false;
        }
        return true;
    }

    public boolean b(@NonNull ImageProxy imageProxy) {
        if (a() && imageProxy.getFormat() == 256) {
            return true;
        }
        return false;
    }
}
