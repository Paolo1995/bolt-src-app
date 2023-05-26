package io.ktor.http;

import io.ktor.http.HeaderValueWithParameters;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: ContentTypes.kt */
/* loaded from: classes5.dex */
public final class ContentType extends HeaderValueWithParameters {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f46727f = new Companion(null);

    /* renamed from: g  reason: collision with root package name */
    private static final ContentType f46728g = new ContentType("*", "*", null, 4, null);

    /* renamed from: d  reason: collision with root package name */
    private final String f46729d;

    /* renamed from: e  reason: collision with root package name */
    private final String f46730e;

    /* compiled from: ContentTypes.kt */
    /* loaded from: classes5.dex */
    public static final class Application {

        /* renamed from: a  reason: collision with root package name */
        public static final Application f46731a = new Application();

        /* renamed from: b  reason: collision with root package name */
        private static final ContentType f46732b = new ContentType("application", "*", null, 4, null);

        /* renamed from: c  reason: collision with root package name */
        private static final ContentType f46733c = new ContentType("application", "atom+xml", null, 4, null);

        /* renamed from: d  reason: collision with root package name */
        private static final ContentType f46734d = new ContentType("application", "cbor", null, 4, null);

        /* renamed from: e  reason: collision with root package name */
        private static final ContentType f46735e = new ContentType("application", "json", null, 4, null);

        /* renamed from: f  reason: collision with root package name */
        private static final ContentType f46736f = new ContentType("application", "hal+json", null, 4, null);

        /* renamed from: g  reason: collision with root package name */
        private static final ContentType f46737g = new ContentType("application", "javascript", null, 4, null);

        /* renamed from: h  reason: collision with root package name */
        private static final ContentType f46738h = new ContentType("application", "octet-stream", null, 4, null);

        /* renamed from: i  reason: collision with root package name */
        private static final ContentType f46739i = new ContentType("application", "font-woff", null, 4, null);

        /* renamed from: j  reason: collision with root package name */
        private static final ContentType f46740j = new ContentType("application", "rss+xml", null, 4, null);

        /* renamed from: k  reason: collision with root package name */
        private static final ContentType f46741k = new ContentType("application", "xml", null, 4, null);

        /* renamed from: l  reason: collision with root package name */
        private static final ContentType f46742l = new ContentType("application", "xml-dtd", null, 4, null);

        /* renamed from: m  reason: collision with root package name */
        private static final ContentType f46743m = new ContentType("application", "zip", null, 4, null);

        /* renamed from: n  reason: collision with root package name */
        private static final ContentType f46744n = new ContentType("application", "gzip", null, 4, null);

        /* renamed from: o  reason: collision with root package name */
        private static final ContentType f46745o = new ContentType("application", "x-www-form-urlencoded", null, 4, null);

        /* renamed from: p  reason: collision with root package name */
        private static final ContentType f46746p = new ContentType("application", "pdf", null, 4, null);

        /* renamed from: q  reason: collision with root package name */
        private static final ContentType f46747q = new ContentType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet", null, 4, null);

        /* renamed from: r  reason: collision with root package name */
        private static final ContentType f46748r = new ContentType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document", null, 4, null);

        /* renamed from: s  reason: collision with root package name */
        private static final ContentType f46749s = new ContentType("application", "vnd.openxmlformats-officedocument.presentationml.presentation", null, 4, null);

        /* renamed from: t  reason: collision with root package name */
        private static final ContentType f46750t = new ContentType("application", "protobuf", null, 4, null);

        /* renamed from: u  reason: collision with root package name */
        private static final ContentType f46751u = new ContentType("application", "wasm", null, 4, null);

        /* renamed from: v  reason: collision with root package name */
        private static final ContentType f46752v = new ContentType("application", "problem+json", null, 4, null);

        /* renamed from: w  reason: collision with root package name */
        private static final ContentType f46753w = new ContentType("application", "problem+xml", null, 4, null);

        private Application() {
        }

        public final ContentType a() {
            return f46735e;
        }

        public final ContentType b() {
            return f46738h;
        }
    }

