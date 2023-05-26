package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ProcessingRequest {

    /* renamed from: a  reason: collision with root package name */
    private final ImageCapture.OutputFileOptions f3476a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Rect f3477b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3478c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3479d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f3480e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TakePictureCallback f3481f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final String f3482g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final List<Integer> f3483h = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessingRequest(@NonNull CaptureBundle captureBundle, ImageCapture.OutputFileOptions outputFileOptions, @NonNull Rect rect, int i8, int i9, @NonNull Matrix matrix, @NonNull TakePictureCallback takePictureCallback) {
        this.f3476a = outputFileOptions;
        this.f3479d = i9;
        this.f3478c = i8;
        this.f3477b = rect;
        this.f3480e = matrix;
        this.f3481f = takePictureCallback;
        this.f3482g = String.valueOf(captureBundle.hashCode());
        List<CaptureStage> a8 = captureBundle.a();
        Objects.requireNonNull(a8);
        for (CaptureStage captureStage : a8) {
            this.f3483h.add(Integer.valueOf(captureStage.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Rect a() {
        return this.f3477b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f3479d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageCapture.OutputFileOptions c() {
        return this.f3476a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f3478c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Matrix e() {
        return this.f3480e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public List<Integer> f() {
        return this.f3483h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String g() {
        return this.f3482g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f3481f.isAborted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        if (c() == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(@NonNull ImageCapture.OutputFileResults outputFileResults) {
        this.f3481f.a(outputFileResults);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(@NonNull ImageProxy imageProxy) {
        this.f3481f.c(imageProxy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        this.f3481f.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(@NonNull ImageCaptureException imageCaptureException) {
        this.f3481f.b(imageCaptureException);
    }
}
