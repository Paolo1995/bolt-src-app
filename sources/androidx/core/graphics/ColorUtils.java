package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ColorUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<double[]> f5735a = new ThreadLocal<>();

    private ColorUtils() {
    }

    public static void a(int i8, int i9, int i10, @NonNull double[] dArr) {
        double pow;
        double pow2;
        double pow3;
        if (dArr.length == 3) {
            double d8 = i8 / 255.0d;
            if (d8 < 0.04045d) {
                pow = d8 / 12.92d;
            } else {
                pow = Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
            }
            double d9 = i9 / 255.0d;
            if (d9 < 0.04045d) {
                pow2 = d9 / 12.92d;
            } else {
                pow2 = Math.pow((d9 + 0.055d) / 1.055d, 2.4d);
            }
            double d10 = i10 / 255.0d;
            if (d10 < 0.04045d) {
                pow3 = d10 / 12.92d;
            } else {
                pow3 = Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
            }
            dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
            dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
            dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int b(double d8, double d9, double d10) {
        double d11;
        double d12;
        double d13;
        double d14 = (((3.2406d * d8) + ((-1.5372d) * d9)) + ((-0.4986d) * d10)) / 100.0d;
        double d15 = ((((-0.9689d) * d8) + (1.8758d * d9)) + (0.0415d * d10)) / 100.0d;
        double d16 = (((0.0557d * d8) + ((-0.204d) * d9)) + (1.057d * d10)) / 100.0d;
        if (d14 > 0.0031308d) {
            d11 = (Math.pow(d14, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d11 = d14 * 12.92d;
        }
        if (d15 > 0.0031308d) {
            d12 = (Math.pow(d15, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d12 = d15 * 12.92d;
        }
        if (d16 > 0.0031308d) {
            d13 = (Math.pow(d16, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d13 = d16 * 12.92d;
        }
        return Color.rgb(h((int) Math.round(d11 * 255.0d), 0, 255), h((int) Math.round(d12 * 255.0d), 0, 255), h((int) Math.round(d13 * 255.0d), 0, 255));
    }

    public static double c(int i8) {
        double[] i9 = i();
        d(i8, i9);
        return i9[1] / 100.0d;
    }

    public static void d(int i8, @NonNull double[] dArr) {
        a(Color.red(i8), Color.green(i8), Color.blue(i8), dArr);
    }

    private static int e(int i8, int i9) {
        return 255 - (((255 - i9) * (255 - i8)) / 255);
    }

    public static int f(int i8, int i9) {
        int alpha = Color.alpha(i9);
        int alpha2 = Color.alpha(i8);
        int e8 = e(alpha2, alpha);
        return Color.argb(e8, g(Color.red(i8), alpha2, Color.red(i9), alpha, e8), g(Color.green(i8), alpha2, Color.green(i9), alpha, e8), g(Color.blue(i8), alpha2, Color.blue(i9), alpha, e8));
    }

    private static int g(int i8, int i9, int i10, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        return (((i8 * 255) * i9) + ((i10 * i11) * (255 - i9))) / (i12 * 255);
    }

    private static int h(int i8, int i9, int i10) {
        if (i8 >= i9) {
            return Math.min(i8, i10);
        }
        return i9;
    }

    private static double[] i() {
        ThreadLocal<double[]> threadLocal = f5735a;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            threadLocal.set(dArr2);
            return dArr2;
        }
        return dArr;
    }

    public static int j(int i8, int i9) {
        if (i9 >= 0 && i9 <= 255) {
            return (i8 & 16777215) | (i9 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
