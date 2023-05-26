package io.ktor.serialization;

import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: ContentConverter.kt */
/* loaded from: classes5.dex */
public final class ContentConverterKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(java.util.List<? extends io.ktor.serialization.ContentConverter> r5, final io.ktor.utils.io.ByteReadChannel r6, final io.ktor.util.reflect.TypeInfo r7, final java.nio.charset.Charset r8, kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.serialization.ContentConverterKt$deserialize$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.serialization.ContentConverterKt$deserialize$1 r0 = (io.ktor.serialization.ContentConverterKt$deserialize$1) r0
            int r1 = r0.f46966i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46966i = r1
            goto L18
        L13:
            io.ktor.serialization.ContentConverterKt$deserialize$1 r0 = new io.ktor.serialization.ContentConverterKt$deserialize$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f46965h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46966i
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r5 = r0.f46964g
            r7 = r5
            io.ktor.util.reflect.TypeInfo r7 = (io.ktor.util.reflect.TypeInfo) r7
            java.lang.Object r5 = r0.f46963f
            r6 = r5
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.ResultKt.b(r9)
            goto L5a
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.flow.Flow r5 = kotlinx.coroutines.flow.FlowKt.a(r5)
            io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1 r9 = new io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1
            r9.<init>()
            io.ktor.serialization.ContentConverterKt$deserialize$result$2 r5 = new io.ktor.serialization.ContentConverterKt$deserialize$result$2
            r5.<init>(r6, r3)
            r0.f46963f = r6
            r0.f46964g = r7
            r0.f46966i = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.q(r9, r5, r0)
            if (r9 != r1) goto L5a
            return r1
        L5a:
            if (r9 != 0) goto L8f
            boolean r5 = r6.o()
            if (r5 != 0) goto L63
            goto L90
        L63:
            kotlin.reflect.KType r5 = r7.a()
            r6 = 0
            if (r5 == 0) goto L71
            boolean r5 = r5.a()
            if (r5 != r4) goto L71
            goto L72
        L71:
            r4 = 0
        L72:
            if (r4 == 0) goto L77
            io.ktor.http.content.NullBody r6 = io.ktor.http.content.NullBody.f46943a
            goto L90
        L77:
            io.ktor.serialization.ContentConvertException r5 = new io.ktor.serialization.ContentConvertException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "No suitable converter found for "
            r6.append(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 2
            r5.<init>(r6, r3, r7, r3)
            throw r5
        L8f:
            r6 = r9
        L90:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.ContentConverterKt.a(java.util.List, io.ktor.utils.io.ByteReadChannel, io.ktor.util.reflect.TypeInfo, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Charset b(Headers headers, Charset defaultCharset) {
        Intrinsics.f(headers, "<this>");
        Intrinsics.f(defaultCharset, "defaultCharset");
        Charset d8 = d(headers, defaultCharset);
        if (d8 != null) {
            return d8;
        }
        return defaultCharset;
    }

    public static /* synthetic */ Charset c(Headers headers, Charset charset, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charset = Charsets.f51135b;
        }
        return b(headers, charset);
    }

    public static final Charset d(Headers headers, Charset defaultCharset) {
        Intrinsics.f(headers, "<this>");
        Intrinsics.f(defaultCharset, "defaultCharset");
        for (HeaderValue headerValue : HttpHeaderValueParserKt.b(headers.get(HttpHeaders.f46782a.d()))) {
            String a8 = headerValue.a();
            if (Intrinsics.a(a8, "*")) {
                return defaultCharset;
            }
            if (Charset.isSupported(a8)) {
                return Charset.forName(a8);
            }
        }
        return null;
    }
}
