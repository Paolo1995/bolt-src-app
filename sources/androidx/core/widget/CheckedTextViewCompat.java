package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class CheckedTextViewCompat {

    /* loaded from: classes.dex */
    private static class Api16Impl {
        private Api16Impl() {
        }

        static Drawable a(@NonNull CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    /* loaded from: classes.dex */
    private static class Api21Impl {
        private Api21Impl() {
        }

        static void a(@NonNull CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void b(@NonNull CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    private CheckedTextViewCompat() {
    }

    public static Drawable a(@NonNull CheckedTextView checkedTextView) {
        return Api16Impl.a(checkedTextView);
    }

    public static void b(@NonNull CheckedTextView checkedTextView, ColorStateList colorStateList) {
        Api21Impl.a(checkedTextView, colorStateList);
    }

    public static void c(@NonNull CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        Api21Impl.b(checkedTextView, mode);
    }
}
