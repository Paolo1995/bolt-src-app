package androidx.constraintlayout.motion.widget;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class MotionController {

    /* renamed from: a  reason: collision with root package name */
    boolean f4827a;

    /* renamed from: b  reason: collision with root package name */
    private MotionPaths f4828b;

    /* renamed from: c  reason: collision with root package name */
    private MotionPaths f4829c;

    /* renamed from: d  reason: collision with root package name */
    private MotionConstrainedPoint f4830d;

    /* renamed from: e  reason: collision with root package name */
    private MotionConstrainedPoint f4831e;

    /* renamed from: f  reason: collision with root package name */
    private CurveFit[] f4832f;

    /* renamed from: g  reason: collision with root package name */
    private CurveFit f4833g;

    /* renamed from: h  reason: collision with root package name */
    float f4834h;

    /* renamed from: i  reason: collision with root package name */
    float f4835i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f4836j;

    /* renamed from: k  reason: collision with root package name */
    private double[] f4837k;

    /* renamed from: l  reason: collision with root package name */
    private double[] f4838l;

    /* renamed from: m  reason: collision with root package name */
    private String[] f4839m;

    /* renamed from: n  reason: collision with root package name */
    private float[] f4840n;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<MotionPaths> f4841o;

    /* renamed from: p  reason: collision with root package name */
    private HashMap<String, ViewTimeCycle> f4842p;

    /* renamed from: q  reason: collision with root package name */
    private HashMap<String, ViewSpline> f4843q;

    /* renamed from: r  reason: collision with root package name */
    private HashMap<String, ViewOscillator> f4844r;

    /* renamed from: s  reason: collision with root package name */
    private KeyTrigger[] f4845s;

    /* renamed from: t  reason: collision with root package name */
    private int f4846t;

    /* renamed from: u  reason: collision with root package name */
    private View f4847u;

    /* renamed from: v  reason: collision with root package name */
    private int f4848v;

    /* renamed from: w  reason: collision with root package name */
    private float f4849w;

    /* renamed from: x  reason: collision with root package name */
    private Interpolator f4850x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f4851y;

    private float a(float f8, float[] fArr) {
        float f9 = 0.0f;
        float f10 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f11 = this.f4835i;
            if (f11 != 1.0d) {
                float f12 = this.f4834h;
                if (f8 < f12) {
                    f8 = 0.0f;
                }
                if (f8 > f12 && f8 < 1.0d) {
                    f8 = Math.min((f8 - f12) * f11, 1.0f);
                }
            }
        }
        Easing easing = this.f4828b.f4899f;
        float f13 = Float.NaN;
        Iterator<MotionPaths> it = this.f4841o.iterator();
        while (it.hasNext()) {
            MotionPaths next = it.next();
            Easing easing2 = next.f4899f;
            if (easing2 != null) {
                float f14 = next.f4901h;
                if (f14 < f8) {
                    easing = easing2;
                    f9 = f14;
                } else if (Float.isNaN(f13)) {
                    f13 = next.f4901h;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f13)) {
                f10 = f13;
            }
            float f15 = f10 - f9;
            double d8 = (f8 - f9) / f15;
            f8 = (((float) easing.a(d8)) * f15) + f9;
            if (fArr != null) {
                fArr[0] = (float) easing.b(d8);
            }
        }
        return f8;
    }

    public void b(double d8, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f4832f[0].b(d8, dArr);
        this.f4832f[0].d(d8, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f4828b.c(d8, this.f4836j, dArr, fArr, dArr2, fArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(View view, float f8, long j8, KeyCache keyCache) {
        ViewTimeCycle.PathRotate pathRotate;
        boolean z7;
        char c8;
        double d8;
        View view2;
        float f9;
        float a8 = a(f8, null);
        int i8 = this.f4848v;
        if (i8 != Key.f4780f) {
            float f10 = 1.0f / i8;
            float floor = ((float) Math.floor(a8 / f10)) * f10;
            float f11 = (a8 % f10) / f10;
            if (!Float.isNaN(this.f4849w)) {
                f11 = (f11 + this.f4849w) % 1.0f;
            }
            Interpolator interpolator = this.f4850x;
            if (interpolator != null) {
                f9 = interpolator.getInterpolation(f11);
            } else if (f11 > 0.5d) {
                f9 = 1.0f;
            } else {
                f9 = 0.0f;
            }
            a8 = (f9 * f10) + floor;
        }
        float f12 = a8;
        HashMap<String, ViewSpline> hashMap = this.f4843q;
        if (hashMap != null) {
            for (ViewSpline viewSpline : hashMap.values()) {
                viewSpline.b(view, f12);
            }
        }
        HashMap<String, ViewTimeCycle> hashMap2 = this.f4842p;
        if (hashMap2 != null) {
            ViewTimeCycle.PathRotate pathRotate2 = null;
            boolean z8 = false;
            for (ViewTimeCycle viewTimeCycle : hashMap2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate2 = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    z8 |= viewTimeCycle.c(view, f12, j8, keyCache);
                }
            }
            z7 = z8;
            pathRotate = pathRotate2;
        } else {
            pathRotate = null;
            z7 = false;
        }
        CurveFit[] curveFitArr = this.f4832f;
        if (curveFitArr != null) {
            double d9 = f12;
            curveFitArr[0].b(d9, this.f4837k);
            this.f4832f[0].d(d9, this.f4838l);
            CurveFit curveFit = this.f4833g;
            if (curveFit != null) {
                double[] dArr = this.f4837k;
                if (dArr.length > 0) {
                    curveFit.b(d9, dArr);
                    this.f4833g.d(d9, this.f4838l);
                }
            }
            if (!this.f4851y) {
                d8 = d9;
                this.f4828b.e(f12, view, this.f4836j, this.f4837k, this.f4838l, null, this.f4827a);
                this.f4827a = false;
            } else {
                d8 = d9;
            }
            if (this.f4846t != Key.f4780f) {
                if (this.f4847u == null) {
                    this.f4847u = ((View) view.getParent()).findViewById(this.f4846t);
                }
                if (this.f4847u != null) {
                    float top = (view2.getTop() + this.f4847u.getBottom()) / 2.0f;
                    float left = (this.f4847u.getLeft() + this.f4847u.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view.setPivotX(left - view.getLeft());
                        view.setPivotY(top - view.getTop());
                    }
                }
            }
            HashMap<String, ViewSpline> hashMap3 = this.f4843q;
            if (hashMap3 != null) {
                for (ViewSpline viewSpline2 : hashMap3.values()) {
                    if (viewSpline2 instanceof ViewSpline.PathRotate) {
                        double[] dArr2 = this.f4838l;
                        if (dArr2.length > 1) {
                            ((ViewSpline.PathRotate) viewSpline2).c(view, f12, dArr2[0], dArr2[1]);
                        }
                    }
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.f4838l;
                c8 = 1;
                z7 |= pathRotate.d(view, keyCache, f12, j8, dArr3[0], dArr3[1]);
            } else {
                c8 = 1;
            }
            int i9 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.f4832f;
                if (i9 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i9].c(d8, this.f4840n);
                CustomSupport.b(this.f4828b.f4913t.get(this.f4839m[i9 - 1]), view, this.f4840n);
                i9++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.f4830d;
            if (motionConstrainedPoint.f4807g == 0) {
                if (f12 <= 0.0f) {
                    view.setVisibility(motionConstrainedPoint.f4808h);
                } else if (f12 >= 1.0f) {
                    view.setVisibility(this.f4831e.f4808h);
                } else if (this.f4831e.f4808h != motionConstrainedPoint.f4808h) {
                    view.setVisibility(0);
                }
            }
            if (this.f4845s != null) {
                int i10 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.f4845s;
                    if (i10 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i10].c(f12, view);
                    i10++;
                }
            }
        } else {
            c8 = 1;
            MotionPaths motionPaths = this.f4828b;
            float f13 = motionPaths.f4903j;
            MotionPaths motionPaths2 = this.f4829c;
            float f14 = f13 + ((motionPaths2.f4903j - f13) * f12);
            float f15 = motionPaths.f4904k;
            float f16 = f15 + ((motionPaths2.f4904k - f15) * f12);
            float f17 = motionPaths.f4905l;
            float f18 = motionPaths2.f4905l;
            float f19 = motionPaths.f4906m;
            float f20 = motionPaths2.f4906m;
            float f21 = f14 + 0.5f;
            int i11 = (int) f21;
            float f22 = f16 + 0.5f;
            int i12 = (int) f22;
            int i13 = (int) (f21 + ((f18 - f17) * f12) + f17);
            int i14 = (int) (f22 + ((f20 - f19) * f12) + f19);
            int i15 = i13 - i11;
            int i16 = i14 - i12;
            if (f18 != f17 || f20 != f19 || this.f4827a) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i15, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(i16, Pow2.MAX_POW2));
                this.f4827a = false;
            }
            view.layout(i11, i12, i13, i14);
        }
        HashMap<String, ViewOscillator> hashMap4 = this.f4844r;
        if (hashMap4 != null) {
            for (ViewOscillator viewOscillator : hashMap4.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    double[] dArr4 = this.f4838l;
                    ((ViewOscillator.PathRotateSet) viewOscillator).c(view, f12, dArr4[0], dArr4[c8]);
                } else {
                    viewOscillator.b(view, f12);
                }
            }
        }
        return z7;
    }

    public String toString() {
        return " start: x: " + this.f4828b.f4903j + " y: " + this.f4828b.f4904k + " end: x: " + this.f4829c.f4903j + " y: " + this.f4829c.f4904k;
    }
}
