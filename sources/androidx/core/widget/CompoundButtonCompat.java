package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class CompoundButtonCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Field f6116a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6117b;

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static ColorStateList a(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        static PorterDuff.Mode b(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    /* loaded from: classes.dex */
    static class Api23Impl {
        private Api23Impl() {
        }

        static Drawable a(CompoundButton compoundButton) {
            Drawable buttonDrawable;
            buttonDrawable = compoundButton.getButtonDrawable();
            return buttonDrawable;
        }
    }

    private CompoundButtonCompat() {
    }

    public static Drawable a(@NonNull CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(compoundButton);
        }
        if (!f6117b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f6116a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e8);
            }
            f6117b = true;
        }
        Field field = f6116a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e9) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e9);
                f6116a = null;
            }
        }
        return null;
    }

    public static ColorStateList b(@NonNull CompoundButton compoundButton) {
        return Api21Impl.a(compoundButton);
    }

    public static PorterDuff.Mode c(@NonNull CompoundButton compoundButton) {
        return Api21Impl.b(compoundButton);
    }

    public static void d(@NonNull CompoundButton compoundButton, ColorStateList colorStateList) {
        Api21Impl.c(compoundButton, colorStateList);
    }

    public static void e(@NonNull CompoundButton compoundButton, PorterDuff.Mode mode) {
        Api21Impl.d(compoundButton, mode);
    }
}
