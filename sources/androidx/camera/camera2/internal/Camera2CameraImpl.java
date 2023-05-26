package androidx.camera.camera2.internal;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener;
import androidx.camera.camera2.internal.compat.ApiCompat$Api21Impl;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraState;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.common.util.concurrent.ListenableFuture;
import com.sinch.android.rtc.internal.InternalErrorCodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Camera2CameraImpl implements CameraInternal {
    @NonNull
    private final SynchronizedCaptureSessionOpener.Builder A;
    private final Set<String> B;
    @NonNull
    private CameraConfig C;
    final Object D;
    private SessionProcessor E;
    boolean F;
    @NonNull
    private final DisplayInfoManager G;

    /* renamed from: f  reason: collision with root package name */
    private final UseCaseAttachState f2421f;

    /* renamed from: g  reason: collision with root package name */
    private final CameraManagerCompat f2422g;

    /* renamed from: h  reason: collision with root package name */
    private final Executor f2423h;

    /* renamed from: i  reason: collision with root package name */
    private final ScheduledExecutorService f2424i;

    /* renamed from: j  reason: collision with root package name */
    volatile InternalState f2425j = InternalState.INITIALIZED;

    /* renamed from: k  reason: collision with root package name */
    private final LiveDataObservable<CameraInternal.State> f2426k;

    /* renamed from: l  reason: collision with root package name */
    private final CameraStateMachine f2427l;

    /* renamed from: m  reason: collision with root package name */
    private final Camera2CameraControlImpl f2428m;

    /* renamed from: n  reason: collision with root package name */
    private final StateCallback f2429n;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    final Camera2CameraInfoImpl f2430o;

    /* renamed from: p  reason: collision with root package name */
    CameraDevice f2431p;

    /* renamed from: q  reason: collision with root package name */
    int f2432q;

    /* renamed from: r  reason: collision with root package name */
    CaptureSessionInterface f2433r;

    /* renamed from: s  reason: collision with root package name */
    final AtomicInteger f2434s;

    /* renamed from: t  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Void> f2435t;

    /* renamed from: u  reason: collision with root package name */
    final Map<CaptureSessionInterface, ListenableFuture<Void>> f2436u;

    /* renamed from: v  reason: collision with root package name */
    private final CameraAvailability f2437v;

    /* renamed from: w  reason: collision with root package name */
    private final CameraStateRegistry f2438w;

    /* renamed from: x  reason: collision with root package name */
    final Set<CaptureSession> f2439x;

    /* renamed from: y  reason: collision with root package name */
    private MeteringRepeatingSession f2440y;
    @NonNull

    /* renamed from: z  reason: collision with root package name */
    private final CaptureSessionRepository f2441z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.camera2.internal.Camera2CameraImpl$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2445a;

        static {
            int[] iArr = new int[InternalState.values().length];
            f2445a = iArr;
            try {
                iArr[InternalState.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2445a[InternalState.PENDING_OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2445a[InternalState.CLOSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2445a[InternalState.OPENED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2445a[InternalState.OPENING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2445a[InternalState.REOPENING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2445a[InternalState.RELEASING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2445a[InternalState.RELEASED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class CameraAvailability extends CameraManager.AvailabilityCallback implements CameraStateRegistry.OnOpenAvailableListener {

        /* renamed from: a  reason: collision with root package name */
        private final String f2446a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2447b = true;

        CameraAvailability(String str) {
            this.f2446a = str;
        }

        @Override // androidx.camera.core.impl.CameraStateRegistry.OnOpenAvailableListener
        public void a() {
            if (Camera2CameraImpl.this.f2425j == InternalState.PENDING_OPEN) {
                Camera2CameraImpl.this.q0(false);
            }
        }

        boolean b() {
            return this.f2447b;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(@NonNull String str) {
            if (!this.f2446a.equals(str)) {
                return;
            }
            this.f2447b = true;
            if (Camera2CameraImpl.this.f2425j == InternalState.PENDING_OPEN) {
                Camera2CameraImpl.this.q0(false);
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(@NonNull String str) {
            if (!this.f2446a.equals(str)) {
                return;
            }
            this.f2447b = false;
        }
    }

    /* loaded from: classes.dex */
    final class ControlUpdateListenerInternal implements CameraControlInternal.ControlUpdateCallback {
        ControlUpdateListenerInternal() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void a() {
            Camera2CameraImpl.this.r0();
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void b(@NonNull List<CaptureConfig> list) {
            Camera2CameraImpl.this.l0((List) Preconditions.g(list));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum InternalState {
        INITIALIZED,
        PENDING_OPEN,
        OPENING,
        OPENED,
        CLOSING,
        REOPENING,
        RELEASING,
        RELEASED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class StateCallback extends CameraDevice.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f2459a;

        /* renamed from: b  reason: collision with root package name */
        private final ScheduledExecutorService f2460b;

        /* renamed from: c  reason: collision with root package name */
        private ScheduledReopen f2461c;

        /* renamed from: d  reason: collision with root package name */
        ScheduledFuture<?> f2462d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private final CameraReopenMonitor f2463e = new CameraReopenMonitor();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class CameraReopenMonitor {

            /* renamed from: a  reason: collision with root package name */
            private long f2465a = -1;

            CameraReopenMonitor() {
            }

            boolean a() {
                boolean z7;
                if (b() >= d()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7) {
                    return true;
                }
                e();
                return false;
            }

            long b() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.f2465a == -1) {
                    this.f2465a = uptimeMillis;
                }
                return uptimeMillis - this.f2465a;
            }

            int c() {
                if (!StateCallback.this.f()) {
                    return 700;
                }
                long b8 = b();
                if (b8 <= 120000) {
                    return 1000;
                }
                if (b8 <= 300000) {
                    return CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
                }
                return InternalErrorCodes.ApiCallFailed;
            }

            int d() {
                if (!StateCallback.this.f()) {
                    return 10000;
                }
                return 1800000;
            }

            void e() {
                this.f2465a = -1L;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class ScheduledReopen implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            private Executor f2467f;

            /* renamed from: g  reason: collision with root package name */
            private boolean f2468g = false;

            ScheduledReopen(@NonNull Executor executor) {
                this.f2467f = executor;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void c() {
                boolean z7;
                if (!this.f2468g) {
                    if (Camera2CameraImpl.this.f2425j == InternalState.REOPENING) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Preconditions.i(z7);
                    if (StateCallback.this.f()) {
                        Camera2CameraImpl.this.p0(true);
                    } else {
                        Camera2CameraImpl.this.q0(true);
                    }
                }
            }

            void b() {
                this.f2468g = true;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f2467f.execute(new Runnable() { // from class: androidx.camera.camera2.internal.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        Camera2CameraImpl.StateCallback.ScheduledReopen.this.c();
                    }
                });
            }
        }

        StateCallback(@NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService) {
            this.f2459a = executor;
            this.f2460b = scheduledExecutorService;
        }

        private void b(@NonNull CameraDevice cameraDevice, int i8) {
            boolean z7;
            int i9;
            if (Camera2CameraImpl.this.f2425j != InternalState.OPENING && Camera2CameraImpl.this.f2425j != InternalState.OPENED && Camera2CameraImpl.this.f2425j != InternalState.REOPENING) {
                z7 = false;
            } else {
                z7 = true;
            }
            Preconditions.j(z7, "Attempt to handle open error from non open state: " + Camera2CameraImpl.this.f2425j);
            if (i8 != 1 && i8 != 2 && i8 != 4) {
                Logger.c("Camera2CameraImpl", "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + Camera2CameraImpl.J(i8) + " closing camera.");
                if (i8 == 3) {
                    i9 = 5;
                } else {
                    i9 = 6;
                }
                Camera2CameraImpl.this.j0(InternalState.CLOSING, CameraState.StateError.a(i9));
                Camera2CameraImpl.this.B(false);
                return;
            }
            Logger.a("Camera2CameraImpl", String.format("Attempt to reopen camera[%s] after error[%s]", cameraDevice.getId(), Camera2CameraImpl.J(i8)));
            c(i8);
        }

        private void c(int i8) {
            boolean z7;
            int i9 = 1;
            if (Camera2CameraImpl.this.f2432q != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.j(z7, "Can only reopen camera device after error if the camera device is actually in an error state.");
            if (i8 != 1) {
                if (i8 != 2) {
                    i9 = 3;
                }
            } else {
                i9 = 2;
            }
            Camera2CameraImpl.this.j0(InternalState.REOPENING, CameraState.StateError.a(i9));
            Camera2CameraImpl.this.B(false);
        }

        boolean a() {
            if (this.f2462d == null) {
                return false;
            }
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.F("Cancelling scheduled re-open: " + this.f2461c);
            this.f2461c.b();
            this.f2461c = null;
            this.f2462d.cancel(false);
            this.f2462d = null;
            return true;
        }

        void d() {
            this.f2463e.e();
        }

        void e() {
            boolean z7;
            boolean z8 = true;
            if (this.f2461c == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.i(z7);
            if (this.f2462d != null) {
                z8 = false;
            }
            Preconditions.i(z8);
            if (this.f2463e.a()) {
                this.f2461c = new ScheduledReopen(this.f2459a);
                Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                camera2CameraImpl.F("Attempting camera re-open in " + this.f2463e.c() + "ms: " + this.f2461c + " activeResuming = " + Camera2CameraImpl.this.F);
                this.f2462d = this.f2460b.schedule(this.f2461c, (long) this.f2463e.c(), TimeUnit.MILLISECONDS);
                return;
            }
            Logger.c("Camera2CameraImpl", "Camera reopening attempted for " + this.f2463e.d() + "ms without success.");
            Camera2CameraImpl.this.k0(InternalState.PENDING_OPEN, null, false);
        }

        boolean f() {
            int i8;
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            if (camera2CameraImpl.F && ((i8 = camera2CameraImpl.f2432q) == 1 || i8 == 2)) {
                return true;
            }
            return false;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(@NonNull CameraDevice cameraDevice) {
            boolean z7;
            Camera2CameraImpl.this.F("CameraDevice.onClosed()");
            if (Camera2CameraImpl.this.f2431p == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.j(z7, "Unexpected onClose callback on camera device: " + cameraDevice);
            int i8 = AnonymousClass3.f2445a[Camera2CameraImpl.this.f2425j.ordinal()];
            if (i8 != 3) {
                if (i8 != 6) {
                    if (i8 != 7) {
                        throw new IllegalStateException("Camera closed while in state: " + Camera2CameraImpl.this.f2425j);
                    }
                } else {
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    if (camera2CameraImpl.f2432q != 0) {
                        camera2CameraImpl.F("Camera closed due to error: " + Camera2CameraImpl.J(Camera2CameraImpl.this.f2432q));
                        e();
                        return;
                    }
                    camera2CameraImpl.q0(false);
                    return;
                }
            }
            Preconditions.i(Camera2CameraImpl.this.M());
            Camera2CameraImpl.this.I();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.F("CameraDevice.onDisconnected()");
            onError(cameraDevice, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i8) {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.f2431p = cameraDevice;
            camera2CameraImpl.f2432q = i8;
            int i9 = AnonymousClass3.f2445a[camera2CameraImpl.f2425j.ordinal()];
            if (i9 != 3) {
                if (i9 != 4 && i9 != 5 && i9 != 6) {
                    if (i9 != 7) {
                        throw new IllegalStateException("onError() should not be possible from state: " + Camera2CameraImpl.this.f2425j);
                    }
                } else {
                    Logger.a("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.", cameraDevice.getId(), Camera2CameraImpl.J(i8), Camera2CameraImpl.this.f2425j.name()));
                    b(cameraDevice, i8);
                    return;
                }
            }
            Logger.c("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", cameraDevice.getId(), Camera2CameraImpl.J(i8), Camera2CameraImpl.this.f2425j.name()));
            Camera2CameraImpl.this.B(false);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.F("CameraDevice.onOpened()");
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.f2431p = cameraDevice;
            camera2CameraImpl.f2432q = 0;
            d();
            int i8 = AnonymousClass3.f2445a[Camera2CameraImpl.this.f2425j.ordinal()];
            if (i8 != 3) {
                if (i8 != 5 && i8 != 6) {
                    if (i8 != 7) {
                        throw new IllegalStateException("onOpened() should not be possible from state: " + Camera2CameraImpl.this.f2425j);
                    }
                } else {
                    Camera2CameraImpl.this.i0(InternalState.OPENED);
                    Camera2CameraImpl.this.b0();
                    return;
                }
            }
            Preconditions.i(Camera2CameraImpl.this.M());
            Camera2CameraImpl.this.f2431p.close();
            Camera2CameraImpl.this.f2431p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class UseCaseInfo {
        @NonNull
        static UseCaseInfo a(@NonNull String str, @NonNull Class<?> cls, @NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig, Size size) {
            return new AutoValue_Camera2CameraImpl_UseCaseInfo(str, cls, sessionConfig, useCaseConfig, size);
        }

        @NonNull
        static UseCaseInfo b(@NonNull UseCase useCase) {
            return a(Camera2CameraImpl.K(useCase), useCase.getClass(), useCase.m(), useCase.g(), useCase.c());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public abstract SessionConfig c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Size d();

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public abstract UseCaseConfig<?> e();

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public abstract String f();

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public abstract Class<?> g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Camera2CameraImpl(@NonNull CameraManagerCompat cameraManagerCompat, @NonNull String str, @NonNull Camera2CameraInfoImpl camera2CameraInfoImpl, @NonNull CameraStateRegistry cameraStateRegistry, @NonNull Executor executor, @NonNull Handler handler, @NonNull DisplayInfoManager displayInfoManager) throws CameraUnavailableException {
        LiveDataObservable<CameraInternal.State> liveDataObservable = new LiveDataObservable<>();
        this.f2426k = liveDataObservable;
        this.f2432q = 0;
        this.f2434s = new AtomicInteger(0);
        this.f2436u = new LinkedHashMap();
        this.f2439x = new HashSet();
        this.B = new HashSet();
        this.C = CameraConfigs.a();
        this.D = new Object();
        this.F = false;
        this.f2422g = cameraManagerCompat;
        this.f2438w = cameraStateRegistry;
        ScheduledExecutorService e8 = CameraXExecutors.e(handler);
        this.f2424i = e8;
        Executor f8 = CameraXExecutors.f(executor);
        this.f2423h = f8;
        this.f2429n = new StateCallback(f8, e8);
        this.f2421f = new UseCaseAttachState(str);
        liveDataObservable.g(CameraInternal.State.CLOSED);
        CameraStateMachine cameraStateMachine = new CameraStateMachine(cameraStateRegistry);
        this.f2427l = cameraStateMachine;
        CaptureSessionRepository captureSessionRepository = new CaptureSessionRepository(f8);
        this.f2441z = captureSessionRepository;
        this.G = displayInfoManager;
        this.f2433r = X();
        try {
            Camera2CameraControlImpl camera2CameraControlImpl = new Camera2CameraControlImpl(cameraManagerCompat.c(str), e8, f8, new ControlUpdateListenerInternal(), camera2CameraInfoImpl.d());
            this.f2428m = camera2CameraControlImpl;
            this.f2430o = camera2CameraInfoImpl;
            camera2CameraInfoImpl.k(camera2CameraControlImpl);
            camera2CameraInfoImpl.n(cameraStateMachine.a());
            this.A = new SynchronizedCaptureSessionOpener.Builder(f8, e8, handler, captureSessionRepository, camera2CameraInfoImpl.d(), DeviceQuirks.b());
            CameraAvailability cameraAvailability = new CameraAvailability(str);
            this.f2437v = cameraAvailability;
            cameraStateRegistry.e(this, f8, cameraAvailability);
            cameraManagerCompat.f(f8, cameraAvailability);
        } catch (CameraAccessExceptionCompat e9) {
            throw CameraUnavailableExceptionHelper.a(e9);
        }
    }

    private boolean A(CaptureConfig.Builder builder) {
        if (!builder.l().isEmpty()) {
            Logger.k("Camera2CameraImpl", "The capture config builder already has surface inside.");
            return false;
        }
        for (SessionConfig sessionConfig : this.f2421f.e()) {
            List<DeferrableSurface> e8 = sessionConfig.h().e();
            if (!e8.isEmpty()) {
                for (DeferrableSurface deferrableSurface : e8) {
                    builder.f(deferrableSurface);
                }
            }
        }
        if (builder.l().isEmpty()) {
            Logger.k("Camera2CameraImpl", "Unable to find a repeating surface to attach to CaptureConfig");
            return false;
        }
        return true;
    }

    private void C() {
        F("Closing camera.");
        int i8 = AnonymousClass3.f2445a[this.f2425j.ordinal()];
        boolean z7 = false;
        if (i8 != 2) {
            if (i8 != 4) {
                if (i8 != 5 && i8 != 6) {
                    F("close() ignored due to being in state: " + this.f2425j);
                    return;
                }
                boolean a8 = this.f2429n.a();
                i0(InternalState.CLOSING);
                if (a8) {
                    Preconditions.i(M());
                    I();
                    return;
                }
                return;
            }
            i0(InternalState.CLOSING);
            B(false);
            return;
        }
        if (this.f2431p == null) {
            z7 = true;
        }
        Preconditions.i(z7);
        i0(InternalState.INITIALIZED);
    }

    private void D(boolean z7) {
        final CaptureSession captureSession = new CaptureSession();
        this.f2439x.add(captureSession);
        h0(z7);
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(640, 480);
        final Surface surface = new Surface(surfaceTexture);
        final Runnable runnable = new Runnable() { // from class: androidx.camera.camera2.internal.w
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.O(surface, surfaceTexture);
            }
        };
        SessionConfig.Builder builder = new SessionConfig.Builder();
        final ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        builder.h(immediateSurface);
        builder.s(1);
        F("Start configAndClose.");
        captureSession.g(builder.m(), (CameraDevice) Preconditions.g(this.f2431p), this.A.a()).f(new Runnable() { // from class: androidx.camera.camera2.internal.x
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.P(captureSession, immediateSurface, runnable);
            }
        }, this.f2423h);
    }

    private CameraDevice.StateCallback E() {
        ArrayList arrayList = new ArrayList(this.f2421f.f().c().b());
        arrayList.add(this.f2441z.c());
        arrayList.add(this.f2429n);
        return CameraDeviceStateCallbacks.a(arrayList);
    }

    private void G(@NonNull String str, Throwable th) {
        Logger.b("Camera2CameraImpl", String.format("{%s} %s", toString(), str), th);
    }

    static String J(int i8) {
        return i8 != 0 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? i8 != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE" : "ERROR_CAMERA_DEVICE" : "ERROR_CAMERA_DISABLED" : "ERROR_MAX_CAMERAS_IN_USE" : "ERROR_CAMERA_IN_USE" : "ERROR_NONE";
    }

    @NonNull
    static String K(@NonNull UseCase useCase) {
        return useCase.j() + useCase.hashCode();
    }

    private boolean L() {
        if (((Camera2CameraInfoImpl) j()).j() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(List list) {
        try {
            n0(list);
        } finally {
            this.f2428m.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig) {
        F("Use case " + str + " ACTIVE");
        this.f2421f.q(str, sessionConfig, useCaseConfig);
        this.f2421f.u(str, sessionConfig, useCaseConfig);
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(String str) {
        F("Use case " + str + " INACTIVE");
        this.f2421f.t(str);
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig) {
        F("Use case " + str + " RESET");
        this.f2421f.u(str, sessionConfig, useCaseConfig);
        h0(false);
        r0();
        if (this.f2425j == InternalState.OPENED) {
            b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig) {
        F("Use case " + str + " UPDATED");
        this.f2421f.u(str, sessionConfig, useCaseConfig);
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(SessionConfig.ErrorListener errorListener, SessionConfig sessionConfig) {
        errorListener.a(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(boolean z7) {
        this.F = z7;
        if (z7 && this.f2425j == InternalState.PENDING_OPEN) {
            p0(false);
        }
    }

    @NonNull
    private CaptureSessionInterface X() {
        synchronized (this.D) {
            if (this.E == null) {
                return new CaptureSession();
            }
            return new ProcessingCaptureSession(this.E, this.f2430o, this.f2423h, this.f2424i);
        }
    }

    private void Y(List<UseCase> list) {
        for (UseCase useCase : list) {
            String K = K(useCase);
            if (!this.B.contains(K)) {
                this.B.add(K);
                useCase.D();
            }
        }
    }

    private void Z(List<UseCase> list) {
        for (UseCase useCase : list) {
            String K = K(useCase);
            if (this.B.contains(K)) {
                useCase.E();
                this.B.remove(K);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private void a0(boolean z7) {
        if (!z7) {
            this.f2429n.d();
        }
        this.f2429n.a();
        F("Opening camera.");
        i0(InternalState.OPENING);
        try {
            this.f2422g.e(this.f2430o.a(), this.f2423h, E());
        } catch (CameraAccessExceptionCompat e8) {
            F("Unable to open camera due to " + e8.getMessage());
            if (e8.d() == 10001) {
                j0(InternalState.INITIALIZED, CameraState.StateError.b(7, e8));
            }
        } catch (SecurityException e9) {
            F("Unable to open camera due to " + e9.getMessage());
            i0(InternalState.REOPENING);
            this.f2429n.e();
        }
    }

    private void c0() {
        int i8 = AnonymousClass3.f2445a[this.f2425j.ordinal()];
        boolean z7 = false;
        if (i8 != 1 && i8 != 2) {
            if (i8 != 3) {
                F("open() ignored due to being in state: " + this.f2425j);
                return;
            }
            i0(InternalState.REOPENING);
            if (!M() && this.f2432q == 0) {
                if (this.f2431p != null) {
                    z7 = true;
                }
                Preconditions.j(z7, "Camera Device should be open if session close is not complete");
                i0(InternalState.OPENED);
                b0();
                return;
            }
            return;
        }
        p0(false);
    }

    private void g0() {
        if (this.f2440y != null) {
            UseCaseAttachState useCaseAttachState = this.f2421f;
            useCaseAttachState.s(this.f2440y.c() + this.f2440y.hashCode());
            UseCaseAttachState useCaseAttachState2 = this.f2421f;
            useCaseAttachState2.t(this.f2440y.c() + this.f2440y.hashCode());
            this.f2440y.b();
            this.f2440y = null;
        }
    }

    @NonNull
    private Collection<UseCaseInfo> m0(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : collection) {
            arrayList.add(UseCaseInfo.b(useCase));
        }
        return arrayList;
    }

    private void n0(@NonNull Collection<UseCaseInfo> collection) {
        Size d8;
        boolean isEmpty = this.f2421f.g().isEmpty();
        ArrayList arrayList = new ArrayList();
        Rational rational = null;
        for (UseCaseInfo useCaseInfo : collection) {
            if (!this.f2421f.l(useCaseInfo.f())) {
                this.f2421f.r(useCaseInfo.f(), useCaseInfo.c(), useCaseInfo.e());
                arrayList.add(useCaseInfo.f());
                if (useCaseInfo.g() == Preview.class && (d8 = useCaseInfo.d()) != null) {
                    rational = new Rational(d8.getWidth(), d8.getHeight());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        F("Use cases [" + TextUtils.join(", ", arrayList) + "] now ATTACHED");
        if (isEmpty) {
            this.f2428m.Z(true);
            this.f2428m.H();
        }
        z();
        s0();
        r0();
        h0(false);
        if (this.f2425j == InternalState.OPENED) {
            b0();
        } else {
            c0();
        }
        if (rational != null) {
            this.f2428m.a0(rational);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public void Q(@NonNull Collection<UseCaseInfo> collection) {
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (UseCaseInfo useCaseInfo : collection) {
            if (this.f2421f.l(useCaseInfo.f())) {
                this.f2421f.p(useCaseInfo.f());
                arrayList.add(useCaseInfo.f());
                if (useCaseInfo.g() == Preview.class) {
                    z7 = true;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        F("Use cases [" + TextUtils.join(", ", arrayList) + "] now DETACHED for camera");
        if (z7) {
            this.f2428m.a0(null);
        }
        z();
        if (this.f2421f.h().isEmpty()) {
            this.f2428m.c0(false);
        } else {
            s0();
        }
        if (this.f2421f.g().isEmpty()) {
            this.f2428m.u();
            h0(false);
            this.f2428m.Z(false);
            this.f2433r = X();
            C();
            return;
        }
        r0();
        h0(false);
        if (this.f2425j == InternalState.OPENED) {
            b0();
        }
    }

    private void s0() {
        boolean z7 = false;
        for (UseCaseConfig<?> useCaseConfig : this.f2421f.h()) {
            z7 |= useCaseConfig.z(false);
        }
        this.f2428m.c0(z7);
    }

    private void y() {
        if (this.f2440y != null) {
            UseCaseAttachState useCaseAttachState = this.f2421f;
            useCaseAttachState.r(this.f2440y.c() + this.f2440y.hashCode(), this.f2440y.e(), this.f2440y.f());
            UseCaseAttachState useCaseAttachState2 = this.f2421f;
            useCaseAttachState2.q(this.f2440y.c() + this.f2440y.hashCode(), this.f2440y.e(), this.f2440y.f());
        }
    }

    private void z() {
        SessionConfig c8 = this.f2421f.f().c();
        CaptureConfig h8 = c8.h();
        int size = h8.e().size();
        int size2 = c8.k().size();
        if (!c8.k().isEmpty()) {
            if (h8.e().isEmpty()) {
                if (this.f2440y == null) {
                    this.f2440y = new MeteringRepeatingSession(this.f2430o.h(), this.G);
                }
                y();
            } else if (size2 == 1 && size == 1) {
                g0();
            } else if (size >= 2) {
                g0();
            } else {
                Logger.a("Camera2CameraImpl", "mMeteringRepeating is ATTACHED, SessionConfig Surfaces: " + size2 + ", CaptureConfig Surfaces: " + size);
            }
        }
    }

    void B(boolean z7) {
        boolean z8;
        if (this.f2425j != InternalState.CLOSING && this.f2425j != InternalState.RELEASING && (this.f2425j != InternalState.REOPENING || this.f2432q == 0)) {
            z8 = false;
        } else {
            z8 = true;
        }
        Preconditions.j(z8, "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.f2425j + " (error: " + J(this.f2432q) + ")");
        int i8 = Build.VERSION.SDK_INT;
        if (i8 > 23 && i8 < 29 && L() && this.f2432q == 0) {
            D(z7);
        } else {
            h0(z7);
        }
        this.f2433r.b();
    }

    void F(@NonNull String str) {
        G(str, null);
    }

    SessionConfig H(@NonNull DeferrableSurface deferrableSurface) {
        for (SessionConfig sessionConfig : this.f2421f.g()) {
            if (sessionConfig.k().contains(deferrableSurface)) {
                return sessionConfig;
            }
        }
        return null;
    }

    void I() {
        boolean z7;
        if (this.f2425j != InternalState.RELEASING && this.f2425j != InternalState.CLOSING) {
            z7 = false;
        } else {
            z7 = true;
        }
        Preconditions.i(z7);
        Preconditions.i(this.f2436u.isEmpty());
        this.f2431p = null;
        if (this.f2425j == InternalState.CLOSING) {
            i0(InternalState.INITIALIZED);
            return;
        }
        this.f2422g.g(this.f2437v);
        i0(InternalState.RELEASED);
        CallbackToFutureAdapter.Completer<Void> completer = this.f2435t;
        if (completer != null) {
            completer.c(null);
            this.f2435t = null;
        }
    }

    boolean M() {
        if (this.f2436u.isEmpty() && this.f2439x.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void a(@NonNull UseCase useCase) {
        Preconditions.g(useCase);
        final String K = K(useCase);
        final SessionConfig m8 = useCase.m();
        final UseCaseConfig<?> g8 = useCase.g();
        this.f2423h.execute(new Runnable() { // from class: androidx.camera.camera2.internal.r
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.R(K, m8, g8);
            }
        });
    }

    @Override // androidx.camera.core.Camera
    public /* synthetic */ CameraControl b() {
        return androidx.camera.core.impl.e.a(this);
    }

    void b0() {
        boolean z7;
        if (this.f2425j == InternalState.OPENED) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.i(z7);
        SessionConfig.ValidatingBuilder f8 = this.f2421f.f();
        if (!f8.f()) {
            F("Unable to create capture session due to conflicting configurations");
            return;
        }
        Config d8 = f8.c().d();
        Config.Option<Long> option = Camera2ImplConfig.C;
        if (!d8.b(option)) {
            f8.b(option, Long.valueOf(StreamUseCaseUtil.a(this.f2421f.h(), this.f2421f.g())));
        }
        Futures.b(this.f2433r.g(f8.c(), (CameraDevice) Preconditions.g(this.f2431p), this.A.a()), new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.2
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(Void r12) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                if (th instanceof DeferrableSurface.SurfaceClosedException) {
                    SessionConfig H = Camera2CameraImpl.this.H(((DeferrableSurface.SurfaceClosedException) th).a());
                    if (H != null) {
                        Camera2CameraImpl.this.d0(H);
                    }
                } else if (th instanceof CancellationException) {
                    Camera2CameraImpl.this.F("Unable to configure camera cancelled");
                } else {
                    InternalState internalState = Camera2CameraImpl.this.f2425j;
                    InternalState internalState2 = InternalState.OPENED;
                    if (internalState == internalState2) {
                        Camera2CameraImpl.this.j0(internalState2, CameraState.StateError.b(4, th));
                    }
                    if (th instanceof CameraAccessException) {
                        Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                        camera2CameraImpl.F("Unable to configure camera due to " + th.getMessage());
                    } else if (th instanceof TimeoutException) {
                        Logger.c("Camera2CameraImpl", "Unable to configure camera " + Camera2CameraImpl.this.f2430o.a() + ", timeout!");
                    }
                }
            }
        }, this.f2423h);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void c(@NonNull UseCase useCase) {
        Preconditions.g(useCase);
        final String K = K(useCase);
        final SessionConfig m8 = useCase.m();
        final UseCaseConfig<?> g8 = useCase.g();
        this.f2423h.execute(new Runnable() { // from class: androidx.camera.camera2.internal.t
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.U(K, m8, g8);
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraControlInternal d() {
        return this.f2428m;
    }

    void d0(@NonNull final SessionConfig sessionConfig) {
        ScheduledExecutorService d8 = CameraXExecutors.d();
        List<SessionConfig.ErrorListener> c8 = sessionConfig.c();
        if (!c8.isEmpty()) {
            final SessionConfig.ErrorListener errorListener = c8.get(0);
            G("Posting surface closed", new Throwable());
            d8.execute(new Runnable() { // from class: androidx.camera.camera2.internal.s
                @Override // java.lang.Runnable
                public final void run() {
                    Camera2CameraImpl.V(SessionConfig.ErrorListener.this, sessionConfig);
                }
            });
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraConfig e() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e0 */
    public void P(@NonNull CaptureSession captureSession, @NonNull DeferrableSurface deferrableSurface, @NonNull Runnable runnable) {
        this.f2439x.remove(captureSession);
        ListenableFuture<Void> f02 = f0(captureSession, false);
        deferrableSurface.c();
        Futures.n(Arrays.asList(f02, deferrableSurface.i())).f(runnable, CameraXExecutors.a());
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void f(final boolean z7) {
        this.f2423h.execute(new Runnable() { // from class: androidx.camera.camera2.internal.q
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.W(z7);
            }
        });
    }

    ListenableFuture<Void> f0(@NonNull final CaptureSessionInterface captureSessionInterface, boolean z7) {
        captureSessionInterface.close();
        ListenableFuture<Void> c8 = captureSessionInterface.c(z7);
        F("Releasing session in state " + this.f2425j.name());
        this.f2436u.put(captureSessionInterface, c8);
        Futures.b(c8, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(Void r22) {
                CameraDevice cameraDevice;
                Camera2CameraImpl.this.f2436u.remove(captureSessionInterface);
                int i8 = AnonymousClass3.f2445a[Camera2CameraImpl.this.f2425j.ordinal()];
                if (i8 != 3) {
                    if (i8 != 6) {
                        if (i8 != 7) {
                            return;
                        }
                    } else if (Camera2CameraImpl.this.f2432q == 0) {
                        return;
                    }
                }
                if (Camera2CameraImpl.this.M() && (cameraDevice = Camera2CameraImpl.this.f2431p) != null) {
                    ApiCompat$Api21Impl.a(cameraDevice);
                    Camera2CameraImpl.this.f2431p = null;
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
            }
        }, CameraXExecutors.a());
        return c8;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public /* synthetic */ CameraInfo g() {
        return androidx.camera.core.impl.e.b(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void h(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (arrayList.isEmpty()) {
            return;
        }
        this.f2428m.H();
        Y(new ArrayList(arrayList));
        final ArrayList arrayList2 = new ArrayList(m0(arrayList));
        try {
            this.f2423h.execute(new Runnable() { // from class: androidx.camera.camera2.internal.v
                @Override // java.lang.Runnable
                public final void run() {
                    Camera2CameraImpl.this.N(arrayList2);
                }
            });
        } catch (RejectedExecutionException e8) {
            G("Unable to attach use cases.", e8);
            this.f2428m.u();
        }
    }

    void h0(boolean z7) {
        boolean z8;
        if (this.f2433r != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        Preconditions.i(z8);
        F("Resetting Capture Session");
        CaptureSessionInterface captureSessionInterface = this.f2433r;
        SessionConfig e8 = captureSessionInterface.e();
        List<CaptureConfig> d8 = captureSessionInterface.d();
        CaptureSessionInterface X = X();
        this.f2433r = X;
        X.f(e8);
        this.f2433r.a(d8);
        f0(captureSessionInterface, z7);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void i(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (arrayList.isEmpty()) {
            return;
        }
        final ArrayList arrayList2 = new ArrayList(m0(arrayList));
        Z(new ArrayList(arrayList));
        this.f2423h.execute(new Runnable() { // from class: androidx.camera.camera2.internal.u
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.Q(arrayList2);
            }
        });
    }

    void i0(@NonNull InternalState internalState) {
        j0(internalState, null);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraInfoInternal j() {
        return this.f2430o;
    }

    void j0(@NonNull InternalState internalState, CameraState.StateError stateError) {
        k0(internalState, stateError, true);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void k(@NonNull UseCase useCase) {
        Preconditions.g(useCase);
        final String K = K(useCase);
        final SessionConfig m8 = useCase.m();
        final UseCaseConfig<?> g8 = useCase.g();
        this.f2423h.execute(new Runnable() { // from class: androidx.camera.camera2.internal.y
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.T(K, m8, g8);
            }
        });
    }

    void k0(@NonNull InternalState internalState, CameraState.StateError stateError, boolean z7) {
        CameraInternal.State state;
        F("Transitioning camera internal state: " + this.f2425j + " --> " + internalState);
        this.f2425j = internalState;
        switch (AnonymousClass3.f2445a[internalState.ordinal()]) {
            case 1:
                state = CameraInternal.State.CLOSED;
                break;
            case 2:
                state = CameraInternal.State.PENDING_OPEN;
                break;
            case 3:
                state = CameraInternal.State.CLOSING;
                break;
            case 4:
                state = CameraInternal.State.OPEN;
                break;
            case 5:
            case 6:
                state = CameraInternal.State.OPENING;
                break;
            case 7:
                state = CameraInternal.State.RELEASING;
                break;
            case 8:
                state = CameraInternal.State.RELEASED;
                break;
            default:
                throw new IllegalStateException("Unknown state: " + internalState);
        }
        this.f2438w.c(this, state, z7);
        this.f2426k.g(state);
        this.f2427l.c(state, stateError);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void l(CameraConfig cameraConfig) {
        if (cameraConfig == null) {
            cameraConfig = CameraConfigs.a();
        }
        SessionProcessor G = cameraConfig.G(null);
        this.C = cameraConfig;
        synchronized (this.D) {
            this.E = G;
        }
    }

    void l0(@NonNull List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig captureConfig : list) {
            CaptureConfig.Builder k8 = CaptureConfig.Builder.k(captureConfig);
            if (captureConfig.g() == 5 && captureConfig.c() != null) {
                k8.n(captureConfig.c());
            }
            if (!captureConfig.e().isEmpty() || !captureConfig.h() || A(k8)) {
                arrayList.add(k8.h());
            }
        }
        F("Issue capture request");
        this.f2433r.a(arrayList);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public Observable<CameraInternal.State> m() {
        return this.f2426k;
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void n(@NonNull UseCase useCase) {
        Preconditions.g(useCase);
        final String K = K(useCase);
        this.f2423h.execute(new Runnable() { // from class: androidx.camera.camera2.internal.p
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.S(K);
            }
        });
    }

    void p0(boolean z7) {
        F("Attempting to force open the camera.");
        if (!this.f2438w.f(this)) {
            F("No cameras available. Waiting for available camera before opening camera.");
            i0(InternalState.PENDING_OPEN);
            return;
        }
        a0(z7);
    }

    void q0(boolean z7) {
        boolean z8;
        F("Attempting to open the camera.");
        if (this.f2437v.b() && this.f2438w.f(this)) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!z8) {
            F("No cameras available. Waiting for available camera before opening camera.");
            i0(InternalState.PENDING_OPEN);
            return;
        }
        a0(z7);
    }

    void r0() {
        SessionConfig.ValidatingBuilder d8 = this.f2421f.d();
        if (d8.f()) {
            this.f2428m.b0(d8.c().l());
            d8.a(this.f2428m.y());
            this.f2433r.f(d8.c());
            return;
        }
        this.f2428m.Y();
        this.f2433r.f(this.f2428m.y());
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.f2430o.a());
    }
}
