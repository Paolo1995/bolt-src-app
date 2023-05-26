package androidx.camera.core.imagecapture;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/* loaded from: classes.dex */
public class TakePictureManager implements ForwardingImageProxy.OnImageCloseListener {

    /* renamed from: b  reason: collision with root package name */
    final ImagePipeline f3492b;

    /* renamed from: c  reason: collision with root package name */
    final ImageCaptureControl f3493c;

    /* renamed from: d  reason: collision with root package name */
    RequestWithCallback f3494d;

    /* renamed from: a  reason: collision with root package name */
    final Deque<TakePictureRequest> f3491a = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    boolean f3495e = false;

    public TakePictureManager(@NonNull ImageCaptureControl imageCaptureControl, @NonNull ImagePipeline imagePipeline) {
        Threads.a();
        this.f3493c = imageCaptureControl;
        this.f3492b = imagePipeline;
        imagePipeline.j(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(ProcessingRequest processingRequest) {
        this.f3492b.i(processingRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.f3494d = null;
        f();
    }

    private void l(@NonNull final CameraRequest cameraRequest, @NonNull final Runnable runnable) {
        Threads.a();
        this.f3493c.b();
        Futures.b(this.f3493c.a(cameraRequest.a()), new FutureCallback<Void>() { // from class: androidx.camera.core.imagecapture.TakePictureManager.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(Void r12) {
                runnable.run();
                TakePictureManager.this.f3493c.c();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                if (th instanceof ImageCaptureException) {
                    cameraRequest.b((ImageCaptureException) th);
                } else {
                    cameraRequest.b(new ImageCaptureException(2, "Failed to submit capture request", th));
                }
                TakePictureManager.this.f3493c.c();
            }
        }, CameraXExecutors.d());
    }

    private void m(@NonNull RequestWithCallback requestWithCallback) {
        Preconditions.i(!e());
        this.f3494d = requestWithCallback;
        requestWithCallback.i().f(new Runnable() { // from class: androidx.camera.core.imagecapture.m
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureManager.this.h();
            }
        }, CameraXExecutors.a());
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public void a(@NonNull ImageProxy imageProxy) {
        CameraXExecutors.d().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.l
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureManager.this.f();
            }
        });
    }

    public void d() {
        Threads.a();
        ImageCaptureException imageCaptureException = new ImageCaptureException(3, "Camera is closed.", null);
        for (TakePictureRequest takePictureRequest : this.f3491a) {
            takePictureRequest.r(imageCaptureException);
        }
        this.f3491a.clear();
        RequestWithCallback requestWithCallback = this.f3494d;
        if (requestWithCallback != null) {
            requestWithCallback.g(imageCaptureException);
        }
    }

    boolean e() {
        if (this.f3494d != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        Threads.a();
        Log.d("TakePictureManager", "Issue the next TakePictureRequest.");
        if (e()) {
            Log.d("TakePictureManager", "There is already a request in-flight.");
        } else if (this.f3495e) {
            Log.d("TakePictureManager", "The class is paused.");
        } else if (this.f3492b.h() == 0) {
            Log.d("TakePictureManager", "Too many acquire images. Close image to be able to process next.");
        } else {
            TakePictureRequest poll = this.f3491a.poll();
            if (poll == null) {
                Log.d("TakePictureManager", "No new request.");
                return;
            }
            RequestWithCallback requestWithCallback = new RequestWithCallback(poll);
            m(requestWithCallback);
            Pair<CameraRequest, ProcessingRequest> e8 = this.f3492b.e(poll, requestWithCallback);
            CameraRequest cameraRequest = e8.f5908a;
            Objects.requireNonNull(cameraRequest);
            final ProcessingRequest processingRequest = e8.f5909b;
            Objects.requireNonNull(processingRequest);
            l(cameraRequest, new Runnable() { // from class: androidx.camera.core.imagecapture.k
                @Override // java.lang.Runnable
                public final void run() {
                    TakePictureManager.this.g(processingRequest);
                }
            });
        }
    }

    public void i(@NonNull TakePictureRequest takePictureRequest) {
        Threads.a();
        this.f3491a.offer(takePictureRequest);
        f();
    }

    public void j() {
        Threads.a();
        this.f3495e = true;
    }

    public void k() {
        Threads.a();
        this.f3495e = false;
        f();
    }
}
