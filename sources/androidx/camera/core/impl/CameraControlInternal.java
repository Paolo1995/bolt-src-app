package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public interface CameraControlInternal extends CameraControl {

    /* renamed from: a  reason: collision with root package name */
    public static final CameraControlInternal f3591a = new CameraControlInternal() { // from class: androidx.camera.core.impl.CameraControlInternal.1
        @Override // androidx.camera.core.impl.CameraControlInternal
        public void a(@NonNull SessionConfig.Builder builder) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        @NonNull
        public ListenableFuture<List<Void>> b(@NonNull List<CaptureConfig> list, int i8, int i9) {
            return Futures.h(Collections.emptyList());
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        @NonNull
        public Rect c() {
            return new Rect();
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void d(int i8) {
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public ListenableFuture<Void> e(boolean z7) {
            return Futures.h(null);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        @NonNull
        public Config f() {
            return null;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void g(@NonNull Config config) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void h() {
        }
    };

    /* loaded from: classes.dex */
    public static final class CameraControlException extends Exception {
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private CameraCaptureFailure f3592f;

        public CameraControlException(@NonNull CameraCaptureFailure cameraCaptureFailure) {
            this.f3592f = cameraCaptureFailure;
        }
    }

    /* loaded from: classes.dex */
    public interface ControlUpdateCallback {
        void a();

        void b(@NonNull List<CaptureConfig> list);
    }

    void a(@NonNull SessionConfig.Builder builder);

    @NonNull
    ListenableFuture<List<Void>> b(@NonNull List<CaptureConfig> list, int i8, int i9);

    @NonNull
    Rect c();

    void d(int i8);

    @NonNull
    Config f();

    void g(@NonNull Config config);

    void h();
}
