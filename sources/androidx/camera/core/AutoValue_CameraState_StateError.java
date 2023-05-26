package androidx.camera.core;

import androidx.camera.core.CameraState;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_CameraState_StateError extends CameraState.StateError {

    /* renamed from: a  reason: collision with root package name */
    private final int f3031a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f3032b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_CameraState_StateError(int i8, Throwable th) {
        this.f3031a = i8;
        this.f3032b = th;
    }

    @Override // androidx.camera.core.CameraState.StateError
    public Throwable c() {
        return this.f3032b;
    }

    @Override // androidx.camera.core.CameraState.StateError
    public int d() {
        return this.f3031a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraState.StateError)) {
            return false;
        }
        CameraState.StateError stateError = (CameraState.StateError) obj;
        if (this.f3031a == stateError.d()) {
            Throwable th = this.f3032b;
            if (th == null) {
                if (stateError.c() == null) {
                    return true;
                }
            } else if (th.equals(stateError.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i8 = (this.f3031a ^ 1000003) * 1000003;
        Throwable th = this.f3032b;
        if (th == null) {
            hashCode = 0;
        } else {
            hashCode = th.hashCode();
        }
        return i8 ^ hashCode;
    }

    public String toString() {
        return "StateError{code=" + this.f3031a + ", cause=" + this.f3032b + "}";
    }
}
