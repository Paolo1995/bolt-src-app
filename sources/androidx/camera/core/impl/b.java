package androidx.camera.core.impl;

import androidx.annotation.NonNull;

/* compiled from: CameraConfig.java */
/* loaded from: classes.dex */
public final /* synthetic */ class b {
    public static SessionProcessor a(CameraConfig cameraConfig, SessionProcessor sessionProcessor) {
        return (SessionProcessor) cameraConfig.e(CameraConfig.f3587d, sessionProcessor);
    }

    public static int b(CameraConfig cameraConfig) {
        return ((Integer) cameraConfig.e(CameraConfig.f3586c, 0)).intValue();
    }

    @NonNull
    public static UseCaseConfigFactory c(CameraConfig cameraConfig) {
        return (UseCaseConfigFactory) cameraConfig.e(CameraConfig.f3584a, UseCaseConfigFactory.f3724a);
    }
}
