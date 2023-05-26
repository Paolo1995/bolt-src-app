package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* loaded from: classes.dex */
interface CaptureSessionInterface {
    void a(@NonNull List<CaptureConfig> list);

    void b();

    @NonNull
    ListenableFuture<Void> c(boolean z7);

    void close();

    @NonNull
    List<CaptureConfig> d();

    SessionConfig e();

    void f(SessionConfig sessionConfig);

    @NonNull
    ListenableFuture<Void> g(@NonNull SessionConfig sessionConfig, @NonNull CameraDevice cameraDevice, @NonNull SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener);
}
