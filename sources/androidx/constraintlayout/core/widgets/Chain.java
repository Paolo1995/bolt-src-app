package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Chain {
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r7 == 2) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
        if (r7 == 2) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0264 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03ae A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x051f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x03a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:336:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.core.LinearSystem r38, int r39, int r40, androidx.constraintlayout.core.widgets.ChainHead r41) {
        /*
            Method dump skipped, instructions count: 1344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Chain.a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead):void");
    }

    public static void b(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i8) {
        ChainHead[] chainHeadArr;
        int i9;
        int i10;
        if (i8 == 0) {
            i9 = constraintWidgetContainer.X0;
            chainHeadArr = constraintWidgetContainer.f4611a1;
            i10 = 0;
        } else {
            int i11 = constraintWidgetContainer.Y0;
            chainHeadArr = constraintWidgetContainer.Z0;
            i9 = i11;
            i10 = 2;
        }
        for (int i12 = 0; i12 < i9; i12++) {
            ChainHead chainHead = chainHeadArr[i12];
            chainHead.a();
            if (arrayList == null || arrayList.contains(chainHead.f4510a)) {
                a(constraintWidgetContainer, linearSystem, i8, i10, chainHead);
            }
        }
    }
}
