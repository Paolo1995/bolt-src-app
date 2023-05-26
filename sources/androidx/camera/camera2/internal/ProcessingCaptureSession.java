package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ProcessingCaptureSession implements CaptureSessionInterface {

    /* renamed from: q  reason: collision with root package name */
    private static List<DeferrableSurface> f2634q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private static int f2635r = 0;

    /* renamed from: a  reason: collision with root package name */
    private final SessionProcessor f2636a;

    /* renamed from: b  reason: collision with root package name */
    private final Camera2CameraInfoImpl f2637b;

    /* renamed from: c  reason: collision with root package name */
    final Executor f2638c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f2639d;

    /* renamed from: g  reason: collision with root package name */
    private SessionConfig f2642g;

    /* renamed from: h  reason: collision with root package name */
    private Camera2RequestProcessor f2643h;

    /* renamed from: i  reason: collision with root package name */
    private SessionConfig f2644i;

    /* renamed from: p  reason: collision with root package name */
    private int f2651p;

    /* renamed from: f  reason: collision with root package name */
    private List<DeferrableSurface> f2641f = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private volatile CaptureConfig f2646k = null;

    /* renamed from: l  reason: collision with root package name */
    volatile boolean f2647l = false;

    /* renamed from: n  reason: collision with root package name */
    private CaptureRequestOptions f2649n = new CaptureRequestOptions.Builder().d();

    /* renamed from: o  reason: collision with root package name */
    private CaptureRequestOptions f2650o = new CaptureRequestOptions.Builder().d();

    /* renamed from: e  reason: collision with root package name */
    private final CaptureSession f2640e = new CaptureSession();

    /* renamed from: j  reason: collision with root package name */
    private ProcessorState f2645j = ProcessorState.UNINITIALIZED;

    /* renamed from: m  reason: collision with root package name */
    private final SessionProcessorCaptureCallback f2648m = new SessionProcessorCaptureCallback();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.camera2.internal.ProcessingCaptureSession$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2655a;

        static {
            int[] iArr = new int[ProcessorState.values().length];
            f2655a = iArr;
            try {
                iArr[ProcessorState.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2655a[ProcessorState.SESSION_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2655a[ProcessorState.ON_CAPTURE_SESSION_STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2655a[ProcessorState.ON_CAPTURE_SESSION_ENDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2655a[ProcessorState.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum ProcessorState {
        UNINITIALIZED,
        SESSION_INITIALIZED,
        ON_CAPTURE_SESSION_STARTED,
        ON_CAPTURE_SESSION_ENDED,
        CLOSED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SessionProcessorCaptureCallback implements SessionProcessor.CaptureCallback {
        SessionProcessorCaptureCallback() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessingCaptureSession(@NonNull SessionProcessor sessionProcessor, @NonNull Camera2CameraInfoImpl camera2CameraInfoImpl, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.f2651p = 0;
        this.f2636a = sessionProcessor;
        this.f2637b = camera2CameraInfoImpl;
        this.f2638c = executor;
        this.f2639d = scheduledExecutorService;
        int i8 = f2635r;
        f2635r = i8 + 1;
        this.f2651p = i8;
        Logger.a("ProcessingCaptureSession", "New ProcessingCaptureSession (id=" + this.f2651p + ")");
    }

    private static void l(@NonNull List<CaptureConfig> list) {
        for (CaptureConfig captureConfig : list) {
            for (CameraCaptureCallback cameraCaptureCallback : captureConfig.b()) {
                cameraCaptureCallback.a();
            }
        }
    }

    private static List<SessionProcessorSurface> m(List<DeferrableSurface> list) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface deferrableSurface : list) {
            Preconditions.b(deferrableSurface instanceof SessionProcessorSurface, "Surface must be SessionProcessorSurface");
            arrayList.add((SessionProcessorSurface) deferrableSurface);
        }
        return arrayList;
    }

    private boolean n(@NonNull List<CaptureConfig> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (CaptureConfig captureConfig : list) {
            if (captureConfig.g() != 2) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        DeferrableSurfaces.e(this.f2641f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(DeferrableSurface deferrableSurface) {
        f2634q.remove(deferrableSurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ListenableFuture q(SessionConfig sessionConfig, CameraDevice cameraDevice, SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener, List list) throws Exception {
        Logger.a("ProcessingCaptureSession", "-- getSurfaces done, start init (id=" + this.f2651p + ")");
        if (this.f2645j == ProcessorState.CLOSED) {
            return Futures.f(new IllegalStateException("SessionProcessorCaptureSession is closed."));
        }
        OutputSurface outputSurface = null;
        if (list.contains(null)) {
            return Futures.f(new DeferrableSurface.SurfaceClosedException("Surface closed", sessionConfig.k().get(list.indexOf(null))));
        }
        try {
            DeferrableSurfaces.f(this.f2641f);
            OutputSurface outputSurface2 = null;
            OutputSurface outputSurface3 = null;
            for (int i8 = 0; i8 < sessionConfig.k().size(); i8++) {
                DeferrableSurface deferrableSurface = sessionConfig.k().get(i8);
                if (Objects.equals(deferrableSurface.e(), Preview.class)) {
                    outputSurface = OutputSurface.a(deferrableSurface.h().get(), new Size(deferrableSurface.f().getWidth(), deferrableSurface.f().getHeight()), deferrableSurface.g());
                } else if (Objects.equals(deferrableSurface.e(), ImageCapture.class)) {
                    outputSurface2 = OutputSurface.a(deferrableSurface.h().get(), new Size(deferrableSurface.f().getWidth(), deferrableSurface.f().getHeight()), deferrableSurface.g());
                } else if (Objects.equals(deferrableSurface.e(), ImageAnalysis.class)) {
                    outputSurface3 = OutputSurface.a(deferrableSurface.h().get(), new Size(deferrableSurface.f().getWidth(), deferrableSurface.f().getHeight()), deferrableSurface.g());
                }
            }
            this.f2645j = ProcessorState.SESSION_INITIALIZED;
            Logger.k("ProcessingCaptureSession", "== initSession (id=" + this.f2651p + ")");
            SessionConfig b8 = this.f2636a.b(this.f2637b, outputSurface, outputSurface2, outputSurface3);
            this.f2644i = b8;
            b8.k().get(0).i().f(new Runnable() { // from class: androidx.camera.camera2.internal.y0
                @Override // java.lang.Runnable
                public final void run() {
                    ProcessingCaptureSession.this.o();
                }
            }, CameraXExecutors.a());
            for (final DeferrableSurface deferrableSurface2 : this.f2644i.k()) {
                f2634q.add(deferrableSurface2);
                deferrableSurface2.i().f(new Runnable() { // from class: androidx.camera.camera2.internal.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProcessingCaptureSession.p(DeferrableSurface.this);
                    }
                }, this.f2638c);
            }
            SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
            validatingBuilder.a(sessionConfig);
            validatingBuilder.d();
            validatingBuilder.a(this.f2644i);
            Preconditions.b(validatingBuilder.f(), "Cannot transform the SessionConfig");
            ListenableFuture<Void> g8 = this.f2640e.g(validatingBuilder.c(), (CameraDevice) Preconditions.g(cameraDevice), synchronizedCaptureSessionOpener);
            Futures.b(g8, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.ProcessingCaptureSession.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                /* renamed from: a */
                public void onSuccess(Void r12) {
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(@NonNull Throwable th) {
                    Logger.d("ProcessingCaptureSession", "open session failed ", th);
                    ProcessingCaptureSession.this.close();
                }
            }, this.f2638c);
            return g8;
        } catch (DeferrableSurface.SurfaceClosedException e8) {
            return Futures.f(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void r(Void r12) {
        s(this.f2640e);
        return null;
    }

    private void t(@NonNull CaptureRequestOptions captureRequestOptions, @NonNull CaptureRequestOptions captureRequestOptions2) {
        Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
        builder.d(captureRequestOptions);
        builder.d(captureRequestOptions2);
        this.f2636a.f(builder.c());
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void a(@NonNull List<CaptureConfig> list) {
        if (list.isEmpty()) {
            return;
        }
        if (list.size() <= 1 && n(list)) {
            if (this.f2646k == null && !this.f2647l) {
                final CaptureConfig captureConfig = list.get(0);
                Logger.a("ProcessingCaptureSession", "issueCaptureRequests (id=" + this.f2651p + ") + state =" + this.f2645j);
                int i8 = AnonymousClass3.f2655a[this.f2645j.ordinal()];
                if (i8 != 1 && i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4 || i8 == 5) {
                            Logger.a("ProcessingCaptureSession", "Run issueCaptureRequests in wrong state, state = " + this.f2645j);
                            l(list);
                            return;
                        }
                        return;
                    }
                    this.f2647l = true;
                    CaptureRequestOptions.Builder e8 = CaptureRequestOptions.Builder.e(captureConfig.d());
                    Config d8 = captureConfig.d();
                    Config.Option<Integer> option = CaptureConfig.f3613h;
                    if (d8.b(option)) {
                        e8.g(CaptureRequest.JPEG_ORIENTATION, (Integer) captureConfig.d().a(option));
                    }
                    Config d9 = captureConfig.d();
                    Config.Option<Integer> option2 = CaptureConfig.f3614i;
                    if (d9.b(option2)) {
                        e8.g(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) captureConfig.d().a(option2)).byteValue()));
                    }
                    CaptureRequestOptions d10 = e8.d();
                    this.f2650o = d10;
                    t(this.f2649n, d10);
                    this.f2636a.g(new SessionProcessor.CaptureCallback() { // from class: androidx.camera.camera2.internal.ProcessingCaptureSession.2
                    });
                    return;
                }
                this.f2646k = captureConfig;
                return;
            }
            l(list);
            return;
        }
        l(list);
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void b() {
        Logger.a("ProcessingCaptureSession", "cancelIssuedCaptureRequests (id=" + this.f2651p + ")");
        if (this.f2646k != null) {
            for (CameraCaptureCallback cameraCaptureCallback : this.f2646k.b()) {
                cameraCaptureCallback.a();
            }
            this.f2646k = null;
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @NonNull
    public ListenableFuture<Void> c(boolean z7) {
        boolean z8;
        if (this.f2645j == ProcessorState.CLOSED) {
            z8 = true;
        } else {
            z8 = false;
        }
        Preconditions.j(z8, "release() can only be called in CLOSED state");
        Logger.a("ProcessingCaptureSession", "release (id=" + this.f2651p + ")");
        return this.f2640e.c(z7);
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void close() {
        Logger.a("ProcessingCaptureSession", "close (id=" + this.f2651p + ") state=" + this.f2645j);
        int i8 = AnonymousClass3.f2655a[this.f2645j.ordinal()];
        if (i8 != 2) {
            if (i8 != 3) {
                if (i8 != 4) {
                    if (i8 == 5) {
                        return;
                    }
                    this.f2645j = ProcessorState.CLOSED;
                    this.f2640e.close();
                }
            } else {
                this.f2636a.c();
                Camera2RequestProcessor camera2RequestProcessor = this.f2643h;
                if (camera2RequestProcessor != null) {
                    camera2RequestProcessor.a();
                }
                this.f2645j = ProcessorState.ON_CAPTURE_SESSION_ENDED;
            }
        }
        this.f2636a.d();
        this.f2645j = ProcessorState.CLOSED;
        this.f2640e.close();
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @NonNull
    public List<CaptureConfig> d() {
        if (this.f2646k != null) {
            return Arrays.asList(this.f2646k);
        }
        return Collections.emptyList();
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public SessionConfig e() {
        return this.f2642g;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void f(SessionConfig sessionConfig) {
        Logger.a("ProcessingCaptureSession", "setSessionConfig (id=" + this.f2651p + ")");
        this.f2642g = sessionConfig;
        if (sessionConfig == null) {
            return;
        }
        Camera2RequestProcessor camera2RequestProcessor = this.f2643h;
        if (camera2RequestProcessor != null) {
            camera2RequestProcessor.b(sessionConfig);
        }
        if (this.f2645j == ProcessorState.ON_CAPTURE_SESSION_STARTED) {
            CaptureRequestOptions d8 = CaptureRequestOptions.Builder.e(sessionConfig.d()).d();
            this.f2649n = d8;
            t(d8, this.f2650o);
            this.f2636a.e(this.f2648m);
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @NonNull
    public ListenableFuture<Void> g(@NonNull final SessionConfig sessionConfig, @NonNull final CameraDevice cameraDevice, @NonNull final SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener) {
        boolean z7;
        if (this.f2645j == ProcessorState.UNINITIALIZED) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.b(z7, "Invalid state state:" + this.f2645j);
        Preconditions.b(sessionConfig.k().isEmpty() ^ true, "SessionConfig contains no surfaces");
        Logger.a("ProcessingCaptureSession", "open (id=" + this.f2651p + ")");
        List<DeferrableSurface> k8 = sessionConfig.k();
        this.f2641f = k8;
        return FutureChain.a(DeferrableSurfaces.k(k8, false, 5000L, this.f2638c, this.f2639d)).e(new AsyncFunction() { // from class: androidx.camera.camera2.internal.w0
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                ListenableFuture q8;
                q8 = ProcessingCaptureSession.this.q(sessionConfig, cameraDevice, synchronizedCaptureSessionOpener, (List) obj);
                return q8;
            }
        }, this.f2638c).d(new Function() { // from class: androidx.camera.camera2.internal.x0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Void r7;
                r7 = ProcessingCaptureSession.this.r((Void) obj);
                return r7;
            }
        }, this.f2638c);
    }

    void s(@NonNull CaptureSession captureSession) {
        boolean z7;
        if (this.f2645j == ProcessorState.SESSION_INITIALIZED) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.b(z7, "Invalid state state:" + this.f2645j);
        Camera2RequestProcessor camera2RequestProcessor = new Camera2RequestProcessor(captureSession, m(this.f2644i.k()));
        this.f2643h = camera2RequestProcessor;
        this.f2636a.a(camera2RequestProcessor);
        this.f2645j = ProcessorState.ON_CAPTURE_SESSION_STARTED;
        SessionConfig sessionConfig = this.f2642g;
        if (sessionConfig != null) {
            f(sessionConfig);
        }
        if (this.f2646k != null) {
            List<CaptureConfig> asList = Arrays.asList(this.f2646k);
            this.f2646k = null;
            a(asList);
        }
    }
}
