package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraInfo;

/* loaded from: classes.dex */
public interface SessionProcessor {

    /* loaded from: classes.dex */
    public interface CaptureCallback {
    }

    void a(@NonNull RequestProcessor requestProcessor);

    @NonNull
    SessionConfig b(@NonNull CameraInfo cameraInfo, @NonNull OutputSurface outputSurface, @NonNull OutputSurface outputSurface2, OutputSurface outputSurface3);

    void c();

    void d();

    int e(@NonNull CaptureCallback captureCallback);

    void f(@NonNull Config config);

    int g(@NonNull CaptureCallback captureCallback);
}
