package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChainRun extends WidgetRun {

    /* renamed from: k  reason: collision with root package name */
    ArrayList<WidgetRun> f4689k;

    /* renamed from: l  reason: collision with root package name */
    private int f4690l;

    public ChainRun(ConstraintWidget constraintWidget, int i8) {
        super(constraintWidget);
        this.f4689k = new ArrayList<>();
        this.f4758f = i8;
        q();
    }

    private void q() {
        ConstraintWidget constraintWidget;
        boolean z7;
        int S;
        ConstraintWidget constraintWidget2 = this.f4754b;
        ConstraintWidget L = constraintWidget2.L(this.f4758f);
        while (true) {
            ConstraintWidget constraintWidget3 = L;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            }
            L = constraintWidget2.L(this.f4758f);
        }
        this.f4754b = constraintWidget;
        this.f4689k.add(constraintWidget.N(this.f4758f));
        ConstraintWidget J = constraintWidget.J(this.f4758f);
        while (J != null) {
            this.f4689k.add(J.N(this.f4758f));
            J = J.J(this.f4758f);
        }
        Iterator<WidgetRun> it = this.f4689k.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i8 = this.f4758f;
            if (i8 == 0) {
                next.f4754b.f4556c = this;
            } else if (i8 == 1) {
                next.f4754b.f4558d = this;
            }
        }
        if (this.f4758f == 0 && ((ConstraintWidgetContainer) this.f4754b.K()).P1()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 && this.f4689k.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.f4689k;
            this.f4754b = arrayList.get(arrayList.size() - 1).f4754b;
        }
        if (this.f4758f == 0) {
            S = this.f4754b.z();
        } else {
            S = this.f4754b.S();
        }
        this.f4690l = S;
    }

    private ConstraintWidget r() {
        for (int i8 = 0; i8 < this.f4689k.size(); i8++) {
            WidgetRun widgetRun = this.f4689k.get(i8);
            if (widgetRun.f4754b.V() != 8) {
                return widgetRun.f4754b;
            }
        }
        return null;
    }

    private ConstraintWidget s() {
        for (int size = this.f4689k.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.f4689k.get(size);
            if (widgetRun.f4754b.V() != 8) {
                return widgetRun.f4754b;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:271:0x0402, code lost:
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e9  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(androidx.constraintlayout.core.widgets.analyzer.Dependency r27) {
        /*
            Method dump skipped, instructions count: 1066
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.ChainRun.a(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        Iterator<WidgetRun> it = this.f4689k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f4689k.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.f4689k.get(0).f4754b;
        ConstraintWidget constraintWidget2 = this.f4689k.get(size - 1).f4754b;
        if (this.f4758f == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.O;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.Q;
            DependencyNode i8 = i(constraintAnchor, 0);
            int f8 = constraintAnchor.f();
            ConstraintWidget r7 = r();
            if (r7 != null) {
                f8 = r7.O.f();
            }
            if (i8 != null) {
                b(this.f4760h, i8, f8);
            }
            DependencyNode i9 = i(constraintAnchor2, 0);
            int f9 = constraintAnchor2.f();
            ConstraintWidget s7 = s();
            if (s7 != null) {
                f9 = s7.Q.f();
            }
            if (i9 != null) {
                b(this.f4761i, i9, -f9);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.P;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.R;
            DependencyNode i10 = i(constraintAnchor3, 1);
            int f10 = constraintAnchor3.f();
            ConstraintWidget r8 = r();
            if (r8 != null) {
                f10 = r8.P.f();
            }
            if (i10 != null) {
                b(this.f4760h, i10, f10);
            }
            DependencyNode i11 = i(constraintAnchor4, 1);
            int f11 = constraintAnchor4.f();
            ConstraintWidget s8 = s();
            if (s8 != null) {
                f11 = s8.R.f();
            }
            if (i11 != null) {
                b(this.f4761i, i11, -f11);
            }
        }
        this.f4760h.f4700a = this;
        this.f4761i.f4700a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        for (int i8 = 0; i8 < this.f4689k.size(); i8++) {
            this.f4689k.get(i8).e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f4755c = null;
        Iterator<WidgetRun> it = this.f4689k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long j() {
        int size = this.f4689k.size();
        long j8 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            WidgetRun widgetRun = this.f4689k.get(i8);
            j8 = j8 + widgetRun.f4760h.f4705f + widgetRun.j() + widgetRun.f4761i.f4705f;
        }
        return j8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        int size = this.f4689k.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (!this.f4689k.get(i8).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ChainRun ");
        if (this.f4758f == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        sb.append(str);
        Iterator<WidgetRun> it = this.f4689k.iterator();
        while (it.hasNext()) {
            sb.append("<");
            sb.append(it.next());
            sb.append("> ");
        }
        return sb.toString();
    }
}
