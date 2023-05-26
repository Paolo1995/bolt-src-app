package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class s6 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final x6 f44943f;

    /* renamed from: g  reason: collision with root package name */
    private final a f44944g;

    /* renamed from: h  reason: collision with root package name */
    private final b f44945h;

    /* renamed from: i  reason: collision with root package name */
    private final u f44946i;

    /* renamed from: j  reason: collision with root package name */
    private final q f44947j;

    /* loaded from: classes5.dex */
    public enum a {
        Large,
        Small
    }

    /* loaded from: classes5.dex */
    public enum b {
        Center,
        Start
    }

    public s6(x6 errorContent, a buttonsSize, b textGravity, u uVar, q qVar) {
        Intrinsics.f(errorContent, "errorContent");
        Intrinsics.f(buttonsSize, "buttonsSize");
        Intrinsics.f(textGravity, "textGravity");
        this.f44943f = errorContent;
        this.f44944g = buttonsSize;
        this.f44945h = textGravity;
        this.f44946i = uVar;
        this.f44947j = qVar;
    }

    public /* synthetic */ s6(x6 x6Var, a aVar, b bVar, u uVar, q qVar, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(x6Var, (i8 & 2) != 0 ? a.Large : aVar, (i8 & 4) != 0 ? b.Center : bVar, (i8 & 8) != 0 ? null : uVar, (i8 & 16) != 0 ? null : qVar);
    }

    public final u a() {
        return this.f44946i;
    }

    public final a b() {
        return this.f44944g;
    }

    public final x6 c() {
        return this.f44943f;
    }

    public final q d() {
        return this.f44947j;
    }

    public final b e() {
        return this.f44945h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s6) {
            s6 s6Var = (s6) obj;
            return Intrinsics.a(this.f44943f, s6Var.f44943f) && this.f44944g == s6Var.f44944g && this.f44945h == s6Var.f44945h && Intrinsics.a(this.f44946i, s6Var.f44946i) && Intrinsics.a(this.f44947j, s6Var.f44947j);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f44943f.hashCode() * 31) + this.f44944g.hashCode()) * 31) + this.f44945h.hashCode()) * 31;
        u uVar = this.f44946i;
        int hashCode2 = (hashCode + (uVar == null ? 0 : uVar.hashCode())) * 31;
        q qVar = this.f44947j;
        return hashCode2 + (qVar != null ? qVar.hashCode() : 0);
    }

    public String toString() {
        x6 x6Var = this.f44943f;
        a aVar = this.f44944g;
        b bVar = this.f44945h;
        u uVar = this.f44946i;
        q qVar = this.f44947j;
        return "ErrorContentRibArgs(errorContent=" + x6Var + ", buttonsSize=" + aVar + ", textGravity=" + bVar + ", analyticsScreen=" + uVar + ", onOpenAnalyticsEvent=" + qVar + ")";
    }
}
