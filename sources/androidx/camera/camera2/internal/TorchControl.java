package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.FlashAvailabilityChecker;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class TorchControl {

    /* renamed from: a  reason: collision with root package name */
    private final Camera2CameraControlImpl f2710a;

    /* renamed from: b  reason: collision with root package name */
    private final MutableLiveData<Integer> f2711b = new MutableLiveData<>(0);

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2712c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f2713d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2714e;

    /* renamed from: f  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Void> f2715f;

    /* renamed from: g  reason: collision with root package name */
    boolean f2716g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TorchControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull Executor executor) {
        this.f2710a = camera2CameraControlImpl;
        this.f2713d = executor;
        this.f2712c = FlashAvailabilityChecker.c(cameraCharacteristicsCompat);
        camera2CameraControlImpl.s(new Camera2CameraControlImpl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.k1
            @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
            public final boolean a(TotalCaptureResult totalCaptureResult) {
                boolean i8;
                i8 = TorchControl.this.i(totalCaptureResult);
                return i8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object h(final boolean z7, final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.f2713d.execute(new Runnable() { // from class: androidx.camera.camera2.internal.l1
            @Override // java.lang.Runnable
            public final void run() {
                TorchControl.this.g(completer, z7);
            }
        });
        return "enableTorch: " + z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean i(TotalCaptureResult totalCaptureResult) {
        boolean z7;
        if (this.f2715f != null) {
            Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
            if (num != null && num.intValue() == 2) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 == this.f2716g) {
                this.f2715f.c(null);
                this.f2715f = null;
            }
        }
        return false;
    }

    private <T> void k(@NonNull MutableLiveData<T> mutableLiveData, T t7) {
        if (Threads.b()) {
            mutableLiveData.o(t7);
        } else {
            mutableLiveData.m(t7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenableFuture<Void> d(final boolean z7) {
        if (!this.f2712c) {
            Logger.a("TorchControl", "Unable to enableTorch due to there is no flash unit.");
            return Futures.f(new IllegalStateException("No flash unit"));
        }
        k(this.f2711b, Integer.valueOf(z7 ? 1 : 0));
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.j1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object h8;
                h8 = TorchControl.this.h(z7, completer);
                return h8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void g(CallbackToFutureAdapter.Completer<Void> completer, boolean z7) {
        if (!this.f2712c) {
            if (completer != null) {
                completer.f(new IllegalStateException("No flash unit"));
            }
        } else if (!this.f2714e) {
            k(this.f2711b, 0);
            if (completer != null) {
                completer.f(new CameraControl.OperationCanceledException("Camera is not active."));
            }
        } else {
            this.f2716g = z7;
            this.f2710a.v(z7);
            k(this.f2711b, Integer.valueOf(z7 ? 1 : 0));
            CallbackToFutureAdapter.Completer<Void> completer2 = this.f2715f;
            if (completer2 != null) {
                completer2.f(new CameraControl.OperationCanceledException("There is a new enableTorch being set"));
            }
            this.f2715f = completer;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public LiveData<Integer> f() {
        return this.f2711b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(boolean z7) {
        if (this.f2714e == z7) {
            return;
        }
        this.f2714e = z7;
        if (!z7) {
            if (this.f2716g) {
                this.f2716g = false;
                this.f2710a.v(false);
                k(this.f2711b, 0);
            }
            CallbackToFutureAdapter.Completer<Void> completer = this.f2715f;
            if (completer != null) {
                completer.f(new CameraControl.OperationCanceledException("Camera is not active."));
                this.f2715f = null;
            }
        }
    }
}
