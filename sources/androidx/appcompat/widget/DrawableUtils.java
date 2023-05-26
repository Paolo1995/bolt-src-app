package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class DrawableUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1968a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1969b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f1970c = new Rect();

    /* loaded from: classes.dex */
    static class Api18Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final boolean f1971a;

        /* renamed from: b  reason: collision with root package name */
        private static final Method f1972b;

        /* renamed from: c  reason: collision with root package name */
        private static final Field f1973c;

        /* renamed from: d  reason: collision with root package name */
        private static final Field f1974d;

        /* renamed from: e  reason: collision with root package name */
        private static final Field f1975e;

        /* renamed from: f  reason: collision with root package name */
        private static final Field f1976f;

        /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.NoSuchFieldException -> L44 java.lang.ClassNotFoundException -> L49 java.lang.NoSuchMethodException -> L4e
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch: java.lang.NoSuchFieldException -> L44 java.lang.ClassNotFoundException -> L49 java.lang.NoSuchMethodException -> L4e
                java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch: java.lang.NoSuchFieldException -> L44 java.lang.ClassNotFoundException -> L49 java.lang.NoSuchMethodException -> L4e
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3e java.lang.NoSuchMethodException -> L41
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch: java.lang.NoSuchFieldException -> L32 java.lang.ClassNotFoundException -> L35 java.lang.NoSuchMethodException -> L38
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch: java.lang.Throwable -> L2f
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch: java.lang.Throwable -> L2d
                r8 = 1
                goto L55
            L2d:
                goto L53
            L2f:
                r7 = r2
                goto L53
            L32:
                r6 = r2
                goto L52
            L35:
                r6 = r2
                goto L52
            L38:
                r6 = r2
                goto L52
            L3b:
                r5 = r2
                goto L47
            L3e:
                r5 = r2
                goto L4c
            L41:
                r5 = r2
                goto L51
            L44:
                r4 = r2
                r5 = r4
            L47:
                r6 = r5
                goto L52
            L49:
                r4 = r2
                r5 = r4
            L4c:
                r6 = r5
                goto L52
            L4e:
                r4 = r2
                r5 = r4
            L51:
                r6 = r5
            L52:
                r7 = r6
            L53:
                r3 = r2
                r8 = 0
            L55:
                if (r8 == 0) goto L64
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1972b = r4
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1973c = r5
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1974d = r6
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1975e = r7
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1976f = r3
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1971a = r0
                goto L70
            L64:
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1972b = r2
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1973c = r2
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1974d = r2
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1975e = r2
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1976f = r2
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1971a = r1
            L70:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DrawableUtils.Api18Impl.<clinit>():void");
        }

        private Api18Impl() {
        }

        @NonNull
        static Rect a(@NonNull Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f1971a) {
                try {
                    Object invoke = f1972b.invoke(drawable, new Object[0]);
                    if (invoke != null) {
                        return new Rect(f1973c.getInt(invoke), f1974d.getInt(invoke), f1975e.getInt(invoke), f1976f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return DrawableUtils.f1970c;
        }
    }

    /* loaded from: classes.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static Insets a(Drawable drawable) {
            Insets opticalInsets;
            opticalInsets = drawable.getOpticalInsets();
            return opticalInsets;
        }
    }

    private DrawableUtils() {
    }

    public static boolean a(@NonNull Drawable drawable) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(@NonNull Drawable drawable) {
        String name = drawable.getClass().getName();
        int i8 = Build.VERSION.SDK_INT;
        if (i8 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            c(drawable);
        } else if (i8 >= 29 && i8 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            c(drawable);
        }
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state != null && state.length != 0) {
            drawable.setState(f1969b);
        } else {
            drawable.setState(f1968a);
        }
        drawable.setState(state);
    }

    @NonNull
    public static Rect d(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 29) {
            Insets a8 = Api29Impl.a(drawable);
            return new Rect(a8.left, a8.top, a8.right, a8.bottom);
        }
        return Api18Impl.a(DrawableCompat.q(drawable));
    }

    public static PorterDuff.Mode e(int i8, PorterDuff.Mode mode) {
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
}
