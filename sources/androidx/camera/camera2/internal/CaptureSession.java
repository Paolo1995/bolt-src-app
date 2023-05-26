package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionStateCallbacks;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.workaround.StillCaptureFlow;
import androidx.camera.camera2.internal.compat.workaround.TorchStateReset;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CaptureSession implements CaptureSessionInterface {

    /* renamed from: e  reason: collision with root package name */
    SynchronizedCaptureSessionOpener f2547e;

    /* renamed from: f  reason: collision with root package name */
    SynchronizedCaptureSession f2548f;

    /* renamed from: g  reason: collision with root package name */
    SessionConfig f2549g;

    /* renamed from: l  reason: collision with root package name */
    State f2554l;

    /* renamed from: m  reason: collision with root package name */
    ListenableFuture<Void> f2555m;

    /* renamed from: n  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Void> f2556n;

    /* renamed from: a  reason: collision with root package name */
    final Object f2543a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final List<CaptureConfig> f2544b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final CameraCaptureSession.CaptureCallback f2545c = new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.CaptureSession.1
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        }
    };
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    Config f2550h = OptionsBundle.I();
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    CameraEventCallbacks f2551i = CameraEventCallbacks.e();

    /* renamed from: j  reason: collision with root package name */
    private final Map<DeferrableSurface, Surface> f2552j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    List<DeferrableSurface> f2553k = Collections.emptyList();

    /* renamed from: o  reason: collision with root package name */
    final StillCaptureFlow f2557o = new StillCaptureFlow();

    /* renamed from: p  reason: collision with root package name */
    final TorchStateReset f2558p = new TorchStateReset();

    /* renamed from: d  reason: collision with root package name */
    private final StateCallback f2546d = new StateCallback();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.camera2.internal.CaptureSession$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2562a;

        static {
            int[] iArr = new int[State.values().length];
            f2562a = iArr;
            try {
                iArr[State.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2562a[State.INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2562a[State.GET_SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2562a[State.OPENING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2562a[State.OPENED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2562a[State.CLOSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2562a[State.RELEASING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2562a[State.RELEASED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum State {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class StateCallback extends SynchronizedCaptureSession.StateCallback {
        StateCallback() {
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void p(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.f2543a) {
                switch (AnonymousClass4.f2562a[CaptureSession.this.f2554l.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                        throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + CaptureSession.this.f2554l);
                    case 4:
                    case 6:
                    case 7:
                        CaptureSession.this.l();
                        break;
                    case 8:
                        Logger.a("CaptureSession", "ConfigureFailed callback after change to RELEASED state");
                        break;
                }
                Logger.c("CaptureSession", "CameraCaptureSession.onConfigureFailed() " + CaptureSession.this.f2554l);
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void q(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.f2543a) {
                switch (AnonymousClass4.f2562a[CaptureSession.this.f2554l.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 8:
                        throw new IllegalStateException("onConfigured() should not be possible in state: " + CaptureSession.this.f2554l);
                    case 4:
                        CaptureSession captureSession = CaptureSession.this;
                        captureSession.f2554l = State.OPENED;
                        captureSession.f2548f = synchronizedCaptureSession;
                        if (captureSession.f2549g != null) {
                            List<CaptureConfig> c8 = captureSession.f2551i.d().c();
                            if (!c8.isEmpty()) {
                                CaptureSession captureSession2 = CaptureSession.this;
                                captureSession2.o(captureSession2.w(c8));
                            }
                        }
                        Logger.a("CaptureSession", "Attempting to send capture request onConfigured");
                        CaptureSession captureSession3 = CaptureSession.this;
                        captureSession3.q(captureSession3.f2549g);
                        CaptureSession.this.p();
                        break;
                    case 6:
                        CaptureSession.this.f2548f = synchronizedCaptureSession;
                        break;
                    case 7:
                        synchronizedCaptureSession.close();
                        break;
                }
                Logger.a("CaptureSession", "CameraCaptureSession.onConfigured() mState=" + CaptureSession.this.f2554l);
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void r(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.f2543a) {
                if (AnonymousClass4.f2562a[CaptureSession.this.f2554l.ordinal()] != 1) {
                    Logger.a("CaptureSession", "CameraCaptureSession.onReady() " + CaptureSession.this.f2554l);
                } else {
                    throw new IllegalStateException("onReady() should not be possible in state: " + CaptureSession.this.f2554l);
                }
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void s(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.f2543a) {
                if (CaptureSession.this.f2554l != State.UNINITIALIZED) {
                    Logger.a("CaptureSession", "onSessionFinished()");
                    CaptureSession.this.l();
                } else {
                    throw new IllegalStateException("onSessionFinished() should not be possible in state: " + CaptureSession.this.f2554l);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CaptureSession() {
        this.f2554l = State.UNINITIALIZED;
        this.f2554l = State.INITIALIZED;
    }

    private CameraCaptureSession.CaptureCallback k(List<CameraCaptureCallback> list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        for (CameraCaptureCallback cameraCaptureCallback : list) {
            arrayList.add(CaptureCallbackConverter.a(cameraCaptureCallback));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return Camera2CaptureCallbacks.a(arrayList);
    }

    @NonNull
    private OutputConfigurationCompat m(@NonNull SessionConfig.OutputConfig outputConfig, @NonNull Map<DeferrableSurface, Surface> map, String str) {
        Surface surface = map.get(outputConfig.d());
        Preconditions.h(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        OutputConfigurationCompat outputConfigurationCompat = new OutputConfigurationCompat(outputConfig.e(), surface);
        if (str != null) {
            outputConfigurationCompat.e(str);
        } else {
            outputConfigurationCompat.e(outputConfig.b());
        }
        if (!outputConfig.c().isEmpty()) {
            outputConfigurationCompat.b();
            for (DeferrableSurface deferrableSurface : outputConfig.c()) {
                Surface surface2 = map.get(deferrableSurface);
                Preconditions.h(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                outputConfigurationCompat.a(surface2);
            }
        }
        return outputConfigurationCompat;
    }

    @NonNull
    private List<OutputConfigurationCompat> n(@NonNull List<OutputConfigurationCompat> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (OutputConfigurationCompat outputConfigurationCompat : list) {
            if (!arrayList.contains(outputConfigurationCompat.d())) {
                arrayList.add(outputConfigurationCompat.d());
                arrayList2.add(outputConfigurationCompat);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(CameraCaptureSession cameraCaptureSession, int i8, boolean z7) {
        synchronized (this.f2543a) {
            if (this.f2554l == State.OPENED) {
                q(this.f2549g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object t(CallbackToFutureAdapter.Completer completer) throws Exception {
        boolean z7;
        String str;
        synchronized (this.f2543a) {
            if (this.f2556n == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.j(z7, "Release completer expected to be null");
            this.f2556n = completer;
            str = "Release[session=" + this + "]";
        }
        return str;
    }

    @NonNull
    private static Config u(List<CaptureConfig> list) {
        MutableOptionsBundle L = MutableOptionsBundle.L();
        for (CaptureConfig captureConfig : list) {
            Config d8 = captureConfig.d();
            for (Config.Option<?> option : d8.c()) {
                Object e8 = d8.e(option, null);
                if (L.b(option)) {
                    Object e9 = L.e(option, null);
                    if (!Objects.equals(e9, e8)) {
                        Logger.a("CaptureSession", "Detect conflicting option " + option.c() + " : " + e8 + " != " + e9);
                    }
                } else {
                    L.o(option, e8);
                }
            }
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* renamed from: v */
    public ListenableFuture<Void> s(@NonNull List<Surface> list, @NonNull SessionConfig sessionConfig, @NonNull CameraDevice cameraDevice) {
        synchronized (this.f2543a) {
            int i8 = AnonymousClass4.f2562a[this.f2554l.ordinal()];
            if (i8 != 1 && i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 5) {
                        return Futures.f(new CancellationException("openCaptureSession() not execute in state: " + this.f2554l));
                    }
                } else {
                    this.f2552j.clear();
                    for (int i9 = 0; i9 < list.size(); i9++) {
                        this.f2552j.put(this.f2553k.get(i9), list.get(i9));
                    }
                    this.f2554l = State.OPENING;
                    Logger.a("CaptureSession", "Opening capture session.");
                    SynchronizedCaptureSession.StateCallback u7 = SynchronizedCaptureSessionStateCallbacks.u(this.f2546d, new SynchronizedCaptureSessionStateCallbacks.Adapter(sessionConfig.i()));
                    Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(sessionConfig.d());
                    CameraEventCallbacks I = camera2ImplConfig.I(CameraEventCallbacks.e());
                    this.f2551i = I;
                    List<CaptureConfig> d8 = I.d().d();
                    CaptureConfig.Builder k8 = CaptureConfig.Builder.k(sessionConfig.h());
                    for (CaptureConfig captureConfig : d8) {
                        k8.e(captureConfig.d());
                    }
                    ArrayList arrayList = new ArrayList();
                    String N = camera2ImplConfig.N(null);
                    for (SessionConfig.OutputConfig outputConfig : sessionConfig.f()) {
                        OutputConfigurationCompat m8 = m(outputConfig, this.f2552j, N);
                        Config d9 = sessionConfig.d();
                        Config.Option<Long> option = Camera2ImplConfig.C;
                        if (d9.b(option)) {
                            m8.f(((Long) sessionConfig.d().a(option)).longValue());
                        }
                        arrayList.add(m8);
                    }
                    SessionConfigurationCompat a8 = this.f2547e.a(0, n(arrayList), u7);
                    if (sessionConfig.l() == 5 && sessionConfig.e() != null) {
                        a8.f(InputConfigurationCompat.b(sessionConfig.e()));
                    }
                    try {
                        CaptureRequest c8 = Camera2CaptureRequestBuilder.c(k8.h(), cameraDevice);
                        if (c8 != null) {
                            a8.g(c8);
                        }
                        return this.f2547e.c(cameraDevice, a8, this.f2553k);
                    } catch (CameraAccessException e8) {
                        return Futures.f(e8);
                    }
                }
            }
            return Futures.f(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.f2554l));
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void a(@NonNull List<CaptureConfig> list) {
        synchronized (this.f2543a) {
            switch (AnonymousClass4.f2562a[this.f2554l.ordinal()]) {
                case 1:
                    throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.f2554l);
                case 2:
                case 3:
                case 4:
                    this.f2544b.addAll(list);
                    break;
                case 5:
                    this.f2544b.addAll(list);
                    p();
                    break;
                case 6:
                case 7:
                case 8:
                    throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void b() {
        ArrayList<CaptureConfig> arrayList;
        synchronized (this.f2543a) {
            if (!this.f2544b.isEmpty()) {
                arrayList = new ArrayList(this.f2544b);
                this.f2544b.clear();
            } else {
                arrayList = null;
            }
        }
        if (arrayList != null) {
            for (CaptureConfig captureConfig : arrayList) {
                for (CameraCaptureCallback cameraCaptureCallback : captureConfig.b()) {
                    cameraCaptureCallback.a();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056 A[Catch: all -> 0x00af, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x000d, B:28:0x00a8, B:7:0x0012, B:10:0x0018, B:14:0x0024, B:13:0x001d, B:15:0x0029, B:17:0x0056, B:18:0x005a, B:20:0x005e, B:21:0x0069, B:22:0x006b, B:24:0x006d, B:25:0x008a, B:26:0x008f, B:27:0x00a7), top: B:36:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e A[Catch: all -> 0x00af, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x000d, B:28:0x00a8, B:7:0x0012, B:10:0x0018, B:14:0x0024, B:13:0x001d, B:15:0x0029, B:17:0x0056, B:18:0x005a, B:20:0x005e, B:21:0x0069, B:22:0x006b, B:24:0x006d, B:25:0x008a, B:26:0x008f, B:27:0x00a7), top: B:36:0x0003, inners: #0 }] */
    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> c(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f2543a
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass4.f2562a     // Catch: java.lang.Throwable -> Laf
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f2554l     // Catch: java.lang.Throwable -> Laf
            int r2 = r2.ordinal()     // Catch: java.lang.Throwable -> Laf
            r1 = r1[r2]     // Catch: java.lang.Throwable -> Laf
            switch(r1) {
                case 1: goto L8f;
                case 2: goto L8a;
                case 3: goto L6d;
                case 4: goto L29;
                case 5: goto L12;
                case 6: goto L12;
                case 7: goto L5a;
                default: goto L10;
            }     // Catch: java.lang.Throwable -> Laf
        L10:
            goto La8
        L12:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r1 = r3.f2548f     // Catch: java.lang.Throwable -> Laf
            if (r1 == 0) goto L29
            if (r4 == 0) goto L24
            r1.d()     // Catch: android.hardware.camera2.CameraAccessException -> L1c java.lang.Throwable -> Laf
            goto L24
        L1c:
            r4 = move-exception
            java.lang.String r1 = "CaptureSession"
            java.lang.String r2 = "Unable to abort captures."
            androidx.camera.core.Logger.d(r1, r2, r4)     // Catch: java.lang.Throwable -> Laf
        L24:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r4 = r3.f2548f     // Catch: java.lang.Throwable -> Laf
            r4.close()     // Catch: java.lang.Throwable -> Laf
        L29:
            androidx.camera.camera2.impl.CameraEventCallbacks r4 = r3.f2551i     // Catch: java.lang.Throwable -> Laf
            androidx.camera.camera2.impl.CameraEventCallbacks$ComboCameraEventCallback r4 = r4.d()     // Catch: java.lang.Throwable -> Laf
            r4.a()     // Catch: java.lang.Throwable -> Laf
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch: java.lang.Throwable -> Laf
            r3.f2554l = r4     // Catch: java.lang.Throwable -> Laf
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.f2547e     // Catch: java.lang.Throwable -> Laf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf
            r1.<init>()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch: java.lang.Throwable -> Laf
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f2554l     // Catch: java.lang.Throwable -> Laf
            r1.append(r2)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Laf
            androidx.core.util.Preconditions.h(r4, r1)     // Catch: java.lang.Throwable -> Laf
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.f2547e     // Catch: java.lang.Throwable -> Laf
            boolean r4 = r4.e()     // Catch: java.lang.Throwable -> Laf
            if (r4 == 0) goto L5a
            r3.l()     // Catch: java.lang.Throwable -> Laf
            goto La8
        L5a:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.f2555m     // Catch: java.lang.Throwable -> Laf
            if (r4 != 0) goto L69
            androidx.camera.camera2.internal.s0 r4 = new androidx.camera.camera2.internal.s0     // Catch: java.lang.Throwable -> Laf
            r4.<init>()     // Catch: java.lang.Throwable -> Laf
            com.google.common.util.concurrent.ListenableFuture r4 = androidx.concurrent.futures.CallbackToFutureAdapter.a(r4)     // Catch: java.lang.Throwable -> Laf
            r3.f2555m = r4     // Catch: java.lang.Throwable -> Laf
        L69:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.f2555m     // Catch: java.lang.Throwable -> Laf
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Laf
            return r4
        L6d:
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.f2547e     // Catch: java.lang.Throwable -> Laf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf
            r1.<init>()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch: java.lang.Throwable -> Laf
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f2554l     // Catch: java.lang.Throwable -> Laf
            r1.append(r2)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Laf
            androidx.core.util.Preconditions.h(r4, r1)     // Catch: java.lang.Throwable -> Laf
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.f2547e     // Catch: java.lang.Throwable -> Laf
            r4.e()     // Catch: java.lang.Throwable -> Laf
        L8a:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch: java.lang.Throwable -> Laf
            r3.f2554l = r4     // Catch: java.lang.Throwable -> Laf
            goto La8
        L8f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Laf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf
            r1.<init>()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = "release() should not be possible in state: "
            r1.append(r2)     // Catch: java.lang.Throwable -> Laf
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f2554l     // Catch: java.lang.Throwable -> Laf
            r1.append(r2)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Laf
            r4.<init>(r1)     // Catch: java.lang.Throwable -> Laf
            throw r4     // Catch: java.lang.Throwable -> Laf
        La8:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Laf
            r4 = 0
            com.google.common.util.concurrent.ListenableFuture r4 = androidx.camera.core.impl.utils.futures.Futures.h(r4)
            return r4
        Laf:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Laf
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.c(boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void close() {
        synchronized (this.f2543a) {
            int i8 = AnonymousClass4.f2562a[this.f2554l.ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 == 5) {
                                if (this.f2549g != null) {
                                    List<CaptureConfig> b8 = this.f2551i.d().b();
                                    if (!b8.isEmpty()) {
                                        try {
                                            a(w(b8));
                                        } catch (IllegalStateException e8) {
                                            Logger.d("CaptureSession", "Unable to issue the request before close the capture session", e8);
                                        }
                                    }
                                }
                            }
                        }
                        SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener = this.f2547e;
                        Preconditions.h(synchronizedCaptureSessionOpener, "The Opener shouldn't null in state:" + this.f2554l);
                        this.f2547e.e();
                        this.f2554l = State.CLOSED;
                        this.f2549g = null;
                    } else {
                        SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener2 = this.f2547e;
                        Preconditions.h(synchronizedCaptureSessionOpener2, "The Opener shouldn't null in state:" + this.f2554l);
                        this.f2547e.e();
                    }
                }
                this.f2554l = State.RELEASED;
            } else {
                throw new IllegalStateException("close() should not be possible in state: " + this.f2554l);
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @NonNull
    public List<CaptureConfig> d() {
        List<CaptureConfig> unmodifiableList;
        synchronized (this.f2543a) {
            unmodifiableList = Collections.unmodifiableList(this.f2544b);
        }
        return unmodifiableList;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public SessionConfig e() {
        SessionConfig sessionConfig;
        synchronized (this.f2543a) {
            sessionConfig = this.f2549g;
        }
        return sessionConfig;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void f(SessionConfig sessionConfig) {
        synchronized (this.f2543a) {
            switch (AnonymousClass4.f2562a[this.f2554l.ordinal()]) {
                case 1:
                    throw new IllegalStateException("setSessionConfig() should not be possible in state: " + this.f2554l);
                case 2:
                case 3:
                case 4:
                    this.f2549g = sessionConfig;
                    break;
                case 5:
                    this.f2549g = sessionConfig;
                    if (sessionConfig == null) {
                        return;
                    }
                    if (!this.f2552j.keySet().containsAll(sessionConfig.k())) {
                        Logger.c("CaptureSession", "Does not have the proper configured lists");
                        return;
                    }
                    Logger.a("CaptureSession", "Attempting to submit CaptureRequest after setting");
                    q(this.f2549g);
                    break;
                case 6:
                case 7:
                case 8:
                    throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @NonNull
    public ListenableFuture<Void> g(@NonNull final SessionConfig sessionConfig, @NonNull final CameraDevice cameraDevice, @NonNull SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener) {
        synchronized (this.f2543a) {
            if (AnonymousClass4.f2562a[this.f2554l.ordinal()] != 2) {
                Logger.c("CaptureSession", "Open not allowed in state: " + this.f2554l);
                return Futures.f(new IllegalStateException("open() should not allow the state: " + this.f2554l));
            }
            this.f2554l = State.GET_SURFACE;
            ArrayList arrayList = new ArrayList(sessionConfig.k());
            this.f2553k = arrayList;
            this.f2547e = synchronizedCaptureSessionOpener;
            FutureChain e8 = FutureChain.a(synchronizedCaptureSessionOpener.d(arrayList, 5000L)).e(new AsyncFunction() { // from class: androidx.camera.camera2.internal.r0
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    ListenableFuture s7;
                    s7 = CaptureSession.this.s(sessionConfig, cameraDevice, (List) obj);
                    return s7;
                }
            }, this.f2547e.b());
            Futures.b(e8, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.CaptureSession.2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                /* renamed from: a */
                public void onSuccess(Void r12) {
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(@NonNull Throwable th) {
                    synchronized (CaptureSession.this.f2543a) {
                        CaptureSession.this.f2547e.e();
                        int i8 = AnonymousClass4.f2562a[CaptureSession.this.f2554l.ordinal()];
                        if ((i8 == 4 || i8 == 6 || i8 == 7) && !(th instanceof CancellationException)) {
                            Logger.l("CaptureSession", "Opening session with fail " + CaptureSession.this.f2554l, th);
                            CaptureSession.this.l();
                        }
                    }
                }
            }, this.f2547e.b());
            return Futures.j(e8);
        }
    }

    void l() {
        State state = this.f2554l;
        State state2 = State.RELEASED;
        if (state == state2) {
            Logger.a("CaptureSession", "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.f2554l = state2;
        this.f2548f = null;
        CallbackToFutureAdapter.Completer<Void> completer = this.f2556n;
        if (completer != null) {
            completer.c(null);
            this.f2556n = null;
        }
    }

    int o(List<CaptureConfig> list) {
        CameraBurstCaptureCallback cameraBurstCaptureCallback;
        ArrayList arrayList;
        boolean z7;
        boolean z8;
        synchronized (this.f2543a) {
            if (list.isEmpty()) {
                return -1;
            }
            try {
                cameraBurstCaptureCallback = new CameraBurstCaptureCallback();
                arrayList = new ArrayList();
                Logger.a("CaptureSession", "Issuing capture request.");
                z7 = false;
                for (CaptureConfig captureConfig : list) {
                    if (captureConfig.e().isEmpty()) {
                        Logger.a("CaptureSession", "Skipping issuing empty capture request.");
                    } else {
                        Iterator<DeferrableSurface> it = captureConfig.e().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                DeferrableSurface next = it.next();
                                if (!this.f2552j.containsKey(next)) {
                                    Logger.a("CaptureSession", "Skipping capture request with invalid surface: " + next);
                                    z8 = false;
                                    break;
                                }
                            } else {
                                z8 = true;
                                break;
                            }
                        }
                        if (z8) {
                            if (captureConfig.g() == 2) {
                                z7 = true;
                            }
                            CaptureConfig.Builder k8 = CaptureConfig.Builder.k(captureConfig);
                            if (captureConfig.g() == 5 && captureConfig.c() != null) {
                                k8.n(captureConfig.c());
                            }
                            SessionConfig sessionConfig = this.f2549g;
                            if (sessionConfig != null) {
                                k8.e(sessionConfig.h().d());
                            }
                            k8.e(this.f2550h);
                            k8.e(captureConfig.d());
                            CaptureRequest b8 = Camera2CaptureRequestBuilder.b(k8.h(), this.f2548f.e(), this.f2552j);
                            if (b8 == null) {
                                Logger.a("CaptureSession", "Skipping issuing request without surface.");
                                return -1;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (CameraCaptureCallback cameraCaptureCallback : captureConfig.b()) {
                                CaptureCallbackConverter.b(cameraCaptureCallback, arrayList2);
                            }
                            cameraBurstCaptureCallback.a(b8, arrayList2);
                            arrayList.add(b8);
                        }
                    }
                }
            } catch (CameraAccessException e8) {
                Logger.c("CaptureSession", "Unable to access camera: " + e8.getMessage());
                Thread.dumpStack();
            }
            if (!arrayList.isEmpty()) {
                if (this.f2557o.a(arrayList, z7)) {
                    this.f2548f.k();
                    cameraBurstCaptureCallback.c(new CameraBurstCaptureCallback.CaptureSequenceCallback() { // from class: androidx.camera.camera2.internal.q0
                        @Override // androidx.camera.camera2.internal.CameraBurstCaptureCallback.CaptureSequenceCallback
                        public final void a(CameraCaptureSession cameraCaptureSession, int i8, boolean z9) {
                            CaptureSession.this.r(cameraCaptureSession, i8, z9);
                        }
                    });
                }
                if (this.f2558p.b(arrayList, z7)) {
                    cameraBurstCaptureCallback.a((CaptureRequest) arrayList.get(arrayList.size() - 1), Collections.singletonList(new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.CaptureSession.3
                        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                            synchronized (CaptureSession.this.f2543a) {
                                SessionConfig sessionConfig2 = CaptureSession.this.f2549g;
                                if (sessionConfig2 == null) {
                                    return;
                                }
                                CaptureConfig h8 = sessionConfig2.h();
                                Logger.a("CaptureSession", "Submit FLASH_MODE_OFF request");
                                CaptureSession captureSession = CaptureSession.this;
                                captureSession.a(Collections.singletonList(captureSession.f2558p.a(h8)));
                            }
                        }
                    }));
                }
                return this.f2548f.i(arrayList, cameraBurstCaptureCallback);
            }
            Logger.a("CaptureSession", "Skipping issuing burst request due to no valid request elements");
            return -1;
        }
    }

    void p() {
        if (this.f2544b.isEmpty()) {
            return;
        }
        try {
            o(this.f2544b);
        } finally {
            this.f2544b.clear();
        }
    }

    int q(SessionConfig sessionConfig) {
        synchronized (this.f2543a) {
            if (sessionConfig == null) {
                Logger.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no configuration case.");
                return -1;
            }
            CaptureConfig h8 = sessionConfig.h();
            if (h8.e().isEmpty()) {
                Logger.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no surface.");
                try {
                    this.f2548f.k();
                } catch (CameraAccessException e8) {
                    Logger.c("CaptureSession", "Unable to access camera: " + e8.getMessage());
                    Thread.dumpStack();
                }
                return -1;
            }
            try {
                Logger.a("CaptureSession", "Issuing request for session.");
                CaptureConfig.Builder k8 = CaptureConfig.Builder.k(h8);
                Config u7 = u(this.f2551i.d().e());
                this.f2550h = u7;
                k8.e(u7);
                CaptureRequest b8 = Camera2CaptureRequestBuilder.b(k8.h(), this.f2548f.e(), this.f2552j);
                if (b8 == null) {
                    Logger.a("CaptureSession", "Skipping issuing empty request for session.");
                    return -1;
                }
                return this.f2548f.f(b8, k(h8.b(), this.f2545c));
            } catch (CameraAccessException e9) {
                Logger.c("CaptureSession", "Unable to access camera: " + e9.getMessage());
                Thread.dumpStack();
                return -1;
            }
        }
    }

    List<CaptureConfig> w(List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig captureConfig : list) {
            CaptureConfig.Builder k8 = CaptureConfig.Builder.k(captureConfig);
            k8.p(1);
            for (DeferrableSurface deferrableSurface : this.f2549g.h().e()) {
                k8.f(deferrableSurface);
            }
            arrayList.add(k8.h());
        }
        return arrayList;
    }
}
