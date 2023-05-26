package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;

/* loaded from: classes.dex */
public final class CameraCaptureResults {
    private CameraCaptureResults() {
    }

    public static CameraCaptureResult a(@NonNull ImageInfo imageInfo) {
        if (imageInfo instanceof CameraCaptureResultImageInfo) {
            return ((CameraCaptureResultImageInfo) imageInfo).f();
        }
        return null;
    }
}
