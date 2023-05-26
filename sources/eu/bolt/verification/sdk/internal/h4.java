package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h4 {

    /* renamed from: a  reason: collision with root package name */
    private final j4 f43337a;

    /* renamed from: b  reason: collision with root package name */
    private final i4 f43338b;

    public h4(j4 view, i4 uiModel) {
        Intrinsics.f(view, "view");
        Intrinsics.f(uiModel, "uiModel");
        this.f43337a = view;
        this.f43338b = uiModel;
    }

    public final i4 a() {
        return this.f43338b;
    }

    public final j4 b() {
        return this.f43337a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h4) {
            h4 h4Var = (h4) obj;
            return Intrinsics.a(this.f43337a, h4Var.f43337a) && Intrinsics.a(this.f43338b, h4Var.f43338b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f43337a.hashCode() * 31) + this.f43338b.hashCode();
    }

    public String toString() {
        j4 j4Var = this.f43337a;
        i4 i4Var = this.f43338b;
        return "DesignCardStackViewItem(view=" + j4Var + ", uiModel=" + i4Var + ")";
    }
}
