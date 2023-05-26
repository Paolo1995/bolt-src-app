package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;

/* loaded from: classes.dex */
class Camera2CaptureOptionUnpacker implements CaptureConfig.OptionUnpacker {

    /* renamed from: a  reason: collision with root package name */
    static final Camera2CaptureOptionUnpacker f2485a = new Camera2CaptureOptionUnpacker();

    @Override // androidx.camera.core.impl.CaptureConfig.OptionUnpacker
    public void a(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull CaptureConfig.Builder builder) {
        CaptureConfig p8 = useCaseConfig.p(null);
        Config I = OptionsBundle.I();
        int g8 = CaptureConfig.a().g();
        if (p8 != null) {
            g8 = p8.g();
            builder.a(p8.b());
            I = p8.d();
        }
        builder.o(I);
        Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(useCaseConfig);
        builder.p(camera2ImplConfig.L(g8));
        builder.c(CaptureCallbackContainer.d(camera2ImplConfig.O(Camera2CaptureCallbacks.c())));
        builder.e(camera2ImplConfig.J());
    }
}
