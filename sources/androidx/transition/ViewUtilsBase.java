package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class ViewUtilsBase {

    /* renamed from: a  reason: collision with root package name */
    private static Method f7893a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f7894b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f7895c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f7896d;

    @SuppressLint({"PrivateApi"})
    private void b() {
        if (!f7894b) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                f7893a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e8) {
                Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e8);
            }
            f7894b = true;
        }
    }

    public void a(@NonNull View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R$id.f7825a, null);
        }
    }

    public float c(@NonNull View view) {
        Float f8 = (Float) view.getTag(R$id.f7825a);
        if (f8 != null) {
            return view.getAlpha() / f8.floatValue();
        }
        return view.getAlpha();
    }

    public void d(@NonNull View view) {
        int i8 = R$id.f7825a;
        if (view.getTag(i8) == null) {
            view.setTag(i8, Float.valueOf(view.getAlpha()));
        }
    }

    public void e(@NonNull View view, int i8, int i9, int i10, int i11) {
        b();
        Method method = f7893a;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e8) {
                throw new RuntimeException(e8.getCause());
            }
        }
    }

    public void f(@NonNull View view, float f8) {
        Float f9 = (Float) view.getTag(R$id.f7825a);
        if (f9 != null) {
            view.setAlpha(f9.floatValue() * f8);
        } else {
            view.setAlpha(f8);
        }
    }

    public void g(@NonNull View view, int i8) {
        if (!f7896d) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f7895c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f7896d = true;
        }
        Field field = f7895c;
        if (field != null) {
            try {
                f7895c.setInt(view, i8 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void h(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            h(view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void i(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            i(view2, matrix);
            matrix.postTranslate(view2.getScrollX(), view2.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }
}
