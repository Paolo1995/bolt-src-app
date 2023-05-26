package io.ktor.client.statement;

import io.ktor.client.request.HttpRequest;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* compiled from: HttpResponse.kt */
/* loaded from: classes5.dex */
public final class HttpResponseKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(io.ktor.client.statement.HttpResponse r5, java.nio.charset.Charset r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.client.statement.HttpResponseKt$bodyAsText$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = (io.ktor.client.statement.HttpResponseKt$bodyAsText$1) r0
            int r1 = r0.f46666h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46666h = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = new io.ktor.client.statement.HttpResponseKt$bodyAsText$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f46665g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46666h
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f46664f
            java.nio.charset.CharsetDecoder r5 = (java.nio.charset.CharsetDecoder) r5
            kotlin.ResultKt.b(r7)
            goto L68
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r7)
            java.nio.charset.Charset r7 = io.ktor.http.HttpMessagePropertiesKt.b(r5)
            if (r7 != 0) goto L3f
            goto L40
        L3f:
            r6 = r7
        L40:
            java.nio.charset.CharsetDecoder r6 = r6.newDecoder()
            io.ktor.client.call.HttpClientCall r5 = r5.Y()
            java.lang.Class<io.ktor.utils.io.core.Input> r7 = io.ktor.utils.io.core.Input.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.i(r7)
            java.lang.reflect.Type r2 = kotlin.reflect.TypesJVMKt.f(r7)
            java.lang.Class<io.ktor.utils.io.core.Input> r4 = io.ktor.utils.io.core.Input.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.b(r4)
            io.ktor.util.reflect.TypeInfo r7 = io.ktor.util.reflect.TypeInfoJvmKt.b(r2, r4, r7)
            r0.f46664f = r6
            r0.f46666h = r3
            java.lang.Object r7 = r5.a(r7, r0)
            if (r7 != r1) goto L67
            return r1
        L67:
            r5 = r6
        L68:
            if (r7 == 0) goto L79
            io.ktor.utils.io.core.Input r7 = (io.ktor.utils.io.core.Input) r7
            java.lang.String r6 = "decoder"
            kotlin.jvm.internal.Intrinsics.e(r5, r6)
            r6 = 0
            r0 = 2
            r1 = 0
            java.lang.String r5 = io.ktor.utils.io.charsets.EncodingKt.b(r5, r7, r6, r0, r1)
            return r5
        L79:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type io.ktor.utils.io.core.Input"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpResponseKt.a(io.ktor.client.statement.HttpResponse, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object b(HttpResponse httpResponse, Charset charset, Continuation continuation, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charset = Charsets.f51135b;
        }
        return a(httpResponse, charset, continuation);
    }

    public static final void c(HttpResponse httpResponse) {
        Intrinsics.f(httpResponse, "<this>");
        CoroutineContext.Element g8 = httpResponse.j().g(Job.f51296d);
        Intrinsics.c(g8);
        ((CompletableJob) g8).k();
    }

    public static final HttpRequest d(HttpResponse httpResponse) {
        Intrinsics.f(httpResponse, "<this>");
        return httpResponse.Y().e();
    }
}
