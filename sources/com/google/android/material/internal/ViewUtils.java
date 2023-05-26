package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: classes.dex */
public class ViewUtils {

    /* loaded from: classes.dex */
    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding);
    }

    private ViewUtils() {
    }

    public static void a(View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void b(@NonNull View view, @NonNull final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        final RelativePadding relativePadding = new RelativePadding(ViewCompat.J(view), view.getPaddingTop(), ViewCompat.I(view), view.getPaddingBottom());
        ViewCompat.G0(view, new androidx.core.view.OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ViewUtils.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat a(View view2, WindowInsetsCompat windowInsetsCompat) {
                return OnApplyWindowInsetsListener.this.a(view2, windowInsetsCompat, new RelativePadding(relativePadding));
            }
        });
        j(view);
    }

    public static float c(@NonNull Context context, int i8) {
        return TypedValue.applyDimension(1, i8, context.getResources().getDisplayMetrics());
    }

    public static Integer d(@NonNull View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    public static float e(@NonNull View view) {
        float f8 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f8 += ViewCompat.y((View) parent);
        }
        return f8;
    }

    public static boolean f(View view) {
        if (ViewCompat.E(view) == 1) {
            return true;
        }
        return false;
    }

    public static PorterDuff.Mode g(int i8, PorterDuff.Mode mode) {
        if (i8 != 3) {
            if (i8 != 5) {
                if (i8 != 9) {
                    switch (i8) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static void h(View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            i(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void i(@NonNull ViewTreeObserver viewTreeObserver, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void j(@NonNull View view) {
        if (ViewCompat.V(view)) {
            ViewCompat.p0(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.internal.ViewUtils.4
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NonNull View view2) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewCompat.p0(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }
            });
        }
    }

    public static void k(@NonNull final View view) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.ViewUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
            }
        });
    }

    /* loaded from: classes.dex */
    public static class RelativePadding {

        /* renamed from: a  reason: collision with root package name */
        public int f13686a;

        /* renamed from: b  reason: collision with root package name */
        public int f13687b;

        /* renamed from: c  reason: collision with root package name */
        public int f13688c;

        /* renamed from: d  reason: collision with root package name */
        public int f13689d;

        public RelativePadding(int i8, int i9, int i10, int i11) {
            this.f13686a = i8;
            this.f13687b = i9;
            this.f13688c = i10;
            this.f13689d = i11;
        }

        public RelativePadding(@NonNull RelativePadding relativePadding) {
            this.f13686a = relativePadding.f13686a;
            this.f13687b = relativePadding.f13687b;
            this.f13688c = relativePadding.f13688c;
            this.f13689d = relativePadding.f13689d;
        }
    }
}
