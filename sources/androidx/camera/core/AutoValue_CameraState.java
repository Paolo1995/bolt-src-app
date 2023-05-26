package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraState;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_CameraState extends CameraState {

    /* renamed from: a  reason: collision with root package name */
    private final CameraState.Type f3029a;

    /* renamed from: b  reason: collision with root package name */
    private final CameraState.StateError f3030b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_CameraState(CameraState.Type type, CameraState.StateError stateError) {
        if (type != null) {
            this.f3029a = type;
            this.f3030b = stateError;
            return;
        }
        throw new NullPointerException("Null type");
    }

    @Override // androidx.camera.core.CameraState
    public CameraState.StateError c() {
        return this.f3030b;
    }

    @Override // androidx.camera.core.CameraState
    @NonNull
    public CameraState.Type d() {
        return this.f3029a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraState)) {
            return false;
        }
        CameraState cameraState = (CameraState) obj;
        if (this.f3029a.equals(cameraState.d())) {
            CameraState.StateError stateError = this.f3030b;
            if (stateError == null) {
                if (cameraState.c() == null) {
                    return true;
                }
            } else if (stateError.equals(cameraState.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (this.f3029a.hashCode() ^ 1000003) * 1000003;
        CameraState.StateError stateError = this.f3030b;
        if (stateError == null) {
            hashCode = 0;
        } else {
            hashCode = stateError.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public String toString() {
        return "CameraState{type=" + this.f3029a + ", error=" + this.f3030b + "}";
    }
}
