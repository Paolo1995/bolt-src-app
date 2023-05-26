package androidx.camera.core.impl.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public class TransformUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final RectF f3820a = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);

    private TransformUtils() {
    }

    @NonNull
    public static Matrix a(@NonNull Rect rect) {
        return b(new RectF(rect));
    }

    @NonNull
    public static Matrix b(@NonNull RectF rectF) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(f3820a, rectF, Matrix.ScaleToFit.FILL);
        return matrix;
    }

    @NonNull
    public static Matrix c(@NonNull RectF rectF, @NonNull RectF rectF2, int i8) {
        return d(rectF, rectF2, i8, false);
    }

    @NonNull
    public static Matrix d(@NonNull RectF rectF, @NonNull RectF rectF2, int i8, boolean z7) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, f3820a, Matrix.ScaleToFit.FILL);
        matrix.postRotate(i8);
        if (z7) {
            matrix.postScale(-1.0f, 1.0f);
        }
        matrix.postConcat(b(rectF2));
        return matrix;
    }

    public static boolean e(@NonNull Rect rect, @NonNull Size size) {
        if (rect.left == 0 && rect.top == 0 && rect.width() == size.getWidth() && rect.height() == size.getHeight()) {
            return false;
        }
        return true;
    }

    public static boolean f(int i8) {
        if (i8 != 90 && i8 != 270) {
            if (i8 != 0 && i8 != 180) {
                throw new IllegalArgumentException("Invalid rotation degrees: " + i8);
            }
            return false;
        }
        return true;
    }

    public static boolean g(@NonNull Size size, boolean z7, @NonNull Size size2, boolean z8) {
        float width;
        float width2;
        float width3;
        float f8;
        if (z7) {
            width = size.getWidth() / size.getHeight();
            width2 = width;
        } else {
            width = (size.getWidth() + 1.0f) / (size.getHeight() - 1.0f);
            width2 = (size.getWidth() - 1.0f) / (size.getHeight() + 1.0f);
        }
        if (z8) {
            width3 = size2.getWidth() / size2.getHeight();
            f8 = width3;
        } else {
            float width4 = (size2.getWidth() + 1.0f) / (size2.getHeight() - 1.0f);
            width3 = (size2.getWidth() - 1.0f) / (size2.getHeight() + 1.0f);
            f8 = width4;
        }
        if (width >= width3 && f8 >= width2) {
            return true;
        }
        return false;
    }

    @NonNull
    public static Size h(@NonNull Rect rect) {
        return new Size(rect.width(), rect.height());
    }

    @NonNull
    public static Size i(@NonNull Size size) {
        return new Size(size.getHeight(), size.getWidth());
    }

    @NonNull
    public static Size j(@NonNull Size size, int i8) {
        boolean z7;
        if (i8 % 90 == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.b(z7, "Invalid rotation degrees: " + i8);
        if (f(p(i8))) {
            return i(size);
        }
        return size;
    }

    @NonNull
    public static Rect k(@NonNull Size size) {
        return l(size, 0, 0);
    }

    @NonNull
    public static Rect l(@NonNull Size size, int i8, int i9) {
        return new Rect(i8, i9, size.getWidth() + i8, size.getHeight() + i9);
    }

    @NonNull
    public static RectF m(@NonNull Size size) {
        return n(size, 0, 0);
    }

    @NonNull
    public static RectF n(@NonNull Size size, int i8, int i9) {
        return new RectF(i8, i9, i8 + size.getWidth(), i9 + size.getHeight());
    }

    @NonNull
    public static Matrix o(@NonNull Matrix matrix, @NonNull Rect rect) {
        Matrix matrix2 = new Matrix(matrix);
        matrix2.postTranslate(-rect.left, -rect.top);
        return matrix2;
    }

    public static int p(int i8) {
        return ((i8 % 360) + 360) % 360;
    }
}
