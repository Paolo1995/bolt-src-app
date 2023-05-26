package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class k7 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f43823f;

    /* renamed from: g  reason: collision with root package name */
    private final c f43824g;

    /* renamed from: h  reason: collision with root package name */
    private final nh f43825h;

    /* renamed from: i  reason: collision with root package name */
    private final a f43826i;

    /* renamed from: j  reason: collision with root package name */
    private final b f43827j;

    /* renamed from: k  reason: collision with root package name */
    private final e f43828k;

    /* loaded from: classes5.dex */
    public enum a {
        NONE,
        CLOSE_FORM,
        GO_BACK
    }

    /* loaded from: classes5.dex */
    public static final class b implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final String f43833f;

        /* renamed from: g  reason: collision with root package name */
        private final Map<String, String> f43834g;

        public b(String screenName, Map<String, String> parameters) {
            Intrinsics.f(screenName, "screenName");
            Intrinsics.f(parameters, "parameters");
            this.f43833f = screenName;
            this.f43834g = parameters;
        }

        public final Map<String, String> a() {
            return this.f43834g;
        }

        public final String b() {
            return this.f43833f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(this.f43833f, bVar.f43833f) && Intrinsics.a(this.f43834g, bVar.f43834g);
            }
            return false;
        }

        public int hashCode() {
            return (this.f43833f.hashCode() * 31) + this.f43834g.hashCode();
        }

        public String toString() {
            String str = this.f43833f;
            Map<String, String> map = this.f43834g;
            return "StepAnalytics(screenName=" + str + ", parameters=" + map + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final String f43835f;

        public c(String text) {
            Intrinsics.f(text, "text");
            this.f43835f = text;
        }

        public final String a() {
            return this.f43835f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.a(this.f43835f, ((c) obj).f43835f);
        }

        public int hashCode() {
            return this.f43835f.hashCode();
        }

        public String toString() {
            String str = this.f43835f;
            return "Title(text=" + str + ")";
        }
    }

    public k7(String stepId, c title, nh layout, a backNavigation, b bVar, e eVar) {
        Intrinsics.f(stepId, "stepId");
        Intrinsics.f(title, "title");
        Intrinsics.f(layout, "layout");
        Intrinsics.f(backNavigation, "backNavigation");
        this.f43823f = stepId;
        this.f43824g = title;
        this.f43825h = layout;
        this.f43826i = backNavigation;
        this.f43827j = bVar;
        this.f43828k = eVar;
    }

    public /* synthetic */ k7(String str, c cVar, nh nhVar, a aVar, b bVar, e eVar, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, cVar, nhVar, aVar, (i8 & 16) != 0 ? null : bVar, (i8 & 32) != 0 ? null : eVar);
    }

    public final b a() {
        return this.f43827j;
    }

    public final a b() {
        return this.f43826i;
    }

    public final e c() {
        return this.f43828k;
    }

    public final nh d() {
        return this.f43825h;
    }

    public final String e() {
        return this.f43823f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k7) {
            k7 k7Var = (k7) obj;
            return Intrinsics.a(this.f43823f, k7Var.f43823f) && Intrinsics.a(this.f43824g, k7Var.f43824g) && Intrinsics.a(this.f43825h, k7Var.f43825h) && this.f43826i == k7Var.f43826i && Intrinsics.a(this.f43827j, k7Var.f43827j) && Intrinsics.a(this.f43828k, k7Var.f43828k);
        }
        return false;
    }

    public final c f() {
        return this.f43824g;
    }

    public int hashCode() {
        int hashCode = ((((((this.f43823f.hashCode() * 31) + this.f43824g.hashCode()) * 31) + this.f43825h.hashCode()) * 31) + this.f43826i.hashCode()) * 31;
        b bVar = this.f43827j;
        int hashCode2 = (hashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
        e eVar = this.f43828k;
        return hashCode2 + (eVar != null ? eVar.hashCode() : 0);
    }

    public String toString() {
        String str = this.f43823f;
        c cVar = this.f43824g;
        nh nhVar = this.f43825h;
        a aVar = this.f43826i;
        b bVar = this.f43827j;
        e eVar = this.f43828k;
        return "FlowStep(stepId=" + str + ", title=" + cVar + ", layout=" + nhVar + ", backNavigation=" + aVar + ", analytics=" + bVar + ", backNavigationAnalytics=" + eVar + ")";
    }
}
