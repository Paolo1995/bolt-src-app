package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class WindowCompat {

    /* loaded from: classes.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static void a(@NonNull Window window, boolean z7) {
            int i8;
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z7) {
                i8 = systemUiVisibility & (-1793);
            } else {
                i8 = systemUiVisibility | 1792;
            }
            decorView.setSystemUiVisibility(i8);
        }
    }

    /* loaded from: classes.dex */
    static class Api30Impl {
        private Api30Impl() {
        }

        static void a(@NonNull Window window, boolean z7) {
            window.setDecorFitsSystemWindows(z7);
        }
    }

    private WindowCompat() {
    }

    @NonNull
    public static WindowInsetsControllerCompat a(@NonNull Window window, @NonNull View view) {
        return new WindowInsetsControllerCompat(window, view);
    }

    public static void b(@NonNull Window window, boolean z7) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(window, z7);
        } else {
            Api16Impl.a(window, z7);
        }
    }
}
