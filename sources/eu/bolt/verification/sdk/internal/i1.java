package eu.bolt.verification.sdk.internal;

import android.net.Uri;
import android.util.Size;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import com.google.common.util.concurrent.ListenableFuture;
import eu.bolt.verification.sdk.internal.ac;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class i1 {

    /* renamed from: g */
    private static final a f43433g = new a(null);

    /* renamed from: a */
    private final AppCompatActivity f43434a;

    /* renamed from: b */
    private final PreviewView f43435b;

    /* renamed from: c */
    private final xg f43436c;

    /* renamed from: d */
    private Camera f43437d;

    /* renamed from: e */
    private ProcessCameraProvider f43438e;

    /* renamed from: f */
    private ImageCapture f43439f;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
    }

    /* loaded from: classes5.dex */
    public static final class c implements ImageCapture.OnImageSavedCallback {

        /* renamed from: a */
        final /* synthetic */ i1 f43440a;

        /* renamed from: b */
        final /* synthetic */ File f43441b;

        /* renamed from: c */
        final /* synthetic */ SingleEmitter<Uri> f43442c;

        c(b bVar, i1 i1Var, File file, SingleEmitter<Uri> singleEmitter) {
            this.f43440a = i1Var;
            this.f43441b = file;
            this.f43442c = singleEmitter;
        }

        @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
        public void a(ImageCapture.OutputFileResults output) {
            Intrinsics.f(output, "output");
            this.f43442c.onSuccess(Uri.fromFile(this.f43441b));
        }

        @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
        public void b(ImageCaptureException e8) {
            Intrinsics.f(e8, "e");
            this.f43442c.onError(e8);
        }
    }

    @Inject
    public i1(AppCompatActivity activity, PreviewView previewView, xg rxSchedulers) {
        Intrinsics.f(activity, "activity");
        Intrinsics.f(previewView, "previewView");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        this.f43434a = activity;
        this.f43435b = previewView;
        this.f43436c = rxSchedulers;
    }

    public static /* synthetic */ Single c(i1 i1Var, File file, b bVar, long j8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            bVar = null;
        }
        if ((i8 & 4) != 0) {
            j8 = 3000;
        }
        return i1Var.d(file, bVar, j8);
    }

    private final Runnable e(final ListenableFuture<ProcessCameraProvider> listenableFuture, final CameraSelector cameraSelector, final Size size, final Integer num) {
        return new Runnable() { // from class: eu.bolt.verification.sdk.internal.zs
            @Override // java.lang.Runnable
            public final void run() {
                i1.i(i1.this, listenableFuture, num, size, cameraSelector);
            }
        };
    }

    public static final void h(ImageCapture imageCapture, ImageCapture.OutputFileOptions outputOptions, i1 this$0, b bVar, File file, SingleEmitter emitter) {
        Intrinsics.f(imageCapture, "$imageCapture");
        Intrinsics.f(outputOptions, "$outputOptions");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(file, "$file");
        Intrinsics.f(emitter, "emitter");
        imageCapture.z0(outputOptions, ContextCompat.getMainExecutor(this$0.f43434a), new c(bVar, this$0, file, emitter));
    }

    public static final void i(i1 this$0, ListenableFuture cameraProviderFuture, Integer num, Size size, CameraSelector cameraSelector) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(cameraProviderFuture, "$cameraProviderFuture");
        Intrinsics.f(cameraSelector, "$cameraSelector");
        try {
            this$0.f43438e = (ProcessCameraProvider) cameraProviderFuture.get();
            Preview c8 = new Preview.Builder().c();
            c8.X(this$0.f43435b.getSurfaceProvider());
            Intrinsics.e(c8, "Builder()\n              …ovider)\n                }");
            ImageCapture.Builder f8 = new ImageCapture.Builder().f(num != null ? num.intValue() : 70);
            if (size == null) {
                size = new Size(1000, 1000);
            }
            this$0.f43439f = f8.k(size).c();
            ProcessCameraProvider processCameraProvider = this$0.f43438e;
            if (processCameraProvider != null) {
                processCameraProvider.m();
            }
            ProcessCameraProvider processCameraProvider2 = this$0.f43438e;
            this$0.f43437d = processCameraProvider2 != null ? processCameraProvider2.e(this$0.f43434a, cameraSelector, c8, this$0.f43439f) : null;
        } catch (Exception e8) {
            ac.a.f42020b.d().c(e8);
        }
    }

    public final Single<Uri> d(File file, b bVar, long j8) {
        Single<Uri> M;
        String str;
        Intrinsics.f(file, "file");
        ImageCapture imageCapture = this.f43439f;
        if (imageCapture == null) {
            M = Single.error(new IllegalStateException("Image capture use case not bound"));
            str = "error(IllegalStateExcept…ure use case not bound\"))";
        } else {
            ImageCapture.OutputFileOptions a8 = new ImageCapture.OutputFileOptions.Builder(file).a();
            Intrinsics.e(a8, "Builder(file)\n            .build()");
            M = Single.f(new SingleOnSubscribe(a8, this, bVar, file) { // from class: eu.bolt.verification.sdk.internal.ys

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ImageCapture.OutputFileOptions f45787b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ i1 f45788c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ File f45789d;

                {
                    this.f45789d = file;
                }

                @Override // io.reactivex.SingleOnSubscribe
                public final void a(SingleEmitter singleEmitter) {
                    i1.h(ImageCapture.this, this.f45787b, this.f45788c, null, this.f45789d, singleEmitter);
                }
            }).M(j8, TimeUnit.MILLISECONDS, this.f43436c.a());
            str = "create { emitter ->\n    …rxSchedulers.computation)";
        }
        Intrinsics.e(M, str);
        return M;
    }

    public final void f() {
        ProcessCameraProvider processCameraProvider = this.f43438e;
        if (processCameraProvider != null) {
            processCameraProvider.m();
        }
        this.f43438e = null;
    }

    public final void g(CameraSelector cameraSelector, Size size, Integer num) {
        Intrinsics.f(cameraSelector, "cameraSelector");
        if (this.f43438e == null) {
            Executor mainExecutor = ContextCompat.getMainExecutor(this.f43434a);
            Intrinsics.e(mainExecutor, "getMainExecutor(activity)");
            ListenableFuture<ProcessCameraProvider> f8 = ProcessCameraProvider.f(this.f43434a);
            Intrinsics.e(f8, "this");
            f8.f(e(f8, cameraSelector, size, num), mainExecutor);
        }
    }

    public final void j(boolean z7) {
        CameraControl b8;
        Camera camera = this.f43437d;
        if (camera == null || (b8 = camera.b()) == null) {
            return;
        }
        b8.e(z7);
    }
}
