package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class PathInterpolatorCompat {

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static PathInterpolator a(float f8, float f9) {
            return new PathInterpolator(f8, f9);
        }

        static PathInterpolator b(float f8, float f9, float f10, float f11) {
            return new PathInterpolator(f8, f9, f10, f11);
        }

        static PathInterpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator a(float f8, float f9, float f10, float f11) {
        return Api21Impl.b(f8, f9, f10, f11);
    }

    @NonNull
    public static Interpolator b(@NonNull Path path) {
        return Api21Impl.c(path);
    }
}
