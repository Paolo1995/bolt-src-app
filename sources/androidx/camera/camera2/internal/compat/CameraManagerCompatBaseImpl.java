package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CameraManagerCompatBaseImpl implements CameraManagerCompat.CameraManagerCompatImpl {

    /* renamed from: a  reason: collision with root package name */
    final CameraManager f2780a;

    /* renamed from: b  reason: collision with root package name */
    final Object f2781b;

    /* loaded from: classes.dex */
    static final class CameraManagerCompatParamsApi21 {

        /* renamed from: a  reason: collision with root package name */
        final Map<CameraManager.AvailabilityCallback, CameraManagerCompat.AvailabilityCallbackExecutorWrapper> f2782a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Handler f2783b;

        CameraManagerCompatParamsApi21(@NonNull Handler handler) {
            this.f2783b = handler;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraManagerCompatBaseImpl(@NonNull Context context, Object obj) {
        this.f2780a = (CameraManager) context.getSystemService("camera");
        this.f2781b = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CameraManagerCompatBaseImpl f(@NonNull Context context, @NonNull Handler handler) {
        return new CameraManagerCompatBaseImpl(context, new CameraManagerCompatParamsApi21(handler));
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void a(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        if (executor != null) {
            CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper = null;
            CameraManagerCompatParamsApi21 cameraManagerCompatParamsApi21 = (CameraManagerCompatParamsApi21) this.f2781b;
            if (availabilityCallback != null) {
                synchronized (cameraManagerCompatParamsApi21.f2782a) {
                    availabilityCallbackExecutorWrapper = cameraManagerCompatParamsApi21.f2782a.get(availabilityCallback);
                    if (availabilityCallbackExecutorWrapper == null) {
                        availabilityCallbackExecutorWrapper = new CameraManagerCompat.AvailabilityCallbackExecutorWrapper(executor, availabilityCallback);
                        cameraManagerCompatParamsApi21.f2782a.put(availabilityCallback, availabilityCallbackExecutorWrapper);
                    }
                }
            }
            this.f2780a.registerAvailabilityCallback(availabilityCallbackExecutorWrapper, cameraManagerCompatParamsApi21.f2783b);
            return;
        }
        throw new IllegalArgumentException("executor was null");
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @NonNull
    public CameraCharacteristics b(@NonNull String str) throws CameraAccessExceptionCompat {
        try {
            return this.f2780a.getCameraCharacteristics(str);
        } catch (CameraAccessException e8) {
            throw CameraAccessExceptionCompat.e(e8);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void c(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        Preconditions.g(executor);
        Preconditions.g(stateCallback);
        try {
            this.f2780a.openCamera(str, new CameraDeviceCompat.StateCallbackExecutorWrapper(executor, stateCallback), ((CameraManagerCompatParamsApi21) this.f2781b).f2783b);
        } catch (CameraAccessException e8) {
            throw CameraAccessExceptionCompat.e(e8);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @NonNull
    public String[] d() throws CameraAccessExceptionCompat {
        try {
            return this.f2780a.getCameraIdList();
        } catch (CameraAccessException e8) {
            throw CameraAccessExceptionCompat.e(e8);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void e(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper;
        if (availabilityCallback != null) {
            CameraManagerCompatParamsApi21 cameraManagerCompatParamsApi21 = (CameraManagerCompatParamsApi21) this.f2781b;
            synchronized (cameraManagerCompatParamsApi21.f2782a) {
                availabilityCallbackExecutorWrapper = cameraManagerCompatParamsApi21.f2782a.remove(availabilityCallback);
            }
        } else {
            availabilityCallbackExecutorWrapper = null;
        }
        if (availabilityCallbackExecutorWrapper != null) {
            availabilityCallbackExecutorWrapper.g();
        }
        this.f2780a.unregisterAvailabilityCallback(availabilityCallbackExecutorWrapper);
    }
}
