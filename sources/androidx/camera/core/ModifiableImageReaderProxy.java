package androidx.camera.core;

import android.graphics.Matrix;
import android.media.ImageReader;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.TagBundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ModifiableImageReaderProxy extends AndroidImageReaderProxy {

    /* renamed from: d  reason: collision with root package name */
    private volatile TagBundle f3217d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Long f3218e;

    /* renamed from: f  reason: collision with root package name */
    private volatile Integer f3219f;

    /* renamed from: g  reason: collision with root package name */
    private volatile Matrix f3220g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModifiableImageReaderProxy(@NonNull ImageReader imageReader) {
        super(imageReader);
        this.f3217d = null;
        this.f3218e = null;
        this.f3219f = null;
        this.f3220g = null;
    }

    private ImageProxy l(ImageProxy imageProxy) {
        TagBundle b8;
        long d8;
        int c8;
        Matrix e8;
        ImageInfo O0 = imageProxy.O0();
        if (this.f3217d != null) {
            b8 = this.f3217d;
        } else {
            b8 = O0.b();
        }
        if (this.f3218e != null) {
            d8 = this.f3218e.longValue();
        } else {
            d8 = O0.d();
        }
        if (this.f3219f != null) {
            c8 = this.f3219f.intValue();
        } else {
            c8 = O0.c();
        }
        if (this.f3220g != null) {
            e8 = this.f3220g;
        } else {
            e8 = O0.e();
        }
        return new SettableImageProxy(imageProxy, ImmutableImageInfo.f(b8, d8, c8, e8));
    }

    @Override // androidx.camera.core.AndroidImageReaderProxy, androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy b() {
        return l(super.g());
    }

    @Override // androidx.camera.core.AndroidImageReaderProxy, androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy g() {
        return l(super.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(@NonNull TagBundle tagBundle) {
        this.f3217d = tagBundle;
    }
}
