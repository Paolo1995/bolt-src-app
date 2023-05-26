package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraInfo;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface CameraInfoInternal extends CameraInfo {
    @NonNull
    String a();

    void b(@NonNull Executor executor, @NonNull CameraCaptureCallback cameraCaptureCallback);

    Integer c();

    @NonNull
    Quirks d();

    void e(@NonNull CameraCaptureCallback cameraCaptureCallback);
}
