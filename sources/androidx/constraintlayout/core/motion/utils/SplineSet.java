package androidx.constraintlayout.core.motion.utils;

import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class SplineSet {

    /* renamed from: a  reason: collision with root package name */
    protected CurveFit f4457a;

    /* renamed from: b  reason: collision with root package name */
    protected int[] f4458b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    protected float[] f4459c = new float[10];

    /* renamed from: d  reason: collision with root package name */
    private int f4460d;

    /* renamed from: e  reason: collision with root package name */
    private String f4461e;

    public float a(float f8) {
        return (float) this.f4457a.a(f8, 0);
    }

    public String toString() {
        String str = this.f4461e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i8 = 0; i8 < this.f4460d; i8++) {
            str = str + "[" + this.f4458b[i8] + " , " + decimalFormat.format(this.f4459c[i8]) + "] ";
        }
        return str;
    }
}
