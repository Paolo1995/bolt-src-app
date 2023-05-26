package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CameraCaptureSessionCompatBaseImpl implements CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl {

    /* renamed from: a  reason: collision with root package name */
    final CameraCaptureSession f2762a;

    /* renamed from: b  reason: collision with root package name */
    final Object f2763b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CameraCaptureSessionCompatParamsApi21 {

        /* renamed from: a  reason: collision with root package name */
        final Handler f2764a;

        CameraCaptureSessionCompatParamsApi21(@NonNull Handler handler) {
            this.f2764a = handler;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraCaptureSessionCompatBaseImpl(@NonNull CameraCaptureSession cameraCaptureSession, Object obj) {
        this.f2762a = (CameraCaptureSession) Preconditions.g(cameraCaptureSession);
        this.f2763b = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl d(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Handler handler) {
        return new CameraCaptureSessionCompatBaseImpl(cameraCaptureSession, new CameraCaptureSessionCompatParamsApi21(handler));
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    @NonNull
    public CameraCaptureSession a() {
        return this.f2762a;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int b(@NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f2762a.captureBurst(list, new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(executor, captureCallback), ((CameraCaptureSessionCompatParamsApi21) this.f2763b).f2764a);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int c(@NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f2762a.setRepeatingRequest(captureRequest, new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(executor, captureCallback), ((CameraCaptureSessionCompatParamsApi21) this.f2763b).f2764a);
    }
}
