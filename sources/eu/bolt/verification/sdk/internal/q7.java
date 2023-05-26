package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.k7;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class q7 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f44630f;

    /* renamed from: g  reason: collision with root package name */
    private final k7.b f44631g;

    /* renamed from: h  reason: collision with root package name */
    private final k7.a f44632h;

    /* renamed from: i  reason: collision with root package name */
    private final e f44633i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f44634j;

    public q7(String stepId, k7.b bVar, k7.a backNavigation, e eVar, boolean z7) {
        Intrinsics.f(stepId, "stepId");
        Intrinsics.f(backNavigation, "backNavigation");
        this.f44630f = stepId;
        this.f44631g = bVar;
        this.f44632h = backNavigation;
        this.f44633i = eVar;
        this.f44634j = z7;
    }

    public final k7.a a() {
        return this.f44632h;
    }

    public final e b() {
        return this.f44633i;
    }

    public final k7.b c() {
        return this.f44631g;
    }

    public final String d() {
        return this.f44630f;
    }

    public final boolean e() {
        return this.f44634j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q7) {
            q7 q7Var = (q7) obj;
            return Intrinsics.a(this.f44630f, q7Var.f44630f) && Intrinsics.a(this.f44631g, q7Var.f44631g) && this.f44632h == q7Var.f44632h && Intrinsics.a(this.f44633i, q7Var.f44633i) && this.f44634j == q7Var.f44634j;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f44630f.hashCode() * 31;
        k7.b bVar = this.f44631g;
        int hashCode2 = (((hashCode + (bVar == null ? 0 : bVar.hashCode())) * 31) + this.f44632h.hashCode()) * 31;
        e eVar = this.f44633i;
        int hashCode3 = (hashCode2 + (eVar != null ? eVar.hashCode() : 0)) * 31;
        boolean z7 = this.f44634j;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode3 + i8;
    }

    public String toString() {
        String str = this.f44630f;
        k7.b bVar = this.f44631g;
        k7.a aVar = this.f44632h;
        e eVar = this.f44633i;
        boolean z7 = this.f44634j;
        return "FormBuilderRibArgs(stepId=" + str + ", stepAnalytics=" + bVar + ", backNavigation=" + aVar + ", backNavigationAnalytics=" + eVar + ", isError=" + z7 + ")";
    }
}
