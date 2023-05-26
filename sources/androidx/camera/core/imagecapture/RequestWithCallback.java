package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.Threads;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RequestWithCallback implements TakePictureCallback {

    /* renamed from: a  reason: collision with root package name */
    private final TakePictureRequest f3484a;

    /* renamed from: c  reason: collision with root package name */
    private CallbackToFutureAdapter.Completer<Void> f3486c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3487d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3488e = false;

    /* renamed from: b  reason: collision with root package name */
    private final ListenableFuture<Void> f3485b = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.imagecapture.h
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
        public final Object a(CallbackToFutureAdapter.Completer completer) {
            Object j8;
            j8 = RequestWithCallback.this.j(completer);
            return j8;
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestWithCallback(@NonNull TakePictureRequest takePictureRequest) {
        this.f3484a = takePictureRequest;
    }

    private void h() {
        Preconditions.j(this.f3485b.isDone(), "onImageCaptured() must be called before onFinalResult()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object j(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.f3486c = completer;
        return "CaptureCompleteFuture";
    }

    private void k() {
        Preconditions.j(!this.f3487d, "The callback can only complete once.");
        this.f3487d = true;
    }

    private void l(@NonNull ImageCaptureException imageCaptureException) {
        Threads.a();
        this.f3484a.r(imageCaptureException);
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void a(@NonNull ImageCapture.OutputFileResults outputFileResults) {
        Threads.a();
        if (this.f3488e) {
            return;
        }
        h();
        k();
        this.f3484a.s(outputFileResults);
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void b(@NonNull ImageCaptureException imageCaptureException) {
        Threads.a();
        if (this.f3488e) {
            return;
        }
        h();
        k();
        l(imageCaptureException);
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void c(@NonNull ImageProxy imageProxy) {
        Threads.a();
        if (this.f3488e) {
            return;
        }
        h();
        k();
        this.f3484a.t(imageProxy);
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void d(@NonNull ImageCaptureException imageCaptureException) {
        Threads.a();
        if (this.f3488e) {
            return;
        }
        k();
        this.f3486c.c(null);
        l(imageCaptureException);
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void e() {
        Threads.a();
        if (this.f3488e) {
            return;
        }
        this.f3486c.c(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(@NonNull ImageCaptureException imageCaptureException) {
        Threads.a();
        this.f3488e = true;
        this.f3486c.c(null);
        l(imageCaptureException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ListenableFuture<Void> i() {
        Threads.a();
        return this.f3485b;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public boolean isAborted() {
        return this.f3488e;
    }
}
