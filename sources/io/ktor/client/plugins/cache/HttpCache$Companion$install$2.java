package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCache.kt */
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$2", f = "HttpCache.kt", l = {118, 119, 129}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpCache$Companion$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46429g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46430h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46431i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpCache f46432j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ HttpClient f46433k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$Companion$install$2(HttpCache httpCache, HttpClient httpClient, Continuation<? super HttpCache$Companion$install$2> continuation) {
        super(3, continuation);
        this.f46432j = httpCache;
        this.f46433k = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        HttpCache$Companion$install$2 httpCache$Companion$install$2 = new HttpCache$Companion$install$2(this.f46432j, this.f46433k, continuation);
        httpCache$Companion$install$2.f46430h = pipelineContext;
        httpCache$Companion$install$2.f46431i = httpResponse;
        return httpCache$Companion$install$2.invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0075 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r1 = r8.f46429g
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2b
            if (r1 == r5) goto L23
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            kotlin.ResultKt.b(r9)
            goto Lc8
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            kotlin.ResultKt.b(r9)
            goto L76
        L23:
            java.lang.Object r1 = r8.f46430h
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.b(r9)
            goto L69
        L2b:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f46430h
            r1 = r9
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            java.lang.Object r9 = r8.f46431i
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r6 = r9.Y()
            io.ktor.client.request.HttpRequest r6 = r6.e()
            io.ktor.http.HttpMethod r6 = r6.getMethod()
            io.ktor.http.HttpMethod$Companion r7 = io.ktor.http.HttpMethod.f46834b
            io.ktor.http.HttpMethod r7 = r7.a()
            boolean r6 = kotlin.jvm.internal.Intrinsics.a(r6, r7)
            if (r6 != 0) goto L52
            kotlin.Unit r9 = kotlin.Unit.f50853a
            return r9
        L52:
            io.ktor.http.HttpStatusCode r6 = r9.e()
            boolean r6 = io.ktor.http.HttpStatusCodeKt.b(r6)
            if (r6 == 0) goto L79
            io.ktor.client.plugins.cache.HttpCache r3 = r8.f46432j
            r8.f46430h = r1
            r8.f46429g = r5
            java.lang.Object r9 = io.ktor.client.plugins.cache.HttpCache.a(r3, r9, r8)
            if (r9 != r0) goto L69
            return r0
        L69:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            r8.f46430h = r2
            r8.f46429g = r4
            java.lang.Object r9 = r1.g(r9, r8)
            if (r9 != r0) goto L76
            return r0
        L76:
            kotlin.Unit r9 = kotlin.Unit.f50853a
            return r9
        L79:
            io.ktor.http.HttpStatusCode r4 = r9.e()
            io.ktor.http.HttpStatusCode$Companion r5 = io.ktor.http.HttpStatusCode.f46855c
            io.ktor.http.HttpStatusCode r5 = r5.z()
            boolean r4 = kotlin.jvm.internal.Intrinsics.a(r4, r5)
            if (r4 == 0) goto Lc8
            io.ktor.client.statement.HttpResponseKt.c(r9)
            io.ktor.client.plugins.cache.HttpCache r4 = r8.f46432j
            io.ktor.client.call.HttpClientCall r5 = r9.Y()
            io.ktor.client.request.HttpRequest r5 = r5.e()
            io.ktor.client.statement.HttpResponse r4 = io.ktor.client.plugins.cache.HttpCache.b(r4, r5, r9)
            if (r4 == 0) goto Lb6
            io.ktor.client.HttpClient r9 = r8.f46433k
            io.ktor.events.Events r9 = r9.g()
            io.ktor.client.plugins.cache.HttpCache$Companion r5 = io.ktor.client.plugins.cache.HttpCache.f46419c
            io.ktor.events.EventDefinition r5 = r5.f()
            r9.a(r5, r4)
            r8.f46430h = r2
            r8.f46429g = r3
            java.lang.Object r9 = r1.g(r4, r8)
            if (r9 != r0) goto Lc8
            return r0
        Lb6:
            io.ktor.client.plugins.cache.InvalidCacheStateException r0 = new io.ktor.client.plugins.cache.InvalidCacheStateException
            io.ktor.client.call.HttpClientCall r9 = r9.Y()
            io.ktor.client.request.HttpRequest r9 = r9.e()
            io.ktor.http.Url r9 = r9.getUrl()
            r0.<init>(r9)
            throw r0
        Lc8:
            kotlin.Unit r9 = kotlin.Unit.f50853a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache$Companion$install$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
