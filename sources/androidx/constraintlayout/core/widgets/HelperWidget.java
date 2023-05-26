package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] L0 = new ConstraintWidget[4];
    public int M0 = 0;

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void a(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i8 = this.M0 + 1;
            ConstraintWidget[] constraintWidgetArr = this.L0;
            if (i8 > constraintWidgetArr.length) {
                this.L0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.L0;
            int i9 = this.M0;
            constraintWidgetArr2[i9] = constraintWidget;
            this.M0 = i9 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void b() {
        this.M0 = 0;
        Arrays.fill(this.L0, (Object) null);
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void c(ConstraintWidgetContainer constraintWidgetContainer) {
    }

    public void r1(ArrayList<WidgetGroup> arrayList, int i8, WidgetGroup widgetGroup) {
        for (int i9 = 0; i9 < this.M0; i9++) {
            widgetGroup.a(this.L0[i9]);
        }
        for (int i10 = 0; i10 < this.M0; i10++) {
            Grouping.a(this.L0[i10], i8, arrayList, widgetGroup);
        }
    }

    public int s1(int i8) {
        int i9;
        int i10;
        for (int i11 = 0; i11 < this.M0; i11++) {
            ConstraintWidget constraintWidget = this.L0[i11];
            if (i8 == 0 && (i10 = constraintWidget.I0) != -1) {
                return i10;
            }
            if (i8 == 1 && (i9 = constraintWidget.J0) != -1) {
                return i9;
            }
        }
        return -1;
    }
}
