package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChainHead {

    /* renamed from: a  reason: collision with root package name */
    protected ConstraintWidget f4510a;

    /* renamed from: b  reason: collision with root package name */
    protected ConstraintWidget f4511b;

    /* renamed from: c  reason: collision with root package name */
    protected ConstraintWidget f4512c;

    /* renamed from: d  reason: collision with root package name */
    protected ConstraintWidget f4513d;

    /* renamed from: e  reason: collision with root package name */
    protected ConstraintWidget f4514e;

    /* renamed from: f  reason: collision with root package name */
    protected ConstraintWidget f4515f;

    /* renamed from: g  reason: collision with root package name */
    protected ConstraintWidget f4516g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<ConstraintWidget> f4517h;

    /* renamed from: i  reason: collision with root package name */
    protected int f4518i;

    /* renamed from: j  reason: collision with root package name */
    protected int f4519j;

    /* renamed from: k  reason: collision with root package name */
    protected float f4520k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    int f4521l;

    /* renamed from: m  reason: collision with root package name */
    int f4522m;

    /* renamed from: n  reason: collision with root package name */
    int f4523n;

    /* renamed from: o  reason: collision with root package name */
    boolean f4524o;

    /* renamed from: p  reason: collision with root package name */
    private int f4525p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4526q;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f4527r;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f4528s;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f4529t;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f4530u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f4531v;

    public ChainHead(ConstraintWidget constraintWidget, int i8, boolean z7) {
        this.f4510a = constraintWidget;
        this.f4525p = i8;
        this.f4526q = z7;
    }

    private void b() {
        int i8 = this.f4525p * 2;
        ConstraintWidget constraintWidget = this.f4510a;
        boolean z7 = true;
        this.f4524o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z8 = false;
        while (!z8) {
            this.f4518i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.F0;
            int i9 = this.f4525p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i9] = null;
            constraintWidget.E0[i9] = null;
            if (constraintWidget.V() != 8) {
                this.f4521l++;
                ConstraintWidget.DimensionBehaviour u7 = constraintWidget.u(this.f4525p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (u7 != dimensionBehaviour) {
                    this.f4522m += constraintWidget.E(this.f4525p);
                }
                int f8 = this.f4522m + constraintWidget.W[i8].f();
                this.f4522m = f8;
                int i10 = i8 + 1;
                this.f4522m = f8 + constraintWidget.W[i10].f();
                int f9 = this.f4523n + constraintWidget.W[i8].f();
                this.f4523n = f9;
                this.f4523n = f9 + constraintWidget.W[i10].f();
                if (this.f4511b == null) {
                    this.f4511b = constraintWidget;
                }
                this.f4513d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.Z;
                int i11 = this.f4525p;
                if (dimensionBehaviourArr[i11] == dimensionBehaviour) {
                    int i12 = constraintWidget.f4600y[i11];
                    if (i12 == 0 || i12 == 3 || i12 == 2) {
                        this.f4519j++;
                        float f10 = constraintWidget.D0[i11];
                        if (f10 > 0.0f) {
                            this.f4520k += f10;
                        }
                        if (c(constraintWidget, i11)) {
                            if (f10 < 0.0f) {
                                this.f4527r = true;
                            } else {
                                this.f4528s = true;
                            }
                            if (this.f4517h == null) {
                                this.f4517h = new ArrayList<>();
                            }
                            this.f4517h.add(constraintWidget);
                        }
                        if (this.f4515f == null) {
                            this.f4515f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f4516g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.E0[this.f4525p] = constraintWidget;
                        }
                        this.f4516g = constraintWidget;
                    }
                    if (this.f4525p == 0) {
                        if (constraintWidget.f4596w != 0) {
                            this.f4524o = false;
                        } else if (constraintWidget.f4602z != 0 || constraintWidget.A != 0) {
                            this.f4524o = false;
                        }
                    } else if (constraintWidget.f4598x != 0) {
                        this.f4524o = false;
                    } else if (constraintWidget.C != 0 || constraintWidget.D != 0) {
                        this.f4524o = false;
                    }
                    if (constraintWidget.f4559d0 != 0.0f) {
                        this.f4524o = false;
                        this.f4530u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.F0[this.f4525p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.W[i8 + 1].f4537f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f4535d;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.W[i8].f4537f;
                if (constraintAnchor2 != null && constraintAnchor2.f4535d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z8 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f4511b;
        if (constraintWidget6 != null) {
            this.f4522m -= constraintWidget6.W[i8].f();
        }
        ConstraintWidget constraintWidget7 = this.f4513d;
        if (constraintWidget7 != null) {
            this.f4522m -= constraintWidget7.W[i8 + 1].f();
        }
        this.f4512c = constraintWidget;
        if (this.f4525p == 0 && this.f4526q) {
            this.f4514e = constraintWidget;
        } else {
            this.f4514e = this.f4510a;
        }
        this.f4529t = (this.f4528s && this.f4527r) ? false : false;
    }

    private static boolean c(ConstraintWidget constraintWidget, int i8) {
        int i9;
        if (constraintWidget.V() != 8 && constraintWidget.Z[i8] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && ((i9 = constraintWidget.f4600y[i8]) == 0 || i9 == 3)) {
            return true;
        }
        return false;
    }

    public void a() {
        if (!this.f4531v) {
            b();
        }
        this.f4531v = true;
    }
}
