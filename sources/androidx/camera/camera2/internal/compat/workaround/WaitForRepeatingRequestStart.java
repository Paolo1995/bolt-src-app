package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WaitForRepeatingRequestStart {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2910a;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final ListenableFuture<Void> f2912c;

    /* renamed from: d  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Void> f2913d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2914e;

    /* renamed from: b  reason: collision with root package name */
    private final Object f2911b = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final CameraCaptureSession.CaptureCallback f2915f = new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart.1
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i8) {
            CallbackToFutureAdapter.Completer<Void> completer = WaitForRepeatingRequestStart.this.f2913d;
            if (completer != null) {
                completer.d();
                WaitForRepeatingRequestStart.this.f2913d = null;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j8, long j9) {
            CallbackToFutureAdapter.Completer<Void> completer = WaitForRepeatingRequestStart.this.f2913d;
            if (completer != null) {
                completer.c(null);
                WaitForRepeatingRequestStart.this.f2913d = null;
            }
        }
    };

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface OpenCaptureSession {
        @NonNull
        ListenableFuture<Void> a(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat, @NonNull List<DeferrableSurface> list);
    }

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface SingleRepeatingRequest {
        int a(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;
    }

    public WaitForRepeatingRequestStart(@NonNull Quirks quirks) {
        this.f2910a = quirks.a(CaptureSessionStuckQuirk.class);
        if (i()) {
            this.f2912c = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: d.a
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object a(CallbackToFutureAdapter.Completer completer) {
                    Object d8;
                    d8 = WaitForRepeatingRequestStart.this.d(completer);
                    return d8;
                }
            });
        } else {
            this.f2912c = Futures.h(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.f2913d = completer;
        return "WaitForRepeatingRequestStart[" + this + "]";
    }

    @NonNull
    public ListenableFuture<Void> c() {
        return Futures.j(this.f2912c);
    }

    public void f() {
        synchronized (this.f2911b) {
            if (i() && !this.f2914e) {
                this.f2912c.cancel(true);
            }
        }
    }

    @NonNull
    public ListenableFuture<Void> g(@NonNull final CameraDevice cameraDevice, @NonNull final SessionConfigurationCompat sessionConfigurationCompat, @NonNull final List<DeferrableSurface> list, @NonNull List<SynchronizedCaptureSession> list2, @NonNull final OpenCaptureSession openCaptureSession) {
        ArrayList arrayList = new ArrayList();
        for (SynchronizedCaptureSession synchronizedCaptureSession : list2) {
            arrayList.add(synchronizedCaptureSession.l());
        }
        return FutureChain.a(Futures.n(arrayList)).e(new AsyncFunction() { // from class: d.b
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                ListenableFuture a8;
                List list3 = (List) obj;
                a8 = WaitForRepeatingRequestStart.OpenCaptureSession.this.a(cameraDevice, sessionConfigurationCompat, list);
                return a8;
            }
        }, CameraXExecutors.a());
    }

    public int h(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback, @NonNull SingleRepeatingRequest singleRepeatingRequest) throws CameraAccessException {
        int a8;
        synchronized (this.f2911b) {
            if (i()) {
                captureCallback = Camera2CaptureCallbacks.b(this.f2915f, captureCallback);
                this.f2914e = true;
            }
            a8 = singleRepeatingRequest.a(captureRequest, captureCallback);
        }
        return a8;
    }

    public boolean i() {
        return this.f2910a;
    }
}
