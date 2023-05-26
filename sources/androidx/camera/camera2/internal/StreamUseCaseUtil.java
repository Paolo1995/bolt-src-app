package androidx.camera.camera2.internal;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.VideoCaptureConfig;
import java.util.Collection;

/* loaded from: classes.dex */
public final class StreamUseCaseUtil {
    private StreamUseCaseUtil() {
    }

    public static long a(@NonNull Collection<UseCaseConfig<?>> collection, @NonNull Collection<SessionConfig> collection2) {
        if (Build.VERSION.SDK_INT < 33) {
            return -1L;
        }
        if (collection.isEmpty()) {
            return 0L;
        }
        for (SessionConfig sessionConfig : collection2) {
            if (sessionConfig.l() == 5) {
                return 0L;
            }
        }
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        for (UseCaseConfig<?> useCaseConfig : collection) {
            if (useCaseConfig instanceof ImageAnalysisConfig) {
                return 0L;
            }
            if (useCaseConfig instanceof PreviewConfig) {
                z9 = true;
            } else if (useCaseConfig instanceof ImageCaptureConfig) {
                if (z8) {
                    return 4L;
                }
                z7 = true;
            } else if (!(useCaseConfig instanceof VideoCaptureConfig)) {
                continue;
            } else if (z7) {
                return 4L;
            } else {
                z8 = true;
            }
        }
        if (z7) {
            return 2L;
        }
        if (z8) {
            return 3L;
        }
        if (!z9) {
            return 0L;
        }
        return 1L;
    }
}
