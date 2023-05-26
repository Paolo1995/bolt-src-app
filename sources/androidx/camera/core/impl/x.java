package androidx.camera.core.impl;

import android.util.Range;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;

/* compiled from: UseCaseConfig.java */
/* loaded from: classes.dex */
public final /* synthetic */ class x<T extends UseCase> {
    public static CameraSelector a(UseCaseConfig useCaseConfig, CameraSelector cameraSelector) {
        return (CameraSelector) useCaseConfig.e(UseCaseConfig.f3721s, cameraSelector);
    }

    public static CaptureConfig.OptionUnpacker b(UseCaseConfig useCaseConfig, CaptureConfig.OptionUnpacker optionUnpacker) {
        return (CaptureConfig.OptionUnpacker) useCaseConfig.e(UseCaseConfig.f3719q, optionUnpacker);
    }

    public static CaptureConfig c(UseCaseConfig useCaseConfig, CaptureConfig captureConfig) {
        return (CaptureConfig) useCaseConfig.e(UseCaseConfig.f3717o, captureConfig);
    }

    public static SessionConfig d(UseCaseConfig useCaseConfig, SessionConfig sessionConfig) {
        return (SessionConfig) useCaseConfig.e(UseCaseConfig.f3716n, sessionConfig);
    }

    public static SessionConfig.OptionUnpacker e(UseCaseConfig useCaseConfig, SessionConfig.OptionUnpacker optionUnpacker) {
        return (SessionConfig.OptionUnpacker) useCaseConfig.e(UseCaseConfig.f3718p, optionUnpacker);
    }

    public static int f(UseCaseConfig useCaseConfig, int i8) {
        return ((Integer) useCaseConfig.e(UseCaseConfig.f3720r, Integer.valueOf(i8))).intValue();
    }

    public static Range g(UseCaseConfig useCaseConfig, Range range) {
        return (Range) useCaseConfig.e(UseCaseConfig.f3722t, range);
    }

    public static boolean h(UseCaseConfig useCaseConfig, boolean z7) {
        return ((Boolean) useCaseConfig.e(UseCaseConfig.f3723u, Boolean.valueOf(z7))).booleanValue();
    }
}
