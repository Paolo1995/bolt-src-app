package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.Arrays;
import java.util.LinkedHashMap;
import org.jctools.util.Pow2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {

    /* renamed from: x  reason: collision with root package name */
    static String[] f4898x = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: f  reason: collision with root package name */
    Easing f4899f;

    /* renamed from: h  reason: collision with root package name */
    float f4901h;

    /* renamed from: i  reason: collision with root package name */
    float f4902i;

    /* renamed from: j  reason: collision with root package name */
    float f4903j;

    /* renamed from: k  reason: collision with root package name */
    float f4904k;

    /* renamed from: l  reason: collision with root package name */
    float f4905l;

    /* renamed from: m  reason: collision with root package name */
    float f4906m;

    /* renamed from: p  reason: collision with root package name */
    int f4909p;

    /* renamed from: q  reason: collision with root package name */
    int f4910q;

    /* renamed from: r  reason: collision with root package name */
    float f4911r;

    /* renamed from: s  reason: collision with root package name */
    MotionController f4912s;

    /* renamed from: t  reason: collision with root package name */
    LinkedHashMap<String, ConstraintAttribute> f4913t;

    /* renamed from: u  reason: collision with root package name */
    int f4914u;

    /* renamed from: v  reason: collision with root package name */
    double[] f4915v;

    /* renamed from: w  reason: collision with root package name */
    double[] f4916w;

    /* renamed from: g  reason: collision with root package name */
    int f4900g = 0;

    /* renamed from: n  reason: collision with root package name */
    float f4907n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    float f4908o = Float.NaN;

    public MotionPaths() {
        int i8 = Key.f4780f;
        this.f4909p = i8;
        this.f4910q = i8;
        this.f4911r = Float.NaN;
        this.f4912s = null;
        this.f4913t = new LinkedHashMap<>();
        this.f4914u = 0;
        this.f4915v = new double[18];
        this.f4916w = new double[18];
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.f4902i, motionPaths.f4902i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(double d8, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f8;
        float f9 = this.f4903j;
        float f10 = this.f4904k;
        float f11 = this.f4905l;
        float f12 = this.f4906m;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            float f17 = (float) dArr[i8];
            float f18 = (float) dArr2[i8];
            int i9 = iArr[i8];
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 3) {
                        if (i9 == 4) {
                            f12 = f17;
                            f16 = f18;
                        }
                    } else {
                        f11 = f17;
                        f14 = f18;
                    }
                } else {
                    f10 = f17;
                    f15 = f18;
                }
            } else {
                f9 = f17;
                f13 = f18;
            }
        }
        float f19 = 2.0f;
        float f20 = (f14 / 2.0f) + f13;
        float f21 = (f16 / 2.0f) + f15;
        MotionController motionController = this.f4912s;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.b(d8, fArr3, fArr4);
            float f22 = fArr3[0];
            float f23 = fArr3[1];
            float f24 = fArr4[0];
            float f25 = fArr4[1];
            double d9 = f9;
            double d10 = f10;
            f8 = f11;
            double d11 = f13;
            double d12 = f15;
            float sin = (float) (f24 + (Math.sin(d10) * d11) + (Math.cos(d10) * d12));
            f21 = (float) ((f25 - (d11 * Math.cos(d10))) + (Math.sin(d10) * d12));
            f20 = sin;
            f9 = (float) ((f22 + (Math.sin(d10) * d9)) - (f11 / 2.0f));
            f10 = (float) ((f23 - (d9 * Math.cos(d10))) - (f12 / 2.0f));
            f19 = 2.0f;
        } else {
            f8 = f11;
        }
        fArr[0] = f9 + (f8 / f19) + 0.0f;
        fArr[1] = f10 + (f12 / f19) + 0.0f;
        fArr2[0] = f20;
        fArr2[1] = f21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f8, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z7) {
        float f9;
        boolean z8;
        float f10;
        float f11 = this.f4903j;
        float f12 = this.f4904k;
        float f13 = this.f4905l;
        float f14 = this.f4906m;
        if (iArr.length != 0 && this.f4915v.length <= iArr[iArr.length - 1]) {
            int i8 = iArr[iArr.length - 1] + 1;
            this.f4915v = new double[i8];
            this.f4916w = new double[i8];
        }
        Arrays.fill(this.f4915v, Double.NaN);
        for (int i9 = 0; i9 < iArr.length; i9++) {
            double[] dArr4 = this.f4915v;
            int i10 = iArr[i9];
            dArr4[i10] = dArr[i9];
            this.f4916w[i10] = dArr2[i9];
        }
        float f15 = Float.NaN;
        int i11 = 0;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        while (true) {
            double[] dArr5 = this.f4915v;
            if (i11 >= dArr5.length) {
                break;
            }
            double d8 = 0.0d;
            if (Double.isNaN(dArr5[i11]) && (dArr3 == null || dArr3[i11] == 0.0d)) {
                f10 = f15;
            } else {
                if (dArr3 != null) {
                    d8 = dArr3[i11];
                }
                if (!Double.isNaN(this.f4915v[i11])) {
                    d8 = this.f4915v[i11] + d8;
                }
                f10 = f15;
                float f20 = (float) d8;
                float f21 = (float) this.f4916w[i11];
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            if (i11 != 4) {
                                if (i11 == 5) {
                                    f15 = f20;
                                }
                            } else {
                                f15 = f10;
                                f19 = f21;
                                f14 = f20;
                            }
                        } else {
                            f15 = f10;
                            f18 = f21;
                            f13 = f20;
                        }
                    } else {
                        f15 = f10;
                        f17 = f21;
                        f12 = f20;
                    }
                } else {
                    f15 = f10;
                    f16 = f21;
                    f11 = f20;
                }
                i11++;
            }
            f15 = f10;
            i11++;
        }
        float f22 = f15;
        MotionController motionController = this.f4912s;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.b(f8, fArr, fArr2);
            float f23 = fArr[0];
            float f24 = fArr[1];
            float f25 = fArr2[0];
            float f26 = fArr2[1];
            double d9 = f11;
            double d10 = f12;
            float sin = (float) ((f23 + (Math.sin(d10) * d9)) - (f13 / 2.0f));
            f9 = f14;
            float cos = (float) ((f24 - (Math.cos(d10) * d9)) - (f14 / 2.0f));
            double d11 = f16;
            double d12 = f17;
            float sin2 = (float) (f25 + (Math.sin(d10) * d11) + (Math.cos(d10) * d9 * d12));
            float cos2 = (float) ((f26 - (d11 * Math.cos(d10))) + (d9 * Math.sin(d10) * d12));
            if (dArr2.length >= 2) {
                z8 = false;
                dArr2[0] = sin2;
                dArr2[1] = cos2;
            } else {
                z8 = false;
            }
            if (!Float.isNaN(f22)) {
                view.setRotation((float) (f22 + Math.toDegrees(Math.atan2(cos2, sin2))));
            }
            f11 = sin;
            f12 = cos;
        } else {
            f9 = f14;
            z8 = false;
            if (!Float.isNaN(f22)) {
                view.setRotation((float) (0.0f + f22 + Math.toDegrees(Math.atan2(f17 + (f19 / 2.0f), f16 + (f18 / 2.0f)))));
            }
        }
        if (view instanceof FloatLayout) {
            ((FloatLayout) view).a(f11, f12, f13 + f11, f12 + f9);
            return;
        }
        float f27 = f11 + 0.5f;
        int i12 = (int) f27;
        float f28 = f12 + 0.5f;
        int i13 = (int) f28;
        int i14 = (int) (f27 + f13);
        int i15 = (int) (f28 + f9);
        int i16 = i14 - i12;
        int i17 = i15 - i13;
        if (((i16 == view.getMeasuredWidth() && i17 == view.getMeasuredHeight()) ? true : true) || z7) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i16, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(i17, Pow2.MAX_POW2));
        }
        view.layout(i12, i13, i14, i15);
    }
}
