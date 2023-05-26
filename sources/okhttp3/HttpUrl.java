package okhttp3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.SetsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;

/* compiled from: HttpUrl.kt */
/* loaded from: classes5.dex */
public final class HttpUrl {
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* compiled from: HttpUrl.kt */
    /* loaded from: classes5.dex */
    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = "";
        private String encodedPassword = "";
        private int port = -1;

        /* compiled from: HttpUrl.kt */
        /* loaded from: classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String str, int i8, int i9) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i8, i9, "", false, false, false, false, null, 248, null));
                    boolean z7 = false;
                    if (1 <= parseInt && parseInt < 65536) {
                        z7 = true;
                    }
                    if (!z7) {
                        return -1;
                    }
                    return parseInt;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String str, int i8, int i9) {
                while (i8 < i9) {
                    char charAt = str.charAt(i8);
                    if (charAt == '[') {
                        do {
                            i8++;
                            if (i8 < i9) {
                            }
                        } while (str.charAt(i8) != ']');
                    } else if (charAt == ':') {
                        return i8;
                    }
                    i8++;
                }
                return i9;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i8, int i9) {
                boolean z7;
                boolean z8;
                boolean z9;
                boolean z10;
                boolean z11;
                if (i9 - i8 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i8);
                if ((Intrinsics.h(charAt, 97) < 0 || Intrinsics.h(charAt, 122) > 0) && (Intrinsics.h(charAt, 65) < 0 || Intrinsics.h(charAt, 90) > 0)) {
                    return -1;
                }
                int i10 = i8 + 1;
                while (i10 < i9) {
                    int i11 = i10 + 1;
                    char charAt2 = str.charAt(i10);
                    boolean z12 = false;
                    if ('a' <= charAt2 && charAt2 < '{') {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7 || ('A' <= charAt2 && charAt2 < '[')) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8 || ('0' <= charAt2 && charAt2 < ':')) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z9 || charAt2 == '+') {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10 || charAt2 == '-') {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11 || charAt2 == '.') {
                        z12 = true;
                    }
                    if (z12) {
                        i10 = i11;
                    } else if (charAt2 != ':') {
                        return -1;
                    } else {
                        return i10;
                    }
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i8, int i9) {
                int i10 = 0;
                while (i8 < i9) {
                    int i11 = i8 + 1;
                    char charAt = str.charAt(i8);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i10++;
                    i8 = i11;
                }
                return i10;
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i8 = this.port;
            if (i8 == -1) {
                Companion companion = HttpUrl.Companion;
                String str = this.scheme;
                Intrinsics.c(str);
                return companion.defaultPort(str);
            }
            return i8;
        }

        private final boolean isDot(String str) {
            boolean w7;
            if (Intrinsics.a(str, ".")) {
                return true;
            }
            w7 = StringsKt__StringsJVMKt.w(str, "%2e", true);
            if (w7) {
                return true;
            }
            return false;
        }

        private final boolean isDotDot(String str) {
            boolean w7;
            boolean w8;
            boolean w9;
            if (Intrinsics.a(str, "..")) {
                return true;
            }
            w7 = StringsKt__StringsJVMKt.w(str, "%2e.", true);
            if (w7) {
                return true;
            }
            w8 = StringsKt__StringsJVMKt.w(str, ".%2e", true);
            if (w8) {
                return true;
            }
            w9 = StringsKt__StringsJVMKt.w(str, "%2e%2e", true);
            if (w9) {
                return true;
            }
            return false;
        }

        private final void pop() {
            boolean z7;
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && (!this.encodedPathSegments.isEmpty())) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.encodedPathSegments.add("");
        }

        private final void push(String str, int i8, int i9, boolean z7, boolean z8) {
            boolean z9;
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i8, i9, HttpUrl.PATH_SEGMENT_ENCODE_SET, z8, false, false, false, null, 240, null);
            if (isDot(canonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(canonicalize$okhttp$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z9) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, canonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(canonicalize$okhttp$default);
            }
            if (z7) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.c(list);
            int size = list.size() - 2;
            int c8 = ProgressionUtilKt.c(size, 0, -2);
            if (c8 > size) {
                return;
            }
            while (true) {
                int i8 = size - 2;
                List<String> list2 = this.encodedQueryNamesAndValues;
                Intrinsics.c(list2);
                if (Intrinsics.a(str, list2.get(size))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    Intrinsics.c(list3);
                    list3.remove(size + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    Intrinsics.c(list4);
                    list4.remove(size);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    Intrinsics.c(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size != c8) {
                    size = i8;
                } else {
                    return;
                }
            }
        }

        private final void resolvePath(String str, int i8, int i9) {
            boolean z7;
            if (i8 == i9) {
                return;
            }
            char charAt = str.charAt(i8);
            if (charAt != '/' && charAt != '\\') {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            } else {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i8++;
            }
            while (true) {
                int i10 = i8;
                while (i10 < i9) {
                    i8 = Util.delimiterOffset(str, "/\\", i10, i9);
                    if (i8 < i9) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    push(str, i10, i8, z7, true);
                    if (z7) {
                        i10 = i8 + 1;
                    }
                }
                return;
            }
        }

        public final Builder addEncodedPathSegment(String encodedPathSegment) {
            Intrinsics.f(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String encodedPathSegments) {
            Intrinsics.f(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        public final Builder addEncodedQueryParameter(String encodedName, String str) {
            String canonicalize$okhttp$default;
            Intrinsics.f(encodedName, "encodedName");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                setEncodedQueryNamesAndValues$okhttp(new ArrayList());
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.c(encodedQueryNamesAndValues$okhttp);
            Companion companion = HttpUrl.Companion;
            encodedQueryNamesAndValues$okhttp.add(Companion.canonicalize$okhttp$default(companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> encodedQueryNamesAndValues$okhttp2 = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.c(encodedQueryNamesAndValues$okhttp2);
            if (str == null) {
                canonicalize$okhttp$default = null;
            } else {
                canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null);
            }
            encodedQueryNamesAndValues$okhttp2.add(canonicalize$okhttp$default);
            return this;
        }

        public final Builder addPathSegment(String pathSegment) {
            Intrinsics.f(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String pathSegments) {
            Intrinsics.f(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        public final Builder addQueryParameter(String name, String str) {
            String canonicalize$okhttp$default;
            Intrinsics.f(name, "name");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                setEncodedQueryNamesAndValues$okhttp(new ArrayList());
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.c(encodedQueryNamesAndValues$okhttp);
            Companion companion = HttpUrl.Companion;
            encodedQueryNamesAndValues$okhttp.add(Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> encodedQueryNamesAndValues$okhttp2 = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.c(encodedQueryNamesAndValues$okhttp2);
            if (str == null) {
                canonicalize$okhttp$default = null;
            } else {
                canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null);
            }
            encodedQueryNamesAndValues$okhttp2.add(canonicalize$okhttp$default);
            return this;
        }

        public final HttpUrl build() {
            int v7;
            ArrayList arrayList;
            int v8;
            String percentDecode$okhttp$default;
            String percentDecode$okhttp$default2;
            String str = this.scheme;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String percentDecode$okhttp$default3 = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
                String percentDecode$okhttp$default4 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
                String str2 = this.host;
                if (str2 != null) {
                    int effectivePort = effectivePort();
                    List<String> list = this.encodedPathSegments;
                    v7 = CollectionsKt__IterablesKt.v(list, 10);
                    ArrayList arrayList2 = new ArrayList(v7);
                    for (String str3 : list) {
                        arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, false, 7, null));
                    }
                    List<String> list2 = this.encodedQueryNamesAndValues;
                    if (list2 == null) {
                        arrayList = null;
                    } else {
                        v8 = CollectionsKt__IterablesKt.v(list2, 10);
                        arrayList = new ArrayList(v8);
                        for (String str4 : list2) {
                            if (str4 == null) {
                                percentDecode$okhttp$default = null;
                            } else {
                                percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, true, 3, null);
                            }
                            arrayList.add(percentDecode$okhttp$default);
                        }
                    }
                    String str5 = this.encodedFragment;
                    if (str5 == null) {
                        percentDecode$okhttp$default2 = null;
                    } else {
                        percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, str5, 0, 0, false, 7, null);
                    }
                    return new HttpUrl(str, percentDecode$okhttp$default3, percentDecode$okhttp$default4, str2, effectivePort, arrayList2, arrayList, percentDecode$okhttp$default2, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final Builder encodedFragment(String str) {
            String canonicalize$okhttp$default;
            if (str == null) {
                canonicalize$okhttp$default = null;
            } else {
                canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, 179, null);
            }
            setEncodedFragment$okhttp(canonicalize$okhttp$default);
            return this;
        }

        public final Builder encodedPassword(String encodedPassword) {
            Intrinsics.f(encodedPassword, "encodedPassword");
            setEncodedPassword$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null));
            return this;
        }

        public final Builder encodedPath(String encodedPath) {
            boolean L;
            Intrinsics.f(encodedPath, "encodedPath");
            L = StringsKt__StringsJVMKt.L(encodedPath, "/", false, 2, null);
            if (L) {
                resolvePath(encodedPath, 0, encodedPath.length());
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.n("unexpected encodedPath: ", encodedPath).toString());
        }

        public final Builder encodedQuery(String str) {
            List<String> list = null;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                }
            }
            setEncodedQueryNamesAndValues$okhttp(list);
            return this;
        }

        public final Builder encodedUsername(String encodedUsername) {
            Intrinsics.f(encodedUsername, "encodedUsername");
            setEncodedUsername$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null));
            return this;
        }

        public final Builder fragment(String str) {
            String canonicalize$okhttp$default;
            if (str == null) {
                canonicalize$okhttp$default = null;
            } else {
                canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, 187, null);
            }
            setEncodedFragment$okhttp(canonicalize$okhttp$default);
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String host) {
            Intrinsics.f(host, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, host, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                setHost$okhttp(canonicalHost);
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.n("unexpected host: ", host));
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            String f12;
            int delimiterOffset;
            char c8;
            int i8;
            int i9;
            String str2;
            boolean z7;
            boolean z8;
            int i10;
            String str3;
            int i11;
            boolean z9;
            boolean I;
            boolean I2;
            String input = str;
            Intrinsics.f(input, "input");
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(input, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(input, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            int schemeDelimiterOffset = companion.schemeDelimiterOffset(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            String str4 = "this as java.lang.String…ing(startIndex, endIndex)";
            char c9 = 65535;
            if (schemeDelimiterOffset != -1) {
                I = StringsKt__StringsJVMKt.I(input, "https:", indexOfFirstNonAsciiWhitespace$default, true);
                if (I) {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    I2 = StringsKt__StringsJVMKt.I(input, "http:", indexOfFirstNonAsciiWhitespace$default, true);
                    if (I2) {
                        this.scheme = "http";
                        indexOfFirstNonAsciiWhitespace$default += 5;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String substring = input.substring(0, schemeDelimiterOffset);
                        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(substring);
                        sb.append('\'');
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme();
            } else {
                if (str.length() > 6) {
                    f12 = StringsKt___StringsKt.f1(input, 6);
                    input = Intrinsics.n(f12, "...");
                }
                throw new IllegalArgumentException(Intrinsics.n("Expected URL scheme 'http' or 'https' but no scheme was found for ", input));
            }
            int slashCount = companion.slashCount(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c10 = '?';
            char c11 = '#';
            if (slashCount < 2 && httpUrl != null && Intrinsics.a(httpUrl.scheme(), this.scheme)) {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || input.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i8 = indexOfLastNonAsciiWhitespace$default;
            } else {
                int i12 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                boolean z10 = false;
                boolean z11 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(input, "@/\\?#", i12, indexOfLastNonAsciiWhitespace$default);
                    if (delimiterOffset != indexOfLastNonAsciiWhitespace$default) {
                        c8 = input.charAt(delimiterOffset);
                    } else {
                        c8 = 65535;
                    }
                    if (c8 == c9 || c8 == c11 || c8 == '/' || c8 == '\\' || c8 == c10) {
                        break;
                    } else if (c8 == '@') {
                        if (!z10) {
                            int delimiterOffset2 = Util.delimiterOffset(input, ':', i12, delimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            i10 = indexOfLastNonAsciiWhitespace$default;
                            String str5 = str4;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, str, i12, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z11) {
                                canonicalize$okhttp$default = this.encodedUsername + "%40" + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, str, delimiterOffset2 + 1, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z9 = true;
                            } else {
                                z9 = z10;
                            }
                            z10 = z9;
                            str3 = str5;
                            z11 = true;
                            i11 = delimiterOffset;
                        } else {
                            i10 = indexOfLastNonAsciiWhitespace$default;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            str3 = str4;
                            i11 = delimiterOffset;
                            sb2.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i12, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb2.toString();
                        }
                        i12 = i11 + 1;
                        str4 = str3;
                        indexOfLastNonAsciiWhitespace$default = i10;
                        c11 = '#';
                        c10 = '?';
                        c9 = 65535;
                    }
                }
                String str6 = str4;
                i8 = indexOfLastNonAsciiWhitespace$default;
                Companion companion3 = Companion;
                int portColonOffset = companion3.portColonOffset(input, i12, delimiterOffset);
                int i13 = portColonOffset + 1;
                if (i13 < delimiterOffset) {
                    i9 = i12;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, i12, portColonOffset, false, 4, null));
                    int parsePort = companion3.parsePort(input, i13, delimiterOffset);
                    this.port = parsePort;
                    if (parsePort != -1) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        str2 = str6;
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String substring2 = input.substring(i13, delimiterOffset);
                        Intrinsics.e(substring2, str6);
                        sb3.append(substring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                } else {
                    i9 = i12;
                    str2 = str6;
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, str, i9, portColonOffset, false, 4, null));
                    String str7 = this.scheme;
                    Intrinsics.c(str7);
                    this.port = companion4.defaultPort(str7);
                }
                if (this.host != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String substring3 = input.substring(i9, portColonOffset);
                    Intrinsics.e(substring3, str2);
                    sb4.append(substring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
            }
            int i14 = i8;
            int delimiterOffset3 = Util.delimiterOffset(input, "?#", indexOfFirstNonAsciiWhitespace$default, i14);
            resolvePath(input, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i14 && input.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(input, '#', delimiterOffset3, i14);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, str, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i14 && input.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, delimiterOffset3 + 1, i14, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final Builder password(String password) {
            Intrinsics.f(password, "password");
            setEncodedPassword$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        public final Builder port(int i8) {
            boolean z7 = false;
            if (1 <= i8 && i8 < 65536) {
                z7 = true;
            }
            if (z7) {
                setPort$okhttp(i8);
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.n("unexpected port: ", Integer.valueOf(i8)).toString());
        }

        public final Builder query(String str) {
            List<String> list = null;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                }
            }
            setEncodedQueryNamesAndValues$okhttp(list);
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String g8;
            String canonicalize$okhttp$default;
            String host$okhttp = getHost$okhttp();
            String str = null;
            if (host$okhttp == null) {
                g8 = null;
            } else {
                g8 = new Regex("[\"<>^`{|}]").g(host$okhttp, "");
            }
            setHost$okhttp(g8);
            int size = getEncodedPathSegments$okhttp().size();
            int i8 = 0;
            for (int i9 = 0; i9 < size; i9++) {
                getEncodedPathSegments$okhttp().set(i9, Companion.canonicalize$okhttp$default(HttpUrl.Companion, getEncodedPathSegments$okhttp().get(i9), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            if (encodedQueryNamesAndValues$okhttp != null) {
                int size2 = encodedQueryNamesAndValues$okhttp.size();
                while (i8 < size2) {
                    int i10 = i8 + 1;
                    String str2 = encodedQueryNamesAndValues$okhttp.get(i8);
                    if (str2 == null) {
                        canonicalize$okhttp$default = null;
                    } else {
                        canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null);
                    }
                    encodedQueryNamesAndValues$okhttp.set(i8, canonicalize$okhttp$default);
                    i8 = i10;
                }
            }
            String encodedFragment$okhttp = getEncodedFragment$okhttp();
            if (encodedFragment$okhttp != null) {
                str = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedFragment$okhttp, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null);
            }
            setEncodedFragment$okhttp(str);
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String encodedName) {
            Intrinsics.f(encodedName, "encodedName");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String name) {
            Intrinsics.f(name, "name");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        public final Builder removePathSegment(int i8) {
            getEncodedPathSegments$okhttp().remove(i8);
            if (getEncodedPathSegments$okhttp().isEmpty()) {
                getEncodedPathSegments$okhttp().add("");
            }
            return this;
        }

        public final Builder scheme(String scheme) {
            boolean w7;
            boolean w8;
            Intrinsics.f(scheme, "scheme");
            w7 = StringsKt__StringsJVMKt.w(scheme, "http", true);
            if (w7) {
                setScheme$okhttp("http");
            } else {
                w8 = StringsKt__StringsJVMKt.w(scheme, "https", true);
                if (w8) {
                    setScheme$okhttp("https");
                } else {
                    throw new IllegalArgumentException(Intrinsics.n("unexpected scheme: ", scheme));
                }
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            Intrinsics.f(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i8, String encodedPathSegment) {
            boolean z7;
            Intrinsics.f(encodedPathSegment, "encodedPathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            getEncodedPathSegments$okhttp().set(i8, canonicalize$okhttp$default);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.n("unexpected path segment: ", encodedPathSegment).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String encodedName, String str) {
            Intrinsics.f(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, str);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            Intrinsics.f(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i8, String pathSegment) {
            boolean z7;
            Intrinsics.f(pathSegment, "pathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, pathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                getEncodedPathSegments$okhttp().set(i8, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.n("unexpected path segment: ", pathSegment).toString());
        }

        public final void setPort$okhttp(int i8) {
            this.port = i8;
        }

        public final Builder setQueryParameter(String name, String str) {
            Intrinsics.f(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, str);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
            if (r1 != false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00b5, code lost:
            if (r1 != r2.defaultPort(r3)) goto L36;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.getScheme$okhttp()
                if (r1 == 0) goto L18
                java.lang.String r1 = r6.getScheme$okhttp()
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L1d
            L18:
                java.lang.String r1 = "//"
                r0.append(r1)
            L1d:
                java.lang.String r1 = r6.getEncodedUsername$okhttp()
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L2b
                r1 = 1
                goto L2c
            L2b:
                r1 = 0
            L2c:
                r4 = 58
                if (r1 != 0) goto L3f
                java.lang.String r1 = r6.getEncodedPassword$okhttp()
                int r1 = r1.length()
                if (r1 <= 0) goto L3c
                r1 = 1
                goto L3d
            L3c:
                r1 = 0
            L3d:
                if (r1 == 0) goto L63
            L3f:
                java.lang.String r1 = r6.getEncodedUsername$okhttp()
                r0.append(r1)
                java.lang.String r1 = r6.getEncodedPassword$okhttp()
                int r1 = r1.length()
                if (r1 <= 0) goto L51
                goto L52
            L51:
                r2 = 0
            L52:
                if (r2 == 0) goto L5e
                r0.append(r4)
                java.lang.String r1 = r6.getEncodedPassword$okhttp()
                r0.append(r1)
            L5e:
                r1 = 64
                r0.append(r1)
            L63:
                java.lang.String r1 = r6.getHost$okhttp()
                if (r1 == 0) goto L91
                java.lang.String r1 = r6.getHost$okhttp()
                kotlin.jvm.internal.Intrinsics.c(r1)
                r2 = 2
                r5 = 0
                boolean r1 = kotlin.text.StringsKt.P(r1, r4, r3, r2, r5)
                if (r1 == 0) goto L8a
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.getHost$okhttp()
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L91
            L8a:
                java.lang.String r1 = r6.getHost$okhttp()
                r0.append(r1)
            L91:
                int r1 = r6.getPort$okhttp()
                r2 = -1
                if (r1 != r2) goto L9e
                java.lang.String r1 = r6.getScheme$okhttp()
                if (r1 == 0) goto Lbd
            L9e:
                int r1 = r6.effectivePort()
                java.lang.String r2 = r6.getScheme$okhttp()
                if (r2 == 0) goto Lb7
                okhttp3.HttpUrl$Companion r2 = okhttp3.HttpUrl.Companion
                java.lang.String r3 = r6.getScheme$okhttp()
                kotlin.jvm.internal.Intrinsics.c(r3)
                int r2 = r2.defaultPort(r3)
                if (r1 == r2) goto Lbd
            Lb7:
                r0.append(r4)
                r0.append(r1)
            Lbd:
                okhttp3.HttpUrl$Companion r1 = okhttp3.HttpUrl.Companion
                java.util.List r2 = r6.getEncodedPathSegments$okhttp()
                r1.toPathString$okhttp(r2, r0)
                java.util.List r2 = r6.getEncodedQueryNamesAndValues$okhttp()
                if (r2 == 0) goto Ldb
                r2 = 63
                r0.append(r2)
                java.util.List r2 = r6.getEncodedQueryNamesAndValues$okhttp()
                kotlin.jvm.internal.Intrinsics.c(r2)
                r1.toQueryString$okhttp(r2, r0)
            Ldb:
                java.lang.String r1 = r6.getEncodedFragment$okhttp()
                if (r1 == 0) goto Led
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.getEncodedFragment$okhttp()
                r0.append(r1)
            Led:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.Intrinsics.e(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        public final Builder username(String username) {
            Intrinsics.f(username, "username");
            setEncodedUsername$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        private final Builder addPathSegments(String str, boolean z7) {
            int i8 = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i8, str.length());
                push(str, i8, delimiterOffset, delimiterOffset < str.length(), z7);
                i8 = delimiterOffset + 1;
            } while (i8 <= str.length());
            return this;
        }
    }

    /* compiled from: HttpUrl.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i8, int i9, String str2, boolean z7, boolean z8, boolean z9, boolean z10, Charset charset, int i10, Object obj) {
            int i11;
            int i12;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            Charset charset2;
            if ((i10 & 1) != 0) {
                i11 = 0;
            } else {
                i11 = i8;
            }
            if ((i10 & 2) != 0) {
                i12 = str.length();
            } else {
                i12 = i9;
            }
            if ((i10 & 8) != 0) {
                z11 = false;
            } else {
                z11 = z7;
            }
            if ((i10 & 16) != 0) {
                z12 = false;
            } else {
                z12 = z8;
            }
            if ((i10 & 32) != 0) {
                z13 = false;
            } else {
                z13 = z9;
            }
            if ((i10 & 64) != 0) {
                z14 = false;
            } else {
                z14 = z10;
            }
            if ((i10 & 128) != 0) {
                charset2 = null;
            } else {
                charset2 = charset;
            }
            return companion.canonicalize$okhttp(str, i11, i12, str2, z11, z12, z13, z14, charset2);
        }

        private final boolean isPercentEncoded(String str, int i8, int i9) {
            int i10 = i8 + 2;
            if (i10 < i9 && str.charAt(i8) == '%' && Util.parseHexDigit(str.charAt(i8 + 1)) != -1 && Util.parseHexDigit(str.charAt(i10)) != -1) {
                return true;
            }
            return false;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i8, int i9, boolean z7, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                i8 = 0;
            }
            if ((i10 & 2) != 0) {
                i9 = str.length();
            }
            if ((i10 & 4) != 0) {
                z7 = false;
            }
            return companion.percentDecode$okhttp(str, i8, i9, z7);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x005f, code lost:
            if (isPercentEncoded(r16, r5, r18) == false) goto L39;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void writeCanonicalized(okio.Buffer r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            Lb:
                if (r5 >= r2) goto Lb9
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L28
                r8 = 9
                if (r7 == r8) goto L23
                r8 = 10
                if (r7 == r8) goto L23
                r8 = 12
                if (r7 == r8) goto L23
                r8 = 13
                if (r7 != r8) goto L28
            L23:
                r8 = r14
                r12 = r19
                goto Lb2
            L28:
                r8 = 43
                if (r7 != r8) goto L39
                if (r22 == 0) goto L39
                if (r20 == 0) goto L33
                java.lang.String r8 = "+"
                goto L35
            L33:
                java.lang.String r8 = "%2B"
            L35:
                r15.Q(r8)
                goto L23
            L39:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L69
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L69
                r8 = 128(0x80, float:1.8E-43)
                if (r7 < r8) goto L49
                if (r23 == 0) goto L69
            L49:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.text.StringsKt.P(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L67
                if (r7 != r9) goto L62
                if (r20 == 0) goto L67
                if (r21 == 0) goto L62
                r8 = r14
                boolean r10 = r14.isPercentEncoded(r1, r5, r2)
                if (r10 != 0) goto L63
                goto L6c
            L62:
                r8 = r14
            L63:
                r15.o1(r7)
                goto Lb2
            L67:
                r8 = r14
                goto L6c
            L69:
                r8 = r14
                r12 = r19
            L6c:
                if (r6 != 0) goto L73
                okio.Buffer r6 = new okio.Buffer
                r6.<init>()
            L73:
                if (r3 == 0) goto L87
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = kotlin.jvm.internal.Intrinsics.a(r3, r10)
                if (r10 == 0) goto L7e
                goto L87
            L7e:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.h1(r1, r5, r10, r3)
                goto L8a
            L87:
                r6.o1(r7)
            L8a:
                boolean r10 = r6.y0()
                if (r10 != 0) goto Lb2
                byte r10 = r6.readByte()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte(r9)
                char[] r11 = okhttp3.HttpUrl.access$getHEX_DIGITS$cp()
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.writeByte(r11)
                char[] r11 = okhttp3.HttpUrl.access$getHEX_DIGITS$cp()
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte(r10)
                goto L8a
            Lb2:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto Lb
            Lb9:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.writeCanonicalized(okio.Buffer, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void writePercentDecoded(Buffer buffer, String str, int i8, int i9, boolean z7) {
            int i10;
            while (i8 < i9) {
                int codePointAt = str.codePointAt(i8);
                if (codePointAt == 37 && (i10 = i8 + 2) < i9) {
                    int parseHexDigit = Util.parseHexDigit(str.charAt(i8 + 1));
                    int parseHexDigit2 = Util.parseHexDigit(str.charAt(i10));
                    if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                        buffer.writeByte((parseHexDigit << 4) + parseHexDigit2);
                        i8 = Character.charCount(codePointAt) + i10;
                    }
                    buffer.o1(codePointAt);
                    i8 += Character.charCount(codePointAt);
                } else {
                    if (codePointAt == 43 && z7) {
                        buffer.writeByte(32);
                        i8++;
                    }
                    buffer.o1(codePointAt);
                    i8 += Character.charCount(codePointAt);
                }
            }
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m83deprecated_get(String url) {
            Intrinsics.f(url, "url");
            return get(url);
        }

        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final HttpUrl m86deprecated_parse(String url) {
            Intrinsics.f(url, "url");
            return parse(url);
        }

        public final String canonicalize$okhttp(String str, int i8, int i9, String encodeSet, boolean z7, boolean z8, boolean z9, boolean z10, Charset charset) {
            boolean P;
            Intrinsics.f(str, "<this>");
            Intrinsics.f(encodeSet, "encodeSet");
            int i10 = i8;
            while (i10 < i9) {
                int codePointAt = str.codePointAt(i10);
                if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z10)) {
                    P = StringsKt__StringsKt.P(encodeSet, (char) codePointAt, false, 2, null);
                    if (!P) {
                        if (codePointAt == 37) {
                            if (z7) {
                                if (z8) {
                                    if (!isPercentEncoded(str, i10, i9)) {
                                        Buffer buffer = new Buffer();
                                        buffer.U(str, i8, i10);
                                        writeCanonicalized(buffer, str, i10, i9, encodeSet, z7, z8, z9, z10, charset);
                                        return buffer.k0();
                                    }
                                    if (codePointAt == 43 || !z9) {
                                        i10 += Character.charCount(codePointAt);
                                    } else {
                                        Buffer buffer2 = new Buffer();
                                        buffer2.U(str, i8, i10);
                                        writeCanonicalized(buffer2, str, i10, i9, encodeSet, z7, z8, z9, z10, charset);
                                        return buffer2.k0();
                                    }
                                }
                            }
                        }
                        if (codePointAt == 43) {
                        }
                        i10 += Character.charCount(codePointAt);
                    }
                }
                Buffer buffer22 = new Buffer();
                buffer22.U(str, i8, i10);
                writeCanonicalized(buffer22, str, i10, i9, encodeSet, z7, z8, z9, z10, charset);
                return buffer22.k0();
            }
            String substring = str.substring(i8, i9);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final int defaultPort(String scheme) {
            Intrinsics.f(scheme, "scheme");
            if (Intrinsics.a(scheme, "http")) {
                return 80;
            }
            if (Intrinsics.a(scheme, "https")) {
                return 443;
            }
            return -1;
        }

        public final HttpUrl get(String str) {
            Intrinsics.f(str, "<this>");
            return new Builder().parse$okhttp(null, str).build();
        }

        public final HttpUrl parse(String str) {
            Intrinsics.f(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String str, int i8, int i9, boolean z7) {
            Intrinsics.f(str, "<this>");
            int i10 = i8;
            while (i10 < i9) {
                int i11 = i10 + 1;
                char charAt = str.charAt(i10);
                if (charAt != '%' && (charAt != '+' || !z7)) {
                    i10 = i11;
                } else {
                    Buffer buffer = new Buffer();
                    buffer.U(str, i8, i10);
                    writePercentDecoded(buffer, str, i10, i9, z7);
                    return buffer.k0();
                }
            }
            String substring = str.substring(i8, i9);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(List<String> list, StringBuilder out) {
            Intrinsics.f(list, "<this>");
            Intrinsics.f(out, "out");
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                out.append('/');
                out.append(list.get(i8));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String str) {
            int a02;
            int a03;
            Intrinsics.f(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i8 = 0;
            while (i8 <= str.length()) {
                a02 = StringsKt__StringsKt.a0(str, '&', i8, false, 4, null);
                if (a02 == -1) {
                    a02 = str.length();
                }
                int i9 = a02;
                a03 = StringsKt__StringsKt.a0(str, '=', i8, false, 4, null);
                if (a03 != -1 && a03 <= i9) {
                    String substring = str.substring(i8, a03);
                    Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    String substring2 = str.substring(a03 + 1, i9);
                    Intrinsics.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                } else {
                    String substring3 = str.substring(i8, i9);
                    Intrinsics.e(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                    arrayList.add(null);
                }
                i8 = i9 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> list, StringBuilder out) {
            Intrinsics.f(list, "<this>");
            Intrinsics.f(out, "out");
            IntProgression n8 = RangesKt.n(RangesKt.o(0, list.size()), 2);
            int g8 = n8.g();
            int i8 = n8.i();
            int k8 = n8.k();
            if ((k8 <= 0 || g8 > i8) && (k8 >= 0 || i8 > g8)) {
                return;
            }
            while (true) {
                int i9 = g8 + k8;
                String str = list.get(g8);
                String str2 = list.get(g8 + 1);
                if (g8 > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (g8 != i8) {
                    g8 = i9;
                } else {
                    return;
                }
            }
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m85deprecated_get(URL url) {
            Intrinsics.f(url, "url");
            return get(url);
        }

        public final HttpUrl get(URL url) {
            Intrinsics.f(url, "<this>");
            String url2 = url.toString();
            Intrinsics.e(url2, "toString()");
            return parse(url2);
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m84deprecated_get(URI uri) {
            Intrinsics.f(uri, "uri");
            return get(uri);
        }

        public final HttpUrl get(URI uri) {
            Intrinsics.f(uri, "<this>");
            String uri2 = uri.toString();
            Intrinsics.e(uri2, "toString()");
            return parse(uri2);
        }
    }

    public HttpUrl(String scheme, String username, String password, String host, int i8, List<String> pathSegments, List<String> list, String str, String url) {
        Intrinsics.f(scheme, "scheme");
        Intrinsics.f(username, "username");
        Intrinsics.f(password, "password");
        Intrinsics.f(host, "host");
        Intrinsics.f(pathSegments, "pathSegments");
        Intrinsics.f(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i8;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = Intrinsics.a(scheme, "https");
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_encodedFragment  reason: not valid java name */
    public final String m64deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* renamed from: -deprecated_encodedPassword  reason: not valid java name */
    public final String m65deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* renamed from: -deprecated_encodedPath  reason: not valid java name */
    public final String m66deprecated_encodedPath() {
        return encodedPath();
    }

