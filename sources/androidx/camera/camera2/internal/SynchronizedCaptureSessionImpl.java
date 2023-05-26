package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseDeferrableSurface;
import androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SynchronizedCaptureSessionImpl extends SynchronizedCaptureSessionBaseImpl {

    /* renamed from: o  reason: collision with root package name */
    private final Object f2694o;

    /* renamed from: p  reason: collision with root package name */
    private List<DeferrableSurface> f2695p;

    /* renamed from: q  reason: collision with root package name */
    ListenableFuture<Void> f2696q;

    /* renamed from: r  reason: collision with root package name */
    private final ForceCloseDeferrableSurface f2697r;

    /* renamed from: s  reason: collision with root package name */
    private final WaitForRepeatingRequestStart f2698s;

    /* renamed from: t  reason: collision with root package name */
    private final ForceCloseCaptureSession f2699t;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SynchronizedCaptureSessionImpl(@NonNull Quirks quirks, @NonNull Quirks quirks2, @NonNull CaptureSessionRepository captureSessionRepository, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Handler handler) {
        super(captureSessionRepository, executor, scheduledExecutorService, handler);
        this.f2694o = new Object();
        this.f2697r = new ForceCloseDeferrableSurface(quirks, quirks2);
        this.f2698s = new WaitForRepeatingRequestStart(quirks);
        this.f2699t = new ForceCloseCaptureSession(quirks2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        M("Session call super.close()");
        super.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(SynchronizedCaptureSession synchronizedCaptureSession) {
        super.q(synchronizedCaptureSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ListenableFuture P(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) {
        return super.a(cameraDevice, sessionConfigurationCompat, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int Q(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return super.f(captureRequest, captureCallback);
    }

    void M(String str) {
        Logger.a("SyncCaptureSessionImpl", "[" + this + "] " + str);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public ListenableFuture<Void> a(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat, @NonNull List<DeferrableSurface> list) {
        ListenableFuture<Void> j8;
        synchronized (this.f2694o) {
            ListenableFuture<Void> g8 = this.f2698s.g(cameraDevice, sessionConfigurationCompat, list, this.f2679b.e(), new WaitForRepeatingRequestStart.OpenCaptureSession() { // from class: androidx.camera.camera2.internal.h1
                @Override // androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart.OpenCaptureSession
                public final ListenableFuture a(CameraDevice cameraDevice2, SessionConfigurationCompat sessionConfigurationCompat2, List list2) {
                    ListenableFuture P;
                    P = SynchronizedCaptureSessionImpl.this.P(cameraDevice2, sessionConfigurationCompat2, list2);
                    return P;
                }
            });
            this.f2696q = g8;
            j8 = Futures.j(g8);
        }
        return j8;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void close() {
        M("Session call close()");
        this.f2698s.f();
        this.f2698s.c().f(new Runnable() { // from class: androidx.camera.camera2.internal.g1
            @Override // java.lang.Runnable
            public final void run() {
                SynchronizedCaptureSessionImpl.this.N();
            }
        }, getExecutor());
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int f(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f2698s.h(captureRequest, captureCallback, new WaitForRepeatingRequestStart.SingleRepeatingRequest() { // from class: androidx.camera.camera2.internal.f1
            @Override // androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart.SingleRepeatingRequest
            public final int a(CaptureRequest captureRequest2, CameraCaptureSession.CaptureCallback captureCallback2) {
                int Q;
                Q = SynchronizedCaptureSessionImpl.this.Q(captureRequest2, captureCallback2);
                return Q;
            }
        });
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public ListenableFuture<List<Surface>> h(@NonNull List<DeferrableSurface> list, long j8) {
        ListenableFuture<List<Surface>> h8;
        synchronized (this.f2694o) {
            this.f2695p = list;
            h8 = super.h(list, j8);
        }
        return h8;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    @NonNull
    public ListenableFuture<Void> l() {
        return this.f2698s.c();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void o(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.f2694o) {
            this.f2697r.a(this.f2695p);
        }
        M("onClosed()");
        super.o(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void q(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        M("Session onConfigured()");
        this.f2699t.c(synchronizedCaptureSession, this.f2679b.f(), this.f2679b.d(), new ForceCloseCaptureSession.OnConfigured() { // from class: androidx.camera.camera2.internal.i1
            @Override // androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession.OnConfigured
            public final void a(SynchronizedCaptureSession synchronizedCaptureSession2) {
                SynchronizedCaptureSessionImpl.this.O(synchronizedCaptureSession2);
            }
        });
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    public boolean stop() {
        boolean stop;
        synchronized (this.f2694o) {
            if (B()) {
                this.f2697r.a(this.f2695p);
            } else {
                ListenableFuture<Void> listenableFuture = this.f2696q;
                if (listenableFuture != null) {
                    listenableFuture.cancel(true);
                }
            }
            stop = super.stop();
        }
        return stop;
    }
}
