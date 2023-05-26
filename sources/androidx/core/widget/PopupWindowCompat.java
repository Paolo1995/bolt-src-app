package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class PopupWindowCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f6141a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6142b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f6143c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f6144d;

    /* loaded from: classes.dex */
    static class Api19Impl {
        private Api19Impl() {
        }

        static void a(PopupWindow popupWindow, View view, int i8, int i9, int i10) {
            popupWindow.showAsDropDown(view, i8, i9, i10);
        }
    }

    /* loaded from: classes.dex */
    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean a(PopupWindow popupWindow) {
            boolean overlapAnchor;
            overlapAnchor = popupWindow.getOverlapAnchor();
            return overlapAnchor;
        }

        static int b(PopupWindow popupWindow) {
            int windowLayoutType;
            windowLayoutType = popupWindow.getWindowLayoutType();
            return windowLayoutType;
        }

        static void c(PopupWindow popupWindow, boolean z7) {
            popupWindow.setOverlapAnchor(z7);
        }

        static void d(PopupWindow popupWindow, int i8) {
            popupWindow.setWindowLayoutType(i8);
        }
    }

    private PopupWindowCompat() {
    }

    public static void a(@NonNull PopupWindow popupWindow, boolean z7) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.c(popupWindow, z7);
            return;
        }
        if (!f6144d) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f6143c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e8);
            }
            f6144d = true;
        }
        Field field = f6143c;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z7));
            } catch (IllegalAccessException e9) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e9);
            }
        }
    }

    public static void b(@NonNull PopupWindow popupWindow, int i8) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.d(popupWindow, i8);
            return;
        }
        if (!f6142b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f6141a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f6142b = true;
        }
        Method method = f6141a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i8));
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(@NonNull PopupWindow popupWindow, @NonNull View view, int i8, int i9, int i10) {
        Api19Impl.a(popupWindow, view, i8, i9, i10);
    }
}
