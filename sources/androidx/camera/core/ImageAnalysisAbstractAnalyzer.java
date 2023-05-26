package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.ImageReaderProxy;

/* loaded from: classes.dex */
abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f3111a;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f3113c;

    /* renamed from: d  reason: collision with root package name */
    private SafeCloseImageReaderProxy f3114d;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f3112b = 1;

    /* renamed from: e  reason: collision with root package name */
    private Rect f3115e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private Rect f3116f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private Matrix f3117g = new Matrix();

    /* renamed from: h  reason: collision with root package name */
    private Matrix f3118h = new Matrix();

    /* renamed from: i  reason: collision with root package name */
    private final Object f3119i = new Object();

    /* renamed from: j  reason: collision with root package name */
    protected boolean f3120j = true;

    ImageAnalysisAbstractAnalyzer() {
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void a(@NonNull ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy b8 = b(imageReaderProxy);
            if (b8 != null) {
                f(b8);
            }
        } catch (IllegalStateException e8) {
            Logger.d("ImageAnalysisAnalyzer", "Failed to acquire image.", e8);
        }
    }

    abstract ImageProxy b(@NonNull ImageReaderProxy imageReaderProxy);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f3120j = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f3120j = false;
        d();
    }

    abstract void f(@NonNull ImageProxy imageProxy);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(boolean z7) {
        this.f3113c = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(@NonNull SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        synchronized (this.f3119i) {
            this.f3114d = safeCloseImageReaderProxy;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i8) {
        this.f3111a = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(@NonNull Matrix matrix) {
        synchronized (this.f3119i) {
            this.f3117g = matrix;
            this.f3118h = new Matrix(this.f3117g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(@NonNull Rect rect) {
        synchronized (this.f3119i) {
            this.f3115e = rect;
            this.f3116f = new Rect(this.f3115e);
        }
    }
}
