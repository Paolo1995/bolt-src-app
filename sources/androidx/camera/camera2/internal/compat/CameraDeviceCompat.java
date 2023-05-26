package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class CameraDeviceCompat {

    /* renamed from: a  reason: collision with root package name */
    private final CameraDeviceCompatImpl f2768a;

    /* loaded from: classes.dex */
    interface CameraDeviceCompatImpl {
        void a(@NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class StateCallbackExecutorWrapper extends CameraDevice.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        final CameraDevice.StateCallback f2769a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f2770b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public StateCallbackExecutorWrapper(@NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) {
            this.f2770b = executor;
            this.f2769a = stateCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(CameraDevice cameraDevice) {
            this.f2769a.onClosed(cameraDevice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(CameraDevice cameraDevice) {
            this.f2769a.onDisconnected(cameraDevice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(CameraDevice cameraDevice, int i8) {
            this.f2769a.onError(cameraDevice, i8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(CameraDevice cameraDevice) {
            this.f2769a.onOpened(cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(@NonNull final CameraDevice cameraDevice) {
            this.f2770b.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.o
                @Override // java.lang.Runnable
                public final void run() {
                    CameraDeviceCompat.StateCallbackExecutorWrapper.this.e(cameraDevice);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull final CameraDevice cameraDevice) {
            this.f2770b.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.p
                @Override // java.lang.Runnable
                public final void run() {
                    CameraDeviceCompat.StateCallbackExecutorWrapper.this.f(cameraDevice);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull final CameraDevice cameraDevice, final int i8) {
            this.f2770b.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.r
                @Override // java.lang.Runnable
                public final void run() {
                    CameraDeviceCompat.StateCallbackExecutorWrapper.this.g(cameraDevice, i8);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull final CameraDevice cameraDevice) {
            this.f2770b.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.q
                @Override // java.lang.Runnable
                public final void run() {
                    CameraDeviceCompat.StateCallbackExecutorWrapper.this.h(cameraDevice);
                }
            });
        }
    }

    private CameraDeviceCompat(@NonNull CameraDevice cameraDevice, @NonNull Handler handler) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 28) {
            this.f2768a = new CameraDeviceCompatApi28Impl(cameraDevice);
        } else if (i8 >= 24) {
            this.f2768a = CameraDeviceCompatApi24Impl.h(cameraDevice, handler);
        } else if (i8 >= 23) {
            this.f2768a = CameraDeviceCompatApi23Impl.g(cameraDevice, handler);
        } else {
            this.f2768a = CameraDeviceCompatBaseImpl.d(cameraDevice, handler);
        }
    }

    @NonNull
    public static CameraDeviceCompat b(@NonNull CameraDevice cameraDevice, @NonNull Handler handler) {
        return new CameraDeviceCompat(cameraDevice, handler);
    }

    public void a(@NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        this.f2768a.a(sessionConfigurationCompat);
    }
}
