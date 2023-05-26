package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.OverrideAeModeForStillCapture;
import androidx.camera.camera2.internal.compat.workaround.UseTorchAsFlash;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResults;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Camera2CapturePipeline {

    /* renamed from: g  reason: collision with root package name */
    private static final Set<CameraCaptureMetaData$AfState> f2486g = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData$AfState.PASSIVE_FOCUSED, CameraCaptureMetaData$AfState.PASSIVE_NOT_FOCUSED, CameraCaptureMetaData$AfState.LOCKED_FOCUSED, CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED));

    /* renamed from: h  reason: collision with root package name */
    private static final Set<CameraCaptureMetaData$AwbState> f2487h = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData$AwbState.CONVERGED, CameraCaptureMetaData$AwbState.UNKNOWN));

    /* renamed from: i  reason: collision with root package name */
    private static final Set<CameraCaptureMetaData$AeState> f2488i;

    /* renamed from: j  reason: collision with root package name */
    private static final Set<CameraCaptureMetaData$AeState> f2489j;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Camera2CameraControlImpl f2490a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final UseTorchAsFlash f2491b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Quirks f2492c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Executor f2493d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2494e;

    /* renamed from: f  reason: collision with root package name */
    private int f2495f = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AePreCaptureTask implements PipelineTask {

        /* renamed from: a  reason: collision with root package name */
        private final Camera2CameraControlImpl f2496a;

        /* renamed from: b  reason: collision with root package name */
        private final OverrideAeModeForStillCapture f2497b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2498c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2499d = false;

        AePreCaptureTask(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, int i8, @NonNull OverrideAeModeForStillCapture overrideAeModeForStillCapture) {
            this.f2496a = camera2CameraControlImpl;
            this.f2498c = i8;
            this.f2497b = overrideAeModeForStillCapture;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object f(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.f2496a.x().q(completer);
            this.f2497b.b();
            return "AePreCapture";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean g(Void r02) {
            return Boolean.TRUE;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        @NonNull
        public ListenableFuture<Boolean> a(TotalCaptureResult totalCaptureResult) {
            if (Camera2CapturePipeline.b(this.f2498c, totalCaptureResult)) {
                Logger.a("Camera2CapturePipeline", "Trigger AE");
                this.f2499d = true;
                return FutureChain.a(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.b0
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object a(CallbackToFutureAdapter.Completer completer) {
                        Object f8;
                        f8 = Camera2CapturePipeline.AePreCaptureTask.this.f(completer);
                        return f8;
                    }
                })).d(new Function() { // from class: androidx.camera.camera2.internal.c0
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        Boolean g8;
                        g8 = Camera2CapturePipeline.AePreCaptureTask.g((Void) obj);
                        return g8;
                    }
                }, CameraXExecutors.a());
            }
            return Futures.h(Boolean.FALSE);
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public boolean b() {
            if (this.f2498c == 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public void c() {
            if (this.f2499d) {
                Logger.a("Camera2CapturePipeline", "cancel TriggerAePreCapture");
                this.f2496a.x().c(false, true);
                this.f2497b.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AfTask implements PipelineTask {

        /* renamed from: a  reason: collision with root package name */
        private final Camera2CameraControlImpl f2500a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2501b = false;

        AfTask(@NonNull Camera2CameraControlImpl camera2CameraControlImpl) {
            this.f2500a = camera2CameraControlImpl;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        @NonNull
        public ListenableFuture<Boolean> a(TotalCaptureResult totalCaptureResult) {
            ListenableFuture<Boolean> h8 = Futures.h(Boolean.TRUE);
            if (totalCaptureResult == null) {
                return h8;
            }
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
            if (num == null) {
                return h8;
            }
            int intValue = num.intValue();
            if (intValue == 1 || intValue == 2) {
                Logger.a("Camera2CapturePipeline", "TriggerAf? AF mode auto");
                Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num2 != null && num2.intValue() == 0) {
                    Logger.a("Camera2CapturePipeline", "Trigger AF");
                    this.f2501b = true;
                    this.f2500a.x().r(null, false);
                }
            }
            return h8;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public boolean b() {
            return true;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public void c() {
            if (this.f2501b) {
                Logger.a("Camera2CapturePipeline", "cancel TriggerAF");
                this.f2500a.x().c(true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Pipeline {

        /* renamed from: i  reason: collision with root package name */
        private static final long f2502i;

        /* renamed from: j  reason: collision with root package name */
        private static final long f2503j;

        /* renamed from: a  reason: collision with root package name */
        private final int f2504a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f2505b;

        /* renamed from: c  reason: collision with root package name */
        private final Camera2CameraControlImpl f2506c;

        /* renamed from: d  reason: collision with root package name */
        private final OverrideAeModeForStillCapture f2507d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f2508e;

        /* renamed from: f  reason: collision with root package name */
        private long f2509f = f2502i;

        /* renamed from: g  reason: collision with root package name */
        final List<PipelineTask> f2510g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        private final PipelineTask f2511h = new AnonymousClass1();

        /* renamed from: androidx.camera.camera2.internal.Camera2CapturePipeline$Pipeline$1  reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements PipelineTask {
            AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ Boolean e(List list) {
                return Boolean.valueOf(list.contains(Boolean.TRUE));
            }

            @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
            @NonNull
            public ListenableFuture<Boolean> a(TotalCaptureResult totalCaptureResult) {
                ArrayList arrayList = new ArrayList();
                for (PipelineTask pipelineTask : Pipeline.this.f2510g) {
                    arrayList.add(pipelineTask.a(totalCaptureResult));
                }
                return Futures.o(Futures.c(arrayList), new Function() { // from class: androidx.camera.camera2.internal.j0
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        Boolean e8;
                        e8 = Camera2CapturePipeline.Pipeline.AnonymousClass1.e((List) obj);
                        return e8;
                    }
                }, CameraXExecutors.a());
            }

            @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
            public boolean b() {
                for (PipelineTask pipelineTask : Pipeline.this.f2510g) {
                    if (pipelineTask.b()) {
                        return true;
                    }
                }
                return false;
            }

            @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
            public void c() {
                for (PipelineTask pipelineTask : Pipeline.this.f2510g) {
                    pipelineTask.c();
                }
            }
        }

        static {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            f2502i = timeUnit.toNanos(1L);
            f2503j = timeUnit.toNanos(5L);
        }

        Pipeline(int i8, @NonNull Executor executor, @NonNull Camera2CameraControlImpl camera2CameraControlImpl, boolean z7, @NonNull OverrideAeModeForStillCapture overrideAeModeForStillCapture) {
            this.f2504a = i8;
            this.f2505b = executor;
            this.f2506c = camera2CameraControlImpl;
            this.f2508e = z7;
            this.f2507d = overrideAeModeForStillCapture;
        }

        private void g(@NonNull CaptureConfig.Builder builder) {
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.e(CaptureRequest.CONTROL_AE_MODE, 3);
            builder.e(builder2.c());
        }

        private void h(@NonNull CaptureConfig.Builder builder, @NonNull CaptureConfig captureConfig) {
            int i8;
            if (this.f2504a == 3 && !this.f2508e) {
                i8 = 4;
            } else if (captureConfig.g() != -1 && captureConfig.g() != 5) {
                i8 = -1;
            } else {
                i8 = 2;
            }
            if (i8 != -1) {
                builder.p(i8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ListenableFuture j(int i8, TotalCaptureResult totalCaptureResult) throws Exception {
            if (Camera2CapturePipeline.b(i8, totalCaptureResult)) {
                o(f2503j);
            }
            return this.f2511h.a(totalCaptureResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ListenableFuture l(Boolean bool) throws Exception {
            if (Boolean.TRUE.equals(bool)) {
                return Camera2CapturePipeline.f(this.f2509f, this.f2506c, new ResultListener.Checker() { // from class: androidx.camera.camera2.internal.i0
                    @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.ResultListener.Checker
                    public final boolean a(TotalCaptureResult totalCaptureResult) {
                        boolean a8;
                        a8 = Camera2CapturePipeline.a(totalCaptureResult, false);
                        return a8;
                    }
                });
            }
            return Futures.h(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ListenableFuture m(List list, int i8, TotalCaptureResult totalCaptureResult) throws Exception {
            return p(list, i8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object n(CaptureConfig.Builder builder, final CallbackToFutureAdapter.Completer completer) throws Exception {
            builder.c(new CameraCaptureCallback() { // from class: androidx.camera.camera2.internal.Camera2CapturePipeline.Pipeline.2
                @Override // androidx.camera.core.impl.CameraCaptureCallback
                public void a() {
                    completer.f(new ImageCaptureException(3, "Capture request is cancelled because camera is closed", null));
                }

                @Override // androidx.camera.core.impl.CameraCaptureCallback
                public void b(@NonNull CameraCaptureResult cameraCaptureResult) {
                    completer.c(null);
                }

                @Override // androidx.camera.core.impl.CameraCaptureCallback
                public void c(@NonNull CameraCaptureFailure cameraCaptureFailure) {
                    completer.f(new ImageCaptureException(2, "Capture request failed with reason " + cameraCaptureFailure.a(), null));
                }
            });
            return "submitStillCapture";
        }

        private void o(long j8) {
            this.f2509f = j8;
        }

        void f(@NonNull PipelineTask pipelineTask) {
            this.f2510g.add(pipelineTask);
        }

        @NonNull
        ListenableFuture<List<Void>> i(@NonNull final List<CaptureConfig> list, final int i8) {
            ListenableFuture<TotalCaptureResult> h8;
            ListenableFuture h9 = Futures.h(null);
            if (!this.f2510g.isEmpty()) {
                if (this.f2511h.b()) {
                    h8 = Camera2CapturePipeline.f(0L, this.f2506c, null);
                } else {
                    h8 = Futures.h(null);
                }
                h9 = FutureChain.a(h8).e(new AsyncFunction() { // from class: androidx.camera.camera2.internal.d0
                    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                    public final ListenableFuture apply(Object obj) {
                        ListenableFuture j8;
                        j8 = Camera2CapturePipeline.Pipeline.this.j(i8, (TotalCaptureResult) obj);
                        return j8;
                    }
                }, this.f2505b).e(new AsyncFunction() { // from class: androidx.camera.camera2.internal.e0
                    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                    public final ListenableFuture apply(Object obj) {
                        ListenableFuture l8;
                        l8 = Camera2CapturePipeline.Pipeline.this.l((Boolean) obj);
                        return l8;
                    }
                }, this.f2505b);
            }
            FutureChain e8 = FutureChain.a(h9).e(new AsyncFunction() { // from class: androidx.camera.camera2.internal.f0
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    ListenableFuture m8;
                    m8 = Camera2CapturePipeline.Pipeline.this.m(list, i8, (TotalCaptureResult) obj);
                    return m8;
                }
            }, this.f2505b);
            final PipelineTask pipelineTask = this.f2511h;
            Objects.requireNonNull(pipelineTask);
            e8.f(new Runnable() { // from class: androidx.camera.camera2.internal.g0
                @Override // java.lang.Runnable
                public final void run() {
                    Camera2CapturePipeline.PipelineTask.this.c();
                }
            }, this.f2505b);
            return e8;
        }

        @NonNull
        ListenableFuture<List<Void>> p(@NonNull List<CaptureConfig> list, int i8) {
            boolean z7;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (CaptureConfig captureConfig : list) {
                final CaptureConfig.Builder k8 = CaptureConfig.Builder.k(captureConfig);
                CameraCaptureResult cameraCaptureResult = null;
                if (captureConfig.g() == 5 && !this.f2506c.G().g() && !this.f2506c.G().b()) {
                    ImageProxy e8 = this.f2506c.G().e();
                    if (e8 != null && this.f2506c.G().f(e8)) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        cameraCaptureResult = CameraCaptureResults.a(e8.O0());
                    }
                }
                if (cameraCaptureResult != null) {
                    k8.n(cameraCaptureResult);
                } else {
                    h(k8, captureConfig);
                }
                if (this.f2507d.c(i8)) {
                    g(k8);
                }
                arrayList.add(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.h0
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object a(CallbackToFutureAdapter.Completer completer) {
                        Object n8;
                        n8 = Camera2CapturePipeline.Pipeline.this.n(k8, completer);
                        return n8;
                    }
                }));
                arrayList2.add(k8.h());
            }
            this.f2506c.d0(arrayList2);
            return Futures.c(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface PipelineTask {
        @NonNull
        ListenableFuture<Boolean> a(TotalCaptureResult totalCaptureResult);

        boolean b();

        void c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ResultListener implements Camera2CameraControlImpl.CaptureResultListener {

        /* renamed from: a  reason: collision with root package name */
        private CallbackToFutureAdapter.Completer<TotalCaptureResult> f2515a;

        /* renamed from: c  reason: collision with root package name */
        private final long f2517c;

        /* renamed from: d  reason: collision with root package name */
        private final Checker f2518d;

        /* renamed from: b  reason: collision with root package name */
        private final ListenableFuture<TotalCaptureResult> f2516b = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.k0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object d8;
                d8 = Camera2CapturePipeline.ResultListener.this.d(completer);
                return d8;
            }
        });

        /* renamed from: e  reason: collision with root package name */
        private volatile Long f2519e = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface Checker {
            boolean a(@NonNull TotalCaptureResult totalCaptureResult);
        }

        ResultListener(long j8, Checker checker) {
            this.f2517c = j8;
            this.f2518d = checker;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object d(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.f2515a = completer;
            return "waitFor3AResult";
        }

        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        public boolean a(@NonNull TotalCaptureResult totalCaptureResult) {
            Long l8 = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
            if (l8 != null && this.f2519e == null) {
                this.f2519e = l8;
            }
            Long l9 = this.f2519e;
            if (0 != this.f2517c && l9 != null && l8 != null && l8.longValue() - l9.longValue() > this.f2517c) {
                this.f2515a.c(null);
                Logger.a("Camera2CapturePipeline", "Wait for capture result timeout, current:" + l8 + " first: " + l9);
                return true;
            }
            Checker checker = this.f2518d;
            if (checker != null && !checker.a(totalCaptureResult)) {
                return false;
            }
            this.f2515a.c(totalCaptureResult);
            return true;
        }

        @NonNull
        public ListenableFuture<TotalCaptureResult> c() {
            return this.f2516b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TorchTask implements PipelineTask {

        /* renamed from: e  reason: collision with root package name */
        private static final long f2520e = TimeUnit.SECONDS.toNanos(2);

        /* renamed from: a  reason: collision with root package name */
        private final Camera2CameraControlImpl f2521a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2522b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2523c = false;

        /* renamed from: d  reason: collision with root package name */
        private final Executor f2524d;

        TorchTask(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, int i8, @NonNull Executor executor) {
            this.f2521a = camera2CameraControlImpl;
            this.f2522b = i8;
            this.f2524d = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object h(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.f2521a.D().g(completer, true);
            return "TorchOn";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ListenableFuture j(Void r42) throws Exception {
            return Camera2CapturePipeline.f(f2520e, this.f2521a, new ResultListener.Checker() { // from class: androidx.camera.camera2.internal.o0
                @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.ResultListener.Checker
                public final boolean a(TotalCaptureResult totalCaptureResult) {
                    boolean a8;
                    a8 = Camera2CapturePipeline.a(totalCaptureResult, true);
                    return a8;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean k(TotalCaptureResult totalCaptureResult) {
            return Boolean.FALSE;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        @NonNull
        public ListenableFuture<Boolean> a(TotalCaptureResult totalCaptureResult) {
            if (Camera2CapturePipeline.b(this.f2522b, totalCaptureResult)) {
                if (this.f2521a.L()) {
                    Logger.a("Camera2CapturePipeline", "Torch already on, not turn on");
                } else {
                    Logger.a("Camera2CapturePipeline", "Turn on torch");
                    this.f2523c = true;
                    return FutureChain.a(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.l0
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object a(CallbackToFutureAdapter.Completer completer) {
                            Object h8;
                            h8 = Camera2CapturePipeline.TorchTask.this.h(completer);
                            return h8;
                        }
                    })).e(new AsyncFunction() { // from class: androidx.camera.camera2.internal.m0
                        @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                        public final ListenableFuture apply(Object obj) {
                            ListenableFuture j8;
                            j8 = Camera2CapturePipeline.TorchTask.this.j((Void) obj);
                            return j8;
                        }
                    }, this.f2524d).d(new Function() { // from class: androidx.camera.camera2.internal.n0
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            Boolean k8;
                            k8 = Camera2CapturePipeline.TorchTask.k((TotalCaptureResult) obj);
                            return k8;
                        }
                    }, CameraXExecutors.a());
                }
            }
            return Futures.h(Boolean.FALSE);
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public boolean b() {
            if (this.f2522b == 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public void c() {
            if (this.f2523c) {
                this.f2521a.D().g(null, false);
                Logger.a("Camera2CapturePipeline", "Turn off torch");
            }
        }
    }

    static {
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState = CameraCaptureMetaData$AeState.CONVERGED;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState2 = CameraCaptureMetaData$AeState.FLASH_REQUIRED;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState3 = CameraCaptureMetaData$AeState.UNKNOWN;
        Set<CameraCaptureMetaData$AeState> unmodifiableSet = Collections.unmodifiableSet(EnumSet.of(cameraCaptureMetaData$AeState, cameraCaptureMetaData$AeState2, cameraCaptureMetaData$AeState3));
        f2488i = unmodifiableSet;
        EnumSet copyOf = EnumSet.copyOf((Collection) unmodifiableSet);
        copyOf.remove(cameraCaptureMetaData$AeState2);
        copyOf.remove(cameraCaptureMetaData$AeState3);
        f2489j = Collections.unmodifiableSet(copyOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Camera2CapturePipeline(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull Quirks quirks, @NonNull Executor executor) {
        boolean z7 = true;
        this.f2490a = camera2CameraControlImpl;
        Integer num = (Integer) cameraCharacteristicsCompat.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        this.f2494e = (num == null || num.intValue() != 2) ? false : false;
        this.f2493d = executor;
        this.f2492c = quirks;
        this.f2491b = new UseTorchAsFlash(quirks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(TotalCaptureResult totalCaptureResult, boolean z7) {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        if (totalCaptureResult == null) {
            return false;
        }
        Camera2CameraCaptureResult camera2CameraCaptureResult = new Camera2CameraCaptureResult(totalCaptureResult);
        if (camera2CameraCaptureResult.i() != CameraCaptureMetaData$AfMode.OFF && camera2CameraCaptureResult.i() != CameraCaptureMetaData$AfMode.UNKNOWN && !f2486g.contains(camera2CameraCaptureResult.f())) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE)).intValue() == 0) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (!z7 ? !(z9 || f2488i.contains(camera2CameraCaptureResult.h())) : !(z9 || f2489j.contains(camera2CameraCaptureResult.h()))) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_MODE)).intValue() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 && !f2487h.contains(camera2CameraCaptureResult.g())) {
            z12 = false;
        } else {
            z12 = true;
        }
        Logger.a("Camera2CapturePipeline", "checkCaptureResult, AE=" + camera2CameraCaptureResult.h() + " AF =" + camera2CameraCaptureResult.f() + " AWB=" + camera2CameraCaptureResult.g());
        if (!z8 || !z10 || !z12) {
            return false;
        }
        return true;
    }

    static boolean b(int i8, TotalCaptureResult totalCaptureResult) {
        Integer num;
        if (i8 != 0) {
            if (i8 == 1) {
                return true;
            }
            if (i8 == 2) {
                return false;
            }
            throw new AssertionError(i8);
        }
        if (totalCaptureResult != null) {
            num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        } else {
            num = null;
        }
        if (num == null || num.intValue() != 4) {
            return false;
        }
        return true;
    }

    private boolean c(int i8) {
        if (this.f2491b.a() || this.f2495f == 3 || i8 == 1) {
            return true;
        }
        return false;
    }

    @NonNull
    static ListenableFuture<TotalCaptureResult> f(long j8, @NonNull Camera2CameraControlImpl camera2CameraControlImpl, ResultListener.Checker checker) {
        ResultListener resultListener = new ResultListener(j8, checker);
        camera2CameraControlImpl.s(resultListener);
        return resultListener.c();
    }

    public void d(int i8) {
        this.f2495f = i8;
    }

    @NonNull
    public ListenableFuture<List<Void>> e(@NonNull List<CaptureConfig> list, int i8, int i9, int i10) {
        OverrideAeModeForStillCapture overrideAeModeForStillCapture = new OverrideAeModeForStillCapture(this.f2492c);
        Pipeline pipeline = new Pipeline(this.f2495f, this.f2493d, this.f2490a, this.f2494e, overrideAeModeForStillCapture);
        if (i8 == 0) {
            pipeline.f(new AfTask(this.f2490a));
        }
        if (c(i10)) {
            pipeline.f(new TorchTask(this.f2490a, i9, this.f2493d));
        } else {
            pipeline.f(new AePreCaptureTask(this.f2490a, i9, overrideAeModeForStillCapture));
        }
        return Futures.j(pipeline.i(list, i9));
    }
}
