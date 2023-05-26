package androidx.camera.core;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class SafeCloseImageReaderProxy implements ImageReaderProxy {

    /* renamed from: d  reason: collision with root package name */
    private final ImageReaderProxy f3280d;

    /* renamed from: e  reason: collision with root package name */
    private final Surface f3281e;

    /* renamed from: f  reason: collision with root package name */
    private ForwardingImageProxy.OnImageCloseListener f3282f;

    /* renamed from: a  reason: collision with root package name */
    private final Object f3277a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private int f3278b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3279c = false;

    /* renamed from: g  reason: collision with root package name */
    private final ForwardingImageProxy.OnImageCloseListener f3283g = new ForwardingImageProxy.OnImageCloseListener() { // from class: androidx.camera.core.v0
        @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
        public final void a(ImageProxy imageProxy) {
            SafeCloseImageReaderProxy.this.j(imageProxy);
        }
    };

    public SafeCloseImageReaderProxy(@NonNull ImageReaderProxy imageReaderProxy) {
        this.f3280d = imageReaderProxy;
        this.f3281e = imageReaderProxy.getSurface();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(ImageProxy imageProxy) {
        ForwardingImageProxy.OnImageCloseListener onImageCloseListener;
        synchronized (this.f3277a) {
            int i8 = this.f3278b - 1;
            this.f3278b = i8;
            if (this.f3279c && i8 == 0) {
                close();
            }
            onImageCloseListener = this.f3282f;
        }
        if (onImageCloseListener != null) {
            onImageCloseListener.a(imageProxy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, ImageReaderProxy imageReaderProxy) {
        onImageAvailableListener.a(this);
    }

    private ImageProxy n(ImageProxy imageProxy) {
        if (imageProxy != null) {
            this.f3278b++;
            SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(imageProxy);
            singleCloseImageProxy.a(this.f3283g);
            return singleCloseImageProxy;
        }
        return null;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy b() {
        ImageProxy n8;
        synchronized (this.f3277a) {
            n8 = n(this.f3280d.b());
        }
        return n8;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int c() {
        int c8;
        synchronized (this.f3277a) {
            c8 = this.f3280d.c();
        }
        return c8;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.f3277a) {
            Surface surface = this.f3281e;
            if (surface != null) {
                surface.release();
            }
            this.f3280d.close();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void d() {
        synchronized (this.f3277a) {
            this.f3280d.d();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int e() {
        int e8;
        synchronized (this.f3277a) {
            e8 = this.f3280d.e();
        }
        return e8;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void f(@NonNull final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        synchronized (this.f3277a) {
            this.f3280d.f(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.w0
                @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
                public final void a(ImageReaderProxy imageReaderProxy) {
                    SafeCloseImageReaderProxy.this.k(onImageAvailableListener, imageReaderProxy);
                }
            }, executor);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy g() {
        ImageProxy n8;
        synchronized (this.f3277a) {
            n8 = n(this.f3280d.g());
        }
        return n8;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.f3277a) {
            height = this.f3280d.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public Surface getSurface() {
        Surface surface;
        synchronized (this.f3277a) {
            surface = this.f3280d.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.f3277a) {
            width = this.f3280d.getWidth();
        }
        return width;
    }

    public int i() {
        int e8;
        synchronized (this.f3277a) {
            e8 = this.f3280d.e() - this.f3278b;
        }
        return e8;
    }

    public void l() {
        synchronized (this.f3277a) {
            this.f3279c = true;
            this.f3280d.d();
            if (this.f3278b == 0) {
                close();
            }
        }
    }

    public void m(@NonNull ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        synchronized (this.f3277a) {
            this.f3282f = onImageCloseListener;
        }
    }
}
