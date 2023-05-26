package androidx.camera.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class SingleCloseImageProxy extends ForwardingImageProxy {

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f3298i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleCloseImageProxy(ImageProxy imageProxy) {
        super(imageProxy);
        this.f3298i = new AtomicBoolean(false);
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        if (!this.f3298i.getAndSet(true)) {
            super.close();
        }
    }
}
