package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.TagBundle;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class AndroidImageProxy implements ImageProxy {

    /* renamed from: f  reason: collision with root package name */
    private final Image f3022f;

    /* renamed from: g  reason: collision with root package name */
    private final PlaneProxy[] f3023g;

    /* renamed from: h  reason: collision with root package name */
    private final ImageInfo f3024h;

    /* loaded from: classes.dex */
    private static final class PlaneProxy implements ImageProxy.PlaneProxy {

        /* renamed from: a  reason: collision with root package name */
        private final Image.Plane f3025a;

        PlaneProxy(Image.Plane plane) {
            this.f3025a = plane;
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        @NonNull
        public ByteBuffer b() {
            return this.f3025a.getBuffer();
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public int c() {
            return this.f3025a.getRowStride();
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public int d() {
            return this.f3025a.getPixelStride();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidImageProxy(@NonNull Image image) {
        this.f3022f = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.f3023g = new PlaneProxy[planes.length];
            for (int i8 = 0; i8 < planes.length; i8++) {
                this.f3023g[i8] = new PlaneProxy(planes[i8]);
            }
        } else {
            this.f3023g = new PlaneProxy[0];
        }
        this.f3024h = ImmutableImageInfo.f(TagBundle.a(), image.getTimestamp(), 0, new Matrix());
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public ImageInfo O0() {
        return this.f3024h;
    }

    @Override // androidx.camera.core.ImageProxy
    public Image V0() {
        return this.f3022f;
    }

    @Override // androidx.camera.core.ImageProxy
    public void W(Rect rect) {
        this.f3022f.setCropRect(rect);
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        this.f3022f.close();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getFormat() {
        return this.f3022f.getFormat();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getHeight() {
        return this.f3022f.getHeight();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.f3022f.getWidth();
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public ImageProxy.PlaneProxy[] n0() {
        return this.f3023g;
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public Rect x0() {
        return this.f3022f.getCropRect();
    }
}
