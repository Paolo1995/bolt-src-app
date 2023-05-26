package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f4560e.f();
        constraintWidget.f4562f.f();
        this.f4758f = ((Guideline) constraintWidget).s1();
    }

    private void q(DependencyNode dependencyNode) {
        this.f4760h.f4710k.add(dependencyNode);
        dependencyNode.f4711l.add(this.f4760h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void a(Dependency dependency) {
        DependencyNode dependencyNode = this.f4760h;
        if (!dependencyNode.f4702c || dependencyNode.f4709j) {
            return;
        }
        this.f4760h.d((int) ((dependencyNode.f4711l.get(0).f4706g * ((Guideline) this.f4754b).v1()) + 0.5f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        Guideline guideline = (Guideline) this.f4754b;
        int t12 = guideline.t1();
        int u12 = guideline.u1();
        guideline.v1();
        if (guideline.s1() == 1) {
            if (t12 != -1) {
                this.f4760h.f4711l.add(this.f4754b.f4553a0.f4560e.f4760h);
                this.f4754b.f4553a0.f4560e.f4760h.f4710k.add(this.f4760h);
                this.f4760h.f4705f = t12;
            } else if (u12 != -1) {
                this.f4760h.f4711l.add(this.f4754b.f4553a0.f4560e.f4761i);
                this.f4754b.f4553a0.f4560e.f4761i.f4710k.add(this.f4760h);
                this.f4760h.f4705f = -u12;
            } else {
                DependencyNode dependencyNode = this.f4760h;
                dependencyNode.f4701b = true;
                dependencyNode.f4711l.add(this.f4754b.f4553a0.f4560e.f4761i);
                this.f4754b.f4553a0.f4560e.f4761i.f4710k.add(this.f4760h);
            }
            q(this.f4754b.f4560e.f4760h);
            q(this.f4754b.f4560e.f4761i);
            return;
        }
        if (t12 != -1) {
            this.f4760h.f4711l.add(this.f4754b.f4553a0.f4562f.f4760h);
            this.f4754b.f4553a0.f4562f.f4760h.f4710k.add(this.f4760h);
            this.f4760h.f4705f = t12;
        } else if (u12 != -1) {
            this.f4760h.f4711l.add(this.f4754b.f4553a0.f4562f.f4761i);
            this.f4754b.f4553a0.f4562f.f4761i.f4710k.add(this.f4760h);
            this.f4760h.f4705f = -u12;
        } else {
            DependencyNode dependencyNode2 = this.f4760h;
            dependencyNode2.f4701b = true;
            dependencyNode2.f4711l.add(this.f4754b.f4553a0.f4562f.f4761i);
            this.f4754b.f4553a0.f4562f.f4761i.f4710k.add(this.f4760h);
        }
        q(this.f4754b.f4562f.f4760h);
        q(this.f4754b.f4562f.f4761i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        if (((Guideline) this.f4754b).s1() == 1) {
            this.f4754b.m1(this.f4760h.f4706g);
        } else {
            this.f4754b.n1(this.f4760h.f4706g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f4760h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return false;
    }
}
