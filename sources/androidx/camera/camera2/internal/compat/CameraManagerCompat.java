package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class CameraManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final CameraManagerCompatImpl f2774a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, CameraCharacteristicsCompat> f2775b = new ArrayMap(4);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class AvailabilityCallbackExecutorWrapper extends CameraManager.AvailabilityCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f2776a;

        /* renamed from: b  reason: collision with root package name */
        final CameraManager.AvailabilityCallback f2777b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f2778c = new Object();

        /* renamed from: d  reason: collision with root package name */
        private boolean f2779d = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AvailabilityCallbackExecutorWrapper(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
            this.f2776a = executor;
            this.f2777b = availabilityCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            ApiCompat$Api29Impl.a(this.f2777b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(String str) {
            this.f2777b.onCameraAvailable(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str) {
            this.f2777b.onCameraUnavailable(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void g() {
            synchronized (this.f2778c) {
                this.f2779d = true;
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAccessPrioritiesChanged() {
            synchronized (this.f2778c) {
                if (!this.f2779d) {
                    this.f2776a.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraManagerCompat.AvailabilityCallbackExecutorWrapper.this.d();
                        }
                    });
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(@NonNull final String str) {
            synchronized (this.f2778c) {
                if (!this.f2779d) {
                    this.f2776a.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.u
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraManagerCompat.AvailabilityCallbackExecutorWrapper.this.e(str);
                        }
                    });
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(@NonNull final String str) {
            synchronized (this.f2778c) {
                if (!this.f2779d) {
                    this.f2776a.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraManagerCompat.AvailabilityCallbackExecutorWrapper.this.f(str);
                        }
                    });
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface CameraManagerCompatImpl {
        void a(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback);

        @NonNull
        CameraCharacteristics b(@NonNull String str) throws CameraAccessExceptionCompat;

        void c(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat;

        @NonNull
        String[] d() throws CameraAccessExceptionCompat;

        void e(@NonNull CameraManager.AvailabilityCallback availabilityCallback);
    }

    private CameraManagerCompat(CameraManagerCompatImpl cameraManagerCompatImpl) {
        this.f2774a = cameraManagerCompatImpl;
    }

    @NonNull
    public static CameraManagerCompat a(@NonNull Context context) {
        return b(context, MainThreadAsyncHandler.a());
    }

    @NonNull
    public static CameraManagerCompat b(@NonNull Context context, @NonNull Handler handler) {
        return new CameraManagerCompat(v.a(context, handler));
    }

    @NonNull
    public CameraCharacteristicsCompat c(@NonNull String str) throws CameraAccessExceptionCompat {
        CameraCharacteristicsCompat cameraCharacteristicsCompat;
        synchronized (this.f2775b) {
            cameraCharacteristicsCompat = this.f2775b.get(str);
            if (cameraCharacteristicsCompat == null) {
                try {
                    cameraCharacteristicsCompat = CameraCharacteristicsCompat.c(this.f2774a.b(str));
                    this.f2775b.put(str, cameraCharacteristicsCompat);
                } catch (AssertionError e8) {
                    throw new CameraAccessExceptionCompat(10002, e8.getMessage(), e8);
                }
            }
        }
        return cameraCharacteristicsCompat;
    }

    @NonNull
    public String[] d() throws CameraAccessExceptionCompat {
        return this.f2774a.d();
    }

    public void e(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        this.f2774a.c(str, executor, stateCallback);
    }

    public void f(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.f2774a.a(executor, availabilityCallback);
    }

    public void g(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.f2774a.e(availabilityCallback);
    }
}
