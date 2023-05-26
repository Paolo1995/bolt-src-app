package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Direct {

    /* renamed from: a  reason: collision with root package name */
    private static BasicMeasure.Measure f4722a = new BasicMeasure.Measure();

    /* renamed from: b  reason: collision with root package name */
    private static int f4723b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f4724c = 0;

    private static boolean a(int i8, ConstraintWidget constraintWidget) {
        ConstraintWidgetContainer constraintWidgetContainer;
        boolean z7;
        boolean z8;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour A = constraintWidget.A();
        ConstraintWidget.DimensionBehaviour T = constraintWidget.T();
        if (constraintWidget.K() != null) {
            constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.K();
        } else {
            constraintWidgetContainer = null;
        }
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.A();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.T();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (A != dimensionBehaviour5 && !constraintWidget.n0() && A != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && ((A != (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || constraintWidget.f4596w != 0 || constraintWidget.f4559d0 != 0.0f || !constraintWidget.a0(0)) && (A != dimensionBehaviour2 || constraintWidget.f4596w != 1 || !constraintWidget.d0(0, constraintWidget.W())))) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (T != dimensionBehaviour5 && !constraintWidget.o0() && T != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && ((T != (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || constraintWidget.f4598x != 0 || constraintWidget.f4559d0 != 0.0f || !constraintWidget.a0(1)) && (T != dimensionBehaviour || constraintWidget.f4598x != 1 || !constraintWidget.d0(1, constraintWidget.x())))) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (constraintWidget.f4559d0 > 0.0f && (z7 || z8)) {
            return true;
        }
        if (!z7 || !z8) {
            return false;
        }
        return true;
    }

    private static void b(int i8, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z7) {
        boolean z8;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z9;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.g0()) {
            return;
        }
        f4723b++;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.m0()) {
            int i9 = i8 + 1;
            if (a(i9, constraintWidget)) {
                ConstraintWidgetContainer.S1(i9, constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f4676k);
            }
        }
        ConstraintAnchor o8 = constraintWidget.o(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor o9 = constraintWidget.o(ConstraintAnchor.Type.RIGHT);
        int e8 = o8.e();
        int e9 = o9.e();
        if (o8.d() != null && o8.n()) {
            Iterator<ConstraintAnchor> it = o8.d().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.f4535d;
                int i10 = i8 + 1;
                boolean a8 = a(i10, constraintWidget2);
                if (constraintWidget2.m0() && a8) {
                    ConstraintWidgetContainer.S1(i10, constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f4676k);
                }
                if ((next == constraintWidget2.O && (constraintAnchor4 = constraintWidget2.Q.f4537f) != null && constraintAnchor4.n()) || (next == constraintWidget2.Q && (constraintAnchor3 = constraintWidget2.O.f4537f) != null && constraintAnchor3.n())) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                ConstraintWidget.DimensionBehaviour A = constraintWidget2.A();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (A == dimensionBehaviour && !a8) {
                    if (constraintWidget2.A() == dimensionBehaviour && constraintWidget2.A >= 0 && constraintWidget2.f4602z >= 0 && ((constraintWidget2.V() == 8 || (constraintWidget2.f4596w == 0 && constraintWidget2.v() == 0.0f)) && !constraintWidget2.i0() && !constraintWidget2.l0() && z9 && !constraintWidget2.i0())) {
                        e(i10, constraintWidget, measurer, constraintWidget2, z7);
                    }
                } else if (!constraintWidget2.m0()) {
                    ConstraintAnchor constraintAnchor5 = constraintWidget2.O;
                    if (next == constraintAnchor5 && constraintWidget2.Q.f4537f == null) {
                        int f8 = constraintAnchor5.f() + e8;
                        constraintWidget2.F0(f8, constraintWidget2.W() + f8);
                        b(i10, constraintWidget2, measurer, z7);
                    } else {
                        ConstraintAnchor constraintAnchor6 = constraintWidget2.Q;
                        if (next == constraintAnchor6 && constraintAnchor5.f4537f == null) {
                            int f9 = e8 - constraintAnchor6.f();
                            constraintWidget2.F0(f9 - constraintWidget2.W(), f9);
                            b(i10, constraintWidget2, measurer, z7);
                        } else if (z9 && !constraintWidget2.i0()) {
                            d(i10, measurer, constraintWidget2, z7);
                        }
                    }
                }
            }
        }
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (o9.d() != null && o9.n()) {
            Iterator<ConstraintAnchor> it2 = o9.d().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.f4535d;
                int i11 = i8 + 1;
                boolean a9 = a(i11, constraintWidget3);
                if (constraintWidget3.m0() && a9) {
                    ConstraintWidgetContainer.S1(i11, constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f4676k);
                }
                if ((next2 == constraintWidget3.O && (constraintAnchor2 = constraintWidget3.Q.f4537f) != null && constraintAnchor2.n()) || (next2 == constraintWidget3.Q && (constraintAnchor = constraintWidget3.O.f4537f) != null && constraintAnchor.n())) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                ConstraintWidget.DimensionBehaviour A2 = constraintWidget3.A();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (A2 == dimensionBehaviour2 && !a9) {
                    if (constraintWidget3.A() == dimensionBehaviour2 && constraintWidget3.A >= 0 && constraintWidget3.f4602z >= 0 && (constraintWidget3.V() == 8 || (constraintWidget3.f4596w == 0 && constraintWidget3.v() == 0.0f))) {
                        if (!constraintWidget3.i0() && !constraintWidget3.l0() && z8 && !constraintWidget3.i0()) {
                            e(i11, constraintWidget, measurer, constraintWidget3, z7);
                        }
                    }
                } else if (!constraintWidget3.m0()) {
                    ConstraintAnchor constraintAnchor7 = constraintWidget3.O;
                    if (next2 == constraintAnchor7 && constraintWidget3.Q.f4537f == null) {
                        int f10 = constraintAnchor7.f() + e9;
                        constraintWidget3.F0(f10, constraintWidget3.W() + f10);
                        b(i11, constraintWidget3, measurer, z7);
                    } else {
                        ConstraintAnchor constraintAnchor8 = constraintWidget3.Q;
                        if (next2 == constraintAnchor8 && constraintAnchor7.f4537f == null) {
                            int f11 = e9 - constraintAnchor8.f();
                            constraintWidget3.F0(f11 - constraintWidget3.W(), f11);
                            b(i11, constraintWidget3, measurer, z7);
                        } else if (z8 && !constraintWidget3.i0()) {
                            d(i11, measurer, constraintWidget3, z7);
                        }
                    }
                }
            }
        }
        constraintWidget.q0();
    }

    private static void c(int i8, Barrier barrier, BasicMeasure.Measurer measurer, int i9, boolean z7) {
        if (barrier.t1()) {
            if (i9 == 0) {
                b(i8 + 1, barrier, measurer, z7);
            } else {
                i(i8 + 1, barrier, measurer);
            }
        }
    }

    private static void d(int i8, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget, boolean z7) {
        float f8;
        float y7 = constraintWidget.y();
        int e8 = constraintWidget.O.f4537f.e();
        int e9 = constraintWidget.Q.f4537f.e();
        int f9 = constraintWidget.O.f() + e8;
        int f10 = e9 - constraintWidget.Q.f();
        if (e8 == e9) {
            y7 = 0.5f;
        } else {
            e8 = f9;
            e9 = f10;
        }
        int W = constraintWidget.W();
        int i9 = (e9 - e8) - W;
        if (e8 > e9) {
            i9 = (e8 - e9) - W;
        }
        if (i9 > 0) {
            f8 = (y7 * i9) + 0.5f;
        } else {
            f8 = y7 * i9;
        }
        int i10 = ((int) f8) + e8;
        int i11 = i10 + W;
        if (e8 > e9) {
            i11 = i10 - W;
        }
        constraintWidget.F0(i10, i11);
        b(i8 + 1, constraintWidget, measurer, z7);
    }

    private static void e(int i8, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z7) {
        int W;
        float y7 = constraintWidget2.y();
        int e8 = constraintWidget2.O.f4537f.e() + constraintWidget2.O.f();
        int e9 = constraintWidget2.Q.f4537f.e() - constraintWidget2.Q.f();
        if (e9 >= e8) {
            int W2 = constraintWidget2.W();
            if (constraintWidget2.V() != 8) {
                int i9 = constraintWidget2.f4596w;
                if (i9 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        W = constraintWidget.W();
                    } else {
                        W = constraintWidget.K().W();
                    }
                    W2 = (int) (constraintWidget2.y() * 0.5f * W);
                } else if (i9 == 0) {
                    W2 = e9 - e8;
                }
                W2 = Math.max(constraintWidget2.f4602z, W2);
                int i10 = constraintWidget2.A;
                if (i10 > 0) {
                    W2 = Math.min(i10, W2);
                }
            }
            int i11 = e8 + ((int) ((y7 * ((e9 - e8) - W2)) + 0.5f));
            constraintWidget2.F0(i11, W2 + i11);
            b(i8 + 1, constraintWidget2, measurer, z7);
        }
    }

    private static void f(int i8, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float f8;
        float R = constraintWidget.R();
        int e8 = constraintWidget.P.f4537f.e();
        int e9 = constraintWidget.R.f4537f.e();
        int f9 = constraintWidget.P.f() + e8;
        int f10 = e9 - constraintWidget.R.f();
        if (e8 == e9) {
            R = 0.5f;
        } else {
            e8 = f9;
            e9 = f10;
        }
        int x7 = constraintWidget.x();
        int i9 = (e9 - e8) - x7;
        if (e8 > e9) {
            i9 = (e8 - e9) - x7;
        }
        if (i9 > 0) {
            f8 = (R * i9) + 0.5f;
        } else {
            f8 = R * i9;
        }
        int i10 = (int) f8;
        int i11 = e8 + i10;
        int i12 = i11 + x7;
        if (e8 > e9) {
            i11 = e8 - i10;
            i12 = i11 - x7;
        }
        constraintWidget.I0(i11, i12);
        i(i8 + 1, constraintWidget, measurer);
    }

    private static void g(int i8, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        int x7;
        float R = constraintWidget2.R();
        int e8 = constraintWidget2.P.f4537f.e() + constraintWidget2.P.f();
        int e9 = constraintWidget2.R.f4537f.e() - constraintWidget2.R.f();
        if (e9 >= e8) {
            int x8 = constraintWidget2.x();
            if (constraintWidget2.V() != 8) {
                int i9 = constraintWidget2.f4598x;
                if (i9 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        x7 = constraintWidget.x();
                    } else {
                        x7 = constraintWidget.K().x();
                    }
                    x8 = (int) (R * 0.5f * x7);
                } else if (i9 == 0) {
                    x8 = e9 - e8;
                }
                x8 = Math.max(constraintWidget2.C, x8);
                int i10 = constraintWidget2.D;
                if (i10 > 0) {
                    x8 = Math.min(i10, x8);
                }
            }
            int i11 = e8 + ((int) ((R * ((e9 - e8) - x8)) + 0.5f));
            constraintWidget2.I0(i11, x8 + i11);
            i(i8 + 1, constraintWidget2, measurer);
        }
    }

    public static void h(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        ConstraintWidget.DimensionBehaviour A = constraintWidgetContainer.A();
        ConstraintWidget.DimensionBehaviour T = constraintWidgetContainer.T();
        f4723b = 0;
        f4724c = 0;
        constraintWidgetContainer.v0();
        ArrayList<ConstraintWidget> r12 = constraintWidgetContainer.r1();
        int size = r12.size();
        for (int i8 = 0; i8 < size; i8++) {
            r12.get(i8).v0();
        }
        boolean P1 = constraintWidgetContainer.P1();
        if (A == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.F0(0, constraintWidgetContainer.W());
        } else {
            constraintWidgetContainer.G0(0);
        }
        boolean z7 = false;
        boolean z8 = false;
        for (int i9 = 0; i9 < size; i9++) {
            ConstraintWidget constraintWidget = r12.get(i9);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.s1() == 1) {
                    if (guideline.t1() != -1) {
                        guideline.w1(guideline.t1());
                    } else if (guideline.u1() != -1 && constraintWidgetContainer.n0()) {
                        guideline.w1(constraintWidgetContainer.W() - guideline.u1());
                    } else if (constraintWidgetContainer.n0()) {
                        guideline.w1((int) ((guideline.v1() * constraintWidgetContainer.W()) + 0.5f));
                    }
                    z7 = true;
                }
            } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).x1() == 0) {
                z8 = true;
            }
        }
        if (z7) {
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget2 = r12.get(i10);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.s1() == 1) {
                        b(0, guideline2, measurer, P1);
                    }
                }
            }
        }
        b(0, constraintWidgetContainer, measurer, P1);
        if (z8) {
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget3 = r12.get(i11);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    if (barrier.x1() == 0) {
                        c(0, barrier, measurer, 0, P1);
                    }
                }
            }
        }
        if (T == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.I0(0, constraintWidgetContainer.x());
        } else {
            constraintWidgetContainer.H0(0);
        }
        boolean z9 = false;
        boolean z10 = false;
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget4 = r12.get(i12);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.s1() == 0) {
                    if (guideline3.t1() != -1) {
                        guideline3.w1(guideline3.t1());
                    } else if (guideline3.u1() != -1 && constraintWidgetContainer.o0()) {
                        guideline3.w1(constraintWidgetContainer.x() - guideline3.u1());
                    } else if (constraintWidgetContainer.o0()) {
                        guideline3.w1((int) ((guideline3.v1() * constraintWidgetContainer.x()) + 0.5f));
                    }
                    z9 = true;
                }
            } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).x1() == 1) {
                z10 = true;
            }
        }
        if (z9) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget5 = r12.get(i13);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.s1() == 0) {
                        i(1, guideline4, measurer);
                    }
                }
            }
        }
        i(0, constraintWidgetContainer, measurer);
        if (z10) {
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget6 = r12.get(i14);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    if (barrier2.x1() == 1) {
                        c(0, barrier2, measurer, 1, P1);
                    }
                }
            }
        }
        for (int i15 = 0; i15 < size; i15++) {
            ConstraintWidget constraintWidget7 = r12.get(i15);
            if (constraintWidget7.m0() && a(0, constraintWidget7)) {
                ConstraintWidgetContainer.S1(0, constraintWidget7, measurer, f4722a, BasicMeasure.Measure.f4676k);
                if (constraintWidget7 instanceof Guideline) {
                    if (((Guideline) constraintWidget7).s1() == 0) {
                        i(0, constraintWidget7, measurer);
                    } else {
                        b(0, constraintWidget7, measurer, P1);
                    }
                } else {
                    b(0, constraintWidget7, measurer, P1);
                    i(0, constraintWidget7, measurer);
                }
            }
        }
    }

    private static void i(int i8, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        boolean z7;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z8;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.p0()) {
            return;
        }
        f4724c++;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.m0()) {
            int i9 = i8 + 1;
            if (a(i9, constraintWidget)) {
                ConstraintWidgetContainer.S1(i9, constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f4676k);
            }
        }
        ConstraintAnchor o8 = constraintWidget.o(ConstraintAnchor.Type.TOP);
        ConstraintAnchor o9 = constraintWidget.o(ConstraintAnchor.Type.BOTTOM);
        int e8 = o8.e();
        int e9 = o9.e();
        if (o8.d() != null && o8.n()) {
            Iterator<ConstraintAnchor> it = o8.d().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.f4535d;
                int i10 = i8 + 1;
                boolean a8 = a(i10, constraintWidget2);
                if (constraintWidget2.m0() && a8) {
                    ConstraintWidgetContainer.S1(i10, constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f4676k);
                }
                if ((next == constraintWidget2.P && (constraintAnchor4 = constraintWidget2.R.f4537f) != null && constraintAnchor4.n()) || (next == constraintWidget2.R && (constraintAnchor3 = constraintWidget2.P.f4537f) != null && constraintAnchor3.n())) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                ConstraintWidget.DimensionBehaviour T = constraintWidget2.T();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (T == dimensionBehaviour && !a8) {
                    if (constraintWidget2.T() == dimensionBehaviour && constraintWidget2.D >= 0 && constraintWidget2.C >= 0 && (constraintWidget2.V() == 8 || (constraintWidget2.f4598x == 0 && constraintWidget2.v() == 0.0f))) {
                        if (!constraintWidget2.k0() && !constraintWidget2.l0() && z8 && !constraintWidget2.k0()) {
                            g(i10, constraintWidget, measurer, constraintWidget2);
                        }
                    }
                } else if (!constraintWidget2.m0()) {
                    ConstraintAnchor constraintAnchor5 = constraintWidget2.P;
                    if (next == constraintAnchor5 && constraintWidget2.R.f4537f == null) {
                        int f8 = constraintAnchor5.f() + e8;
                        constraintWidget2.I0(f8, constraintWidget2.x() + f8);
                        i(i10, constraintWidget2, measurer);
                    } else {
                        ConstraintAnchor constraintAnchor6 = constraintWidget2.R;
                        if (next == constraintAnchor6 && constraintAnchor5.f4537f == null) {
                            int f9 = e8 - constraintAnchor6.f();
                            constraintWidget2.I0(f9 - constraintWidget2.x(), f9);
                            i(i10, constraintWidget2, measurer);
                        } else if (z8 && !constraintWidget2.k0()) {
                            f(i10, measurer, constraintWidget2);
                        }
                    }
                }
            }
        }
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (o9.d() != null && o9.n()) {
            Iterator<ConstraintAnchor> it2 = o9.d().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.f4535d;
                int i11 = i8 + 1;
                boolean a9 = a(i11, constraintWidget3);
                if (constraintWidget3.m0() && a9) {
                    ConstraintWidgetContainer.S1(i11, constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f4676k);
                }
                if ((next2 == constraintWidget3.P && (constraintAnchor2 = constraintWidget3.R.f4537f) != null && constraintAnchor2.n()) || (next2 == constraintWidget3.R && (constraintAnchor = constraintWidget3.P.f4537f) != null && constraintAnchor.n())) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                ConstraintWidget.DimensionBehaviour T2 = constraintWidget3.T();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (T2 == dimensionBehaviour2 && !a9) {
                    if (constraintWidget3.T() == dimensionBehaviour2 && constraintWidget3.D >= 0 && constraintWidget3.C >= 0 && (constraintWidget3.V() == 8 || (constraintWidget3.f4598x == 0 && constraintWidget3.v() == 0.0f))) {
                        if (!constraintWidget3.k0() && !constraintWidget3.l0() && z7 && !constraintWidget3.k0()) {
                            g(i11, constraintWidget, measurer, constraintWidget3);
                        }
                    }
                } else if (!constraintWidget3.m0()) {
                    ConstraintAnchor constraintAnchor7 = constraintWidget3.P;
                    if (next2 == constraintAnchor7 && constraintWidget3.R.f4537f == null) {
                        int f10 = constraintAnchor7.f() + e9;
                        constraintWidget3.I0(f10, constraintWidget3.x() + f10);
                        i(i11, constraintWidget3, measurer);
                    } else {
                        ConstraintAnchor constraintAnchor8 = constraintWidget3.R;
                        if (next2 == constraintAnchor8 && constraintAnchor7.f4537f == null) {
                            int f11 = e9 - constraintAnchor8.f();
                            constraintWidget3.I0(f11 - constraintWidget3.x(), f11);
                            i(i11, constraintWidget3, measurer);
                        } else if (z7 && !constraintWidget3.k0()) {
                            f(i11, measurer, constraintWidget3);
                        }
                    }
                }
            }
        }
        ConstraintAnchor o10 = constraintWidget.o(ConstraintAnchor.Type.BASELINE);
        if (o10.d() != null && o10.n()) {
            int e10 = o10.e();
            Iterator<ConstraintAnchor> it3 = o10.d().iterator();
            while (it3.hasNext()) {
                ConstraintAnchor next3 = it3.next();
                ConstraintWidget constraintWidget4 = next3.f4535d;
                int i12 = i8 + 1;
                boolean a10 = a(i12, constraintWidget4);
                if (constraintWidget4.m0() && a10) {
                    ConstraintWidgetContainer.S1(i12, constraintWidget4, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f4676k);
                }
                if (constraintWidget4.T() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || a10) {
                    if (!constraintWidget4.m0() && next3 == constraintWidget4.S) {
                        constraintWidget4.E0(next3.f() + e10);
                        i(i12, constraintWidget4, measurer);
                    }
                }
            }
        }
        constraintWidget.r0();
    }
}
