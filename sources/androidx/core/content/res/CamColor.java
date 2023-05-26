package androidx.core.content.res;

import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CamColor {

    /* renamed from: a  reason: collision with root package name */
    private final float f5679a;

    /* renamed from: b  reason: collision with root package name */
    private final float f5680b;

    /* renamed from: c  reason: collision with root package name */
    private final float f5681c;

    /* renamed from: d  reason: collision with root package name */
    private final float f5682d;

    /* renamed from: e  reason: collision with root package name */
    private final float f5683e;

    /* renamed from: f  reason: collision with root package name */
    private final float f5684f;

    /* renamed from: g  reason: collision with root package name */
    private final float f5685g;

    /* renamed from: h  reason: collision with root package name */
    private final float f5686h;

    /* renamed from: i  reason: collision with root package name */
    private final float f5687i;

    CamColor(float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f5679a = f8;
        this.f5680b = f9;
        this.f5681c = f10;
        this.f5682d = f11;
        this.f5683e = f12;
        this.f5684f = f13;
        this.f5685g = f14;
        this.f5686h = f15;
        this.f5687i = f16;
    }

    private static CamColor b(float f8, float f9, float f10) {
        float f11 = 1000.0f;
        CamColor camColor = null;
        float f12 = 1000.0f;
        float f13 = 100.0f;
        float f14 = 0.0f;
        while (Math.abs(f14 - f13) > 0.01f) {
            float f15 = ((f13 - f14) / 2.0f) + f14;
            int p8 = e(f15, f9, f8).p();
            float b8 = CamUtils.b(p8);
            float abs = Math.abs(f10 - b8);
            if (abs < 0.2f) {
                CamColor c8 = c(p8);
                float a8 = c8.a(e(c8.k(), c8.i(), f8));
                if (a8 <= 1.0f) {
                    camColor = c8;
                    f11 = abs;
                    f12 = a8;
                }
            }
            if (f11 == 0.0f && f12 == 0.0f) {
                break;
            } else if (b8 < f10) {
                f14 = f15;
            } else {
                f13 = f15;
            }
        }
        return camColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static CamColor c(int i8) {
        return d(i8, ViewingConditions.f5720k);
    }

    @NonNull
    static CamColor d(int i8, @NonNull ViewingConditions viewingConditions) {
        float f8;
        float pow;
        float[] f9 = CamUtils.f(i8);
        float[][] fArr = CamUtils.f5688a;
        float f10 = f9[0];
        float[] fArr2 = fArr[0];
        float f11 = f9[1];
        float f12 = f9[2];
        float f13 = (fArr2[0] * f10) + (fArr2[1] * f11) + (fArr2[2] * f12);
        float[] fArr3 = fArr[1];
        float f14 = (fArr3[0] * f10) + (fArr3[1] * f11) + (fArr3[2] * f12);
        float[] fArr4 = fArr[2];
        float f15 = (f10 * fArr4[0]) + (f11 * fArr4[1]) + (f12 * fArr4[2]);
        float f16 = viewingConditions.i()[0] * f13;
        float f17 = viewingConditions.i()[1] * f14;
        float f18 = viewingConditions.i()[2] * f15;
        float pow2 = (float) Math.pow((viewingConditions.c() * Math.abs(f16)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((viewingConditions.c() * Math.abs(f17)) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((viewingConditions.c() * Math.abs(f18)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f16) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f17) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f18) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d8 = signum3;
        float f19 = ((float) (((signum * 11.0d) + (signum2 * (-12.0d))) + d8)) / 11.0f;
        float f20 = ((float) ((signum + signum2) - (d8 * 2.0d))) / 9.0f;
        float f21 = signum2 * 20.0f;
        float f22 = (((signum * 20.0f) + f21) + (21.0f * signum3)) / 20.0f;
        float f23 = (((signum * 40.0f) + f21) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f20, f19)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f24 = atan2;
        float f25 = (3.1415927f * f24) / 180.0f;
        float pow5 = ((float) Math.pow((f23 * viewingConditions.f()) / viewingConditions.a(), viewingConditions.b() * viewingConditions.j())) * 100.0f;
        float d9 = viewingConditions.d() * (4.0f / viewingConditions.b()) * ((float) Math.sqrt(pow5 / 100.0f)) * (viewingConditions.a() + 4.0f);
        if (f24 < 20.14d) {
            f8 = 360.0f + f24;
        } else {
            f8 = f24;
        }
        float pow6 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((f8 * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.g()) * viewingConditions.h()) * ((float) Math.sqrt((f19 * f19) + (f20 * f20)))) / (f22 + 0.305f), 0.9d)) * ((float) Math.sqrt(pow5 / 100.0d));
        float d10 = pow6 * viewingConditions.d();
        float sqrt = ((float) Math.sqrt((pow * viewingConditions.b()) / (viewingConditions.a() + 4.0f))) * 50.0f;
        float f26 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log = ((float) Math.log((0.0228f * d10) + 1.0f)) * 43.85965f;
        double d11 = f25;
        return new CamColor(f24, pow6, pow5, d9, d10, sqrt, f26, log * ((float) Math.cos(d11)), log * ((float) Math.sin(d11)));
    }

    @NonNull
    private static CamColor e(float f8, float f9, float f10) {
        return f(f8, f9, f10, ViewingConditions.f5720k);
    }

    @NonNull
    private static CamColor f(float f8, float f9, float f10, ViewingConditions viewingConditions) {
        double d8;
        float b8 = (4.0f / viewingConditions.b()) * ((float) Math.sqrt(f8 / 100.0d)) * (viewingConditions.a() + 4.0f) * viewingConditions.d();
        float d9 = f9 * viewingConditions.d();
        float sqrt = ((float) Math.sqrt(((f9 / ((float) Math.sqrt(d8))) * viewingConditions.b()) / (viewingConditions.a() + 4.0f))) * 50.0f;
        float f11 = (1.7f * f8) / ((0.007f * f8) + 1.0f);
        float log = ((float) Math.log((d9 * 0.0228d) + 1.0d)) * 43.85965f;
        double d10 = (3.1415927f * f10) / 180.0f;
        return new CamColor(f10, f9, f8, b8, d9, sqrt, f11, log * ((float) Math.cos(d10)), log * ((float) Math.sin(d10)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(float f8, float f9, float f10) {
        return n(f8, f9, f10, ViewingConditions.f5720k);
    }

    static int n(float f8, float f9, float f10, @NonNull ViewingConditions viewingConditions) {
        float min;
        if (f9 >= 1.0d && Math.round(f10) > 0.0d && Math.round(f10) < 100.0d) {
            if (f8 < 0.0f) {
                min = 0.0f;
            } else {
                min = Math.min(360.0f, f8);
            }
            float f11 = f9;
            CamColor camColor = null;
            float f12 = 0.0f;
            boolean z7 = true;
            while (Math.abs(f12 - f9) >= 0.4f) {
                CamColor b8 = b(min, f11, f10);
                if (z7) {
                    if (b8 != null) {
                        return b8.o(viewingConditions);
                    }
                    z7 = false;
                } else if (b8 == null) {
                    f9 = f11;
                } else {
                    f12 = f11;
                    camColor = b8;
                }
                f11 = ((f9 - f12) / 2.0f) + f12;
            }
            if (camColor == null) {
                return CamUtils.a(f10);
            }
            return camColor.o(viewingConditions);
        }
        return CamUtils.a(f10);
    }

    float a(@NonNull CamColor camColor) {
        float l8 = l() - camColor.l();
        float g8 = g() - camColor.g();
        float h8 = h() - camColor.h();
        return (float) (Math.pow(Math.sqrt((l8 * l8) + (g8 * g8) + (h8 * h8)), 0.63d) * 1.41d);
    }

    float g() {
        return this.f5686h;
    }

    float h() {
        return this.f5687i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f5680b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f5679a;
    }

    float k() {
        return this.f5681c;
    }

    float l() {
        return this.f5685g;
    }

    int o(@NonNull ViewingConditions viewingConditions) {
        float f8;
        float f9;
        if (i() != 0.0d && k() != 0.0d) {
            f8 = i() / ((float) Math.sqrt(k() / 100.0d));
        } else {
            f8 = 0.0f;
        }
        float pow = (float) Math.pow(f8 / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.e()), 0.73d), 1.1111111111111112d);
        double j8 = (j() * 3.1415927f) / 180.0f;
        float a8 = viewingConditions.a() * ((float) Math.pow(k() / 100.0d, (1.0d / viewingConditions.b()) / viewingConditions.j()));
        float cos = ((float) (Math.cos(2.0d + j8) + 3.8d)) * 0.25f * 3846.1538f * viewingConditions.g() * viewingConditions.h();
        float f10 = a8 / viewingConditions.f();
        float sin = (float) Math.sin(j8);
        float cos2 = (float) Math.cos(j8);
        float f11 = (((0.305f + f10) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f12 = cos2 * f11;
        float f13 = f11 * sin;
        float f14 = f10 * 460.0f;
        float f15 = (((451.0f * f12) + f14) + (288.0f * f13)) / 1403.0f;
        float f16 = ((f14 - (891.0f * f12)) - (261.0f * f13)) / 1403.0f;
        float signum = Math.signum(f15) * (100.0f / viewingConditions.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f15) * 27.13d) / (400.0d - Math.abs(f15))), 2.380952380952381d));
        float signum2 = Math.signum(f16) * (100.0f / viewingConditions.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f16) * 27.13d) / (400.0d - Math.abs(f16))), 2.380952380952381d));
        float signum3 = Math.signum(((f14 - (f12 * 220.0f)) - (f13 * 6300.0f)) / 1403.0f) * (100.0f / viewingConditions.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f9) * 27.13d) / (400.0d - Math.abs(f9))), 2.380952380952381d));
        float f17 = signum / viewingConditions.i()[0];
        float f18 = signum2 / viewingConditions.i()[1];
        float f19 = signum3 / viewingConditions.i()[2];
        float[][] fArr = CamUtils.f5689b;
        float[] fArr2 = fArr[0];
        float f20 = (fArr2[0] * f17) + (fArr2[1] * f18) + (fArr2[2] * f19);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return ColorUtils.b(f20, (fArr3[0] * f17) + (fArr3[1] * f18) + (fArr3[2] * f19), (f17 * fArr4[0]) + (f18 * fArr4[1]) + (f19 * fArr4[2]));
    }

    int p() {
        return o(ViewingConditions.f5720k);
    }
}
