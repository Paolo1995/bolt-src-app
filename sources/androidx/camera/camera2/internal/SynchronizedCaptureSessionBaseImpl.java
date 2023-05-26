package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SynchronizedCaptureSessionBaseImpl extends SynchronizedCaptureSession.StateCallback implements SynchronizedCaptureSession, SynchronizedCaptureSessionOpener.OpenerImpl {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final CaptureSessionRepository f2679b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final Handler f2680c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final Executor f2681d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ScheduledExecutorService f2682e;

    /* renamed from: f  reason: collision with root package name */
    SynchronizedCaptureSession.StateCallback f2683f;

    /* renamed from: g  reason: collision with root package name */
    CameraCaptureSessionCompat f2684g;

    /* renamed from: h  reason: collision with root package name */
    ListenableFuture<Void> f2685h;

    /* renamed from: i  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Void> f2686i;

    /* renamed from: j  reason: collision with root package name */
    private ListenableFuture<List<Surface>> f2687j;

    /* renamed from: a  reason: collision with root package name */
    final Object f2678a = new Object();

    /* renamed from: k  reason: collision with root package name */
    private List<DeferrableSurface> f2688k = null;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2689l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2690m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2691n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SynchronizedCaptureSessionBaseImpl(@NonNull CaptureSessionRepository captureSessionRepository, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Handler handler) {
        this.f2679b = captureSessionRepository;
        this.f2680c = handler;
        this.f2681d = executor;
        this.f2682e = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        s(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.f2679b.h(this);
        s(synchronizedCaptureSession);
        Objects.requireNonNull(this.f2683f);
        this.f2683f.o(synchronizedCaptureSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f2683f);
        this.f2683f.s(synchronizedCaptureSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object F(List list, CameraDeviceCompat cameraDeviceCompat, SessionConfigurationCompat sessionConfigurationCompat, CallbackToFutureAdapter.Completer completer) throws Exception {
        boolean z7;
        String str;
        synchronized (this.f2678a) {
            A(list);
            if (this.f2686i == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.j(z7, "The openCaptureSessionCompleter can only set once!");
            this.f2686i = completer;
            cameraDeviceCompat.a(sessionConfigurationCompat);
            str = "openCaptureSession[session=" + this + "]";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ListenableFuture G(List list, List list2) throws Exception {
        Logger.a("SyncCaptureSessionBase", "[" + this + "] getSurface...done");
        if (list2.contains(null)) {
            return Futures.f(new DeferrableSurface.SurfaceClosedException("Surface closed", (DeferrableSurface) list.get(list2.indexOf(null))));
        }
        if (list2.isEmpty()) {
            return Futures.f(new IllegalArgumentException("Unable to open capture session without surfaces"));
        }
        return Futures.h(list2);
    }

    void A(@NonNull List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        synchronized (this.f2678a) {
            H();
            DeferrableSurfaces.f(list);
            this.f2688k = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        boolean z7;
        synchronized (this.f2678a) {
            if (this.f2685h != null) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    void H() {
        synchronized (this.f2678a) {
            List<DeferrableSurface> list = this.f2688k;
            if (list != null) {
                DeferrableSurfaces.e(list);
                this.f2688k = null;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public ListenableFuture<Void> a(@NonNull CameraDevice cameraDevice, @NonNull final SessionConfigurationCompat sessionConfigurationCompat, @NonNull final List<DeferrableSurface> list) {
        synchronized (this.f2678a) {
            if (this.f2690m) {
                return Futures.f(new CancellationException("Opener is disabled"));
            }
            this.f2679b.l(this);
            final CameraDeviceCompat b8 = CameraDeviceCompat.b(cameraDevice, this.f2680c);
            ListenableFuture<Void> a8 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.b1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object a(CallbackToFutureAdapter.Completer completer) {
                    Object F;
                    F = SynchronizedCaptureSessionBaseImpl.this.F(list, b8, sessionConfigurationCompat, completer);
                    return F;
                }
            });
            this.f2685h = a8;
            Futures.b(a8, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                /* renamed from: a */
                public void onSuccess(Void r12) {
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(@NonNull Throwable th) {
                    SynchronizedCaptureSessionBaseImpl.this.c();
                    SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                    synchronizedCaptureSessionBaseImpl.f2679b.j(synchronizedCaptureSessionBaseImpl);
                }
            }, CameraXExecutors.a());
            return Futures.j(this.f2685h);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    @NonNull
    public SynchronizedCaptureSession.StateCallback b() {
        return this;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void c() {
        H();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void close() {
        Preconditions.h(this.f2684g, "Need to call openCaptureSession before using this API.");
        this.f2679b.i(this);
        this.f2684g.c().close();
        getExecutor().execute(new Runnable() { // from class: androidx.camera.camera2.internal.d1
            @Override // java.lang.Runnable
            public final void run() {
                SynchronizedCaptureSessionBaseImpl.this.C();
            }
        });
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void d() throws CameraAccessException {
        Preconditions.h(this.f2684g, "Need to call openCaptureSession before using this API.");
        this.f2684g.c().abortCaptures();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    @NonNull
    public CameraDevice e() {
        Preconditions.g(this.f2684g);
        return this.f2684g.c().getDevice();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int f(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.h(this.f2684g, "Need to call openCaptureSession before using this API.");
        return this.f2684g.b(captureRequest, getExecutor(), captureCallback);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public SessionConfigurationCompat g(int i8, @NonNull List<OutputConfigurationCompat> list, @NonNull SynchronizedCaptureSession.StateCallback stateCallback) {
        this.f2683f = stateCallback;
        return new SessionConfigurationCompat(i8, list, getExecutor(), new CameraCaptureSession.StateCallback() { // from class: androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl.2
            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onActive(@NonNull CameraCaptureSession cameraCaptureSession) {
                SynchronizedCaptureSessionBaseImpl.this.z(cameraCaptureSession);
                SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                synchronizedCaptureSessionBaseImpl.m(synchronizedCaptureSessionBaseImpl);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onCaptureQueueEmpty(@NonNull CameraCaptureSession cameraCaptureSession) {
                SynchronizedCaptureSessionBaseImpl.this.z(cameraCaptureSession);
                SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                synchronizedCaptureSessionBaseImpl.n(synchronizedCaptureSessionBaseImpl);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
                SynchronizedCaptureSessionBaseImpl.this.z(cameraCaptureSession);
                SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                synchronizedCaptureSessionBaseImpl.o(synchronizedCaptureSessionBaseImpl);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
                CallbackToFutureAdapter.Completer<Void> completer;
                try {
                    SynchronizedCaptureSessionBaseImpl.this.z(cameraCaptureSession);
                    SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                    synchronizedCaptureSessionBaseImpl.p(synchronizedCaptureSessionBaseImpl);
                    synchronized (SynchronizedCaptureSessionBaseImpl.this.f2678a) {
                        Preconditions.h(SynchronizedCaptureSessionBaseImpl.this.f2686i, "OpenCaptureSession completer should not null");
                        SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl2 = SynchronizedCaptureSessionBaseImpl.this;
                        completer = synchronizedCaptureSessionBaseImpl2.f2686i;
                        synchronizedCaptureSessionBaseImpl2.f2686i = null;
                    }
                    completer.f(new IllegalStateException("onConfigureFailed"));
                } catch (Throwable th) {
                    synchronized (SynchronizedCaptureSessionBaseImpl.this.f2678a) {
                        Preconditions.h(SynchronizedCaptureSessionBaseImpl.this.f2686i, "OpenCaptureSession completer should not null");
                        SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl3 = SynchronizedCaptureSessionBaseImpl.this;
                        CallbackToFutureAdapter.Completer<Void> completer2 = synchronizedCaptureSessionBaseImpl3.f2686i;
                        synchronizedCaptureSessionBaseImpl3.f2686i = null;
                        completer2.f(new IllegalStateException("onConfigureFailed"));
                        throw th;
                    }
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                CallbackToFutureAdapter.Completer<Void> completer;
                try {
                    SynchronizedCaptureSessionBaseImpl.this.z(cameraCaptureSession);
                    SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                    synchronizedCaptureSessionBaseImpl.q(synchronizedCaptureSessionBaseImpl);
                    synchronized (SynchronizedCaptureSessionBaseImpl.this.f2678a) {
                        Preconditions.h(SynchronizedCaptureSessionBaseImpl.this.f2686i, "OpenCaptureSession completer should not null");
                        SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl2 = SynchronizedCaptureSessionBaseImpl.this;
                        completer = synchronizedCaptureSessionBaseImpl2.f2686i;
                        synchronizedCaptureSessionBaseImpl2.f2686i = null;
                    }
                    completer.c(null);
                } catch (Throwable th) {
                    synchronized (SynchronizedCaptureSessionBaseImpl.this.f2678a) {
                        Preconditions.h(SynchronizedCaptureSessionBaseImpl.this.f2686i, "OpenCaptureSession completer should not null");
                        SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl3 = SynchronizedCaptureSessionBaseImpl.this;
                        CallbackToFutureAdapter.Completer<Void> completer2 = synchronizedCaptureSessionBaseImpl3.f2686i;
                        synchronizedCaptureSessionBaseImpl3.f2686i = null;
                        completer2.c(null);
                        throw th;
                    }
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
                SynchronizedCaptureSessionBaseImpl.this.z(cameraCaptureSession);
                SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                synchronizedCaptureSessionBaseImpl.r(synchronizedCaptureSessionBaseImpl);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onSurfacePrepared(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
                SynchronizedCaptureSessionBaseImpl.this.z(cameraCaptureSession);
                SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                synchronizedCaptureSessionBaseImpl.t(synchronizedCaptureSessionBaseImpl, surface);
            }
        });
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public Executor getExecutor() {
        return this.f2681d;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public ListenableFuture<List<Surface>> h(@NonNull final List<DeferrableSurface> list, long j8) {
        synchronized (this.f2678a) {
            if (this.f2690m) {
                return Futures.f(new CancellationException("Opener is disabled"));
            }
            FutureChain e8 = FutureChain.a(DeferrableSurfaces.k(list, false, j8, getExecutor(), this.f2682e)).e(new AsyncFunction() { // from class: androidx.camera.camera2.internal.a1
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    ListenableFuture G;
                    G = SynchronizedCaptureSessionBaseImpl.this.G(list, (List) obj);
                    return G;
                }
            }, getExecutor());
            this.f2687j = e8;
            return Futures.j(e8);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int i(@NonNull List<CaptureRequest> list, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.h(this.f2684g, "Need to call openCaptureSession before using this API.");
        return this.f2684g.a(list, getExecutor(), captureCallback);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    @NonNull
    public CameraCaptureSessionCompat j() {
        Preconditions.g(this.f2684g);
        return this.f2684g;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void k() throws CameraAccessException {
        Preconditions.h(this.f2684g, "Need to call openCaptureSession before using this API.");
        this.f2684g.c().stopRepeating();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    @NonNull
    public ListenableFuture<Void> l() {
        return Futures.h(null);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void m(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f2683f);
        this.f2683f.m(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void n(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f2683f);
        this.f2683f.n(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void o(@NonNull final SynchronizedCaptureSession synchronizedCaptureSession) {
        ListenableFuture<Void> listenableFuture;
        synchronized (this.f2678a) {
            if (!this.f2689l) {
                this.f2689l = true;
                Preconditions.h(this.f2685h, "Need to call openCaptureSession before using this API.");
                listenableFuture = this.f2685h;
            } else {
                listenableFuture = null;
            }
        }
        c();
        if (listenableFuture != null) {
            listenableFuture.f(new Runnable() { // from class: androidx.camera.camera2.internal.c1
                @Override // java.lang.Runnable
                public final void run() {
                    SynchronizedCaptureSessionBaseImpl.this.D(synchronizedCaptureSession);
                }
            }, CameraXExecutors.a());
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void p(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f2683f);
        c();
        this.f2679b.j(this);
        this.f2683f.p(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void q(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f2683f);
        this.f2679b.k(this);
        this.f2683f.q(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void r(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f2683f);
        this.f2683f.r(synchronizedCaptureSession);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void s(@NonNull final SynchronizedCaptureSession synchronizedCaptureSession) {
        ListenableFuture<Void> listenableFuture;
        synchronized (this.f2678a) {
            if (!this.f2691n) {
                this.f2691n = true;
                Preconditions.h(this.f2685h, "Need to call openCaptureSession before using this API.");
                listenableFuture = this.f2685h;
            } else {
                listenableFuture = null;
            }
        }
        if (listenableFuture != null) {
            listenableFuture.f(new Runnable() { // from class: androidx.camera.camera2.internal.e1
                @Override // java.lang.Runnable
                public final void run() {
                    SynchronizedCaptureSessionBaseImpl.this.E(synchronizedCaptureSession);
                }
            }, CameraXExecutors.a());
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    public boolean stop() {
        boolean z7;
        ListenableFuture<List<Surface>> listenableFuture = null;
        try {
            synchronized (this.f2678a) {
                if (!this.f2690m) {
                    ListenableFuture<List<Surface>> listenableFuture2 = this.f2687j;
                    if (listenableFuture2 != null) {
                        listenableFuture = listenableFuture2;
                    }
                    this.f2690m = true;
                }
                if (!B()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
            return z7;
        } finally {
            if (listenableFuture != null) {
                listenableFuture.cancel(true);
            }
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void t(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull Surface surface) {
        Objects.requireNonNull(this.f2683f);
        this.f2683f.t(synchronizedCaptureSession, surface);
    }

    void z(@NonNull CameraCaptureSession cameraCaptureSession) {
        if (this.f2684g == null) {
            this.f2684g = CameraCaptureSessionCompat.d(cameraCaptureSession, this.f2680c);
        }
    }
}
