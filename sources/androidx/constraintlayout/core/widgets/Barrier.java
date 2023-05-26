package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class Barrier extends HelperWidget {
    private int N0 = 0;
    private boolean O0 = true;
    private int P0 = 0;
    boolean Q0 = false;

    public void A1(int i8) {
        this.N0 = i8;
    }

    public void B1(int i8) {
        this.P0 = i8;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(LinearSystem linearSystem, boolean z7) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        int i8;
        int i9;
        int i10;
        int i11;
        ConstraintAnchor[] constraintAnchorArr2 = this.W;
        constraintAnchorArr2[0] = this.O;
        constraintAnchorArr2[2] = this.P;
        constraintAnchorArr2[1] = this.Q;
        constraintAnchorArr2[3] = this.R;
        int i12 = 0;
        while (true) {
            constraintAnchorArr = this.W;
            if (i12 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i12];
            constraintAnchor.f4540i = linearSystem.q(constraintAnchor);
            i12++;
        }
        int i13 = this.N0;
        if (i13 >= 0 && i13 < 4) {
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i13];
            if (!this.Q0) {
                t1();
            }
            if (this.Q0) {
                this.Q0 = false;
                int i14 = this.N0;
                if (i14 != 0 && i14 != 1) {
                    if (i14 == 2 || i14 == 3) {
                        linearSystem.f(this.P.f4540i, this.f4565g0);
                        linearSystem.f(this.R.f4540i, this.f4565g0);
                        return;
                    }
                    return;
                }
                linearSystem.f(this.O.f4540i, this.f4563f0);
                linearSystem.f(this.Q.f4540i, this.f4563f0);
                return;
            }
            for (int i15 = 0; i15 < this.M0; i15++) {
                ConstraintWidget constraintWidget = this.L0[i15];
                if ((this.O0 || constraintWidget.h()) && ((((i10 = this.N0) == 0 || i10 == 1) && constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.O.f4537f != null && constraintWidget.Q.f4537f != null) || (((i11 = this.N0) == 2 || i11 == 3) && constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.P.f4537f != null && constraintWidget.R.f4537f != null))) {
                    z8 = true;
                    break;
                }
            }
            z8 = false;
            if (!this.O.l() && !this.Q.l()) {
                z9 = false;
            } else {
                z9 = true;
            }
            if (!this.P.l() && !this.R.l()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z8 && (((i9 = this.N0) == 0 && z9) || ((i9 == 2 && z10) || ((i9 == 1 && z9) || (i9 == 3 && z10))))) {
                z11 = true;
            } else {
                z11 = false;
            }
            int i16 = 5;
            if (!z11) {
                i16 = 4;
            }
            for (int i17 = 0; i17 < this.M0; i17++) {
                ConstraintWidget constraintWidget2 = this.L0[i17];
                if (this.O0 || constraintWidget2.h()) {
                    SolverVariable q8 = linearSystem.q(constraintWidget2.W[this.N0]);
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.W;
                    int i18 = this.N0;
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i18];
                    constraintAnchor3.f4540i = q8;
                    ConstraintAnchor constraintAnchor4 = constraintAnchor3.f4537f;
                    if (constraintAnchor4 != null && constraintAnchor4.f4535d == this) {
                        i8 = constraintAnchor3.f4538g + 0;
                    } else {
                        i8 = 0;
                    }
                    if (i18 != 0 && i18 != 2) {
                        linearSystem.g(constraintAnchor2.f4540i, q8, this.P0 + i8, z8);
                    } else {
                        linearSystem.i(constraintAnchor2.f4540i, q8, this.P0 - i8, z8);
                    }
                    linearSystem.e(constraintAnchor2.f4540i, q8, this.P0 + i8, i16);
                }
            }
            int i19 = this.N0;
            if (i19 == 0) {
                linearSystem.e(this.Q.f4540i, this.O.f4540i, 0, 8);
                linearSystem.e(this.O.f4540i, this.f4553a0.Q.f4540i, 0, 4);
                linearSystem.e(this.O.f4540i, this.f4553a0.O.f4540i, 0, 0);
            } else if (i19 == 1) {
                linearSystem.e(this.O.f4540i, this.Q.f4540i, 0, 8);
                linearSystem.e(this.O.f4540i, this.f4553a0.O.f4540i, 0, 4);
                linearSystem.e(this.O.f4540i, this.f4553a0.Q.f4540i, 0, 0);
            } else if (i19 == 2) {
                linearSystem.e(this.R.f4540i, this.P.f4540i, 0, 8);
                linearSystem.e(this.P.f4540i, this.f4553a0.R.f4540i, 0, 4);
                linearSystem.e(this.P.f4540i, this.f4553a0.P.f4540i, 0, 0);
            } else if (i19 == 3) {
                linearSystem.e(this.P.f4540i, this.R.f4540i, 0, 8);
                linearSystem.e(this.P.f4540i, this.f4553a0.P.f4540i, 0, 4);
                linearSystem.e(this.P.f4540i, this.f4553a0.R.f4540i, 0, 0);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean n0() {
        return this.Q0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean o0() {
        return this.Q0;
    }

    public boolean t1() {
        int i8;
        int i9;
        int i10;
        int i11 = 0;
        boolean z7 = true;
        while (true) {
            i8 = this.M0;
            if (i11 >= i8) {
                break;
            }
            ConstraintWidget constraintWidget = this.L0[i11];
            if ((this.O0 || constraintWidget.h()) && ((((i9 = this.N0) == 0 || i9 == 1) && !constraintWidget.n0()) || (((i10 = this.N0) == 2 || i10 == 3) && !constraintWidget.o0()))) {
                z7 = false;
            }
            i11++;
        }
        if (!z7 || i8 <= 0) {
            return false;
        }
        int i12 = 0;
        boolean z8 = false;
        for (int i13 = 0; i13 < this.M0; i13++) {
            ConstraintWidget constraintWidget2 = this.L0[i13];
            if (this.O0 || constraintWidget2.h()) {
                if (!z8) {
                    int i14 = this.N0;
                    if (i14 == 0) {
                        i12 = constraintWidget2.o(ConstraintAnchor.Type.LEFT).e();
                    } else if (i14 == 1) {
                        i12 = constraintWidget2.o(ConstraintAnchor.Type.RIGHT).e();
                    } else if (i14 == 2) {
                        i12 = constraintWidget2.o(ConstraintAnchor.Type.TOP).e();
                    } else if (i14 == 3) {
                        i12 = constraintWidget2.o(ConstraintAnchor.Type.BOTTOM).e();
                    }
                    z8 = true;
                }
                int i15 = this.N0;
                if (i15 == 0) {
                    i12 = Math.min(i12, constraintWidget2.o(ConstraintAnchor.Type.LEFT).e());
                } else if (i15 == 1) {
                    i12 = Math.max(i12, constraintWidget2.o(ConstraintAnchor.Type.RIGHT).e());
                } else if (i15 == 2) {
                    i12 = Math.min(i12, constraintWidget2.o(ConstraintAnchor.Type.TOP).e());
                } else if (i15 == 3) {
                    i12 = Math.max(i12, constraintWidget2.o(ConstraintAnchor.Type.BOTTOM).e());
                }
            }
        }
        int i16 = i12 + this.P0;
        int i17 = this.N0;
        if (i17 != 0 && i17 != 1) {
            I0(i16, i16);
        } else {
            F0(i16, i16);
        }
        this.Q0 = true;
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + t() + " {";
        for (int i8 = 0; i8 < this.M0; i8++) {
            ConstraintWidget constraintWidget = this.L0[i8];
            if (i8 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.t();
        }
        return str + "}";
    }

    public boolean u1() {
        return this.O0;
    }

    public int v1() {
        return this.N0;
    }

    public int w1() {
        return this.P0;
    }

    public int x1() {
        int i8 = this.N0;
        if (i8 != 0 && i8 != 1) {
            if (i8 == 2 || i8 == 3) {
                return 1;
            }
            return -1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y1() {
        for (int i8 = 0; i8 < this.M0; i8++) {
            ConstraintWidget constraintWidget = this.L0[i8];
            if (this.O0 || constraintWidget.h()) {
                int i9 = this.N0;
                if (i9 != 0 && i9 != 1) {
                    if (i9 == 2 || i9 == 3) {
                        constraintWidget.S0(1, true);
                    }
                } else {
                    constraintWidget.S0(0, true);
                }
            }
        }
    }

    public void z1(boolean z7) {
        this.O0 = z7;
    }
}
