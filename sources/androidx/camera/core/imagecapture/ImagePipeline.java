package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.CaptureBundles;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ImagePipeline {

    /* renamed from: g  reason: collision with root package name */
    static final ExifRotationAvailability f3461g = new ExifRotationAvailability();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ImageCaptureConfig f3462a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final CaptureConfig f3463b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final CaptureNode f3464c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final SingleBundlingNode f3465d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ProcessingNode f3466e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final CaptureNode.In f3467f;

    public ImagePipeline(@NonNull ImageCaptureConfig imageCaptureConfig, @NonNull Size size) {
        Threads.a();
        this.f3462a = imageCaptureConfig;
        this.f3463b = CaptureConfig.Builder.j(imageCaptureConfig).h();
        CaptureNode captureNode = new CaptureNode();
        this.f3464c = captureNode;
        SingleBundlingNode singleBundlingNode = new SingleBundlingNode();
        this.f3465d = singleBundlingNode;
        Executor N = imageCaptureConfig.N(CameraXExecutors.c());
        Objects.requireNonNull(N);
        ProcessingNode processingNode = new ProcessingNode(N);
        this.f3466e = processingNode;
        CaptureNode.In g8 = CaptureNode.In.g(size, imageCaptureConfig.getInputFormat());
        this.f3467f = g8;
        processingNode.p(singleBundlingNode.f(captureNode.i(g8)));
    }

    private CameraRequest b(@NonNull CaptureBundle captureBundle, @NonNull TakePictureRequest takePictureRequest, @NonNull TakePictureCallback takePictureCallback) {
        ArrayList arrayList = new ArrayList();
        String valueOf = String.valueOf(captureBundle.hashCode());
        List<CaptureStage> a8 = captureBundle.a();
        Objects.requireNonNull(a8);
        for (CaptureStage captureStage : a8) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.p(this.f3463b.g());
            builder.e(this.f3463b.d());
            builder.a(takePictureRequest.m());
            builder.f(this.f3467f.f());
            if (this.f3467f.c() == 256) {
                if (f3461g.a()) {
                    builder.d(CaptureConfig.f3613h, Integer.valueOf(takePictureRequest.k()));
                }
                builder.d(CaptureConfig.f3614i, Integer.valueOf(g(takePictureRequest)));
            }
            builder.e(captureStage.a().d());
            builder.g(valueOf, Integer.valueOf(captureStage.getId()));
            builder.c(this.f3467f.b());
            arrayList.add(builder.h());
        }
        return new CameraRequest(arrayList, takePictureCallback);
    }

    @NonNull
    private CaptureBundle c() {
        CaptureBundle H = this.f3462a.H(CaptureBundles.c());
        Objects.requireNonNull(H);
        return H;
    }

    @NonNull
    private ProcessingRequest d(@NonNull CaptureBundle captureBundle, @NonNull TakePictureRequest takePictureRequest, @NonNull TakePictureCallback takePictureCallback) {
        return new ProcessingRequest(captureBundle, takePictureRequest.j(), takePictureRequest.f(), takePictureRequest.k(), takePictureRequest.h(), takePictureRequest.l(), takePictureCallback);
    }

    public void a() {
        Threads.a();
        this.f3464c.g();
        this.f3465d.d();
        this.f3466e.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Pair<CameraRequest, ProcessingRequest> e(@NonNull TakePictureRequest takePictureRequest, @NonNull TakePictureCallback takePictureCallback) {
        Threads.a();
        CaptureBundle c8 = c();
        return new Pair<>(b(c8, takePictureRequest, takePictureCallback), d(c8, takePictureRequest, takePictureCallback));
    }

    @NonNull
    public SessionConfig.Builder f() {
        SessionConfig.Builder o8 = SessionConfig.Builder.o(this.f3462a);
        o8.h(this.f3467f.f());
        return o8;
    }

    int g(@NonNull TakePictureRequest takePictureRequest) {
        boolean z7;
        if (takePictureRequest.i() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        boolean e8 = TransformUtils.e(takePictureRequest.f(), this.f3467f.e());
        if (z7 && e8) {
            if (takePictureRequest.e() == 0) {
                return 100;
            }
            return 95;
        }
        return takePictureRequest.h();
    }

    public int h() {
        Threads.a();
        return this.f3464c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(@NonNull ProcessingRequest processingRequest) {
        Threads.a();
        this.f3467f.d().accept(processingRequest);
    }

    public void j(@NonNull ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        Threads.a();
        this.f3464c.h(onImageCloseListener);
    }
}