    /* renamed from: -deprecated_encodedPathSegments  reason: not valid java name */
    public final List<String> m67deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* renamed from: -deprecated_encodedQuery  reason: not valid java name */
    public final String m68deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* renamed from: -deprecated_encodedUsername  reason: not valid java name */
    public final String m69deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* renamed from: -deprecated_fragment  reason: not valid java name */
    public final String m70deprecated_fragment() {
        return this.fragment;
    }

    /* renamed from: -deprecated_host  reason: not valid java name */
    public final String m71deprecated_host() {
        return this.host;
    }

    /* renamed from: -deprecated_password  reason: not valid java name */
    public final String m72deprecated_password() {
        return this.password;
    }

    /* renamed from: -deprecated_pathSegments  reason: not valid java name */
    public final List<String> m73deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* renamed from: -deprecated_pathSize  reason: not valid java name */
    public final int m74deprecated_pathSize() {
        return pathSize();
    }

    /* renamed from: -deprecated_port  reason: not valid java name */
    public final int m75deprecated_port() {
        return this.port;
    }

    /* renamed from: -deprecated_query  reason: not valid java name */
    public final String m76deprecated_query() {
        return query();
    }

    /* renamed from: -deprecated_queryParameterNames  reason: not valid java name */
    public final Set<String> m77deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* renamed from: -deprecated_querySize  reason: not valid java name */
    public final int m78deprecated_querySize() {
        return querySize();
    }

    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m79deprecated_scheme() {
        return this.scheme;
    }

