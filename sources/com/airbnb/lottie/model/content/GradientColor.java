package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes.dex */
public class GradientColor {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f9325a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f9326b;

    public GradientColor(float[] fArr, int[] iArr) {
        this.f9325a = fArr;
        this.f9326b = iArr;
    }

    public int[] a() {
        return this.f9326b;
    }

    public float[] b() {
        return this.f9325a;
    }

    public int c() {
        return this.f9326b.length;
    }

    public void d(GradientColor gradientColor, GradientColor gradientColor2, float f8) {
        if (gradientColor.f9326b.length == gradientColor2.f9326b.length) {
            for (int i8 = 0; i8 < gradientColor.f9326b.length; i8++) {
                this.f9325a[i8] = MiscUtils.i(gradientColor.f9325a[i8], gradientColor2.f9325a[i8], f8);
                this.f9326b[i8] = GammaEvaluator.c(f8, gradientColor.f9326b[i8], gradientColor2.f9326b[i8]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.f9326b.length + " vs " + gradientColor2.f9326b.length + ")");
    }
}
