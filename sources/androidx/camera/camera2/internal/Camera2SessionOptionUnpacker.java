package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* loaded from: classes.dex */
final class Camera2SessionOptionUnpacker implements SessionConfig.OptionUnpacker {

    /* renamed from: a  reason: collision with root package name */
    static final Camera2SessionOptionUnpacker f2531a = new Camera2SessionOptionUnpacker();

    @Override // androidx.camera.core.impl.SessionConfig.OptionUnpacker
    public void a(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull SessionConfig.Builder builder) {
        SessionConfig j8 = useCaseConfig.j(null);
        Config I = OptionsBundle.I();
        int l8 = SessionConfig.a().l();
        if (j8 != null) {
            l8 = j8.l();
            builder.a(j8.b());
            builder.c(j8.i());
            builder.b(j8.g());
            I = j8.d();
        }
        builder.q(I);
        Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(useCaseConfig);
        builder.s(camera2ImplConfig.L(l8));
        builder.e(camera2ImplConfig.M(CameraDeviceStateCallbacks.b()));
        builder.j(camera2ImplConfig.P(CameraCaptureSessionStateCallbacks.b()));
        builder.d(CaptureCallbackContainer.d(camera2ImplConfig.O(Camera2CaptureCallbacks.c())));
        MutableOptionsBundle L = MutableOptionsBundle.L();
        L.o(Camera2ImplConfig.G, camera2ImplConfig.I(CameraEventCallbacks.e()));
        L.o(Camera2ImplConfig.I, camera2ImplConfig.N(null));
        L.o(Camera2ImplConfig.C, Long.valueOf(camera2ImplConfig.Q(-1L)));
        builder.g(L);
        builder.g(camera2ImplConfig.J());
    }
}
