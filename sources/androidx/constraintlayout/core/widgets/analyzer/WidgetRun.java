package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {

    /* renamed from: a  reason: collision with root package name */
    public int f4753a;

    /* renamed from: b  reason: collision with root package name */
    ConstraintWidget f4754b;

    /* renamed from: c  reason: collision with root package name */
    RunGroup f4755c;

    /* renamed from: d  reason: collision with root package name */
    protected ConstraintWidget.DimensionBehaviour f4756d;

    /* renamed from: e  reason: collision with root package name */
    DimensionDependency f4757e = new DimensionDependency(this);

    /* renamed from: f  reason: collision with root package name */
    public int f4758f = 0;

    /* renamed from: g  reason: collision with root package name */
    boolean f4759g = false;

    /* renamed from: h  reason: collision with root package name */
    public DependencyNode f4760h = new DependencyNode(this);

    /* renamed from: i  reason: collision with root package name */
    public DependencyNode f4761i = new DependencyNode(this);

    /* renamed from: j  reason: collision with root package name */
    protected RunType f4762j = RunType.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4763a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f4763a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4763a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4763a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4763a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4763a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f4754b = constraintWidget;
    }

    private void l(int i8, int i9) {
        WidgetRun widgetRun;
        float f8;
        int i10;
        int i11 = this.f4753a;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 == 3) {
                        ConstraintWidget constraintWidget = this.f4754b;
                        WidgetRun widgetRun2 = constraintWidget.f4560e;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun2.f4756d;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (dimensionBehaviour == dimensionBehaviour2 && widgetRun2.f4753a == 3) {
                            VerticalWidgetRun verticalWidgetRun = constraintWidget.f4562f;
                            if (verticalWidgetRun.f4756d == dimensionBehaviour2 && verticalWidgetRun.f4753a == 3) {
                                return;
                            }
                        }
                        if (i8 == 0) {
                            widgetRun2 = constraintWidget.f4562f;
                        }
                        if (widgetRun2.f4757e.f4709j) {
                            float v7 = constraintWidget.v();
                            if (i8 == 1) {
                                i10 = (int) ((widgetRun2.f4757e.f4706g / v7) + 0.5f);
                            } else {
                                i10 = (int) ((v7 * widgetRun2.f4757e.f4706g) + 0.5f);
                            }
                            this.f4757e.d(i10);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintWidget K = this.f4754b.K();
                if (K != null) {
                    if (i8 == 0) {
                        widgetRun = K.f4560e;
                    } else {
                        widgetRun = K.f4562f;
                    }
                    DimensionDependency dimensionDependency = widgetRun.f4757e;
                    if (dimensionDependency.f4709j) {
                        ConstraintWidget constraintWidget2 = this.f4754b;
                        if (i8 == 0) {
                            f8 = constraintWidget2.B;
                        } else {
                            f8 = constraintWidget2.E;
                        }
                        this.f4757e.d(g((int) ((dimensionDependency.f4706g * f8) + 0.5f), i8));
                        return;
                    }
                    return;
                }
                return;
            }
            this.f4757e.d(Math.min(g(this.f4757e.f4721m, i8), i9));
            return;
        }
        this.f4757e.d(g(i9, i8));
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void a(Dependency dependency) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i8) {
        dependencyNode.f4711l.add(dependencyNode2);
        dependencyNode.f4705f = i8;
        dependencyNode2.f4710k.add(dependencyNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i8, DimensionDependency dimensionDependency) {
        dependencyNode.f4711l.add(dependencyNode2);
        dependencyNode.f4711l.add(this.f4757e);
        dependencyNode.f4707h = i8;
        dependencyNode.f4708i = dimensionDependency;
        dependencyNode2.f4710k.add(dependencyNode);
        dimensionDependency.f4710k.add(dependencyNode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g(int i8, int i9) {
        int max;
        if (i9 == 0) {
            ConstraintWidget constraintWidget = this.f4754b;
            int i10 = constraintWidget.A;
            max = Math.max(constraintWidget.f4602z, i8);
            if (i10 > 0) {
                max = Math.min(i10, i8);
            }
            if (max == i8) {
                return i8;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f4754b;
            int i11 = constraintWidget2.D;
            max = Math.max(constraintWidget2.C, i8);
            if (i11 > 0) {
                max = Math.min(i11, i8);
            }
            if (max == i8) {
                return i8;
            }
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f4537f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f4535d;
        int i8 = AnonymousClass1.f4763a[constraintAnchor2.f4536e.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 != 5) {
                            return null;
                        }
                        return constraintWidget.f4562f.f4761i;
                    }
                    return constraintWidget.f4562f.f4735k;
                }
                return constraintWidget.f4562f.f4760h;
            }
            return constraintWidget.f4560e.f4761i;
        }
        return constraintWidget.f4560e.f4760h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DependencyNode i(ConstraintAnchor constraintAnchor, int i8) {
        WidgetRun widgetRun;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f4537f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f4535d;
        if (i8 == 0) {
            widgetRun = constraintWidget.f4560e;
        } else {
            widgetRun = constraintWidget.f4562f;
        }
        int i9 = AnonymousClass1.f4763a[constraintAnchor2.f4536e.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.f4761i;
        }
        return widgetRun.f4760h;
    }

    public long j() {
        DimensionDependency dimensionDependency = this.f4757e;
        if (dimensionDependency.f4709j) {
            return dimensionDependency.f4706g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f4759g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean m();

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i8) {
        float R;
        DependencyNode h8 = h(constraintAnchor);
        DependencyNode h9 = h(constraintAnchor2);
        if (h8.f4709j && h9.f4709j) {
            int f8 = h8.f4706g + constraintAnchor.f();
            int f9 = h9.f4706g - constraintAnchor2.f();
            int i9 = f9 - f8;
            if (!this.f4757e.f4709j && this.f4756d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                l(i8, i9);
            }
            DimensionDependency dimensionDependency = this.f4757e;
            if (!dimensionDependency.f4709j) {
                return;
            }
            if (dimensionDependency.f4706g == i9) {
                this.f4760h.d(f8);
                this.f4761i.d(f9);
                return;
            }
            ConstraintWidget constraintWidget = this.f4754b;
            if (i8 == 0) {
                R = constraintWidget.y();
            } else {
                R = constraintWidget.R();
            }
            if (h8 == h9) {
                f8 = h8.f4706g;
                f9 = h9.f4706g;
                R = 0.5f;
            }
            this.f4760h.d((int) (f8 + 0.5f + (((f9 - f8) - this.f4757e.f4706g) * R)));
            this.f4761i.d(this.f4760h.f4706g + this.f4757e.f4706g);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(Dependency dependency) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Dependency dependency) {
    }
}