    /* compiled from: ContentTypes.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ContentType a() {
            return ContentType.f46728g;
        }

        public final ContentType b(String value) {
            boolean y7;
            Object h02;
            int a02;
            CharSequence Y0;
            boolean z7;
            CharSequence Y02;
            boolean P;
            boolean P2;
            boolean P3;
            CharSequence Y03;
            Intrinsics.f(value, "value");
            y7 = StringsKt__StringsJVMKt.y(value);
            if (y7) {
                return a();
            }
            HeaderValueWithParameters.Companion companion = HeaderValueWithParameters.f46773c;
            h02 = CollectionsKt___CollectionsKt.h0(HttpHeaderValueParserKt.c(value));
            HeaderValue headerValue = (HeaderValue) h02;
            String d8 = headerValue.d();
            List<HeaderValueParam> b8 = headerValue.b();
            a02 = StringsKt__StringsKt.a0(d8, '/', 0, false, 6, null);
            if (a02 == -1) {
                Y03 = StringsKt__StringsKt.Y0(d8);
                if (Intrinsics.a(Y03.toString(), "*")) {
                    return ContentType.f46727f.a();
                }
                throw new BadContentTypeFormatException(value);
            }
            String substring = d8.substring(0, a02);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Y0 = StringsKt__StringsKt.Y0(substring);
            String obj = Y0.toString();
            boolean z8 = true;
            if (obj.length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                String substring2 = d8.substring(a02 + 1);
                Intrinsics.e(substring2, "this as java.lang.String).substring(startIndex)");
                Y02 = StringsKt__StringsKt.Y0(substring2);
                String obj2 = Y02.toString();
                P = StringsKt__StringsKt.P(obj, ' ', false, 2, null);
                if (!P) {
                    P2 = StringsKt__StringsKt.P(obj2, ' ', false, 2, null);
                    if (!P2) {
                        if (obj2.length() != 0) {
                            z8 = false;
                        }
                        if (!z8) {
                            P3 = StringsKt__StringsKt.P(obj2, '/', false, 2, null);
                            if (!P3) {
                                return new ContentType(obj, obj2, b8);
                            }
                        }
                        throw new BadContentTypeFormatException(value);
                    }
                }
                throw new BadContentTypeFormatException(value);
            }
            throw new BadContentTypeFormatException(value);
        }
    }

    /* compiled from: ContentTypes.kt */
    /* loaded from: classes5.dex */
    public static final class Text {

        /* renamed from: a  reason: collision with root package name */
        public static final Text f46754a = new Text();

        /* renamed from: b  reason: collision with root package name */
        private static final ContentType f46755b = new ContentType("text", "*", null, 4, null);

        /* renamed from: c  reason: collision with root package name */
        private static final ContentType f46756c = new ContentType("text", "plain", null, 4, null);

        /* renamed from: d  reason: collision with root package name */
        private static final ContentType f46757d = new ContentType("text", "css", null, 4, null);

        /* renamed from: e  reason: collision with root package name */
        private static final ContentType f46758e = new ContentType("text", "csv", null, 4, null);

        /* renamed from: f  reason: collision with root package name */
        private static final ContentType f46759f = new ContentType("text", "html", null, 4, null);

        /* renamed from: g  reason: collision with root package name */
        private static final ContentType f46760g = new ContentType("text", "javascript", null, 4, null);

        /* renamed from: h  reason: collision with root package name */
        private static final ContentType f46761h = new ContentType("text", "vcard", null, 4, null);

        /* renamed from: i  reason: collision with root package name */
        private static final ContentType f46762i = new ContentType("text", "xml", null, 4, null);

        /* renamed from: j  reason: collision with root package name */
        private static final ContentType f46763j = new ContentType("text", "event-stream", null, 4, null);

        private Text() {
        }

        public final ContentType a() {
            return f46756c;
        }
    }

