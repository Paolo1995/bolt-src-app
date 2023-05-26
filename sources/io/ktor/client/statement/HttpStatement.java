package io.ktor.client.statement;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpStatement.kt */
/* loaded from: classes5.dex */
public final class HttpStatement {

    /* renamed from: a  reason: collision with root package name */
    private final HttpRequestBuilder f46674a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpClient f46675b;

    public HttpStatement(HttpRequestBuilder builder, HttpClient client) {
        Intrinsics.f(builder, "builder");
        Intrinsics.f(client, "client");
        this.f46674a = builder;
        this.f46675b = client;
        a();
    }

    private final void a() {
        Set keySet;
        Map map = (Map) this.f46674a.b().f(HttpClientEngineCapabilityKt.a());
        if (map != null && (keySet = map.keySet()) != null) {
            ArrayList<HttpClientPlugin> arrayList = new ArrayList();
            for (Object obj : keySet) {
                if (obj instanceof HttpClientPlugin) {
                    arrayList.add(obj);
                }
            }
            for (HttpClientPlugin httpClientPlugin : arrayList) {
                if (HttpClientPluginKt.c(this.f46675b, httpClientPlugin) == null) {
                    throw new IllegalArgumentException(("Consider installing " + httpClientPlugin + " plugin because the request requires it to be installed").toString());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(io.ktor.client.statement.HttpResponse r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpStatement$cleanup$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = (io.ktor.client.statement.HttpStatement$cleanup$1) r0
            int r1 = r0.f46679i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46679i = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = new io.ktor.client.statement.HttpStatement$cleanup$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f46677g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46679i
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f46676f
            kotlinx.coroutines.CompletableJob r5 = (kotlinx.coroutines.CompletableJob) r5
            kotlin.ResultKt.b(r6)
            goto L5e
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            kotlin.coroutines.CoroutineContext r6 = r5.j()
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.f51296d
            kotlin.coroutines.CoroutineContext$Element r6 = r6.g(r2)
            kotlin.jvm.internal.Intrinsics.c(r6)
            kotlinx.coroutines.CompletableJob r6 = (kotlinx.coroutines.CompletableJob) r6
            r6.k()
            io.ktor.utils.io.ByteReadChannel r5 = r5.a()     // Catch: java.lang.Throwable -> L52
            io.ktor.utils.io.ByteReadChannelKt.a(r5)     // Catch: java.lang.Throwable -> L52
            goto L53
        L52:
        L53:
            r0.f46676f = r6
            r0.f46679i = r3
            java.lang.Object r5 = r6.v0(r0)
            if (r5 != r1) goto L5e
            return r1
        L5e:
            kotlin.Unit r5 = kotlin.Unit.f50853a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.b(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object c(Continuation<? super HttpResponse> continuation) {
        return d(new HttpStatement$execute$4(null), continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|7|(1:(1:(1:(1:(2:13|14)(3:16|17|18))(3:19|20|21))(5:22|23|24|25|(1:27)(2:28|29)))(2:36|37))(3:46|47|(1:49)(1:50))|38|39|40|(1:42)(3:43|25|(0)(0))))|54|6|7|(0)(0)|38|39|40|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0095, code lost:
        r10 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a2 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> java.lang.Object d(kotlin.jvm.functions.Function2<? super io.ktor.client.statement.HttpResponse, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super T> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.client.statement.HttpStatement$execute$1
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.client.statement.HttpStatement$execute$1 r0 = (io.ktor.client.statement.HttpStatement$execute$1) r0
            int r1 = r0.f46684j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46684j = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$execute$1 r0 = new io.ktor.client.statement.HttpStatement$execute$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.f46682h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46684j
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L63
            if (r2 == r7) goto L57
            if (r2 == r6) goto L46
            if (r2 == r5) goto L40
            if (r2 == r4) goto L37
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            java.lang.Object r10 = r0.f46680f
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.b(r11)     // Catch: java.util.concurrent.CancellationException -> La4
            goto La3
        L40:
            java.lang.Object r10 = r0.f46680f
            kotlin.ResultKt.b(r11)     // Catch: java.util.concurrent.CancellationException -> La4
            goto L94
        L46:
            java.lang.Object r10 = r0.f46681g
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
            java.lang.Object r2 = r0.f46680f
            io.ktor.client.statement.HttpStatement r2 = (io.ktor.client.statement.HttpStatement) r2
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L52
            goto L86
        L52:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L96
        L57:
            java.lang.Object r10 = r0.f46681g
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r2 = r0.f46680f
            io.ktor.client.statement.HttpStatement r2 = (io.ktor.client.statement.HttpStatement) r2
            kotlin.ResultKt.b(r11)     // Catch: java.util.concurrent.CancellationException -> La4
            goto L74
        L63:
            kotlin.ResultKt.b(r11)
            r0.f46680f = r9     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f46681g = r10     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f46684j = r7     // Catch: java.util.concurrent.CancellationException -> La4
            java.lang.Object r11 = r9.e(r0)     // Catch: java.util.concurrent.CancellationException -> La4
            if (r11 != r1) goto L73
            return r1
        L73:
            r2 = r9
        L74:
            io.ktor.client.statement.HttpResponse r11 = (io.ktor.client.statement.HttpResponse) r11     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f46680f = r2     // Catch: java.lang.Throwable -> L95
            r0.f46681g = r11     // Catch: java.lang.Throwable -> L95
            r0.f46684j = r6     // Catch: java.lang.Throwable -> L95
            java.lang.Object r10 = r10.s(r11, r0)     // Catch: java.lang.Throwable -> L95
            if (r10 != r1) goto L83
            return r1
        L83:
            r8 = r11
            r11 = r10
            r10 = r8
        L86:
            r0.f46680f = r11     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f46681g = r3     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f46684j = r5     // Catch: java.util.concurrent.CancellationException -> La4
            java.lang.Object r10 = r2.b(r10, r0)     // Catch: java.util.concurrent.CancellationException -> La4
            if (r10 != r1) goto L93
            return r1
        L93:
            r10 = r11
        L94:
            return r10
        L95:
            r10 = move-exception
        L96:
            r0.f46680f = r10     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f46681g = r3     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f46684j = r4     // Catch: java.util.concurrent.CancellationException -> La4
            java.lang.Object r11 = r2.b(r11, r0)     // Catch: java.util.concurrent.CancellationException -> La4
            if (r11 != r1) goto La3
            return r1
        La3:
            throw r10     // Catch: java.util.concurrent.CancellationException -> La4
        La4:
            r10 = move-exception
            java.lang.Throwable r10 = io.ktor.client.utils.ExceptionUtilsJvmKt.a(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.d(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.client.statement.HttpStatement$executeUnsafe$1
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = (io.ktor.client.statement.HttpStatement$executeUnsafe$1) r0
            int r1 = r0.f46689h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46689h = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = new io.ktor.client.statement.HttpStatement$executeUnsafe$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f46687f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46689h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)     // Catch: java.util.concurrent.CancellationException -> L51
            goto L4a
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            io.ktor.client.request.HttpRequestBuilder r5 = new io.ktor.client.request.HttpRequestBuilder     // Catch: java.util.concurrent.CancellationException -> L51
            r5.<init>()     // Catch: java.util.concurrent.CancellationException -> L51
            io.ktor.client.request.HttpRequestBuilder r2 = r4.f46674a     // Catch: java.util.concurrent.CancellationException -> L51
            io.ktor.client.request.HttpRequestBuilder r5 = r5.o(r2)     // Catch: java.util.concurrent.CancellationException -> L51
            io.ktor.client.HttpClient r2 = r4.f46675b     // Catch: java.util.concurrent.CancellationException -> L51
            r0.f46689h = r3     // Catch: java.util.concurrent.CancellationException -> L51
            java.lang.Object r5 = r2.a(r5, r0)     // Catch: java.util.concurrent.CancellationException -> L51
            if (r5 != r1) goto L4a
            return r1
        L4a:
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5     // Catch: java.util.concurrent.CancellationException -> L51
            io.ktor.client.statement.HttpResponse r5 = r5.f()     // Catch: java.util.concurrent.CancellationException -> L51
            return r5
        L51:
            r5 = move-exception
            java.lang.Throwable r5 = io.ktor.client.utils.ExceptionUtilsJvmKt.a(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public String toString() {
        return "HttpStatement[" + this.f46674a.h().c() + ']';
    }
}
