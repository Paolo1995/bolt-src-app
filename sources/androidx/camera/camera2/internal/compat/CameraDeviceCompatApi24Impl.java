package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.core.util.Preconditions;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CameraDeviceCompatApi24Impl extends CameraDeviceCompatApi23Impl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraDeviceCompatApi24Impl(@NonNull CameraDevice cameraDevice, Object obj) {
        super(cameraDevice, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CameraDeviceCompatApi24Impl h(@NonNull CameraDevice cameraDevice, @NonNull Handler handler) {
        return new CameraDeviceCompatApi24Impl(cameraDevice, new CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21(handler));
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompatApi23Impl, androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void a(@NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        CameraDeviceCompatBaseImpl.c(this.f2771a, sessionConfigurationCompat);
        CameraCaptureSessionCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper = new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(sessionConfigurationCompat.a(), sessionConfigurationCompat.e());
        List<OutputConfigurationCompat> c8 = sessionConfigurationCompat.c();
        Handler handler = ((CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21) Preconditions.g((CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21) this.f2772b)).f2773a;
        InputConfigurationCompat b8 = sessionConfigurationCompat.b();
        try {
            if (b8 != null) {
                InputConfiguration inputConfiguration = (InputConfiguration) b8.a();
                Preconditions.g(inputConfiguration);
                this.f2771a.createReprocessableCaptureSessionByConfigurations(inputConfiguration, SessionConfigurationCompat.h(c8), stateCallbackExecutorWrapper, handler);
            } else if (sessionConfigurationCompat.d() == 1) {
                this.f2771a.createConstrainedHighSpeedCaptureSession(CameraDeviceCompatBaseImpl.f(c8), stateCallbackExecutorWrapper, handler);
            } else {
                this.f2771a.createCaptureSessionByOutputConfigurations(SessionConfigurationCompat.h(c8), stateCallbackExecutorWrapper, handler);
            }
        } catch (CameraAccessException e8) {
            throw CameraAccessExceptionCompat.e(e8);
        }
    }
}
