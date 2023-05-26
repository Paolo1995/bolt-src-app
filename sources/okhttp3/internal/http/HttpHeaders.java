package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;

/* compiled from: HttpHeaders.kt */
/* loaded from: classes5.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS;
    private static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString.Companion companion = ByteString.f52591i;
        QUOTED_STRING_DELIMITERS = companion.d("\"\\");
        TOKEN_DELIMITERS = companion.d("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        Intrinsics.f(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String headerName) {
        boolean w7;
        Intrinsics.f(headers, "<this>");
        Intrinsics.f(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        int i8 = 0;
        while (i8 < size) {
            int i9 = i8 + 1;
            w7 = StringsKt__StringsJVMKt.w(headerName, headers.name(i8), true);
            if (w7) {
                try {
                    readChallengeHeader(new Buffer().Q(headers.value(i8)), arrayList);
                } catch (EOFException e8) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e8);
                }
            }
            i8 = i9;
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        boolean w7;
        Intrinsics.f(response, "<this>");
        if (Intrinsics.a(response.request().method(), "HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && Util.headersContentLength(response) == -1) {
            w7 = StringsKt__StringsJVMKt.w("chunked", Response.header$default(response, "Transfer-Encoding", null, 2, null), true);
            if (!w7) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0079, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0079, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void readChallengeHeader(okio.Buffer r7, java.util.List<okhttp3.Challenge> r8) throws java.io.EOFException {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            skipCommasAndWhitespace(r7)
            java.lang.String r1 = readToken(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = skipCommasAndWhitespace(r7)
            java.lang.String r3 = readToken(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.y0()
            if (r7 != 0) goto L1f
            return
        L1f:
            okhttp3.Challenge r7 = new okhttp3.Challenge
            java.util.Map r0 = kotlin.collections.MapsKt.f()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            int r5 = okhttp3.internal.Util.skipAll(r7, r4)
            boolean r6 = skipCommasAndWhitespace(r7)
            if (r2 != 0) goto L5c
            if (r6 != 0) goto L40
            boolean r2 = r7.y0()
            if (r2 == 0) goto L5c
        L40:
            okhttp3.Challenge r2 = new okhttp3.Challenge
            java.lang.String r4 = "="
            java.lang.String r4 = kotlin.text.StringsKt.B(r4, r5)
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.n(r3, r4)
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "singletonMap<String, Str…ek + \"=\".repeat(eqCount))"
            kotlin.jvm.internal.Intrinsics.e(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L5c:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = okhttp3.internal.Util.skipAll(r7, r4)
            int r5 = r5 + r6
        L66:
            if (r3 != 0) goto L77
            java.lang.String r3 = readToken(r7)
            boolean r5 = skipCommasAndWhitespace(r7)
            if (r5 == 0) goto L73
            goto L79
        L73:
            int r5 = okhttp3.internal.Util.skipAll(r7, r4)
        L77:
            if (r5 != 0) goto L84
        L79:
            okhttp3.Challenge r4 = new okhttp3.Challenge
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L84:
            r6 = 1
            if (r5 <= r6) goto L88
            return
        L88:
            boolean r6 = skipCommasAndWhitespace(r7)
            if (r6 == 0) goto L8f
            return
        L8f:
            r6 = 34
            boolean r6 = startsWith(r7, r6)
            if (r6 == 0) goto L9c
            java.lang.String r6 = readQuotedString(r7)
            goto La0
        L9c:
            java.lang.String r6 = readToken(r7)
        La0:
            if (r6 != 0) goto La3
            return
        La3:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lac
            return
        Lac:
            boolean r3 = skipCommasAndWhitespace(r7)
            if (r3 != 0) goto Lb9
            boolean r3 = r7.y0()
            if (r3 != 0) goto Lb9
            return
        Lb9:
            r3 = r0
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.readChallengeHeader(okio.Buffer, java.util.List):void");
    }

    private static final String readQuotedString(Buffer buffer) throws EOFException {
        boolean z7;
        if (buffer.readByte() == 34) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            Buffer buffer2 = new Buffer();
            while (true) {
                long G = buffer.G(QUOTED_STRING_DELIMITERS);
                if (G == -1) {
                    return null;
                }
                if (buffer.m(G) == 34) {
                    buffer2.write(buffer, G);
                    buffer.readByte();
                    return buffer2.k0();
                } else if (buffer.size() == G + 1) {
                    return null;
                } else {
                    buffer2.write(buffer, G);
                    buffer.readByte();
                    buffer2.write(buffer, 1L);
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private static final String readToken(Buffer buffer) {
        long G = buffer.G(TOKEN_DELIMITERS);
        if (G == -1) {
            G = buffer.size();
        }
        if (G != 0) {
            return buffer.s0(G);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl url, Headers headers) {
        Intrinsics.f(cookieJar, "<this>");
        Intrinsics.f(url, "url");
        Intrinsics.f(headers, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.Companion.parseAll(url, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(url, parseAll);
    }

    private static final boolean skipCommasAndWhitespace(Buffer buffer) {
        boolean z7;
        boolean z8 = false;
        while (!buffer.y0()) {
            byte m8 = buffer.m(0L);
            if (m8 == 44) {
                buffer.readByte();
                z8 = true;
            } else {
                if (m8 == 32 || m8 == 9) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7) {
                    break;
                }
                buffer.readByte();
            }
        }
        return z8;
    }

    private static final boolean startsWith(Buffer buffer, byte b8) {
        if (!buffer.y0() && buffer.m(0L) == b8) {
            return true;
        }
        return false;
    }
}
