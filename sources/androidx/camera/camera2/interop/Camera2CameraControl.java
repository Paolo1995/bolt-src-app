package androidx.camera.camera2.interop;

import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class Camera2CameraControl {

    /* renamed from: c  reason: collision with root package name */
    private final Camera2CameraControlImpl f3014c;

    /* renamed from: d  reason: collision with root package name */
    final Executor f3015d;

    /* renamed from: g  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Void> f3018g;

    /* renamed from: a  reason: collision with root package name */
    private boolean f3012a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3013b = false;

    /* renamed from: e  reason: collision with root package name */
    final Object f3016e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private Camera2ImplConfig.Builder f3017f = new Camera2ImplConfig.Builder();

    /* renamed from: h  reason: collision with root package name */
    private final Camera2CameraControlImpl.CaptureResultListener f3019h = new Camera2CameraControlImpl.CaptureResultListener() { // from class: e.d
        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        public final boolean a(TotalCaptureResult totalCaptureResult) {
            boolean q8;
            q8 = Camera2CameraControl.this.q(totalCaptureResult);
            return q8;
        }
    };

    public Camera2CameraControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull Executor executor) {
        this.f3014c = camera2CameraControlImpl;
        this.f3015d = executor;
    }

    private void h(@NonNull CaptureRequestOptions captureRequestOptions) {
        synchronized (this.f3016e) {
            for (Config.Option option : captureRequestOptions.c()) {
                this.f3017f.a().o(option, captureRequestOptions.a(option));
            }
        }
    }

    private void j() {
        synchronized (this.f3016e) {
            this.f3017f = new Camera2ImplConfig.Builder();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.f3015d.execute(new Runnable() { // from class: e.e
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControl.this.m(completer);
            }
        });
        return "addCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.f3015d.execute(new Runnable() { // from class: e.f
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControl.this.o(completer);
            }
        });
        return "clearCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ boolean q(android.hardware.camera2.TotalCaptureResult r3) {
        /*
            r2 = this;
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r0 = r2.f3018g
            r1 = 0
            if (r0 == 0) goto L32
            android.hardware.camera2.CaptureRequest r3 = r3.getRequest()
            java.lang.Object r3 = r3.getTag()
            boolean r0 = r3 instanceof androidx.camera.core.impl.TagBundle
            if (r0 == 0) goto L32
            androidx.camera.core.impl.TagBundle r3 = (androidx.camera.core.impl.TagBundle) r3
            java.lang.String r0 = "Camera2CameraControl"
            java.lang.Object r3 = r3.c(r0)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L32
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r0 = r2.f3018g
            int r0 = r0.hashCode()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r3 = r2.f3018g
            r2.f3018g = r1
            goto L33
        L32:
            r3 = r1
        L33:
            if (r3 == 0) goto L38
            r3.c(r1)
        L38:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.interop.Camera2CameraControl.q(android.hardware.camera2.TotalCaptureResult):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void r(boolean z7) {
        if (this.f3012a == z7) {
            return;
        }
        this.f3012a = z7;
        if (z7) {
            if (this.f3013b) {
                v();
                return;
            }
            return;
        }
        CallbackToFutureAdapter.Completer<Void> completer = this.f3018g;
        if (completer != null) {
            completer.f(new CameraControl.OperationCanceledException("The camera control has became inactive."));
            this.f3018g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void o(CallbackToFutureAdapter.Completer<Void> completer) {
        this.f3013b = true;
        CallbackToFutureAdapter.Completer<Void> completer2 = this.f3018g;
        if (completer2 == null) {
            completer2 = null;
        }
        this.f3018g = completer;
        if (this.f3012a) {
            v();
        }
        if (completer2 != null) {
            completer2.f(new CameraControl.OperationCanceledException("Camera2CameraControl was updated with new options."));
        }
    }

    private void v() {
        this.f3014c.e0();
        this.f3013b = false;
    }

    @NonNull
    public ListenableFuture<Void> g(@NonNull CaptureRequestOptions captureRequestOptions) {
        h(captureRequestOptions);
        return Futures.j(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: e.c
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object n8;
                n8 = Camera2CameraControl.this.n(completer);
                return n8;
            }
        }));
    }

    @NonNull
    public ListenableFuture<Void> i() {
        j();
        return Futures.j(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: e.b
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object p8;
                p8 = Camera2CameraControl.this.p(completer);
                return p8;
            }
        }));
    }

    @NonNull
    public Camera2ImplConfig k() {
        Camera2ImplConfig c8;
        synchronized (this.f3016e) {
            if (this.f3018g != null) {
                this.f3017f.a().o(Camera2ImplConfig.H, Integer.valueOf(this.f3018g.hashCode()));
            }
            c8 = this.f3017f.c();
        }
        return c8;
    }

    @NonNull
    public Camera2CameraControlImpl.CaptureResultListener l() {
        return this.f3019h;
    }

    public void s(final boolean z7) {
        this.f3015d.execute(new Runnable() { // from class: e.a
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControl.this.r(z7);
            }
        });
    }
}
