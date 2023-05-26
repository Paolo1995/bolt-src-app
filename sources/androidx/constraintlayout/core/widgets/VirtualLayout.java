package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

/* loaded from: classes.dex */
public class VirtualLayout extends HelperWidget {
    private int N0 = 0;
    private int O0 = 0;
    private int P0 = 0;
    private int Q0 = 0;
    private int R0 = 0;
    private int S0 = 0;
    private int T0 = 0;
    private int U0 = 0;
    private boolean V0 = false;
    private int W0 = 0;
    private int X0 = 0;
    protected BasicMeasure.Measure Y0 = new BasicMeasure.Measure();
    BasicMeasure.Measurer Z0 = null;

    public int A1() {
        return this.U0;
    }

    public int B1() {
        return this.N0;
    }

    public void C1(int i8, int i9, int i10, int i11) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D1(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i8, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i9) {
        while (this.Z0 == null && K() != null) {
            this.Z0 = ((ConstraintWidgetContainer) K()).I1();
        }
        BasicMeasure.Measure measure = this.Y0;
        measure.f4679a = dimensionBehaviour;
        measure.f4680b = dimensionBehaviour2;
        measure.f4681c = i8;
        measure.f4682d = i9;
        this.Z0.b(constraintWidget, measure);
        constraintWidget.k1(this.Y0.f4683e);
        constraintWidget.L0(this.Y0.f4684f);
        constraintWidget.K0(this.Y0.f4686h);
        constraintWidget.A0(this.Y0.f4685g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean E1() {
        BasicMeasure.Measurer measurer;
        ConstraintWidget constraintWidget = this.f4553a0;
        if (constraintWidget != null) {
            measurer = ((ConstraintWidgetContainer) constraintWidget).I1();
        } else {
            measurer = null;
        }
        if (measurer == null) {
            return false;
        }
        int i8 = 0;
        while (true) {
            boolean z7 = true;
            if (i8 >= this.M0) {
                return true;
            }
            ConstraintWidget constraintWidget2 = this.L0[i8];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour u7 = constraintWidget2.u(0);
                ConstraintWidget.DimensionBehaviour u8 = constraintWidget2.u(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (!((u7 != dimensionBehaviour || constraintWidget2.f4596w == 1 || u8 != dimensionBehaviour || constraintWidget2.f4598x == 1) ? false : false)) {
                    if (u7 == dimensionBehaviour) {
                        u7 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (u8 == dimensionBehaviour) {
                        u8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    BasicMeasure.Measure measure = this.Y0;
                    measure.f4679a = u7;
                    measure.f4680b = u8;
                    measure.f4681c = constraintWidget2.W();
                    this.Y0.f4682d = constraintWidget2.x();
                    measurer.b(constraintWidget2, this.Y0);
                    constraintWidget2.k1(this.Y0.f4683e);
                    constraintWidget2.L0(this.Y0.f4684f);
                    constraintWidget2.A0(this.Y0.f4685g);
                }
            }
            i8++;
        }
    }

    public boolean F1() {
        return this.V0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G1(boolean z7) {
        this.V0 = z7;
    }

    public void H1(int i8, int i9) {
        this.W0 = i8;
        this.X0 = i9;
    }

    public void I1(int i8) {
        this.P0 = i8;
        this.N0 = i8;
        this.Q0 = i8;
        this.O0 = i8;
        this.R0 = i8;
        this.S0 = i8;
    }

    public void J1(int i8) {
        this.O0 = i8;
    }

    public void K1(int i8) {
        this.S0 = i8;
    }

    public void L1(int i8) {
        this.P0 = i8;
        this.T0 = i8;
    }

    public void M1(int i8) {
        this.Q0 = i8;
        this.U0 = i8;
    }

    public void N1(int i8) {
        this.R0 = i8;
        this.T0 = i8;
        this.U0 = i8;
    }

    public void O1(int i8) {
        this.N0 = i8;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.Helper
    public void c(ConstraintWidgetContainer constraintWidgetContainer) {
        u1();
    }

    public void t1(boolean z7) {
        int i8 = this.R0;
        if (i8 > 0 || this.S0 > 0) {
            if (z7) {
                this.T0 = this.S0;
                this.U0 = i8;
                return;
            }
            this.T0 = i8;
            this.U0 = this.S0;
        }
    }

    public void u1() {
        for (int i8 = 0; i8 < this.M0; i8++) {
            ConstraintWidget constraintWidget = this.L0[i8];
            if (constraintWidget != null) {
                constraintWidget.U0(true);
            }
        }
    }

    public boolean v1(HashSet<ConstraintWidget> hashSet) {
        for (int i8 = 0; i8 < this.M0; i8++) {
            if (hashSet.contains(this.L0[i8])) {
                return true;
            }
        }
        return false;
    }

    public int w1() {
        return this.X0;
    }

    public int x1() {
        return this.W0;
    }

    public int y1() {
        return this.O0;
    }

    public int z1() {
        return this.T0;
    }
}
