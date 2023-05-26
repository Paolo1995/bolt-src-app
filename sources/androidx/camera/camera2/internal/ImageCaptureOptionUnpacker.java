package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.workaround.ImageCapturePixelHDRPlus;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* loaded from: classes.dex */
final class ImageCaptureOptionUnpacker extends Camera2CaptureOptionUnpacker {

    /* renamed from: c  reason: collision with root package name */
    static final ImageCaptureOptionUnpacker f2625c = new ImageCaptureOptionUnpacker(new ImageCapturePixelHDRPlus());
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final ImageCapturePixelHDRPlus f2626b;

    private ImageCaptureOptionUnpacker(@NonNull ImageCapturePixelHDRPlus imageCapturePixelHDRPlus) {
        this.f2626b = imageCapturePixelHDRPlus;
    }

    @Override // androidx.camera.camera2.internal.Camera2CaptureOptionUnpacker, androidx.camera.core.impl.CaptureConfig.OptionUnpacker
    public void a(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull CaptureConfig.Builder builder) {
        super.a(useCaseConfig, builder);
        if (useCaseConfig instanceof ImageCaptureConfig) {
            ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) useCaseConfig;
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            if (imageCaptureConfig.Q()) {
                this.f2626b.a(imageCaptureConfig.I(), builder2);
            }
            builder.e(builder2.c());
            return;
        }
        throw new IllegalArgumentException("config is not ImageCaptureConfig");
    }
}
