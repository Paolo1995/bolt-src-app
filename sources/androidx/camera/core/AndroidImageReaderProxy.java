package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AndroidImageReaderProxy implements ImageReaderProxy {

    /* renamed from: a  reason: collision with root package name */
    private final ImageReader f3026a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f3027b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f3028c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidImageReaderProxy(ImageReader imageReader) {
        this.f3026a = imageReader;
    }

    private boolean i(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        onImageAvailableListener.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Executor executor, final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, ImageReader imageReader) {
        synchronized (this.f3027b) {
            if (!this.f3028c) {
                executor.execute(new Runnable() { // from class: androidx.camera.core.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidImageReaderProxy.this.j(onImageAvailableListener);
                    }
                });
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy b() {
        Image image;
        synchronized (this.f3027b) {
            try {
                image = this.f3026a.acquireLatestImage();
            } catch (RuntimeException e8) {
                if (i(e8)) {
                    image = null;
                } else {
                    throw e8;
                }
            }
            if (image == null) {
                return null;
            }
            return new AndroidImageProxy(image);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int c() {
        int imageFormat;
        synchronized (this.f3027b) {
            imageFormat = this.f3026a.getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.f3027b) {
            this.f3026a.close();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void d() {
        synchronized (this.f3027b) {
            this.f3028c = true;
            this.f3026a.setOnImageAvailableListener(null, null);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int e() {
        int maxImages;
        synchronized (this.f3027b) {
            maxImages = this.f3026a.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void f(@NonNull final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull final Executor executor) {
        synchronized (this.f3027b) {
            this.f3028c = false;
            this.f3026a.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: androidx.camera.core.a
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader) {
                    AndroidImageReaderProxy.this.k(executor, onImageAvailableListener, imageReader);
                }
            }, MainThreadAsyncHandler.a());
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy g() {
        Image image;
        synchronized (this.f3027b) {
            try {
                image = this.f3026a.acquireNextImage();
            } catch (RuntimeException e8) {
                if (i(e8)) {
                    image = null;
                } else {
                    throw e8;
                }
            }
            if (image == null) {
                return null;
            }
            return new AndroidImageProxy(image);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.f3027b) {
            height = this.f3026a.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public Surface getSurface() {
        Surface surface;
        synchronized (this.f3027b) {
            surface = this.f3026a.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.f3027b) {
            width = this.f3026a.getWidth();
        }
        return width;
    }
}
