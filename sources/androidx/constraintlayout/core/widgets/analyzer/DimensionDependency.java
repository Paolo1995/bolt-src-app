package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DimensionDependency extends DependencyNode {

    /* renamed from: m  reason: collision with root package name */
    public int f4721m;

    public DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.f4704e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.f4704e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
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
}
