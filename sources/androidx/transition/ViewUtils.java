package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewUtilsBase f7885a;

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Float> f7886b;

    /* renamed from: c  reason: collision with root package name */
    static final Property<View, Rect> f7887c;

    static {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            f7885a = new ViewUtilsApi29();
        } else if (i8 >= 23) {
            f7885a = new ViewUtilsApi23();
        } else if (i8 >= 22) {
            f7885a = new ViewUtilsApi22();
        } else {
            f7885a = new ViewUtilsApi21();
        }
        f7886b = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.ViewUtils.1
            @Override // android.util.Property
            /* renamed from: a */
            public Float get(View view) {
                return Float.valueOf(ViewUtils.c(view));
            }

            @Override // android.util.Property
            /* renamed from: b */
            public void set(View view, Float f8) {
                ViewUtils.g(view, f8.floatValue());
            }
        };
        f7887c = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.ViewUtils.2
            @Override // android.util.Property
            /* renamed from: a */
            public Rect get(View view) {
                return ViewCompat.w(view);
            }

            @Override // android.util.Property
            /* renamed from: b */
            public void set(View view, Rect rect) {
                ViewCompat.z0(view, rect);
            }
        };
    }

    private ViewUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull View view) {
        f7885a.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewOverlayImpl b(@NonNull View view) {
        return new ViewOverlayApi18(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(@NonNull View view) {
        return f7885a.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WindowIdImpl d(@NonNull View view) {
        return new WindowIdApi18(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(@NonNull View view) {
        f7885a.d(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(@NonNull View view, int i8, int i9, int i10, int i11) {
        f7885a.e(view, i8, i9, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(@NonNull View view, float f8) {
        f7885a.f(view, f8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(@NonNull View view, int i8) {
        f7885a.g(view, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(@NonNull View view, @NonNull Matrix matrix) {
        f7885a.h(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(@NonNull View view, @NonNull Matrix matrix) {
        f7885a.i(view, matrix);
    }
}
