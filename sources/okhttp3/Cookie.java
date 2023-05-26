package okhttp3;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import i0.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: Cookie.kt */
/* loaded from: classes5.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* compiled from: Cookie.kt */
    /* loaded from: classes5.dex */
    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = DatesKt.MAX_DATE;
        private String path = "/";

        public final Cookie build() {
            String str = this.name;
            if (str != null) {
                String str2 = this.value;
                if (str2 != null) {
                    long j8 = this.expiresAt;
                    String str3 = this.domain;
                    if (str3 != null) {
                        return new Cookie(str, str2, j8, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
                    }
                    throw new NullPointerException("builder.domain == null");
                }
                throw new NullPointerException("builder.value == null");
            }
            throw new NullPointerException("builder.name == null");
        }

        public final Builder domain(String domain) {
            Intrinsics.f(domain, "domain");
            return domain(domain, false);
        }

        public final Builder expiresAt(long j8) {
            if (j8 <= 0) {
                j8 = Long.MIN_VALUE;
            }
            if (j8 > DatesKt.MAX_DATE) {
                j8 = 253402300799999L;
            }
            this.expiresAt = j8;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String domain) {
            Intrinsics.f(domain, "domain");
            return domain(domain, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String name) {
            CharSequence Y0;
            Intrinsics.f(name, "name");
            Y0 = StringsKt__StringsKt.Y0(name);
            if (Intrinsics.a(Y0.toString(), name)) {
                this.name = name;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        public final Builder path(String path) {
            boolean L;
            Intrinsics.f(path, "path");
            L = StringsKt__StringsJVMKt.L(path, "/", false, 2, null);
            if (L) {
                this.path = path;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String value) {
            CharSequence Y0;
            Intrinsics.f(value, "value");
            Y0 = StringsKt__StringsKt.Y0(value);
            if (Intrinsics.a(Y0.toString(), value)) {
                this.value = value;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        private final Builder domain(String str, boolean z7) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z7;
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.n("unexpected domain: ", str));
        }
    }

    /* compiled from: Cookie.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x003f, code lost:
            if (r1 != ':') goto L7;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final int dateCharacterOffset(java.lang.String r6, int r7, int r8, boolean r9) {
            /*
                r5 = this;
            L0:
                if (r7 >= r8) goto L49
                int r0 = r7 + 1
                char r1 = r6.charAt(r7)
                r2 = 32
                r3 = 1
                r4 = 0
                if (r1 >= r2) goto L12
                r2 = 9
                if (r1 != r2) goto L41
            L12:
                r2 = 127(0x7f, float:1.78E-43)
                if (r1 >= r2) goto L41
                r2 = 57
                if (r1 > r2) goto L20
                r2 = 48
                if (r2 > r1) goto L20
                r2 = 1
                goto L21
            L20:
                r2 = 0
            L21:
                if (r2 != 0) goto L41
                r2 = 122(0x7a, float:1.71E-43)
                if (r1 > r2) goto L2d
                r2 = 97
                if (r2 > r1) goto L2d
                r2 = 1
                goto L2e
            L2d:
                r2 = 0
            L2e:
                if (r2 != 0) goto L41
                r2 = 90
                if (r1 > r2) goto L3a
                r2 = 65
                if (r2 > r1) goto L3a
                r2 = 1
                goto L3b
            L3a:
                r2 = 0
            L3b:
                if (r2 != 0) goto L41
                r2 = 58
                if (r1 != r2) goto L42
            L41:
                r4 = 1
            L42:
                r1 = r9 ^ 1
                if (r4 != r1) goto L47
                return r7
            L47:
                r7 = r0
                goto L0
            L49:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.dateCharacterOffset(java.lang.String, int, int, boolean):int");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            boolean v7;
            if (Intrinsics.a(str, str2)) {
                return true;
            }
            v7 = StringsKt__StringsJVMKt.v(str, str2, false, 2, null);
            if (v7 && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str)) {
                return true;
            }
            return false;
        }

        private final String parseDomain(String str) {
            boolean v7;
            String s02;
            v7 = StringsKt__StringsJVMKt.v(str, ".", false, 2, null);
            if (!v7) {
                s02 = StringsKt__StringsKt.s0(str, ".");
                String canonicalHost = HostnamesKt.toCanonicalHost(s02);
                if (canonicalHost != null) {
                    return canonicalHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseExpires(String str, int i8, int i9) {
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            int b02;
            int dateCharacterOffset = dateCharacterOffset(str, i8, i9, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            while (dateCharacterOffset < i9) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i9, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i11 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    Intrinsics.e(group, "matcher.group(1)");
                    i11 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    Intrinsics.e(group2, "matcher.group(2)");
                    i14 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    Intrinsics.e(group3, "matcher.group(3)");
                    i15 = Integer.parseInt(group3);
                } else if (i12 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    Intrinsics.e(group4, "matcher.group(1)");
                    i12 = Integer.parseInt(group4);
                } else if (i13 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    Intrinsics.e(group5, "matcher.group(1)");
                    Locale US = Locale.US;
                    Intrinsics.e(US, "US");
                    String lowerCase = group5.toLowerCase(US);
                    Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    Intrinsics.e(pattern, "MONTH_PATTERN.pattern()");
                    b02 = StringsKt__StringsKt.b0(pattern, lowerCase, 0, false, 6, null);
                    i13 = b02 / 4;
                } else if (i10 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    Intrinsics.e(group6, "matcher.group(1)");
                    i10 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i9, false);
            }
            if (70 <= i10 && i10 < 100) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                i10 += 1900;
            }
            if (i10 >= 0 && i10 < 70) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                i10 += CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
            }
            if (i10 >= 1601) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z9) {
                if (i13 != -1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    if (1 <= i12 && i12 < 32) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        if (i11 >= 0 && i11 < 24) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            if (i14 >= 0 && i14 < 60) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            if (z13) {
                                if (i15 >= 0 && i15 < 60) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                if (z14) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i10);
                                    gregorianCalendar.set(2, i13 - 1);
                                    gregorianCalendar.set(5, i12);
                                    gregorianCalendar.set(11, i11);
                                    gregorianCalendar.set(12, i14);
                                    gregorianCalendar.set(13, i15);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseMaxAge(String str) {
            boolean L;
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e8) {
                if (new Regex("-?\\d+").f(str)) {
                    L = StringsKt__StringsJVMKt.L(str, "-", false, 2, null);
                    if (L) {
                        return Long.MIN_VALUE;
                    }
                    return Long.MAX_VALUE;
                }
                throw e8;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            boolean L;
            boolean v7;
            String encodedPath = httpUrl.encodedPath();
            if (Intrinsics.a(encodedPath, str)) {
                return true;
            }
            L = StringsKt__StringsJVMKt.L(encodedPath, str, false, 2, null);
            if (L) {
                v7 = StringsKt__StringsJVMKt.v(str, "/", false, 2, null);
                if (v7 || encodedPath.charAt(str.length()) == '/') {
                    return true;
                }
            }
            return false;
        }

        public final Cookie parse(HttpUrl url, String setCookie) {
            Intrinsics.f(url, "url");
            Intrinsics.f(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x0103, code lost:
            if (r1 > okhttp3.internal.http.DatesKt.MAX_DATE) goto L86;
         */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x015b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okhttp3.Cookie parse$okhttp(long r26, okhttp3.HttpUrl r28, java.lang.String r29) {
            /*
                Method dump skipped, instructions count: 369
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        public final List<Cookie> parseAll(HttpUrl url, Headers headers) {
            List<Cookie> k8;
            Intrinsics.f(url, "url");
            Intrinsics.f(headers, "headers");
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            int i8 = 0;
            while (i8 < size) {
                int i9 = i8 + 1;
                Cookie parse = parse(url, values.get(i8));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
                i8 = i9;
            }
            if (arrayList != null) {
                List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
                Intrinsics.e(unmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
                return unmodifiableList;
            }
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
    }

    private Cookie(String str, String str2, long j8, String str3, String str4, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j8;
        this.domain = str3;
        this.path = str4;
        this.secure = z7;
        this.httpOnly = z8;
        this.persistent = z9;
        this.hostOnly = z10;
    }

    public /* synthetic */ Cookie(String str, String str2, long j8, String str3, String str4, boolean z7, boolean z8, boolean z9, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j8, str3, str4, z7, z8, z9, z10);
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m43deprecated_domain() {
        return this.domain;
    }

    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m44deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m45deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m46deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m47deprecated_name() {
        return this.name;
    }

    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m48deprecated_path() {
        return this.path;
    }

    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m49deprecated_persistent() {
        return this.persistent;
    }

    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m50deprecated_secure() {
        return this.secure;
    }

    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m51deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (Intrinsics.a(cookie.name, this.name) && Intrinsics.a(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.a(cookie.domain, this.domain) && Intrinsics.a(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + a.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + e0.a.a(this.secure)) * 31) + e0.a.a(this.httpOnly)) * 31) + e0.a.a(this.persistent)) * 31) + e0.a.a(this.hostOnly);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl url) {
        boolean domainMatch;
        Intrinsics.f(url, "url");
        if (!this.hostOnly) {
            domainMatch = Companion.domainMatch(url.host(), this.domain);
        } else {
            domainMatch = Intrinsics.a(url.host(), this.domain);
        }
        if (!domainMatch || !Companion.pathMatch(url, this.path)) {
            return false;
        }
        if (this.secure && !url.isHttps()) {
            return false;
        }
        return true;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append('=');
        sb.append(value());
        if (persistent()) {
            if (expiresAt() == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(expiresAt())));
            }
        }
        if (!hostOnly()) {
            sb.append("; domain=");
            if (z7) {
                sb.append(".");
            }
            sb.append(domain());
        }
        sb.append("; path=");
        sb.append(path());
        if (secure()) {
            sb.append("; secure");
        }
        if (httpOnly()) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "toString()");
        return sb2;
    }

    public final String value() {
        return this.value;
    }
}
