package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.AeFpsRange;
import androidx.camera.camera2.internal.compat.workaround.AutoFlashAEModeDisabler;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class Camera2CameraControlImpl implements CameraControlInternal {

    /* renamed from: b  reason: collision with root package name */
    final CameraControlSessionCallback f2388b;

    /* renamed from: c  reason: collision with root package name */
    final Executor f2389c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f2390d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final CameraCharacteristicsCompat f2391e;

    /* renamed from: f  reason: collision with root package name */
    private final CameraControlInternal.ControlUpdateCallback f2392f;

    /* renamed from: g  reason: collision with root package name */
    private final SessionConfig.Builder f2393g;

    /* renamed from: h  reason: collision with root package name */
    private final FocusMeteringControl f2394h;

    /* renamed from: i  reason: collision with root package name */
    private final ZoomControl f2395i;

    /* renamed from: j  reason: collision with root package name */
    private final TorchControl f2396j;

    /* renamed from: k  reason: collision with root package name */
    private final ExposureControl f2397k;

    /* renamed from: l  reason: collision with root package name */
    ZslControl f2398l;

    /* renamed from: m  reason: collision with root package name */
    private final Camera2CameraControl f2399m;

    /* renamed from: n  reason: collision with root package name */
    private final Camera2CapturePipeline f2400n;

    /* renamed from: o  reason: collision with root package name */
    private int f2401o;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f2402p;

    /* renamed from: q  reason: collision with root package name */
    private volatile int f2403q;

    /* renamed from: r  reason: collision with root package name */
    private final AeFpsRange f2404r;

    /* renamed from: s  reason: collision with root package name */
    private final AutoFlashAEModeDisabler f2405s;

    /* renamed from: t  reason: collision with root package name */
    private final AtomicLong f2406t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    private volatile ListenableFuture<Void> f2407u;

    /* renamed from: v  reason: collision with root package name */
    private int f2408v;

    /* renamed from: w  reason: collision with root package name */
    private long f2409w;

    /* renamed from: x  reason: collision with root package name */
    private final CameraCaptureCallbackSet f2410x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class CameraCaptureCallbackSet extends CameraCaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        Set<CameraCaptureCallback> f2411a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        Map<CameraCaptureCallback, Executor> f2412b = new ArrayMap();

        CameraCaptureCallbackSet() {
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void a() {
            for (final CameraCaptureCallback cameraCaptureCallback : this.f2411a) {
                try {
                    this.f2412b.get(cameraCaptureCallback).execute(new Runnable() { // from class: androidx.camera.camera2.internal.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraCaptureCallback.this.a();
                        }
                    });
                } catch (RejectedExecutionException e8) {
                    Logger.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCancelled.", e8);
                }
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void b(@NonNull final CameraCaptureResult cameraCaptureResult) {
            for (final CameraCaptureCallback cameraCaptureCallback : this.f2411a) {
                try {
                    this.f2412b.get(cameraCaptureCallback).execute(new Runnable() { // from class: androidx.camera.camera2.internal.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraCaptureCallback.this.b(cameraCaptureResult);
                        }
                    });
                } catch (RejectedExecutionException e8) {
                    Logger.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCompleted.", e8);
                }
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void c(@NonNull final CameraCaptureFailure cameraCaptureFailure) {
            for (final CameraCaptureCallback cameraCaptureCallback : this.f2411a) {
                try {
                    this.f2412b.get(cameraCaptureCallback).execute(new Runnable() { // from class: androidx.camera.camera2.internal.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraCaptureCallback.this.c(cameraCaptureFailure);
                        }
                    });
                } catch (RejectedExecutionException e8) {
                    Logger.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureFailed.", e8);
                }
            }
        }

        void g(@NonNull Executor executor, @NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.f2411a.add(cameraCaptureCallback);
            this.f2412b.put(cameraCaptureCallback, executor);
        }

        void k(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.f2411a.remove(cameraCaptureCallback);
            this.f2412b.remove(cameraCaptureCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class CameraControlSessionCallback extends CameraCaptureSession.CaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        final Set<CaptureResultListener> f2413a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private final Executor f2414b;

        CameraControlSessionCallback(@NonNull Executor executor) {
            this.f2414b = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(TotalCaptureResult totalCaptureResult) {
            HashSet hashSet = new HashSet();
            for (CaptureResultListener captureResultListener : this.f2413a) {
                if (captureResultListener.a(totalCaptureResult)) {
                    hashSet.add(captureResultListener);
                }
            }
            if (!hashSet.isEmpty()) {
                this.f2413a.removeAll(hashSet);
            }
        }

        void b(@NonNull CaptureResultListener captureResultListener) {
            this.f2413a.add(captureResultListener);
        }

        void d(@NonNull CaptureResultListener captureResultListener) {
            this.f2413a.remove(captureResultListener);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull final TotalCaptureResult totalCaptureResult) {
            this.f2414b.execute(new Runnable() { // from class: androidx.camera.camera2.internal.o
                @Override // java.lang.Runnable
                public final void run() {
                    Camera2CameraControlImpl.CameraControlSessionCallback.this.c(totalCaptureResult);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public interface CaptureResultListener {
        boolean a(@NonNull TotalCaptureResult totalCaptureResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Camera2CameraControlImpl(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Executor executor, @NonNull CameraControlInternal.ControlUpdateCallback controlUpdateCallback, @NonNull Quirks quirks) {
        SessionConfig.Builder builder = new SessionConfig.Builder();
        this.f2393g = builder;
        this.f2401o = 0;
        this.f2402p = false;
        this.f2403q = 2;
        this.f2406t = new AtomicLong(0L);
        this.f2407u = Futures.h(null);
        this.f2408v = 1;
        this.f2409w = 0L;
        CameraCaptureCallbackSet cameraCaptureCallbackSet = new CameraCaptureCallbackSet();
        this.f2410x = cameraCaptureCallbackSet;
        this.f2391e = cameraCharacteristicsCompat;
        this.f2392f = controlUpdateCallback;
        this.f2389c = executor;
        CameraControlSessionCallback cameraControlSessionCallback = new CameraControlSessionCallback(executor);
        this.f2388b = cameraControlSessionCallback;
        builder.s(this.f2408v);
        builder.i(CaptureCallbackContainer.d(cameraControlSessionCallback));
        builder.i(cameraCaptureCallbackSet);
        this.f2397k = new ExposureControl(this, cameraCharacteristicsCompat, executor);
        this.f2394h = new FocusMeteringControl(this, scheduledExecutorService, executor, quirks);
        this.f2395i = new ZoomControl(this, cameraCharacteristicsCompat, executor);
        this.f2396j = new TorchControl(this, cameraCharacteristicsCompat, executor);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f2398l = new ZslControlImpl(cameraCharacteristicsCompat);
        } else {
            this.f2398l = new ZslControlNoOpImpl();
        }
        this.f2404r = new AeFpsRange(quirks);
        this.f2405s = new AutoFlashAEModeDisabler(quirks);
        this.f2399m = new Camera2CameraControl(this, executor);
        this.f2400n = new Camera2CapturePipeline(this, cameraCharacteristicsCompat, quirks, executor);
        executor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.f
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControlImpl.this.P();
            }
        });
    }

    private int C(int i8) {
        int[] iArr = (int[]) this.f2391e.a(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (J(i8, iArr)) {
            return i8;
        }
        if (!J(1, iArr)) {
            return 0;
        }
        return 1;
    }

    private boolean I() {
        if (E() > 0) {
            return true;
        }
        return false;
    }

    private boolean J(int i8, int[] iArr) {
        for (int i9 : iArr) {
            if (i8 == i9) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean K(@NonNull TotalCaptureResult totalCaptureResult, long j8) {
        Long l8;
        if (totalCaptureResult.getRequest() == null) {
            return false;
        }
        Object tag = totalCaptureResult.getRequest().getTag();
        if (!(tag instanceof TagBundle) || (l8 = (Long) ((TagBundle) tag).c("CameraControlSessionUpdateId")) == null || l8.longValue() < j8) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.f2410x.g(executor, cameraCaptureCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        s(this.f2399m.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(CameraCaptureCallback cameraCaptureCallback) {
        this.f2410x.k(cameraCaptureCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ListenableFuture R(List list, int i8, int i9, int i10, Void r52) throws Exception {
        return this.f2400n.e(list, i8, i9, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(CallbackToFutureAdapter.Completer completer) {
        Futures.k(h0(g0()), completer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object T(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.f2389c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.h
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControlImpl.this.S(completer);
            }
        });
        return "updateSessionConfigAsync";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean U(long j8, CallbackToFutureAdapter.Completer completer, TotalCaptureResult totalCaptureResult) {
        if (K(totalCaptureResult, j8)) {
            completer.c(null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object V(final long j8, final CallbackToFutureAdapter.Completer completer) throws Exception {
        s(new CaptureResultListener() { // from class: androidx.camera.camera2.internal.b
            @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
            public final boolean a(TotalCaptureResult totalCaptureResult) {
                boolean U;
                U = Camera2CameraControlImpl.U(j8, completer, totalCaptureResult);
                return U;
            }
        });
        return "waitForSessionUpdateId:" + j8;
    }

    @NonNull
    private ListenableFuture<Void> h0(final long j8) {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.j
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object V;
                V = Camera2CameraControlImpl.this.V(j8, completer);
                return V;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int A(int i8) {
        int[] iArr = (int[]) this.f2391e.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (J(i8, iArr)) {
            return i8;
        }
        if (!J(1, iArr)) {
            return 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int B(int i8) {
        int[] iArr = (int[]) this.f2391e.a(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (J(i8, iArr)) {
            return i8;
        }
        if (J(4, iArr)) {
            return 4;
        }
        if (!J(1, iArr)) {
            return 0;
        }
        return 1;
    }

    @NonNull
    public TorchControl D() {
        return this.f2396j;
    }

    int E() {
        int i8;
        synchronized (this.f2390d) {
            i8 = this.f2401o;
        }
        return i8;
    }

    @NonNull
    public ZoomControl F() {
        return this.f2395i;
    }

    @NonNull
    public ZslControl G() {
        return this.f2398l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H() {
        synchronized (this.f2390d) {
            this.f2401o++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean L() {
        return this.f2402p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(@NonNull CaptureResultListener captureResultListener) {
        this.f2388b.d(captureResultListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(@NonNull final CameraCaptureCallback cameraCaptureCallback) {
        this.f2389c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.k
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControlImpl.this.Q(cameraCaptureCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y() {
        b0(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(boolean z7) {
        this.f2394h.m(z7);
        this.f2395i.f(z7);
        this.f2396j.j(z7);
        this.f2397k.b(z7);
        this.f2399m.s(z7);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void a(@NonNull SessionConfig.Builder builder) {
        this.f2398l.a(builder);
    }

    public void a0(Rational rational) {
        this.f2394h.n(rational);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public ListenableFuture<List<Void>> b(@NonNull final List<CaptureConfig> list, final int i8, final int i9) {
        if (!I()) {
            Logger.k("Camera2CameraControlImp", "Camera is not active.");
            return Futures.f(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        final int w7 = w();
        return FutureChain.a(Futures.j(this.f2407u)).e(new AsyncFunction() { // from class: androidx.camera.camera2.internal.e
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                ListenableFuture R;
                R = Camera2CameraControlImpl.this.R(list, i8, w7, i9, (Void) obj);
                return R;
            }
        }, this.f2389c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0(int i8) {
        this.f2408v = i8;
        this.f2394h.o(i8);
        this.f2400n.d(this.f2408v);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public Rect c() {
        return (Rect) Preconditions.g((Rect) this.f2391e.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    public void c0(boolean z7) {
        this.f2398l.d(z7);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void d(int i8) {
        if (!I()) {
            Logger.k("Camera2CameraControlImp", "Camera is not active.");
            return;
        }
        this.f2403q = i8;
        ZslControl zslControl = this.f2398l;
        boolean z7 = true;
        if (this.f2403q != 1 && this.f2403q != 0) {
            z7 = false;
        }
        zslControl.c(z7);
        this.f2407u = f0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0(List<CaptureConfig> list) {
        this.f2392f.b(list);
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> e(boolean z7) {
        if (!I()) {
            return Futures.f(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return Futures.j(this.f2396j.d(z7));
    }

    public void e0() {
        this.f2389c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.i
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControlImpl.this.g0();
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public Config f() {
        return this.f2399m.k();
    }

    @NonNull
    ListenableFuture<Void> f0() {
        return Futures.j(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object T;
                T = Camera2CameraControlImpl.this.T(completer);
                return T;
            }
        }));
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void g(@NonNull Config config) {
        this.f2399m.g(CaptureRequestOptions.Builder.e(config).d()).f(new Runnable() { // from class: androidx.camera.camera2.internal.g
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControlImpl.M();
            }
        }, CameraXExecutors.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long g0() {
        this.f2409w = this.f2406t.getAndIncrement();
        this.f2392f.a();
        return this.f2409w;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void h() {
        this.f2399m.i().f(new Runnable() { // from class: androidx.camera.camera2.internal.c
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControlImpl.O();
            }
        }, CameraXExecutors.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(@NonNull CaptureResultListener captureResultListener) {
        this.f2388b.b(captureResultListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(@NonNull final Executor executor, @NonNull final CameraCaptureCallback cameraCaptureCallback) {
        this.f2389c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.d
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControlImpl.this.N(executor, cameraCaptureCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        synchronized (this.f2390d) {
            int i8 = this.f2401o;
            if (i8 != 0) {
                this.f2401o = i8 - 1;
            } else {
                throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(boolean z7) {
        this.f2402p = z7;
        if (!z7) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.p(this.f2408v);
            builder.q(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.e(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(A(1)));
            builder2.e(CaptureRequest.FLASH_MODE, 0);
            builder.e(builder2.c());
            d0(Collections.singletonList(builder.h()));
        }
        g0();
    }

    public int w() {
        return this.f2403q;
    }

    @NonNull
    public FocusMeteringControl x() {
        return this.f2394h;
    }

    @NonNull
    public SessionConfig y() {
        this.f2393g.s(this.f2408v);
        this.f2393g.q(z());
        Object K = this.f2399m.k().K(null);
        if (K != null && (K instanceof Integer)) {
            this.f2393g.l("Camera2CameraControl", K);
        }
        this.f2393g.l("CameraControlSessionUpdateId", Long.valueOf(this.f2409w));
        return this.f2393g.m();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[LOOP:0: B:12:0x006a->B:14:0x0070, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.camera.core.impl.Config z() {
        /*
            r7 = this;
            androidx.camera.camera2.impl.Camera2ImplConfig$Builder r0 = new androidx.camera.camera2.impl.Camera2ImplConfig$Builder
            r0.<init>()
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_MODE
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.e(r1, r3)
            androidx.camera.camera2.internal.FocusMeteringControl r1 = r7.f2394h
            r1.b(r0)
            androidx.camera.camera2.internal.compat.workaround.AeFpsRange r1 = r7.f2404r
            r1.a(r0)
            androidx.camera.camera2.internal.ZoomControl r1 = r7.f2395i
            r1.a(r0)
            boolean r1 = r7.f2402p
            r3 = 2
            if (r1 == 0) goto L2d
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.FLASH_MODE
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.e(r1, r3)
            goto L33
        L2d:
            int r1 = r7.f2403q
            if (r1 == 0) goto L37
            if (r1 == r2) goto L35
        L33:
            r1 = 1
            goto L3d
        L35:
            r1 = 3
            goto L3d
        L37:
            androidx.camera.camera2.internal.compat.workaround.AutoFlashAEModeDisabler r1 = r7.f2405s
            int r1 = r1.a(r3)
        L3d:
            android.hardware.camera2.CaptureRequest$Key r3 = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE
            int r1 = r7.A(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.e(r3, r1)
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_AWB_MODE
            int r2 = r7.C(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.e(r1, r2)
            androidx.camera.camera2.internal.ExposureControl r1 = r7.f2397k
            r1.c(r0)
            androidx.camera.camera2.interop.Camera2CameraControl r1 = r7.f2399m
            androidx.camera.camera2.impl.Camera2ImplConfig r1 = r1.k()
            java.util.Set r2 = r1.c()
            java.util.Iterator r2 = r2.iterator()
        L6a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L84
            java.lang.Object r3 = r2.next()
            androidx.camera.core.impl.Config$Option r3 = (androidx.camera.core.impl.Config.Option) r3
            androidx.camera.core.impl.MutableConfig r4 = r0.a()
            androidx.camera.core.impl.Config$OptionPriority r5 = androidx.camera.core.impl.Config.OptionPriority.ALWAYS_OVERRIDE
            java.lang.Object r6 = r1.a(r3)
            r4.k(r3, r5, r6)
            goto L6a
        L84:
            androidx.camera.camera2.impl.Camera2ImplConfig r0 = r0.c()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2CameraControlImpl.z():androidx.camera.core.impl.Config");
    }
}
