package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class GravityCompat {

    /* loaded from: classes.dex */
    static class Api17Impl {
        private Api17Impl() {
        }

        static void a(int i8, int i9, int i10, Rect rect, int i11, int i12, Rect rect2, int i13) {
            Gravity.apply(i8, i9, i10, rect, i11, i12, rect2, i13);
        }

        static void b(int i8, int i9, int i10, Rect rect, Rect rect2, int i11) {
            Gravity.apply(i8, i9, i10, rect, rect2, i11);
        }

        static void c(int i8, Rect rect, Rect rect2, int i9) {
            Gravity.applyDisplay(i8, rect, rect2, i9);
        }
    }

    private GravityCompat() {
    }

    public static void a(int i8, int i9, int i10, @NonNull Rect rect, @NonNull Rect rect2, int i11) {
        Api17Impl.b(i8, i9, i10, rect, rect2, i11);
    }

    public static int b(int i8, int i9) {
        return Gravity.getAbsoluteGravity(i8, i9);
    }
}
