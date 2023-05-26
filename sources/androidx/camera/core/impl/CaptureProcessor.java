package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public interface CaptureProcessor {
    void a(@NonNull Surface surface, int i8);

    @NonNull
    ListenableFuture<Void> b();

    void c(@NonNull Size size);

    void close();

    void d(@NonNull ImageProxyBundle imageProxyBundle);
}
