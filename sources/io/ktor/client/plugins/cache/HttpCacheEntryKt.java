package io.ktor.client.plugins.cache;

import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCacheEntry.kt */
/* loaded from: classes5.dex */
public final class HttpCacheEntryKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(io.ktor.client.statement.HttpResponse r8, kotlin.coroutines.Continuation<? super io.ktor.client.plugins.cache.HttpCacheEntry> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = (io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1) r0
            int r1 = r0.f46446h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46446h = r1
            goto L18
        L13:
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = new io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1
            r0.<init>(r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.f46445g
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r1 = r4.f46446h
            r7 = 1
            if (r1 == 0) goto L36
            if (r1 != r7) goto L2e
            java.lang.Object r8 = r4.f46444f
            io.ktor.client.statement.HttpResponse r8 = (io.ktor.client.statement.HttpResponse) r8
            kotlin.ResultKt.b(r9)
            goto L4c
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.b(r9)
            io.ktor.utils.io.ByteReadChannel r1 = r8.a()
            r2 = 0
            r5 = 1
            r6 = 0
            r4.f46444f = r8
            r4.f46446h = r7
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.a(r1, r2, r4, r5, r6)
            if (r9 != r0) goto L4c
            return r0
        L4c:
            io.ktor.utils.io.core.ByteReadPacket r9 = (io.ktor.utils.io.core.ByteReadPacket) r9
            r0 = 0
            r1 = 0
            byte[] r9 = io.ktor.utils.io.core.StringsKt.c(r9, r0, r7, r1)
            io.ktor.client.statement.HttpResponseKt.c(r8)
            io.ktor.client.plugins.cache.HttpCacheEntry r0 = new io.ktor.client.plugins.cache.HttpCacheEntry
            io.ktor.util.date.GMTDate r1 = c(r8, r1, r7, r1)
            java.util.Map r2 = e(r8)
            r0.<init>(r1, r2, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.a(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        r0 = kotlin.text.StringsKt__StringsKt.C0(r4, new java.lang.String[]{"="}, false, 0, 6, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final io.ktor.util.date.GMTDate b(io.ktor.client.statement.HttpResponse r10, kotlin.jvm.functions.Function0<io.ktor.util.date.GMTDate> r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            java.lang.String r0 = "fallback"
            kotlin.jvm.internal.Intrinsics.f(r11, r0)
            java.util.List r0 = io.ktor.http.HttpMessagePropertiesKt.a(r10)
            io.ktor.client.plugins.cache.CacheControl r1 = io.ktor.client.plugins.cache.CacheControl.f46413a
            io.ktor.http.HeaderValue r1 = r1.e()
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L1d
            java.lang.String r1 = "s-max-age"
            goto L1f
        L1d:
            java.lang.String r1 = "max-age"
        L1f:
            java.util.Iterator r0 = r0.iterator()
        L23:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L3e
            java.lang.Object r2 = r0.next()
            r4 = r2
            io.ktor.http.HeaderValue r4 = (io.ktor.http.HeaderValue) r4
            java.lang.String r4 = r4.d()
            r5 = 0
            r6 = 2
            boolean r4 = kotlin.text.StringsKt.L(r4, r1, r5, r6, r3)
            if (r4 == 0) goto L23
            goto L3f
        L3e:
            r2 = r3
        L3f:
            io.ktor.http.HeaderValue r2 = (io.ktor.http.HeaderValue) r2
            if (r2 == 0) goto L6a
            java.lang.String r4 = r2.d()
            if (r4 == 0) goto L6a
            java.lang.String r0 = "="
            java.lang.String[] r5 = new java.lang.String[]{r0}
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            java.util.List r0 = kotlin.text.StringsKt.C0(r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L6a
            r1 = 1
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L6a
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
        L6a:
            if (r3 == 0) goto L86
            io.ktor.client.call.HttpClientCall r10 = r10.Y()
            io.ktor.client.statement.HttpResponse r10 = r10.f()
            io.ktor.util.date.GMTDate r10 = r10.b()
            int r11 = r3.intValue()
            long r0 = (long) r11
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            io.ktor.util.date.GMTDate r10 = io.ktor.util.date.DateKt.a(r10, r0)
            return r10
        L86:
            io.ktor.http.Headers r10 = r10.getHeaders()
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.f46782a
            java.lang.String r0 = r0.l()
            java.lang.String r10 = r10.get(r0)
            if (r10 == 0) goto Lb8
            java.lang.String r0 = "0"
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r10, r0)
            if (r0 != 0) goto Lb1
            boolean r0 = kotlin.text.StringsKt.y(r10)
            if (r0 == 0) goto La5
            goto Lb1
        La5:
            io.ktor.util.date.GMTDate r10 = io.ktor.http.DateUtilsKt.a(r10)     // Catch: java.lang.Throwable -> Laa
            goto Lb0
        Laa:
            java.lang.Object r10 = r11.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
        Lb0:
            return r10
        Lb1:
            java.lang.Object r10 = r11.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
            return r10
        Lb8:
            java.lang.Object r10 = r11.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.b(io.ktor.client.statement.HttpResponse, kotlin.jvm.functions.Function0):io.ktor.util.date.GMTDate");
    }

    public static /* synthetic */ GMTDate c(HttpResponse httpResponse, Function0 function0, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function0 = new Function0<GMTDate>() { // from class: io.ktor.client.plugins.cache.HttpCacheEntryKt$cacheExpires$1
                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final GMTDate invoke() {
                    return DateJvmKt.c(null, 1, null);
                }
            };
        }
        return b(httpResponse, function0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
        r0 = kotlin.text.StringsKt__StringsKt.C0(r5, new java.lang.String[]{"="}, false, 0, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fe, code lost:
        r11 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final io.ktor.client.plugins.cache.ValidateStatus d(io.ktor.util.date.GMTDate r11, io.ktor.http.Headers r12, io.ktor.http.HeadersBuilder r13) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.d(io.ktor.util.date.GMTDate, io.ktor.http.Headers, io.ktor.http.HeadersBuilder):io.ktor.client.plugins.cache.ValidateStatus");
    }

    public static final Map<String, String> e(HttpResponse httpResponse) {
        Map<String, String> f8;
        Intrinsics.f(httpResponse, "<this>");
        List<String> f9 = HttpMessagePropertiesKt.f(httpResponse);
        if (f9 == null) {
            f8 = MapsKt__MapsKt.f();
            return f8;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Headers headers = httpResponse.Y().e().getHeaders();
        for (String str : f9) {
            String str2 = headers.get(str);
            if (str2 == null) {
                str2 = "";
            }
            linkedHashMap.put(str, str2);
        }
        return linkedHashMap;
    }
}
