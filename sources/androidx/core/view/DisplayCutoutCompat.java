package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import java.util.List;

/* loaded from: classes.dex */
public final class DisplayCutoutCompat {

    /* renamed from: a  reason: collision with root package name */
    private final DisplayCutout f5936a;

    /* loaded from: classes.dex */
    static class Api28Impl {
        private Api28Impl() {
        }

        static DisplayCutout a(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        static List<Rect> b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        static int e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        static int f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    private DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.f5936a = displayCutout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayCutoutCompat e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new DisplayCutoutCompat(displayCutout);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.c(this.f5936a);
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.d(this.f5936a);
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.e(this.f5936a);
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.f(this.f5936a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DisplayCutoutCompat.class == obj.getClass()) {
            return ObjectsCompat.a(this.f5936a, ((DisplayCutoutCompat) obj).f5936a);
        }
        return false;
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f5936a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    @NonNull
    public String toString() {
        return "DisplayCutoutCompat{" + this.f5936a + "}";
    }
}
