package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraCaptureCallback;

/* loaded from: classes.dex */
final class CaptureCallbackContainer extends CameraCaptureCallback {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSession.CaptureCallback f2542a;

    private CaptureCallbackContainer(CameraCaptureSession.CaptureCallback captureCallback) {
        if (captureCallback != null) {
            this.f2542a = captureCallback;
            return;
        }
        throw new NullPointerException("captureCallback is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CaptureCallbackContainer d(CameraCaptureSession.CaptureCallback captureCallback) {
        return new CaptureCallbackContainer(captureCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CameraCaptureSession.CaptureCallback e() {
        return this.f2542a;
    }
}
