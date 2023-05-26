package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {

    /* renamed from: x1  reason: collision with root package name */
    private ConstraintWidget[] f4651x1;

    /* renamed from: a1  reason: collision with root package name */
    private int f4628a1 = -1;

    /* renamed from: b1  reason: collision with root package name */
    private int f4629b1 = -1;

    /* renamed from: c1  reason: collision with root package name */
    private int f4630c1 = -1;

    /* renamed from: d1  reason: collision with root package name */
    private int f4631d1 = -1;

    /* renamed from: e1  reason: collision with root package name */
    private int f4632e1 = -1;

    /* renamed from: f1  reason: collision with root package name */
    private int f4633f1 = -1;

    /* renamed from: g1  reason: collision with root package name */
    private float f4634g1 = 0.5f;

    /* renamed from: h1  reason: collision with root package name */
    private float f4635h1 = 0.5f;

    /* renamed from: i1  reason: collision with root package name */
    private float f4636i1 = 0.5f;

    /* renamed from: j1  reason: collision with root package name */
    private float f4637j1 = 0.5f;

    /* renamed from: k1  reason: collision with root package name */
    private float f4638k1 = 0.5f;

    /* renamed from: l1  reason: collision with root package name */
    private float f4639l1 = 0.5f;

    /* renamed from: m1  reason: collision with root package name */
    private int f4640m1 = 0;

    /* renamed from: n1  reason: collision with root package name */
    private int f4641n1 = 0;

    /* renamed from: o1  reason: collision with root package name */
    private int f4642o1 = 2;

    /* renamed from: p1  reason: collision with root package name */
    private int f4643p1 = 2;

    /* renamed from: q1  reason: collision with root package name */
    private int f4644q1 = 0;

    /* renamed from: r1  reason: collision with root package name */
    private int f4645r1 = -1;

    /* renamed from: s1  reason: collision with root package name */
    private int f4646s1 = 0;

    /* renamed from: t1  reason: collision with root package name */
    private ArrayList<WidgetsList> f4647t1 = new ArrayList<>();

    /* renamed from: u1  reason: collision with root package name */
    private ConstraintWidget[] f4648u1 = null;

    /* renamed from: v1  reason: collision with root package name */
    private ConstraintWidget[] f4649v1 = null;

    /* renamed from: w1  reason: collision with root package name */
    private int[] f4650w1 = null;

    /* renamed from: y1  reason: collision with root package name */
    private int f4652y1 = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class WidgetsList {

        /* renamed from: a  reason: collision with root package name */
        private int f4653a;

        /* renamed from: d  reason: collision with root package name */
        private ConstraintAnchor f4656d;

        /* renamed from: e  reason: collision with root package name */
        private ConstraintAnchor f4657e;

        /* renamed from: f  reason: collision with root package name */
        private ConstraintAnchor f4658f;

        /* renamed from: g  reason: collision with root package name */
        private ConstraintAnchor f4659g;

        /* renamed from: h  reason: collision with root package name */
        private int f4660h;

        /* renamed from: i  reason: collision with root package name */
        private int f4661i;

        /* renamed from: j  reason: collision with root package name */
        private int f4662j;

        /* renamed from: k  reason: collision with root package name */
        private int f4663k;

        /* renamed from: q  reason: collision with root package name */
        private int f4669q;

        /* renamed from: b  reason: collision with root package name */
        private ConstraintWidget f4654b = null;

        /* renamed from: c  reason: collision with root package name */
        int f4655c = 0;

        /* renamed from: l  reason: collision with root package name */
        private int f4664l = 0;

        /* renamed from: m  reason: collision with root package name */
        private int f4665m = 0;

        /* renamed from: n  reason: collision with root package name */
        private int f4666n = 0;

        /* renamed from: o  reason: collision with root package name */
        private int f4667o = 0;

        /* renamed from: p  reason: collision with root package name */
        private int f4668p = 0;

        public WidgetsList(int i8, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i9) {
            this.f4660h = 0;
            this.f4661i = 0;
            this.f4662j = 0;
            this.f4663k = 0;
            this.f4669q = 0;
            this.f4653a = i8;
            this.f4656d = constraintAnchor;
            this.f4657e = constraintAnchor2;
            this.f4658f = constraintAnchor3;
            this.f4659g = constraintAnchor4;
            this.f4660h = Flow.this.z1();
            this.f4661i = Flow.this.B1();
            this.f4662j = Flow.this.A1();
            this.f4663k = Flow.this.y1();
            this.f4669q = i9;
        }

        private void h() {
            this.f4664l = 0;
            this.f4665m = 0;
            this.f4654b = null;
            this.f4655c = 0;
            int i8 = this.f4667o;
            for (int i9 = 0; i9 < i8 && this.f4666n + i9 < Flow.this.f4652y1; i9++) {
                ConstraintWidget constraintWidget = Flow.this.f4651x1[this.f4666n + i9];
                if (this.f4653a != 0) {
                    int l22 = Flow.this.l2(constraintWidget, this.f4669q);
                    int k22 = Flow.this.k2(constraintWidget, this.f4669q);
                    int i10 = Flow.this.f4641n1;
                    if (constraintWidget.V() == 8) {
                        i10 = 0;
                    }
                    this.f4665m += k22 + i10;
                    if (this.f4654b == null || this.f4655c < l22) {
                        this.f4654b = constraintWidget;
                        this.f4655c = l22;
                        this.f4664l = l22;
                    }
                } else {
                    int W = constraintWidget.W();
                    int i11 = Flow.this.f4640m1;
                    if (constraintWidget.V() == 8) {
                        i11 = 0;
                    }
                    this.f4664l += W + i11;
                    int k23 = Flow.this.k2(constraintWidget, this.f4669q);
                    if (this.f4654b == null || this.f4655c < k23) {
                        this.f4654b = constraintWidget;
                        this.f4655c = k23;
                        this.f4665m = k23;
                    }
                }
            }
        }

        public void b(ConstraintWidget constraintWidget) {
            int i8 = 0;
            if (this.f4653a == 0) {
                int l22 = Flow.this.l2(constraintWidget, this.f4669q);
                if (constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f4668p++;
                    l22 = 0;
                }
                int i9 = Flow.this.f4640m1;
                if (constraintWidget.V() != 8) {
                    i8 = i9;
                }
                this.f4664l += l22 + i8;
                int k22 = Flow.this.k2(constraintWidget, this.f4669q);
                if (this.f4654b == null || this.f4655c < k22) {
                    this.f4654b = constraintWidget;
                    this.f4655c = k22;
                    this.f4665m = k22;
                }
            } else {
                int l23 = Flow.this.l2(constraintWidget, this.f4669q);
                int k23 = Flow.this.k2(constraintWidget, this.f4669q);
                if (constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f4668p++;
                    k23 = 0;
                }
                int i10 = Flow.this.f4641n1;
                if (constraintWidget.V() != 8) {
                    i8 = i10;
                }
                this.f4665m += k23 + i8;
                if (this.f4654b == null || this.f4655c < l23) {
                    this.f4654b = constraintWidget;
                    this.f4655c = l23;
                    this.f4664l = l23;
                }
            }
            this.f4667o++;
        }

        public void c() {
            this.f4655c = 0;
            this.f4654b = null;
            this.f4664l = 0;
            this.f4665m = 0;
            this.f4666n = 0;
            this.f4667o = 0;
            this.f4668p = 0;
        }

        public void d(boolean z7, int i8, boolean z8) {
            ConstraintWidget constraintWidget;
            float f8;
            float f9;
            int i9 = this.f4667o;
            for (int i10 = 0; i10 < i9 && this.f4666n + i10 < Flow.this.f4652y1; i10++) {
                ConstraintWidget constraintWidget2 = Flow.this.f4651x1[this.f4666n + i10];
                if (constraintWidget2 != null) {
                    constraintWidget2.u0();
                }
            }
            if (i9 == 0 || this.f4654b == null) {
                return;
            }
            boolean z9 = z8 && i8 == 0;
            int i11 = -1;
            int i12 = -1;
            for (int i13 = 0; i13 < i9; i13++) {
                int i14 = z7 ? (i9 - 1) - i13 : i13;
                if (this.f4666n + i14 >= Flow.this.f4652y1) {
                    break;
                }
                ConstraintWidget constraintWidget3 = Flow.this.f4651x1[this.f4666n + i14];
                if (constraintWidget3 != null && constraintWidget3.V() == 0) {
                    if (i11 == -1) {
                        i11 = i13;
                    }
                    i12 = i13;
                }
            }
            ConstraintWidget constraintWidget4 = null;
            if (this.f4653a == 0) {
                ConstraintWidget constraintWidget5 = this.f4654b;
                constraintWidget5.e1(Flow.this.f4629b1);
                int i15 = this.f4661i;
                if (i8 > 0) {
                    i15 += Flow.this.f4641n1;
                }
                constraintWidget5.P.a(this.f4657e, i15);
                if (z8) {
                    constraintWidget5.R.a(this.f4659g, this.f4663k);
                }
                if (i8 > 0) {
                    this.f4657e.f4535d.R.a(constraintWidget5.P, 0);
                }
                if (Flow.this.f4643p1 == 3 && !constraintWidget5.Z()) {
                    for (int i16 = 0; i16 < i9; i16++) {
                        int i17 = z7 ? (i9 - 1) - i16 : i16;
                        if (this.f4666n + i17 >= Flow.this.f4652y1) {
                            break;
                        }
                        constraintWidget = Flow.this.f4651x1[this.f4666n + i17];
                        if (constraintWidget.Z()) {
                            break;
                        }
                    }
                }
                constraintWidget = constraintWidget5;
                int i18 = 0;
                while (i18 < i9) {
                    int i19 = z7 ? (i9 - 1) - i18 : i18;
                    if (this.f4666n + i19 >= Flow.this.f4652y1) {
                        return;
                    }
                    ConstraintWidget constraintWidget6 = Flow.this.f4651x1[this.f4666n + i19];
                    if (constraintWidget6 == null) {
                        constraintWidget6 = constraintWidget4;
                    } else {
                        if (i18 == 0) {
                            constraintWidget6.k(constraintWidget6.O, this.f4656d, this.f4660h);
                        }
                        if (i19 == 0) {
                            int i20 = Flow.this.f4628a1;
                            float f10 = Flow.this.f4634g1;
                            if (z7) {
                                f10 = 1.0f - f10;
                            }
                            if (this.f4666n != 0 || Flow.this.f4630c1 == -1) {
                                if (z8 && Flow.this.f4632e1 != -1) {
                                    i20 = Flow.this.f4632e1;
                                    if (z7) {
                                        f9 = Flow.this.f4638k1;
                                        f8 = 1.0f - f9;
                                        f10 = f8;
                                    } else {
                                        f8 = Flow.this.f4638k1;
                                        f10 = f8;
                                    }
                                }
                            } else {
                                i20 = Flow.this.f4630c1;
                                if (z7) {
                                    f9 = Flow.this.f4636i1;
                                    f8 = 1.0f - f9;
                                    f10 = f8;
                                } else {
                                    f8 = Flow.this.f4636i1;
                                    f10 = f8;
                                }
                            }
                            constraintWidget6.N0(i20);
                            constraintWidget6.M0(f10);
                        }
                        if (i18 == i9 - 1) {
                            constraintWidget6.k(constraintWidget6.Q, this.f4658f, this.f4662j);
                        }
                        if (constraintWidget4 != null) {
                            constraintWidget6.O.a(constraintWidget4.Q, Flow.this.f4640m1);
                            if (i18 == i11) {
                                constraintWidget6.O.u(this.f4660h);
                            }
                            constraintWidget4.Q.a(constraintWidget6.O, 0);
                            if (i18 == i12 + 1) {
                                constraintWidget4.Q.u(this.f4662j);
                            }
                        }
                        if (constraintWidget6 != constraintWidget5) {
                            if (Flow.this.f4643p1 != 3 || !constraintWidget.Z() || constraintWidget6 == constraintWidget || !constraintWidget6.Z()) {
                                int i21 = Flow.this.f4643p1;
                                if (i21 == 0) {
                                    constraintWidget6.P.a(constraintWidget5.P, 0);
                                } else if (i21 == 1) {
                                    constraintWidget6.R.a(constraintWidget5.R, 0);
                                } else if (z9) {
                                    constraintWidget6.P.a(this.f4657e, this.f4661i);
                                    constraintWidget6.R.a(this.f4659g, this.f4663k);
                                } else {
                                    constraintWidget6.P.a(constraintWidget5.P, 0);
                                    constraintWidget6.R.a(constraintWidget5.R, 0);
                                }
                            } else {
                                constraintWidget6.S.a(constraintWidget.S, 0);
                            }
                            i18++;
                            constraintWidget4 = constraintWidget6;
                        }
                    }
                    i18++;
                    constraintWidget4 = constraintWidget6;
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.f4654b;
            constraintWidget7.N0(Flow.this.f4628a1);
            int i22 = this.f4660h;
            if (i8 > 0) {
                i22 += Flow.this.f4640m1;
            }
            if (z7) {
                constraintWidget7.Q.a(this.f4658f, i22);
                if (z8) {
                    constraintWidget7.O.a(this.f4656d, this.f4662j);
                }
                if (i8 > 0) {
                    this.f4658f.f4535d.O.a(constraintWidget7.Q, 0);
                }
            } else {
                constraintWidget7.O.a(this.f4656d, i22);
                if (z8) {
                    constraintWidget7.Q.a(this.f4658f, this.f4662j);
                }
                if (i8 > 0) {
                    this.f4656d.f4535d.Q.a(constraintWidget7.O, 0);
                }
            }
            for (int i23 = 0; i23 < i9 && this.f4666n + i23 < Flow.this.f4652y1; i23++) {
                ConstraintWidget constraintWidget8 = Flow.this.f4651x1[this.f4666n + i23];
                if (constraintWidget8 != null) {
                    if (i23 == 0) {
                        constraintWidget8.k(constraintWidget8.P, this.f4657e, this.f4661i);
                        int i24 = Flow.this.f4629b1;
                        float f11 = Flow.this.f4635h1;
                        if (this.f4666n != 0 || Flow.this.f4631d1 == -1) {
                            if (z8 && Flow.this.f4633f1 != -1) {
                                i24 = Flow.this.f4633f1;
                                f11 = Flow.this.f4639l1;
                            }
                        } else {
                            i24 = Flow.this.f4631d1;
                            f11 = Flow.this.f4637j1;
                        }
                        constraintWidget8.e1(i24);
                        constraintWidget8.d1(f11);
                    }
                    if (i23 == i9 - 1) {
                        constraintWidget8.k(constraintWidget8.R, this.f4659g, this.f4663k);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget8.P.a(constraintWidget4.R, Flow.this.f4641n1);
                        if (i23 == i11) {
                            constraintWidget8.P.u(this.f4661i);
                        }
                        constraintWidget4.R.a(constraintWidget8.P, 0);
                        if (i23 == i12 + 1) {
                            constraintWidget4.R.u(this.f4663k);
                        }
                    }
                    if (constraintWidget8 != constraintWidget7) {
                        if (z7) {
                            int i25 = Flow.this.f4642o1;
                            if (i25 == 0) {
                                constraintWidget8.Q.a(constraintWidget7.Q, 0);
                            } else if (i25 == 1) {
                                constraintWidget8.O.a(constraintWidget7.O, 0);
                            } else if (i25 == 2) {
                                constraintWidget8.O.a(constraintWidget7.O, 0);
                                constraintWidget8.Q.a(constraintWidget7.Q, 0);
                            }
                        } else {
                            int i26 = Flow.this.f4642o1;
                            if (i26 == 0) {
                                constraintWidget8.O.a(constraintWidget7.O, 0);
                            } else if (i26 == 1) {
                                constraintWidget8.Q.a(constraintWidget7.Q, 0);
                            } else if (i26 == 2) {
                                if (z9) {
                                    constraintWidget8.O.a(this.f4656d, this.f4660h);
                                    constraintWidget8.Q.a(this.f4658f, this.f4662j);
                                } else {
                                    constraintWidget8.O.a(constraintWidget7.O, 0);
                                    constraintWidget8.Q.a(constraintWidget7.Q, 0);
                                }
                            }
                            constraintWidget4 = constraintWidget8;
                        }
                    }
                    constraintWidget4 = constraintWidget8;
                }
            }
        }

        public int e() {
            if (this.f4653a == 1) {
                return this.f4665m - Flow.this.f4641n1;
            }
            return this.f4665m;
        }

        public int f() {
            if (this.f4653a == 0) {
                return this.f4664l - Flow.this.f4640m1;
            }
            return this.f4664l;
        }

        public void g(int i8) {
            int i9 = this.f4668p;
            if (i9 == 0) {
                return;
            }
            int i10 = this.f4667o;
            int i11 = i8 / i9;
            for (int i12 = 0; i12 < i10 && this.f4666n + i12 < Flow.this.f4652y1; i12++) {
                ConstraintWidget constraintWidget = Flow.this.f4651x1[this.f4666n + i12];
                if (this.f4653a == 0) {
                    if (constraintWidget != null && constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f4596w == 0) {
                        Flow.this.D1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i11, constraintWidget.T(), constraintWidget.x());
                    }
                } else if (constraintWidget != null && constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f4598x == 0) {
                    Flow.this.D1(constraintWidget, constraintWidget.A(), constraintWidget.W(), ConstraintWidget.DimensionBehaviour.FIXED, i11);
                }
            }
            h();
        }

        public void i(int i8) {
            this.f4666n = i8;
        }

        public void j(int i8, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i9, int i10, int i11, int i12, int i13) {
            this.f4653a = i8;
            this.f4656d = constraintAnchor;
            this.f4657e = constraintAnchor2;
            this.f4658f = constraintAnchor3;
            this.f4659g = constraintAnchor4;
            this.f4660h = i9;
            this.f4661i = i10;
            this.f4662j = i11;
            this.f4663k = i12;
            this.f4669q = i13;
        }
    }

    private void j2(boolean z7) {
        ConstraintWidget constraintWidget;
        float f8;
        int i8;
        if (this.f4650w1 != null && this.f4649v1 != null && this.f4648u1 != null) {
            for (int i9 = 0; i9 < this.f4652y1; i9++) {
                this.f4651x1[i9].u0();
            }
            int[] iArr = this.f4650w1;
            int i10 = iArr[0];
            int i11 = iArr[1];
            ConstraintWidget constraintWidget2 = null;
            float f9 = this.f4634g1;
            int i12 = 0;
            while (i12 < i10) {
                if (z7) {
                    i8 = (i10 - i12) - 1;
                    f8 = 1.0f - this.f4634g1;
                } else {
                    f8 = f9;
                    i8 = i12;
                }
                ConstraintWidget constraintWidget3 = this.f4649v1[i8];
                if (constraintWidget3 != null && constraintWidget3.V() != 8) {
                    if (i12 == 0) {
                        constraintWidget3.k(constraintWidget3.O, this.O, z1());
                        constraintWidget3.N0(this.f4628a1);
                        constraintWidget3.M0(f8);
                    }
                    if (i12 == i10 - 1) {
                        constraintWidget3.k(constraintWidget3.Q, this.Q, A1());
                    }
                    if (i12 > 0 && constraintWidget2 != null) {
                        constraintWidget3.k(constraintWidget3.O, constraintWidget2.Q, this.f4640m1);
                        constraintWidget2.k(constraintWidget2.Q, constraintWidget3.O, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
                i12++;
                f9 = f8;
            }
            for (int i13 = 0; i13 < i11; i13++) {
                ConstraintWidget constraintWidget4 = this.f4648u1[i13];
                if (constraintWidget4 != null && constraintWidget4.V() != 8) {
                    if (i13 == 0) {
                        constraintWidget4.k(constraintWidget4.P, this.P, B1());
                        constraintWidget4.e1(this.f4629b1);
                        constraintWidget4.d1(this.f4635h1);
                    }
                    if (i13 == i11 - 1) {
                        constraintWidget4.k(constraintWidget4.R, this.R, y1());
                    }
                    if (i13 > 0 && constraintWidget2 != null) {
                        constraintWidget4.k(constraintWidget4.P, constraintWidget2.R, this.f4641n1);
                        constraintWidget2.k(constraintWidget2.R, constraintWidget4.P, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i14 = 0; i14 < i10; i14++) {
                for (int i15 = 0; i15 < i11; i15++) {
                    int i16 = (i15 * i10) + i14;
                    if (this.f4646s1 == 1) {
                        i16 = (i14 * i11) + i15;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.f4651x1;
                    if (i16 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i16]) != null && constraintWidget.V() != 8) {
                        ConstraintWidget constraintWidget5 = this.f4649v1[i14];
                        ConstraintWidget constraintWidget6 = this.f4648u1[i15];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.k(constraintWidget.O, constraintWidget5.O, 0);
                            constraintWidget.k(constraintWidget.Q, constraintWidget5.Q, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.k(constraintWidget.P, constraintWidget6.P, 0);
                            constraintWidget.k(constraintWidget.R, constraintWidget6.R, 0);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k2(ConstraintWidget constraintWidget, int i8) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i9 = constraintWidget.f4598x;
            if (i9 == 0) {
                return 0;
            }
            if (i9 == 2) {
                int i10 = (int) (constraintWidget.E * i8);
                if (i10 != constraintWidget.x()) {
                    constraintWidget.Y0(true);
                    D1(constraintWidget, constraintWidget.A(), constraintWidget.W(), ConstraintWidget.DimensionBehaviour.FIXED, i10);
                }
                return i10;
            } else if (i9 == 1) {
                return constraintWidget.x();
            } else {
                if (i9 == 3) {
                    return (int) ((constraintWidget.W() * constraintWidget.f4559d0) + 0.5f);
                }
            }
        }
        return constraintWidget.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int l2(ConstraintWidget constraintWidget, int i8) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i9 = constraintWidget.f4596w;
            if (i9 == 0) {
                return 0;
            }
            if (i9 == 2) {
                int i10 = (int) (constraintWidget.B * i8);
                if (i10 != constraintWidget.W()) {
                    constraintWidget.Y0(true);
                    D1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i10, constraintWidget.T(), constraintWidget.x());
                }
                return i10;
            } else if (i9 == 1) {
                return constraintWidget.W();
            } else {
                if (i9 == 3) {
                    return (int) ((constraintWidget.x() * constraintWidget.f4559d0) + 0.5f);
                }
            }
        }
        return constraintWidget.W();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m2(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.m2(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void n2(ConstraintWidget[] constraintWidgetArr, int i8, int i9, int i10, int[] iArr) {
        int i11;
        boolean z7;
        int i12;
        boolean z8;
        int i13;
        ConstraintAnchor constraintAnchor;
        int A1;
        ConstraintAnchor constraintAnchor2;
        int y12;
        boolean z9;
        int i14;
        if (i8 == 0) {
            return;
        }
        this.f4647t1.clear();
        WidgetsList widgetsList = new WidgetsList(i9, this.O, this.P, this.Q, this.R, i10);
        this.f4647t1.add(widgetsList);
        if (i9 == 0) {
            i11 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i16 < i8) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i16];
                int l22 = l2(constraintWidget, i10);
                if (constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i17 = i11;
                if ((i15 == i10 || this.f4640m1 + i15 + l22 > i10) && widgetsList.f4654b != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (!z9 && i16 > 0 && (i14 = this.f4645r1) > 0 && i16 % i14 == 0) {
                    z9 = true;
                }
                if (z9) {
                    widgetsList = new WidgetsList(i9, this.O, this.P, this.Q, this.R, i10);
                    widgetsList.i(i16);
                    this.f4647t1.add(widgetsList);
                } else if (i16 > 0) {
                    i15 += this.f4640m1 + l22;
                    widgetsList.b(constraintWidget);
                    i16++;
                    i11 = i17;
                }
                i15 = l22;
                widgetsList.b(constraintWidget);
                i16++;
                i11 = i17;
            }
        } else {
            i11 = 0;
            int i18 = 0;
            int i19 = 0;
            while (i19 < i8) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i19];
                int k22 = k2(constraintWidget2, i10);
                if (constraintWidget2.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i20 = i11;
                if ((i18 == i10 || this.f4641n1 + i18 + k22 > i10) && widgetsList.f4654b != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7 && i19 > 0 && (i12 = this.f4645r1) > 0 && i19 % i12 == 0) {
                    z7 = true;
                }
                if (z7) {
                    widgetsList = new WidgetsList(i9, this.O, this.P, this.Q, this.R, i10);
                    widgetsList.i(i19);
                    this.f4647t1.add(widgetsList);
                } else if (i19 > 0) {
                    i18 += this.f4641n1 + k22;
                    widgetsList.b(constraintWidget2);
                    i19++;
                    i11 = i20;
                }
                i18 = k22;
                widgetsList.b(constraintWidget2);
                i19++;
                i11 = i20;
            }
        }
        int size = this.f4647t1.size();
        ConstraintAnchor constraintAnchor3 = this.O;
        ConstraintAnchor constraintAnchor4 = this.P;
        ConstraintAnchor constraintAnchor5 = this.Q;
        ConstraintAnchor constraintAnchor6 = this.R;
        int z12 = z1();
        int B1 = B1();
        int A12 = A1();
        int y13 = y1();
        ConstraintWidget.DimensionBehaviour A = A();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (A != dimensionBehaviour && T() != dimensionBehaviour) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (i11 > 0 && z8) {
            for (int i21 = 0; i21 < size; i21++) {
                WidgetsList widgetsList2 = this.f4647t1.get(i21);
                if (i9 == 0) {
                    widgetsList2.g(i10 - widgetsList2.f());
                } else {
                    widgetsList2.g(i10 - widgetsList2.e());
                }
            }
        }
        int i22 = B1;
        int i23 = A12;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = z12;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i28 = y13;
        while (i26 < size) {
            WidgetsList widgetsList3 = this.f4647t1.get(i26);
            if (i9 == 0) {
                if (i26 < size - 1) {
                    constraintAnchor2 = this.f4647t1.get(i26 + 1).f4654b.P;
                    y12 = 0;
                } else {
                    constraintAnchor2 = this.R;
                    y12 = y1();
                }
                ConstraintAnchor constraintAnchor9 = widgetsList3.f4654b.R;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i29 = i24;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i30 = i25;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i13 = i26;
                widgetsList3.j(i9, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i27, i22, i23, y12, i10);
                int max = Math.max(i30, widgetsList3.f());
                i24 = i29 + widgetsList3.e();
                if (i13 > 0) {
                    i24 += this.f4641n1;
                }
                constraintAnchor8 = constraintAnchor11;
                i25 = max;
                constraintAnchor7 = constraintAnchor9;
                i22 = 0;
                constraintAnchor = constraintAnchor14;
                int i31 = y12;
                constraintAnchor6 = constraintAnchor2;
                i28 = i31;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i32 = i24;
                int i33 = i25;
                i13 = i26;
                if (i13 < size - 1) {
                    constraintAnchor = this.f4647t1.get(i13 + 1).f4654b.O;
                    A1 = 0;
                } else {
                    constraintAnchor = this.Q;
                    A1 = A1();
                }
                ConstraintAnchor constraintAnchor16 = widgetsList3.f4654b.Q;
                widgetsList3.j(i9, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i27, i22, A1, i28, i10);
                i25 = i33 + widgetsList3.f();
                int max2 = Math.max(i32, widgetsList3.e());
                if (i13 > 0) {
                    i25 += this.f4640m1;
                }
                i24 = max2;
                i23 = A1;
                constraintAnchor8 = constraintAnchor16;
                i27 = 0;
            }
            i26 = i13 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = i25;
        iArr[1] = i24;
    }

    private void o2(ConstraintWidget[] constraintWidgetArr, int i8, int i9, int i10, int[] iArr) {
        int i11;
        boolean z7;
        int i12;
        boolean z8;
        int i13;
        ConstraintAnchor constraintAnchor;
        int A1;
        ConstraintAnchor constraintAnchor2;
        int y12;
        boolean z9;
        int i14;
        if (i8 == 0) {
            return;
        }
        this.f4647t1.clear();
        WidgetsList widgetsList = new WidgetsList(i9, this.O, this.P, this.Q, this.R, i10);
        this.f4647t1.add(widgetsList);
        if (i9 == 0) {
            int i15 = 0;
            i11 = 0;
            int i16 = 0;
            int i17 = 0;
            while (i17 < i8) {
                int i18 = i15 + 1;
                ConstraintWidget constraintWidget = constraintWidgetArr[i17];
                int l22 = l2(constraintWidget, i10);
                if (constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i19 = i11;
                if ((i16 == i10 || this.f4640m1 + i16 + l22 > i10) && widgetsList.f4654b != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (!z9 && i17 > 0 && (i14 = this.f4645r1) > 0 && i18 > i14) {
                    z9 = true;
                }
                if (z9) {
                    widgetsList = new WidgetsList(i9, this.O, this.P, this.Q, this.R, i10);
                    widgetsList.i(i17);
                    this.f4647t1.add(widgetsList);
                    i15 = i18;
                    i16 = l22;
                } else {
                    if (i17 > 0) {
                        i16 += this.f4640m1 + l22;
                    } else {
                        i16 = l22;
                    }
                    i15 = 0;
                }
                widgetsList.b(constraintWidget);
                i17++;
                i11 = i19;
            }
        } else {
            int i20 = 0;
            i11 = 0;
            int i21 = 0;
            while (i21 < i8) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i21];
                int k22 = k2(constraintWidget2, i10);
                if (constraintWidget2.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i22 = i11;
                if ((i20 == i10 || this.f4641n1 + i20 + k22 > i10) && widgetsList.f4654b != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7 && i21 > 0 && (i12 = this.f4645r1) > 0 && i12 < 0) {
                    z7 = true;
                }
                if (z7) {
                    widgetsList = new WidgetsList(i9, this.O, this.P, this.Q, this.R, i10);
                    widgetsList.i(i21);
                    this.f4647t1.add(widgetsList);
                } else if (i21 > 0) {
                    i20 += this.f4641n1 + k22;
                    widgetsList.b(constraintWidget2);
                    i21++;
                    i11 = i22;
                }
                i20 = k22;
                widgetsList.b(constraintWidget2);
                i21++;
                i11 = i22;
            }
        }
        int size = this.f4647t1.size();
        ConstraintAnchor constraintAnchor3 = this.O;
        ConstraintAnchor constraintAnchor4 = this.P;
        ConstraintAnchor constraintAnchor5 = this.Q;
        ConstraintAnchor constraintAnchor6 = this.R;
        int z12 = z1();
        int B1 = B1();
        int A12 = A1();
        int y13 = y1();
        ConstraintWidget.DimensionBehaviour A = A();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (A != dimensionBehaviour && T() != dimensionBehaviour) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (i11 > 0 && z8) {
            for (int i23 = 0; i23 < size; i23++) {
                WidgetsList widgetsList2 = this.f4647t1.get(i23);
                if (i9 == 0) {
                    widgetsList2.g(i10 - widgetsList2.f());
                } else {
                    widgetsList2.g(i10 - widgetsList2.e());
                }
            }
        }
        int i24 = B1;
        int i25 = A12;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = z12;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i30 = y13;
        while (i28 < size) {
            WidgetsList widgetsList3 = this.f4647t1.get(i28);
            if (i9 == 0) {
                if (i28 < size - 1) {
                    constraintAnchor2 = this.f4647t1.get(i28 + 1).f4654b.P;
                    y12 = 0;
                } else {
                    constraintAnchor2 = this.R;
                    y12 = y1();
                }
                ConstraintAnchor constraintAnchor9 = widgetsList3.f4654b.R;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i31 = i26;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i32 = i27;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i13 = i28;
                widgetsList3.j(i9, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i29, i24, i25, y12, i10);
                int max = Math.max(i32, widgetsList3.f());
                i26 = i31 + widgetsList3.e();
                if (i13 > 0) {
                    i26 += this.f4641n1;
                }
                constraintAnchor8 = constraintAnchor11;
                i27 = max;
                constraintAnchor7 = constraintAnchor9;
                i24 = 0;
                constraintAnchor = constraintAnchor14;
                int i33 = y12;
                constraintAnchor6 = constraintAnchor2;
                i30 = i33;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i34 = i26;
                int i35 = i27;
                i13 = i28;
                if (i13 < size - 1) {
                    constraintAnchor = this.f4647t1.get(i13 + 1).f4654b.O;
                    A1 = 0;
                } else {
                    constraintAnchor = this.Q;
                    A1 = A1();
                }
                ConstraintAnchor constraintAnchor16 = widgetsList3.f4654b.Q;
                widgetsList3.j(i9, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i29, i24, A1, i30, i10);
                i27 = i35 + widgetsList3.f();
                int max2 = Math.max(i34, widgetsList3.e());
                if (i13 > 0) {
                    i27 += this.f4640m1;
                }
                i26 = max2;
                i25 = A1;
                constraintAnchor8 = constraintAnchor16;
                i29 = 0;
            }
            i28 = i13 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = i27;
        iArr[1] = i26;
    }

    private void p2(ConstraintWidget[] constraintWidgetArr, int i8, int i9, int i10, int[] iArr) {
        WidgetsList widgetsList;
        if (i8 == 0) {
            return;
        }
        if (this.f4647t1.size() == 0) {
            widgetsList = new WidgetsList(i9, this.O, this.P, this.Q, this.R, i10);
            this.f4647t1.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.f4647t1.get(0);
            widgetsList2.c();
            widgetsList = widgetsList2;
            widgetsList.j(i9, this.O, this.P, this.Q, this.R, z1(), B1(), A1(), y1(), i10);
        }
        for (int i11 = 0; i11 < i8; i11++) {
            widgetsList.b(constraintWidgetArr[i11]);
        }
        iArr[0] = widgetsList.f();
        iArr[1] = widgetsList.e();
    }

    public void A2(float f8) {
        this.f4639l1 = f8;
    }

    public void B2(int i8) {
        this.f4633f1 = i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0114  */
    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C1(int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.C1(int, int, int, int):void");
    }

    public void C2(int i8) {
        this.f4645r1 = i8;
    }

    public void D2(int i8) {
        this.f4646s1 = i8;
    }

    public void E2(int i8) {
        this.f4643p1 = i8;
    }

    public void F2(float f8) {
        this.f4635h1 = f8;
    }

    public void G2(int i8) {
        this.f4641n1 = i8;
    }

    public void H2(int i8) {
        this.f4629b1 = i8;
    }

    public void I2(int i8) {
        this.f4644q1 = i8;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(LinearSystem linearSystem, boolean z7) {
        boolean z8;
        boolean z9;
        boolean z10;
        super.g(linearSystem, z7);
        if (K() != null && ((ConstraintWidgetContainer) K()).P1()) {
            z8 = true;
        } else {
            z8 = false;
        }
        int i8 = this.f4644q1;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        int size = this.f4647t1.size();
                        for (int i9 = 0; i9 < size; i9++) {
                            WidgetsList widgetsList = this.f4647t1.get(i9);
                            if (i9 == size - 1) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            widgetsList.d(z8, i9, z10);
                        }
                    }
                } else {
                    j2(z8);
                }
            } else {
                int size2 = this.f4647t1.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    WidgetsList widgetsList2 = this.f4647t1.get(i10);
                    if (i10 == size2 - 1) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    widgetsList2.d(z8, i10, z9);
                }
            }
        } else if (this.f4647t1.size() > 0) {
            this.f4647t1.get(0).d(z8, 0, true);
        }
        G1(false);
    }

    public void q2(float f8) {
        this.f4636i1 = f8;
    }

    public void r2(int i8) {
        this.f4630c1 = i8;
    }

    public void s2(float f8) {
        this.f4637j1 = f8;
    }

    public void t2(int i8) {
        this.f4631d1 = i8;
    }

    public void u2(int i8) {
        this.f4642o1 = i8;
    }

    public void v2(float f8) {
        this.f4634g1 = f8;
    }

    public void w2(int i8) {
        this.f4640m1 = i8;
    }

    public void x2(int i8) {
        this.f4628a1 = i8;
    }

    public void y2(float f8) {
        this.f4638k1 = f8;
    }

    public void z2(int i8) {
        this.f4632e1 = i8;
    }
}
