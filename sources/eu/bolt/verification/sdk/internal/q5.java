package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class q5 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final x6 f44621f;

    /* renamed from: g  reason: collision with root package name */
    private final u f44622g;

    /* renamed from: h  reason: collision with root package name */
    private final q f44623h;

    public q5(x6 errorContent, u uVar, q qVar) {
        Intrinsics.f(errorContent, "errorContent");
        this.f44621f = errorContent;
        this.f44622g = uVar;
        this.f44623h = qVar;
    }

    public /* synthetic */ q5(x6 x6Var, u uVar, q qVar, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(x6Var, (i8 & 2) != 0 ? null : uVar, (i8 & 4) != 0 ? null : qVar);
    }

    public final u a() {
        return this.f44622g;
    }

    public final x6 b() {
        return this.f44621f;
    }

    public final q c() {
        return this.f44623h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q5) {
            q5 q5Var = (q5) obj;
            return Intrinsics.a(this.f44621f, q5Var.f44621f) && Intrinsics.a(this.f44622g, q5Var.f44622g) && Intrinsics.a(this.f44623h, q5Var.f44623h);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f44621f.hashCode() * 31;
        u uVar = this.f44622g;
        int hashCode2 = (hashCode + (uVar == null ? 0 : uVar.hashCode())) * 31;
        q qVar = this.f44623h;
        return hashCode2 + (qVar != null ? qVar.hashCode() : 0);
    }

    public String toString() {
        x6 x6Var = this.f44621f;
        u uVar = this.f44622g;
        q qVar = this.f44623h;
        return "DialogErrorRibArgs(errorContent=" + x6Var + ", analyticsScreen=" + uVar + ", onOpenAnalyticsEvent=" + qVar + ")";
    }
}
