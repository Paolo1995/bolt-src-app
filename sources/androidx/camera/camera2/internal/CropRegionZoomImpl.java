package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CropRegionZoomImpl implements ZoomControl.ZoomImpl {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCharacteristicsCompat f2580a;

    /* renamed from: c  reason: collision with root package name */
    private CallbackToFutureAdapter.Completer<Void> f2582c;

    /* renamed from: b  reason: collision with root package name */
    private Rect f2581b = null;

    /* renamed from: d  reason: collision with root package name */
    private Rect f2583d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CropRegionZoomImpl(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.f2580a = cameraCharacteristicsCompat;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void a(@NonNull TotalCaptureResult totalCaptureResult) {
        Rect rect;
        if (this.f2582c != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            if (request == null) {
                rect = null;
            } else {
                rect = (Rect) request.get(CaptureRequest.SCALER_CROP_REGION);
            }
            Rect rect2 = this.f2583d;
            if (rect2 != null && rect2.equals(rect)) {
                this.f2582c.c(null);
                this.f2582c = null;
                this.f2583d = null;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void b(@NonNull Camera2ImplConfig.Builder builder) {
        Rect rect = this.f2581b;
        if (rect != null) {
            builder.e(CaptureRequest.SCALER_CROP_REGION, rect);
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float c() {
        return 1.0f;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void d() {
        this.f2583d = null;
        this.f2581b = null;
        CallbackToFutureAdapter.Completer<Void> completer = this.f2582c;
        if (completer != null) {
            completer.f(new CameraControl.OperationCanceledException("Camera is not active."));
            this.f2582c = null;
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float e() {
        Float f8 = (Float) this.f2580a.a(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f8 == null) {
            return 1.0f;
        }
        if (f8.floatValue() < c()) {
            return c();
        }
        return f8.floatValue();
    }
}
