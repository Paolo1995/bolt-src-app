package androidx.core.content.res;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
final class ViewingConditions {

    /* renamed from: k  reason: collision with root package name */
    static final ViewingConditions f5720k = k(CamUtils.f5690c, (float) ((CamUtils.h(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a  reason: collision with root package name */
    private final float f5721a;

    /* renamed from: b  reason: collision with root package name */
    private final float f5722b;

    /* renamed from: c  reason: collision with root package name */
    private final float f5723c;

    /* renamed from: d  reason: collision with root package name */
    private final float f5724d;

    /* renamed from: e  reason: collision with root package name */
    private final float f5725e;

    /* renamed from: f  reason: collision with root package name */
    private final float f5726f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f5727g;

    /* renamed from: h  reason: collision with root package name */
    private final float f5728h;

    /* renamed from: i  reason: collision with root package name */
    private final float f5729i;

    /* renamed from: j  reason: collision with root package name */
    private final float f5730j;

    private ViewingConditions(float f8, float f9, float f10, float f11, float f12, float f13, float[] fArr, float f14, float f15, float f16) {
        this.f5726f = f8;
        this.f5721a = f9;
        this.f5722b = f10;
        this.f5723c = f11;
        this.f5724d = f12;
        this.f5725e = f13;
        this.f5727g = fArr;
        this.f5728h = f14;
        this.f5729i = f15;
        this.f5730j = f16;
    }

    @NonNull
    static ViewingConditions k(@NonNull float[] fArr, float f8, float f9, float f10, boolean z7) {
        float d8;
        float exp;
        float[][] fArr2 = CamUtils.f5688a;
        float f11 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f12 = fArr[1];
        float f13 = fArr[2];
        float f14 = (fArr3[0] * f11) + (fArr3[1] * f12) + (fArr3[2] * f13);
        float[] fArr4 = fArr2[1];
        float f15 = (fArr4[0] * f11) + (fArr4[1] * f12) + (fArr4[2] * f13);
        float[] fArr5 = fArr2[2];
        float f16 = (f11 * fArr5[0]) + (f12 * fArr5[1]) + (f13 * fArr5[2]);
        float f17 = (f10 / 10.0f) + 0.8f;
        if (f17 >= 0.9d) {
            d8 = CamUtils.d(0.59f, 0.69f, (f17 - 0.9f) * 10.0f);
        } else {
            d8 = CamUtils.d(0.525f, 0.59f, (f17 - 0.8f) * 10.0f);
        }
        float f18 = d8;
        if (z7) {
            exp = 1.0f;
        } else {
            exp = (1.0f - (((float) Math.exp(((-f8) - 42.0f) / 92.0f)) * 0.2777778f)) * f17;
        }
        double d9 = exp;
        if (d9 > 1.0d) {
            exp = 1.0f;
        } else if (d9 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f14) * exp) + 1.0f) - exp, (((100.0f / f15) * exp) + 1.0f) - exp, (((100.0f / f16) * exp) + 1.0f) - exp};
        float f19 = 1.0f / ((5.0f * f8) + 1.0f);
        float f20 = f19 * f19 * f19 * f19;
        float f21 = 1.0f - f20;
        float cbrt = (f20 * f8) + (0.1f * f21 * f21 * ((float) Math.cbrt(f8 * 5.0d)));
        float h8 = CamUtils.h(f9) / fArr[1];
        double d10 = h8;
        float sqrt = ((float) Math.sqrt(d10)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d10, 0.2d));
        float pow2 = (float) Math.pow(((fArr6[2] * cbrt) * f16) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f14) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f15) / 100.0d, 0.42d), pow2};
        float f22 = fArr7[0];
        float f23 = (f22 * 400.0f) / (f22 + 27.13f);
        float f24 = fArr7[1];
        return new ViewingConditions(h8, ((f23 * 2.0f) + ((f24 * 400.0f) / (f24 + 27.13f)) + (((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f)) * pow, pow, pow, f18, f17, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.f5721a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f5724d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f5728h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f5729i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f5726f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.f5722b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f5725e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        return this.f5723c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public float[] i() {
        return this.f5727g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f5730j;
    }
}
