package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* loaded from: classes.dex */
public interface ImageProxyBundle {
    @NonNull
    List<Integer> a();

    @NonNull
    ListenableFuture<ImageProxy> b(int i8);
}
