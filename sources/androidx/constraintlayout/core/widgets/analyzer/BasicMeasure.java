package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicMeasure {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<ConstraintWidget> f4673a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private Measure f4674b = new Measure();

    /* renamed from: c  reason: collision with root package name */
    private ConstraintWidgetContainer f4675c;

    /* loaded from: classes.dex */
    public static class Measure {

        /* renamed from: k  reason: collision with root package name */
        public static int f4676k = 0;

        /* renamed from: l  reason: collision with root package name */
        public static int f4677l = 1;

        /* renamed from: m  reason: collision with root package name */
        public static int f4678m = 2;

        /* renamed from: a  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f4679a;

        /* renamed from: b  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f4680b;

        /* renamed from: c  reason: collision with root package name */
        public int f4681c;

        /* renamed from: d  reason: collision with root package name */
        public int f4682d;

        /* renamed from: e  reason: collision with root package name */
        public int f4683e;

        /* renamed from: f  reason: collision with root package name */
        public int f4684f;

        /* renamed from: g  reason: collision with root package name */
        public int f4685g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f4686h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f4687i;

        /* renamed from: j  reason: collision with root package name */
        public int f4688j;
    }

    /* loaded from: classes.dex */
    public interface Measurer {
        void a();

        void b(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f4675c = constraintWidgetContainer;
    }

    private boolean a(Measurer measurer, ConstraintWidget constraintWidget, int i8) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        this.f4674b.f4679a = constraintWidget.A();
        this.f4674b.f4680b = constraintWidget.T();
        this.f4674b.f4681c = constraintWidget.W();
        this.f4674b.f4682d = constraintWidget.x();
        Measure measure = this.f4674b;
        measure.f4687i = false;
        measure.f4688j = i8;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f4679a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (measure.f4680b == dimensionBehaviour2) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 && constraintWidget.f4559d0 > 0.0f) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z8 && constraintWidget.f4559d0 > 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 && constraintWidget.f4600y[0] == 4) {
            measure.f4679a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z10 && constraintWidget.f4600y[1] == 4) {
            measure.f4680b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.b(constraintWidget, measure);
        constraintWidget.k1(this.f4674b.f4683e);
        constraintWidget.L0(this.f4674b.f4684f);
        constraintWidget.K0(this.f4674b.f4686h);
        constraintWidget.A0(this.f4674b.f4685g);
        Measure measure2 = this.f4674b;
        measure2.f4688j = Measure.f4676k;
        return measure2.f4687i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
        if (r8 != r9) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0095, code lost:
        if (r5.f4559d0 <= 0.0f) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r13) {
        /*
            r12 = this;
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r13.L0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.T1(r1)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r2 = r13.I1()
            r3 = 0
            r4 = 0
        L12:
            if (r4 >= r0) goto Lb0
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r5 = r13.L0
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r6 == 0) goto L22
            goto Lac
        L22:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r6 == 0) goto L28
            goto Lac
        L28:
            boolean r6 = r5.l0()
            if (r6 == 0) goto L30
            goto Lac
        L30:
            if (r1 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r5.f4560e
            if (r6 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r7 = r5.f4562f
            if (r7 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.f4757e
            boolean r6 = r6.f4709j
            if (r6 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r7.f4757e
            boolean r6 = r6.f4709j
            if (r6 == 0) goto L48
            goto Lac
        L48:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.u(r3)
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.u(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L61
            int r10 = r5.f4596w
            if (r10 == r7) goto L61
            if (r8 != r9) goto L61
            int r10 = r5.f4598x
            if (r10 == r7) goto L61
            r10 = 1
            goto L62
        L61:
            r10 = 0
        L62:
            if (r10 != 0) goto L98
            boolean r11 = r13.T1(r7)
            if (r11 == 0) goto L98
            boolean r11 = r5 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r11 != 0) goto L98
            if (r6 != r9) goto L7d
            int r11 = r5.f4596w
            if (r11 != 0) goto L7d
            if (r8 == r9) goto L7d
            boolean r11 = r5.i0()
            if (r11 != 0) goto L7d
            r10 = 1
        L7d:
            if (r8 != r9) goto L8c
            int r11 = r5.f4598x
            if (r11 != 0) goto L8c
            if (r6 == r9) goto L8c
            boolean r11 = r5.i0()
            if (r11 != 0) goto L8c
            r10 = 1
        L8c:
            if (r6 == r9) goto L90
            if (r8 != r9) goto L98
        L90:
            float r6 = r5.f4559d0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L98
            goto L99
        L98:
            r7 = r10
        L99:
            if (r7 == 0) goto L9c
            goto Lac
        L9c:
            int r6 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4676k
            r12.a(r2, r5, r6)
            androidx.constraintlayout.core.Metrics r5 = r13.R0
            if (r5 == 0) goto Lac
            long r6 = r5.f4369a
            r8 = 1
            long r6 = r6 + r8
            r5.f4369a = r6
        Lac:
            int r4 = r4 + 1
            goto L12
        Lb0:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    private void c(ConstraintWidgetContainer constraintWidgetContainer, String str, int i8, int i9, int i10) {
        int I = constraintWidgetContainer.I();
        int H = constraintWidgetContainer.H();
        constraintWidgetContainer.a1(0);
        constraintWidgetContainer.Z0(0);
        constraintWidgetContainer.k1(i9);
        constraintWidgetContainer.L0(i10);
        constraintWidgetContainer.a1(I);
        constraintWidgetContainer.Z0(H);
        this.f4675c.X1(i8);
        this.f4675c.s1();
    }

    public long d(ConstraintWidgetContainer constraintWidgetContainer, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        boolean z7;
        int i17;
        int i18;
        boolean z8;
        int i19;
        Measurer measurer;
        int i20;
        int i21;
        int i22;
        boolean z9;
        Metrics metrics;
        Measurer I1 = constraintWidgetContainer.I1();
        int size = constraintWidgetContainer.L0.size();
        int W = constraintWidgetContainer.W();
        int x7 = constraintWidgetContainer.x();
        boolean b8 = Optimizer.b(i8, 128);
        boolean z10 = b8 || Optimizer.b(i8, 64);
        if (z10) {
            for (int i23 = 0; i23 < size; i23++) {
                ConstraintWidget constraintWidget = constraintWidgetContainer.L0.get(i23);
                ConstraintWidget.DimensionBehaviour A = constraintWidget.A();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z11 = (A == dimensionBehaviour) && (constraintWidget.T() == dimensionBehaviour) && constraintWidget.v() > 0.0f;
                if ((constraintWidget.i0() && z11) || ((constraintWidget.k0() && z11) || (constraintWidget instanceof VirtualLayout) || constraintWidget.i0() || constraintWidget.k0())) {
                    z10 = false;
                    break;
                }
            }
        }
        if (z10 && (metrics = LinearSystem.f4348x) != null) {
            metrics.f4371c++;
        }
        boolean z12 = z10 & ((i11 == 1073741824 && i13 == 1073741824) || b8);
        if (z12) {
            int min = Math.min(constraintWidgetContainer.G(), i12);
            int min2 = Math.min(constraintWidgetContainer.F(), i14);
            if (i11 == 1073741824 && constraintWidgetContainer.W() != min) {
                constraintWidgetContainer.k1(min);
                constraintWidgetContainer.M1();
            }
            if (i13 == 1073741824 && constraintWidgetContainer.x() != min2) {
                constraintWidgetContainer.L0(min2);
                constraintWidgetContainer.M1();
            }
            if (i11 == 1073741824 && i13 == 1073741824) {
                z7 = constraintWidgetContainer.F1(b8);
                i17 = 2;
            } else {
                boolean G1 = constraintWidgetContainer.G1(b8);
                if (i11 == 1073741824) {
                    G1 &= constraintWidgetContainer.H1(b8, 0);
                    i17 = 1;
                } else {
                    i17 = 0;
                }
                if (i13 == 1073741824) {
                    z7 = constraintWidgetContainer.H1(b8, 1) & G1;
                    i17++;
                } else {
                    z7 = G1;
                }
            }
            if (z7) {
                constraintWidgetContainer.p1(i11 == 1073741824, i13 == 1073741824);
            }
        } else {
            z7 = false;
            i17 = 0;
        }
        if (z7 && i17 == 2) {
            return 0L;
        }
        int J1 = constraintWidgetContainer.J1();
        if (size > 0) {
            b(constraintWidgetContainer);
        }
        e(constraintWidgetContainer);
        int size2 = this.f4673a.size();
        if (size > 0) {
            c(constraintWidgetContainer, "First pass", 0, W, x7);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour A2 = constraintWidgetContainer.A();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z13 = A2 == dimensionBehaviour2;
            boolean z14 = constraintWidgetContainer.T() == dimensionBehaviour2;
            int max = Math.max(constraintWidgetContainer.W(), this.f4675c.I());
            int max2 = Math.max(constraintWidgetContainer.x(), this.f4675c.H());
            int i24 = 0;
            boolean z15 = false;
            while (i24 < size2) {
                ConstraintWidget constraintWidget2 = this.f4673a.get(i24);
                if (constraintWidget2 instanceof VirtualLayout) {
                    int W2 = constraintWidget2.W();
                    i20 = J1;
                    int x8 = constraintWidget2.x();
                    i21 = x7;
                    boolean a8 = a(I1, constraintWidget2, Measure.f4677l) | z15;
                    Metrics metrics2 = constraintWidgetContainer.R0;
                    i22 = W;
                    if (metrics2 != null) {
                        metrics2.f4370b++;
                    }
                    int W3 = constraintWidget2.W();
                    int x9 = constraintWidget2.x();
                    if (W3 != W2) {
                        constraintWidget2.k1(W3);
                        if (z13 && constraintWidget2.M() > max) {
                            max = Math.max(max, constraintWidget2.M() + constraintWidget2.o(ConstraintAnchor.Type.RIGHT).f());
                        }
                        z9 = true;
                    } else {
                        z9 = a8;
                    }
                    if (x9 != x8) {
                        constraintWidget2.L0(x9);
                        if (z14 && constraintWidget2.r() > max2) {
                            max2 = Math.max(max2, constraintWidget2.r() + constraintWidget2.o(ConstraintAnchor.Type.BOTTOM).f());
                        }
                        z9 = true;
                    }
                    z15 = z9 | ((VirtualLayout) constraintWidget2).F1();
                } else {
                    i20 = J1;
                    i22 = W;
                    i21 = x7;
                }
                i24++;
                J1 = i20;
                x7 = i21;
                W = i22;
            }
            int i25 = J1;
            int i26 = W;
            int i27 = x7;
            int i28 = 0;
            int i29 = 2;
            while (i28 < i29) {
                int i30 = 0;
                while (i30 < size2) {
                    ConstraintWidget constraintWidget3 = this.f4673a.get(i30);
                    if (((constraintWidget3 instanceof Helper) && !(constraintWidget3 instanceof VirtualLayout)) || (constraintWidget3 instanceof Guideline) || constraintWidget3.V() == 8 || ((z12 && constraintWidget3.f4560e.f4757e.f4709j && constraintWidget3.f4562f.f4757e.f4709j) || (constraintWidget3 instanceof VirtualLayout))) {
                        z8 = z12;
                        i19 = size2;
                        measurer = I1;
                    } else {
                        int W4 = constraintWidget3.W();
                        int x10 = constraintWidget3.x();
                        int p8 = constraintWidget3.p();
                        int i31 = Measure.f4677l;
                        z8 = z12;
                        if (i28 == 1) {
                            i31 = Measure.f4678m;
                        }
                        boolean a9 = a(I1, constraintWidget3, i31) | z15;
                        Metrics metrics3 = constraintWidgetContainer.R0;
                        i19 = size2;
                        measurer = I1;
                        if (metrics3 != null) {
                            metrics3.f4370b++;
                        }
                        int W5 = constraintWidget3.W();
                        int x11 = constraintWidget3.x();
                        if (W5 != W4) {
                            constraintWidget3.k1(W5);
                            if (z13 && constraintWidget3.M() > max) {
                                max = Math.max(max, constraintWidget3.M() + constraintWidget3.o(ConstraintAnchor.Type.RIGHT).f());
                            }
                            a9 = true;
                        }
                        if (x11 != x10) {
                            constraintWidget3.L0(x11);
                            if (z14 && constraintWidget3.r() > max2) {
                                max2 = Math.max(max2, constraintWidget3.r() + constraintWidget3.o(ConstraintAnchor.Type.BOTTOM).f());
                            }
                            a9 = true;
                        }
                        z15 = (!constraintWidget3.Z() || p8 == constraintWidget3.p()) ? a9 : true;
                    }
                    i30++;
                    I1 = measurer;
                    z12 = z8;
                    size2 = i19;
                }
                boolean z16 = z12;
                int i32 = size2;
                Measurer measurer2 = I1;
                if (!z15) {
                    break;
                }
                i28++;
                c(constraintWidgetContainer, "intermediate pass", i28, i26, i27);
                I1 = measurer2;
                z12 = z16;
                size2 = i32;
                i29 = 2;
                z15 = false;
            }
            i18 = i25;
        } else {
            i18 = J1;
        }
        constraintWidgetContainer.W1(i18);
        return 0L;
    }

    public void e(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f4673a.clear();
        int size = constraintWidgetContainer.L0.size();
        for (int i8 = 0; i8 < size; i8++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.L0.get(i8);
            ConstraintWidget.DimensionBehaviour A = constraintWidget.A();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (A == dimensionBehaviour || constraintWidget.T() == dimensionBehaviour) {
                this.f4673a.add(constraintWidget);
            }
        }
        constraintWidgetContainer.M1();
    }
}
