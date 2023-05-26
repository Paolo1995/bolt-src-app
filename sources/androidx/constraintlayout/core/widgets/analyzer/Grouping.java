package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Grouping {
    public static WidgetGroup a(ConstraintWidget constraintWidget, int i8, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        int i9;
        int s12;
        if (i8 == 0) {
            i9 = constraintWidget.I0;
        } else {
            i9 = constraintWidget.J0;
        }
        int i10 = 0;
        if (i9 != -1 && (widgetGroup == null || i9 != widgetGroup.f4740b)) {
            int i11 = 0;
            while (true) {
                if (i11 >= arrayList.size()) {
                    break;
                }
                WidgetGroup widgetGroup2 = arrayList.get(i11);
                if (widgetGroup2.c() == i9) {
                    if (widgetGroup != null) {
                        widgetGroup.g(i8, widgetGroup2);
                        arrayList.remove(widgetGroup);
                    }
                    widgetGroup = widgetGroup2;
                } else {
                    i11++;
                }
            }
        } else if (i9 != -1) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            if ((constraintWidget instanceof HelperWidget) && (s12 = ((HelperWidget) constraintWidget).s1(i8)) != -1) {
                int i12 = 0;
                while (true) {
                    if (i12 >= arrayList.size()) {
                        break;
                    }
                    WidgetGroup widgetGroup3 = arrayList.get(i12);
                    if (widgetGroup3.c() == s12) {
                        widgetGroup = widgetGroup3;
                        break;
                    }
                    i12++;
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new WidgetGroup(i8);
            }
            arrayList.add(widgetGroup);
        }
        if (widgetGroup.a(constraintWidget)) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                ConstraintAnchor r12 = guideline.r1();
                if (guideline.s1() == 0) {
                    i10 = 1;
                }
                r12.c(i10, arrayList, widgetGroup);
            }
            if (i8 == 0) {
                constraintWidget.I0 = widgetGroup.c();
                constraintWidget.O.c(i8, arrayList, widgetGroup);
                constraintWidget.Q.c(i8, arrayList, widgetGroup);
            } else {
                constraintWidget.J0 = widgetGroup.c();
                constraintWidget.P.c(i8, arrayList, widgetGroup);
                constraintWidget.S.c(i8, arrayList, widgetGroup);
                constraintWidget.R.c(i8, arrayList, widgetGroup);
            }
            constraintWidget.V.c(i8, arrayList, widgetGroup);
        }
        return widgetGroup;
    }

    private static WidgetGroup b(ArrayList<WidgetGroup> arrayList, int i8) {
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            WidgetGroup widgetGroup = arrayList.get(i9);
            if (i8 == widgetGroup.f4740b) {
                return widgetGroup;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03a0 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r16, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r17) {
        /*
            Method dump skipped, instructions count: 935
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Grouping.c(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer):boolean");
    }

    public static boolean d(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        boolean z7;
        boolean z8;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour3 != dimensionBehaviour7 && dimensionBehaviour3 != (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == dimensionBehaviour6)) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (dimensionBehaviour4 != dimensionBehaviour7 && dimensionBehaviour4 != (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour2 == dimensionBehaviour5)) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (!z7 && !z8) {
            return false;
        }
        return true;
    }
}
