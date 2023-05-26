package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.core.impl.SessionConfig;

/* loaded from: classes.dex */
public class PreviewPixelHDRnet {
    private PreviewPixelHDRnet() {
    }

    public static void a(@NonNull SessionConfig.Builder builder) {
        if (((PreviewPixelHDRnetQuirk) DeviceQuirks.a(PreviewPixelHDRnetQuirk.class)) == null) {
            return;
        }
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.e(CaptureRequest.TONEMAP_MODE, 2);
        builder.g(builder2.c());
    }
}
