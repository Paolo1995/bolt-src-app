package eu.bolt.verification.sdk.internal;

import eu.bolt.client.design.toolbar.DesignToolbarView;
import eu.bolt.verification.sdk.internal.nh;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b8 {

    /* renamed from: a  reason: collision with root package name */
    private final List<w7> f42290a;

    /* renamed from: b  reason: collision with root package name */
    private final nh.b.a f42291b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42292c;

    /* renamed from: d  reason: collision with root package name */
    private final DesignToolbarView.c f42293d;

    /* renamed from: e  reason: collision with root package name */
    private final List<w7> f42294e;

    /* JADX WARN: Multi-variable type inference failed */
    public b8(List<? extends w7> layoutElements, nh.b.a alignment, String title, DesignToolbarView.c toolbarHomeMode, List<? extends w7> bottomLayoutElements) {
        Intrinsics.f(layoutElements, "layoutElements");
        Intrinsics.f(alignment, "alignment");
        Intrinsics.f(title, "title");
        Intrinsics.f(toolbarHomeMode, "toolbarHomeMode");
        Intrinsics.f(bottomLayoutElements, "bottomLayoutElements");
        this.f42290a = layoutElements;
        this.f42291b = alignment;
        this.f42292c = title;
        this.f42293d = toolbarHomeMode;
        this.f42294e = bottomLayoutElements;
    }

    public final nh.b.a a() {
        return this.f42291b;
    }

    public final List<w7> b() {
        return this.f42294e;
    }

    public final List<w7> c() {
        return this.f42290a;
    }

    public final String d() {
        return this.f42292c;
    }

    public final DesignToolbarView.c e() {
        return this.f42293d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b8) {
            b8 b8Var = (b8) obj;
            return Intrinsics.a(this.f42290a, b8Var.f42290a) && this.f42291b == b8Var.f42291b && Intrinsics.a(this.f42292c, b8Var.f42292c) && Intrinsics.a(this.f42293d, b8Var.f42293d) && Intrinsics.a(this.f42294e, b8Var.f42294e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f42290a.hashCode() * 31) + this.f42291b.hashCode()) * 31) + this.f42292c.hashCode()) * 31) + this.f42293d.hashCode()) * 31) + this.f42294e.hashCode();
    }

    public String toString() {
        List<w7> list = this.f42290a;
        nh.b.a aVar = this.f42291b;
        String str = this.f42292c;
        DesignToolbarView.c cVar = this.f42293d;
        List<w7> list2 = this.f42294e;
        return "FormUiModel(layoutElements=" + list + ", alignment=" + aVar + ", title=" + str + ", toolbarHomeMode=" + cVar + ", bottomLayoutElements=" + list2 + ")";
    }
}
