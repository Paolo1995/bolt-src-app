package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class SingleImageProxyBundle implements ImageProxyBundle {

    /* renamed from: a  reason: collision with root package name */
    private final int f3693a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageProxy f3694b;

    public SingleImageProxyBundle(@NonNull ImageProxy imageProxy, @NonNull String str) {
        ImageInfo O0 = imageProxy.O0();
        if (O0 != null) {
            Integer num = (Integer) O0.b().c(str);
            if (num != null) {
                this.f3693a = num.intValue();
                this.f3694b = imageProxy;
                return;
            }
            throw new IllegalArgumentException("ImageProxy has no associated tag");
        }
        throw new IllegalArgumentException("ImageProxy has no associated ImageInfo");
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public List<Integer> a() {
        return Collections.singletonList(Integer.valueOf(this.f3693a));
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public ListenableFuture<ImageProxy> b(int i8) {
        if (i8 != this.f3693a) {
            return Futures.f(new IllegalArgumentException("Capture id does not exist in the bundle"));
        }
        return Futures.h(this.f3694b);
    }

    public void c() {
        this.f3694b.close();
    }
}
