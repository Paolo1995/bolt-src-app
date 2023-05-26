package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.utils.Threads;
import java.util.List;

/* loaded from: classes.dex */
public final class CameraRequest {

    /* renamed from: a  reason: collision with root package name */
    private final List<CaptureConfig> f3451a;

    /* renamed from: b  reason: collision with root package name */
    private final TakePictureCallback f3452b;

    public CameraRequest(@NonNull List<CaptureConfig> list, @NonNull TakePictureCallback takePictureCallback) {
        this.f3451a = list;
        this.f3452b = takePictureCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public List<CaptureConfig> a() {
        return this.f3451a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@NonNull ImageCaptureException imageCaptureException) {
        Threads.a();
        this.f3452b.d(imageCaptureException);
    }
}
