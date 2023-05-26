package ee.mtakso.driver.uikit.recyclerview;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutListModel.kt */
/* loaded from: classes5.dex */
public final class LayoutListModel {

    /* renamed from: a  reason: collision with root package name */
    private final int f35988a;

    /* renamed from: b  reason: collision with root package name */
    private final int f35989b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35990c;

    /* renamed from: d  reason: collision with root package name */
    private final int f35991d;

    /* renamed from: e  reason: collision with root package name */
    private final ListModel f35992e;

    public LayoutListModel(int i8, int i9, int i10, int i11, ListModel model) {
        Intrinsics.f(model, "model");
        this.f35988a = i8;
        this.f35989b = i9;
        this.f35990c = i10;
        this.f35991d = i11;
        this.f35992e = model;
    }

    public final int a() {
        return this.f35989b;
    }

    public final int b() {
        return this.f35991d;
    }

    public final ListModel c() {
        return this.f35992e;
    }

    public final int d() {
        return this.f35988a;
    }

    public final int e() {
        return this.f35990c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LayoutListModel) {
            LayoutListModel layoutListModel = (LayoutListModel) obj;
            return this.f35988a == layoutListModel.f35988a && this.f35989b == layoutListModel.f35989b && this.f35990c == layoutListModel.f35990c && this.f35991d == layoutListModel.f35991d && Intrinsics.a(this.f35992e, layoutListModel.f35992e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f35988a * 31) + this.f35989b) * 31) + this.f35990c) * 31) + this.f35991d) * 31) + this.f35992e.hashCode();
    }

    public String toString() {
        int i8 = this.f35988a;
        int i9 = this.f35989b;
        int i10 = this.f35990c;
        int i11 = this.f35991d;
        ListModel listModel = this.f35992e;
        return "LayoutListModel(row=" + i8 + ", col=" + i9 + ", width=" + i10 + ", height=" + i11 + ", model=" + listModel + ")";
    }
}
