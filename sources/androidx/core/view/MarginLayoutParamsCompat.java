package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class MarginLayoutParamsCompat {

    /* loaded from: classes.dex */
    static class Api17Impl {
        private Api17Impl() {
        }

        static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i8) {
            marginLayoutParams.resolveLayoutDirection(i8);
        }

        static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i8) {
            marginLayoutParams.setLayoutDirection(i8);
        }

        static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i8) {
            marginLayoutParams.setMarginEnd(i8);
        }

        static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i8) {
            marginLayoutParams.setMarginStart(i8);
        }
    }

    private MarginLayoutParamsCompat() {
    }

    public static int a(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Api17Impl.b(marginLayoutParams);
    }

    public static int b(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Api17Impl.c(marginLayoutParams);
    }

    public static void c(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i8) {
        Api17Impl.g(marginLayoutParams, i8);
    }

    public static void d(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i8) {
        Api17Impl.h(marginLayoutParams, i8);
    }
}
