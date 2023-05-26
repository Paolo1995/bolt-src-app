package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class ForwardingImageProxy implements ImageProxy {

    /* renamed from: g  reason: collision with root package name */
    protected final ImageProxy f3100g;

    /* renamed from: f  reason: collision with root package name */
    private final Object f3099f = new Object();

    /* renamed from: h  reason: collision with root package name */
    private final Set<OnImageCloseListener> f3101h = new HashSet();

    /* loaded from: classes.dex */
    public interface OnImageCloseListener {
        void a(@NonNull ImageProxy imageProxy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ForwardingImageProxy(@NonNull ImageProxy imageProxy) {
        this.f3100g = imageProxy;
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public ImageInfo O0() {
        return this.f3100g.O0();
    }

    @Override // androidx.camera.core.ImageProxy
    public Image V0() {
        return this.f3100g.V0();
    }

    @Override // androidx.camera.core.ImageProxy
    public void W(Rect rect) {
        this.f3100g.W(rect);
    }

    public void a(@NonNull OnImageCloseListener onImageCloseListener) {
        synchronized (this.f3099f) {
            this.f3101h.add(onImageCloseListener);
        }
    }

    protected void c() {
        HashSet<OnImageCloseListener> hashSet;
        synchronized (this.f3099f) {
            hashSet = new HashSet(this.f3101h);
        }
        for (OnImageCloseListener onImageCloseListener : hashSet) {
            onImageCloseListener.a(this);
        }
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        this.f3100g.close();
        c();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getFormat() {
        return this.f3100g.getFormat();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getHeight() {
        return this.f3100g.getHeight();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.f3100g.getWidth();
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public ImageProxy.PlaneProxy[] n0() {
        return this.f3100g.n0();
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public Rect x0() {
        return this.f3100g.x0();
    }
}
