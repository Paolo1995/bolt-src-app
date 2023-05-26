package androidx.appcompat.app;

/* loaded from: classes.dex */
class TwilightCalculator {

    /* renamed from: d  reason: collision with root package name */
    private static TwilightCalculator f1292d;

    /* renamed from: a  reason: collision with root package name */
    public long f1293a;

    /* renamed from: b  reason: collision with root package name */
    public long f1294b;

    /* renamed from: c  reason: collision with root package name */
    public int f1295c;

    TwilightCalculator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TwilightCalculator b() {
        if (f1292d == null) {
            f1292d = new TwilightCalculator();
        }
        return f1292d;
    }

    public void a(long j8, double d8, double d9) {
        float f8;
        float f9;
        double d10;
        double d11 = (0.01720197f * (((float) (j8 - 946728000000L)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(d11) * 0.03341960161924362d) + d11 + (Math.sin(2.0f * f9) * 3.4906598739326E-4d) + (Math.sin(f9 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double round = ((float) Math.round((f8 - 9.0E-4f) - d10)) + 9.0E-4f + ((-d9) / 360.0d) + (Math.sin(d11) * 0.0053d) + (Math.sin(2.0d * sin) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d12 = 0.01745329238474369d * d8;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d12) * Math.sin(asin))) / (Math.cos(d12) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f1295c = 1;
            this.f1293a = -1L;
            this.f1294b = -1L;
        } else if (sin2 <= -1.0d) {
            this.f1295c = 0;
            this.f1293a = -1L;
            this.f1294b = -1L;
        } else {
            double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
            this.f1293a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            this.f1294b = round2;
            if (round2 < j8 && this.f1293a > j8) {
                this.f1295c = 0;
            } else {
                this.f1295c = 1;
            }
        }
    }
}
