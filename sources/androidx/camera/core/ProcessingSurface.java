package androidx.camera.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.SingleImageProxyBundle;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ProcessingSurface extends DeferrableSurface {

    /* renamed from: m  reason: collision with root package name */
    final Object f3264m;

    /* renamed from: n  reason: collision with root package name */
    private final ImageReaderProxy.OnImageAvailableListener f3265n;

    /* renamed from: o  reason: collision with root package name */
    boolean f3266o;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    private final Size f3267p;

    /* renamed from: q  reason: collision with root package name */
    private final MetadataImageReader f3268q;

    /* renamed from: r  reason: collision with root package name */
    private final Surface f3269r;

    /* renamed from: s  reason: collision with root package name */
    private final Handler f3270s;

    /* renamed from: t  reason: collision with root package name */
    final CaptureStage f3271t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    final CaptureProcessor f3272u;

    /* renamed from: v  reason: collision with root package name */
    private final CameraCaptureCallback f3273v;

    /* renamed from: w  reason: collision with root package name */
    private final DeferrableSurface f3274w;

    /* renamed from: x  reason: collision with root package name */
    private String f3275x;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessingSurface(int i8, int i9, int i10, Handler handler, @NonNull CaptureStage captureStage, @NonNull CaptureProcessor captureProcessor, @NonNull DeferrableSurface deferrableSurface, @NonNull String str) {
        super(new Size(i8, i9), i10);
        this.f3264m = new Object();
        ImageReaderProxy.OnImageAvailableListener onImageAvailableListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.s0
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void a(ImageReaderProxy imageReaderProxy) {
                ProcessingSurface.this.u(imageReaderProxy);
            }
        };
        this.f3265n = onImageAvailableListener;
        this.f3266o = false;
        Size size = new Size(i8, i9);
        this.f3267p = size;
        if (handler != null) {
            this.f3270s = handler;
        } else {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                this.f3270s = new Handler(myLooper);
            } else {
                throw new IllegalStateException("Creating a ProcessingSurface requires a non-null Handler, or be created  on a thread with a Looper.");
            }
        }
        ScheduledExecutorService e8 = CameraXExecutors.e(this.f3270s);
        MetadataImageReader metadataImageReader = new MetadataImageReader(i8, i9, i10, 2);
        this.f3268q = metadataImageReader;
        metadataImageReader.f(onImageAvailableListener, e8);
        this.f3269r = metadataImageReader.getSurface();
        this.f3273v = metadataImageReader.m();
        this.f3272u = captureProcessor;
        captureProcessor.c(size);
        this.f3271t = captureStage;
        this.f3274w = deferrableSurface;
        this.f3275x = str;
        Futures.b(deferrableSurface.h(), new FutureCallback<Surface>() { // from class: androidx.camera.core.ProcessingSurface.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(Surface surface) {
                synchronized (ProcessingSurface.this.f3264m) {
                    ProcessingSurface.this.f3272u.a(surface, 1);
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                Logger.d("ProcessingSurfaceTextur", "Failed to extract Listenable<Surface>.", th);
            }
        }, CameraXExecutors.a());
        i().f(new Runnable() { // from class: androidx.camera.core.t0
            @Override // java.lang.Runnable
            public final void run() {
                ProcessingSurface.this.w();
            }
        }, CameraXExecutors.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(ImageReaderProxy imageReaderProxy) {
        synchronized (this.f3264m) {
            t(imageReaderProxy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Surface v(Surface surface) {
        return this.f3269r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        synchronized (this.f3264m) {
            if (this.f3266o) {
                return;
            }
            this.f3268q.d();
            this.f3268q.close();
            this.f3269r.release();
            this.f3274w.c();
            this.f3266o = true;
        }
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    @NonNull
    public ListenableFuture<Surface> n() {
        return FutureChain.a(this.f3274w.h()).d(new Function() { // from class: androidx.camera.core.u0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Surface v7;
                v7 = ProcessingSurface.this.v((Surface) obj);
                return v7;
            }
        }, CameraXExecutors.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraCaptureCallback s() {
        CameraCaptureCallback cameraCaptureCallback;
        synchronized (this.f3264m) {
            if (!this.f3266o) {
                cameraCaptureCallback = this.f3273v;
            } else {
                throw new IllegalStateException("ProcessingSurface already released!");
            }
        }
        return cameraCaptureCallback;
    }

    void t(ImageReaderProxy imageReaderProxy) {
        if (this.f3266o) {
            return;
        }
        ImageProxy imageProxy = null;
        try {
            imageProxy = imageReaderProxy.g();
        } catch (IllegalStateException e8) {
            Logger.d("ProcessingSurfaceTextur", "Failed to acquire next image.", e8);
        }
        if (imageProxy == null) {
            return;
        }
        ImageInfo O0 = imageProxy.O0();
        if (O0 == null) {
            imageProxy.close();
            return;
        }
        Integer num = (Integer) O0.b().c(this.f3275x);
        if (num == null) {
            imageProxy.close();
        } else if (this.f3271t.getId() != num.intValue()) {
            Logger.k("ProcessingSurfaceTextur", "ImageProxyBundle does not contain this id: " + num);
            imageProxy.close();
        } else {
            SingleImageProxyBundle singleImageProxyBundle = new SingleImageProxyBundle(imageProxy, this.f3275x);
            try {
                j();
                this.f3272u.d(singleImageProxyBundle);
                singleImageProxyBundle.c();
                d();
            } catch (DeferrableSurface.SurfaceClosedException unused) {
                Logger.a("ProcessingSurfaceTextur", "The ProcessingSurface has been closed. Don't process the incoming image.");
                singleImageProxyBundle.c();
            }
        }
    }
}
