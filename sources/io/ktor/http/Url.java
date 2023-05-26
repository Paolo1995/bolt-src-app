package io.ktor.http;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Url.kt */
/* loaded from: classes5.dex */
public final class Url {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f46915q = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final URLProtocol f46916a;

    /* renamed from: b  reason: collision with root package name */
    private final String f46917b;

    /* renamed from: c  reason: collision with root package name */
    private final int f46918c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f46919d;

    /* renamed from: e  reason: collision with root package name */
    private final Parameters f46920e;

    /* renamed from: f  reason: collision with root package name */
    private final String f46921f;

    /* renamed from: g  reason: collision with root package name */
    private final String f46922g;

    /* renamed from: h  reason: collision with root package name */
    private final String f46923h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f46924i;

    /* renamed from: j  reason: collision with root package name */
    private final String f46925j;

    /* renamed from: k  reason: collision with root package name */
    private final Lazy f46926k;

    /* renamed from: l  reason: collision with root package name */
    private final Lazy f46927l;

    /* renamed from: m  reason: collision with root package name */
    private final Lazy f46928m;

    /* renamed from: n  reason: collision with root package name */
    private final Lazy f46929n;

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f46930o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f46931p;

    /* compiled from: Url.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Url(URLProtocol protocol, String host, int i8, List<String> pathSegments, Parameters parameters, String fragment, String str, String str2, boolean z7, String urlString) {
        boolean z8;
        Lazy b8;
        Lazy b9;
        Lazy b10;
        Lazy b11;
        Lazy b12;
        Lazy b13;
        Intrinsics.f(protocol, "protocol");
        Intrinsics.f(host, "host");
        Intrinsics.f(pathSegments, "pathSegments");
        Intrinsics.f(parameters, "parameters");
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(urlString, "urlString");
        this.f46916a = protocol;
        this.f46917b = host;
        this.f46918c = i8;
        this.f46919d = pathSegments;
        this.f46920e = parameters;
        this.f46921f = fragment;
        this.f46922g = str;
        this.f46923h = str2;
        this.f46924i = z7;
        this.f46925j = urlString;
        boolean z9 = true;
        if (i8 >= 0 && i8 < 65536) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!z8 && i8 != 0) {
            z9 = false;
        }
        if (z9) {
            b8 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedPath$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final String invoke() {
                    String str3;
                    int a02;
                    String str4;
                    int d02;
                    String str5;
                    String str6;
                    if (!Url.this.i().isEmpty()) {
                        str3 = Url.this.f46925j;
                        a02 = StringsKt__StringsKt.a0(str3, '/', Url.this.k().e().length() + 3, false, 4, null);
                        if (a02 != -1) {
                            str4 = Url.this.f46925j;
                            d02 = StringsKt__StringsKt.d0(str4, new char[]{'?', '#'}, a02, false, 4, null);
                            if (d02 == -1) {
                                str6 = Url.this.f46925j;
                                String substring = str6.substring(a02);
                                Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                                return substring;
                            }
                            str5 = Url.this.f46925j;
                            String substring2 = str5.substring(a02, d02);
                            Intrinsics.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                            return substring2;
                        }
                        return "";
                    }
                    return "";
                }
            });
            this.f46926k = b8;
            b9 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedQuery$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final String invoke() {
                    String str3;
                    int a02;
                    String str4;
                    int a03;
                    String str5;
                    String str6;
                    str3 = Url.this.f46925j;
                    a02 = StringsKt__StringsKt.a0(str3, '?', 0, false, 6, null);
                    int i9 = a02 + 1;
                    if (i9 != 0) {
                        str4 = Url.this.f46925j;
                        a03 = StringsKt__StringsKt.a0(str4, '#', i9, false, 4, null);
                        if (a03 == -1) {
                            str6 = Url.this.f46925j;
                            String substring = str6.substring(i9);
                            Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                            return substring;
                        }
                        str5 = Url.this.f46925j;
                        String substring2 = str5.substring(i9, a03);
                        Intrinsics.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        return substring2;
                    }
                    return "";
                }
            });
            this.f46927l = b9;
            b10 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedPathAndQuery$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final String invoke() {
                    String str3;
                    int a02;
                    String str4;
                    int a03;
                    String str5;
                    String str6;
                    str3 = Url.this.f46925j;
                    a02 = StringsKt__StringsKt.a0(str3, '/', Url.this.k().e().length() + 3, false, 4, null);
                    if (a02 != -1) {
                        str4 = Url.this.f46925j;
                        a03 = StringsKt__StringsKt.a0(str4, '#', a02, false, 4, null);
                        if (a03 == -1) {
                            str6 = Url.this.f46925j;
                            String substring = str6.substring(a02);
                            Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                            return substring;
                        }
                        str5 = Url.this.f46925j;
                        String substring2 = str5.substring(a02, a03);
                        Intrinsics.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        return substring2;
                    }
                    return "";
                }
            });
            this.f46928m = b10;
            b11 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedUser$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final String invoke() {
                    boolean z10;
                    String str3;
                    int d02;
                    String str4;
                    if (Url.this.n() == null) {
                        return null;
                    }
                    if (Url.this.n().length() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        return "";
                    }
                    int length = Url.this.k().e().length() + 3;
                    str3 = Url.this.f46925j;
                    d02 = StringsKt__StringsKt.d0(str3, new char[]{':', '@'}, length, false, 4, null);
                    str4 = Url.this.f46925j;
                    String substring = str4.substring(length, d02);
                    Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return substring;
                }
            });
            this.f46929n = b11;
            b12 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedPassword$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final String invoke() {
                    boolean z10;
                    String str3;
                    int a02;
                    String str4;
                    int a03;
                    String str5;
                    if (Url.this.h() == null) {
                        return null;
                    }
                    if (Url.this.h().length() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        str3 = Url.this.f46925j;
                        a02 = StringsKt__StringsKt.a0(str3, ':', Url.this.k().e().length() + 3, false, 4, null);
                        str4 = Url.this.f46925j;
                        a03 = StringsKt__StringsKt.a0(str4, '@', 0, false, 6, null);
                        str5 = Url.this.f46925j;
                        String substring = str5.substring(a02 + 1, a03);
                        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        return substring;
                    }
                    return "";
                }
            });
            this.f46930o = b12;
            b13 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedFragment$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final String invoke() {
                    String str3;
                    int a02;
                    String str4;
                    str3 = Url.this.f46925j;
                    a02 = StringsKt__StringsKt.a0(str3, '#', 0, false, 6, null);
                    int i9 = a02 + 1;
                    if (i9 != 0) {
                        str4 = Url.this.f46925j;
                        String substring = str4.substring(i9);
                        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                        return substring;
                    }
                    return "";
                }
            });
            this.f46931p = b13;
            return;
        }
        throw new IllegalArgumentException("port must be between 0 and 65535, or 0 if not set".toString());
    }

    public final String b() {
        return (String) this.f46931p.getValue();
    }

    public final String c() {
        return (String) this.f46930o.getValue();
    }

    public final String d() {
        return (String) this.f46926k.getValue();
    }

    public final String e() {
        return (String) this.f46927l.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Intrinsics.a(Reflection.b(Url.class), Reflection.b(obj.getClass())) && Intrinsics.a(this.f46925j, ((Url) obj).f46925j)) {
            return true;
        }
        return false;
    }

    public final String f() {
        return (String) this.f46929n.getValue();
    }

    public final String g() {
        return this.f46917b;
    }

    public final String h() {
        return this.f46923h;
    }

    public int hashCode() {
        return this.f46925j.hashCode();
    }

    public final List<String> i() {
        return this.f46919d;
    }

    public final int j() {
        boolean z7;
        Integer valueOf = Integer.valueOf(this.f46918c);
        if (valueOf.intValue() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return this.f46916a.d();
    }

    public final URLProtocol k() {
        return this.f46916a;
    }

    public final int l() {
        return this.f46918c;
    }

    public final boolean m() {
        return this.f46924i;
    }

    public final String n() {
        return this.f46922g;
    }

    public String toString() {
        return this.f46925j;
    }
}
