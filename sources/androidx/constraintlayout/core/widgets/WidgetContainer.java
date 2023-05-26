package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> L0 = new ArrayList<>();

    public void a(ConstraintWidget constraintWidget) {
        this.L0.add(constraintWidget);
        if (constraintWidget.K() != null) {
            ((WidgetContainer) constraintWidget.K()).t1(constraintWidget);
        }
        constraintWidget.c1(this);
    }

    public ArrayList<ConstraintWidget> r1() {
        return this.L0;
    }

    public void s1() {
        ArrayList<ConstraintWidget> arrayList = this.L0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            ConstraintWidget constraintWidget = this.L0.get(i8);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).s1();
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void t0() {
        this.L0.clear();
        super.t0();
    }

    public void t1(ConstraintWidget constraintWidget) {
        this.L0.remove(constraintWidget);
        constraintWidget.t0();
    }

    public void u1() {
        this.L0.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void w0(Cache cache) {
        super.w0(cache);
        int size = this.L0.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.L0.get(i8).w0(cache);
        }
    }
}
