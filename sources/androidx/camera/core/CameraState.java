package androidx.camera.core;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class CameraState {

    /* loaded from: classes.dex */
    public static abstract class StateError {
        @NonNull
        public static StateError a(int i8) {
            return b(i8, null);
        }

        @NonNull
        public static StateError b(int i8, Throwable th) {
            return new AutoValue_CameraState_StateError(i8, th);
        }

        public abstract Throwable c();

        public abstract int d();
    }

    /* loaded from: classes.dex */
    public enum Type {
        PENDING_OPEN,
        OPENING,
        OPEN,
        CLOSING,
        CLOSED
    }

    @NonNull
    public static CameraState a(@NonNull Type type) {
        return b(type, null);
    }

    @NonNull
    public static CameraState b(@NonNull Type type, StateError stateError) {
        return new AutoValue_CameraState(type, stateError);
    }

    public abstract StateError c();

    @NonNull
    public abstract Type d();
}
