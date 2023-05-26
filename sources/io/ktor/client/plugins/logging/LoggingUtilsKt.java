package io.ktor.client.plugins.logging;

import io.ktor.client.statement.HttpResponse;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggingUtils.kt */
/* loaded from: classes5.dex */
public final class LoggingUtilsKt {
    public static final void a(Appendable appendable, String key, String value) {
        Intrinsics.f(appendable, "<this>");
        Intrinsics.f(key, "key");
        Intrinsics.f(value, "value");
        Appendable append = appendable.append("-> " + key + ": " + value);
        Intrinsics.e(append, "append(value)");
        Intrinsics.e(append.append('\n'), "append('\\n')");
    }

    public static final void b(Appendable appendable, Set<? extends Map.Entry<String, ? extends List<String>>> headers) {
        List H0;
        List<Map.Entry> v02;
        String f02;
        Intrinsics.f(appendable, "<this>");
        Intrinsics.f(headers, "headers");
        H0 = CollectionsKt___CollectionsKt.H0(headers);
        v02 = CollectionsKt___CollectionsKt.v0(H0, new Comparator() { // from class: io.ktor.client.plugins.logging.LoggingUtilsKt$logHeaders$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a8;
                a8 = ComparisonsKt__ComparisonsKt.a((String) ((Map.Entry) t7).getKey(), (String) ((Map.Entry) t8).getKey());
                return a8;
            }
        });
        for (Map.Entry entry : v02) {
            f02 = CollectionsKt___CollectionsKt.f0((List) entry.getValue(), "; ", null, null, 0, null, null, 62, null);
            a(appendable, (String) entry.getKey(), f02);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(java.lang.StringBuilder r16, io.ktor.http.ContentType r17, io.ktor.utils.io.ByteReadChannel r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r17
            r2 = r19
            boolean r3 = r2 instanceof io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1
            if (r3 == 0) goto L19
            r3 = r2
            io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1 r3 = (io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1) r3
            int r4 = r3.f46572i
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.f46572i = r4
            goto L1e
        L19:
            io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1 r3 = new io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1
            r3.<init>(r2)
        L1e:
            r7 = r3
            java.lang.Object r2 = r7.f46571h
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r4 = r7.f46572i
            r10 = 0
            r5 = 1
            java.lang.String r11 = "append('\\n')"
            r12 = 10
            java.lang.String r13 = "append(value)"
            if (r4 == 0) goto L4d
            if (r4 != r5) goto L45
            java.lang.Object r0 = r7.f46570g
            java.nio.charset.Charset r0 = (java.nio.charset.Charset) r0
            java.lang.Object r1 = r7.f46569f
            java.lang.StringBuilder r1 = (java.lang.StringBuilder) r1
            kotlin.ResultKt.b(r2)     // Catch: java.lang.Throwable -> L42
            r15 = r1
            r1 = r0
            r0 = r15
            goto L9b
        L42:
            r0 = r1
            goto La5
        L45:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L4d:
            kotlin.ResultKt.b(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "BODY Content-Type: "
            r2.append(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            kotlin.jvm.internal.Intrinsics.e(r0, r13)
            r0.append(r12)
            kotlin.jvm.internal.Intrinsics.e(r0, r11)
            java.lang.String r2 = "BODY START"
            r0.append(r2)
            kotlin.jvm.internal.Intrinsics.e(r0, r13)
            r0.append(r12)
            kotlin.jvm.internal.Intrinsics.e(r0, r11)
            if (r1 == 0) goto L83
            java.nio.charset.Charset r1 = io.ktor.http.ContentTypesKt.a(r17)
            if (r1 != 0) goto L85
        L83:
            java.nio.charset.Charset r1 = kotlin.text.Charsets.f51135b
        L85:
            r8 = 0
            r2 = 1
            r14 = 0
            r7.f46569f = r0     // Catch: java.lang.Throwable -> La4
            r7.f46570g = r1     // Catch: java.lang.Throwable -> La4
            r7.f46572i = r5     // Catch: java.lang.Throwable -> La4
            r4 = r18
            r5 = r8
            r8 = r2
            r9 = r14
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.a(r4, r5, r7, r8, r9)     // Catch: java.lang.Throwable -> La4
            if (r2 != r3) goto L9b
            return r3
        L9b:
            io.ktor.utils.io.core.Input r2 = (io.ktor.utils.io.core.Input) r2     // Catch: java.lang.Throwable -> La4
            r3 = 0
            r4 = 2
            java.lang.String r10 = io.ktor.utils.io.core.StringsKt.e(r2, r1, r3, r4, r10)     // Catch: java.lang.Throwable -> La4
            goto La5
        La4:
        La5:
            if (r10 != 0) goto La9
            java.lang.String r10 = "[response body omitted]"
        La9:
            r0.append(r10)
            kotlin.jvm.internal.Intrinsics.e(r0, r13)
            r0.append(r12)
            kotlin.jvm.internal.Intrinsics.e(r0, r11)
            java.lang.String r1 = "BODY END"
            r0.append(r1)
            kotlin.Unit r0 = kotlin.Unit.f50853a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.LoggingUtilsKt.c(java.lang.StringBuilder, io.ktor.http.ContentType, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void d(StringBuilder log, HttpResponse response, LogLevel level) {
        Intrinsics.f(log, "log");
        Intrinsics.f(response, "response");
        Intrinsics.f(level, "level");
        if (level.f()) {
            log.append("RESPONSE: " + response.e());
            Intrinsics.e(log, "append(value)");
            log.append('\n');
            Intrinsics.e(log, "append('\\n')");
            log.append("METHOD: " + response.Y().e().getMethod());
            Intrinsics.e(log, "append(value)");
            log.append('\n');
            Intrinsics.e(log, "append('\\n')");
            log.append("FROM: " + response.Y().e().getUrl());
            Intrinsics.e(log, "append(value)");
            log.append('\n');
            Intrinsics.e(log, "append('\\n')");
        }
        if (level.e()) {
            log.append("COMMON HEADERS");
            Intrinsics.e(log, "append(value)");
            log.append('\n');
            Intrinsics.e(log, "append('\\n')");
            b(log, response.getHeaders().a());
        }
    }
}
