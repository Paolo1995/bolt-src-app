package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DependencyGraph {

    /* renamed from: a  reason: collision with root package name */
    private ConstraintWidgetContainer f4691a;

    /* renamed from: d  reason: collision with root package name */
    private ConstraintWidgetContainer f4694d;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4692b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4693c = true;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<WidgetRun> f4695e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<RunGroup> f4696f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private BasicMeasure.Measurer f4697g = null;

    /* renamed from: h  reason: collision with root package name */
    private BasicMeasure.Measure f4698h = new BasicMeasure.Measure();

    /* renamed from: i  reason: collision with root package name */
    ArrayList<RunGroup> f4699i = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f4691a = constraintWidgetContainer;
        this.f4694d = constraintWidgetContainer;
    }

    private void a(DependencyNode dependencyNode, int i8, int i9, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.f4703d;
        if (widgetRun.f4755c == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.f4691a;
            if (widgetRun != constraintWidgetContainer.f4560e && widgetRun != constraintWidgetContainer.f4562f) {
                if (runGroup == null) {
                    runGroup = new RunGroup(widgetRun, i9);
                    arrayList.add(runGroup);
                }
                widgetRun.f4755c = runGroup;
                runGroup.a(widgetRun);
                for (Dependency dependency : widgetRun.f4760h.f4710k) {
                    if (dependency instanceof DependencyNode) {
                        a((DependencyNode) dependency, i8, 0, dependencyNode2, arrayList, runGroup);
                    }
                }
                for (Dependency dependency2 : widgetRun.f4761i.f4710k) {
                    if (dependency2 instanceof DependencyNode) {
                        a((DependencyNode) dependency2, i8, 1, dependencyNode2, arrayList, runGroup);
                    }
                }
                if (i8 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).f4735k.f4710k) {
                        if (dependency3 instanceof DependencyNode) {
                            a((DependencyNode) dependency3, i8, 2, dependencyNode2, arrayList, runGroup);
                        }
                    }
                }
                for (DependencyNode dependencyNode3 : widgetRun.f4760h.f4711l) {
                    if (dependencyNode3 == dependencyNode2) {
                        runGroup.f4729b = true;
                    }
                    a(dependencyNode3, i8, 0, dependencyNode2, arrayList, runGroup);
                }
                for (DependencyNode dependencyNode4 : widgetRun.f4761i.f4711l) {
                    if (dependencyNode4 == dependencyNode2) {
                        runGroup.f4729b = true;
                    }
                    a(dependencyNode4, i8, 1, dependencyNode2, arrayList, runGroup);
                }
                if (i8 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (DependencyNode dependencyNode5 : ((VerticalWidgetRun) widgetRun).f4735k.f4711l) {
                        a(dependencyNode5, i8, 2, dependencyNode2, arrayList, runGroup);
                    }
                }
            }
        }
    }

    private boolean b(ConstraintWidgetContainer constraintWidgetContainer) {
        int i8;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i9;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        Iterator<ConstraintWidget> it = constraintWidgetContainer.L0.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.Z;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[1];
            if (next.V() == 8) {
                next.f4552a = true;
            } else {
                if (next.B < 1.0f && dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.f4596w = 2;
                }
                if (next.E < 1.0f && dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.f4598x = 2;
                }
                if (next.v() > 0.0f) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour5 == dimensionBehaviour7 && (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.f4596w = 3;
                    } else if (dimensionBehaviour6 == dimensionBehaviour7 && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.f4598x = 3;
                    } else if (dimensionBehaviour5 == dimensionBehaviour7 && dimensionBehaviour6 == dimensionBehaviour7) {
                        if (next.f4596w == 0) {
                            next.f4596w = 3;
                        }
                        if (next.f4598x == 0) {
                            next.f4598x = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour5 == dimensionBehaviour8 && next.f4596w == 1 && (next.O.f4537f == null || next.Q.f4537f == null)) {
                    dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = dimensionBehaviour5;
                if (dimensionBehaviour6 == dimensionBehaviour8 && next.f4598x == 1 && (next.P.f4537f == null || next.R.f4537f == null)) {
                    dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = dimensionBehaviour6;
                HorizontalWidgetRun horizontalWidgetRun = next.f4560e;
                horizontalWidgetRun.f4756d = dimensionBehaviour9;
                int i10 = next.f4596w;
                horizontalWidgetRun.f4753a = i10;
                VerticalWidgetRun verticalWidgetRun = next.f4562f;
                verticalWidgetRun.f4756d = dimensionBehaviour10;
                int i11 = next.f4598x;
                verticalWidgetRun.f4753a = i11;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((dimensionBehaviour9 != dimensionBehaviour11 && dimensionBehaviour9 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour9 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour10 != dimensionBehaviour11 && dimensionBehaviour10 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour10 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    if (dimensionBehaviour9 == dimensionBehaviour8 && (dimensionBehaviour10 == (dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i10 == 3) {
                            if (dimensionBehaviour10 == dimensionBehaviour4) {
                                l(next, dimensionBehaviour4, 0, dimensionBehaviour4, 0);
                            }
                            int x7 = next.x();
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.FIXED;
                            l(next, dimensionBehaviour12, (int) ((x7 * next.f4559d0) + 0.5f), dimensionBehaviour12, x7);
                            next.f4560e.f4757e.d(next.W());
                            next.f4562f.f4757e.d(next.x());
                            next.f4552a = true;
                        } else if (i10 == 1) {
                            l(next, dimensionBehaviour4, 0, dimensionBehaviour10, 0);
                            next.f4560e.f4757e.f4721m = next.W();
                        } else if (i10 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = constraintWidgetContainer.Z[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour13 == dimensionBehaviour14 || dimensionBehaviour13 == dimensionBehaviour11) {
                                l(next, dimensionBehaviour14, (int) ((next.B * constraintWidgetContainer.W()) + 0.5f), dimensionBehaviour10, next.x());
                                next.f4560e.f4757e.d(next.W());
                                next.f4562f.f4757e.d(next.x());
                                next.f4552a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = next.W;
                            if (constraintAnchorArr[0].f4537f == null || constraintAnchorArr[1].f4537f == null) {
                                l(next, dimensionBehaviour4, 0, dimensionBehaviour10, 0);
                                next.f4560e.f4757e.d(next.W());
                                next.f4562f.f4757e.d(next.x());
                                next.f4552a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour10 == dimensionBehaviour8 && (dimensionBehaviour9 == (dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i11 == 3) {
                            if (dimensionBehaviour9 == dimensionBehaviour3) {
                                l(next, dimensionBehaviour3, 0, dimensionBehaviour3, 0);
                            }
                            int W = next.W();
                            float f8 = next.f4559d0;
                            if (next.w() == -1) {
                                f8 = 1.0f / f8;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = ConstraintWidget.DimensionBehaviour.FIXED;
                            l(next, dimensionBehaviour15, W, dimensionBehaviour15, (int) ((W * f8) + 0.5f));
                            next.f4560e.f4757e.d(next.W());
                            next.f4562f.f4757e.d(next.x());
                            next.f4552a = true;
                        } else if (i11 == 1) {
                            l(next, dimensionBehaviour9, 0, dimensionBehaviour3, 0);
                            next.f4562f.f4757e.f4721m = next.x();
                        } else if (i11 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = constraintWidgetContainer.Z[1];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour16 == dimensionBehaviour17 || dimensionBehaviour16 == dimensionBehaviour11) {
                                l(next, dimensionBehaviour9, next.W(), dimensionBehaviour17, (int) ((next.E * constraintWidgetContainer.x()) + 0.5f));
                                next.f4560e.f4757e.d(next.W());
                                next.f4562f.f4757e.d(next.x());
                                next.f4552a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = next.W;
                            if (constraintAnchorArr2[2].f4537f == null || constraintAnchorArr2[3].f4537f == null) {
                                l(next, dimensionBehaviour3, 0, dimensionBehaviour10, 0);
                                next.f4560e.f4757e.d(next.W());
                                next.f4562f.f4757e.d(next.x());
                                next.f4552a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour9 == dimensionBehaviour8 && dimensionBehaviour10 == dimensionBehaviour8) {
                        if (i10 != 1 && i11 != 1) {
                            if (i11 == 2 && i10 == 2) {
                                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer.Z;
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = dimensionBehaviourArr2[0];
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour19 = ConstraintWidget.DimensionBehaviour.FIXED;
                                if (dimensionBehaviour18 == dimensionBehaviour19 && dimensionBehaviourArr2[1] == dimensionBehaviour19) {
                                    l(next, dimensionBehaviour19, (int) ((next.B * constraintWidgetContainer.W()) + 0.5f), dimensionBehaviour19, (int) ((next.E * constraintWidgetContainer.x()) + 0.5f));
                                    next.f4560e.f4757e.d(next.W());
                                    next.f4562f.f4757e.d(next.x());
                                    next.f4552a = true;
                                }
                            }
                        } else {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            l(next, dimensionBehaviour20, 0, dimensionBehaviour20, 0);
                            next.f4560e.f4757e.f4721m = next.W();
                            next.f4562f.f4757e.f4721m = next.x();
                        }
                    }
                } else {
                    int W2 = next.W();
                    if (dimensionBehaviour9 == dimensionBehaviour11) {
                        i8 = (constraintWidgetContainer.W() - next.O.f4538g) - next.Q.f4538g;
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i8 = W2;
                        dimensionBehaviour = dimensionBehaviour9;
                    }
                    int x8 = next.x();
                    if (dimensionBehaviour10 == dimensionBehaviour11) {
                        i9 = (constraintWidgetContainer.x() - next.P.f4538g) - next.R.f4538g;
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i9 = x8;
                        dimensionBehaviour2 = dimensionBehaviour10;
                    }
                    l(next, dimensionBehaviour, i8, dimensionBehaviour2, i9);
                    next.f4560e.f4757e.d(next.W());
                    next.f4562f.f4757e.d(next.x());
                    next.f4552a = true;
                }
            }
        }
        return false;
    }

    private int e(ConstraintWidgetContainer constraintWidgetContainer, int i8) {
        int size = this.f4699i.size();
        long j8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            j8 = Math.max(j8, this.f4699i.get(i9).b(constraintWidgetContainer, i8));
        }
        return (int) j8;
    }

    private void i(WidgetRun widgetRun, int i8, ArrayList<RunGroup> arrayList) {
        for (Dependency dependency : widgetRun.f4760h.f4710k) {
            if (dependency instanceof DependencyNode) {
                a((DependencyNode) dependency, i8, 0, widgetRun.f4761i, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                a(((WidgetRun) dependency).f4760h, i8, 0, widgetRun.f4761i, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.f4761i.f4710k) {
            if (dependency2 instanceof DependencyNode) {
                a((DependencyNode) dependency2, i8, 1, widgetRun.f4760h, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                a(((WidgetRun) dependency2).f4761i, i8, 1, widgetRun.f4760h, arrayList, null);
            }
        }
        if (i8 == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).f4735k.f4710k) {
                if (dependency3 instanceof DependencyNode) {
                    a((DependencyNode) dependency3, i8, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i8, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i9) {
        BasicMeasure.Measure measure = this.f4698h;
        measure.f4679a = dimensionBehaviour;
        measure.f4680b = dimensionBehaviour2;
        measure.f4681c = i8;
        measure.f4682d = i9;
        this.f4697g.b(constraintWidget, measure);
        constraintWidget.k1(this.f4698h.f4683e);
        constraintWidget.L0(this.f4698h.f4684f);
        constraintWidget.K0(this.f4698h.f4686h);
        constraintWidget.A0(this.f4698h.f4685g);
    }

    public void c() {
        d(this.f4695e);
        this.f4699i.clear();
        RunGroup.f4727h = 0;
        i(this.f4691a.f4560e, 0, this.f4699i);
        i(this.f4691a.f4562f, 1, this.f4699i);
        this.f4692b = false;
    }

    public void d(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.f4694d.f4560e.f();
        this.f4694d.f4562f.f();
        arrayList.add(this.f4694d.f4560e);
        arrayList.add(this.f4694d.f4562f);
        Iterator<ConstraintWidget> it = this.f4694d.L0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                arrayList.add(new GuidelineReference(next));
            } else {
                if (next.i0()) {
                    if (next.f4556c == null) {
                        next.f4556c = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f4556c);
                } else {
                    arrayList.add(next.f4560e);
                }
                if (next.k0()) {
                    if (next.f4558d == null) {
                        next.f4558d = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f4558d);
                } else {
                    arrayList.add(next.f4562f);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.f4754b != this.f4694d) {
                next2.d();
            }
        }
    }

    public boolean f(boolean z7) {
        boolean z8;
        boolean z9 = true;
        boolean z10 = z7 & true;
        if (this.f4692b || this.f4693c) {
            Iterator<ConstraintWidget> it = this.f4691a.L0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.n();
                next.f4552a = false;
                next.f4560e.r();
                next.f4562f.q();
            }
            this.f4691a.n();
            ConstraintWidgetContainer constraintWidgetContainer = this.f4691a;
            constraintWidgetContainer.f4552a = false;
            constraintWidgetContainer.f4560e.r();
            this.f4691a.f4562f.q();
            this.f4693c = false;
        }
        if (b(this.f4694d)) {
            return false;
        }
        this.f4691a.m1(0);
        this.f4691a.n1(0);
        ConstraintWidget.DimensionBehaviour u7 = this.f4691a.u(0);
        ConstraintWidget.DimensionBehaviour u8 = this.f4691a.u(1);
        if (this.f4692b) {
            c();
        }
        int X = this.f4691a.X();
        int Y = this.f4691a.Y();
        this.f4691a.f4560e.f4760h.d(X);
        this.f4691a.f4562f.f4760h.d(Y);
        m();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (u7 == dimensionBehaviour || u8 == dimensionBehaviour) {
            if (z10) {
                Iterator<WidgetRun> it2 = this.f4695e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (!it2.next().m()) {
                        z10 = false;
                        break;
                    }
                }
            }
            if (z10 && u7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f4691a.P0(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.f4691a;
                constraintWidgetContainer2.k1(e(constraintWidgetContainer2, 0));
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f4691a;
                constraintWidgetContainer3.f4560e.f4757e.d(constraintWidgetContainer3.W());
            }
            if (z10 && u8 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f4691a.g1(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer4 = this.f4691a;
                constraintWidgetContainer4.L0(e(constraintWidgetContainer4, 1));
                ConstraintWidgetContainer constraintWidgetContainer5 = this.f4691a;
                constraintWidgetContainer5.f4562f.f4757e.d(constraintWidgetContainer5.x());
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer6 = this.f4691a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidgetContainer6.Z[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 != dimensionBehaviour3 && dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            z8 = false;
        } else {
            int W = constraintWidgetContainer6.W() + X;
            this.f4691a.f4560e.f4761i.d(W);
            this.f4691a.f4560e.f4757e.d(W - X);
            m();
            ConstraintWidgetContainer constraintWidgetContainer7 = this.f4691a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer7.Z[1];
            if (dimensionBehaviour4 == dimensionBehaviour3 || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int x7 = constraintWidgetContainer7.x() + Y;
                this.f4691a.f4562f.f4761i.d(x7);
                this.f4691a.f4562f.f4757e.d(x7 - Y);
            }
            m();
            z8 = true;
        }
        Iterator<WidgetRun> it3 = this.f4695e.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.f4754b != this.f4691a || next2.f4759g) {
                next2.e();
            }
        }
        Iterator<WidgetRun> it4 = this.f4695e.iterator();
        while (it4.hasNext()) {
            WidgetRun next3 = it4.next();
            if (z8 || next3.f4754b != this.f4691a) {
                if (!next3.f4760h.f4709j || ((!next3.f4761i.f4709j && !(next3 instanceof GuidelineReference)) || (!next3.f4757e.f4709j && !(next3 instanceof ChainRun) && !(next3 instanceof GuidelineReference)))) {
                    z9 = false;
                    break;
                }
            }
        }
        this.f4691a.P0(u7);
        this.f4691a.g1(u8);
        return z9;
    }

    public boolean g(boolean z7) {
        if (this.f4692b) {
            Iterator<ConstraintWidget> it = this.f4691a.L0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.n();
                next.f4552a = false;
                HorizontalWidgetRun horizontalWidgetRun = next.f4560e;
                horizontalWidgetRun.f4757e.f4709j = false;
                horizontalWidgetRun.f4759g = false;
                horizontalWidgetRun.r();
                VerticalWidgetRun verticalWidgetRun = next.f4562f;
                verticalWidgetRun.f4757e.f4709j = false;
                verticalWidgetRun.f4759g = false;
                verticalWidgetRun.q();
            }
            this.f4691a.n();
            ConstraintWidgetContainer constraintWidgetContainer = this.f4691a;
            constraintWidgetContainer.f4552a = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.f4560e;
            horizontalWidgetRun2.f4757e.f4709j = false;
            horizontalWidgetRun2.f4759g = false;
            horizontalWidgetRun2.r();
            VerticalWidgetRun verticalWidgetRun2 = this.f4691a.f4562f;
            verticalWidgetRun2.f4757e.f4709j = false;
            verticalWidgetRun2.f4759g = false;
            verticalWidgetRun2.q();
            c();
        }
        if (b(this.f4694d)) {
            return false;
        }
        this.f4691a.m1(0);
        this.f4691a.n1(0);
        this.f4691a.f4560e.f4760h.d(0);
        this.f4691a.f4562f.f4760h.d(0);
        return true;
    }

    public boolean h(boolean z7, int i8) {
        boolean z8;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z9 = true;
        boolean z10 = z7 & true;
        ConstraintWidget.DimensionBehaviour u7 = this.f4691a.u(0);
        ConstraintWidget.DimensionBehaviour u8 = this.f4691a.u(1);
        int X = this.f4691a.X();
        int Y = this.f4691a.Y();
        if (z10 && (u7 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || u8 == dimensionBehaviour)) {
            Iterator<WidgetRun> it = this.f4695e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.f4758f == i8 && !next.m()) {
                    z10 = false;
                    break;
                }
            }
            if (i8 == 0) {
                if (z10 && u7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.f4691a.P0(ConstraintWidget.DimensionBehaviour.FIXED);
                    ConstraintWidgetContainer constraintWidgetContainer = this.f4691a;
                    constraintWidgetContainer.k1(e(constraintWidgetContainer, 0));
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f4691a;
                    constraintWidgetContainer2.f4560e.f4757e.d(constraintWidgetContainer2.W());
                }
            } else if (z10 && u8 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f4691a.g1(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f4691a;
                constraintWidgetContainer3.L0(e(constraintWidgetContainer3, 1));
                ConstraintWidgetContainer constraintWidgetContainer4 = this.f4691a;
                constraintWidgetContainer4.f4562f.f4757e.d(constraintWidgetContainer4.x());
            }
        }
        if (i8 == 0) {
            ConstraintWidgetContainer constraintWidgetContainer5 = this.f4691a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidgetContainer5.Z[0];
            if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int W = constraintWidgetContainer5.W() + X;
                this.f4691a.f4560e.f4761i.d(W);
                this.f4691a.f4560e.f4757e.d(W - X);
                z8 = true;
            }
            z8 = false;
        } else {
            ConstraintWidgetContainer constraintWidgetContainer6 = this.f4691a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = constraintWidgetContainer6.Z[1];
            if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int x7 = constraintWidgetContainer6.x() + Y;
                this.f4691a.f4562f.f4761i.d(x7);
                this.f4691a.f4562f.f4757e.d(x7 - Y);
                z8 = true;
            }
            z8 = false;
        }
        m();
        Iterator<WidgetRun> it2 = this.f4695e.iterator();
        while (it2.hasNext()) {
            WidgetRun next2 = it2.next();
            if (next2.f4758f == i8 && (next2.f4754b != this.f4691a || next2.f4759g)) {
                next2.e();
            }
        }
        Iterator<WidgetRun> it3 = this.f4695e.iterator();
        while (it3.hasNext()) {
            WidgetRun next3 = it3.next();
            if (next3.f4758f == i8 && (z8 || next3.f4754b != this.f4691a)) {
                if (!next3.f4760h.f4709j || !next3.f4761i.f4709j || (!(next3 instanceof ChainRun) && !next3.f4757e.f4709j)) {
                    z9 = false;
                    break;
                }
            }
        }
        this.f4691a.P0(u7);
        this.f4691a.g1(u8);
        return z9;
    }

    public void j() {
        this.f4692b = true;
    }

    public void k() {
        this.f4693c = true;
    }

    public void m() {
        boolean z7;
        DimensionDependency dimensionDependency;
        Iterator<ConstraintWidget> it = this.f4691a.L0.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.f4552a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.Z;
                boolean z8 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i8 = next.f4596w;
                int i9 = next.f4598x;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour != dimensionBehaviour3 && (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || i8 != 1)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i9 == 1)) {
                    z8 = true;
                }
                DimensionDependency dimensionDependency2 = next.f4560e.f4757e;
                boolean z9 = dimensionDependency2.f4709j;
                DimensionDependency dimensionDependency3 = next.f4562f.f4757e;
                boolean z10 = dimensionDependency3.f4709j;
                if (z9 && z10) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    l(next, dimensionBehaviour4, dimensionDependency2.f4706g, dimensionBehaviour4, dimensionDependency3.f4706g);
                    next.f4552a = true;
                } else if (z9 && z8) {
                    l(next, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency2.f4706g, dimensionBehaviour3, dimensionDependency3.f4706g);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.f4562f.f4757e.f4721m = next.x();
                    } else {
                        next.f4562f.f4757e.d(next.x());
                        next.f4552a = true;
                    }
                } else if (z10 && z7) {
                    l(next, dimensionBehaviour3, dimensionDependency2.f4706g, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency3.f4706g);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.f4560e.f4757e.f4721m = next.W();
                    } else {
                        next.f4560e.f4757e.d(next.W());
                        next.f4552a = true;
                    }
                }
                if (next.f4552a && (dimensionDependency = next.f4562f.f4736l) != null) {
                    dimensionDependency.d(next.p());
                }
            }
        }
    }

    public void n(BasicMeasure.Measurer measurer) {
        this.f4697g = measurer;
    }
}
