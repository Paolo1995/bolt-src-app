package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* loaded from: classes.dex */
public interface ImageCaptureControl {
    @NonNull
    ListenableFuture<Void> a(@NonNull List<CaptureConfig> list);

    void b();

    void c();
}
