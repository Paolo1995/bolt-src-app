package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.k7;
import java.io.File;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class en implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f42826f;

    /* renamed from: g  reason: collision with root package name */
    private final String f42827g;

    /* renamed from: h  reason: collision with root package name */
    private final k7.b f42828h;

    /* renamed from: i  reason: collision with root package name */
    private final String f42829i;

    /* renamed from: j  reason: collision with root package name */
    private final String f42830j;

    /* renamed from: k  reason: collision with root package name */
    private final String f42831k;

    /* renamed from: l  reason: collision with root package name */
    private final x6 f42832l;

    /* renamed from: m  reason: collision with root package name */
    private final l1 f42833m;

    /* renamed from: n  reason: collision with root package name */
    private final p9 f42834n;

    /* renamed from: o  reason: collision with root package name */
    private final n1 f42835o;

    /* renamed from: p  reason: collision with root package name */
    private final q1 f42836p;

    /* renamed from: q  reason: collision with root package name */
    private final File f42837q;

    /* renamed from: r  reason: collision with root package name */
    private final k7.a f42838r;

    /* renamed from: s  reason: collision with root package name */
    private final e f42839s;

    public en(String flowId, String stepId, k7.b bVar, String nextStepId, String str, String str2, x6 x6Var, l1 overlay, p9 p9Var, n1 theme, q1 cameraType, File outputFile, k7.a backNavigation, e eVar) {
        Intrinsics.f(flowId, "flowId");
        Intrinsics.f(stepId, "stepId");
        Intrinsics.f(nextStepId, "nextStepId");
        Intrinsics.f(overlay, "overlay");
        Intrinsics.f(theme, "theme");
        Intrinsics.f(cameraType, "cameraType");
        Intrinsics.f(outputFile, "outputFile");
        Intrinsics.f(backNavigation, "backNavigation");
        this.f42826f = flowId;
        this.f42827g = stepId;
        this.f42828h = bVar;
        this.f42829i = nextStepId;
        this.f42830j = str;
        this.f42831k = str2;
        this.f42832l = x6Var;
        this.f42833m = overlay;
        this.f42834n = p9Var;
        this.f42835o = theme;
        this.f42836p = cameraType;
        this.f42837q = outputFile;
        this.f42838r = backNavigation;
        this.f42839s = eVar;
    }

    public final k7.a a() {
        return this.f42838r;
    }

    public final e b() {
        return this.f42839s;
    }

    public final q1 c() {
        return this.f42836p;
    }

    public final String d() {
        return this.f42831k;
    }

    public final String e() {
        return this.f42826f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof en) {
            en enVar = (en) obj;
            return Intrinsics.a(this.f42826f, enVar.f42826f) && Intrinsics.a(this.f42827g, enVar.f42827g) && Intrinsics.a(this.f42828h, enVar.f42828h) && Intrinsics.a(this.f42829i, enVar.f42829i) && Intrinsics.a(this.f42830j, enVar.f42830j) && Intrinsics.a(this.f42831k, enVar.f42831k) && Intrinsics.a(this.f42832l, enVar.f42832l) && Intrinsics.a(this.f42833m, enVar.f42833m) && Intrinsics.a(this.f42834n, enVar.f42834n) && this.f42835o == enVar.f42835o && this.f42836p == enVar.f42836p && Intrinsics.a(this.f42837q, enVar.f42837q) && this.f42838r == enVar.f42838r && Intrinsics.a(this.f42839s, enVar.f42839s);
        }
        return false;
    }

    public final String f() {
        return this.f42829i;
    }

    public final File g() {
        return this.f42837q;
    }

    public final l1 h() {
        return this.f42833m;
    }

    public int hashCode() {
        int hashCode = ((this.f42826f.hashCode() * 31) + this.f42827g.hashCode()) * 31;
        k7.b bVar = this.f42828h;
        int hashCode2 = (((hashCode + (bVar == null ? 0 : bVar.hashCode())) * 31) + this.f42829i.hashCode()) * 31;
        String str = this.f42830j;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f42831k;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        x6 x6Var = this.f42832l;
        int hashCode5 = (((hashCode4 + (x6Var == null ? 0 : x6Var.hashCode())) * 31) + this.f42833m.hashCode()) * 31;
        p9 p9Var = this.f42834n;
        int hashCode6 = (((((((((hashCode5 + (p9Var == null ? 0 : p9Var.hashCode())) * 31) + this.f42835o.hashCode()) * 31) + this.f42836p.hashCode()) * 31) + this.f42837q.hashCode()) * 31) + this.f42838r.hashCode()) * 31;
        e eVar = this.f42839s;
        return hashCode6 + (eVar != null ? eVar.hashCode() : 0);
    }

    public final p9 i() {
        return this.f42834n;
    }

    public final x6 j() {
        return this.f42832l;
    }

    public final k7.b k() {
        return this.f42828h;
    }

    public final String l() {
        return this.f42827g;
    }

    public final n1 m() {
        return this.f42835o;
    }

    public final String n() {
        return this.f42830j;
    }

    public String toString() {
        String str = this.f42826f;
        String str2 = this.f42827g;
        k7.b bVar = this.f42828h;
        String str3 = this.f42829i;
        String str4 = this.f42830j;
        String str5 = this.f42831k;
        x6 x6Var = this.f42832l;
        l1 l1Var = this.f42833m;
        p9 p9Var = this.f42834n;
        n1 n1Var = this.f42835o;
        q1 q1Var = this.f42836p;
        File file = this.f42837q;
        k7.a aVar = this.f42838r;
        e eVar = this.f42839s;
        return "VerificationCameraRibArgs(flowId=" + str + ", stepId=" + str2 + ", stepAnalytics=" + bVar + ", nextStepId=" + str3 + ", title=" + str4 + ", descriptionHtml=" + str5 + ", permissionErrorModel=" + x6Var + ", overlay=" + l1Var + ", overlayImage=" + p9Var + ", theme=" + n1Var + ", cameraType=" + q1Var + ", outputFile=" + file + ", backNavigation=" + aVar + ", backNavigationAnalytics=" + eVar + ")";
    }
}
