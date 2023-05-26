package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static String[] D = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: h  reason: collision with root package name */
    int f4808h;

    /* renamed from: v  reason: collision with root package name */
    private float f4822v;

    /* renamed from: f  reason: collision with root package name */
    private float f4806f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    int f4807g = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4809i = false;

    /* renamed from: j  reason: collision with root package name */
    private float f4810j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f4811k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f4812l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    public float f4813m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f4814n = 1.0f;

    /* renamed from: o  reason: collision with root package name */
    private float f4815o = 1.0f;

    /* renamed from: p  reason: collision with root package name */
    private float f4816p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    private float f4817q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    private float f4818r = 0.0f;

    /* renamed from: s  reason: collision with root package name */
    private float f4819s = 0.0f;

    /* renamed from: t  reason: collision with root package name */
    private float f4820t = 0.0f;

    /* renamed from: u  reason: collision with root package name */
    private int f4821u = 0;

    /* renamed from: w  reason: collision with root package name */
    private float f4823w = Float.NaN;

    /* renamed from: x  reason: collision with root package name */
    private float f4824x = Float.NaN;

    /* renamed from: y  reason: collision with root package name */
    private int f4825y = -1;

    /* renamed from: z  reason: collision with root package name */
    LinkedHashMap<String, ConstraintAttribute> f4826z = new LinkedHashMap<>();
    int A = 0;
    double[] B = new double[18];
    double[] C = new double[18];

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.f4822v, motionConstrainedPoint.f4822v);
    }
}
