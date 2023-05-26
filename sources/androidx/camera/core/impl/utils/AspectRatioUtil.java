package androidx.camera.core.impl.utils;

import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.core.util.Preconditions;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class AspectRatioUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Rational f3754a = new Rational(4, 3);

    /* renamed from: b  reason: collision with root package name */
    public static final Rational f3755b = new Rational(3, 4);

    /* renamed from: c  reason: collision with root package name */
    public static final Rational f3756c = new Rational(16, 9);

    /* renamed from: d  reason: collision with root package name */
    public static final Rational f3757d = new Rational(9, 16);

    /* loaded from: classes.dex */
    public static final class CompareAspectRatiosByDistanceToTargetRatio implements Comparator<Rational> {

        /* renamed from: f  reason: collision with root package name */
        private Rational f3758f;

        public CompareAspectRatiosByDistanceToTargetRatio(@NonNull Rational rational) {
            this.f3758f = rational;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Rational rational, Rational rational2) {
            if (rational.equals(rational2)) {
                return 0;
            }
            return (int) Math.signum(Float.valueOf(Math.abs(rational.floatValue() - this.f3758f.floatValue())).floatValue() - Float.valueOf(Math.abs(rational2.floatValue() - this.f3758f.floatValue())).floatValue());
        }
    }

    private AspectRatioUtil() {
    }

    public static boolean a(@NonNull Size size, Rational rational) {
        if (rational == null) {
            return false;
        }
        if (rational.equals(new Rational(size.getWidth(), size.getHeight()))) {
            return true;
        }
        if (SizeUtil.a(size) < SizeUtil.a(SizeUtil.f3938b)) {
            return false;
        }
        return b(size, rational);
    }

    private static boolean b(@NonNull Size size, @NonNull Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rational2 = new Rational(rational.getDenominator(), rational.getNumerator());
        int i8 = width % 16;
        if (i8 == 0 && height % 16 == 0) {
            if (!c(Math.max(0, height - 16), width, rational) && !c(Math.max(0, width - 16), height, rational2)) {
                return false;
            }
            return true;
        } else if (i8 == 0) {
            return c(height, width, rational);
        } else {
            if (height % 16 != 0) {
                return false;
            }
            return c(width, height, rational2);
        }
    }

    private static boolean c(int i8, int i9, Rational rational) {
        boolean z7;
        if (i9 % 16 == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.a(z7);
        double numerator = (i8 * rational.getNumerator()) / rational.getDenominator();
        if (numerator > Math.max(0, i9 - 16) && numerator < i9 + 16) {
            return true;
        }
        return false;
    }
}
