package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes.dex */
public final class CameraCaptureCallbacks$ComboCameraCaptureCallback extends CameraCaptureCallback {

    /* renamed from: a  reason: collision with root package name */
    private final List<CameraCaptureCallback> f3549a;

    @Override // androidx.camera.core.impl.CameraCaptureCallback
    public void a() {
        for (CameraCaptureCallback cameraCaptureCallback : this.f3549a) {
            cameraCaptureCallback.a();
        }
    }

    @Override // androidx.camera.core.impl.CameraCaptureCallback
    public void b(@NonNull CameraCaptureResult cameraCaptureResult) {
        for (CameraCaptureCallback cameraCaptureCallback : this.f3549a) {
            cameraCaptureCallback.b(cameraCaptureResult);
        }
    }

    @Override // androidx.camera.core.impl.CameraCaptureCallback
    public void c(@NonNull CameraCaptureFailure cameraCaptureFailure) {
        for (CameraCaptureCallback cameraCaptureCallback : this.f3549a) {
            cameraCaptureCallback.c(cameraCaptureFailure);
        }
    }

    @NonNull
    public List<CameraCaptureCallback> d() {
        return this.f3549a;
    }
}
