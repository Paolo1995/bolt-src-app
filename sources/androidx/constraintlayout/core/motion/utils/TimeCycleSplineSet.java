package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class TimeCycleSplineSet {

    /* renamed from: k  reason: collision with root package name */
    protected static float f4476k = 6.2831855f;

    /* renamed from: a  reason: collision with root package name */
    protected CurveFit f4477a;

    /* renamed from: e  reason: collision with root package name */
    protected int f4481e;

    /* renamed from: f  reason: collision with root package name */
    protected String f4482f;

    /* renamed from: i  reason: collision with root package name */
    protected long f4485i;

    /* renamed from: b  reason: collision with root package name */
    protected int f4478b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int[] f4479c = new int[10];

    /* renamed from: d  reason: collision with root package name */
    protected float[][] f4480d = (float[][]) Array.newInstance(Float.TYPE, 10, 3);

    /* renamed from: g  reason: collision with root package name */
    protected float[] f4483g = new float[3];

    /* renamed from: h  reason: collision with root package name */
    protected boolean f4484h = false;

    /* renamed from: j  reason: collision with root package name */
    protected float f4486j = Float.NaN;

    /* JADX INFO: Access modifiers changed from: protected */
    public float a(float f8) {
        float abs;
        switch (this.f4478b) {
            case 1:
                return Math.signum(f8 * f4476k);
            case 2:
                abs = Math.abs(f8);
                break;
            case 3:
                return (((f8 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f8 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f8 * f4476k);
            case 6:
                float abs2 = 1.0f - Math.abs(((f8 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f8 * f4476k);
        }
        return 1.0f - abs;
    }

    public String toString() {
        String str = this.f4482f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i8 = 0; i8 < this.f4481e; i8++) {
            str = str + "[" + this.f4479c[i8] + " , " + decimalFormat.format(this.f4480d[i8]) + "] ";
        }
        return str;
    }
}
