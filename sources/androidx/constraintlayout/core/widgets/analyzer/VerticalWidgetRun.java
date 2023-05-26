package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: classes.dex */
public class VerticalWidgetRun extends WidgetRun {

    /* renamed from: k  reason: collision with root package name */
    public DependencyNode f4735k;

    /* renamed from: l  reason: collision with root package name */
    DimensionDependency f4736l;

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4737a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f4737a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4737a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4737a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f4735k = dependencyNode;
        this.f4736l = null;
        this.f4760h.f4704e = DependencyNode.Type.TOP;
        this.f4761i.f4704e = DependencyNode.Type.BOTTOM;
        dependencyNode.f4704e = DependencyNode.Type.BASELINE;
        this.f4758f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void a(Dependency dependency) {
        DimensionDependency dimensionDependency;
        float f8;
        float v7;
        float f9;
        int i8;
        ConstraintWidget constraintWidget;
        int i9 = AnonymousClass1.f4737a[this.f4762j.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 == 3) {
                    ConstraintWidget constraintWidget2 = this.f4754b;
                    n(dependency, constraintWidget2.P, constraintWidget2.R, 1);
                    return;
                }
            } else {
                o(dependency);
            }
        } else {
            p(dependency);
        }
        DimensionDependency dimensionDependency2 = this.f4757e;
        if (dimensionDependency2.f4702c && !dimensionDependency2.f4709j && this.f4756d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f4754b;
            int i10 = constraintWidget3.f4598x;
            if (i10 != 2) {
                if (i10 == 3 && constraintWidget3.f4560e.f4757e.f4709j) {
                    int w7 = constraintWidget3.w();
                    if (w7 != -1) {
                        if (w7 != 0) {
                            if (w7 != 1) {
                                i8 = 0;
                                this.f4757e.d(i8);
                            } else {
                                ConstraintWidget constraintWidget4 = this.f4754b;
                                f8 = constraintWidget4.f4560e.f4757e.f4706g;
                                v7 = constraintWidget4.v();
                            }
                        } else {
                            f9 = constraintWidget.f4560e.f4757e.f4706g * this.f4754b.v();
                            i8 = (int) (f9 + 0.5f);
                            this.f4757e.d(i8);
                        }
                    } else {
                        ConstraintWidget constraintWidget5 = this.f4754b;
                        f8 = constraintWidget5.f4560e.f4757e.f4706g;
                        v7 = constraintWidget5.v();
                    }
                    f9 = f8 / v7;
                    i8 = (int) (f9 + 0.5f);
                    this.f4757e.d(i8);
                }
            } else {
                ConstraintWidget K = constraintWidget3.K();
                if (K != null) {
                    if (K.f4562f.f4757e.f4709j) {
                        this.f4757e.d((int) ((dimensionDependency.f4706g * this.f4754b.E) + 0.5f));
                    }
                }
            }
        }
        DependencyNode dependencyNode = this.f4760h;
        if (dependencyNode.f4702c) {
            DependencyNode dependencyNode2 = this.f4761i;
            if (dependencyNode2.f4702c) {
                if (dependencyNode.f4709j && dependencyNode2.f4709j && this.f4757e.f4709j) {
                    return;
                }
                if (!this.f4757e.f4709j && this.f4756d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget6 = this.f4754b;
                    if (constraintWidget6.f4596w == 0 && !constraintWidget6.k0()) {
                        int i11 = this.f4760h.f4711l.get(0).f4706g;
                        DependencyNode dependencyNode3 = this.f4760h;
                        int i12 = i11 + dependencyNode3.f4705f;
                        int i13 = this.f4761i.f4711l.get(0).f4706g + this.f4761i.f4705f;
                        dependencyNode3.d(i12);
                        this.f4761i.d(i13);
                        this.f4757e.d(i13 - i12);
                        return;
                    }
                }
                if (!this.f4757e.f4709j && this.f4756d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f4753a == 1 && this.f4760h.f4711l.size() > 0 && this.f4761i.f4711l.size() > 0) {
                    int i14 = (this.f4761i.f4711l.get(0).f4706g + this.f4761i.f4705f) - (this.f4760h.f4711l.get(0).f4706g + this.f4760h.f4705f);
                    DimensionDependency dimensionDependency3 = this.f4757e;
                    int i15 = dimensionDependency3.f4721m;
                    if (i14 < i15) {
                        dimensionDependency3.d(i14);
                    } else {
                        dimensionDependency3.d(i15);
                    }
                }
                if (this.f4757e.f4709j && this.f4760h.f4711l.size() > 0 && this.f4761i.f4711l.size() > 0) {
                    DependencyNode dependencyNode4 = this.f4760h.f4711l.get(0);
                    DependencyNode dependencyNode5 = this.f4761i.f4711l.get(0);
                    int i16 = dependencyNode4.f4706g + this.f4760h.f4705f;
                    int i17 = dependencyNode5.f4706g + this.f4761i.f4705f;
                    float R = this.f4754b.R();
                    if (dependencyNode4 == dependencyNode5) {
                        i16 = dependencyNode4.f4706g;
                        i17 = dependencyNode5.f4706g;
                        R = 0.5f;
                    }
                    this.f4760h.d((int) (i16 + 0.5f + (((i17 - i16) - this.f4757e.f4706g) * R)));
                    this.f4761i.d(this.f4760h.f4706g + this.f4757e.f4706g);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget K;
        ConstraintWidget K2;
        ConstraintWidget constraintWidget = this.f4754b;
        if (constraintWidget.f4552a) {
            this.f4757e.d(constraintWidget.x());
        }
        if (!this.f4757e.f4709j) {
            this.f4756d = this.f4754b.T();
            if (this.f4754b.Z()) {
                this.f4736l = new BaselineDimensionDependency(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f4756d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (K2 = this.f4754b.K()) != null && K2.T() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int x7 = (K2.x() - this.f4754b.P.f()) - this.f4754b.R.f();
                    b(this.f4760h, K2.f4562f.f4760h, this.f4754b.P.f());
                    b(this.f4761i, K2.f4562f.f4761i, -this.f4754b.R.f());
                    this.f4757e.d(x7);
                    return;
                } else if (this.f4756d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f4757e.d(this.f4754b.x());
                }
            }
        } else if (this.f4756d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (K = this.f4754b.K()) != null && K.T() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.f4760h, K.f4562f.f4760h, this.f4754b.P.f());
            b(this.f4761i, K.f4562f.f4761i, -this.f4754b.R.f());
            return;
        }
        DimensionDependency dimensionDependency = this.f4757e;
        boolean z7 = dimensionDependency.f4709j;
        if (z7) {
            ConstraintWidget constraintWidget2 = this.f4754b;
            if (constraintWidget2.f4552a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.W;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f4537f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f4537f != null) {
                    if (constraintWidget2.k0()) {
                        this.f4760h.f4705f = this.f4754b.W[2].f();
                        this.f4761i.f4705f = -this.f4754b.W[3].f();
                    } else {
                        DependencyNode h8 = h(this.f4754b.W[2]);
                        if (h8 != null) {
                            b(this.f4760h, h8, this.f4754b.W[2].f());
                        }
                        DependencyNode h9 = h(this.f4754b.W[3]);
                        if (h9 != null) {
                            b(this.f4761i, h9, -this.f4754b.W[3].f());
                        }
                        this.f4760h.f4701b = true;
                        this.f4761i.f4701b = true;
                    }
                    if (this.f4754b.Z()) {
                        b(this.f4735k, this.f4760h, this.f4754b.p());
                        return;
                    }
                    return;
                } else if (constraintAnchor2 != null) {
                    DependencyNode h10 = h(constraintAnchor);
                    if (h10 != null) {
                        b(this.f4760h, h10, this.f4754b.W[2].f());
                        b(this.f4761i, this.f4760h, this.f4757e.f4706g);
                        if (this.f4754b.Z()) {
                            b(this.f4735k, this.f4760h, this.f4754b.p());
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                    if (constraintAnchor3.f4537f != null) {
                        DependencyNode h11 = h(constraintAnchor3);
                        if (h11 != null) {
                            b(this.f4761i, h11, -this.f4754b.W[3].f());
                            b(this.f4760h, this.f4761i, -this.f4757e.f4706g);
                        }
                        if (this.f4754b.Z()) {
                            b(this.f4735k, this.f4760h, this.f4754b.p());
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                    if (constraintAnchor4.f4537f != null) {
                        DependencyNode h12 = h(constraintAnchor4);
                        if (h12 != null) {
                            b(this.f4735k, h12, 0);
                            b(this.f4760h, this.f4735k, -this.f4754b.p());
                            b(this.f4761i, this.f4760h, this.f4757e.f4706g);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.K() != null && this.f4754b.o(ConstraintAnchor.Type.CENTER).f4537f == null) {
                        b(this.f4760h, this.f4754b.K().f4562f.f4760h, this.f4754b.Y());
                        b(this.f4761i, this.f4760h, this.f4757e.f4706g);
                        if (this.f4754b.Z()) {
                            b(this.f4735k, this.f4760h, this.f4754b.p());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        if (!z7 && this.f4756d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f4754b;
            int i8 = constraintWidget3.f4598x;
            if (i8 != 2) {
                if (i8 == 3 && !constraintWidget3.k0()) {
                    ConstraintWidget constraintWidget4 = this.f4754b;
                    if (constraintWidget4.f4596w != 3) {
                        DimensionDependency dimensionDependency2 = constraintWidget4.f4560e.f4757e;
                        this.f4757e.f4711l.add(dimensionDependency2);
                        dimensionDependency2.f4710k.add(this.f4757e);
                        DimensionDependency dimensionDependency3 = this.f4757e;
                        dimensionDependency3.f4701b = true;
                        dimensionDependency3.f4710k.add(this.f4760h);
                        this.f4757e.f4710k.add(this.f4761i);
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
        } else {
            dimensionDependency.b(this);
        }
        ConstraintWidget constraintWidget5 = this.f4754b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.W;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f4537f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f4537f != null) {
            if (constraintWidget5.k0()) {
                this.f4760h.f4705f = this.f4754b.W[2].f();
                this.f4761i.f4705f = -this.f4754b.W[3].f();
            } else {
                DependencyNode h13 = h(this.f4754b.W[2]);
                DependencyNode h14 = h(this.f4754b.W[3]);
                if (h13 != null) {
                    h13.b(this);
                }
                if (h14 != null) {
                    h14.b(this);
                }
                this.f4762j = WidgetRun.RunType.CENTER;
            }
            if (this.f4754b.Z()) {
                c(this.f4735k, this.f4760h, 1, this.f4736l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode h15 = h(constraintAnchor5);
            if (h15 != null) {
                b(this.f4760h, h15, this.f4754b.W[2].f());
                c(this.f4761i, this.f4760h, 1, this.f4757e);
                if (this.f4754b.Z()) {
                    c(this.f4735k, this.f4760h, 1, this.f4736l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f4756d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f4754b.v() > 0.0f) {
                    HorizontalWidgetRun horizontalWidgetRun = this.f4754b.f4560e;
                    if (horizontalWidgetRun.f4756d == dimensionBehaviour3) {
                        horizontalWidgetRun.f4757e.f4710k.add(this.f4757e);
                        this.f4757e.f4711l.add(this.f4754b.f4560e.f4757e);
                        this.f4757e.f4700a = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f4537f != null) {
                DependencyNode h16 = h(constraintAnchor7);
                if (h16 != null) {
                    b(this.f4761i, h16, -this.f4754b.W[3].f());
                    c(this.f4760h, this.f4761i, -1, this.f4757e);
                    if (this.f4754b.Z()) {
                        c(this.f4735k, this.f4760h, 1, this.f4736l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f4537f != null) {
                    DependencyNode h17 = h(constraintAnchor8);
                    if (h17 != null) {
                        b(this.f4735k, h17, 0);
                        c(this.f4760h, this.f4735k, -1, this.f4736l);
                        c(this.f4761i, this.f4760h, 1, this.f4757e);
                    }
                } else if (!(constraintWidget5 instanceof Helper) && constraintWidget5.K() != null) {
                    b(this.f4760h, this.f4754b.K().f4562f.f4760h, this.f4754b.Y());
                    c(this.f4761i, this.f4760h, 1, this.f4757e);
                    if (this.f4754b.Z()) {
                        c(this.f4735k, this.f4760h, 1, this.f4736l);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f4756d;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.f4754b.v() > 0.0f) {
                        HorizontalWidgetRun horizontalWidgetRun2 = this.f4754b.f4560e;
                        if (horizontalWidgetRun2.f4756d == dimensionBehaviour5) {
                            horizontalWidgetRun2.f4757e.f4710k.add(this.f4757e);
                            this.f4757e.f4711l.add(this.f4754b.f4560e.f4757e);
                            this.f4757e.f4700a = this;
                        }
                    }
                }
            }
        }
        if (this.f4757e.f4711l.size() == 0) {
            this.f4757e.f4702c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f4760h;
        if (dependencyNode.f4709j) {
            this.f4754b.n1(dependencyNode.f4706g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f4755c = null;
        this.f4760h.c();
        this.f4761i.c();
        this.f4735k.c();
        this.f4757e.c();
        this.f4759g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        if (this.f4756d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f4754b.f4598x == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f4759g = false;
        this.f4760h.c();
        this.f4760h.f4709j = false;
        this.f4761i.c();
        this.f4761i.f4709j = false;
        this.f4735k.c();
        this.f4735k.f4709j = false;
        this.f4757e.f4709j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f4754b.t();
    }
}
