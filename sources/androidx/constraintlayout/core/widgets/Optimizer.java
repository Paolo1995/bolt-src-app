package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class Optimizer {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f4672a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        constraintWidget.f4590t = -1;
        constraintWidget.f4592u = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.Z[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.Z[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i8 = constraintWidget.O.f4538g;
            int W = constraintWidgetContainer.W() - constraintWidget.Q.f4538g;
            ConstraintAnchor constraintAnchor = constraintWidget.O;
            constraintAnchor.f4540i = linearSystem.q(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.Q;
            constraintAnchor2.f4540i = linearSystem.q(constraintAnchor2);
            linearSystem.f(constraintWidget.O.f4540i, i8);
            linearSystem.f(constraintWidget.Q.f4540i, W);
            constraintWidget.f4590t = 2;
            constraintWidget.O0(i8, W);
        }
        if (constraintWidgetContainer.Z[1] != dimensionBehaviour2 && constraintWidget.Z[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i9 = constraintWidget.P.f4538g;
            int x7 = constraintWidgetContainer.x() - constraintWidget.R.f4538g;
            ConstraintAnchor constraintAnchor3 = constraintWidget.P;
            constraintAnchor3.f4540i = linearSystem.q(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.R;
            constraintAnchor4.f4540i = linearSystem.q(constraintAnchor4);
            linearSystem.f(constraintWidget.P.f4540i, i9);
            linearSystem.f(constraintWidget.R.f4540i, x7);
            if (constraintWidget.f4575l0 > 0 || constraintWidget.V() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.S;
                constraintAnchor5.f4540i = linearSystem.q(constraintAnchor5);
                linearSystem.f(constraintWidget.S.f4540i, constraintWidget.f4575l0 + i9);
            }
            constraintWidget.f4592u = 2;
            constraintWidget.f1(i9, x7);
        }
    }

    public static final boolean b(int i8, int i9) {
        return (i8 & i9) == i9;
    }
}
