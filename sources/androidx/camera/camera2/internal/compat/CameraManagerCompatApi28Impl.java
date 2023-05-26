package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CameraManagerCompatApi28Impl extends CameraManagerCompatBaseImpl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraManagerCompatApi28Impl(@NonNull Context context) {
        super(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CameraManagerCompatApi28Impl g(@NonNull Context context) {
        return new CameraManagerCompatApi28Impl(context);
    }

    private boolean h(@NonNull Throwable th) {
        if (Build.VERSION.SDK_INT == 28 && i(th)) {
            return true;
        }
        return false;
    }

    private static boolean i(@NonNull Throwable th) {
        StackTraceElement[] stackTrace;
        if (!th.getClass().equals(RuntimeException.class) || (stackTrace = th.getStackTrace()) == null || stackTrace.length < 0) {
            return false;
        }
        return "_enableShutterSound".equals(stackTrace[0].getMethodName());
    }

    private void j(@NonNull Throwable th) throws CameraAccessExceptionCompat {
        throw new CameraAccessExceptionCompat(10001, th);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void a(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.f2780a.registerAvailabilityCallback(executor, availabilityCallback);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @NonNull
    public CameraCharacteristics b(@NonNull String str) throws CameraAccessExceptionCompat {
        try {
            return super.b(str);
        } catch (RuntimeException e8) {
            if (h(e8)) {
                j(e8);
            }
            throw e8;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void c(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        try {
            this.f2780a.openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e8) {
            throw CameraAccessExceptionCompat.e(e8);
        } catch (IllegalArgumentException e9) {
            throw e9;
        } catch (SecurityException e10) {
        } catch (RuntimeException e11) {
            if (h(e11)) {
                j(e11);
            }
            throw e11;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void e(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.f2780a.unregisterAvailabilityCallback(availabilityCallback);
    }
}
