package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CameraDeviceCompatBaseImpl implements CameraDeviceCompat.CameraDeviceCompatImpl {

    /* renamed from: a  reason: collision with root package name */
    final CameraDevice f2771a;

    /* renamed from: b  reason: collision with root package name */
    final Object f2772b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CameraDeviceCompatParamsApi21 {

        /* renamed from: a  reason: collision with root package name */
        final Handler f2773a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CameraDeviceCompatParamsApi21(@NonNull Handler handler) {
            this.f2773a = handler;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraDeviceCompatBaseImpl(@NonNull CameraDevice cameraDevice, Object obj) {
        this.f2771a = (CameraDevice) Preconditions.g(cameraDevice);
        this.f2772b = obj;
    }

    private static void b(CameraDevice cameraDevice, @NonNull List<OutputConfigurationCompat> list) {
        String id = cameraDevice.getId();
        for (OutputConfigurationCompat outputConfigurationCompat : list) {
            String c8 = outputConfigurationCompat.c();
            if (c8 != null && !c8.isEmpty()) {
                Logger.k("CameraDeviceCompat", "Camera " + id + ": Camera doesn't support physicalCameraId " + c8 + ". Ignoring.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat) {
        Preconditions.g(cameraDevice);
        Preconditions.g(sessionConfigurationCompat);
        Preconditions.g(sessionConfigurationCompat.e());
        List<OutputConfigurationCompat> c8 = sessionConfigurationCompat.c();
        if (c8 != null) {
            if (sessionConfigurationCompat.a() != null) {
                b(cameraDevice, c8);
                return;
            }
            throw new IllegalArgumentException("Invalid executor");
        }
        throw new IllegalArgumentException("Invalid output configurations");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CameraDeviceCompatBaseImpl d(@NonNull CameraDevice cameraDevice, @NonNull Handler handler) {
        return new CameraDeviceCompatBaseImpl(cameraDevice, new CameraDeviceCompatParamsApi21(handler));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Surface> f(@NonNull List<OutputConfigurationCompat> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (OutputConfigurationCompat outputConfigurationCompat : list) {
            arrayList.add(outputConfigurationCompat.d());
        }
        return arrayList;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void a(@NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        c(this.f2771a, sessionConfigurationCompat);
        if (sessionConfigurationCompat.b() == null) {
            if (sessionConfigurationCompat.d() != 1) {
                CameraCaptureSessionCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper = new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(sessionConfigurationCompat.a(), sessionConfigurationCompat.e());
                e(this.f2771a, f(sessionConfigurationCompat.c()), stateCallbackExecutorWrapper, ((CameraDeviceCompatParamsApi21) this.f2772b).f2773a);
                return;
            }
            throw new IllegalArgumentException("High speed capture sessions not supported until API 23");
        }
        throw new IllegalArgumentException("Reprocessing sessions not supported until API 23");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(@NonNull CameraDevice cameraDevice, @NonNull List<Surface> list, @NonNull CameraCaptureSession.StateCallback stateCallback, @NonNull Handler handler) throws CameraAccessExceptionCompat {
        try {
            cameraDevice.createCaptureSession(list, stateCallback, handler);
        } catch (CameraAccessException e8) {
            throw CameraAccessExceptionCompat.e(e8);
        }
    }
}
