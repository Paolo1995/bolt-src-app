package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class SettableImageProxy extends ForwardingImageProxy {

    /* renamed from: i  reason: collision with root package name */
    private final Object f3284i;

    /* renamed from: j  reason: collision with root package name */
    private final ImageInfo f3285j;

    /* renamed from: k  reason: collision with root package name */
    private Rect f3286k;

    /* renamed from: l  reason: collision with root package name */
    private final int f3287l;

    /* renamed from: m  reason: collision with root package name */
    private final int f3288m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettableImageProxy(ImageProxy imageProxy, ImageInfo imageInfo) {
        this(imageProxy, null, imageInfo);
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    @NonNull
    public ImageInfo O0() {
        return this.f3285j;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public void W(Rect rect) {
        if (rect != null) {
            Rect rect2 = new Rect(rect);
            if (!rect2.intersect(0, 0, getWidth(), getHeight())) {
                rect2.setEmpty();
            }
            rect = rect2;
        }
        synchronized (this.f3284i) {
            this.f3286k = rect;
        }
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public int getHeight() {
        return this.f3288m;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.f3287l;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    @NonNull
    public Rect x0() {
        synchronized (this.f3284i) {
            if (this.f3286k == null) {
                return new Rect(0, 0, getWidth(), getHeight());
            }
            return new Rect(this.f3286k);
        }
    }

    public SettableImageProxy(@NonNull ImageProxy imageProxy, Size size, @NonNull ImageInfo imageInfo) {
        super(imageProxy);
        this.f3284i = new Object();
        if (size == null) {
            this.f3287l = super.getWidth();
            this.f3288m = super.getHeight();
        } else {
            this.f3287l = size.getWidth();
            this.f3288m = size.getHeight();
        }
        this.f3285j = imageInfo;
    }
}
