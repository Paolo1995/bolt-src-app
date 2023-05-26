package androidx.camera.core.internal;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ViewPorts {
    private ViewPorts() {
    }

    @NonNull
    public static Map<UseCase, Rect> a(@NonNull Rect rect, boolean z7, @NonNull Rational rational, int i8, int i9, int i10, @NonNull Map<UseCase, Size> map) {
        boolean z8;
        if (rect.width() > 0 && rect.height() > 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        Preconditions.b(z8, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        HashMap hashMap = new HashMap();
        RectF rectF2 = new RectF(rect);
        for (Map.Entry<UseCase, Size> entry : map.entrySet()) {
            Matrix matrix = new Matrix();
            RectF rectF3 = new RectF(0.0f, 0.0f, entry.getValue().getWidth(), entry.getValue().getHeight());
            matrix.setRectToRect(rectF3, rectF, Matrix.ScaleToFit.CENTER);
            hashMap.put(entry.getKey(), matrix);
            RectF rectF4 = new RectF();
            matrix.mapRect(rectF4, rectF3);
            rectF2.intersect(rectF4);
        }
        RectF g8 = g(rectF2, ImageUtil.d(i8, rational), i9, z7, i10, i8);
        HashMap hashMap2 = new HashMap();
        RectF rectF5 = new RectF();
        Matrix matrix2 = new Matrix();
        for (Map.Entry entry2 : hashMap.entrySet()) {
            ((Matrix) entry2.getValue()).invert(matrix2);
            matrix2.mapRect(rectF5, g8);
            Rect rect2 = new Rect();
            rectF5.round(rect2);
            hashMap2.put((UseCase) entry2.getKey(), rect2);
        }
        return hashMap2;
    }

    private static RectF b(boolean z7, int i8, RectF rectF, RectF rectF2) {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15 = true;
        if (i8 == 0 && !z7) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (i8 == 90 && z7) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (!z8 && !z9) {
            if (i8 == 0 && z7) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (i8 == 270 && !z7) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z10 && !z11) {
                if (i8 == 90 && !z7) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (i8 == 180 && z7) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z12 && !z13) {
                    if (i8 == 180 && !z7) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    z15 = (i8 == 270 && z7) ? false : false;
                    if (!z14 && !z15) {
                        throw new IllegalArgumentException("Invalid argument: mirrored " + z7 + " rotation " + i8);
                    }
                    return c(d(rectF2, rectF.centerY()), rectF.centerX());
                }
                return d(rectF2, rectF.centerY());
            }
            return c(rectF2, rectF.centerX());
        }
        return rectF2;
    }

    private static RectF c(RectF rectF, float f8) {
        return new RectF(e(rectF.right, f8), rectF.top, e(rectF.left, f8), rectF.bottom);
    }

    private static RectF d(RectF rectF, float f8) {
        return new RectF(rectF.left, f(rectF.bottom, f8), rectF.right, f(rectF.top, f8));
    }

    private static float e(float f8, float f9) {
        return (f9 + f9) - f8;
    }

    private static float f(float f8, float f9) {
        return (f9 + f9) - f8;
    }

    @NonNull
    @SuppressLint({"SwitchIntDef"})
    public static RectF g(@NonNull RectF rectF, @NonNull Rational rational, int i8, boolean z7, int i9, int i10) {
        if (i8 == 3) {
            return rectF;
        }
        Matrix matrix = new Matrix();
        RectF rectF2 = new RectF(0.0f, 0.0f, rational.getNumerator(), rational.getDenominator());
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.END);
                } else {
                    throw new IllegalStateException("Unexpected scale type: " + i8);
                }
            } else {
                matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.CENTER);
            }
        } else {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.START);
        }
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        return b(h(z7, i9), i10, rectF, rectF3);
    }

    private static boolean h(boolean z7, int i8) {
        return z7 ^ (i8 == 1);
    }
}
