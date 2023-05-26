package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class d implements Serializable {

    /* loaded from: classes5.dex */
    public static final class a extends d {

        /* renamed from: f  reason: collision with root package name */
        public static final a f42547f = new a();

        /* renamed from: g  reason: collision with root package name */
        private static final eu.bolt.verification.sdk.internal.e f42548g = null;

        private a() {
            super(null);
        }

        @Override // eu.bolt.verification.sdk.internal.d
        public eu.bolt.verification.sdk.internal.e a() {
            return f42548g;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends d {

        /* renamed from: f  reason: collision with root package name */
        public static final b f42549f = new b();

        /* renamed from: g  reason: collision with root package name */
        private static final eu.bolt.verification.sdk.internal.e f42550g = null;

        private b() {
            super(null);
        }

        @Override // eu.bolt.verification.sdk.internal.d
        public eu.bolt.verification.sdk.internal.e a() {
            return f42550g;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends d {

        /* renamed from: f  reason: collision with root package name */
        private final String f42551f;

        /* renamed from: g  reason: collision with root package name */
        private final eu.bolt.verification.sdk.internal.e f42552g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String stepId, eu.bolt.verification.sdk.internal.e eVar) {
            super(null);
            Intrinsics.f(stepId, "stepId");
            this.f42551f = stepId;
            this.f42552g = eVar;
        }

        public /* synthetic */ c(String str, eu.bolt.verification.sdk.internal.e eVar, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : eVar);
        }

        @Override // eu.bolt.verification.sdk.internal.d
        public eu.bolt.verification.sdk.internal.e a() {
            return this.f42552g;
        }

        public final String b() {
            return this.f42551f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.a(this.f42551f, cVar.f42551f) && Intrinsics.a(a(), cVar.a());
            }
            return false;
        }

        public int hashCode() {
            return (this.f42551f.hashCode() * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            String str = this.f42551f;
            eu.bolt.verification.sdk.internal.e a8 = a();
            return "GoToNextStep(stepId=" + str + ", analytics=" + a8 + ")";
        }
    }

    /* renamed from: eu.bolt.verification.sdk.internal.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0042d extends d {

        /* renamed from: f  reason: collision with root package name */
        private final String f42553f;

        /* renamed from: g  reason: collision with root package name */
        private final String f42554g;

        /* renamed from: h  reason: collision with root package name */
        private final List<b1> f42555h;

        /* renamed from: i  reason: collision with root package name */
        private final eu.bolt.verification.sdk.internal.e f42556i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0042d(String title, String contentHtml, List<b1> buttons, eu.bolt.verification.sdk.internal.e eVar) {
            super(null);
            Intrinsics.f(title, "title");
            Intrinsics.f(contentHtml, "contentHtml");
            Intrinsics.f(buttons, "buttons");
            this.f42553f = title;
            this.f42554g = contentHtml;
            this.f42555h = buttons;
            this.f42556i = eVar;
        }

        public /* synthetic */ C0042d(String str, String str2, List list, eu.bolt.verification.sdk.internal.e eVar, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, list, (i8 & 8) != 0 ? null : eVar);
        }

        @Override // eu.bolt.verification.sdk.internal.d
        public eu.bolt.verification.sdk.internal.e a() {
            return this.f42556i;
        }

        public final List<b1> b() {
            return this.f42555h;
        }

        public final String c() {
            return this.f42554g;
        }

        public final String d() {
            return this.f42553f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0042d) {
                C0042d c0042d = (C0042d) obj;
                return Intrinsics.a(this.f42553f, c0042d.f42553f) && Intrinsics.a(this.f42554g, c0042d.f42554g) && Intrinsics.a(this.f42555h, c0042d.f42555h) && Intrinsics.a(a(), c0042d.a());
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f42553f.hashCode() * 31) + this.f42554g.hashCode()) * 31) + this.f42555h.hashCode()) * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            String str = this.f42553f;
            String str2 = this.f42554g;
            List<b1> list = this.f42555h;
            eu.bolt.verification.sdk.internal.e a8 = a();
            return "OpenBottomSheet(title=" + str + ", contentHtml=" + str2 + ", buttons=" + list + ", analytics=" + a8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends d {

        /* renamed from: f  reason: collision with root package name */
        private final kp f42557f;

        /* renamed from: g  reason: collision with root package name */
        private final eu.bolt.verification.sdk.internal.e f42558g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(kp model, eu.bolt.verification.sdk.internal.e eVar) {
            super(null);
            Intrinsics.f(model, "model");
            this.f42557f = model;
            this.f42558g = eVar;
        }

        @Override // eu.bolt.verification.sdk.internal.d
        public eu.bolt.verification.sdk.internal.e a() {
            return this.f42558g;
        }

        public final kp b() {
            return this.f42557f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e) {
                e eVar = (e) obj;
                return Intrinsics.a(this.f42557f, eVar.f42557f) && Intrinsics.a(a(), eVar.a());
            }
            return false;
        }

        public int hashCode() {
            return (this.f42557f.hashCode() * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            kp kpVar = this.f42557f;
            eu.bolt.verification.sdk.internal.e a8 = a();
            return "OpenWebView(model=" + kpVar + ", analytics=" + a8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends d {

        /* renamed from: f  reason: collision with root package name */
        private final String f42559f;

        /* renamed from: g  reason: collision with root package name */
        private final Map<String, String> f42560g;

        /* renamed from: h  reason: collision with root package name */
        private final eu.bolt.verification.sdk.internal.e f42561h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String path, Map<String, String> params, eu.bolt.verification.sdk.internal.e eVar) {
            super(null);
            Intrinsics.f(path, "path");
            Intrinsics.f(params, "params");
            this.f42559f = path;
            this.f42560g = params;
            this.f42561h = eVar;
        }

        @Override // eu.bolt.verification.sdk.internal.d
        public eu.bolt.verification.sdk.internal.e a() {
            return this.f42561h;
        }

        public final Map<String, String> b() {
            return this.f42560g;
        }

        public final String c() {
            return this.f42559f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof f) {
                f fVar = (f) obj;
                return Intrinsics.a(this.f42559f, fVar.f42559f) && Intrinsics.a(this.f42560g, fVar.f42560g) && Intrinsics.a(a(), fVar.a());
            }
            return false;
        }

        public int hashCode() {
            return (((this.f42559f.hashCode() * 31) + this.f42560g.hashCode()) * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            String str = this.f42559f;
            Map<String, String> map = this.f42560g;
            eu.bolt.verification.sdk.internal.e a8 = a();
            return "SendPostRequest(path=" + str + ", params=" + map + ", analytics=" + a8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends d {

        /* renamed from: f  reason: collision with root package name */
        private final String f42562f;

        /* renamed from: g  reason: collision with root package name */
        private final eu.bolt.verification.sdk.internal.e f42563g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String stepId, eu.bolt.verification.sdk.internal.e eVar) {
            super(null);
            Intrinsics.f(stepId, "stepId");
            this.f42562f = stepId;
            this.f42563g = eVar;
        }

        @Override // eu.bolt.verification.sdk.internal.d
        public eu.bolt.verification.sdk.internal.e a() {
            return this.f42563g;
        }

        public final String b() {
            return this.f42562f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof g) {
                g gVar = (g) obj;
                return Intrinsics.a(this.f42562f, gVar.f42562f) && Intrinsics.a(a(), gVar.a());
            }
            return false;
        }

        public int hashCode() {
            return (this.f42562f.hashCode() * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            String str = this.f42562f;
            eu.bolt.verification.sdk.internal.e a8 = a();
            return "SubmitMultiFormRequest(stepId=" + str + ", analytics=" + a8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class h extends d {

        /* renamed from: f  reason: collision with root package name */
        private final em f42564f;

        /* renamed from: g  reason: collision with root package name */
        private final eu.bolt.verification.sdk.internal.e f42565g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(em userInput, eu.bolt.verification.sdk.internal.e eVar) {
            super(null);
            Intrinsics.f(userInput, "userInput");
            this.f42564f = userInput;
            this.f42565g = eVar;
        }

        @Override // eu.bolt.verification.sdk.internal.d
        public eu.bolt.verification.sdk.internal.e a() {
            return this.f42565g;
        }

        public final em b() {
            return this.f42564f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof h) {
                h hVar = (h) obj;
                return Intrinsics.a(this.f42564f, hVar.f42564f) && Intrinsics.a(a(), hVar.a());
            }
            return false;
        }

        public int hashCode() {
            return (this.f42564f.hashCode() * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            em emVar = this.f42564f;
            eu.bolt.verification.sdk.internal.e a8 = a();
            return "SubmitPredefinedData(userInput=" + emVar + ", analytics=" + a8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class i extends d {

        /* renamed from: f  reason: collision with root package name */
        private final String f42566f;

        /* renamed from: g  reason: collision with root package name */
        private final eu.bolt.verification.sdk.internal.e f42567g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String stepId, eu.bolt.verification.sdk.internal.e eVar) {
            super(null);
            Intrinsics.f(stepId, "stepId");
            this.f42566f = stepId;
            this.f42567g = eVar;
        }

        @Override // eu.bolt.verification.sdk.internal.d
        public eu.bolt.verification.sdk.internal.e a() {
            return this.f42567g;
        }

        public final String b() {
            return this.f42566f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof i) {
                i iVar = (i) obj;
                return Intrinsics.a(this.f42566f, iVar.f42566f) && Intrinsics.a(a(), iVar.a());
            }
            return false;
        }

        public int hashCode() {
            return (this.f42566f.hashCode() * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            String str = this.f42566f;
            eu.bolt.verification.sdk.internal.e a8 = a();
            return "SubmitUserData(stepId=" + str + ", analytics=" + a8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class j extends d {

        /* renamed from: f  reason: collision with root package name */
        private final String f42568f;

        /* renamed from: g  reason: collision with root package name */
        private final eu.bolt.verification.sdk.internal.e f42569g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String stepId, eu.bolt.verification.sdk.internal.e eVar) {
            super(null);
            Intrinsics.f(stepId, "stepId");
            this.f42568f = stepId;
            this.f42569g = eVar;
        }

        @Override // eu.bolt.verification.sdk.internal.d
        public eu.bolt.verification.sdk.internal.e a() {
            return this.f42569g;
        }

        public final String b() {
            return this.f42568f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof j) {
                j jVar = (j) obj;
                return Intrinsics.a(this.f42568f, jVar.f42568f) && Intrinsics.a(a(), jVar.a());
            }
            return false;
        }

        public int hashCode() {
            return (this.f42568f.hashCode() * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            String str = this.f42568f;
            eu.bolt.verification.sdk.internal.e a8 = a();
            return "SubmitUserDataAndClose(stepId=" + str + ", analytics=" + a8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class k extends d {

        /* renamed from: f  reason: collision with root package name */
        public static final k f42570f = new k();

        /* renamed from: g  reason: collision with root package name */
        private static final eu.bolt.verification.sdk.internal.e f42571g = null;

        private k() {
            super(null);
        }

        @Override // eu.bolt.verification.sdk.internal.d
        public eu.bolt.verification.sdk.internal.e a() {
            return f42571g;
        }
    }

    private d() {
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract eu.bolt.verification.sdk.internal.e a();
}