    private ContentType(String str, String str2, String str3, List<HeaderValueParam> list) {
        super(str3, list);
        this.f46729d = str;
        this.f46730e = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0046 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean g(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.util.List r0 = r5.b()
            int r0 = r0.size()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L67
            if (r0 == r2) goto L48
            java.util.List r0 = r5.b()
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L1d
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L1d
            goto L67
        L1d:
            java.util.Iterator r0 = r0.iterator()
        L21:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L67
            java.lang.Object r3 = r0.next()
            io.ktor.http.HeaderValueParam r3 = (io.ktor.http.HeaderValueParam) r3
            java.lang.String r4 = r3.c()
            boolean r4 = kotlin.text.StringsKt.w(r4, r6, r2)
            if (r4 == 0) goto L43
            java.lang.String r3 = r3.d()
            boolean r3 = kotlin.text.StringsKt.w(r3, r7, r2)
            if (r3 == 0) goto L43
            r3 = 1
            goto L44
        L43:
            r3 = 0
        L44:
            if (r3 == 0) goto L21
        L46:
            r1 = 1
            goto L67
        L48:
            java.util.List r0 = r5.b()
            java.lang.Object r0 = r0.get(r1)
            io.ktor.http.HeaderValueParam r0 = (io.ktor.http.HeaderValueParam) r0
            java.lang.String r3 = r0.c()
            boolean r6 = kotlin.text.StringsKt.w(r3, r6, r2)
            if (r6 == 0) goto L67
            java.lang.String r6 = r0.d()
            boolean r6 = kotlin.text.StringsKt.w(r6, r7, r2)
            if (r6 == 0) goto L67
            goto L46
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.ContentType.g(java.lang.String, java.lang.String):boolean");
    }

    public final String e() {
        return this.f46730e;
    }

    public boolean equals(Object obj) {
        boolean w7;
        boolean w8;
        if (obj instanceof ContentType) {
            ContentType contentType = (ContentType) obj;
            w7 = StringsKt__StringsJVMKt.w(this.f46729d, contentType.f46729d, true);
            if (w7) {
                w8 = StringsKt__StringsJVMKt.w(this.f46730e, contentType.f46730e, true);
                if (w8 && Intrinsics.a(b(), contentType.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String f() {
        return this.f46729d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x008d, code lost:
        if (r4 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean h(io.ktor.http.ContentType r7) {
        /*
            r6 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = r7.f46729d
            java.lang.String r1 = "*"
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r1)
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L1c
            java.lang.String r0 = r7.f46729d
            java.lang.String r4 = r6.f46729d
            boolean r0 = kotlin.text.StringsKt.w(r0, r4, r3)
            if (r0 != 0) goto L1c
            return r2
        L1c:
            java.lang.String r0 = r7.f46730e
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r1)
            if (r0 != 0) goto L2f
            java.lang.String r0 = r7.f46730e
            java.lang.String r4 = r6.f46730e
            boolean r0 = kotlin.text.StringsKt.w(r0, r4, r3)
            if (r0 != 0) goto L2f
            return r2
        L2f:
            java.util.List r7 = r7.b()
            java.util.Iterator r7 = r7.iterator()
        L37:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L99
            java.lang.Object r0 = r7.next()
            io.ktor.http.HeaderValueParam r0 = (io.ktor.http.HeaderValueParam) r0
            java.lang.String r4 = r0.a()
            java.lang.String r0 = r0.b()
            boolean r5 = kotlin.jvm.internal.Intrinsics.a(r4, r1)
            if (r5 == 0) goto L83
            boolean r4 = kotlin.jvm.internal.Intrinsics.a(r0, r1)
            if (r4 == 0) goto L59
        L57:
            r0 = 1
            goto L96
        L59:
            java.util.List r4 = r6.b()
            boolean r5 = r4 instanceof java.util.Collection
            if (r5 == 0) goto L68
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L68
            goto L90
        L68:
            java.util.Iterator r4 = r4.iterator()
        L6c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L90
            java.lang.Object r5 = r4.next()
            io.ktor.http.HeaderValueParam r5 = (io.ktor.http.HeaderValueParam) r5
            java.lang.String r5 = r5.d()
            boolean r5 = kotlin.text.StringsKt.w(r5, r0, r3)
            if (r5 == 0) goto L6c
            goto L57
        L83:
            java.lang.String r4 = r6.c(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.a(r0, r1)
            if (r5 == 0) goto L92
            if (r4 == 0) goto L90
            goto L57
        L90:
            r0 = 0
            goto L96
        L92:
            boolean r0 = kotlin.text.StringsKt.w(r4, r0, r3)
        L96:
            if (r0 != 0) goto L37
            return r2
        L99:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.ContentType.h(io.ktor.http.ContentType):boolean");
    }

    public int hashCode() {
        String str = this.f46729d;
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int hashCode = lowerCase.hashCode();
        String lowerCase2 = this.f46730e.toLowerCase(locale);
        Intrinsics.e(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return hashCode + (hashCode * 31) + lowerCase2.hashCode() + (b().hashCode() * 31);
    }

    public final ContentType i(String name, String value) {
        List o02;
        Intrinsics.f(name, "name");
        Intrinsics.f(value, "value");
        if (g(name, value)) {
            return this;
        }
        String str = this.f46729d;
        String str2 = this.f46730e;
        String a8 = a();
        o02 = CollectionsKt___CollectionsKt.o0(b(), new HeaderValueParam(name, value));
        return new ContentType(str, str2, a8, o02);
    }

    public final ContentType j() {
        if (b().isEmpty()) {
            return this;
        }
        return new ContentType(this.f46729d, this.f46730e, null, 4, null);
    }

    public /* synthetic */ ContentType(String str, String str2, List list, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i8 & 4) != 0 ? CollectionsKt__CollectionsKt.k() : list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentType(String contentType, String contentSubtype, List<HeaderValueParam> parameters) {
        this(contentType, contentSubtype, contentType + '/' + contentSubtype, parameters);
        Intrinsics.f(contentType, "contentType");
        Intrinsics.f(contentSubtype, "contentSubtype");
        Intrinsics.f(parameters, "parameters");
    }
}
