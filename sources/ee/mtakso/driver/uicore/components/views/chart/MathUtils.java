package ee.mtakso.driver.uicore.components.views.chart;

/* compiled from: MathUtils.kt */
/* loaded from: classes5.dex */
public final class MathUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final MathUtils f35546a = new MathUtils();

    private MathUtils() {
    }

    private final int c(int i8) {
        if (i8 == 0) {
            return 0;
        }
        return i8 < 0 ? -1 : 1;
    }

    public final int a(int i8, int i9) {
        int i10;
        int i11 = 0;
        if (i8 == 0) {
            return 0;
        }
        int abs = Math.abs(i8);
        int abs2 = Math.abs(i9);
        int c8 = c(i8);
        int b8 = b(abs);
        if (b8 == 0) {
            if (abs % 2 == 0) {
                i10 = abs + 2;
            } else {
                i10 = abs + 1;
            }
            return c8 * i10;
        }
        for (int pow = (int) Math.pow(10.0d, b8); pow > 0; pow /= 10) {
            int i12 = (abs / pow) % 10;
            int i13 = ((i12 + 1) * pow) + i11;
            if (i13 - abs <= abs2) {
                return i13 * c8;
            }
            i11 += i12 * pow;
        }
        return i11 * c8;
    }

    public final int b(int i8) {
        int abs = Math.abs(i8) + 1;
        int i9 = 0;
        while (abs > 0) {
            abs /= 10;
            i9++;
        }
        return Math.max(i9 - 1, 0);
    }
}
