package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_TakePictureRequest extends TakePictureRequest {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3441a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageCapture.OnImageCapturedCallback f3442b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageCapture.OnImageSavedCallback f3443c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageCapture.OutputFileOptions f3444d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f3445e;

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f3446f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3447g;

    /* renamed from: h  reason: collision with root package name */
    private final int f3448h;

    /* renamed from: i  reason: collision with root package name */
    private final int f3449i;

    /* renamed from: j  reason: collision with root package name */
    private final List<CameraCaptureCallback> f3450j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_TakePictureRequest(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback, ImageCapture.OnImageSavedCallback onImageSavedCallback, ImageCapture.OutputFileOptions outputFileOptions, Rect rect, Matrix matrix, int i8, int i9, int i10, List<CameraCaptureCallback> list) {
        if (executor != null) {
            this.f3441a = executor;
            this.f3442b = onImageCapturedCallback;
            this.f3443c = onImageSavedCallback;
            this.f3444d = outputFileOptions;
            if (rect != null) {
                this.f3445e = rect;
                if (matrix != null) {
                    this.f3446f = matrix;
                    this.f3447g = i8;
                    this.f3448h = i9;
                    this.f3449i = i10;
                    if (list != null) {
                        this.f3450j = list;
                        return;
                    }
                    throw new NullPointerException("Null sessionConfigCameraCaptureCallbacks");
                }
                throw new NullPointerException("Null sensorToBufferTransform");
            }
            throw new NullPointerException("Null cropRect");
        }
        throw new NullPointerException("Null appExecutor");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @NonNull
    public Executor d() {
        return this.f3441a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public int e() {
        return this.f3449i;
    }

    public boolean equals(Object obj) {
        ImageCapture.OnImageCapturedCallback onImageCapturedCallback;
        ImageCapture.OnImageSavedCallback onImageSavedCallback;
        ImageCapture.OutputFileOptions outputFileOptions;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TakePictureRequest)) {
            return false;
        }
        TakePictureRequest takePictureRequest = (TakePictureRequest) obj;
        if (this.f3441a.equals(takePictureRequest.d()) && ((onImageCapturedCallback = this.f3442b) != null ? onImageCapturedCallback.equals(takePictureRequest.g()) : takePictureRequest.g() == null) && ((onImageSavedCallback = this.f3443c) != null ? onImageSavedCallback.equals(takePictureRequest.i()) : takePictureRequest.i() == null) && ((outputFileOptions = this.f3444d) != null ? outputFileOptions.equals(takePictureRequest.j()) : takePictureRequest.j() == null) && this.f3445e.equals(takePictureRequest.f()) && this.f3446f.equals(takePictureRequest.l()) && this.f3447g == takePictureRequest.k() && this.f3448h == takePictureRequest.h() && this.f3449i == takePictureRequest.e() && this.f3450j.equals(takePictureRequest.m())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @NonNull
    public Rect f() {
        return this.f3445e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OnImageCapturedCallback g() {
        return this.f3442b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public int h() {
        return this.f3448h;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = (this.f3441a.hashCode() ^ 1000003) * 1000003;
        ImageCapture.OnImageCapturedCallback onImageCapturedCallback = this.f3442b;
        int i8 = 0;
        if (onImageCapturedCallback == null) {
            hashCode = 0;
        } else {
            hashCode = onImageCapturedCallback.hashCode();
        }
        int i9 = (hashCode3 ^ hashCode) * 1000003;
        ImageCapture.OnImageSavedCallback onImageSavedCallback = this.f3443c;
        if (onImageSavedCallback == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = onImageSavedCallback.hashCode();
        }
        int i10 = (i9 ^ hashCode2) * 1000003;
        ImageCapture.OutputFileOptions outputFileOptions = this.f3444d;
        if (outputFileOptions != null) {
            i8 = outputFileOptions.hashCode();
        }
        return ((((((((((((i10 ^ i8) * 1000003) ^ this.f3445e.hashCode()) * 1000003) ^ this.f3446f.hashCode()) * 1000003) ^ this.f3447g) * 1000003) ^ this.f3448h) * 1000003) ^ this.f3449i) * 1000003) ^ this.f3450j.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OnImageSavedCallback i() {
        return this.f3443c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OutputFileOptions j() {
        return this.f3444d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public int k() {
        return this.f3447g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @NonNull
    public Matrix l() {
        return this.f3446f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @NonNull
    public List<CameraCaptureCallback> m() {
        return this.f3450j;
    }

    public String toString() {
        return "TakePictureRequest{appExecutor=" + this.f3441a + ", inMemoryCallback=" + this.f3442b + ", onDiskCallback=" + this.f3443c + ", outputFileOptions=" + this.f3444d + ", cropRect=" + this.f3445e + ", sensorToBufferTransform=" + this.f3446f + ", rotationDegrees=" + this.f3447g + ", jpegQuality=" + this.f3448h + ", captureMode=" + this.f3449i + ", sessionConfigCameraCaptureCallbacks=" + this.f3450j + "}";
    }
}
