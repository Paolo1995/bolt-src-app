package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RunGroup {

    /* renamed from: h  reason: collision with root package name */
    public static int f4727h;

    /* renamed from: c  reason: collision with root package name */
    WidgetRun f4730c;

    /* renamed from: d  reason: collision with root package name */
    WidgetRun f4731d;

    /* renamed from: f  reason: collision with root package name */
    int f4733f;

    /* renamed from: g  reason: collision with root package name */
    int f4734g;

    /* renamed from: a  reason: collision with root package name */
    public int f4728a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4729b = false;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<WidgetRun> f4732e = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun, int i8) {
        this.f4730c = null;
        this.f4731d = null;
        int i9 = f4727h;
        this.f4733f = i9;
        f4727h = i9 + 1;
        this.f4730c = widgetRun;
        this.f4731d = widgetRun;
        this.f4734g = i8;
    }

    private long c(DependencyNode dependencyNode, long j8) {
        WidgetRun widgetRun = dependencyNode.f4703d;
        if (widgetRun instanceof HelperReferences) {
            return j8;
        }
        int size = dependencyNode.f4710k.size();
        long j9 = j8;
        for (int i8 = 0; i8 < size; i8++) {
            Dependency dependency = dependencyNode.f4710k.get(i8);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f4703d != widgetRun) {
                    j9 = Math.min(j9, c(dependencyNode2, dependencyNode2.f4705f + j8));
                }
            }
        }
        if (dependencyNode == widgetRun.f4761i) {
            long j10 = j8 - widgetRun.j();
            return Math.min(Math.min(j9, c(widgetRun.f4760h, j10)), j10 - widgetRun.f4760h.f4705f);
        }
        return j9;
    }

    private long d(DependencyNode dependencyNode, long j8) {
        WidgetRun widgetRun = dependencyNode.f4703d;
        if (widgetRun instanceof HelperReferences) {
            return j8;
        }
        int size = dependencyNode.f4710k.size();
        long j9 = j8;
        for (int i8 = 0; i8 < size; i8++) {
            Dependency dependency = dependencyNode.f4710k.get(i8);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f4703d != widgetRun) {
                    j9 = Math.max(j9, d(dependencyNode2, dependencyNode2.f4705f + j8));
                }
            }
        }
        if (dependencyNode == widgetRun.f4760h) {
            long j10 = j8 + widgetRun.j();
            return Math.max(Math.max(j9, d(widgetRun.f4761i, j10)), j10 - widgetRun.f4761i.f4705f);
        }
        return j9;
    }

    public void a(WidgetRun widgetRun) {
        this.f4732e.add(widgetRun);
        this.f4731d = widgetRun;
    }

    public long b(ConstraintWidgetContainer constraintWidgetContainer, int i8) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        WidgetRun widgetRun3;
        long j8;
        int i9;
        DependencyNode dependencyNode;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun4;
        WidgetRun widgetRun5 = this.f4730c;
        long j9 = 0;
        if (widgetRun5 instanceof ChainRun) {
            if (((ChainRun) widgetRun5).f4758f != i8) {
                return 0L;
            }
        } else if (i8 == 0) {
            if (!(widgetRun5 instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun5 instanceof VerticalWidgetRun)) {
            return 0L;
        }
        if (i8 == 0) {
            widgetRun = constraintWidgetContainer.f4560e;
        } else {
            widgetRun = constraintWidgetContainer.f4562f;
        }
        DependencyNode dependencyNode3 = widgetRun.f4760h;
        if (i8 == 0) {
            widgetRun2 = constraintWidgetContainer.f4560e;
        } else {
            widgetRun2 = constraintWidgetContainer.f4562f;
        }
        DependencyNode dependencyNode4 = widgetRun2.f4761i;
        boolean contains = widgetRun5.f4760h.f4711l.contains(dependencyNode3);
        boolean contains2 = this.f4730c.f4761i.f4711l.contains(dependencyNode4);
        long j10 = this.f4730c.j();
        if (contains && contains2) {
            long d8 = d(this.f4730c.f4760h, 0L);
            long c8 = c(this.f4730c.f4761i, 0L);
            long j11 = d8 - j10;
            WidgetRun widgetRun6 = this.f4730c;
            int i10 = widgetRun6.f4761i.f4705f;
            if (j11 >= (-i10)) {
                j11 += i10;
            }
            int i11 = widgetRun6.f4760h.f4705f;
            long j12 = ((-c8) - j10) - i11;
            if (j12 >= i11) {
                j12 -= i11;
            }
            float q8 = widgetRun6.f4754b.q(i8);
            if (q8 > 0.0f) {
                j9 = (((float) j12) / q8) + (((float) j11) / (1.0f - q8));
            }
            float f8 = (float) j9;
            long j13 = (f8 * q8) + 0.5f + j10 + (f8 * (1.0f - q8)) + 0.5f;
            j8 = widgetRun4.f4760h.f4705f + j13;
            i9 = this.f4730c.f4761i.f4705f;
        } else if (contains) {
            return Math.max(d(this.f4730c.f4760h, dependencyNode2.f4705f), this.f4730c.f4760h.f4705f + j10);
        } else if (contains2) {
            return Math.max(-c(this.f4730c.f4761i, dependencyNode.f4705f), (-this.f4730c.f4761i.f4705f) + j10);
        } else {
            j8 = widgetRun3.f4760h.f4705f + this.f4730c.j();
            i9 = this.f4730c.f4761i.f4705f;
        }
        return j8 - i9;
    }
}
