package io.ktor.http;

import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLBuilder.kt */
/* loaded from: classes5.dex */
public final class URLBuilder {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f46891k;

    /* renamed from: l  reason: collision with root package name */
    private static final Url f46892l;

    /* renamed from: a  reason: collision with root package name */
    private URLProtocol f46893a;

    /* renamed from: b  reason: collision with root package name */
    private String f46894b;

    /* renamed from: c  reason: collision with root package name */
    private int f46895c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f46896d;

    /* renamed from: e  reason: collision with root package name */
    private String f46897e;

    /* renamed from: f  reason: collision with root package name */
    private String f46898f;

    /* renamed from: g  reason: collision with root package name */
    private String f46899g;

    /* renamed from: h  reason: collision with root package name */
    private List<String> f46900h;

    /* renamed from: i  reason: collision with root package name */
    private ParametersBuilder f46901i;

    /* renamed from: j  reason: collision with root package name */
    private ParametersBuilder f46902j;

    /* compiled from: URLBuilder.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Companion companion = new Companion(null);
        f46891k = companion;
        f46892l = URLUtilsKt.d(URLBuilderJvmKt.a(companion));
    }

    public URLBuilder() {
        this(null, null, 0, null, null, null, null, null, false, 511, null);
    }

    public URLBuilder(URLProtocol protocol, String host, int i8, String str, String str2, List<String> pathSegments, Parameters parameters, String fragment, boolean z7) {
        int v7;
        Intrinsics.f(protocol, "protocol");
        Intrinsics.f(host, "host");
        Intrinsics.f(pathSegments, "pathSegments");
        Intrinsics.f(parameters, "parameters");
        Intrinsics.f(fragment, "fragment");
        this.f46893a = protocol;
        this.f46894b = host;
        this.f46895c = i8;
        this.f46896d = z7;
        this.f46897e = str != null ? CodecsKt.m(str, false, 1, null) : null;
        this.f46898f = str2 != null ? CodecsKt.m(str2, false, 1, null) : null;
        this.f46899g = CodecsKt.r(fragment, false, false, null, 7, null);
        v7 = CollectionsKt__IterablesKt.v(pathSegments, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (String str3 : pathSegments) {
            arrayList.add(CodecsKt.p(str3));
        }
        this.f46900h = arrayList;
        ParametersBuilder e8 = UrlDecodedParametersBuilderKt.e(parameters);
        this.f46901i = e8;
        this.f46902j = new UrlDecodedParametersBuilder(e8);
    }

    private final void a() {
        boolean z7;
        if (this.f46894b.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7 && !Intrinsics.a(this.f46893a.e(), "file")) {
            Url url = f46892l;
            this.f46894b = url.g();
            if (Intrinsics.a(this.f46893a, URLProtocol.f46905c.c())) {
                this.f46893a = url.k();
            }
            if (this.f46895c == 0) {
                this.f46895c = url.l();
            }
        }
    }

    public final void A(String str) {
        String str2 = null;
        if (str != null) {
            str2 = CodecsKt.m(str, false, 1, null);
        }
        this.f46897e = str2;
    }

    public final Url b() {
        a();
        return new Url(this.f46893a, this.f46894b, this.f46895c, m(), this.f46902j.build(), i(), q(), l(), this.f46896d, c());
    }

    public final String c() {
        Appendable g8;
        a();
        g8 = URLBuilderKt.g(this, new StringBuilder((int) Spliterator.NONNULL));
        String sb = ((StringBuilder) g8).toString();
        Intrinsics.e(sb, "appendTo(StringBuilder(256)).toString()");
        return sb;
    }

    public final String d() {
        return this.f46899g;
    }

    public final ParametersBuilder e() {
        return this.f46901i;
    }

    public final String f() {
        return this.f46898f;
    }

    public final List<String> g() {
        return this.f46900h;
    }

    public final String h() {
        return this.f46897e;
    }

    public final String i() {
        return CodecsKt.k(this.f46899g, 0, 0, false, null, 15, null);
    }

    public final String j() {
        return this.f46894b;
    }

    public final ParametersBuilder k() {
        return this.f46902j;
    }

    public final String l() {
        String str = this.f46898f;
        if (str != null) {
            return CodecsKt.i(str, 0, 0, null, 7, null);
        }
        return null;
    }

    public final List<String> m() {
        int v7;
        List<String> list = this.f46900h;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (String str : list) {
            arrayList.add(CodecsKt.i(str, 0, 0, null, 7, null));
        }
        return arrayList;
    }

    public final int n() {
        return this.f46895c;
    }

    public final URLProtocol o() {
        return this.f46893a;
    }

    public final boolean p() {
        return this.f46896d;
    }

    public final String q() {
        String str = this.f46897e;
        if (str != null) {
            return CodecsKt.i(str, 0, 0, null, 7, null);
        }
        return null;
    }

    public final void r(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f46899g = str;
    }

    public final void s(ParametersBuilder value) {
        Intrinsics.f(value, "value");
        this.f46901i = value;
        this.f46902j = new UrlDecodedParametersBuilder(value);
    }

    public final void t(String str) {
        this.f46898f = str;
    }

    public final void u(List<String> list) {
        Intrinsics.f(list, "<set-?>");
        this.f46900h = list;
    }

    public final void v(String str) {
        this.f46897e = str;
    }

    public final void w(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f46894b = str;
    }

    public final void x(int i8) {
        this.f46895c = i8;
    }

    public final void y(URLProtocol uRLProtocol) {
        Intrinsics.f(uRLProtocol, "<set-?>");
        this.f46893a = uRLProtocol;
    }

    public final void z(boolean z7) {
        this.f46896d = z7;
    }

    public /* synthetic */ URLBuilder(URLProtocol uRLProtocol, String str, int i8, String str2, String str3, List list, Parameters parameters, String str4, boolean z7, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? URLProtocol.f46905c.c() : uRLProtocol, (i9 & 2) != 0 ? "" : str, (i9 & 4) != 0 ? 0 : i8, (i9 & 8) != 0 ? null : str2, (i9 & 16) == 0 ? str3 : null, (i9 & 32) != 0 ? CollectionsKt__CollectionsKt.k() : list, (i9 & 64) != 0 ? Parameters.f46888b.a() : parameters, (i9 & 128) == 0 ? str4 : "", (i9 & Spliterator.NONNULL) == 0 ? z7 : false);
    }
}