    /* renamed from: -deprecated_uri  reason: not valid java name */
    public final URI m80deprecated_uri() {
        return uri();
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final URL m81deprecated_url() {
        return url();
    }

    /* renamed from: -deprecated_username  reason: not valid java name */
    public final String m82deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        int a02;
        if (this.fragment == null) {
            return null;
        }
        a02 = StringsKt__StringsKt.a0(this.url, '#', 0, false, 6, null);
        String substring = this.url.substring(a02 + 1);
        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String encodedPassword() {
        boolean z7;
        int a02;
        int a03;
        if (this.password.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return "";
        }
        a02 = StringsKt__StringsKt.a0(this.url, ':', this.scheme.length() + 3, false, 4, null);
        a03 = StringsKt__StringsKt.a0(this.url, '@', 0, false, 6, null);
        String substring = this.url.substring(a02 + 1, a03);
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedPath() {
        int a02;
        a02 = StringsKt__StringsKt.a0(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        String substring = this.url.substring(a02, Util.delimiterOffset(str, "?#", a02, str.length()));
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final List<String> encodedPathSegments() {
        int a02;
        a02 = StringsKt__StringsKt.a0(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", a02, str.length());
        ArrayList arrayList = new ArrayList();
        while (a02 < delimiterOffset) {
            int i8 = a02 + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, '/', i8, delimiterOffset);
            String substring = this.url.substring(i8, delimiterOffset2);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
            a02 = delimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        int a02;
        if (this.queryNamesAndValues == null) {
            return null;
        }
        a02 = StringsKt__StringsKt.a0(this.url, '?', 0, false, 6, null);
        int i8 = a02 + 1;
        String str = this.url;
        String substring = this.url.substring(i8, Util.delimiterOffset(str, '#', i8, str.length()));
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedUsername() {
        boolean z7;
        if (this.username.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String substring = this.url.substring(length, Util.delimiterOffset(str, ":@", length, str.length()));
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof HttpUrl) && Intrinsics.a(((HttpUrl) obj).url, this.url)) {
            return true;
        }
        return false;
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String queryParameter(String name) {
        Intrinsics.f(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        IntProgression n8 = RangesKt.n(RangesKt.o(0, list.size()), 2);
        int g8 = n8.g();
        int i8 = n8.i();
        int k8 = n8.k();
        if ((k8 > 0 && g8 <= i8) || (k8 < 0 && i8 <= g8)) {
            while (true) {
                int i9 = g8 + k8;
                if (Intrinsics.a(name, this.queryNamesAndValues.get(g8))) {
                    return this.queryNamesAndValues.get(g8 + 1);
                }
                if (g8 == i8) {
                    break;
                }
                g8 = i9;
            }
        }
        return null;
    }

    public final String queryParameterName(int i8) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            String str = list.get(i8 * 2);
            Intrinsics.c(str);
            return str;
        }
        throw new IndexOutOfBoundsException();
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return SetsKt.b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        IntProgression n8 = RangesKt.n(RangesKt.o(0, this.queryNamesAndValues.size()), 2);
        int g8 = n8.g();
        int i8 = n8.i();
        int k8 = n8.k();
        if ((k8 > 0 && g8 <= i8) || (k8 < 0 && i8 <= g8)) {
            while (true) {
                int i9 = g8 + k8;
                String str = this.queryNamesAndValues.get(g8);
                Intrinsics.c(str);
                linkedHashSet.add(str);
                if (g8 == i8) {
                    break;
                }
                g8 = i9;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        Intrinsics.e(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final String queryParameterValue(int i8) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i8 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String name) {
        List<String> k8;
        Intrinsics.f(name, "name");
        if (this.queryNamesAndValues == null) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        ArrayList arrayList = new ArrayList();
        IntProgression n8 = RangesKt.n(RangesKt.o(0, this.queryNamesAndValues.size()), 2);
        int g8 = n8.g();
        int i8 = n8.i();
        int k9 = n8.k();
        if ((k9 > 0 && g8 <= i8) || (k9 < 0 && i8 <= g8)) {
            while (true) {
                int i9 = g8 + k9;
                if (Intrinsics.a(name, this.queryNamesAndValues.get(g8))) {
                    arrayList.add(this.queryNamesAndValues.get(g8 + 1));
                }
                if (g8 == i8) {
                    break;
                }
                g8 = i9;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.e(unmodifiableList, "unmodifiableList(result)");
        return unmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        Intrinsics.c(newBuilder);
        return newBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String link) {
        Intrinsics.f(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder == null) {
            return null;
        }
        return newBuilder.build();
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e8) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").g(builder, ""));
                Intrinsics.e(create, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e8);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e8) {
            throw new RuntimeException(e8);
        }
    }

    public final String username() {
        return this.username;
    }

    public final Builder newBuilder(String link) {
        Intrinsics.f(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
