package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ExposureControl {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Camera2CameraControlImpl f2590a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final ExposureStateImpl f2591b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Executor f2592c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2593d = false;

    /* renamed from: e  reason: collision with root package name */
    private CallbackToFutureAdapter.Completer<Integer> f2594e;

    /* renamed from: f  reason: collision with root package name */
    private Camera2CameraControlImpl.CaptureResultListener f2595f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExposureControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull Executor executor) {
        this.f2590a = camera2CameraControlImpl;
        this.f2591b = new ExposureStateImpl(cameraCharacteristicsCompat, 0);
        this.f2592c = executor;
    }

    private void a() {
        CallbackToFutureAdapter.Completer<Integer> completer = this.f2594e;
        if (completer != null) {
            completer.f(new CameraControl.OperationCanceledException("Cancelled by another setExposureCompensationIndex()"));
            this.f2594e = null;
        }
        Camera2CameraControlImpl.CaptureResultListener captureResultListener = this.f2595f;
        if (captureResultListener != null) {
            this.f2590a.W(captureResultListener);
            this.f2595f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z7) {
        if (z7 == this.f2593d) {
            return;
        }
        this.f2593d = z7;
        if (!z7) {
            this.f2591b.b(0);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@NonNull Camera2ImplConfig.Builder builder) {
        builder.e(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.f2591b.a()));
    }
}
