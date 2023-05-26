package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.workaround.MeteringRegionCorrection;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Quirks;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FocusMeteringControl {

    /* renamed from: v  reason: collision with root package name */
    private static final MeteringRectangle[] f2599v = new MeteringRectangle[0];

    /* renamed from: a  reason: collision with root package name */
    private final Camera2CameraControlImpl f2600a;

    /* renamed from: b  reason: collision with root package name */
    final Executor f2601b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f2602c;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final MeteringRegionCorrection f2605f;

    /* renamed from: i  reason: collision with root package name */
    private ScheduledFuture<?> f2608i;

    /* renamed from: j  reason: collision with root package name */
    private ScheduledFuture<?> f2609j;

    /* renamed from: q  reason: collision with root package name */
    private MeteringRectangle[] f2616q;

    /* renamed from: r  reason: collision with root package name */
    private MeteringRectangle[] f2617r;

    /* renamed from: s  reason: collision with root package name */
    private MeteringRectangle[] f2618s;

    /* renamed from: t  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Object> f2619t;

    /* renamed from: u  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Void> f2620u;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f2603d = false;

    /* renamed from: e  reason: collision with root package name */
    private volatile Rational f2604e = null;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2606g = false;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    Integer f2607h = 0;

    /* renamed from: k  reason: collision with root package name */
    long f2610k = 0;

    /* renamed from: l  reason: collision with root package name */
    boolean f2611l = false;

    /* renamed from: m  reason: collision with root package name */
    boolean f2612m = false;

    /* renamed from: n  reason: collision with root package name */
    private int f2613n = 1;

    /* renamed from: o  reason: collision with root package name */
    private Camera2CameraControlImpl.CaptureResultListener f2614o = null;

    /* renamed from: p  reason: collision with root package name */
    private Camera2CameraControlImpl.CaptureResultListener f2615p = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FocusMeteringControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Executor executor, @NonNull Quirks quirks) {
        MeteringRectangle[] meteringRectangleArr = f2599v;
        this.f2616q = meteringRectangleArr;
        this.f2617r = meteringRectangleArr;
        this.f2618s = meteringRectangleArr;
        this.f2619t = null;
        this.f2620u = null;
        this.f2600a = camera2CameraControlImpl;
        this.f2601b = executor;
        this.f2602c = scheduledExecutorService;
        this.f2605f = new MeteringRegionCorrection(quirks);
    }

    private void f() {
        ScheduledFuture<?> scheduledFuture = this.f2609j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f2609j = null;
        }
    }

    private void g() {
        CallbackToFutureAdapter.Completer<Void> completer = this.f2620u;
        if (completer != null) {
            completer.c(null);
            this.f2620u = null;
        }
    }

    private void h() {
        ScheduledFuture<?> scheduledFuture = this.f2608i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f2608i = null;
        }
    }

    private void i(String str) {
        this.f2600a.W(this.f2614o);
        CallbackToFutureAdapter.Completer<Object> completer = this.f2619t;
        if (completer != null) {
            completer.f(new CameraControl.OperationCanceledException(str));
            this.f2619t = null;
        }
    }

    private void j(String str) {
        this.f2600a.W(this.f2615p);
        CallbackToFutureAdapter.Completer<Void> completer = this.f2620u;
        if (completer != null) {
            completer.f(new CameraControl.OperationCanceledException(str));
            this.f2620u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean l(int i8, long j8, TotalCaptureResult totalCaptureResult) {
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)).intValue() == i8 && Camera2CameraControlImpl.K(totalCaptureResult, j8)) {
            g();
            return true;
        }
        return false;
    }

    private boolean p() {
        if (this.f2616q.length > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@NonNull Camera2ImplConfig.Builder builder) {
        int k8;
        if (this.f2606g) {
            k8 = 1;
        } else {
            k8 = k();
        }
        builder.e(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.f2600a.B(k8)));
        MeteringRectangle[] meteringRectangleArr = this.f2616q;
        if (meteringRectangleArr.length != 0) {
            builder.e(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
        }
        MeteringRectangle[] meteringRectangleArr2 = this.f2617r;
        if (meteringRectangleArr2.length != 0) {
            builder.e(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2);
        }
        MeteringRectangle[] meteringRectangleArr3 = this.f2618s;
        if (meteringRectangleArr3.length != 0) {
            builder.e(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z7, boolean z8) {
        if (!this.f2603d) {
            return;
        }
        CaptureConfig.Builder builder = new CaptureConfig.Builder();
        builder.q(true);
        builder.p(this.f2613n);
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        if (z7) {
            builder2.e(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        }
        if (Build.VERSION.SDK_INT >= 23 && z8) {
            builder2.e(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
        }
        builder.e(builder2.c());
        this.f2600a.d0(Collections.singletonList(builder.h()));
    }

    void d(CallbackToFutureAdapter.Completer<Void> completer) {
        j("Cancelled by another cancelFocusAndMetering()");
        i("Cancelled by cancelFocusAndMetering()");
        this.f2620u = completer;
        h();
        f();
        if (p()) {
            c(true, false);
        }
        MeteringRectangle[] meteringRectangleArr = f2599v;
        this.f2616q = meteringRectangleArr;
        this.f2617r = meteringRectangleArr;
        this.f2618s = meteringRectangleArr;
        this.f2606g = false;
        final long g02 = this.f2600a.g0();
        if (this.f2620u != null) {
            final int B = this.f2600a.B(k());
            Camera2CameraControlImpl.CaptureResultListener captureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.u0
                @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
                public final boolean a(TotalCaptureResult totalCaptureResult) {
                    boolean l8;
                    l8 = FocusMeteringControl.this.l(B, g02, totalCaptureResult);
                    return l8;
                }
            };
            this.f2615p = captureResultListener;
            this.f2600a.s(captureResultListener);
        }
    }

    void e() {
        d(null);
    }

    int k() {
        if (this.f2613n == 3) {
            return 3;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z7) {
        if (z7 == this.f2603d) {
            return;
        }
        this.f2603d = z7;
        if (!this.f2603d) {
            e();
        }
    }

    public void n(Rational rational) {
        this.f2604e = rational;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i8) {
        this.f2613n = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final CallbackToFutureAdapter.Completer<Void> completer) {
        if (!this.f2603d) {
            if (completer != null) {
                completer.f(new CameraControl.OperationCanceledException("Camera is not active."));
                return;
            }
            return;
        }
        CaptureConfig.Builder builder = new CaptureConfig.Builder();
        builder.p(this.f2613n);
        builder.q(true);
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.e(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        builder.e(builder2.c());
        builder.c(new CameraCaptureCallback() { // from class: androidx.camera.camera2.internal.FocusMeteringControl.2
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void a() {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.f(new CameraControl.OperationCanceledException("Camera is closed"));
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void b(@NonNull CameraCaptureResult cameraCaptureResult) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.c(null);
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void c(@NonNull CameraCaptureFailure cameraCaptureFailure) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.f(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
                }
            }
        });
        this.f2600a.d0(Collections.singletonList(builder.h()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final CallbackToFutureAdapter.Completer<CameraCaptureResult> completer, boolean z7) {
        if (!this.f2603d) {
            if (completer != null) {
                completer.f(new CameraControl.OperationCanceledException("Camera is not active."));
                return;
            }
            return;
        }
        CaptureConfig.Builder builder = new CaptureConfig.Builder();
        builder.p(this.f2613n);
        builder.q(true);
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.e(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        if (z7) {
            builder2.e(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(this.f2600a.A(1)));
        }
        builder.e(builder2.c());
        builder.c(new CameraCaptureCallback() { // from class: androidx.camera.camera2.internal.FocusMeteringControl.1
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void a() {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.f(new CameraControl.OperationCanceledException("Camera is closed"));
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void b(@NonNull CameraCaptureResult cameraCaptureResult) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.c(cameraCaptureResult);
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void c(@NonNull CameraCaptureFailure cameraCaptureFailure) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.f(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
                }
            }
        });
        this.f2600a.d0(Collections.singletonList(builder.h()));
    }
}
