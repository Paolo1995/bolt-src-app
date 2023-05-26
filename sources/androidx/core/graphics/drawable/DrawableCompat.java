package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class DrawableCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f5768a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5769b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f5770c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f5771d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        static int a(Drawable drawable) {
            return drawable.getAlpha();
        }

        static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i8) {
            return drawableContainerState.getChild(i8);
        }

        static Drawable c(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }

        static boolean d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        static void e(Drawable drawable, boolean z7) {
            drawable.setAutoMirrored(z7);
        }
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void e(Drawable drawable, float f8, float f9) {
            drawable.setHotspot(f8, f9);
        }

        static void f(Drawable drawable, int i8, int i9, int i10, int i11) {
            drawable.setHotspotBounds(i8, i9, i10, i11);
        }

        static void g(Drawable drawable, int i8) {
            drawable.setTint(i8);
        }

        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    /* loaded from: classes.dex */
    static class Api23Impl {
        private Api23Impl() {
        }

        static int a(Drawable drawable) {
            int layoutDirection;
            layoutDirection = drawable.getLayoutDirection();
            return layoutDirection;
        }

        static boolean b(Drawable drawable, int i8) {
            boolean layoutDirection;
            layoutDirection = drawable.setLayoutDirection(i8);
            return layoutDirection;
        }
    }

    private DrawableCompat() {
    }

    public static void a(@NonNull Drawable drawable, @NonNull Resources.Theme theme) {
        Api21Impl.a(drawable, theme);
    }

    public static boolean b(@NonNull Drawable drawable) {
        return Api21Impl.b(drawable);
    }

    public static void c(@NonNull Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            c(Api19Impl.c((InsetDrawable) drawable));
        } else if (drawable instanceof WrappedDrawable) {
            c(((WrappedDrawable) drawable).a());
        } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
            int childCount = drawableContainerState.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                Drawable b8 = Api19Impl.b(drawableContainerState, i8);
                if (b8 != null) {
                    c(b8);
                }
            }
        }
    }

    public static int d(@NonNull Drawable drawable) {
        return Api19Impl.a(drawable);
    }

    public static ColorFilter e(@NonNull Drawable drawable) {
        return Api21Impl.c(drawable);
    }

    public static int f(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(drawable);
        }
        if (!f5771d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f5770c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e8) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e8);
            }
            f5771d = true;
        }
        Method method = f5770c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e9) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e9);
                f5770c = null;
            }
        }
        return 0;
    }

    public static void g(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Api21Impl.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean h(@NonNull Drawable drawable) {
        return Api19Impl.d(drawable);
    }

    @Deprecated
    public static void i(@NonNull Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(@NonNull Drawable drawable, boolean z7) {
        Api19Impl.e(drawable, z7);
    }

    public static void k(@NonNull Drawable drawable, float f8, float f9) {
        Api21Impl.e(drawable, f8, f9);
    }

    public static void l(@NonNull Drawable drawable, int i8, int i9, int i10, int i11) {
        Api21Impl.f(drawable, i8, i9, i10, i11);
    }

    public static boolean m(@NonNull Drawable drawable, int i8) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(drawable, i8);
        }
        if (!f5769b) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f5768a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e8) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e8);
            }
            f5769b = true;
        }
        Method method = f5768a;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i8));
                return true;
            } catch (Exception e9) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e9);
                f5768a = null;
            }
        }
        return false;
    }

    public static void n(@NonNull Drawable drawable, int i8) {
        Api21Impl.g(drawable, i8);
    }

    public static void o(@NonNull Drawable drawable, ColorStateList colorStateList) {
        Api21Impl.h(drawable, colorStateList);
    }

    public static void p(@NonNull Drawable drawable, PorterDuff.Mode mode) {
        Api21Impl.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T q(@NonNull Drawable drawable) {
        if (drawable instanceof WrappedDrawable) {
            return (T) ((WrappedDrawable) drawable).a();
        }
        return drawable;
    }

    @NonNull
    public static Drawable r(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable;
        }
        if (!(drawable instanceof TintAwareDrawable)) {
            return new WrappedDrawableApi21(drawable);
        }
        return drawable;
    }
}
