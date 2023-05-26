package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: classes.dex */
public class HorizontalWidgetRun extends WidgetRun {

    /* renamed from: k  reason: collision with root package name */
    private static int[] f4725k = new int[2];

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4726a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f4726a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4726a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4726a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f4760h.f4704e = DependencyNode.Type.LEFT;
        this.f4761i.f4704e = DependencyNode.Type.RIGHT;
        this.f4758f = 0;
    }

    private void q(int[] iArr, int i8, int i9, int i10, int i11, float f8, int i12) {
        int i13 = i9 - i8;
        int i14 = i11 - i10;
        if (i12 != -1) {
            if (i12 != 0) {
                if (i12 == 1) {
                    iArr[0] = i13;
                    iArr[1] = (int) ((i13 * f8) + 0.5f);
                    return;
                }
                return;
            }
            iArr[0] = (int) ((i14 * f8) + 0.5f);
            iArr[1] = i14;
            return;
        }
        int i15 = (int) ((i14 * f8) + 0.5f);
        int i16 = (int) ((i13 / f8) + 0.5f);
        if (i15 <= i13) {
            iArr[0] = i15;
            iArr[1] = i14;
        } else if (i16 <= i14) {
            iArr[0] = i13;
            iArr[1] = i16;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x02bc, code lost:
        if (r14 != 1) goto L131;
     */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(androidx.constraintlayout.core.widgets.analyzer.Dependency r17) {
        /*
            Method dump skipped, instructions count: 1095
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.a(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        ConstraintWidget K;
        ConstraintWidget K2;
        ConstraintWidget constraintWidget = this.f4754b;
        if (constraintWidget.f4552a) {
            this.f4757e.d(constraintWidget.W());
        }
        if (!this.f4757e.f4709j) {
            ConstraintWidget.DimensionBehaviour A = this.f4754b.A();
            this.f4756d = A;
            if (A != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (A == dimensionBehaviour && (K2 = this.f4754b.K()) != null && (K2.A() == ConstraintWidget.DimensionBehaviour.FIXED || K2.A() == dimensionBehaviour)) {
                    int W = (K2.W() - this.f4754b.O.f()) - this.f4754b.Q.f();
                    b(this.f4760h, K2.f4560e.f4760h, this.f4754b.O.f());
                    b(this.f4761i, K2.f4560e.f4761i, -this.f4754b.Q.f());
                    this.f4757e.d(W);
                    return;
                } else if (this.f4756d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f4757e.d(this.f4754b.W());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f4756d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (K = this.f4754b.K()) != null && (K.A() == ConstraintWidget.DimensionBehaviour.FIXED || K.A() == dimensionBehaviour3)) {
                b(this.f4760h, K.f4560e.f4760h, this.f4754b.O.f());
                b(this.f4761i, K.f4560e.f4761i, -this.f4754b.Q.f());
                return;
            }
        }
        DimensionDependency dimensionDependency = this.f4757e;
        if (dimensionDependency.f4709j) {
            ConstraintWidget constraintWidget2 = this.f4754b;
            if (constraintWidget2.f4552a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.W;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f4537f;
                if (constraintAnchor2 != null && constraintAnchorArr[1].f4537f != null) {
                    if (constraintWidget2.i0()) {
                        this.f4760h.f4705f = this.f4754b.W[0].f();
                        this.f4761i.f4705f = -this.f4754b.W[1].f();
                        return;
                    }
                    DependencyNode h8 = h(this.f4754b.W[0]);
                    if (h8 != null) {
                        b(this.f4760h, h8, this.f4754b.W[0].f());
                    }
                    DependencyNode h9 = h(this.f4754b.W[1]);
                    if (h9 != null) {
                        b(this.f4761i, h9, -this.f4754b.W[1].f());
                    }
                    this.f4760h.f4701b = true;
                    this.f4761i.f4701b = true;
                    return;
                } else if (constraintAnchor2 != null) {
                    DependencyNode h10 = h(constraintAnchor);
                    if (h10 != null) {
                        b(this.f4760h, h10, this.f4754b.W[0].f());
                        b(this.f4761i, this.f4760h, this.f4757e.f4706g);
                        return;
                    }
                    return;
                } else {
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                    if (constraintAnchor3.f4537f != null) {
                        DependencyNode h11 = h(constraintAnchor3);
                        if (h11 != null) {
                            b(this.f4761i, h11, -this.f4754b.W[1].f());
                            b(this.f4760h, this.f4761i, -this.f4757e.f4706g);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.K() != null && this.f4754b.o(ConstraintAnchor.Type.CENTER).f4537f == null) {
                        b(this.f4760h, this.f4754b.K().f4560e.f4760h, this.f4754b.X());
                        b(this.f4761i, this.f4760h, this.f4757e.f4706g);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        if (this.f4756d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f4754b;
            int i8 = constraintWidget3.f4596w;
            if (i8 != 2) {
                if (i8 == 3) {
                    if (constraintWidget3.f4598x == 3) {
                        this.f4760h.f4700a = this;
                        this.f4761i.f4700a = this;
                        VerticalWidgetRun verticalWidgetRun = constraintWidget3.f4562f;
                        verticalWidgetRun.f4760h.f4700a = this;
                        verticalWidgetRun.f4761i.f4700a = this;
                        dimensionDependency.f4700a = this;
                        if (constraintWidget3.k0()) {
                            this.f4757e.f4711l.add(this.f4754b.f4562f.f4757e);
                            this.f4754b.f4562f.f4757e.f4710k.add(this.f4757e);
                            VerticalWidgetRun verticalWidgetRun2 = this.f4754b.f4562f;
                            verticalWidgetRun2.f4757e.f4700a = this;
                            this.f4757e.f4711l.add(verticalWidgetRun2.f4760h);
                            this.f4757e.f4711l.add(this.f4754b.f4562f.f4761i);
                            this.f4754b.f4562f.f4760h.f4710k.add(this.f4757e);
                            this.f4754b.f4562f.f4761i.f4710k.add(this.f4757e);
                        } else if (this.f4754b.i0()) {
                            this.f4754b.f4562f.f4757e.f4711l.add(this.f4757e);
                            this.f4757e.f4710k.add(this.f4754b.f4562f.f4757e);
                        } else {
                            this.f4754b.f4562f.f4757e.f4711l.add(this.f4757e);
                        }
                    } else {
                        DimensionDependency dimensionDependency2 = constraintWidget3.f4562f.f4757e;
                        dimensionDependency.f4711l.add(dimensionDependency2);
                        dimensionDependency2.f4710k.add(this.f4757e);
                        this.f4754b.f4562f.f4760h.f4710k.add(this.f4757e);
                        this.f4754b.f4562f.f4761i.f4710k.add(this.f4757e);
                        DimensionDependency dimensionDependency3 = this.f4757e;
                        dimensionDependency3.f4701b = true;
                        dimensionDependency3.f4710k.add(this.f4760h);
                        this.f4757e.f4710k.add(this.f4761i);
                        this.f4760h.f4711l.add(this.f4757e);
                        this.f4761i.f4711l.add(this.f4757e);
                    }
                }
            } else {
                ConstraintWidget K3 = constraintWidget3.K();
                if (K3 != null) {
                    DimensionDependency dimensionDependency4 = K3.f4562f.f4757e;
                    this.f4757e.f4711l.add(dimensionDependency4);
                    dimensionDependency4.f4710k.add(this.f4757e);
                    DimensionDependency dimensionDependency5 = this.f4757e;
                    dimensionDependency5.f4701b = true;
                    dimensionDependency5.f4710k.add(this.f4760h);
                    this.f4757e.f4710k.add(this.f4761i);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f4754b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.W;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f4537f;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].f4537f != null) {
            if (constraintWidget4.i0()) {
                this.f4760h.f4705f = this.f4754b.W[0].f();
                this.f4761i.f4705f = -this.f4754b.W[1].f();
                return;
            }
            DependencyNode h12 = h(this.f4754b.W[0]);
            DependencyNode h13 = h(this.f4754b.W[1]);
            if (h12 != null) {
                h12.b(this);
            }
            if (h13 != null) {
                h13.b(this);
            }
            this.f4762j = WidgetRun.RunType.CENTER;
        } else if (constraintAnchor5 != null) {
            DependencyNode h14 = h(constraintAnchor4);
            if (h14 != null) {
                b(this.f4760h, h14, this.f4754b.W[0].f());
                c(this.f4761i, this.f4760h, 1, this.f4757e);
            }
        } else {
            ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
            if (constraintAnchor6.f4537f != null) {
                DependencyNode h15 = h(constraintAnchor6);
                if (h15 != null) {
                    b(this.f4761i, h15, -this.f4754b.W[1].f());
                    c(this.f4760h, this.f4761i, -1, this.f4757e);
                }
            } else if (!(constraintWidget4 instanceof Helper) && constraintWidget4.K() != null) {
                b(this.f4760h, this.f4754b.K().f4560e.f4760h, this.f4754b.X());
                c(this.f4761i, this.f4760h, 1, this.f4757e);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f4760h;
        if (dependencyNode.f4709j) {
            this.f4754b.m1(dependencyNode.f4706g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f4755c = null;
        this.f4760h.c();
        this.f4761i.c();
        this.f4757e.c();
        this.f4759g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean m() {
        if (this.f4756d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f4754b.f4596w == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f4759g = false;
        this.f4760h.c();
        this.f4760h.f4709j = false;
        this.f4761i.c();
        this.f4761i.f4709j = false;
        this.f4757e.f4709j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f4754b.t();
    }
}
