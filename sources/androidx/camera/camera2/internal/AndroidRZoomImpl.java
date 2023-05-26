package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AndroidRZoomImpl implements ZoomControl.ZoomImpl {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCharacteristicsCompat f2373a;

    /* renamed from: b  reason: collision with root package name */
    private final Range<Float> f2374b;

    /* renamed from: d  reason: collision with root package name */
    private CallbackToFutureAdapter.Completer<Void> f2376d;

    /* renamed from: c  reason: collision with root package name */
    private float f2375c = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f2377e = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidRZoomImpl(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.f2373a = cameraCharacteristicsCompat;
        this.f2374b = (Range) cameraCharacteristicsCompat.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void a(@NonNull TotalCaptureResult totalCaptureResult) {
        Float f8;
        if (this.f2376d != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            if (request == null) {
                f8 = null;
            } else {
                f8 = (Float) request.get(CaptureRequest.CONTROL_ZOOM_RATIO);
            }
            if (f8 == null) {
                return;
            }
            if (this.f2377e == f8.floatValue()) {
                this.f2376d.c(null);
                this.f2376d = null;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void b(@NonNull Camera2ImplConfig.Builder builder) {
        builder.e(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(this.f2375c));
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float c() {
        return this.f2374b.getLower().floatValue();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void d() {
        this.f2375c = 1.0f;
        CallbackToFutureAdapter.Completer<Void> completer = this.f2376d;
        if (completer != null) {
            completer.f(new CameraControl.OperationCanceledException("Camera is not active."));
            this.f2376d = null;
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float e() {
        return this.f2374b.getUpper().floatValue();
    }
}
