package androidx.camera.core;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface SurfaceOutput {

    /* loaded from: classes.dex */
    public static abstract class Event {
        @NonNull
        public static Event c(int i8, @NonNull SurfaceOutput surfaceOutput) {
            return new AutoValue_SurfaceOutput_Event(i8, surfaceOutput);
        }

        public abstract int a();

        @NonNull
        public abstract SurfaceOutput b();
    }

    /* loaded from: classes.dex */
    public enum GlTransformOptions {
        USE_SURFACE_TEXTURE_TRANSFORM,
        APPLY_CROP_ROTATE_AND_MIRRORING
    }

    int c();
}
