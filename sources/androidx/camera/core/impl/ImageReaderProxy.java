package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface ImageReaderProxy {

    /* loaded from: classes.dex */
    public interface OnImageAvailableListener {
        void a(@NonNull ImageReaderProxy imageReaderProxy);
    }

    ImageProxy b();

    int c();

    void close();

    void d();

    int e();

    void f(@NonNull OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor);

    ImageProxy g();

    int getHeight();

    Surface getSurface();

    int getWidth();
}
