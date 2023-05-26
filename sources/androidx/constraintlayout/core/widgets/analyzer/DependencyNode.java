package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DependencyNode implements Dependency {

    /* renamed from: d  reason: collision with root package name */
    WidgetRun f4703d;

    /* renamed from: f  reason: collision with root package name */
    int f4705f;

    /* renamed from: g  reason: collision with root package name */
    public int f4706g;

    /* renamed from: a  reason: collision with root package name */
    public Dependency f4700a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4701b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4702c = false;

    /* renamed from: e  reason: collision with root package name */
    Type f4704e = Type.UNKNOWN;

    /* renamed from: h  reason: collision with root package name */
    int f4707h = 1;

    /* renamed from: i  reason: collision with root package name */
    DimensionDependency f4708i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4709j = false;

    /* renamed from: k  reason: collision with root package name */
    List<Dependency> f4710k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    List<DependencyNode> f4711l = new ArrayList();

    /* loaded from: classes.dex */
    enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f4703d = widgetRun;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void a(Dependency dependency) {
        for (DependencyNode dependencyNode : this.f4711l) {
            if (!dependencyNode.f4709j) {
                return;
            }
        }
        this.f4702c = true;
        Dependency dependency2 = this.f4700a;
        if (dependency2 != null) {
            dependency2.a(this);
        }
        if (this.f4701b) {
            this.f4703d.a(this);
            return;
        }
        DependencyNode dependencyNode2 = null;
        int i8 = 0;
        for (DependencyNode dependencyNode3 : this.f4711l) {
            if (!(dependencyNode3 instanceof DimensionDependency)) {
                i8++;
                dependencyNode2 = dependencyNode3;
            }
        }
        if (dependencyNode2 != null && i8 == 1 && dependencyNode2.f4709j) {
            DimensionDependency dimensionDependency = this.f4708i;
            if (dimensionDependency != null) {
                if (dimensionDependency.f4709j) {
                    this.f4705f = this.f4707h * dimensionDependency.f4706g;
                } else {
                    return;
                }
            }
            d(dependencyNode2.f4706g + this.f4705f);
        }
        Dependency dependency3 = this.f4700a;
        if (dependency3 != null) {
            dependency3.a(this);
        }
    }

    public void b(Dependency dependency) {
        this.f4710k.add(dependency);
        if (this.f4709j) {
            dependency.a(dependency);
        }
    }

    public void c() {
        this.f4711l.clear();
        this.f4710k.clear();
        this.f4709j = false;
        this.f4706g = 0;
        this.f4702c = false;
        this.f4701b = false;
    }

    public void d(int i8) {
        if (this.f4709j) {
            return;
        }
        this.f4709j = true;
        this.f4706g = i8;
        for (Dependency dependency : this.f4710k) {
            dependency.a(dependency);
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4703d.f4754b.t());
        sb.append(":");
        sb.append(this.f4704e);
        sb.append("(");
        if (this.f4709j) {
            obj = Integer.valueOf(this.f4706g);
        } else {
            obj = "unresolved";
        }
        sb.append(obj);
        sb.append(") <t=");
        sb.append(this.f4711l.size());
        sb.append(":d=");
        sb.append(this.f4710k.size());
        sb.append(">");
        return sb.toString();
    }
}
