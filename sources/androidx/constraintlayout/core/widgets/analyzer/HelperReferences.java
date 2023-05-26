package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class HelperReferences extends WidgetRun {
    public HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void q(DependencyNode dependencyNode) {
        this.f4760h.f4710k.add(dependencyNode);
        dependencyNode.f4711l.add(this.f4760h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void a(Dependency dependency) {
        Barrier barrier = (Barrier) this.f4754b;
        int v12 = barrier.v1();
        int i8 = 0;
        int i9 = -1;
        for (DependencyNode dependencyNode : this.f4760h.f4711l) {
            int i10 = dependencyNode.f4706g;
            if (i9 == -1 || i10 < i9) {
                i9 = i10;
            }
            if (i8 < i10) {
                i8 = i10;
            }
        }
        if (v12 != 0 && v12 != 2) {
            this.f4760h.d(i8 + barrier.w1());
        } else {
            this.f4760h.d(i9 + barrier.w1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget constraintWidget = this.f4754b;
        if (constraintWidget instanceof Barrier) {
            this.f4760h.f4701b = true;
            Barrier barrier = (Barrier) constraintWidget;
            int v12 = barrier.v1();
            boolean u12 = barrier.u1();
            int i8 = 0;
            if (v12 != 0) {
                if (v12 != 1) {
                    if (v12 != 2) {
                        if (v12 == 3) {
                            this.f4760h.f4704e = DependencyNode.Type.BOTTOM;
                            while (i8 < barrier.M0) {
                                ConstraintWidget constraintWidget2 = barrier.L0[i8];
                                if (u12 || constraintWidget2.V() != 8) {
                                    DependencyNode dependencyNode = constraintWidget2.f4562f.f4761i;
                                    dependencyNode.f4710k.add(this.f4760h);
                                    this.f4760h.f4711l.add(dependencyNode);
                                }
                                i8++;
                            }
                            q(this.f4754b.f4562f.f4760h);
                            q(this.f4754b.f4562f.f4761i);
                            return;
                        }
                        return;
                    }
                    this.f4760h.f4704e = DependencyNode.Type.TOP;
                    while (i8 < barrier.M0) {
                        ConstraintWidget constraintWidget3 = barrier.L0[i8];
                        if (u12 || constraintWidget3.V() != 8) {
                            DependencyNode dependencyNode2 = constraintWidget3.f4562f.f4760h;
                            dependencyNode2.f4710k.add(this.f4760h);
                            this.f4760h.f4711l.add(dependencyNode2);
                        }
                        i8++;
                    }
                    q(this.f4754b.f4562f.f4760h);
                    q(this.f4754b.f4562f.f4761i);
                    return;
                }
                this.f4760h.f4704e = DependencyNode.Type.RIGHT;
                while (i8 < barrier.M0) {
                    ConstraintWidget constraintWidget4 = barrier.L0[i8];
                    if (u12 || constraintWidget4.V() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.f4560e.f4761i;
                        dependencyNode3.f4710k.add(this.f4760h);
                        this.f4760h.f4711l.add(dependencyNode3);
                    }
                    i8++;
                }
                q(this.f4754b.f4560e.f4760h);
                q(this.f4754b.f4560e.f4761i);
                return;
            }
            this.f4760h.f4704e = DependencyNode.Type.LEFT;
            while (i8 < barrier.M0) {
                ConstraintWidget constraintWidget5 = barrier.L0[i8];
                if (u12 || constraintWidget5.V() != 8) {
                    DependencyNode dependencyNode4 = constraintWidget5.f4560e.f4760h;
                    dependencyNode4.f4710k.add(this.f4760h);
                    this.f4760h.f4711l.add(dependencyNode4);
                }
                i8++;
            }
            q(this.f4754b.f4560e.f4760h);
            q(this.f4754b.f4560e.f4761i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        ConstraintWidget constraintWidget = this.f4754b;
        if (constraintWidget instanceof Barrier) {
            int v12 = ((Barrier) constraintWidget).v1();
            if (v12 != 0 && v12 != 1) {
                this.f4754b.n1(this.f4760h.f4706g);
            } else {
                this.f4754b.m1(this.f4760h.f4706g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f4755c = null;
        this.f4760h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return false;
    }
}
