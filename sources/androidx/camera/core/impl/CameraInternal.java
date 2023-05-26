package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import java.util.Collection;

/* loaded from: classes.dex */
public interface CameraInternal extends Camera, UseCase.StateChangeCallback {

    /* loaded from: classes.dex */
    public enum State {
        PENDING_OPEN(false),
        OPENING(true),
        OPEN(true),
        CLOSING(true),
        CLOSED(false),
        RELEASING(true),
        RELEASED(false);
        

        /* renamed from: f  reason: collision with root package name */
        private final boolean f3601f;

        State(boolean z7) {
            this.f3601f = z7;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.f3601f;
        }
    }

    @NonNull
    CameraControlInternal d();

    @NonNull
    CameraConfig e();

    void f(boolean z7);

    @NonNull
    CameraInfo g();

    void h(@NonNull Collection<UseCase> collection);

    void i(@NonNull Collection<UseCase> collection);

    @NonNull
    CameraInfoInternal j();

    void l(CameraConfig cameraConfig);

    @NonNull
    Observable<State> m();
}
