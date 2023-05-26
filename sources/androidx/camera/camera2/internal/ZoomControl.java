package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Looper;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.ZoomState;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ZoomControl {

    /* renamed from: a  reason: collision with root package name */
    private final Camera2CameraControlImpl f2717a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f2718b;

    /* renamed from: c  reason: collision with root package name */
    private final ZoomStateImpl f2719c;

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<ZoomState> f2720d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    final ZoomImpl f2721e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2722f = false;

    /* renamed from: g  reason: collision with root package name */
    private Camera2CameraControlImpl.CaptureResultListener f2723g = new Camera2CameraControlImpl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.ZoomControl.1
        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        public boolean a(@NonNull TotalCaptureResult totalCaptureResult) {
            ZoomControl.this.f2721e.a(totalCaptureResult);
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ZoomImpl {
        void a(@NonNull TotalCaptureResult totalCaptureResult);

        void b(@NonNull Camera2ImplConfig.Builder builder);

        float c();

        void d();

        float e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoomControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull Executor executor) {
        this.f2717a = camera2CameraControlImpl;
        this.f2718b = executor;
        ZoomImpl b8 = b(cameraCharacteristicsCompat);
        this.f2721e = b8;
        ZoomStateImpl zoomStateImpl = new ZoomStateImpl(b8.e(), b8.c());
        this.f2719c = zoomStateImpl;
        zoomStateImpl.f(1.0f);
        this.f2720d = new MutableLiveData<>(ImmutableZoomState.e(zoomStateImpl));
        camera2CameraControlImpl.s(this.f2723g);
    }

    private static ZoomImpl b(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        if (e(cameraCharacteristicsCompat)) {
            return new AndroidRZoomImpl(cameraCharacteristicsCompat);
        }
        return new CropRegionZoomImpl(cameraCharacteristicsCompat);
    }

    private static Range<Float> c(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        try {
            return (Range) cameraCharacteristicsCompat.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        } catch (AssertionError e8) {
            Logger.l("ZoomControl", "AssertionError, fail to get camera characteristic.", e8);
            return null;
        }
    }

    static boolean e(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        if (Build.VERSION.SDK_INT >= 30 && c(cameraCharacteristicsCompat) != null) {
            return true;
        }
        return false;
    }

    private void g(ZoomState zoomState) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f2720d.o(zoomState);
        } else {
            this.f2720d.m(zoomState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull Camera2ImplConfig.Builder builder) {
        this.f2721e.b(builder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveData<ZoomState> d() {
        return this.f2720d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(boolean z7) {
        ZoomState e8;
        if (this.f2722f == z7) {
            return;
        }
        this.f2722f = z7;
        if (!z7) {
            synchronized (this.f2719c) {
                this.f2719c.f(1.0f);
                e8 = ImmutableZoomState.e(this.f2719c);
            }
            g(e8);
            this.f2721e.d();
            this.f2717a.g0();
        }
    }
}
