package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.ApiCompat$Api23Impl;
import androidx.camera.camera2.internal.compat.ApiCompat$Api26Impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
final class SynchronizedCaptureSessionStateCallbacks extends SynchronizedCaptureSession.StateCallback {

    /* renamed from: a  reason: collision with root package name */
    private final List<SynchronizedCaptureSession.StateCallback> f2708a;

    SynchronizedCaptureSessionStateCallbacks(@NonNull List<SynchronizedCaptureSession.StateCallback> list) {
        ArrayList arrayList = new ArrayList();
        this.f2708a = arrayList;
        arrayList.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static SynchronizedCaptureSession.StateCallback u(@NonNull SynchronizedCaptureSession.StateCallback... stateCallbackArr) {
        return new SynchronizedCaptureSessionStateCallbacks(Arrays.asList(stateCallbackArr));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void m(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback stateCallback : this.f2708a) {
            stateCallback.m(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void n(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback stateCallback : this.f2708a) {
            stateCallback.n(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void o(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback stateCallback : this.f2708a) {
            stateCallback.o(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void p(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback stateCallback : this.f2708a) {
            stateCallback.p(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void q(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback stateCallback : this.f2708a) {
            stateCallback.q(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void r(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback stateCallback : this.f2708a) {
            stateCallback.r(synchronizedCaptureSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void s(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback stateCallback : this.f2708a) {
            stateCallback.s(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void t(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull Surface surface) {
        for (SynchronizedCaptureSession.StateCallback stateCallback : this.f2708a) {
            stateCallback.t(synchronizedCaptureSession, surface);
        }
    }

    /* loaded from: classes.dex */
    static class Adapter extends SynchronizedCaptureSession.StateCallback {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final CameraCaptureSession.StateCallback f2709a;

        Adapter(@NonNull CameraCaptureSession.StateCallback stateCallback) {
            this.f2709a = stateCallback;
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void m(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.f2709a.onActive(synchronizedCaptureSession.j().c());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void n(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            ApiCompat$Api26Impl.b(this.f2709a, synchronizedCaptureSession.j().c());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void o(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.f2709a.onClosed(synchronizedCaptureSession.j().c());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void p(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.f2709a.onConfigureFailed(synchronizedCaptureSession.j().c());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void q(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.f2709a.onConfigured(synchronizedCaptureSession.j().c());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void r(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.f2709a.onReady(synchronizedCaptureSession.j().c());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void s(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void t(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull Surface surface) {
            ApiCompat$Api23Impl.a(this.f2709a, synchronizedCaptureSession.j().c(), surface);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Adapter(@NonNull List<CameraCaptureSession.StateCallback> list) {
            this(CameraCaptureSessionStateCallbacks.a(list));
        }
    }
}
